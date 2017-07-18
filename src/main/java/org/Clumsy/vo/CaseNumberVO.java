package org.Clumsy.vo;

import org.Clumsy.entity.CaseNumber;

/**
 * Created by slow_time on 2017/7/18.
 */
public class CaseNumberVO {

    public String caseId;

    public String caseNumber;

    public CaseNumberVO(String caseId, String caseNumber) {
        this.caseId = caseId;
        this.caseNumber = caseNumber;
    }

    public CaseNumberVO(CaseNumber c) {
       this.caseId = c.getCaseId();
       this.caseNumber = c.getCaseNumber();
    }

    @Override
    public String toString() {
        return "CaseNumberVO{" +
                "caseId='" + caseId + '\'' +
                ", caseNumbers='" + caseNumber + '\'' +
                '}';
    }
}
