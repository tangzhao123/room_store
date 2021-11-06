package cn.gson.room_store.model.mapper.newhouse;

import cn.gson.room_store.model.pojos.newhouse.NewHouse;
import cn.gson.room_store.vo.newhouse.NewHouseSerachVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NewHouseMapper {
    int deleteByPrimaryKey(Integer houseId);
//新增
    int insert(NewHouse record);

    int insertSelective(NewHouse record);
//根据id查询数据
    NewHouse selectByPrimaryKey(Integer houseId);
//修改列表
    int updateByAll(NewHouse record);

    int updateByPrimaryKey(NewHouse record);
//分页模糊查询列表
    List<NewHouse> selectFindAll(NewHouseSerachVo newHouseSerachVo);
}