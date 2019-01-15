package com.jfreecms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jfreecms.entity.ArcType;
import com.jfreecms.respository.ArcTypeRespository;
import com.jfreecms.service.ArcTypeService;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 8:55
 * @Author: Mr.Deng
 * @Description:分类信息资源service实现类
 */
@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService {

	@Autowired
	private ArcTypeRespository arcTypeRespository;
	
	@Override
	public List<ArcType> listAll(Direction direction, String... properties) {
		Sort sort=new Sort(direction, properties);
		return arcTypeRespository.findAll(sort);
	}

}
