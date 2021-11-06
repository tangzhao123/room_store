package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentalhousingService {

    @Autowired
    RentalhousingMapper rentalhousingMapper;

    public List<Rentalhousing> findAllRentalhousing(){
        return rentalhousingMapper.findAllRentalhousing();
    }
}
