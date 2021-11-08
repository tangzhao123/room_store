package cn.gson.room_store.model.pojos.secondary;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class HandHouse {
    private int houseId; //序号
    private String houseNumber;//公房池编号
    private String secondaryNumber;//房源编号
    private double housePrice;//客源奖励
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm", timezone = "GMT+8")
    private Date houseDate;//进入时间
}
