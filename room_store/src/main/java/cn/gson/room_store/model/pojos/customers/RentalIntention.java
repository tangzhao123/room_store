package cn.gson.room_store.model.pojos.customers;

import lombok.Data;

import java.io.Serializable;

/**
 * rental_intention
 * @author 
 */
@Data
public class RentalIntention implements Serializable {
    private Integer rentalId;

    private String rentalName;

    private static final long serialVersionUID = 1L;
}