package Thymeleaf.study.practice0;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private int price;
    public Item() {}
    public Item(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }
}
