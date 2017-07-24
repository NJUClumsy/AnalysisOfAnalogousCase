package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Bourbon on 2017/7/24.
 * 公诉方
 */
public class PublicProsecution {

    @Field("诉讼参与人")
    private String participant;
    @Field("诉讼身份")
    private String identity;
    @Field("当事人类别")
    private String participantType;
    @Field("本审诉讼地位")
    private String statusOfThisTrial;
    @Field("原审诉讼地位")
    private String statusOfLastTrial;

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

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
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

    @Override
    public String toString() {
        return "PublicProsecution{" +
                "participant='" + participant + '\'' +
                ", identity='" + identity + '\'' +
                ", participantType='" + participantType + '\'' +
                ", statusOfThisTrial='" + statusOfThisTrial + '\'' +
                ", statusOfLastTrial='" + statusOfLastTrial + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicProsecution that = (PublicProsecution) o;

        if (participant != null ? !participant.equals(that.participant) : that.participant != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (participantType != null ? !participantType.equals(that.participantType) : that.participantType != null)
            return false;
        if (statusOfThisTrial != null ? !statusOfThisTrial.equals(that.statusOfThisTrial) : that.statusOfThisTrial != null)
            return false;
        return statusOfLastTrial != null ? statusOfLastTrial.equals(that.statusOfLastTrial) : that.statusOfLastTrial == null;
    }

    @Override
    public int hashCode() {
        int result = participant != null ? participant.hashCode() : 0;
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (participantType != null ? participantType.hashCode() : 0);
        result = 31 * result + (statusOfThisTrial != null ? statusOfThisTrial.hashCode() : 0);
        result = 31 * result + (statusOfLastTrial != null ? statusOfLastTrial.hashCode() : 0);
        return result;
    }
}
