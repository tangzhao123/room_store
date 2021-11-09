package cn.gson.room_store.model.service.newhouse;

import cn.gson.room_store.model.mapper.newhouse.SourceCollectionMapper;
import cn.gson.room_store.model.pojos.newhouse.SourceCollection;
import cn.gson.room_store.vo.newhouse.SourceCollectionSearchVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class SourceCollectionServiceImpl implements SourceCollectionService {
    @Autowired
    SourceCollectionMapper sourceCollectionMapper;
    @Override
    public PageInfo<SourceCollection> selectAll(SourceCollectionSearchVo sourceCollectionSearchVo) {
        if(sourceCollectionSearchVo.getPageNum()==null){
            sourceCollectionSearchVo.setPageNum(1);
        }
        if(sourceCollectionSearchVo.getPageSize()==null){
            sourceCollectionSearchVo.setPageSize(10);
        }
        PageHelper.startPage(sourceCollectionSearchVo.getPageNum(),sourceCollectionSearchVo.getPageSize());
        return new PageInfo<SourceCollection>(sourceCollectionMapper.selectAll(sourceCollectionSearchVo));
    }

    @Override
    public int insert(SourceCollection record) {
        if(record.getSourceTime()==null){
            record.setSourceTime(new Date());
        }
        return sourceCollectionMapper.insert(record);
    }

    @Override
    public int updateByAll(SourceCollection record) {
        return sourceCollectionMapper.updateByAll(record);
    }

    @Override
    public SourceCollection selectByPrimaryKey(Integer sourceId) {
        return sourceCollectionMapper.selectByPrimaryKey(sourceId);
    }
}
