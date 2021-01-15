package cn.lfy.lw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/index")
    public String toIndex(Model model){
        model.addAttribute("test","test");
        return "index.html";
    }

}
