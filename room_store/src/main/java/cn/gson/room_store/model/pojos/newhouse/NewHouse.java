package cn.gson.room_store.model.pojos.newhouse;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * new_house
 * @author 
 */
@Data
public class NewHouse implements Serializable {
    /**
     * 新房id
     */
    private Integer houseId;

    /**
     * 小区名称
     */
    private String houseName;

    /**
     * 小区位置
     */
    private String housePosition;

    /**
     * 小区地址
     */
    private String houseAddress;

    /**
     * 物业类型
     */
    private String houseProperty;

    /**
     * 建筑面积
     */
    private Integer houseArea;

    /**
     * 小区特色
     */
    private String houseCharacteristic;

    /**
     * 参考单价
     */
    private Double housePrice;

    /**
     * 参考总价
     */
    private Double houseTotalPrice;

    /**
     * 所属开发商
     */
    private String houseDeveloper;

    /**
     * 销售证号
     */
    private String houseCertificate;

    /**
     * 发证时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date houseCertificateTime;

    /**
     * 销售状态(0：代售，1：在售，2：售罄)
     */
    private Integer houseState;

    /**
     * 请上传房源图片
     */
    private String houseImg;

    /**
     * 前台是否显示(0:显示，1：隐藏)
     */
    private Integer houseIshide;

    /**
     * 楼盘编号
     */
    private Integer houseNumber;

    /**
     * 户型id
     */
    private Integer typeId;

    /**
     * 特点id
     */
    private Integer charaId;

    /**
     * 好房id
     */
    private Integer goodId;

    /**
     * 用户编号
     */
    private Integer houseUsersNo;

    private static final long serialVersionUID = 1L;
}