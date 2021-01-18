package cn.lfy.lw.controller;

import cn.lfy.lw.domain.Staff;
import cn.lfy.lw.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date:2021/1/16 20:55
 * Author:lyf
 */

@Controller
public class ChangePasswordController {

    @Autowired
    private LoginRegisterService loginRegisterService;

    @RequestMapping("/toChangePasswordView")
    public String toChangePassword(@RequestParam("staffUsername") String staffUsername,
                                   Model model) {

        model.addAttribute("staffUsername", staffUsername);
        return "changePassword.html";
    }

    @RequestMapping("/changePasswordController")
    public String changePasswordController(@RequestParam("staffUsername") String staffUsername,
                                           @RequestParam("oldPassword") String oldPassword,
                                           @RequestParam("newPassword") String newPassword,
                                           @RequestParam("rePassword") String rePassword,
                                           Model model) {
        model.addAttribute("msg", "");
        Staff staff = loginRegisterService.findStaffByUsername(staffUsername);

        if (!newPassword.equals(rePassword)) {
            model.addAttribute("staffUsername",staffUsername);
            model.addAttribute("msg", "两次密码不一致");
            return "changePassword.html";
        }

        if(!staff.getStaffPassword().equals(oldPassword)){
            model.addAttribute("staffUsername",staffUsername);
            model.addAttribute("msg", "旧密码错误");
            return "changePassword.html";
        }else {
            boolean b = loginRegisterService.changeStaff(staffUsername,newPassword);
            if(b){
                model.addAttribute("msg","修改密码成功，请重新登录");
                return "login.html";
            }else {
                model.addAttribute("msg","修改密码失败，请重试");
                return "changePassword.html";
            }
        }


    }
}
