package cn.gson.room_store.model.pojos.secondary;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LookRecord {
    private int lookId ; //序号
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lookMake;//预约时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lookEnd;//结束时间
    private String lookName;//客户姓名
    private String lookPhone;//客户联系方式
    private String secondaryNumber;//房源
    private String secondaryVillage;//小区名称
    private String lookTitle;//带看记录
    private String lookPicture;//带看图片
    private String lookState;//带看状态

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

    public String getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setSecondaryNumber(String secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    public String getLookTitle() {
        return lookTitle;
    }

    public void setLookTitle(String lookTitle) {
        this.lookTitle = lookTitle;
    }

    public String getLookPicture() {
        return lookPicture;
    }

    public void setLookPicture(String lookPicture) {
        this.lookPicture = lookPicture;
    }

    public String getLookState() {
        return lookState;
    }

    public void setLookState(String lookState) {
        this.lookState = lookState;
    }

    public String getSecondaryVillage() {
        return secondaryVillage;
    }

    public void setSecondaryVillage(String secondaryVillage) {
        this.secondaryVillage = secondaryVillage;
    }

    @Override
    public String toString() {
        return "LookRecord{" +
                "lookId=" + lookId +
                ", lookMake=" + lookMake +
                ", lookEnd=" + lookEnd +
                ", lookName='" + lookName + '\'' +
                ", lookPhone='" + lookPhone + '\'' +
                ", secondaryNumber='" + secondaryNumber + '\'' +
                ", secondaryVillage='" + secondaryVillage + '\'' +
                ", lookTitle='" + lookTitle + '\'' +
                ", lookPicture='" + lookPicture + '\'' +
                ", lookState='" + lookState + '\'' +
                '}';
    }
}
