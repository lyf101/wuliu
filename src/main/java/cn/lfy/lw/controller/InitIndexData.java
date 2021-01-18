package cn.lfy.lw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Date:2021/1/18 14:46
 * Author:lyf
 */

@Controller
public class InitIndexData {

    @RequestMapping("/indexTopView")
    public String toIndexTopView(HttpSession session, Model model){
        Object staff = session.getAttribute("staff");
        System.out.println(staff);
        model.addAttribute("staff",staff);
        return "indexTop.html";
    }
    @RequestMapping("/indexEndView")
    public String toIndexEndView(){
        return "indexEnd.html";
    }
    @RequestMapping("/indexLeftView")
    public String toIndexLeftView(){
        return "indexLeft.html";
    }
    @RequestMapping("/indexRightView")
    public String toIndexRightView(){
        return "indexRight.html";
    }
}
