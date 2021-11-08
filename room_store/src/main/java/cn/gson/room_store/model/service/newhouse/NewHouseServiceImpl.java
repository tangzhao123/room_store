package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.mapper.newhouse.NewHouseMapper;
import cn.gson.room_store.model.pojos.newhouse.NewHouse;
import cn.gson.room_store.vo.newhouse.NewHouseSerachVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NewHouseServiceImpl implements NewHouseService {
    @Autowired
    NewHouseMapper newHouseMapper;
    @Override
    public PageInfo<NewHouse> selectFindAll(NewHouseSerachVo newHouseSerachVo) {
        if (newHouseSerachVo.getPageNum()==null){
            newHouseSerachVo.setPageNum(1);
        }
        if(newHouseSerachVo.getPageSize()==null){
            newHouseSerachVo.setPageSize(10);
        }
        System.err.println(newHouseSerachVo);
        PageHelper.startPage(newHouseSerachVo.getPageNum(),newHouseSerachVo.getPageSize());
        return new PageInfo<NewHouse>(newHouseMapper.selectFindAll(newHouseSerachVo));
    }

    @Override
    public int insert(NewHouse record) {
        if(record.getHouseIshide()==null){
            record.setHouseIshide("显示");
        }
        return newHouseMapper.insert(record);
    }

    @Override
    public int updateByAll(NewHouse record) {
        return newHouseMapper.updateByAll(record);
    }

    @Override
    public NewHouse selectByPrimaryKey(Integer houseId) {
        return newHouseMapper.selectByPrimaryKey(houseId);
    }

    @Override
    public List<NewHouse> selectAll() {
        return newHouseMapper.selectAll();
    }

    @Override
    public List<Map> selectMap() {
        return newHouseMapper.selectMap();
    }

    @Override
    public List<NewHouse> selectAllDetails(Integer houseId) {
        return newHouseMapper.selectAllDetails(houseId);
    }


}
