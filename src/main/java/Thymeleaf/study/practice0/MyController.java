package Thymeleaf.study.practice0;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
public class MyController {

    private final ItemRepository itemRepository;

    /**
     * @GetMapping    /items -> 아이템 목록
     * @GetMapping    /items/{itemId} -> 해당 id 아이템 상세
     * @PostMapping   /items -> 아이템 등록
     */

    // 초기 데이터 넣어주기
    @PostConstruct
    public void init(){
        itemRepository.save("itemA", 10000);
        itemRepository.save("itemB", 20000);
        itemRepository.save("itemC", 5000);
    }
    @GetMapping
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "/items";
    }
    @GetMapping("/{itemId}")
    public String item(Model model, @PathVariable("itemId") int itemId){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "/item";
    }
}
