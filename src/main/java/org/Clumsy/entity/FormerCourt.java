package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/24.
 */
public class FormerCourt {

    @Field("法院层级码")
    private String code;
    @Field("标准法院名称")
    private String name;
    @Field("法院级别")
    private String level;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormerCourt that = (FormerCourt) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return level != null ? level.equals(that.level) : that.level == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FormerCourt{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
