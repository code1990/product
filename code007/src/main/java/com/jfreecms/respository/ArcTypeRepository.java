package com.jfreecms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jfreecms.entity.ArcType;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 9:00
 * @Author: Mr.Deng
 * @Description: 分类属性请求dao接口
 */
public interface ArcTypeRepository extends JpaRepository<ArcType,Integer>,JpaSpecificationExecutor<ArcType> {


}
