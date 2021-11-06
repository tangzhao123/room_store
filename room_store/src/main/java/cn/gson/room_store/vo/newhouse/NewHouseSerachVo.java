package cn.gson.room_store.vo.newhouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewHouseSerachVo {
    /*
    * 一共多少页
    * */
    private Integer pageNum;
    /*
    * 每页显示的大小
    * */
    private Integer pageSize;
    /*
    * 关键字
    * */
    private String keyword;
    /**
     * 小区名称
     */
    private String houseName;
    /**
     * 物业类型
     */
    private String houseProperty;
    /**
     * 小区特色
     */
    private String houseCharacteristic;
    /**
     * 参考总价
     */
    private Double houseTotalPrice;
    /**
     * 参考单价
     */
    private Double housePrice;
    /**
     * 建筑面积
     */
    private Integer houseArea;
    /**
     * 小区位置
     */
    private String housePosition;
    /**
     * 销售状态(0：代售，1：在售，2：售罄)
     */
    private Integer houseState;
    /**
     * 楼盘编号
     */
    private Integer houseNumber;
}
