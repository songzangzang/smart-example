package org.smart4j.chapter4.service;

import java.util.List;
import java.util.Map;

import org.smart4j.chapter4.model.Customer;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.Param;

public interface CustomerService {
	/**
	 * 获取用户列表
	 * @return
	 * @throws Exception
	 */
	public List<Customer> getCustomerList() throws Exception;
	
	/**
	 * 获取一个用户
	 */
	public Customer getCustomer(Param param) throws Exception;
	
	/**
	 * 添加用户
	 */
	public boolean saveCustomer(Map<String, Object> fieldMap, FileParam fileParam) throws Exception;
	
	/**
	 * 修改用户
	 */
	public boolean editCustomer(Param param) throws Exception;
	
	/**
	 * 删除用户
	 */
	public boolean deleteCustomer(Param param) throws Exception;
}
