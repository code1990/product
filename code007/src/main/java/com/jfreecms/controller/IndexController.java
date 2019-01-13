package com.jfreecms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: code007
 * @Date: 2019/1/13 0013 22:06
 * @Author: Mr.Deng
 * @Description:首页或者跳转url控制器
 */
@Controller
public class IndexController {

    /*
    *
    * @author: s1332177151@gmail.com
    * @Date: 2019/1/13 0013 22:06
    * @description: 网站根目录请求
    */
    @RequestMapping("/")
    public ModelAndView root(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
