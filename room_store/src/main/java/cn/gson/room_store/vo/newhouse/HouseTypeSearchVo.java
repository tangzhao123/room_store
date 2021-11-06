package cn.gson.room_store.vo.newhouse;

import lombok.Data;

@Data
public class HouseTypeSearchVo {
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
     * 户型名称
     */
    private String typeName;
}
