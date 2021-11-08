package cn.gson.room_store.model.mapper.newhouse;

import cn.gson.room_store.model.pojos.newhouse.HouseType;
import cn.gson.room_store.vo.newhouse.HouseTypeSearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HouseTypeMapper {
    int deleteByPrimaryKey(Integer typeId);
    //新增新房户型
    int insert(HouseType record);

    int insertSelective(HouseType record);

    HouseType selectByPrimaryKey(Integer typeId);
    //户型修改
    int updateByAll(HouseType record);

    int updateByPrimaryKey(HouseType record);
    //分页模糊查询列表
    List<HouseType> selectByAll(HouseTypeSearchVo houseTypeSearchVo);
//    连表查询新房名称
    List<Map> selectList();
}