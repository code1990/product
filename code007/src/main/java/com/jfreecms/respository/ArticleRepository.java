package com.jfreecms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jfreecms.entity.Article;

/**
* 资源Respository接口 即为文章或者帖子DAO
* @author: s1332177151@gmail.com
* @Date: 2019/1/15 0015 21:29
*/
public interface ArticleRepository extends JpaRepository<Article, Integer>,JpaSpecificationExecutor<Article>{

}
