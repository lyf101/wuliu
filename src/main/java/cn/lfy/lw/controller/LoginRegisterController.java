package cn.lfy.lw.controller;

import cn.lfy.lw.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginRegisterController {

    @Autowired
    private LoginRegisterService loginRegisterService;


    //注册
    @RequestMapping("registerController")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("rePassword") String rePassword,
                           @RequestParam("realName") String realName,
                           @RequestParam("idCard") String idCard,
                           @RequestParam("classify") String classify,
                           Model model) {

        model.addAttribute("msg", "");
        if (!password.equals(rePassword)) {
            model.addAttribute("msg", "两次密码不一致");
            return "register.html";
        }


        if(classify.equals("")||idCard.equals("")||realName.equals("") ||rePassword.equals("")||password.equals("")||username.equals("")){
            model.addAttribute("msg","信息不能为空");
            return "register.html";
        }

        boolean existStaffByUsername = loginRegisterService.isExistStaffByUsername(username);
        if (existStaffByUsername) {
            model.addAttribute("msg", "用户名已存在");
            return "register.html";
        }

        int i = loginRegisterService.addStaff(username, password, realName, idCard, Integer.valueOf(classify));
        if (i != 1) {
            model.addAttribute("msg", "注册失败，请重新注册");
            return "register.html";
        }

        model.addAttribute("msg", "注册成功");
        return "register.html";
    }


    //登录
    @RequestMapping("/LoginController")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        model.addAttribute("msg","");

        if(username.equals("")||password.equals("")){
            model.addAttribute("msg","用户名或密码不能为空");
            return "login.html";
        }

        boolean exisStaffByUsernamePassword = loginRegisterService.isExisStaffByUsernamePassword(username, password);
        if (!exisStaffByUsernamePassword){
            model.addAttribute("msg","用户名或密码错误");
            return "login.html";
        }


    }
}
