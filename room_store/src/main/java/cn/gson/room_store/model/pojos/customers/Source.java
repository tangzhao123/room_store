package cn.gson.room_store.model.pojos.customers;

import lombok.Data;

import java.io.Serializable;

/**
 * source
 * @author 
 */
@Data
public class Source implements Serializable {
    private Integer souId;

    private String souName;

    private static final long serialVersionUID = 1L;
}