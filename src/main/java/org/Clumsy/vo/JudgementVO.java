package org.Clumsy.vo;


import org.Clumsy.entity.Judgement;

/**
 * Created by slow_time on 2017/7/17.
 */
public class JudgementVO {

    public String main_charge;
    public String single_penalty;
    public String exec_penalty;

    public JudgementVO(String main_charge, String single_penalty, String exec_penalty) {
        this.main_charge = main_charge;
        this.single_penalty = single_penalty;
        this.exec_penalty = exec_penalty;
    }

    public JudgementVO(Judgement judgement) {
        this.main_charge = judgement.getMain_charge();
        this.single_penalty = judgement.getSingle_penalty();
        this.exec_penalty = judgement.getExec_penalty();
    }

    @Override
    public String toString() {
        return "JudgementVO{" +
                "main_charge='" + main_charge + '\'' +
                ", single_penalty='" + single_penalty + '\'' +
                ", exec_penalty='" + exec_penalty + '\'' +
                '}';
    }
}
