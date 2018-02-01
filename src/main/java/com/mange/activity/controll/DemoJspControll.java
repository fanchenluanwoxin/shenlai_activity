package com.mange.activity.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by lbm on 2017/11/17
 * @author lbm
 */
@Controller
public class DemoJspControll {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("/index");
        return view;
    }

    @RequestMapping("/in")
    public String in(){
        return "/index";
    }

    @RequestMapping("/pages")
    public String pages(){
        return "/pages";
    }
}
