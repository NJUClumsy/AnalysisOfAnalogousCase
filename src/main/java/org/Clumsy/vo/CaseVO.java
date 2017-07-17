package org.Clumsy.vo;

import org.Clumsy.entity.Case;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by slow_time on 2017/7/17.
 */
public class CaseVO {

    public String id;
    public ContextVO context;
    public String court;
    public String type;
    public String process;
    public Collection<String> accuser;
    public Collection<String> defendant;
    public Collection<String> organ;
    public String cause;
    public Collection<LawVO> law;
    public Collection<String> judgement1;
    public JudgementVO judgement2;
    public Collection<String> judge;
    public String court_clerk;
    public LocalDate date;

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

    public CaseVO(Case c) {
        this.id = c.getId();
        this.context = new ContextVO(c.getContext());
        this.court = c.getCourt();
        this.type = c.getType();
        this.process = c.getProcess();
        this.accuser = c.getAccuser();
        this.defendant = c.getDefendant();
        this.organ = c.getOrgan();
        this.cause = c.getCause();
        this.law = c.getLaw().stream().map(LawVO::new).collect(Collectors.toList());
        this.judgement1 = c.getJudgment1();
        this.judgement2 = c.getJudgement2() == null ? null : new JudgementVO(c.getJudgement2());
        this.judge = c.getJudge();
        this.court_clerk = c.getCourt_clerk();
        this.date = c.getDate();
    }
}
