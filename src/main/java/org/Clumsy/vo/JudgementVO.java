package org.Clumsy.vo;

/**
 * Created by slow_time on 2017/7/17.
 */
public class JudgementVO {

    String main_charge;
    String single_penalty;
    String exec_penalty;

    public JudgementVO(String main_charge, String single_penalty, String exec_penalty) {
        this.main_charge = main_charge;
        this.single_penalty = single_penalty;
        this.exec_penalty = exec_penalty;
    }
}
