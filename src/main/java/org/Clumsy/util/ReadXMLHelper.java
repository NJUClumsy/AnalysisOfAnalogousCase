package org.Clumsy.util;

import org.Clumsy.entity.*;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Lucifer on 17/7/24.
 */
public class ReadXMLHelper {

    private static Case littleCase = new Case();
    private static String name="";
    private static String qklb="";
    private static String flftmc="";
    private static String spryxm="";

    private static String[] list = {
            "WS","DSR","SSJL","AJJBQK","CPFXGC","PJJG","WW","FJ","WSMC","AH","AJLB","WSZL","SPCX",
            "BGRQX","KTSL","SSXZ","JCYJYYQSL","SNFT","ESAJLY","SSHKSFW","YGSJG","SPZZ","ZZQK","TCGXQYY",
            "KTQSQCHSS","ESFH","ESJAFS","GPYY","CPSJ"
    };

    private static ArrayList<String> newList = new ArrayList<>();
    private static ArrayList<ArrayList<Accusation>> zkzm ;
    private static Map<String,String> allKeyMap = new HashMap<>();
    private static ArrayList<Prosecution> prosecutions;
    private static ArrayList<RespondingParty> respondingParties;
    private static ArrayList<Agent> agents;
    private static ArrayList<Accusation> accusations;
    private static ArrayList<ChargeInfo> chargeInfos;
    private static ArrayList<String> lawName = new ArrayList<>();
    private static ArrayList<String> reason;

    private ReadXMLHelper(){

    }

    /**
     * 根据doucument获取Case
     * @param document
     * @return Case
     */
    public static Case getCase(Document document){
        initialize();
        Element root=document.getRootElement();
        getNodes(root);
        return getEditedCase();
    }

    /**
     *初始化需要搜索的XML的键值名称
     */
    public static void initialize(){
        for(int i=0;i<list.length;i++){
            newList.add(list[i]);
        }
    }

    /**
     *根据路径初始化键值对
     * @param url
     */
    public static void initializeAllKeyMap(String url) throws Exception {
        initialize();
        SAXReader sax=new SAXReader();
        File xmlFile=new File(url);
        Document document;
        document = sax.read(xmlFile);
        Element root=document.getRootElement();
        getNodes(root);
    }

    /**
     * 获取节点内部属性
     * @param node
     * @return
     */
    public static ArrayList<String> get(Element node){
        ArrayList<String> ins = new ArrayList<>();

        List<Attribute> listAttr=node.attributes();
        for(Attribute attr:listAttr){
            String value=attr.getValue();
            ins.add(value);
        }
        return ins;
    }

    /**
     * 消除冗余
     * @param node
     */
    public static Map<String,String> dealWithNode(Element node){
        Map<String,String> map = new HashMap<>();
        //System.out.println("++++++++++++++++++++");
        ArrayList<String> instant = new ArrayList<>();

        //System.out.println("当前节点名称："+node.getName());
        List<Attribute> listAttr=node.attributes();
        for(Attribute attr:listAttr){
            String value=attr.getValue();
            //System.out.println("属性值："+value);
            instant.add(value);
        }

        List<Element> listElement=node.elements();
        for(Element e:listElement){
            ArrayList<String> ins = get(e);
            //System.out.println(ins);
            if(ins.get(0).equals("诉讼参与人")){
                name = ins.get(1);
            }else if(ins.get(0).equals("前科类别")){
                qklb = ins.get(1);
            }
            if(ins.size() == 2){
                map.put(ins.get(0),ins.get(1));
            }
        }
        //System.out.println("++++++++++++++++++++");
        return map;
    }
    /**
     * 处理公诉方
     * @param node
     */
    public static void dealWithGSF(Element node){
        Map<String,String> map = dealWithNode(node);
        //修改公诉方
        PublicProsecution publicProsecution = new PublicProsecution();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "诉讼参与人":
                    publicProsecution.setParticipant(entry.getValue());
                    break;
                case "诉讼身份":
                    publicProsecution.setIdentity(entry.getValue());
                    break;
                case "当事人类别":
                    publicProsecution.setParticipantType(entry.getValue());
                    break;
                case "本审诉讼地位":
                    publicProsecution.setStatusOfThisTrial(entry.getValue());
                    break;
                case "原审诉讼地位":
                    publicProsecution.setStatusOfLastTrial(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        littleCase.setPublicProsecution(publicProsecution);
    }

    /**
     * 处理起诉方
     * @param node
     */
    public static void dealWithQSF(Element node){
        Map<String,String> map = dealWithNode(node);
        //生成一个起诉方加入list
        if(prosecutions == null){
            prosecutions = new ArrayList<>();
        }
        Prosecution prosecution = new Prosecution();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "诉讼参与人":
                    prosecution.setParticipant(entry.getValue());
                    break;
                case "诉讼身份":
                    prosecution.setIdentity(entry.getValue());
                    break;
                case "当事人类型":
                    prosecution.setType(entry.getValue());
                    break;
                case "国籍":
                    prosecution.setNation(entry.getValue());
                    break;
                case "当事人类别":
                    prosecution.setParticipantType(entry.getValue());
                    break;
                case "假释考验期内犯罪":
                    if(entry.getValue().startsWith("否")){
                        prosecution.setParoleCrime(false);
                    }else{
                        prosecution.setParoleCrime(true);
                    }
                    break;
                case "缓刑考验期内犯罪":
                    if(entry.getValue().startsWith("否")){
                        prosecution.setProbationCrime(false);
                    }else{
                        prosecution.setProbationCrime(true);
                    }
                    break;
                case "刑事责任能力":
                    prosecution.setCriminalResponsibility(entry.getValue());
                    break;
                case "本审诉讼地位":
                    prosecution.setStatusOfThisTrial(entry.getValue());
                    break;
                case "原审诉讼地位":
                    prosecution.setStatusOfLastTrial(entry.getValue());
                    break;
                case "上诉人与被告人关系":
                    prosecution.setRelation(entry.getValue());
                    break;
                case "是否被害人":
                    if(entry.getValue().startsWith("否")){
                        prosecution.setVictim(false);
                    }else{
                        prosecution.setVictim(true);
                    }
                    break;
                case "自然人身份":
                    prosecution.setPersonalIdentity(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        prosecutions.add(prosecution);
        littleCase.setProsecutions(prosecutions);
    }

    /**
     * 处理代理人
     * @param node
     */
    public static void dealWithDLR(Element node){
        Map<String,String> map = dealWithNode(node);
        //生成一个代理人加入list
        if(agents == null){
            agents = new ArrayList<>();
        }
        Agent agent = new Agent();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "诉讼参与人":
                    agent.setParticipant(entry.getValue());
                    break;
                case "诉讼身份":
                    agent.setIdentity(entry.getValue());
                    break;
                case "当事人类型":
                    agent.setAgentType(entry.getValue());
                    break;
                case "单位职务":
                    agent.setCompanyDuty(entry.getValue());
                    break;
                case "单位名称":
                    agent.setCompanyName(entry.getValue());
                    break;
                case "单位性质":
                    agent.setCompanyNature(entry.getValue());
                    break;
                case "国籍":
                    agent.setNation(entry.getValue());
                    break;
                case "当事人类别":
                    agent.setParticipantType(entry.getValue());
                    break;
                case "参与人诉讼地位":
                    agent.setStatus(entry.getValue());
                    break;
                case "辩护种类":
                    agent.setDefenseType(entry.getValue());
                    break;
                case "辩护对象":
                    agent.setDefenseTarget(entry.getValue());
                    break;
                case "代理人辩护人职业类型":
                    agent.setOccupationType(entry.getValue());
                    break;
                case "辩护人或诉讼代理人类型":
                    agent.setAgentType(entry.getValue());
                    break;
                case "自然人身份":
                    agent.setPersonalIdentity(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        agents.add(agent);
        littleCase.setAgents(agents);
    }

    /**
     * 应诉方
     * @param node
     */
    public static void dealWithYSF(Element node){
        Map<String,String> map = dealWithNode(node);
//        //生成一个应诉方加入list
        if(respondingParties == null){
            respondingParties = new ArrayList<>();
        }
        RespondingParty respondingParty = new RespondingParty();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "诉讼参与人":
                    respondingParty.setParticipant(entry.getValue());
                    break;
                case "诉讼身份":
                    respondingParty.setIdentity(entry.getValue());
                    break;
                case "当事人类型":
                    respondingParty.setType(entry.getValue());
                    break;
                case "国籍":
                    respondingParty.setNation(entry.getValue());
                    break;
                case "当事人类别":
                    respondingParty.setParticipantType(entry.getValue());
                    break;
                case "假释考验期内犯罪":
                    if(entry.getValue().startsWith("否")){
                        respondingParty.setParoleCrime(false);
                    }else{
                        respondingParty.setParoleCrime(true);
                    }
                    break;
                case "缓刑考验期内犯罪":
                    if(entry.getValue().startsWith("否")){
                        respondingParty.setProbationCrime(false);
                    }else{
                        respondingParty.setProbationCrime(true);
                    }
                    break;
                case "刑事责任能力":
                    respondingParty.setCriminalResponsibility(entry.getValue());
                    break;
                case "本审诉讼地位":
                    respondingParty.setStatusOfThisTrial(entry.getValue());
                    break;
                case "原审诉讼地位":
                    respondingParty.setStatusOfLastTrial(entry.getValue());
                    break;
                case "是否被害人":
                    if(entry.getValue().startsWith("否")){
                        respondingParty.setVictim(false);
                    }else{
                        respondingParty.setVictim(true);
                    }
                    break;
                case "自然人身份":
                    respondingParty.setPersonalIdentity(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        respondingParties.add(respondingParty);
        littleCase.setRespondingParties(respondingParties);
    }

    /**
     * 处理主案由
     * @param node
     */
    public static void dealWithMainCause(Element node){
        Map<String,String> map = dealWithNode(node);
        //修改主案由
        Accusation accusation = new Accusation();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "完整罪名":
                    accusation.setAccusationName(entry.getValue());
                    break;
                case "罪名代码":
                    accusation.setAccusationCode(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        littleCase.setMajorCause(accusation);
    }

    /**
     * 处理其他案由
     * @param node
     */
    public static void dealWithOtherCause(Element node){
        Map<String,String> map = dealWithNode(node);
        //添加一个其他案由
        if(accusations == null){
            accusations = new ArrayList<>();
        }
        Accusation accusation = new Accusation();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "罪名代码":
                    accusation.setAccusationCode(entry.getValue());
                    break;
                case "完整罪名":
                    accusation.setAccusationName(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        accusations.add(accusation);
        littleCase.setMinorCause(accusations);
    }

    /**
     * 处理案件审理经过段
     * @param node
     */
    public static void dealWithProcess(Element node){
        Map<String,String> map = dealWithNode(node);
        CaseProcess caseProcess = new CaseProcess();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "前审案号":
                    caseProcess.setFormerCaseNumber(entry.getValue());
                    break;
                case "前审裁判时间":
                    caseProcess.setFormerDate(getDate(entry.getValue()));
                    break;
                case "前审文书种类":
                    caseProcess.setFormerTypeOfWrit(entry.getValue());
                    break;
                case "前审公诉机关":
                    caseProcess.setFormerPublicProsecution(entry.getValue());
                    break;
                case "前审审级":
                    caseProcess.setFormerLevel(entry.getValue());
                    break;
                case "前审案件由来":
                    caseProcess.setOrigin(entry.getValue());
                    break;
                case "前审结案方式":
                    caseProcess.setFormerClosureWay(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        littleCase.setCaseProcess(caseProcess);
    }

    /**
     * 处理指控信息
     * @param node
     */
    public static void dealWithInfo(Element node){
        Map<String,String> map = dealWithNode(node);

        ArrayList<String> relevent = new ArrayList<>();
        ChargeInfo chargeInfo = new ChargeInfo();
        for (Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getKey().equals("相关人")){
                relevent.add(entry.getValue());
            }
        }
        chargeInfo.setRelevantPeople(relevent);

        if(chargeInfos == null){
            chargeInfos = new ArrayList<>();
        }
        chargeInfos.add(chargeInfo);
        littleCase.setChargeInfos(chargeInfos);
    }

    /**
     * 处理前科
     * @param node
     */
    public static void dealWithBefore(Element node){
        System.out.println("name is "+name);
        Map<String,String> map = dealWithNode(node);

        CriminalRecord record = new CriminalRecord();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "前科类别":
                    record.setType(entry.getValue());
                    break;
                case "处罚原因":
                    record.setCause(entry.getValue());
                    break;
                case "处罚时间":
                    record.setTime(getDate(entry.getValue()));
                    break;
                case "处罚单位":
                    record.setPenaltyUnit(entry.getValue());
                    break;
                case "处罚形式":
                    record.setPenaltyForm(entry.getValue());
                    break;
                case "处罚罚期":
                    record.setPenaltyPeriod(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        Collection<Prosecution> pList = littleCase.getProsecutions();
        if(pList != null && pList.size()>=1){
            for(Prosecution p:pList){
                if(name.equals(p.getParticipant())){
                    if(p.getCriminalRecord() == null){
                        Collection<CriminalRecord> criminalRecords = new ArrayList<>();
                        p.setCriminalRecord(criminalRecords);
                    }
                    p.getCriminalRecord().add(record);
                }
            }
        }

        Collection<RespondingParty> rList = littleCase.getRespondingParties();
        if(rList != null && rList.size()>=1){
            for(RespondingParty r:rList){
                if(name.equals(r.getParticipant())){
                    if(r.getCriminalRecord() == null){
                        Collection<CriminalRecord> criminalRecords = new ArrayList<>();
                        r.setCriminalRecord(criminalRecords);
                    }
                    r.getCriminalRecord().add(record);
                }
            }
        }
    }

    /**
     * 处理处罚原因
     * @param node
     */
    public static void dealWithPunish(Element node){
        System.out.println("qklb is "+qklb);
        if(reason == null){
            reason = new ArrayList<>();
        }
        Map<String,String> map = dealWithNode(node);
        for (Map.Entry<String, String> entry : map.entrySet()){
            reason.add(entry.getValue());
        }
    }

    /**
     * 处理前审法院
     * @param node
     */
    public static void dealWithCourt(Element node){
        Map<String,String> map = dealWithNode(node);
        FormerCourt formerCourt = new FormerCourt();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "法院层级码":
                    formerCourt.setCode(entry.getValue());
                    break;
                case "标准法院名称":
                    formerCourt.setName(entry.getValue());
                    break;
                case "法院级别":
                    formerCourt.setLevel(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        littleCase.getCaseProcess().setFormerCourt(formerCourt);
    }

    /**
     * 处理指控罪名
     * @param node
     */
    public static void dealWithRule(Element node){
        Map<String,String> map = dealWithNode(node);

        if(zkzm== null){
            zkzm = new ArrayList<>();
        }

        ArrayList<Accusation> accusations = new ArrayList<>();
        String code="";
        String name="";
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "罪名代码":
                    code = entry.getValue();
                    break;
                case "完整罪名":
                    name = entry.getValue();
                    break;
                default:
                    break;
            }
        }
        Accusation accusation = new Accusation();
        accusation.setAccusationCode(code);
        accusation.setAccusationName(name);
        accusations.add(accusation);
        zkzm.add(accusations);
    }

    /**
     * 处理经办法院
     * @param node
     */
    public static void dealWithThisCourt(Element node){
        Map<String,String> map = dealWithNode(node);

        Court court = new Court();
        for (Map.Entry<String, String> entry : map.entrySet()){
            switch(entry.getKey()){
                case "法院层级码":
                    court.setCode(entry.getValue());
                    break;
                case "标准法院名称":
                    court.setName(entry.getValue());
                    break;
                case "法院级别":
                    court.setLevel(entry.getValue());
                    break;
                case "行政区划(省)":
                    court.setProvince(entry.getValue());
                    break;
                case "行政区划(市)":
                    court.setRegion(entry.getValue());
                    break;
                default:
                    break;
            }
        }
        littleCase.setCourt(court);
    }

    /**
     *递归获得所有需要的键值对
     * @param node
     */
    public static void getNodes(Element node){
        ArrayList<String> instant = new ArrayList<>();

        switch(node.getName()){
            case "JBFY":
                dealWithThisCourt(node);
                break;
            case "GSF":
                dealWithGSF(node);
                break;
            case "QSF":
                dealWithQSF(node);
                break;
            case "DLR":
                dealWithDLR(node);
                break;
            case "YSF":
                dealWithYSF(node);
                break;
            case "QSZAY":
                dealWithMainCause(node);
                break;
            case "QSAY":
                dealWithOtherCause(node);
                break;
            case "AJYLYSLJGD":
                dealWithProcess(node);
                break;
            case "ZKJL":
                dealWithInfo(node);
                break;
            case "QKLJ"://前科劣迹
                dealWithBefore(node);
                break;
            case "QSFY"://前审法院
                dealWithCourt(node);
                break;
            case "CFYYZ"://处罚原因。。。。。。
                dealWithPunish(node);
                break;
            case "ZKZM"://指控罪名
                dealWithRule(node);
                break;
            default:
                break;
        }

        if(node.getName().equals("title")){
            String title = node.attribute(0).getValue();
            allKeyMap.put("文书标题",title);
        }
        if(node.getName().equals("subTitle")){
            String subTitle = node.attribute(0).getValue();
            allKeyMap.put("文书副标题",subTitle);
        }

        List<Attribute> listAttr=node.attributes();
        for(Attribute attr:listAttr){
            String value=attr.getValue();
            instant.add(value);
        }
        if(instant.size()==1){
            instant.add("空");
        }

        if(instant.size()!=0){
            if("审判人员姓名".equals(instant.get(0))){
                spryxm=instant.get(1);
            }else if("审判人员角色".equals(instant.get(0))){
                allKeyMap.put(instant.get(1),spryxm);
            }

            if("名称".equals(instant.get(0))){
                flftmc=instant.get(1);
                allKeyMap.put(instant.get(0),instant.get(1));
                lawName.add(instant.get(1));
            }else if("条".equals(instant.get(0))){
                allKeyMap.put(flftmc,instant.get(1));
            }

            if(instant.size()==2){
                allKeyMap.put(instant.get(0),instant.get(1));
            }
        }

        List<Element> listElement=node.elements();
        for(Element e:listElement){
            getNodes(e);
        }
    }

    /**
     *获得编辑后的Case
     * @return Case
     */
    public static Case getEditedCase(){
        Context context = new Context();
        Collection<MemberOfTrial> memberOfTrialCollection = new ArrayList<>();

        Map<String,ArrayList<String>> law = new HashMap<>();

        for (Map.Entry<String,String> entry : allKeyMap.entrySet()) {
            if("名称".equals(entry.getKey())){
                law.put(entry.getValue(),new ArrayList<>());
            }
        }

        for (Map.Entry<String,String> entry : allKeyMap.entrySet()){
            switch(entry.getKey()){
                case "文首":
                    context.setHead(entry.getValue());
                    break;
                case "当事人":
                    context.setParticipants(entry.getValue());
                    break;
                case "诉讼记录":
                    context.setRecords(entry.getValue());
                    break;
                case "案件基本情况":
                    context.setSituation(entry.getValue());
                    break;
                case "裁判分析过程":
                    context.setAnalysis(entry.getValue());
                    break;
                case "判决结果":
                    context.setResult(entry.getValue());
                    break;
                case "文尾":
                    context.setTail(entry.getValue());
                    break;
                case "附件":
                    context.setAppendix(entry.getValue());
                    break;
                case "文书名称":
                    littleCase.setName(entry.getValue());
                    break;
                case "案号":
                    littleCase.setCaseNumber(entry.getValue());
                    break;
                case "案件类别":
                    littleCase.setTypeOfCase(entry.getValue());
                    break;
                case "文书种类":
                    littleCase.setTypeOfWrit(entry.getValue());
                    break;
                case "审判程序":
                    littleCase.setJudicialProcedure(entry.getValue());
                    break;
                case "被告人缺席":
                    littleCase.setAbsenceOfDefendant(entry.getValue());
                    break;
                case "开庭审理":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setOpenCourt(false);
                    }else{
                        littleCase.setOpenCourt(true);
                    }
                    break;
                case "诉讼性质":
                    littleCase.setNatureOfLawsuit(entry.getValue());
                    break;
                case "检察院建议延期审理":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setPostpone(false);
                    }else{
                        littleCase.setPostpone(true);
                    }
                    break;
                case "少年法庭":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setJuvenileCourt(false);
                    }else{
                        littleCase.setJuvenileCourt(true);
                    }
                    break;
                case "二审案件来源":
                    littleCase.setOrigin(entry.getValue());
                    break;
                case "上诉或抗诉范围":
                    littleCase.setScopeOfAppeal(entry.getValue());
                    break;
                case "原公诉机关":
                    littleCase.setFormerProcedureOrgan(entry.getValue());
                    break;
                case "审判组织":
                    littleCase.setCollegiateBench(entry.getValue());
                    break;
                case "质证情况":
                    littleCase.setCrossExamination(entry.getValue());
                    break;
                case "提出管辖权异议":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setObjectionOfCompetency(false);
                    }else{
                        littleCase.setObjectionOfCompetency(true);
                    }
                    break;
                case "开庭前申请撤回上诉":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setApplyForWithdraw(false);
                    }else{
                        littleCase.setApplyForWithdraw(true);
                    }
                    break;
                case "二审复核":
                    if(entry.getValue().startsWith("否")){
                        littleCase.setRecheck(false);
                    }else{
                        littleCase.setRecheck(true);
                    }
                    break;
                case "二审结案方式":
                    littleCase.setClosureWay(entry.getValue());
                    break;
                case "改判原因":
                    littleCase.setReason(entry.getValue());//结案原因
                    break;
                case "撤诉类型":
                    littleCase.setReason(entry.getValue());//结案原因
                    break;
                case "发回重审原因":
                    littleCase.setReason(entry.getValue());//结案原因
                    break;
                case "裁判时间":
                    littleCase.setDate(getDate(entry.getValue()));
                    break;
                case "文书标题":
                    littleCase.setTitle(entry.getValue());
                    break;
                case "文书副标题":
                    littleCase.setSubTitle(entry.getValue());
                    break;
                default:
                    break;
            }
            if(entry.getKey().equals("审判长") || entry.getKey().equals("审判员") || entry.getKey().equals("代理审判员")
                    || entry.getKey().equals("书记员")){
                MemberOfTrial instant = new MemberOfTrial();
                instant.setRole(entry.getKey());
                instant.setName(entry.getValue());
                memberOfTrialCollection.add(instant);
            }else if(lawName.contains(entry.getKey())){
                if(!law.containsKey(entry.getKey())){
                    law.put(entry.getKey(),new ArrayList<>());
                }
                law.get(entry.getKey()).add(entry.getValue());
            }

        }

        littleCase.setContext(context);
        if(memberOfTrialCollection.size()>=1){
            littleCase.setMemberOfTrials(memberOfTrialCollection);
        }

        if(law.size()>=1){
            Collection<Law> lawCollection = new ArrayList<>();
            for (Map.Entry<String, ArrayList<String>> entry : law.entrySet()){
                Law lawIns = new Law();
                lawIns.setLawName(entry.getKey());
                lawIns.setCite(entry.getValue());
                lawCollection.add(lawIns);
            }
            littleCase.setLaw(lawCollection);
        }

        Collection<Prosecution> prosecutions = littleCase.getProsecutions();
        Collection<RespondingParty> respondingParties = littleCase.getRespondingParties();
        ArrayList<Prosecution> pl = new ArrayList<>();
        ArrayList<RespondingParty> rl = new ArrayList<>();
        int size1=0;
        if(prosecutions!=null && prosecutions.size()>=1){
            size1=prosecutions.size();
            for(Prosecution p:prosecutions){
                pl.add(p);
            }
        }
        if(respondingParties!=null && respondingParties.size()>=1){
            for(RespondingParty r:respondingParties){
                rl.add(r);
            }
        }
        if(reason!=null){
            for(int i=0;i<reason.size();i++){
                System.out.println(reason.get(i));
                if(i<size1){
                    if(pl.get(i).getCriminalRecord() != null){
                        //pl.get(i).getCriminalRecord().setCause(reason.get(i));//minor error
                    }
                } else if(i>=size1){
                //System.out.println(i);
               // System.out.println(size1);
                //rl.get(i-size1).getCriminalRecord().setCause(reason.get(i));
            }//因为只记录了一次前科劣迹??
            }
        }

        if(pl.size()>=1){
            littleCase.setProsecutions(pl);
        }
        if(rl.size()>=1){
            littleCase.setRespondingParties(rl);
        }

        Collection<ChargeInfo> chargeInfos = littleCase.getChargeInfos();
        ArrayList<ChargeInfo> cl = new ArrayList<>();
        for(ChargeInfo c : chargeInfos){
            cl.add(c);
        }
        for(int i=0;i<zkzm.size();i++){
            cl.get(0).setAccusations(zkzm.get(i));//minor error
        }
        littleCase.setChargeInfos(cl);

        return littleCase;
    }

    /**
     * 获得修正的日期
     * @param text
     * @return LocalDate
     */
    public static LocalDate getDate(String text){
        //System.out.println(text);
        if(text.contains("年")&&text.contains("月")&&text.contains("日")){
            int ydex=text.indexOf('年');
            int mdex=text.indexOf('月');
            int ddex=text.indexOf('日');

            String yearStr = getModified(text.substring(0,ydex));
            String monthStr = getModified(text.substring(ydex+1,mdex));
            String dateStr = getModified(text.substring(mdex+1,ddex));

            ydex = Integer.parseInt(yearStr);
            mdex = Integer.parseInt(monthStr);
            ddex  = Integer.parseInt(dateStr);
            return LocalDate.of(ydex,mdex,ddex);
        }else{
            int ydex=text.indexOf('年');
            int mdex=text.indexOf('月');

            String yearStr = getModified(text.substring(0,ydex));
            String monthStr = getModified(text.substring(ydex+1,mdex));

            ydex = Integer.parseInt(yearStr);
            mdex = Integer.parseInt(monthStr);
            return LocalDate.of(ydex,mdex,1);
        }
    }

    /**
     * 修正日期
     * @param original
     * @return String
     */
    public static String getModified(String original){
        String result = original;
        result = result.replaceFirst("null", "1");
        result = result.replace('O', '0');
        result = result.replace('Ｏ', '0');
        return result;
    }


}
