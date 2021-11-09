package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.mapper.newhouse.CharacteristicMapper;
import cn.gson.room_store.model.pojos.newhouse.Characteristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CharacteristicServiceImpl implements CharacteristicService {
    @Autowired
    CharacteristicMapper characteristicMapper;
    @Override
    public List<Characteristic> selectAll() {
        return characteristicMapper.selectAll();
    }
}
