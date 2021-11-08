package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.HousingRecommendedMapper;
import cn.gson.room_store.model.pojos.customers.ElMessage;
import cn.gson.room_store.model.pojos.customers.HousingRecommended;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HousingRecommendedService {

    @Resource
    HousingRecommendedMapper mapper;

    public ElMessage batchAdd(String hu){
        JSONObject o= JSONObject.parseObject(hu);//转换Object
        List<Integer> choose = JSONArray.parseArray(o.get("choose").toString(), Integer.class);//转换数组--二手房源
        Integer cusId = Integer.parseInt(o.get("cusId").toString());
        ElMessage elMessage=new ElMessage();
        if(choose.isEmpty()==false){
            List<HousingRecommended> list=new ArrayList<>();
            for(Integer p : choose){
                HousingRecommended housingRecommended=new HousingRecommended();
                housingRecommended.setRecCus(cusId);
                housingRecommended.setRecSec(p);
                list.add(housingRecommended);
            }
            System.out.println("数组"+list);
            int i = mapper.batchAdd(list);
            if(i>0){
                elMessage.setType("success");
                elMessage.setMessage("录入成功！");
            }
        }
        return elMessage;
    }
}
