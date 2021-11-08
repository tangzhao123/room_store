package cn.gson.room_store.model.pojos.customers;

import lombok.Data;

import java.io.Serializable;

/**
 * state
 * @author 
 */
@Data
public class State implements Serializable {
    private Integer stateId;

    private String stateName;

    private static final long serialVersionUID = 1L;
}