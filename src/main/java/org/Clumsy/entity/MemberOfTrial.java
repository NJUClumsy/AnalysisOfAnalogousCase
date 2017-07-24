package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/24.
 */
public class MemberOfTrial {

    @Field("审判人员姓名")
    private String name;
    @Field("审判人员角色")
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberOfTrial that = (MemberOfTrial) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return role != null ? role.equals(that.role) : that.role == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MemberOfTrial{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
