package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/24.
 */
public class Accusation {

    @Field("罪名代码")
    private String accusationCode;
    @Field("完整罪名")
    private String accusationName;

    public String getAccusationCode() {
        return accusationCode;
    }

    public void setAccusationCode(String accusationCode) {
        this.accusationCode = accusationCode;
    }

    public String getAccusationName() {
        return accusationName;
    }

    public void setAccusationName(String accusationName) {
        this.accusationName = accusationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accusation that = (Accusation) o;

        if (accusationCode != null ? !accusationCode.equals(that.accusationCode) : that.accusationCode != null)
            return false;
        return accusationName != null ? accusationName.equals(that.accusationName) : that.accusationName == null;
    }

    @Override
    public int hashCode() {
        int result = accusationCode != null ? accusationCode.hashCode() : 0;
        result = 31 * result + (accusationName != null ? accusationName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Accusation{" +
                "accusationCode='" + accusationCode + '\'' +
                ", accusationName='" + accusationName + '\'' +
                '}';
    }
}
