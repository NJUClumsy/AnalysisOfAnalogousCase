package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/24.
 */
public class Court {

    @Field("法院层级码")
    private String code;
    @Field("标准法院名称")
    private String name;
    @Field("法院级别")
    private String level;
    @Field("行政区划(省)")
    private String province;
    @Field("行政区划(市)")
    private String region;

    @Override
    public String toString() {
        return "Court{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Court court = (Court) o;

        if (code != null ? !code.equals(court.code) : court.code != null) return false;
        if (name != null ? !name.equals(court.name) : court.name != null) return false;
        if (level != null ? !level.equals(court.level) : court.level != null) return false;
        if (province != null ? !province.equals(court.province) : court.province != null) return false;
        return region != null ? region.equals(court.region) : court.region == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
