package org.Clumsy.vo;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/17.
 */
public class CauseVO {

    public Collection<String> causes;

    public CauseVO(Collection<String> causes) {
        this.causes = causes;
    }

    @Override
    public String toString() {
        return "CauseVO{" +
                "causes=" + causes +
                '}';
    }
}
