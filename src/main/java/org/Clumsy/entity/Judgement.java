package org.Clumsy.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/16.
 */
public class Judgement {

    @Field("判决主罪名")
    private String main_charge;
    @Field("单罪判罚")
    private String single_penalty;
    @Field("执行判罚")
    private String exec_penalty;

    public String getMain_charge() {
        return main_charge;
    }

    public void setMain_charge(String main_charge) {
        this.main_charge = main_charge;
    }

    public String getSingle_penalty() {
        return single_penalty;
    }

    public void setSingle_penalty(String single_penalty) {
        this.single_penalty = single_penalty;
    }

    public String getExec_penalty() {
        return exec_penalty;
    }

    public void setExec_penalty(String exec_penalty) {
        this.exec_penalty = exec_penalty;
    }

    @Override
    public String toString() {
        return "Judgement{" +
                "main_charge='" + main_charge + '\'' +
                ", single_penalty='" + single_penalty + '\'' +
                ", exec_penalty='" + exec_penalty + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Judgement judgement = (Judgement) o;

        if (main_charge != null ? !main_charge.equals(judgement.main_charge) : judgement.main_charge != null)
            return false;
        if (single_penalty != null ? !single_penalty.equals(judgement.single_penalty) : judgement.single_penalty != null)
            return false;
        return exec_penalty != null ? exec_penalty.equals(judgement.exec_penalty) : judgement.exec_penalty == null;
    }

    @Override
    public int hashCode() {
        int result = main_charge != null ? main_charge.hashCode() : 0;
        result = 31 * result + (single_penalty != null ? single_penalty.hashCode() : 0);
        result = 31 * result + (exec_penalty != null ? exec_penalty.hashCode() : 0);
        return result;
    }
}
