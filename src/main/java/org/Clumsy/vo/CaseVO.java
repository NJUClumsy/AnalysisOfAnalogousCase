package org.Clumsy.vo;

import org.Clumsy.entity.Agent;
import org.Clumsy.entity.Case;
import org.Clumsy.entity.Prosecution;
import org.Clumsy.entity.RespondingParty;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by slow_time on 2017/7/17.
 */
public class CaseVO {

    public String id;
    // 全文
    public ContextVO context;
    // 经办法院
    public String court;
    // 文书名称
    public String name;
    // 审判程序
    public String judicialProcedure;
    // 起诉方
    public Collection<String> prosecution;
    // 代理人
    public Collection<String> agents;
    // 公诉方
    public String publicProsecution;
    // 应诉方
    public Collection<String> respondingParty;
    // 起诉主案由
    public String majorCause;
    // 引用法条
    public Collection<LawVO> law;
    // 原公诉机关
    public String formerProcedureOrgan;
    // 二审结案方式
    public String closureWay;
    // 结案原因
    public String reason;
    // 裁判时间
    public LocalDate date;
    // 文书标题
    public String title;
    // 文书副标题
    public String subTitle;

    public CaseVO(String id, ContextVO context, String court, String name, String judicialProcedure, Collection<String> prosecution, Collection<String> agents, String publicProsecution, Collection<String> respondingParty, String majorCause, Collection<LawVO> law, String formerProcedureOrgan, String closureWay, String reason, LocalDate date, String title, String subTitle) {
        this.id = id;
        this.context = context;
        this.court = court;
        this.name = name;
        this.judicialProcedure = judicialProcedure;
        this.prosecution = prosecution;
        this.agents = agents;
        this.publicProsecution = publicProsecution;
        this.respondingParty = respondingParty;
        this.majorCause = majorCause;
        this.law = law;
        this.formerProcedureOrgan = formerProcedureOrgan;
        this.closureWay = closureWay;
        this.reason = reason;
        this.date = date;
        this.title = title;
        this.subTitle = subTitle;
    }

    public CaseVO(Case c) {
        this.id = c.getId();
        this.context = new ContextVO(c.getContext());
        this.court = c.getCourt().getName();
        this.name = c.getName();
        this.judicialProcedure = c.getJudicialProcedure();
        this.prosecution = c.getProsecutions().stream().map(Prosecution::getParticipant).collect(Collectors.toList());
        if (c.getAgents() != null)
            this.agents = c.getAgents().stream().map(Agent::getParticipant).collect(Collectors.toList());
        this.publicProsecution = c.getPublicProsecution().getParticipant();
        if (c.getRespondingParties() != null)
            this.respondingParty = c.getRespondingParties().stream().map(RespondingParty::getParticipant).collect(Collectors.toList());
        this.majorCause = c.getMajorCause().getAccusationName();
        if (c.getLaw() != null)
            this.law = c.getLaw().stream().map(LawVO::new).collect(Collectors.toList());
        this.formerProcedureOrgan = c.getFormerProcedureOrgan();
        this.closureWay = c.getClosureWay();
        this.reason = c.getReason();
        this.date = c.getDate();
        this.title = c.getTitle();
        this.subTitle = c.getSubTitle();
    }

    @Override
    public String toString() {
        return "CaseVO{" +
                "id='" + id + '\'' +
                ", context=" + context +
                ", court='" + court + '\'' +
                ", name='" + name + '\'' +
                ", judicialProcedure='" + judicialProcedure + '\'' +
                ", prosecution=" + prosecution +
                ", agents=" + agents +
                ", publicProsecution='" + publicProsecution + '\'' +
                ", respondingParty=" + respondingParty +
                ", majorCause='" + majorCause + '\'' +
                ", law=" + law +
                ", formerProcedureOrgan='" + formerProcedureOrgan + '\'' +
                ", closureWay='" + closureWay + '\'' +
                ", reason='" + reason + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
