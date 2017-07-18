package org.Clumsy.vo;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/18.
 */
public class CaseNumberVO {

    public Collection<String> caseNumbers;

    public CaseNumberVO(Collection<String> caseNumbers) {
        this.caseNumbers = caseNumbers;
    }

    @Override
    public String toString() {
        return "CaseNumberVO{" +
                "caseNumbers=" + caseNumbers +
                '}';
    }
}
