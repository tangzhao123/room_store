package cn.gson.room_store.model.pojos.customers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * demand_use
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class DemandUseKey implements Serializable {
    private Integer useId;

    private Integer demandId;

    private static final long serialVersionUID = 1L;
}