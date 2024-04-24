package Thymeleaf.study.practice1.domian;
import lombok.Data;
import java.util.*;

@Data
public class Tesla {

    private Long id;
    private Long price;          // 가격
    private Integer quantity;    // 수량
    private String salesMan;     // 판매원

    private Boolean open;            // 판매 여부
    private CarType carType;         // 차 종류
    private List<String> regions;    // 판매 지역
    private String deliveryWay;      // 배송 방법
    public Tesla () {}
    public Tesla (Long price, Integer quantity, CarType carType, String salesMan) {
        this.price = price;
        this.quantity = quantity;
        this.carType = carType;
        this.salesMan = salesMan;
    }
}
