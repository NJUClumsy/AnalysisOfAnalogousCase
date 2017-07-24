package org.Clumsy.util;

import org.Clumsy.entity.Case;
import org.Clumsy.entity.Law;
import org.Clumsy.vo.CaseVO;
import org.Clumsy.vo.ContextVO;
import org.Clumsy.vo.LawVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lucifer on 17/7/17.
 */
public class VOEntityConvertHelper {

    private VOEntityConvertHelper(){

    }

    /**
     * 将Case转换为CaseCO
     * @param thisCase
     * @return CaseVO
     */
    public static CaseVO convert(Case thisCase){
        String id = thisCase.getId();

        ContextVO context = new ContextVO( thisCase.getContext().getHead(), thisCase.getContext().getParticipants(),
                thisCase.getContext().getRecords(), thisCase.getContext().getSituation(), thisCase.getContext().getAnalysis(),
                thisCase.getContext().getResult(),thisCase.getContext().getTail(),thisCase.getContext().getAppendix());

        String court = thisCase.getCourt();
        String type = thisCase.getType();
        String process = thisCase.getProcess();
        Collection<String> accuser = thisCase.getAccuser();
        Collection<String> defendant = thisCase.getDefendant();
        Collection<String> organ = thisCase.getOrgan();
        String cause = thisCase.getCause();

        Collection<LawVO> law = null;
        Collection<Law> laws = thisCase.getLaw();
        if(laws.size()>=1){
            law = new ArrayList<>();
            if(!laws.isEmpty()){
                for(Law instant: laws){
                    LawVO lawVO = new LawVO( instant.getLawName(), instant.getCite());
                    law.add(lawVO);
                }
            }
        }

        Collection<String> judgement1 = thisCase.getJudgment1();
        JudgementVO judgement2 = null;
        if(thisCase.getJudgement2()!=null){
            judgement2 = new JudgementVO( thisCase.getJudgement2().getMain_charge(), thisCase.getJudgement2().getSingle_penalty(), thisCase.getJudgement2().getExec_penalty());
        }
        Collection<String> judge = thisCase.getJudge();
        String court_clerk = thisCase.getCourt_clerk();
        LocalDate date = thisCase.getDate();

        return  new CaseVO( id, context, court, type, process, accuser, defendant, organ, cause, law,
                judgement1, judgement2, judge, court_clerk, date);
    }

}
