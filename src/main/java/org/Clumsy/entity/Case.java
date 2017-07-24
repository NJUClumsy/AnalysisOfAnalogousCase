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
    private Court court;
    @Field("文书名称")
    private String name;
    @Field("案号")
    private String caseNumber;
    @Field("案件类别")
    private String typeOfCase;
    @Field("文书种类")
    private String typeOfWrit;
    @Field("审判程序")
    private String judicialProcedure;
    @Field("公诉方")
    private PublicProsecution publicProsecution;
    @Field("起诉方")
    private Collection<Prosecution> prosecutions;
    @Field("代理人")
    private Collection<Agent> agents;
    @Field("应诉方")
    private Collection<RespondingParty> respondingParties;
    @Field("被告人缺席")
    private Boolean absenceOfDefendant;
    @Field("开庭审理")
    private Boolean openCourt;
    @Field("诉讼性质")
    private String natureOfLawsuit;
    @Field("检察院建议延期审理")
    private Boolean postpone;
    @Field("少年法庭")
    private Boolean juvenileCourt;
    @Field("指控信息")
    private Collection<ChargeInfo> chargeInfos;
    @Field("起诉主案由")
    private Accusation majorCause;
    @Field("其他起诉案由")
    private Collection<Accusation> minorCause;
    @Field("案件由来与审理经过段")
    private CaseProcess caseProcess;
    @Field("二审案件来源")
    private String origin;
    @Field("上诉或抗诉范围")
    private String scopeOfAppeal;
    @Field("原公诉机关")
    private String formerProcedureOrgan;
    @Field("审判组织")
    private String collegiateBench;
    @Field("质证情况")
    private String crossExamination;
    @Field("提出管辖权异议")
    private Boolean objectionOfCompetency;
    @Field("开庭前申请撤回上诉")
    private Boolean applyForWithdraw;
    @Field("法律法条引用")
    private Collection<Law> law;
    @Field("二审复核")
    private Boolean recheck;
    @Field("二审结案方式")
    private String closureWay;
    @Field("结案原因")
    private String reason;
    @Field("裁判时间")
    private LocalDate date;
    @Field("审判组织成员")
    private Collection<MemberOfTrial> memberOfTrials;
    @Field("文书标题")
    private String title;
    @Field("文书副标题")
    private String subTitle;

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

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getTypeOfCase() {
        return typeOfCase;
    }

    public void setTypeOfCase(String typeOfCase) {
        this.typeOfCase = typeOfCase;
    }

    public String getTypeOfWrit() {
        return typeOfWrit;
    }

    public void setTypeOfWrit(String typeOfWrit) {
        this.typeOfWrit = typeOfWrit;
    }

    public String getJudicialProcedure() {
        return judicialProcedure;
    }

    public void setJudicialProcedure(String judicialProcedure) {
        this.judicialProcedure = judicialProcedure;
    }

    public PublicProsecution getPublicProsecution() {
        return publicProsecution;
    }

    public void setPublicProsecution(PublicProsecution publicProsecution) {
        this.publicProsecution = publicProsecution;
    }

    public Collection<Prosecution> getProsecutions() {
        return prosecutions;
    }

    public void setProsecutions(Collection<Prosecution> prosecutions) {
        this.prosecutions = prosecutions;
    }

    public Collection<Agent> getAgents() {
        return agents;
    }

    public void setAgents(Collection<Agent> agents) {
        this.agents = agents;
    }

    public Collection<RespondingParty> getRespondingParties() {
        return respondingParties;
    }

    public void setRespondingParties(Collection<RespondingParty> respondingParties) {
        this.respondingParties = respondingParties;
    }

    public Boolean getAbsenceOfDefendant() {
        return absenceOfDefendant;
    }

    public void setAbsenceOfDefendant(Boolean absenceOfDefendant) {
        this.absenceOfDefendant = absenceOfDefendant;
    }

    public Boolean getOpenCourt() {
        return openCourt;
    }

    public void setOpenCourt(Boolean openCourt) {
        this.openCourt = openCourt;
    }

    public String getNatureOfLawsuit() {
        return natureOfLawsuit;
    }

    public void setNatureOfLawsuit(String natureOfLawsuit) {
        this.natureOfLawsuit = natureOfLawsuit;
    }

    public Boolean getPostpone() {
        return postpone;
    }

    public void setPostpone(Boolean postpone) {
        this.postpone = postpone;
    }

    public Boolean getJuvenileCourt() {
        return juvenileCourt;
    }

    public void setJuvenileCourt(Boolean juvenileCourt) {
        this.juvenileCourt = juvenileCourt;
    }

    public Collection<ChargeInfo> getChargeInfos() {
        return chargeInfos;
    }

    public void setChargeInfos(Collection<ChargeInfo> chargeInfos) {
        this.chargeInfos = chargeInfos;
    }

    public Accusation getMajorCause() {
        return majorCause;
    }

    public void setMajorCause(Accusation majorCause) {
        this.majorCause = majorCause;
    }

    public Collection<Accusation> getMinorCause() {
        return minorCause;
    }

    public void setMinorCause(Collection<Accusation> minorCause) {
        this.minorCause = minorCause;
    }

    public CaseProcess getCaseProcess() {
        return caseProcess;
    }

    public void setCaseProcess(CaseProcess caseProcess) {
        this.caseProcess = caseProcess;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getScopeOfAppeal() {
        return scopeOfAppeal;
    }

    public void setScopeOfAppeal(String scopeOfAppeal) {
        this.scopeOfAppeal = scopeOfAppeal;
    }

    public String getFormerProcedureOrgan() {
        return formerProcedureOrgan;
    }

    public void setFormerProcedureOrgan(String formerProcedureOrgan) {
        this.formerProcedureOrgan = formerProcedureOrgan;
    }

    public String getCollegiateBench() {
        return collegiateBench;
    }

    public void setCollegiateBench(String collegiateBench) {
        this.collegiateBench = collegiateBench;
    }

    public String getCrossExamination() {
        return crossExamination;
    }

    public void setCrossExamination(String crossExamination) {
        this.crossExamination = crossExamination;
    }

    public Boolean getObjectionOfCompetency() {
        return objectionOfCompetency;
    }

    public void setObjectionOfCompetency(Boolean objectionOfCompetency) {
        this.objectionOfCompetency = objectionOfCompetency;
    }

    public Boolean getApplyForWithdraw() {
        return applyForWithdraw;
    }

    public void setApplyForWithdraw(Boolean applyForWithdraw) {
        this.applyForWithdraw = applyForWithdraw;
    }

    public Collection<Law> getLaw() {
        return law;
    }

    public void setLaw(Collection<Law> law) {
        this.law = law;
    }

    public Boolean getRecheck() {
        return recheck;
    }

    public void setRecheck(Boolean recheck) {
        this.recheck = recheck;
    }

    public String getClosureWay() {
        return closureWay;
    }

    public void setClosureWay(String closureWay) {
        this.closureWay = closureWay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Collection<MemberOfTrial> getMemberOfTrials() {
        return memberOfTrials;
    }

    public void setMemberOfTrials(Collection<MemberOfTrial> memberOfTrials) {
        this.memberOfTrials = memberOfTrials;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Case aCase = (Case) o;

        if (id != null ? !id.equals(aCase.id) : aCase.id != null) return false;
        if (context != null ? !context.equals(aCase.context) : aCase.context != null) return false;
        if (court != null ? !court.equals(aCase.court) : aCase.court != null) return false;
        if (name != null ? !name.equals(aCase.name) : aCase.name != null) return false;
        if (caseNumber != null ? !caseNumber.equals(aCase.caseNumber) : aCase.caseNumber != null) return false;
        if (typeOfCase != null ? !typeOfCase.equals(aCase.typeOfCase) : aCase.typeOfCase != null) return false;
        if (typeOfWrit != null ? !typeOfWrit.equals(aCase.typeOfWrit) : aCase.typeOfWrit != null) return false;
        if (judicialProcedure != null ? !judicialProcedure.equals(aCase.judicialProcedure) : aCase.judicialProcedure != null)
            return false;
        if (publicProsecution != null ? !publicProsecution.equals(aCase.publicProsecution) : aCase.publicProsecution != null)
            return false;
        if (prosecutions != null ? !prosecutions.equals(aCase.prosecutions) : aCase.prosecutions != null) return false;
        if (agents != null ? !agents.equals(aCase.agents) : aCase.agents != null) return false;
        if (respondingParties != null ? !respondingParties.equals(aCase.respondingParties) : aCase.respondingParties != null)
            return false;
        if (absenceOfDefendant != null ? !absenceOfDefendant.equals(aCase.absenceOfDefendant) : aCase.absenceOfDefendant != null)
            return false;
        if (openCourt != null ? !openCourt.equals(aCase.openCourt) : aCase.openCourt != null) return false;
        if (natureOfLawsuit != null ? !natureOfLawsuit.equals(aCase.natureOfLawsuit) : aCase.natureOfLawsuit != null)
            return false;
        if (postpone != null ? !postpone.equals(aCase.postpone) : aCase.postpone != null) return false;
        if (juvenileCourt != null ? !juvenileCourt.equals(aCase.juvenileCourt) : aCase.juvenileCourt != null)
            return false;
        if (chargeInfos != null ? !chargeInfos.equals(aCase.chargeInfos) : aCase.chargeInfos != null) return false;
        if (majorCause != null ? !majorCause.equals(aCase.majorCause) : aCase.majorCause != null) return false;
        if (minorCause != null ? !minorCause.equals(aCase.minorCause) : aCase.minorCause != null) return false;
        if (caseProcess != null ? !caseProcess.equals(aCase.caseProcess) : aCase.caseProcess != null) return false;
        if (origin != null ? !origin.equals(aCase.origin) : aCase.origin != null) return false;
        if (scopeOfAppeal != null ? !scopeOfAppeal.equals(aCase.scopeOfAppeal) : aCase.scopeOfAppeal != null)
            return false;
        if (formerProcedureOrgan != null ? !formerProcedureOrgan.equals(aCase.formerProcedureOrgan) : aCase.formerProcedureOrgan != null)
            return false;
        if (collegiateBench != null ? !collegiateBench.equals(aCase.collegiateBench) : aCase.collegiateBench != null)
            return false;
        if (crossExamination != null ? !crossExamination.equals(aCase.crossExamination) : aCase.crossExamination != null)
            return false;
        if (objectionOfCompetency != null ? !objectionOfCompetency.equals(aCase.objectionOfCompetency) : aCase.objectionOfCompetency != null)
            return false;
        if (applyForWithdraw != null ? !applyForWithdraw.equals(aCase.applyForWithdraw) : aCase.applyForWithdraw != null)
            return false;
        if (law != null ? !law.equals(aCase.law) : aCase.law != null) return false;
        if (recheck != null ? !recheck.equals(aCase.recheck) : aCase.recheck != null) return false;
        if (closureWay != null ? !closureWay.equals(aCase.closureWay) : aCase.closureWay != null) return false;
        if (reason != null ? !reason.equals(aCase.reason) : aCase.reason != null) return false;
        if (date != null ? !date.equals(aCase.date) : aCase.date != null) return false;
        if (memberOfTrials != null ? !memberOfTrials.equals(aCase.memberOfTrials) : aCase.memberOfTrials != null)
            return false;
        if (title != null ? !title.equals(aCase.title) : aCase.title != null) return false;
        return subTitle != null ? subTitle.equals(aCase.subTitle) : aCase.subTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (court != null ? court.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (caseNumber != null ? caseNumber.hashCode() : 0);
        result = 31 * result + (typeOfCase != null ? typeOfCase.hashCode() : 0);
        result = 31 * result + (typeOfWrit != null ? typeOfWrit.hashCode() : 0);
        result = 31 * result + (judicialProcedure != null ? judicialProcedure.hashCode() : 0);
        result = 31 * result + (publicProsecution != null ? publicProsecution.hashCode() : 0);
        result = 31 * result + (prosecutions != null ? prosecutions.hashCode() : 0);
        result = 31 * result + (agents != null ? agents.hashCode() : 0);
        result = 31 * result + (respondingParties != null ? respondingParties.hashCode() : 0);
        result = 31 * result + (absenceOfDefendant != null ? absenceOfDefendant.hashCode() : 0);
        result = 31 * result + (openCourt != null ? openCourt.hashCode() : 0);
        result = 31 * result + (natureOfLawsuit != null ? natureOfLawsuit.hashCode() : 0);
        result = 31 * result + (postpone != null ? postpone.hashCode() : 0);
        result = 31 * result + (juvenileCourt != null ? juvenileCourt.hashCode() : 0);
        result = 31 * result + (chargeInfos != null ? chargeInfos.hashCode() : 0);
        result = 31 * result + (majorCause != null ? majorCause.hashCode() : 0);
        result = 31 * result + (minorCause != null ? minorCause.hashCode() : 0);
        result = 31 * result + (caseProcess != null ? caseProcess.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (scopeOfAppeal != null ? scopeOfAppeal.hashCode() : 0);
        result = 31 * result + (formerProcedureOrgan != null ? formerProcedureOrgan.hashCode() : 0);
        result = 31 * result + (collegiateBench != null ? collegiateBench.hashCode() : 0);
        result = 31 * result + (crossExamination != null ? crossExamination.hashCode() : 0);
        result = 31 * result + (objectionOfCompetency != null ? objectionOfCompetency.hashCode() : 0);
        result = 31 * result + (applyForWithdraw != null ? applyForWithdraw.hashCode() : 0);
        result = 31 * result + (law != null ? law.hashCode() : 0);
        result = 31 * result + (recheck != null ? recheck.hashCode() : 0);
        result = 31 * result + (closureWay != null ? closureWay.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (memberOfTrials != null ? memberOfTrials.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subTitle != null ? subTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id='" + id + '\'' +
                ", context=" + context +
                ", court=" + court +
                ", name='" + name + '\'' +
                ", caseNumber='" + caseNumber + '\'' +
                ", typeOfCase='" + typeOfCase + '\'' +
                ", typeOfWrit='" + typeOfWrit + '\'' +
                ", judicialProcedure='" + judicialProcedure + '\'' +
                ", publicProsecution=" + publicProsecution +
                ", prosecutions=" + prosecutions +
                ", agents=" + agents +
                ", respondingParties=" + respondingParties +
                ", absenceOfDefendant=" + absenceOfDefendant +
                ", openCourt=" + openCourt +
                ", natureOfLawsuit='" + natureOfLawsuit + '\'' +
                ", postpone=" + postpone +
                ", juvenileCourt=" + juvenileCourt +
                ", chargeInfos=" + chargeInfos +
                ", majorCause=" + majorCause +
                ", minorCause=" + minorCause +
                ", caseProcess=" + caseProcess +
                ", origin='" + origin + '\'' +
                ", scopeOfAppeal='" + scopeOfAppeal + '\'' +
                ", formerProcedureOrgan='" + formerProcedureOrgan + '\'' +
                ", collegiateBench='" + collegiateBench + '\'' +
                ", crossExamination='" + crossExamination + '\'' +
                ", objectionOfCompetency=" + objectionOfCompetency +
                ", applyForWithdraw=" + applyForWithdraw +
                ", law=" + law +
                ", recheck=" + recheck +
                ", closureWay='" + closureWay + '\'' +
                ", reason='" + reason + '\'' +
                ", date=" + date +
                ", memberOfTrials=" + memberOfTrials +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}
