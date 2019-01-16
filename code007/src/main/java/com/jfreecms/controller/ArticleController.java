package com.jfreecms.controller;

import com.jfreecms.InitSystem;
import com.jfreecms.entity.ArcType;
import com.jfreecms.entity.Article;
import com.jfreecms.service.ArticleService;
import com.jfreecms.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: code007
 * @Date: 2019/1/16 0016 22:12
 * @Author: Mr.Deng
 * @Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    /**
    *
    * @author: s1332177151@gmail.com
    * @Date: 2019/1/16 0016 22:17
     * 根据条件分页查询资源帖子信息
    */
    @RequestMapping("/list/{id}")
    public ModelAndView list(@RequestParam(value="typeId",required = false)Integer typeId,
                             @PathVariable(value="id",required = false)Integer page, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        Article article = new Article();
        /*审核通过的帖子*/
        article.setState(2);
        if(typeId == null){
            mav.addObject("title","第"+page+"页");
        }else{
            ArcType arcType = InitSystem.arcTypeMap.get(typeId);
            article.setArcType(arcType);
            mav.addObject("title",
                    arcType.getName()+"第"+page+"页");
            request.getSession().setAttribute("tMenu","t_"+typeId);
        }
        mav.addObject("title","第"+page+"页");
        List<Article> indexArticleList = articleService.list(article,page,20,Sort.Direction.DESC,"publishDate");
        Long total = articleService.getTotal(article);
        mav.addObject("articleList",indexArticleList);
        StringBuffer sb = new StringBuffer();
        if(typeId != null){
            sb.append("?typeId="+typeId);
        }
        mav.addObject("pageCode", PageUtil.genPagination("/article/list", total, page, 20, sb.toString()));
        mav.setViewName("index");
        return mav;
    }
}
