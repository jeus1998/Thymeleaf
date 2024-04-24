package Thymeleaf.study.practice1.web;

import Thymeleaf.study.practice1.domian.CarType;
import Thymeleaf.study.practice1.domian.DeliveryWay;
import Thymeleaf.study.practice1.domian.Tesla;
import Thymeleaf.study.practice1.domian.TeslaRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/tesla")
public class TeslaController {

    private final TeslaRepository teslaRepository;
    private List<DeliveryWay> deliveryWays;
    private CarType[] carTypes;
    private Map<String, String> regions;

    @PostConstruct
    public void init(){

        // sample data 넣기
        Tesla product1 = new Tesla(100000000L, 10, CarType.ModelX, "일론");
        Tesla product2 = new Tesla(200000000L, 20, CarType.ModelS, "머스크");
        Tesla product3 = new Tesla(2000L, 100, CarType.Model3, "배제우");
        teslaRepository.save(product1);
        teslaRepository.save(product2);
        teslaRepository.save(product3);

        // 배달 방법 초기화
        deliveryWays = new ArrayList<>();
        deliveryWays.add(new DeliveryWay("AIRPLANE", "비행기"));
        deliveryWays.add(new DeliveryWay("TRUCK", "트럭"));
        deliveryWays.add(new DeliveryWay("SHIP", "배"));

        // 자동차 종류 담아두기
        carTypes = CarType.values();

        // 배송 가능 지역
        regions = new HashMap<>();
        regions.put("KOREA", "한국");
        regions.put("USA", "미국");
        regions.put("JAPAN", "일본");
        regions.put("CHINA", "중국");
        regions.put("UK", "영국");
    }

    @ModelAttribute("regions")
    public Map<String, String> regions(){
        return regions;
    }

    @ModelAttribute("carTypes")
    public CarType [] carTypes(){
        return carTypes;
    }

    @ModelAttribute("deliveryWays")
    public List<DeliveryWay> deliveryWays(){
        return deliveryWays;
    }


    /**
     * main page + 등록된 cars
     */
    @GetMapping
    public String CarLists(Model model){
        List<Tesla> lists = teslaRepository.findAll();
        model.addAttribute("cars" , lists);

        return "/practice1/cars";
    }

    @GetMapping("/{id}")
    public String CarLists(@PathVariable("id") Long id,  Model model){
        Tesla car = teslaRepository.findById(id);
        model.addAttribute("car", car);
        return "/practice1/car";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("car", new Tesla()); // 빈 객체 넘겨주기
        return "/practice1/addForm";
    }

    /**
     * PRG 패턴
     * POST -> Redirect -> GET 적용
     */
    @PostMapping("/add")
    public String add(@ModelAttribute Tesla tesla, RedirectAttributes redirectAttributes){
        Tesla save = teslaRepository.save(tesla);
        redirectAttributes.addAttribute("success", true);
        redirectAttributes.addAttribute("id",save.getId());
        return "redirect:/tesla/{id}";
    }

    @GetMapping("/edit/{id}")
    private String updateForm(@PathVariable("id") Long id, Model model){
        Tesla find = teslaRepository.findById(id);
        model.addAttribute("car", find);
        return "/practice1/editForm";
    }

    @PostMapping("/edit/{id}")
    private String update(@PathVariable("id") Long id, RedirectAttributes redirectAttributes , Tesla updateParam){

        Tesla update = teslaRepository.update(id, updateParam);
        redirectAttributes.addAttribute("edit", true);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/tesla/{id}";
    }

}
