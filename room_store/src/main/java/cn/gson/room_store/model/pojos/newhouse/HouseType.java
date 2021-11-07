package cn.gson.room_store.model.pojos.newhouse;

import java.io.Serializable;
import lombok.Data;

/**
 * house_type
 * @author 
 */
@Data
public class HouseType implements Serializable {
    /**
     * 户型id
     */
    private Integer typeId;

    /**
     * 户型名称
     */
    private String typeName;

    /**
     * 户型结构
     */
    private String typeStructure;

    /**
     * 面积
     */
    private Integer typeArea;

    /**
     * 户型标签
     */
    private String typeLabel;

    /**
     * 户型图
     */
    private String typeImg;

    /**
     * 户型描述
     */
    private String typeDescribe;
    /*
    * 室
    * */
    private String typeRoom;
    /*
     * 厨
     * */
    private String typeKitchen;
    /*
     * 厅
     * */
    private String typeOffice;
    /*
     * 卫
     * */
    private String typeGuard;

    private static final long serialVersionUID = 1L;
}