package cn.gson.room_store.model.pojos.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * customerss
 * @author 
 */
@Validated
@Data
@NonNull
@AllArgsConstructor
@NoArgsConstructor
public class Customerss implements Serializable {
    private Integer cusId;

    private Integer souId;

    private Integer rentalId;

    private Integer stateId;

    private Integer levelId;

    private String cusName;

    private String cusSex;

    private String cusPhone;

    private String cusStandby;

    private String cusNote;

    private String maleState;

    private Integer demanId;

    private Integer userId;

    private Timestamp cusEntry;

    private Level level;//等级

    private RentalIntention rentalIntention;//客户意向

    private Source source;//来源

    private State state;//状态

    private  DemandIntention demandIntention;//需求


    private static final long serialVersionUID = 1L;
}