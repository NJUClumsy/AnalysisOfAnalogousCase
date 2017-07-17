package org.Clumsy.util;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import org.apache.log4j.Logger;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.Clumsy.entity.Case;
import org.Clumsy.entity.Context;
import org.Clumsy.entity.Judgement;
import org.Clumsy.entity.Law;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * Created by Lucifer on 17/7/15.
 */
public class ReadXMLHelper {

    private static Logger logger=Logger.getLogger(BytesToFile.class);

    private static String name="";
    private static String flftmc="";
    private static String spryxm="";

    private static String[] list = {"WS","SSCYRQJ","SSJL","AJJBQK","CPFXGC","CPJG","WW","JBFY","WSMC",
            "AH","SPCX","SSCYRMC","GSJG","AY","KTSLXX","YGSCD","ZKDL","BGBCD","BCDL","CMSSD","BSSLD","FLFTMC","TM",
            "JTCPD","SPRYXM","CPSJ","XSPJJGFZ","PJZZM","DZPF","ZXPF","SSSF","FL","SPRYJS"};

    private static ArrayList<String> newList = new ArrayList<>();

    private static Map<String,String> allKeyMap = new HashMap<>();

    private static ArrayList<String> lawName = new ArrayList<>();

    private ReadXMLHelper(){

    }

    /**
     * 根据doucument获取Case
     * @param document
     * @return Case
     */
    public static Case getCase( Document document){
        initialize();
        try{
            Element root=document.getRootElement();
            getNodes(root);
            return ReadXMLHelper.getEditedCase();
        }catch(NullPointerException e){
            logger.info("context"+e);
        }
        return null;
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
    public static void initializeAllKeyMap(String url){
        initialize();
        SAXReader sax=new SAXReader();
        File xmlFile=new File(url);
        Document document= null;
        try {
            document = sax.read(xmlFile);
        } catch (DocumentException e) {
            logger.info("context"+e);
        }
        try{
            Element root=document.getRootElement();
            getNodes(root);
        }catch(NullPointerException e){
            logger.info("context"+e);
        }
    }

    /**
     *递归获得所有需要的键值对
     * @param node
     */
    public static void getNodes(Element node){
        ArrayList<String> instant = new ArrayList<>();
        if(newList.contains(node.getName())){
            List<Attribute> listAttr=node.attributes();
            for(Attribute attr:listAttr){
                String value=attr.getValue();
                instant.add(value);
            }
            if(instant.size()<2){
                instant.add("空");
            }

            if("审判人员姓名".equals(instant.get(1))){
                spryxm=instant.get(0);
            }else if("审判人员角色".equals(instant.get(1))){
                allKeyMap.put(instant.get(0),spryxm);
            }

            if("法律法条名称".equals(instant.get(1))){
                flftmc=instant.get(0);
                allKeyMap.put(instant.get(1),instant.get(0));
                lawName.add(instant.get(0));
            }else if("条目".equals(instant.get(1))){
                allKeyMap.put(flftmc,instant.get(0));
            }

            if("诉讼参与人名称".equals(instant.get(1))){
                name=instant.get(0);
            }else if("诉讼身份".equals(instant.get(1))){
                allKeyMap.put(instant.get(0),name);
            }else{
                allKeyMap.put(instant.get(1),instant.get(0));
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
        Case littleCase = new Case();
        Context context = new Context();

        ArrayList<String> accuser = null;
        ArrayList<String> defendant = null;
        ArrayList<String> judge = null;
        ArrayList<String> judgment1 = null;

        String mainCharge=null;
        String singlePenalty=null;
        String execPenalty=null;

        ArrayList<Law> lawList = null;
        Map<String,ArrayList<String>> law = new HashMap<>();

        String dateToChange=null;

        ArrayList<String> organ = null;


        for (Map.Entry<String,String> entry : allKeyMap.entrySet()) {
            if("法律法条名称".equals(entry.getKey())){
                law.put(entry.getValue(),new ArrayList<>());
            }
        }

        for (Map.Entry<String,String> entry : allKeyMap.entrySet()){
            switch(entry.getKey()){
                case "文首":
                    context.setHead(entry.getValue());
                    break;
                case "诉讼参与人全集":
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
                case "裁判结果":
                    context.setResult(entry.getValue());
                    break;
                case "文尾":
                    context.setTail(entry.getValue());
                    break;
                case "附录":
                    context.setAppendix(entry.getValue());
                    break;
                case "经办法院":
                    littleCase.setCourt(entry.getValue());
                    break;
                case "文书名称":
                    littleCase.setType(entry.getValue());
                    break;
                case "案号":
                    littleCase.setCaseNumber(entry.getValue());
                    break;
                case "审判程序":
                    littleCase.setProcess(entry.getValue());
                    break;
                case "案由":
                    littleCase.setCause(entry.getValue());
                    break;
                case "开庭审理信息":
                    littleCase.setInfo_try(entry.getValue());
                    break;
                case "书记员":
                    littleCase.setCourt_clerk(defineName(entry.getValue()));
                    break;
                case "原告诉称段":
                    littleCase.setAccuser_state(entry.getValue());
                    break;
                case "指控段落":
                    littleCase.setAccuser_state(entry.getValue());
                    break;
                case "被告辩称段":
                    littleCase.setDefendant_state(entry.getValue());
                    break;
                case "辩称段落":
                    littleCase.setDefendant_state(entry.getValue());
                    break;
                case "查明事实段":
                    littleCase.setFact(entry.getValue());
                    break;
                case "本审审理段":
                    littleCase.setFact(entry.getValue());
                    break;
                case "判决主罪名":
                    mainCharge = entry.getValue();
                    break;
                case "单罪判罚":
                    singlePenalty = entry.getValue();
                    break;
                case "执行判罚":
                    execPenalty = entry.getValue();
                    break;
                case "裁判时间":
                    dateToChange = entry.getValue();
                    break;
                default:
                    break;
            }
            if("原告".equals(entry.getKey())||"原告人".equals(entry.getKey())){
                if(accuser==null){
                    accuser = new ArrayList<>();
                }
                accuser.add(defineName(entry.getValue()));
            }else if("被告".equals(entry.getKey())||"被告人".equals(entry.getKey())){
                if(defendant==null){
                    defendant = new ArrayList<>();
                }
                defendant.add(defineName(entry.getValue()));
            }else if("审判员".equals(entry.getKey())||"代理审判员".equals(entry.getKey())||"审判长".equals(entry.getKey())){
                if(judge==null){
                    judge = new ArrayList<>();
                }
                judge.add(defineName(entry.getValue()));
            }else if("具体裁判段".equals(entry.getKey())){
                if(judgment1==null){
                    judgment1 = new ArrayList<>();
                }
                judgment1.add(defineName(entry.getValue()));
            }else if(lawName.contains(entry.getKey())){
                law.get(entry.getKey()).add(entry.getValue());
            }else if("公诉机关".equals(entry.getKey())){
                if(organ==null){
                    organ = new ArrayList<>();
                }
                organ.add(defineName(entry.getValue()));
            }

        }

        littleCase.setContext(context);

        if(mainCharge!=null && singlePenalty!=null && execPenalty!=null){
            Judgement judgement2 = new Judgement();
            judgement2.setMain_charge(mainCharge);
            judgement2.setSingle_penalty(singlePenalty);
            judgement2.setExec_penalty(execPenalty);
            littleCase.setJudgement2(judgement2);
        }

        if(law.size()>0){
            if(lawList==null){
                lawList = new ArrayList<>();
            }
            for(Map.Entry<String,ArrayList<String>> entry : law.entrySet()){
                Law instant = new Law();
                instant.setLawName(entry.getKey());
                instant.setCite(entry.getValue());
                lawList.add(instant);
            }
            littleCase.setLaw(lawList);
        }

        if(dateToChange!=null){
            LocalDate date = getDate(dateToChange);
            littleCase.setDate(date);
        }

        if(accuser!=null){
            littleCase.setAccuser(accuser);
        }
        if(defendant!=null){
            littleCase.setDefendant(defendant);
        }
        if(organ!=null){
            littleCase.setOrgan(organ);
        }
        if(judge!=null){
            littleCase.setJudge(judge);
        }

        if(judgment1!=null){
            littleCase.setJudgment1(judgment1);
        }
        return littleCase;
    }

    /**
     * 获得修正的日期
     * @param text
     * @return LocalDate
     */
    public static LocalDate getDate(String text){
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

    /**
     * 修正人名的字符串
     * @param fakeName
     * @return String
     */
    public static String defineName(String fakeName){
        if(fakeName.startsWith("：")&&fakeName.length()>1){
            return fakeName.substring(1);
        }else if(fakeName.startsWith(":")&&fakeName.length()>1){
            return fakeName.substring(0,fakeName.length()-1);
        }else{
            return fakeName;
        }
    }

    /**
     * 将两个JsonObject合并
     * @param source
     * @param target
     * @return JsonObject
     * @throws JSONException
     */
    public static JSONObject deepMerge(JSONObject source, JSONObject target){
        try{
            for (Object key: source.keySet()) {
                Object value = source.get(key);
                if (!target.containsKey(key)) {
                    target.put(key, value);
                } else {
                    if (value instanceof JSONObject) {
                        JSONObject valueJson = (JSONObject)value;
                        deepMerge(valueJson, target.getJSONObject(key.toString()));
                    } else {
                        target.put(key, value);
                    }
                }
            }
            return target;
        }catch(JSONException e){
            logger.info("context"+e);
        }
        return null;
    }

}



