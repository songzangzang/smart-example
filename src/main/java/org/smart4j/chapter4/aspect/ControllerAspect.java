package org.smart4j.chapter4.aspect;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;
/**
 * 拦截Controller 所有方法
 * @author Administrator
 *
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy{

	private static final Logger LOGGER = Logger.getLogger(ControllerAspect.class);
	
	private long begin;
	
	@Override
	public void before(Class<?> cls, Method method, Object[] params) {
		LOGGER.debug("------------------------------- begin ----------------------------------");
		LOGGER.debug(String.format("class: %s", cls.getName()));
		LOGGER.debug(String.format("method: %s", method.getName()));
		begin = System.currentTimeMillis();
	}
	
	@Override
	public void after(Class<?> cls, Method method, Object[] params, Object result) {
		LOGGER.debug(String.format("time:  %dms", System.currentTimeMillis()-begin));
		LOGGER.debug("------------------------------- end ------------------------------------");
	}
	
}
