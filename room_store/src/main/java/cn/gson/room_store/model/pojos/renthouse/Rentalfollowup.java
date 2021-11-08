package cn.gson.room_store.model.pojos.renthouse;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date refoDate;
    @JsonFormat(pattern = "YYYY-MM-dd",timezone = "GMT+8")
    private Date refoNexttime;
    private int refoRehoNo;
    private String refoNeirong;
}
