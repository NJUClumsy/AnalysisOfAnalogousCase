package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/16.
 */
public class Law {

    @Field("法条名称")
    private String lawName;
    @Field("引用条目")
    private Collection<String> cite;

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public Collection<String> getCite() {
        return cite;
    }

    public void setCite(Collection<String> cite) {
        this.cite = cite;
    }

    @Override
    public String toString() {
        return "Law{" +
                "lawName='" + lawName + '\'' +
                ", cite=" + cite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Law law = (Law) o;

        if (lawName != null ? !lawName.equals(law.lawName) : law.lawName != null) return false;
        return cite != null ? cite.equals(law.cite) : law.cite == null;
    }

    @Override
    public int hashCode() {
        int result = lawName != null ? lawName.hashCode() : 0;
        result = 31 * result + (cite != null ? cite.hashCode() : 0);
        return result;
    }
}
