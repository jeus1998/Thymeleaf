package Thymeleaf.study.practice0;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {
    /**
     * 둘다 타임리프를 통해 랜더링 되지만 모델에 데이터 유무의 차이
     * GET /basic       model data x
     * GET /basic/text  model data o
     */
    @GetMapping
    public String before(){
        return "basic";
    }
    @GetMapping("/text")
    public String text(Model model){
        String data = "hello Thymeleaf";
        model.addAttribute("data", data);
        return "basic";
    }

}
