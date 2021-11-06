package cn.gson.room_store.model.pojos.newhouse;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * source_collection
 * @author 
 */
@Data
public class SourceCollection implements Serializable {
    /**
     * 房源采集id
     */
    private Integer sourceId;

    /**
     * 小区名称
     */
    private String sourceName;

    /**
     * 小区位置
     */
    private String sourcePosition;

    /**
     * 小区地址
     */
    private String sourceAddress;

    /**
     * 物业类型
     */
    private String sourceProperty;

    /**
     * 建筑面积
     */
    private Integer sourceArea;

    /**
     * 小区特色
     */
    private String sourceCharacteristic;

    /**
     * 参考单价
     */
    private Double sourcePrice;

    /**
     * 参考总价
     */
    private Double sourceTotalPrice;

    /**
     * 所属开发商
     */
    private String sourceDeveloper;

    /**
     * 采集时间
     */
    private Date sourceTime;

    /**
     * 用户编号
     */
    private Integer sourceUsersNo;

    private static final long serialVersionUID = 1L;
}