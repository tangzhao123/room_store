package cn.gson.room_store.model.pojos.customers;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * demand_model
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class DemandModelKey implements Serializable {
    private Integer modelId;

    private Integer demandId;

    private static final long serialVersionUID = 1L;

}