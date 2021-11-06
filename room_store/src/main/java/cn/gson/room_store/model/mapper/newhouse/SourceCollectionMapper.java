package cn.gson.room_store.model.mapper.newhouse;

import cn.gson.room_store.model.pojos.newhouse.SourceCollection;
import cn.gson.room_store.vo.newhouse.SourceCollectionSearchVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SourceCollectionMapper {
    int deleteByPrimaryKey(Integer sourceId);
    //新增新房采集数据
    int insert(SourceCollection record);

    int insertSelective(SourceCollection record);
    //根据id查询新房采集信息
    SourceCollection selectByPrimaryKey(Integer sourceId);
    //修改新房采集信息
    int updateByAll(SourceCollection record);

    int updateByPrimaryKey(SourceCollection record);
    //分页模糊查询
    List<SourceCollection> selectAll(SourceCollectionSearchVo sourceCollectionSearchVo);
}