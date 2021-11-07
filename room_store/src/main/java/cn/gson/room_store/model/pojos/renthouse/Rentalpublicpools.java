package cn.gson.room_store.model.pojos.renthouse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
/*
* 租房公房池信息
* */
public class Rentalpublicpools {
    private int reppNo;
    private String reppRehoNo;
    private double reppMoney;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date reppDate;
}
