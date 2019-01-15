package com.jfreecms.service.impl;

import com.jfreecms.entity.Article;
import com.jfreecms.respository.ArticleRepository;
import com.jfreecms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 21:31
 * @Author: Mr.Deng
 * @Description:
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> list(Article sArticle, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        Pageable pageable = new PageRequest(page-1,pageSize,direction,properties);
        Page<Article> pageArticle = articleRepository.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                /**我们只会查询审核通过的帖子*/
                if (sArticle != null) {
                    if (sArticle.getState() != null) {
                        predicate.getExpressions().add(
                                criteriaBuilder.equal(root.get("state"), sArticle.getState()));

                    }
                }
                return predicate;
            }
        },pageable);
        return pageArticle.getContent();
    }

    @Override
    public Long getTotal(Article sArticle) {
        /*动态 构建相应的查询语句，在JPA2.0中我们可以通过Criteria接口查询，JPA criteria查询.相比JPQL,其优势是类型安全,更加的面向对象.而在Spring data JPA中相应的接口是JpaSpecificationExecutor，这个接口基本是围绕着Specification接口来定义的。 */
        Long count = articleRepository.count(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                /*我们只会查询审核通过的帖子数量*/
                if (sArticle != null) {
                    if (sArticle.getState() != null) {
                        predicate.getExpressions().add(
                                criteriaBuilder.equal(root.get("state"), sArticle.getState()));

                    }
                }
                return predicate;
            }
        });
        return count;
    }

}
