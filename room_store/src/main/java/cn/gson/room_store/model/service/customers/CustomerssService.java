package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.*;
import cn.gson.room_store.model.pojos.customers.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
@Transactional
public class CustomerssService {

    @Resource
    CustomerssMapper customerssMapper;

    @Resource
    DemandIntentionMapper demandIntentionMapper;

    @Resource
    DemandModelMapper demandModelMapper;

    @Resource
    DemandUseMapper demandUseMapper;

    @Resource
    DemandDecorateMapper demandDecorateMapper;

    @Resource
    DemandFloorMapper demandFloorMapper;
    /**
     * 新增客源
     * @param customer
     */
    public ElMessage addCustomerss(String customer) {
        JSONObject o= JSONObject.parseObject(customer);//转换Object
        List<Integer> SelectedModelIntentionList = JSONArray.parseArray(o.get("SelectedModelIntentionList").toString(), Integer.class);//转换数组--户型意向
        List<Integer> SelectedUseIntentionList = JSONArray.parseArray(o.get("SelectedUseIntentionList").toString(), Integer.class);//转换数组--用途意向
        List<Integer> SelectedDecorateIntentionList = JSONArray.parseArray(o.get("SelectedDecorateIntentionList").toString(), Integer.class);//转换数组--装修类型意向
        List<Integer> SelectedFloorIntentionList = JSONArray.parseArray(o.get("SelectedDecorateIntentionList").toString(), Integer.class);//转换数组--楼层意向
        Customerss customers= JSONObject.toJavaObject((JSON) o.get("customers"),Customerss.class);//转换对象--客源
        DemandIntention demand= JSONObject.toJavaObject((JSON) o.get("demand"),DemandIntention.class);//转换对象--需求意向
        System.out.println("状态"+customers.getMaleState());
        if(customers.getMaleState()==null || customers.getMaleState().equals("")){
            customers.setMaleState("不在公客池");
        }
        if(customers.getCusEntry()==null){
            customers.setCusEntry(new Timestamp(new Date().getTime()));
        }
        int i=-1;
        if(customers.getCusId()!=null){
            demandIntentionMapper.updateByPrimaryKeySelective(demand);
            i=customerssMapper.updateByPrimaryKeySelective(customers);
            demandModelMapper.deleteBydemandId(demand.getDemandId());
            demandUseMapper.deleteBydemandId(demand.getDemandId());
            demandDecorateMapper.deleteBydemandId(demand.getDemandId());
            demandFloorMapper.deleteBydemandId(demand.getDemandId());
        }else{
             demandIntentionMapper.insert(demand);
             i= customerssMapper.insertSelective(customers);
        }
        if(customers.getDemanId()==null){
            customers.setDemanId(demand.getDemandId());
        }
            List<DemandModelKey> list=new ArrayList<>();
            for(Integer p : SelectedModelIntentionList) {
                DemandModelKey demandModelKey = new DemandModelKey();
                demandModelKey.setDemandId(demand.getDemandId());
                demandModelKey.setModelId(p);
                list.add(demandModelKey);
            }
            if(!(list.isEmpty())){
                demandModelMapper.batchAdd(list);
            }

        List<DemandUseKey> list2=new ArrayList<>();
        for(Integer p : SelectedUseIntentionList) {
            DemandUseKey demandUseKey = new DemandUseKey();
            demandUseKey.setUseId(p);
            demandUseKey.setDemandId(demand.getDemandId());
            list2.add(demandUseKey);
        }
        if(!(list2.isEmpty())){
            demandUseMapper.batchAdd(list2);
        }

        List<DemandDecorateKey> list3=new ArrayList<>();
        for(Integer p : SelectedDecorateIntentionList) {
            DemandDecorateKey decorateKey = new DemandDecorateKey();
            decorateKey.setDecorId(p);
            decorateKey.setDemandId(demand.getDemandId());
            list3.add(decorateKey);
        }
        if(!(list3.isEmpty())){
            demandDecorateMapper.batchAdd(list3);
        }

        List<DemandFloorKey> list4=new ArrayList<>();
        for(Integer p : SelectedFloorIntentionList) {
            DemandFloorKey demandFloorKey = new DemandFloorKey();
            demandFloorKey.setFloorId(p);
            demandFloorKey.setDemandId(demand.getDemandId());
            list4.add(demandFloorKey);
        }
        if(!(list4.isEmpty())){
            demandFloorMapper.batchAdd(list4);
        }
        ElMessage elMessage=new ElMessage();
        if(i>0){
            elMessage.setMessage("录入成功！");
            elMessage.setType("success");
        }
        return elMessage;
    }

    /**
     * 根据用户查询该下的客源
     * @return
     */
    public List<Customerss> allCustomers(Integer userId){
        return customerssMapper.allCustomers(userId);
    }

    public Map<String,Object> getallCustomers(Integer cusId) {
        Map<String,Object> map=new HashMap<>();
        Customerss customerss = customerssMapper.selectByPrimaryKey(cusId);
        map.put("customers",customerss);
        DemandIntention demandIntention = demandIntentionMapper.selectByPrimaryKey(customerss.getDemanId());
        map.put("demand",demandIntention);
        List<Integer> SelectedModelIntentionList = demandModelMapper.SelectedModelIntentionList(customerss.getDemanId());
        map.put("SelectedModelIntentionList",SelectedModelIntentionList);
        List<Integer> SelectedUseIntentionList = demandUseMapper.SelectedUseIntentionList(customerss.getDemanId());
        map.put("SelectedUseIntentionList",SelectedUseIntentionList);
        List<Integer> SelectedDecorateIntentionList = demandDecorateMapper.SelectedDecorateIntentionList(customerss.getDemanId());
        map.put("SelectedDecorateIntentionList",SelectedDecorateIntentionList);
        List<Integer> SelectedFloorIntentionList = demandFloorMapper.SelectedFloorIntentionList(customerss.getDemanId());
        map.put("SelectedFloorIntentionList",SelectedFloorIntentionList);
        return map;

    }

    public ElMessage update(Customerss customerss) {
        int i = customerssMapper.updateByPrimaryKeySelective(customerss);
        ElMessage elMessage=new ElMessage();
        if(i>0){
            elMessage.setMessage("修改成功！");
            elMessage.setType("success");
        }
        return elMessage;
    }

    public List<Customerss> allCustomersBymaleState(){
        return customerssMapper.allCustomersBymaleState();
    }
}
