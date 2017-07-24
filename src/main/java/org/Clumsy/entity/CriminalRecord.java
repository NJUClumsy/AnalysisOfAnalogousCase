package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/**
 * Created by Bourbon on 2017/7/24.
 * 前科劣迹
 */
public class CriminalRecord {

    @Field("前科类别")
    private String type;
    @Field("处罚原因")
    private String cause;
    @Field("处罚时间")
    private LocalDate time;
    @Field("处罚单位")
    private String penaltyUnit;
    @Field("处罚形式")
    private String penaltyForm;
    @Field("处罚罚期")
    private String penaltyPeriod;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getPenaltyUnit() {
        return penaltyUnit;
    }

    public void setPenaltyUnit(String penaltyUnit) {
        this.penaltyUnit = penaltyUnit;
    }

    public String getPenaltyForm() {
        return penaltyForm;
    }

    public void setPenaltyForm(String penaltyForm) {
        this.penaltyForm = penaltyForm;
    }

    public String getPenaltyPeriod() {
        return penaltyPeriod;
    }

    public void setPenaltyPeriod(String penaltyPeriod) {
        this.penaltyPeriod = penaltyPeriod;
    }

    @Override
    public String toString(){
        return "CriminalRecord{"
                + "type='" + type + "\'"
                + ", cause='" + cause + "\'"
                + ", time='" + time + "\'"
                + ", penaltyUnit='" + penaltyUnit + "\'"
                + ", penaltyForm='" + penaltyForm + "\'"
                + ", penaltyPeriod='" + penaltyPeriod + "\'"
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriminalRecord that = (CriminalRecord) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (cause != null ? !cause.equals(that.cause) : that.cause != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (penaltyUnit != null ? !penaltyUnit.equals(that.penaltyUnit) : that.penaltyUnit != null) return false;
        if (penaltyForm != null ? !penaltyForm.equals(that.penaltyForm) : that.penaltyForm != null) return false;
        return penaltyPeriod != null ? penaltyPeriod.equals(that.penaltyPeriod) : that.penaltyPeriod == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (penaltyUnit != null ? penaltyUnit.hashCode() : 0);
        result = 31 * result + (penaltyForm != null ? penaltyForm.hashCode() : 0);
        result = 31 * result + (penaltyPeriod != null ? penaltyPeriod.hashCode() : 0);
        return result;
    }
}
