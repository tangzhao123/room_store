package cn.gson.room_store.model.pojos.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;

/**
 * decorate_intention
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class DecorateIntention implements Serializable {
    private Integer decorId;

    private String decorName;

    private List<DemandIntention> demandIntentions;

    private static final long serialVersionUID = 1L;
}