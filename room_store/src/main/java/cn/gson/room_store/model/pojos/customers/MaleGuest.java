package cn.gson.room_store.model.pojos.customers;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * male_guest
 * @author 
 */
@Data
public class MaleGuest implements Serializable {
    private Integer maleId;

    private Long housingOfferPrice;

    private Date maleDate;

    private Integer maleCus;

    private static final long serialVersionUID = 1L;
}