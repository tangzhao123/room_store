package cn.gson.room_store.model.pojos.secondary;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import lombok.Data;

import java.util.Date;

@Data
public class Customers {
    private int customersId;
    private String secondaryNumber;
    private String customersName;
    private String customersPhone;
    private Date customersDate;
    private int customersState;

    private Rentalhousing rentalhousing;
}
