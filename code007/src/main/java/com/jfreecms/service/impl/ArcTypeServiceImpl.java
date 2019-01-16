package com.jfreecms.service.impl;

import com.jfreecms.entity.ArcType;
import com.jfreecms.respository.ArcTypeRepository;
import com.jfreecms.service.ArcTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 8:55
 * @Author: Mr.Deng
 * @Description:分类信息资源service实现类
 */
@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService {

	@Autowired
	private ArcTypeRepository arcTypeRepository;
	
	@Override
	public List<ArcType> listAll(Direction direction, String... properties) {
		Sort sort=new Sort(direction, properties);
		return arcTypeRepository.findAll(sort);
	}

}
