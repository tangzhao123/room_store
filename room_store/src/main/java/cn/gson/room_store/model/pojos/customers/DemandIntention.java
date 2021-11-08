package cn.gson.room_store.model.pojos.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

/**
 * demand_intention
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class DemandIntention implements Serializable {
    private Integer demandId;

    private String demandArea;

    private String villageName;

    private Double minPrice;

    private Double maxPrice;

    private Double maxArea;

    private Double minArea;

    private List<ModelIntention> demandModelKeys;//户型

    private List<UseIntention> demandUseKeys;//用途

    private List<DecorateIntention> demandDecorateKeys;//装修类型

    private List<FloorIntention> demandFloorKeys;//楼层

    private static final long serialVersionUID = 1L;
}