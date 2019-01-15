package com.jfreecms.service;

import com.jfreecms.entity.ArcType;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 8:49
 * @Author: Mr.Deng
 * @Description:资源请求接口
 */
public interface ArcTypeService {

    /**
    * 返回所有的资源类型
    * @author: s1332177151@gmail.com 
    * @Date: 2019/1/15 0015 8:50
    * @param direction 表示排序的方向 倒序还是正序
    * @param properties 不确定的参数个数
    * @return List<ArcType>返回所有的资源类型
    */
    public List<ArcType> listAll(Direction direction, String... properties);
}
