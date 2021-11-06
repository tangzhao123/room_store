package cn.gson.room_store.model.pojos.renthouse;

import lombok.Data;

import java.util.Date;
@Data
/*
* 租房跟进记录
* */
public class Rentalfollowup {
    private int refoNo;
    private String refoImg;
    private String refoName;
    private String refoPhone;
    private String refoWay;
    private String refoType;
    private Date refoDate;
    private Date refoNexttime;
    private int refoRehoNo;
}
