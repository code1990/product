package com.jfreecms.cms.controller;

import com.jfreecms.core.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: blog
 * @Date: 2019/1/11 0011 16:18
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;


}
