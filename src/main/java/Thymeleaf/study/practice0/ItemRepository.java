package Thymeleaf.study.practice0;

import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class ItemRepository {
    private Map<Long, Item> store = new HashMap<>();
    private long Id = 1;

    // 저장
    Item save(String name, int price){
        Item item = new Item(name, price);
        item.setId(Id++);
        store.put(item.getId(), item);
        return item;
    }

    // 전체 조회
    List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    // 단일 조회
    Item findById(long Id){
        Item item = store.get(Id);
        return item;
    }

}
