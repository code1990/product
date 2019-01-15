package com.jfreecms.controller;

import com.jfreecms.entity.Article;
import com.jfreecms.service.ArticleService;
import com.jfreecms.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: code007
 * @Date: 2019/1/13 0013 22:06
 * @Author: Mr.Deng
 * @Description:首页或者跳转url控制器
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    /**
    *
    * @author: s1332177151@gmail.com
    * @Date: 2019/1/13 0013 22:06
    * @description: 网站根目录请求
    */
    @RequestMapping("/")
    public ModelAndView root(){
        Article sArticle = new Article();
        /*状态为2表示审核通过*/
        sArticle.setState(2);
        List<Article> indexArticleList = articleService.list(sArticle,1,20, Sort.Direction.DESC,"publishDate");
        Long total=articleService.getTotal(sArticle);
        ModelAndView mav = new ModelAndView();
        mav.addObject("articleList", indexArticleList);
        mav.addObject("pageCode", PageUtil.genPagination("/article/list", total, 1, 20, ""));
        mav.setViewName("index");
        return mav;
    }
}
