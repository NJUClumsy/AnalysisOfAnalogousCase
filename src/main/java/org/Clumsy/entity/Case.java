package org.Clumsy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by slow_time on 2017/7/16.
 */

@Document(collection = "case")
public class Case {

    @Id
    private String id;
    @Field("全文")
    private Context context;
    @Field("经办法院")
    private String court;
    @Field("文书名称")
    private String type;
    @Field("案号")
    private String caseNumber;
    @Field("审判程序")
    private String process;
    @Field("原告")
    private Collection<String> accuser;
    @Field("被告")
    private Collection<String> defendant;
    @Field("公诉机关")
    private Collection<String> organ;
    @Field("案由")
    private String cause;
    @Field("开庭审理信息")
    private String info_try;
    @Field("原告诉称段")
    private String accuser_state;
    @Field("被告辩称段")
    private String defendant_state;
    @Field("查明事实段")
    private String fact;
    @Field("法条")
    private Collection<Law> law;
    @Field("具体裁判段")
    private Collection<String> judgment1;
    @Field("刑事判决结果分组")
    private Judgement judgement2;
    @Field("审判员")
    private Collection<String> judge;
    @Field("书记员")
    private String court_clerk;
    @Field("裁判时间")
    private LocalDate date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Collection<String> getAccuser() {
        return accuser;
    }

    public void setAccuser(Collection<String> accuser) {
        this.accuser = accuser;
    }

    public Collection<String> getDefendant() {
        return defendant;
    }

    public void setDefendant(Collection<String> defendant) {
        this.defendant = defendant;
    }

    public Collection<String> getOrgan() {
        return organ;
    }

    public void setOrgan(Collection<String> organ) {
        this.organ = organ;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getInfo_try() {
        return info_try;
    }

    public void setInfo_try(String info_try) {
        this.info_try = info_try;
    }

    public String getAccuser_state() {
        return accuser_state;
    }

    public void setAccuser_state(String accuser_state) {
        this.accuser_state = accuser_state;
    }

    public String getDefendant_state() {
        return defendant_state;
    }

    public void setDefendant_state(String defendant_state) {
        this.defendant_state = defendant_state;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Collection<Law> getLaw() {
        return law;
    }

    public void setLaw(Collection<Law> law) {
        this.law = law;
    }

    public Collection<String> getJudgment1() {
        return judgment1;
    }

    public void setJudgment1(Collection<String> judgment1) {
        this.judgment1 = judgment1;
    }

    public Judgement getJudgement2() {
        return judgement2;
    }

    public void setJudgement2(Judgement judgement2) {
        this.judgement2 = judgement2;
    }

    public Collection<String> getJudge() {
        return judge;
    }

    public void setJudge(Collection<String> judge) {
        this.judge = judge;
    }

    public String getCourt_clerk() {
        return court_clerk;
    }

    public void setCourt_clerk(String court_clerk) {
        this.court_clerk = court_clerk;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id='" + id + '\'' +
                ", context=" + context +
                ", court='" + court + '\'' +
                ", type='" + type + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", process='" + process + '\'' +
                ", accuser=" + accuser +
                ", defendant=" + defendant +
                ", organ=" + organ +
                ", cause='" + cause + '\'' +
                ", info_try='" + info_try + '\'' +
                ", accuser_state='" + accuser_state + '\'' +
                ", defendant_state='" + defendant_state + '\'' +
                ", fact='" + fact + '\'' +
                ", law=" + law +
                ", judgment1=" + judgment1 +
                ", judgement2=" + judgement2 +
                ", judge=" + judge +
                ", court_clerk='" + court_clerk + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Case aCase = (Case) o;

        if (id != null ? !id.equals(aCase.id) : aCase.id != null) return false;
        if (context != null ? !context.equals(aCase.context) : aCase.context != null) return false;
        if (court != null ? !court.equals(aCase.court) : aCase.court != null) return false;
        if (type != null ? !type.equals(aCase.type) : aCase.type != null) return false;
        if (caseNumber != null ? !caseNumber.equals(aCase.caseNumber) : aCase.caseNumber != null) return false;
        if (process != null ? !process.equals(aCase.process) : aCase.process != null) return false;
        if (accuser != null ? !accuser.equals(aCase.accuser) : aCase.accuser != null) return false;
        if (defendant != null ? !defendant.equals(aCase.defendant) : aCase.defendant != null) return false;
        if (organ != null ? !organ.equals(aCase.organ) : aCase.organ != null) return false;
        if (cause != null ? !cause.equals(aCase.cause) : aCase.cause != null) return false;
        if (info_try != null ? !info_try.equals(aCase.info_try) : aCase.info_try != null) return false;
        if (accuser_state != null ? !accuser_state.equals(aCase.accuser_state) : aCase.accuser_state != null)
            return false;
        if (defendant_state != null ? !defendant_state.equals(aCase.defendant_state) : aCase.defendant_state != null)
            return false;
        if (fact != null ? !fact.equals(aCase.fact) : aCase.fact != null) return false;
        if (law != null ? !law.equals(aCase.law) : aCase.law != null) return false;
        if (judgment1 != null ? !judgment1.equals(aCase.judgment1) : aCase.judgment1 != null) return false;
        if (judgement2 != null ? !judgement2.equals(aCase.judgement2) : aCase.judgement2 != null) return false;
        if (judge != null ? !judge.equals(aCase.judge) : aCase.judge != null) return false;
        if (court_clerk != null ? !court_clerk.equals(aCase.court_clerk) : aCase.court_clerk != null) return false;
        return date != null ? date.equals(aCase.date) : aCase.date == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (court != null ? court.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (caseNumber != null ? caseNumber.hashCode() : 0);
        result = 31 * result + (process != null ? process.hashCode() : 0);
        result = 31 * result + (accuser != null ? accuser.hashCode() : 0);
        result = 31 * result + (defendant != null ? defendant.hashCode() : 0);
        result = 31 * result + (organ != null ? organ.hashCode() : 0);
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + (info_try != null ? info_try.hashCode() : 0);
        result = 31 * result + (accuser_state != null ? accuser_state.hashCode() : 0);
        result = 31 * result + (defendant_state != null ? defendant_state.hashCode() : 0);
        result = 31 * result + (fact != null ? fact.hashCode() : 0);
        result = 31 * result + (law != null ? law.hashCode() : 0);
        result = 31 * result + (judgment1 != null ? judgment1.hashCode() : 0);
        result = 31 * result + (judgement2 != null ? judgement2.hashCode() : 0);
        result = 31 * result + (judge != null ? judge.hashCode() : 0);
        result = 31 * result + (court_clerk != null ? court_clerk.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
