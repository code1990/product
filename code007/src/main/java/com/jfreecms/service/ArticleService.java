package com.jfreecms.service;

import com.jfreecms.entity.Article;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * 资源Service接口
 * @author Administrator
 *
 */
public interface ArticleService {

	/**
	 * 根据条件分页查询资源信息
	 * @param sArticle
	 * @param page
	 * @param pageSize
	 * @param direction
	 * @param properties
	 * @return List<Article>
	 */
	public List<Article> list(Article sArticle, Integer page, Integer pageSize, Direction direction, String... properties);
	
	/**
	 * 根据条件查询总记录数
	 * @param sArticle
	 * @return Long
	 */
	public Long getTotal(Article sArticle);
}
