package org.Clumsy.vo;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by slow_time on 2017/7/17.
 */
public class CaseVO {

    String id;
    ContextVO context;
    String court;
    String type;
    String process;
    Collection<String> accuser;
    Collection<String> defendant;
    Collection<String> organ;
    String cause;
    Collection<LawVO> law;
    Collection<String> judgement1;
    JudgementVO judgement2;
    Collection<String> judge;
    String court_clerk;
    LocalDate date;

    public CaseVO(String id, ContextVO context, String court, String type, String process, Collection<String> accuser, Collection<String> defendant, Collection<String> organ, String cause, Collection<LawVO> law, Collection<String> judgement1, JudgementVO judgement2, Collection<String> judge, String court_clerk, LocalDate date) {
        this.id = id;
        this.context = context;
        this.court = court;
        this.type = type;
        this.process = process;
        this.accuser = accuser;
        this.defendant = defendant;
        this.organ = organ;
        this.cause = cause;
        this.law = law;
        this.judgement1 = judgement1;
        this.judgement2 = judgement2;
        this.judge = judge;
        this.court_clerk = court_clerk;
        this.date = date;
    }
}
