package cn.gson.room_store.model.pojos.renthouse;

import lombok.Data;

import java.util.Date;

@Data
/*
* 租房公房池信息
* */
public class Rentalpublicpools {
    private int reppNo;
    private int reppRehoNo;
    private double reppMoney;
    private Date reppDate;
}
