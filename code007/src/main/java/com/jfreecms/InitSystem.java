package com.jfreecms;

import com.jfreecms.entity.ArcType;
import com.jfreecms.service.ArcTypeService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: code007
 * @Date: 2019/1/15 0015 9:07
 * @Author: Mr.Deng
 * @Description:初始化分类信息加载到主页
 * 通过ApplicationContextAware获取spring上下文的类
 * ServletContextListener 接口，它能够监听 ServletContext 对象的生命周期，实际上就是监听 Web 应用的生命周期。
 *
 * 当Servlet 容器启动或终止Web 应用时，会触发ServletContextEvent 事件，该事件由ServletContextListener 来处理。
 */
@Component("initSystem")
public class InitSystem implements ServletContextListener,ApplicationContextAware{

	private static ApplicationContext applicationContext;

	public static Map<Integer,ArcType> arcTypeMap=new HashMap<Integer,ArcType>();
	
	/**
	 * 加载数据到application缓存中
	 * @param application
	 */
	public void loadData(ServletContext application){
		ArcTypeService arcTypeService=(ArcTypeService) applicationContext.getBean("arcTypeService");
		List<ArcType> allArcTypeList = arcTypeService.listAll(Sort.Direction.ASC, "sort");
		for(ArcType arcType:allArcTypeList){
			arcTypeMap.put(arcType.getId(), arcType);
		}
		application.setAttribute("allArcTypeList", allArcTypeList);
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.loadData(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		InitSystem.applicationContext=applicationContext;
	}

}
