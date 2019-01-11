package com.jfreecms.core.controller;

import com.jfreecms.core.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: blog
 * @Date: 2019/1/11 0011 14:40
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;


}
