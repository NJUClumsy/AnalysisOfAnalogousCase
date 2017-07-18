package org.Clumsy.vo;

import org.Clumsy.entity.Law;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/17.
 */
public class LawVO {

    public String lawName;
    public Collection<String> cite;

    public LawVO(String lawName, Collection<String> cite) {
        this.lawName = lawName;
        this.cite = cite;
    }

    public LawVO (Law law){
        this.lawName = law.getLawName();
        this.cite = law.getCite();
    }

    @Override
    public String toString() {
        return "LawVO{" +
                "lawName='" + lawName + '\'' +
                ", cite=" + cite +
                '}';
    }
}
