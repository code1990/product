package com.jfreecms.core.dao;

import com.jfreecms.core.entity.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: blog
 * @Date: 2019/1/11 0011 14:26
 * @Author: Mr.Deng
 * @Description:
 */
public interface BloggerDao extends JpaRepository<Blogger,Integer>,JpaSpecificationExecutor<Blogger> {
}
