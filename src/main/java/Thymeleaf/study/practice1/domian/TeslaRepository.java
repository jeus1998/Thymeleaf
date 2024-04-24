package Thymeleaf.study.practice1.domian;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * save
 * update
 * findAll
 * findById
 */

@Repository
public class TeslaRepository {
    private static final Map<Long, Tesla> store = new HashMap<>();
    private static long sequence = 0L;

    public Tesla save(Tesla tesla){
        tesla.setId(sequence++);
        store.put(tesla.getId(), tesla);
        return tesla;
    }

    public List<Tesla> findAll(){
        return new ArrayList<>(store.values());
    }

    public Tesla findById(Long id){
        return store.get(id);
    }

    public Tesla update(Long id, Tesla updateDTO){

        Tesla updateTarget = findById(id);

        updateTarget.setDeliveryWay(updateDTO.getDeliveryWay());
        updateTarget.setSalesMan(updateDTO.getSalesMan());
        updateTarget.setOpen(updateDTO.getOpen());
        updateTarget.setPrice(updateDTO.getPrice());
        updateTarget.setRegions(updateDTO.getRegions());
        updateTarget.setQuantity(updateTarget.getQuantity());
        updateTarget.setCarType(updateDTO.getCarType());

        return updateTarget;
    }


}
