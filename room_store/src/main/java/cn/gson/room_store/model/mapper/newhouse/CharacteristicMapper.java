package cn.gson.room_store.model.mapper.newhouse;

import cn.gson.room_store.model.pojos.newhouse.Characteristic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CharacteristicMapper {
    //查询所有特色
      List<Characteristic> selectAll(Characteristic characteristic);
}
