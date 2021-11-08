package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.mapper.newhouse.HouseTypeMapper;
import cn.gson.room_store.model.pojos.newhouse.HouseType;
import cn.gson.room_store.vo.newhouse.HouseTypeSearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HouseTypeServiceImpl implements HouseTypeService {
    @Autowired
    HouseTypeMapper houseTypeMapper;
    @Override
    public int insert(HouseType record) {
        return houseTypeMapper.insert(record);
    }

    @Override
    public int updateByAll(HouseType record) {
       return houseTypeMapper.updateByAll(record);
    }

    @Override
    public PageInfo<HouseType> selectByAll(HouseTypeSearchVo houseTypeSearchVo) {
        if(houseTypeSearchVo.getPageNum()==null){
            houseTypeSearchVo.setPageNum(1);
        }
        if (houseTypeSearchVo.getPageSize()==null){
            houseTypeSearchVo.setPageSize(10);
        }
        PageHelper.startPage(houseTypeSearchVo.getPageNum(),houseTypeSearchVo.getPageSize());
        return new PageInfo<HouseType>(houseTypeMapper.selectByAll(houseTypeSearchVo));
    }

//    @Override
//    public List<Map> selectMap() {
//        List<Map> maps = houseTypeMapper.selectMap();
//        return maps;
//    }
}
