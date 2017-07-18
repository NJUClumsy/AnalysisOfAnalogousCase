package org.Clumsy.vo;

import org.Clumsy.entity.Context;

/**
 * Created by slow_time on 2017/7/17.
 */
public class ContextVO {

    public String head;
    public String participants;
    public String records;
    public String situation;
    public String analysis;
    public String result;
    public String tail;
    public String appendix;

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

    public ContextVO(Context context) {
        this.head = context.getHead();
        this.participants = context.getParticipants();
        this.records = context.getRecords();
        this.situation = context.getSituation();
        this.analysis = context.getAnalysis();
        this.result = context.getResult();
        this.tail = context.getTail();
        this.appendix = context.getAppendix();
    }

    @Override
    public String toString() {
        return "ContextVO{" +
                "head='" + head + '\'' +
                ", participants='" + participants + '\'' +
                ", records='" + records + '\'' +
                ", situation='" + situation + '\'' +
                ", analysis='" + analysis + '\'' +
                ", result='" + result + '\'' +
                ", tail='" + tail + '\'' +
                ", appendix='" + appendix + '\'' +
                '}';
    }
}
