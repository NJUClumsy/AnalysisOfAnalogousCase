package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Bourbon on 2017/7/24.
 * 代理人
 */
public class Agent {

    @Field("诉讼参与人")
    private String participant;
    @Field("诉讼身份")
    private String identity;
    @Field("当事人类型")
    private String type;
    @Field("单位职务")
    private String companyDuty;
    @Field("单位名称")
    private String companyName;
    @Field("单位性质")
    private String companyNature;
    @Field("国籍")
    private String nation;
    @Field("当事人类别")
    private String participantType;
    @Field("参与人诉讼地位")
    private String status;
    @Field("辩护种类")
    private String defenseType;
    @Field("辩护对象")
    private String defenseTarget;
    @Field("代理人辩护人职业类型")
    private String occupationType;
    @Field("辩护人或诉讼代理人类型")
    private String agentType;
    @Field("自然人身份")
    private String personalIdentity;

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyDuty() {
        return companyDuty;
    }

    public void setCompanyDuty(String companyDuty) {
        this.companyDuty = companyDuty;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDefenseType() {
        return defenseType;
    }

    public void setDefenseType(String defenseType) {
        this.defenseType = defenseType;
    }

    public String getDefenseTarget() {
        return defenseTarget;
    }

    public void setDefenseTarget(String defenseTarget) {
        this.defenseTarget = defenseTarget;
    }

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getPersonalIdentity() {
        return personalIdentity;
    }

    public void setPersonalIdentity(String personalIdentity) {
        this.personalIdentity = personalIdentity;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "participant='" + participant + '\'' +
                ", identity='" + identity + '\'' +
                ", type='" + type + '\'' +
                ", companyDuty='" + companyDuty + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyNature='" + companyNature + '\'' +
                ", nation='" + nation + '\'' +
                ", participantType='" + participantType + '\'' +
                ", status='" + status + '\'' +
                ", defenseType='" + defenseType + '\'' +
                ", defenseTarget='" + defenseTarget + '\'' +
                ", occupationType='" + occupationType + '\'' +
                ", agentType='" + agentType + '\'' +
                ", personalIdentity='" + personalIdentity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        if (participant != null ? !participant.equals(agent.participant) : agent.participant != null) return false;
        if (identity != null ? !identity.equals(agent.identity) : agent.identity != null) return false;
        if (type != null ? !type.equals(agent.type) : agent.type != null) return false;
        if (companyDuty != null ? !companyDuty.equals(agent.companyDuty) : agent.companyDuty != null) return false;
        if (companyName != null ? !companyName.equals(agent.companyName) : agent.companyName != null) return false;
        if (companyNature != null ? !companyNature.equals(agent.companyNature) : agent.companyNature != null)
            return false;
        if (nation != null ? !nation.equals(agent.nation) : agent.nation != null) return false;
        if (participantType != null ? !participantType.equals(agent.participantType) : agent.participantType != null)
            return false;
        if (status != null ? !status.equals(agent.status) : agent.status != null) return false;
        if (defenseType != null ? !defenseType.equals(agent.defenseType) : agent.defenseType != null) return false;
        if (defenseTarget != null ? !defenseTarget.equals(agent.defenseTarget) : agent.defenseTarget != null)
            return false;
        if (occupationType != null ? !occupationType.equals(agent.occupationType) : agent.occupationType != null)
            return false;
        if (agentType != null ? !agentType.equals(agent.agentType) : agent.agentType != null) return false;
        return personalIdentity != null ? personalIdentity.equals(agent.personalIdentity) : agent.personalIdentity == null;
    }

    @Override
    public int hashCode() {
        int result = participant != null ? participant.hashCode() : 0;
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (companyDuty != null ? companyDuty.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyNature != null ? companyNature.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (participantType != null ? participantType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (defenseType != null ? defenseType.hashCode() : 0);
        result = 31 * result + (defenseTarget != null ? defenseTarget.hashCode() : 0);
        result = 31 * result + (occupationType != null ? occupationType.hashCode() : 0);
        result = 31 * result + (agentType != null ? agentType.hashCode() : 0);
        result = 31 * result + (personalIdentity != null ? personalIdentity.hashCode() : 0);
        return result;
    }
}
