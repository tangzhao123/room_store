package cn.gson.room_store.model.pojos.secondary;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import lombok.Data;

import java.util.Date;

@Data
public class Customers {
    private int customersId;//序号
    private String secondaryNumber;//房源编号
    private String customersName;//经纪人姓名
    private String customersPhone;//经理人电话
    private Date customersDate;//推荐时间
    private int customersState;//跟进状态
    private Rentalhousing rentalHousing;//租房房源
}
