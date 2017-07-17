package org.Clumsy.util;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

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

    private static String name="";
    private static String flftmc="";
    private static String spryxm="";

    private static String[] list = {"WS","SSCYRQJ","SSJL","AJJBQK","CPFXGC","CPJG","WW","JBFY","WSMC",
            "AH","SPCX","SSCYRMC","GSJG","AY","KTSLXX","YGSCD","ZKDL","BGBCD","BCDL","CMSSD","BSSLD","FLFTMC","TM",
            "JTCPD","SPRYXM","CPSJ","XSPJJGFZ","PJZZM","DZPF","ZXPF","SSSF","FL","SPRYJS"};

    private static ArrayList<String> newList = new ArrayList<String>();

    private static Map<String,String> allKeyMap = new HashMap<String,String>();

    private static ArrayList<String> lawName = new ArrayList<String>();

    public static void main(String[] args){
        String url = "/Users/chengxuelie/Documents/GitHub/AnalysisOfAnalogousCase/src/main/java/org/Clumsy/util/g.xml";//路径
        initializeAllKeyMap(url);
        Case a = ReadXMLHelper.getCase();
        System.out.println(a.getContext());
        System.out.println(a.getAccuser());
        System.out.println(a.getAccuser_state());
        System.out.println(a.getCaseNumber());
        System.out.println(a.getCause());
        System.out.println(a.getCourt());
        System.out.println(a.getCourt_clerk());
        System.out.println(a.getDate());
        System.out.println(a.getDefendant());
        System.out.println(a.getDefendant_state());
        System.out.println(a.getFact());
        System.out.println(a.getInfo_try());
        System.out.println(a.getJudge());//
        System.out.println(a.getJudgement2());
        System.out.println(a.getJudgment1());//
        System.out.println(a.getLaw());
        System.out.println(a.getOrgan());
        System.out.println(a.getProcess());
        System.out.println(a.getType());
        System.out.println(">>>>");
    }

    public static void initialize(){
        for(int i=0;i<list.length;i++){
            newList.add(list[i]);
        }
    }

    public static void initializeAllKeyMap(String url){
        initialize();
        SAXReader sax=new SAXReader();
        File xmlFile=new File(url);
        Document document= null;
        try {
            document = sax.read(xmlFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root=document.getRootElement();
        getNodes(root);
        System.out.println(allKeyMap);
    }

    public static void getNodes(Element node){
//        System.out.println("--------------------");
        ArrayList<String> instant = new ArrayList<String>();
        if(newList.contains(node.getName())){
//            System.out.println("当前节点名称："+node.getName());
            List<Attribute> listAttr=node.attributes();
            for(Attribute attr:listAttr){
                String value=attr.getValue();
//                System.out.println("属性值："+value);
                instant.add(value);
            }
            if(instant.size()<2){
                instant.add("空");
            }

            if(instant.get(1).equals("审判人员姓名")){
                spryxm=instant.get(0);
            }else if(instant.get(1).equals("审判人员角色")){
                allKeyMap.put(instant.get(0),spryxm);
            }

            if(instant.get(1).equals("法律法条名称")){
                flftmc=instant.get(0);
                allKeyMap.put(instant.get(1),instant.get(0));
                lawName.add(instant.get(0));
            }else if(instant.get(1).equals("条目")){
                allKeyMap.put(flftmc,instant.get(0));
            }

            if(instant.get(1).equals("诉讼参与人名称")){
                name=instant.get(0);
            }else if(instant.get(1).equals("诉讼身份")){
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

    public static Case getCase(){
        Case littleCase = new Case();
        Context context = new Context();

        ArrayList<String> accuser = null;
        ArrayList<String> defendant = null;
        ArrayList<String> judge = null;
        ArrayList<String> judgment1 = null;

        Judgement judgement2 = null;
        String mainCharge=null;
        String singlePenalty=null;
        String execPenalty=null;

        ArrayList<Law> lawList = null;
        Map<String,ArrayList<String>> law = new HashMap<String,ArrayList<String>>();

        LocalDate date = null;
        String dateToChange=null;

        ArrayList<String> organ = null;


        for (Map.Entry<String,String> entry : allKeyMap.entrySet()) {
            if(entry.getKey().equals("法律法条名称")){
                law.put(entry.getValue(),new ArrayList<String>());
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
            }
            if(entry.getKey().equals("原告")||entry.getKey().equals("原告人")){
                if(accuser==null){
                    accuser = new ArrayList<String>();
                }
                accuser.add(defineName(entry.getValue()));
            }else if(entry.getKey().equals("被告")||entry.getKey().equals("被告人")){
                if(defendant==null){
                    defendant = new ArrayList<String>();
                }
                defendant.add(defineName(entry.getValue()));
            }else if(entry.getKey().equals("审判员")||entry.getKey().equals("代理审判员")||entry.getKey().equals("审判长")){
                if(judge==null){
                    judge = new ArrayList<String>();
                }
                judge.add(defineName(entry.getValue()));
            }else if(entry.getKey().equals("具体裁判段")){
                if(judgment1==null){
                    judgment1 = new ArrayList<String>();
                }
                judgment1.add(defineName(entry.getValue()));
            }else if(lawName.contains(entry.getKey())){
                law.get(entry.getKey()).add(entry.getValue());
            }else if(entry.getKey().equals("公诉机关")){
                if(organ==null){
                    organ = new ArrayList<String>();
                }
                organ.add(defineName(entry.getValue()));
            }

        }

        littleCase.setContext(context);

        if(mainCharge!=null && singlePenalty!=null && execPenalty!=null){
            judgement2 = new Judgement();
            judgement2.setMain_charge(mainCharge);
            judgement2.setSingle_penalty(singlePenalty);
            judgement2.setExec_penalty(execPenalty);
            littleCase.setJudgement2(judgement2);
        }

        if(law.size()>0){
            if(lawList==null){
                lawList = new ArrayList<Law>();
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
            date = getDate(dateToChange);
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

    public static LocalDate getDate(String text){
        int ydex=text.indexOf("年");
        int mdex=text.indexOf("月");
        int ddex=text.indexOf("日");

        String yearStr = getModified(text.substring(0,ydex));
        String monthStr = getModified(text.substring(ydex+1,mdex));
        String dateStr = getModified(text.substring(mdex+1,ddex));

        ydex = Integer.parseInt(yearStr);
        mdex = Integer.parseInt(monthStr);
        ddex  = Integer.parseInt(dateStr);
        return LocalDate.of(ydex,mdex,ddex);
    }

    public static String getModified(String original){
        original = original.replaceFirst("null", "1");
        original = original.replace('O', '0');
        original = original.replace('Ｏ', '0');
        return original;
    }

    public static String defineName(String fakeName){
        String result=null;
        if(fakeName.startsWith("：")&&fakeName.length()>1){
            result = fakeName.substring(1);
            return result;
        }else if(fakeName.startsWith(":")&&fakeName.length()>1){
            result = fakeName.substring(0,fakeName.length()-1);
            return result;
        }else{
            return fakeName;
        }
    }

    public static JSONObject deepMerge(JSONObject source, JSONObject target) throws JSONException {
        for (Object key: source.keySet()) {
            Object value = source.get(key);
            if (!target.containsKey(key)) {// new value for "key":
                target.put(key, value);
            } else {// existing value for "key" - recursively deep merge:
                if (value instanceof JSONObject) {
                    JSONObject valueJson = (JSONObject)value;
                    deepMerge(valueJson, target.getJSONObject(key.toString()));
                } else {
                    target.put(key, value);
                }
            }
        }
        return target;
    }
}



