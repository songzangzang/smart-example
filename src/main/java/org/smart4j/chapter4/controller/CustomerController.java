package org.smart4j.chapter4.controller;

import java.util.List;

import org.smart4j.chapter4.model.Customer;
import org.smart4j.chapter4.service.CustomerService;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

/**
 * 用户控制器
 * 
 * @author Administrator
 *
 */
@Controller
public class CustomerController {

	@Inject
	private CustomerService customerService;

	/**
	 * 进入列表页面
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Action("get:/customer")
	public View getCustomer(Param param) throws Exception {
		List<Customer> customerList = customerService.getCustomerList();
		return new View("customer.jsp").addModel("customerList", customerList);
	}

	/**
	 * 创建页面
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Action("get:/customer_createSubmit")
	public View createSubmit(Param param) throws Exception {
		return new View("customer_save.jsp");
	}

	/**
	 * 处理添加信息
	 */
	@Action("post:/customer_save")
	public Data saveCustomer(Param param) throws Exception {
		boolean result = customerService.saveCustomer(param);
		return new Data(result);
	}

	/**
	 * 修改页面
	 */
	@Action("get:/customer_editSubmit")
	public View editSubmit(Param param) throws Exception {
		Customer customer = customerService.getCustomer(param);
		return new View("customer_edit.jsp").addModel("map", customer);
	}

	/**
	 * 处理修改信息
	 */
	@Action("post:/customer_edit")
	public Data editCustomer(Param param) throws Exception {
		boolean result = customerService.editCustomer(param);
		return new Data(result);
	}

	/**
	 * 删除信息
	 */
	@Action("get:/customer_delete")
	public Data deleteCustomer(Param param) throws Exception {
		boolean result = customerService.deleteCustomer(param);
		return new Data(result);
	}
}
