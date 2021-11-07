package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.Customerss;
import cn.gson.room_store.model.pojos.customers.ElMessage;
import cn.gson.room_store.model.service.customers.CustomerssService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Customerss")
public class CustomerssController {

    @Resource
    CustomerssService service;

    @PostMapping("/addCustomerss")
    public ElMessage addCustomerss(@RequestParam("customer") String customer){
        return service.addCustomerss(customer);
    }

    @GetMapping("/allCustomers")
    public List<Customerss> allCustomers(){
        return service.allCustomers();
    }

    @GetMapping("/getallCustomers")
    public Map<String,Object> getallCustomers(@RequestParam("cusId") Integer cusId){
        return service.getallCustomers(cusId);
    }

    @PostMapping("/update")
    public ElMessage update(@RequestBody Customerss customerss){
        return service.update(customerss);
    }

    @GetMapping("/AllCustomersBymaleState")
    public List<Customerss> allCustomersBymaleState(){
        return service.allCustomersBymaleState();
    }
}
