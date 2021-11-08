package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.pojos.newhouse.HouseType;
import cn.gson.room_store.vo.newhouse.HouseTypeSearchVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface HouseTypeService {
    //新增新房户型
    int insert(HouseType record);
    //户型修改
    int updateByAll(HouseType record);
    //分页查询列表
    PageInfo<HouseType> selectByAll(HouseTypeSearchVo houseTypeSearchVo);
    //连表查询新房名称
//    List<Map> selectMap();
}
