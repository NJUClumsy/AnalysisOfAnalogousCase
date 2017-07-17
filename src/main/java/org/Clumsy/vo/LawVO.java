package org.Clumsy.vo;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/17.
 */
public class LawVO {

    String lawName;
    Collection<String> cite;

    public LawVO(String lawName, Collection<String> cite) {
        this.lawName = lawName;
        this.cite = cite;
    }
}
