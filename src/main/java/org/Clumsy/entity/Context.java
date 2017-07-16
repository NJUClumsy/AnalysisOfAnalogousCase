package org.Clumsy.entity;


import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by slow_time on 2017/7/16.
 */
public class Context {

    @Field("文首")
    private String head;
    @Field("诉讼参与人全集")
    private String participants;
    @Field("诉讼记录")
    private String records;
    @Field("案件基本情况")
    private String situation;
    @Field("裁判分析过程")
    private String analysis;
    @Field("裁判结果")
    private String result;
    @Field("文尾")
    private String tail;
    @Field("附录")
    private String appendix;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Context context = (Context) o;

        if (head != null ? !head.equals(context.head) : context.head != null) return false;
        if (participants != null ? !participants.equals(context.participants) : context.participants != null)
            return false;
        if (records != null ? !records.equals(context.records) : context.records != null) return false;
        if (situation != null ? !situation.equals(context.situation) : context.situation != null) return false;
        if (analysis != null ? !analysis.equals(context.analysis) : context.analysis != null) return false;
        if (result != null ? !result.equals(context.result) : context.result != null) return false;
        if (tail != null ? !tail.equals(context.tail) : context.tail != null) return false;
        return appendix != null ? appendix.equals(context.appendix) : context.appendix == null;
    }

    @Override
    public int hashCode() {
        int result1 = head != null ? head.hashCode() : 0;
        result1 = 31 * result1 + (participants != null ? participants.hashCode() : 0);
        result1 = 31 * result1 + (records != null ? records.hashCode() : 0);
        result1 = 31 * result1 + (situation != null ? situation.hashCode() : 0);
        result1 = 31 * result1 + (analysis != null ? analysis.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (tail != null ? tail.hashCode() : 0);
        result1 = 31 * result1 + (appendix != null ? appendix.hashCode() : 0);
        return result1;
    }
}
