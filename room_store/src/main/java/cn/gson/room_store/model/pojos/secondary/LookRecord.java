package cn.gson.room_store.model.pojos.secondary;

import java.util.Date;

public class LookRecord {
    private int lookId ;
    private Date lookMake;
    private Date lookEnd;
    private String lookName;
    private String lookPhone;
    private int secondaryNumber;
    private String lookTitle;
    private int lookPicture;
    private String lookState;

    public int getLookId() {
        return lookId;
    }

    public void setLookId(int lookId) {
        this.lookId = lookId;
    }

    public Date getLookMake() {
        return lookMake;
    }

    public void setLookMake(Date lookMake) {
        this.lookMake = lookMake;
    }

    public Date getLookEnd() {
        return lookEnd;
    }

    public void setLookEnd(Date lookEnd) {
        this.lookEnd = lookEnd;
    }

    public String getLookName() {
        return lookName;
    }

    public void setLookName(String lookName) {
        this.lookName = lookName;
    }

    public String getLookPhone() {
        return lookPhone;
    }

    public void setLookPhone(String lookPhone) {
        this.lookPhone = lookPhone;
    }

    public int getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setSecondaryNumber(int secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    public String getLookTitle() {
        return lookTitle;
    }

    public void setLookTitle(String lookTitle) {
        this.lookTitle = lookTitle;
    }

    public int getLookPicture() {
        return lookPicture;
    }

    public void setLookPicture(int lookPicture) {
        this.lookPicture = lookPicture;
    }

    public String getLookState() {
        return lookState;
    }

    public void setLookState(String lookState) {
        this.lookState = lookState;
    }

    @Override
    public String toString() {
        return "LookRecord{" +
                "lookId=" + lookId +
                ", lookMake=" + lookMake +
                ", lookEnd=" + lookEnd +
                ", lookName='" + lookName + '\'' +
                ", lookPhone='" + lookPhone + '\'' +
                ", secondaryNumber=" + secondaryNumber +
                ", lookTitle='" + lookTitle + '\'' +
                ", lookPicture=" + lookPicture +
                ", lookState='" + lookState + '\'' +
                '}';
    }
}
