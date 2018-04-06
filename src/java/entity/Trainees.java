
package entity;


public class Trainees {
    private int RecordId;
    private trainingInfo traininginfo;
    private EmployeeInfo personInfo;
    private boolean AppConfirm;
    private boolean participateTraining;
    private boolean participateExam;
    private boolean passExam;
    private int ExamMark;

    public Trainees() {
        traininginfo = new trainingInfo();
        personInfo = new EmployeeInfo();
    }

    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int RecordId) {
        this.RecordId = RecordId;
    }

    public trainingInfo getTraininginfo() {
        return traininginfo;
    }

    public void setTraininginfo(trainingInfo traininginfo) {
        this.traininginfo = traininginfo;
    }

    public EmployeeInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(EmployeeInfo personInfo) {
        this.personInfo = personInfo;
    }

    public boolean isParticipateTraining() {
        return participateTraining;
    }

    public void setParticipateTraining(boolean participateTraining) {
        this.participateTraining = participateTraining;
    }

    public boolean isParticipateExam() {
        return participateExam;
    }

    public void setParticipateExam(boolean participateExam) {
        this.participateExam = participateExam;
    }

    public boolean isPassExam() {
        return passExam;
    }

    public void setPassExam(boolean passExam) {
        this.passExam = passExam;
    }

    public int getExamMark() {
        return ExamMark;
    }

    public void setExamMark(int ExamMark) {
        this.ExamMark = ExamMark;
    }

    public boolean isAppConfirm() {
        return AppConfirm;
    }

    public void setAppConfirm(boolean AppConfirm) {
        this.AppConfirm = AppConfirm;
    }
    
    

    
}
