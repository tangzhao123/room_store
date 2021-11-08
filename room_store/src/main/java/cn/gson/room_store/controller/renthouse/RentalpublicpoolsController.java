package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import cn.gson.room_store.model.pojos.renthouse.Rentalpublicpools;
import cn.gson.room_store.model.pojos.renthouse.VoRentalPublicpools;
import cn.gson.room_store.model.pojos.secondary.Customers;
import cn.gson.room_store.model.service.renthouse.RentalownerService;
import cn.gson.room_store.model.service.renthouse.RentalpublicpoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房公房池Controller
 * */
public class RentalpublicpoolsController {
    @Autowired
    RentalpublicpoolsService rentalpublicpoolsService;


    @PostMapping("findAllRentalpublicpools")
    public List<Rentalpublicpools> findAllRentalpublicpools(@RequestBody VoRentalPublicpools voRentalPublicpools){
        System.out.println(voRentalPublicpools);
        String chegshi = voRentalPublicpools.getChengshi();

        String xiaoqu = voRentalPublicpools.getXiaoqu();

        String [] zhuangxiu = new String[]{};
        if(voRentalPublicpools.getZhuangxiu() != ""){
            zhuangxiu = voRentalPublicpools.getZhuangxiu().split(",");
        }

        String [] je = new String[]{};
        double minje = 0.0;
        double maxje = -100;
        if(voRentalPublicpools.getJe() != ""){
            je = voRentalPublicpools.getJe().split(",");
            if(je.length != 2){
                je = new String[]{};
            }else{
                if(Double.parseDouble(je[0]) > Double.parseDouble(je[1])){
                    maxje = Double.parseDouble(je[0]);
                    minje = Double.parseDouble(je[1]);
                }else{
                    maxje = Double.parseDouble(je[1]);
                    minje = Double.parseDouble(je[0]);
                }
            }
        }

        String [] m2 = new String[]{};
        double minm2 = 0.0;
        double maxm2 = -100;
        if(voRentalPublicpools.getM2() != ""){
            m2 = voRentalPublicpools.getM2().split(",");
            if(m2.length != 2){
                m2 = new String[]{};
            }else{
                if(Double.parseDouble(m2[0]) > Double.parseDouble(m2[1])){
                    maxm2 = Double.parseDouble(m2[0]);
                    minm2 = Double.parseDouble(m2[1]);
                }else{
                    maxm2 = Double.parseDouble(m2[1]);
                    minm2 = Double.parseDouble(m2[0]);
                }
            }
        }
        return rentalpublicpoolsService.findAllRentalpublicpools(maxm2,minm2,maxje,minje,chegshi,xiaoqu,zhuangxiu);
    }

    //    查询租房公房池推荐客源
    @RequestMapping("findRentalpublicpoolsAndCustomers")
    public List<Customers> findRentalpublicpoolsAndCustomers(String param){
        return rentalpublicpoolsService.findRentalpublicpoolsAndCustomers(param);
    }

    //    租房公房池推荐客源 完成跟进、无效
    @RequestMapping("updateRentalpublicpoolsKYCZ")
    public void updateRentalpublicpoolsKYCZ(int customersState, String secondaryNumber){
        rentalpublicpoolsService.updateRentalpublicpoolsKYCZ(customersState,secondaryNumber);
    }

    //    新增公房池推荐客源
    @PostMapping("insertRentalpublicpoolsKy")
    public void insertRentalpublicpoolsKy(@RequestBody Customers customers){
        rentalpublicpoolsService.insertRentalpublicpoolsKy(customers);
    }

    //    移出公房池
    @RequestMapping("deleteRentalpublicpoolsByReppRehoNo")
    public void deleteRentalpublicpoolsByReppRehoNo(String reppRehoNo){
        rentalpublicpoolsService.deleteRentalpublicpoolsByReppRehoNo(reppRehoNo);
    }

    //    移入公房池
    @PostMapping("insertRentalpublicpools")
    public void insertRentalpublicpools(@RequestBody Rentalpublicpools rentalpublicpools){
        rentalpublicpoolsService.insertRentalpublicpools(rentalpublicpools);
    }
}
