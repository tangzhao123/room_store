package cn.gson.room_store.model.pojos.customers;

import lombok.Data;

import java.io.Serializable;

/**
 * level
 * @author 
 */
@Data
public class Level implements Serializable {
    private Integer levelId;

    private String levelName;

    private static final long serialVersionUID = 1L;
}