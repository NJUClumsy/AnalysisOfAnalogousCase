package org.Clumsy.vo;

/**
 * Created by slow_time on 2017/7/17.
 */
public class ContextVO {

    String head;
    String participants;
    String records;
    String situation;
    String analysis;
    String result;
    String tail;
    String appendix;

    public ContextVO(String head, String participants, String records, String situation, String analysis, String result, String tail, String appendix) {
        this.head = head;
        this.participants = participants;
        this.records = records;
        this.situation = situation;
        this.analysis = analysis;
        this.result = result;
        this.tail = tail;
        this.appendix = appendix;
    }
}
