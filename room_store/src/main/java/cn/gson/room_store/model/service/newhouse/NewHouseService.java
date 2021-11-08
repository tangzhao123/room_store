package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.pojos.newhouse.NewHouse;
import cn.gson.room_store.vo.newhouse.NewHouseSerachVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NewHouseService {
    //分页模糊查询
    PageInfo<NewHouse> selectFindAll(NewHouseSerachVo newHouseSerachVo);
    //插入数据
    int insert(NewHouse record);
    //修改列表
    int updateByAll(NewHouse record);
    //根据id查询数据
    NewHouse selectByPrimaryKey(Integer houseId);

    List<NewHouse> selectAll();
}
