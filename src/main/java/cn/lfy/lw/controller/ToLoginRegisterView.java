package cn.lfy.lw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToLoginRegisterView {

    @RequestMapping("/loginView")
    public String toLogin(){
        return "login.html";
    }

    @RequestMapping("/registerView")
    public String toRegister(){
        return "register.html";
    }
}
