package cn.gson.room_store.model.pojos.customers;

import java.io.Serializable;
import lombok.Data;

/**
 * housing_recommended
 * @author 
 */
@Data
public class HousingRecommended implements Serializable {
    private Integer recId;

    private Integer recCus;

    private Integer recHou;

    private Integer recSec;

    private static final long serialVersionUID = 1L;
}