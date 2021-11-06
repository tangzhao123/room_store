package cn.gson.room_store.model.pojos.renthouse;

import lombok.Data;

import java.util.Date;

@Data
/*
* 租房房源
* */
public class Rentalhousing {
    private int rehoNo;
    private String rehoNumber;
    private String rehoSite;
    private String rehoCommunity;
    private String rehoUnit;
    private String rehoBuilding;
    private String rehoFloornumber;
    private String rehoLivefewfloor;
    private String rehoRoomnumber;
    private int rehoCoveredarea;
    private int rehoInsidespace;
    private String rehoHousetype;
    private String rehoOrientation;
    private String rehoElevator;
    private String rehoHousingtypes;
    private String rehoLadder;
    private String rehoHouseholds;
    private String rehoCertcateCover;
    private String rehoCertcateBackcover;
    private String rehoCertcateQsy;
    private String rehoCertcateFamilypage;
    private String rehoRentouttitle;
    private double rehoRent;
    private String rehoPayway;
    private String rehoFitmenttype;
    private String rehoShortestlease;
    private String rehoSuppfacility;
    private String rehoHouslabel;
    private String rehoHousremark;
    private Date rehoDate;
    private int rehoShelf;
    private int rehoGfczt;
    private int rehoGoodRoom;
    private int rehoUsersNo;
}
