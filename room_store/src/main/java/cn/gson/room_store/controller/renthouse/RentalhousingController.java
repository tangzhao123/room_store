package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import cn.gson.room_store.model.pojos.renthouse.VoRentalhousing;
import cn.gson.room_store.model.pojos.secondary.LookRecord;
import cn.gson.room_store.model.service.renthouse.RentalhousingService;
import cn.gson.room_store.model.service.secondary.LookRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房房源Controller
 * */
public class RentalhousingController {

    @Autowired
    RentalhousingService rentalhousingService;

    //模糊查询
    @PostMapping("findRentalhousingMultiple")
    public List<Rentalhousing> findRentalhousingMultiple(@RequestBody VoRentalhousing voRentalhousing){
        String name = voRentalhousing.getName();
        //房源名称name
        String yezhu = voRentalhousing.getYezhu();
        //业主yezhu
        int fyzt = 0;
        if(voRentalhousing.getFyzt().equals("上架")){
            fyzt = 1;
        }else if(voRentalhousing.getFyzt().equals("下架")){
            fyzt = 2;
        }
        //房源状态fyzt
        String [] zhifus = new String[]{};
        if(voRentalhousing.getZhifus() != ""){
            zhifus = voRentalhousing.getZhifus().split(",");
        }
        //支付方式zhifus
        String [] biaoqians = new String[]{};
        if(voRentalhousing.getBiaoqians() != ""){
            biaoqians = voRentalhousing.getBiaoqians().split(",");
        }
        //标签biaoqians
        String [] leixings = new String[]{};
        if(voRentalhousing.getLeixings() != ""){
            leixings = voRentalhousing.getLeixings().split(",");
        }
        //房屋类型leixings
        String [] zujins = new String[]{};
        double xiao = 0.0;
        double da = -100;
        if(voRentalhousing.getZujins() != ""){
            zujins = voRentalhousing.getZujins().split(",");
            if(zujins.length != 2){
                zujins = new String[]{};
            }else{
                if(Double.parseDouble(zujins[0]) > Double.parseDouble(zujins[1])){
                    da = Double.parseDouble(zujins[0]);
                    xiao = Double.parseDouble(zujins[1]);
                }else{
                    da = Double.parseDouble(zujins[1]);
                    xiao = Double.parseDouble(zujins[0]);
                }
            }
        }
        //租金大小da xiao
        String [] jines = new String[]{};
        if(voRentalhousing.getJines() != ""){
            jines = voRentalhousing.getJines().split(",");
        }
        ArrayList<int []> list = new ArrayList();
        for(int i =0; i < jines.length ; i++){
            int [] jines1 = new int[]{};
            String [] strings = jines[i].split("-");
            jines1 = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
            list.add(jines1);
        }
        //租金list
        String [] quyus = new String[]{};
        if(voRentalhousing.getQuyus() != ""){
            quyus = voRentalhousing.getQuyus().split(",");
        }
        //区域quyus

//        name,yezhu,fyzt,zhifus,biaoqians,leixings,xiao,da,list,quyus
        return rentalhousingService.findRentalhousingMultiple(name,yezhu,fyzt,zhifus,biaoqians,leixings,xiao,da,list,quyus);
    }

    //修改租房房源
    @PostMapping("updateRentalhousingByNumber")
    public void updateRentalhousingByNumber(@RequestBody Rentalhousing rentalhousing){
        rentalhousingService.updateRentalhousingByNumber(rentalhousing);
    }

    //    编号查询租房房源
    @RequestMapping("findRentalhousingByNumber")
    public List<Rentalhousing> findRentalhousingByNumber(String param){
        return rentalhousingService.findRentalhousingByNumber(param);
    }

    //查询所有租房房源
    @RequestMapping("findAllRentalhousing")
    public List<Rentalhousing> findAllRentalhousing(){
        return rentalhousingService.findAllRentalhousing();
    }

    //新增租房房源
    @PostMapping("insertRentalhousing")
    public void insertRentalhousing(@RequestBody Rentalhousing rentalhousing){
        rentalhousingService.insertRentalhousing(rentalhousing);
    }

    //    修改租房房源上下架状态
    @RequestMapping("updateRentalhousingRehoShelfByNumber")
    public void updateRentalhousingRehoShelfByNumber(int rehoShelf, String rehoNumber){
        rentalhousingService.updateRentalhousingRehoShelfByNumber(rehoShelf,rehoNumber);
    }
}
