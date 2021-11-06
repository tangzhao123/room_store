package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Multifileimage;
import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/*
* 多文件图片Mapper
* */
public interface MultifileimageMapper {

//    新增多文件图片
    void insertMultifileimage(Multifileimage multifileimage);

//    删除多文件图片
    void deleteMultifileimageByMuimFangyuanno(String muimFangyuanno);
}
