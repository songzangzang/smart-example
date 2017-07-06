package org.smart4j.chapter4.service.impl;

import java.util.List;
import java.util.Map;

import org.smart4j.chapter4.model.Customer;
import org.smart4j.chapter4.service.CustomerService;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.helper.DataBaseHelper;
import org.smart4j.framework.helper.ServletHelper;
import org.smart4j.framework.helper.UploadHelper;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Transaction
	public List<Customer> getCustomerList() throws Exception {
		String sql = "select * from customer";
		return DataBaseHelper.queryEntityList(Customer.class, sql);
	}
	
	public Customer getCustomer(Param param) throws Exception{
		String sql = "select * from customer where id = "+param.getLong("id");
		return DataBaseHelper.queryEntity(Customer.class, sql);
	}
	
	@Transaction
	@Override
	public boolean saveCustomer(Map<String, Object> fieldMap, FileParam fileParam) throws Exception{
		boolean result = DataBaseHelper.insertEntity(Customer.class, fieldMap);
		if (result) {
			UploadHelper.uploadFile("/tmp/upload/", fileParam);
		}
		return result;
	}
	
	public boolean editCustomer(Param param) throws Exception{
		long id = param.getLong("id");
		Map<String, Object> map = param.getFieldMap();
		return DataBaseHelper.updateEntity(Customer.class, id, map);
	}
	
	public boolean deleteCustomer(Param param) throws Exception{
		return DataBaseHelper.deleteEntity(Customer.class, param.getLong("id"));
	}

}
