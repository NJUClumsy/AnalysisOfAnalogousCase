package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Bourbon on 2017/7/24.
 * 应诉方
 */
public class RespondingParty {

    @Field("诉讼参与人")
    private String participant;
    @Field("诉讼身份")
    private String identity;
    @Field("当事人类型")
    private String type;
    @Field("国籍")
    private String nation;
    @Field("当事人类别")
    private String participantType;
    @Field("前科劣迹")
    private CriminalRecord criminalRecord;
    @Field("缓刑考验期内犯罪")
    private boolean probationCrime;
    @Field("假释考验期内犯罪")
    private boolean paroleCrime;
    @Field("刑事责任能力")
    private String criminalResponsibility;
    @Field("本审诉讼地位")
    private String statusOfThisTrial;
    @Field("原审诉讼地位")
    private String statusOfLastTrial;
    @Field("是否被害人")
    private boolean victim;
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

    public CriminalRecord getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(CriminalRecord criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public boolean isProbationCrime() {
        return probationCrime;
    }

    public void setProbationCrime(boolean probationCrime) {
        this.probationCrime = probationCrime;
    }

    public boolean isParoleCrime() {
        return paroleCrime;
    }

    public void setParoleCrime(boolean paroleCrime) {
        this.paroleCrime = paroleCrime;
    }

    public String getCriminalResponsibility() {
        return criminalResponsibility;
    }

    public void setCriminalResponsibility(String criminalResponsibility) {
        this.criminalResponsibility = criminalResponsibility;
    }

    public String getStatusOfThisTrial() {
        return statusOfThisTrial;
    }

    public void setStatusOfThisTrial(String statusOfThisTrial) {
        this.statusOfThisTrial = statusOfThisTrial;
    }

    public String getStatusOfLastTrial() {
        return statusOfLastTrial;
    }

    public void setStatusOfLastTrial(String statusOfLastTrial) {
        this.statusOfLastTrial = statusOfLastTrial;
    }

    public boolean isVictim() {
        return victim;
    }

    public void setVictim(boolean victim) {
        this.victim = victim;
    }

    public String getPersonalIdentity() {
        return personalIdentity;
    }

    public void setPersonalIdentity(String personalIdentity) {
        this.personalIdentity = personalIdentity;
    }

    @Override
    public String toString() {
        return "RespondingParty{" +
                "participant='" + participant + '\'' +
                ", identity='" + identity + '\'' +
                ", type='" + type + '\'' +
                ", nation='" + nation + '\'' +
                ", participantType='" + participantType + '\'' +
                ", criminalRecord=" + criminalRecord +
                ", probationCrime=" + probationCrime +
                ", paroleCrime=" + paroleCrime +
                ", criminalResponsibility='" + criminalResponsibility + '\'' +
                ", statusOfThisTrial='" + statusOfThisTrial + '\'' +
                ", statusOfLastTrial='" + statusOfLastTrial + '\'' +
                ", victim=" + victim +
                ", personalIdentity='" + personalIdentity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespondingParty that = (RespondingParty) o;

        if (probationCrime != that.probationCrime) return false;
        if (paroleCrime != that.paroleCrime) return false;
        if (victim != that.victim) return false;
        if (participant != null ? !participant.equals(that.participant) : that.participant != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (nation != null ? !nation.equals(that.nation) : that.nation != null) return false;
        if (participantType != null ? !participantType.equals(that.participantType) : that.participantType != null)
            return false;
        if (criminalRecord != null ? !criminalRecord.equals(that.criminalRecord) : that.criminalRecord != null)
            return false;
        if (criminalResponsibility != null ? !criminalResponsibility.equals(that.criminalResponsibility) : that.criminalResponsibility != null)
            return false;
        if (statusOfThisTrial != null ? !statusOfThisTrial.equals(that.statusOfThisTrial) : that.statusOfThisTrial != null)
            return false;
        if (statusOfLastTrial != null ? !statusOfLastTrial.equals(that.statusOfLastTrial) : that.statusOfLastTrial != null)
            return false;
        return personalIdentity != null ? personalIdentity.equals(that.personalIdentity) : that.personalIdentity == null;
    }

    @Override
    public int hashCode() {
        int result = participant != null ? participant.hashCode() : 0;
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (nation != null ? nation.hashCode() : 0);
        result = 31 * result + (participantType != null ? participantType.hashCode() : 0);
        result = 31 * result + (criminalRecord != null ? criminalRecord.hashCode() : 0);
        result = 31 * result + (probationCrime ? 1 : 0);
        result = 31 * result + (paroleCrime ? 1 : 0);
        result = 31 * result + (criminalResponsibility != null ? criminalResponsibility.hashCode() : 0);
        result = 31 * result + (statusOfThisTrial != null ? statusOfThisTrial.hashCode() : 0);
        result = 31 * result + (statusOfLastTrial != null ? statusOfLastTrial.hashCode() : 0);
        result = 31 * result + (victim ? 1 : 0);
        result = 31 * result + (personalIdentity != null ? personalIdentity.hashCode() : 0);
        return result;
    }
}
