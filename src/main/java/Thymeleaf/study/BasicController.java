package Thymeleaf.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class BasicController {
    /**
     * GET /basic 아무 데이터 렌더링x 정적 리소스
     * GET /basic/text 데이터 랜더링 이후 리소스
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
