package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.pojos.newhouse.SourceCollection;
import cn.gson.room_store.vo.newhouse.SourceCollectionSearchVo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;


public interface SourceCollectionService {
    //分页查询
    PageInfo<SourceCollection> selectAll(SourceCollectionSearchVo sourceCollectionSearchVo);
    //新增新房采集数据
    int insert(SourceCollection record);
    //修改新房采集信息
    int updateByAll(SourceCollection record);
    //根据id查询新房采集信息
    SourceCollection selectByPrimaryKey(Integer sourceId);
}
