package org.Clumsy.util;

import org.Clumsy.entity.Case;
import org.Clumsy.entity.Context;
import org.Clumsy.entity.Law;
import org.Clumsy.vo.CaseVO;
import org.Clumsy.vo.ContextVO;
import org.Clumsy.vo.LawVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by NathanielLu on 2017/7/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class VOEntityConvertHelperTest {

    private Case thisCase;

    @Before
    public void initialize(){
        String id = "1234";
        Context context = new Context();
        context.setHead("文首");
        context.setParticipants("诉讼参与人全集");
        context.setRecords("诉讼记录");
        context.setSituation("案件基本情况");
        context.setAnalysis("裁判分析过程");
        context.setResult("裁判结果");
        context.setTail("文尾");
        context.setAppendix("附录");

        String court = "经办法院";
        String type = "文书名称";
        String caseNumber = "案号";
        String process = "审判程序";

        Collection<String> accuser = new ArrayList<>();
        accuser.add("原告1");
        accuser.add("原告2");

        Collection<String> defendant = new ArrayList<>();
        defendant.add("被告");

        Collection<String> organ = null;
        String cause = "案由";
        String info_try = "开庭审理信息";
        String accuser_state = "原告诉称段";
        String defendant_state = "被告辩称段";
        String fact = "查明事实段";

        Collection<Law> law = new ArrayList<>();
        Law lawone = new Law();
        lawone.setLawName("法条名称");
        ArrayList<String> tiaomu = new ArrayList<>();
        tiaomu.add("条目");
        lawone.setCite(tiaomu);
        law.add(lawone);

        Collection<String> judgement1 = new ArrayList<>();
        judgement1.add("具体裁判段1");
        judgement1.add("具体裁判段2");

        Judgement judgement2 = null;

        Collection<String> judge = new ArrayList<>();
        judge.add("审判员1");
        judge.add("审判员2");

        String court_clerk = "书记员";
        LocalDate date = LocalDate.of(2001,1,1);

        thisCase = new Case();
        thisCase.setId(id);
        thisCase.setContext(context);
        thisCase.setCourt(court);
        thisCase.setCause(cause);
        thisCase.setCaseNumber(caseNumber);
        thisCase.setProcess(process);
        thisCase.setType(type);
        thisCase.setAccuser(accuser);
        thisCase.setDefendant(defendant);
        thisCase.setOrgan(organ);
        thisCase.setInfo_try(info_try);
        thisCase.setAccuser_state(accuser_state);
        thisCase.setDefendant_state(defendant_state);
        thisCase.setFact(fact);
        thisCase.setLaw(law);
        thisCase.setJudgment1(judgement1);
        thisCase.setJudgement2(judgement2);
        thisCase.setJudge(judge);
        thisCase.setCourt_clerk(court_clerk);
        thisCase.setDate(date);
    }

    @Test
    public void testConvert() throws Exception {
        String id = "1234";
        ContextVO context = new ContextVO("文首","诉讼参与人全集","诉讼记录","案件基本情况","裁判分析过程","裁判结果","文尾","附录");

        String court = "经办法院";
        String type = "文书名称";
        String process = "审判程序";

        Collection<String> accuser = new ArrayList<>();
        accuser.add("原告1");
        accuser.add("原告2");

        Collection<String> defendant = new ArrayList<>();
        defendant.add("被告");

        Collection<String> organ = null;
        String cause = "案由";

        Collection<LawVO> law = new ArrayList<>();
        ArrayList<String> tiaomu = new ArrayList<>();
        tiaomu.add("条目");
        LawVO lawone = new LawVO("法条名称",tiaomu);
        law.add(lawone);

        Collection<String> judgement1 = new ArrayList<>();
        judgement1.add("具体裁判段1");
        judgement1.add("具体裁判段2");

        JudgementVO judgement2 = null;

        Collection<String> judge = new ArrayList<>();
        judge.add("审判员1");
        judge.add("审判员2");

        String court_clerk = "书记员";
        LocalDate date = LocalDate.of(2001,1,1);

        CaseVO caseVO = VOEntityConvertHelper.convert(thisCase);
        CaseVO mock = new CaseVO(id, context, court, type, process, accuser, defendant, organ, cause,
                law, judgement1, judgement2, judge, court_clerk, date);

        String actual = caseVO.toString();
        String expected = mock.toString();
        assertEquals(actual,expected);
    }

}