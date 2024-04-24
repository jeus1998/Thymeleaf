package Thymeleaf.study.practice1.domian;

import lombok.Data;

/**
 * Truck : 트럭 배송
 * AirPlane : 비행기 배송
 * Ship : 배 배송
 */
@Data
public class DeliveryWay {
    private String way;
    private String displayName;
    public DeliveryWay(String way, String displayName) {
        this.way = way;
        this.displayName = displayName;
    }
}
