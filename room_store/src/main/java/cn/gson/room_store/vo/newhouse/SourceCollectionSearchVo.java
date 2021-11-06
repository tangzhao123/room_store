package cn.gson.room_store.vo.newhouse;

import lombok.Data;

@Data
public class SourceCollectionSearchVo {
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
    private String sourceName;
    /**
     * 物业类型
     */
    private String sourceProperty;
    /**
     * 参考单价
     */
    private Double sourcePrice;

    /**
     * 参考总价
     */
    private Double sourceTotalPrice;
}
