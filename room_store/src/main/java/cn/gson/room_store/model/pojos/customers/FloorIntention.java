package cn.gson.room_store.model.pojos.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

/**
 * floor_intention
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class FloorIntention implements Serializable {
    private Integer floorId;

    private String floorName;

    private List<DemandIntention> demandIntentions;

    private static final long serialVersionUID = 1L;
}