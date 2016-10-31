package appmodel;



public class Information {
    String mDate = "";
    String mSubject = "";
    String mTime = "";

    public Information(){
    }

    public Information(String eDate, String eSubject, String eTime){
        this.mDate = eDate;
        this.mSubject = eSubject;
        this.mTime = eTime;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String eDate) {
        this.mDate = eDate;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String eSubject) {
        this.mSubject = eSubject;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String eTime) {
        this.mTime = eTime;
    }

}
