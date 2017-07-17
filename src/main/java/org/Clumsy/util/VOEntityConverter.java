package org.Clumsy.util;

import org.Clumsy.entity.Case;
import org.Clumsy.vo.CaseVO;
import org.Clumsy.vo.ContextVO;
import org.Clumsy.vo.JudgementVO;
import org.Clumsy.vo.LawVO;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Lucifer on 17/7/17.
 */
public class VOEntityConverter {

    public static CaseVO convert(Case thisCase){
        String id = thisCase.getId();
        ContextVO context;
        String court = thisCase.getCourt();
        String type = thisCase.getType();
        String process = thisCase.getProcess();
        Collection<String> accuser = thisCase.getAccuser();
        Collection<String> defendant = thisCase.getDefendant();
        Collection<String> organ = thisCase.getOrgan();
        String cause = thisCase.getCause();
        Collection<LawVO> law;
        Collection<String> judgement1 = thisCase.getJudgment1();
        JudgementVO judgement2;
        Collection<String> judge = thisCase.getJudge();
        String court_clerk = thisCase.getCourt_clerk();
        LocalDate date = thisCase.getDate();
        return null;
    }
}
