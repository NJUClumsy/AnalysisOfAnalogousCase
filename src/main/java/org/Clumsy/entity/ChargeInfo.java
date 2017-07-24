package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

/**
 * Created by slow_time on 2017/7/24.
 */
public class ChargeInfo {

    @Field("指控罪名")
    private Collection<Accusation> accusations;
    @Field("相关人")
    private Collection<String> relevantPeople;

    public Collection<Accusation> getAccusations() {
        return accusations;
    }

    public void setAccusations(Collection<Accusation> accusations) {
        this.accusations = accusations;
    }

    public Collection<String> getRelevantPeople() {
        return relevantPeople;
    }

    public void setRelevantPeople(Collection<String> relevantPeople) {
        this.relevantPeople = relevantPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargeInfo that = (ChargeInfo) o;

        if (accusations != null ? !accusations.equals(that.accusations) : that.accusations != null) return false;
        return relevantPeople != null ? relevantPeople.equals(that.relevantPeople) : that.relevantPeople == null;
    }

    @Override
    public int hashCode() {
        int result = accusations != null ? accusations.hashCode() : 0;
        result = 31 * result + (relevantPeople != null ? relevantPeople.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChargeInfo{" +
                "accusations=" + accusations +
                ", relevantPeople=" + relevantPeople +
                '}';
    }
}
