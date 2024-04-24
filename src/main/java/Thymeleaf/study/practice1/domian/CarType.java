package Thymeleaf.study.practice1.domian;

/**
 * 테슬라 모델 3
 * 테슬라 모델 S
 * 테슬라 모델 X
 * 테슬라 모델 Y
 */
public enum CarType {
    Model3("모델3"), ModelS("모델S"), ModelX("모델X"), ModelY("모델Y");
    private String description;
    CarType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
