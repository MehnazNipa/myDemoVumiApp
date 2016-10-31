package appmodel;

public class CozListReportModel {
    int caseId ;
    String caseNo = "";
    String dateOfFiling = "";
    String nextSetDate = "";
    String currentCaseStatus = "";
    String caseType = "";
    String caseClass = "";
    String courtName = "";
    String branchNo = "";
    String division = "";


    public CozListReportModel() {
    }


    public CozListReportModel(int caseId, String caseNo, String dateOfFiling, String nextSetDate, String currentCaseStatus, String caseType, String caseClass, String courtName, String branchNo, String division) {
        this.caseId = caseId;
        this.caseNo = caseNo;
        this.dateOfFiling = dateOfFiling;
        this.nextSetDate = nextSetDate;
        this.currentCaseStatus = currentCaseStatus;
        this.caseType = caseType;
        this.caseClass = caseClass;
        this.courtName = courtName;
        this.branchNo = branchNo;
        this.division = division;
    }

    public CozListReportModel(String caseNo, String dateOfFiling, String nextSetDate, String currentCaseStatus, String caseType, String caseClass, String courtName, String branchNo, String division) {
        this.caseNo = caseNo;
        this.dateOfFiling = dateOfFiling;
        this.nextSetDate = nextSetDate;
        this.currentCaseStatus = currentCaseStatus;
        this.caseType = caseType;
        this.caseClass = caseClass;
        this.courtName = courtName;
        this.branchNo = branchNo;
        this.division = division;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getDateOfFiling() {
        return dateOfFiling;
    }

    public void setDateOfFiling(String dateOfFiling) {
        this.dateOfFiling = dateOfFiling;
    }

    public String getNextSetDate() {
        return nextSetDate;
    }

    public void setNextSetDate(String nextSetDate) {
        this.nextSetDate = nextSetDate;
    }

    public String getCurrentCaseStatus() {
        return currentCaseStatus;
    }

    public void setCurrentCaseStatus(String currentCaseStatus) {
        this.currentCaseStatus = currentCaseStatus;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseClass() {
        return caseClass;
    }

    public void setCaseClass(String caseClass) {
        this.caseClass = caseClass;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
