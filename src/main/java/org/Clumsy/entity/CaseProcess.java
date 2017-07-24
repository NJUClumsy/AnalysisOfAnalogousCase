package org.Clumsy.entity;


import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

/**
 * Created by slow_time on 2017/7/24.
 */
public class CaseProcess {

    @Field("前审案号")
    private String formerCaseNumber;
    @Field("前审法院")
    private FormerCourt formerCourt;
    @Field("前审裁判时间")
    private LocalDate formerDate;
    @Field("前审文书种类")
    private String formerTypeOfWrit;
    @Field("前审公诉机关")
    private String formerPublicProsecution;
    @Field("前审审级")
    private String formerLevel;
    @Field("前审案件由来")
    private String formerOrigin;
    @Field("前审结案方式")
    private String formerClosureWay;

    public String getFormerCaseNumber() {
        return formerCaseNumber;
    }

    public void setFormerCaseNumber(String formerCaseNumber) {
        this.formerCaseNumber = formerCaseNumber;
    }

    public FormerCourt getFormerCourt() {
        return formerCourt;
    }

    public void setFormerCourt(FormerCourt formerCourt) {
        this.formerCourt = formerCourt;
    }

    public LocalDate getFormerDate() {
        return formerDate;
    }

    public void setFormerDate(LocalDate formerDate) {
        this.formerDate = formerDate;
    }

    public String getFormerTypeOfWrit() {
        return formerTypeOfWrit;
    }

    public void setFormerTypeOfWrit(String formerTypeOfWrit) {
        this.formerTypeOfWrit = formerTypeOfWrit;
    }

    public String getFormerPublicProsecution() {
        return formerPublicProsecution;
    }

    public void setFormerPublicProsecution(String formerPublicProsecution) {
        this.formerPublicProsecution = formerPublicProsecution;
    }

    public String getFormerLevel() {
        return formerLevel;
    }

    public void setFormerLevel(String formerLevel) {
        this.formerLevel = formerLevel;
    }

    public String getFormerOrigin() {
        return formerOrigin;
    }

    public void setOrigin(String formerOrigin) {
        this.formerOrigin = formerOrigin;
    }

    public String getFormerClosureWay() {
        return formerClosureWay;
    }

    public void setFormerClosureWay(String formerClosureWay) {
        this.formerClosureWay = formerClosureWay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseProcess that = (CaseProcess) o;

        if (formerCaseNumber != null ? !formerCaseNumber.equals(that.formerCaseNumber) : that.formerCaseNumber != null)
            return false;
        if (formerCourt != null ? !formerCourt.equals(that.formerCourt) : that.formerCourt != null) return false;
        if (formerDate != null ? !formerDate.equals(that.formerDate) : that.formerDate != null) return false;
        if (formerTypeOfWrit != null ? !formerTypeOfWrit.equals(that.formerTypeOfWrit) : that.formerTypeOfWrit != null)
            return false;
        if (formerPublicProsecution != null ? !formerPublicProsecution.equals(that.formerPublicProsecution) : that.formerPublicProsecution != null)
            return false;
        if (formerLevel != null ? !formerLevel.equals(that.formerLevel) : that.formerLevel != null) return false;
        if (formerOrigin != null ? !formerOrigin.equals(that.formerOrigin) : that.formerOrigin != null) return false;
        return formerClosureWay != null ? formerClosureWay.equals(that.formerClosureWay) : that.formerClosureWay == null;
    }

    @Override
    public int hashCode() {
        int result = formerCaseNumber != null ? formerCaseNumber.hashCode() : 0;
        result = 31 * result + (formerCourt != null ? formerCourt.hashCode() : 0);
        result = 31 * result + (formerDate != null ? formerDate.hashCode() : 0);
        result = 31 * result + (formerTypeOfWrit != null ? formerTypeOfWrit.hashCode() : 0);
        result = 31 * result + (formerPublicProsecution != null ? formerPublicProsecution.hashCode() : 0);
        result = 31 * result + (formerLevel != null ? formerLevel.hashCode() : 0);
        result = 31 * result + (formerOrigin != null ? formerOrigin.hashCode() : 0);
        result = 31 * result + (formerClosureWay != null ? formerClosureWay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CaseProcess{" +
                "formerCaseNumber='" + formerCaseNumber + '\'' +
                ", formerCourt=" + formerCourt +
                ", formerDate=" + formerDate +
                ", formerTypeOfWrit='" + formerTypeOfWrit + '\'' +
                ", formerPublicProsecution='" + formerPublicProsecution + '\'' +
                ", formerLevel='" + formerLevel + '\'' +
                ", origin='" + formerOrigin + '\'' +
                ", formerClosureWay='" + formerClosureWay + '\'' +
                '}';
    }
}
