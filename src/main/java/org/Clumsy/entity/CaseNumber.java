package org.Clumsy.entity;

/**
 * Created by slow_time on 2017/7/18.
 */
public class CaseNumber {

    private String caseId;
    private String caseNumber;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseNumber that = (CaseNumber) o;

        if (caseId != null ? !caseId.equals(that.caseId) : that.caseId != null) return false;
        return caseNumber != null ? caseNumber.equals(that.caseNumber) : that.caseNumber == null;
    }

    @Override
    public int hashCode() {
        int result = caseId != null ? caseId.hashCode() : 0;
        result = 31 * result + (caseNumber != null ? caseNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CaseNumber{" +
                "caseId='" + caseId + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                '}';
    }
}
