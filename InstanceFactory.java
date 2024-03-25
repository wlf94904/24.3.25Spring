package com.itheima.factory;

/**
 * 模拟一实例工厂
 */
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

public class InstanceFactory {
	
	public ICustomerService getCustomerService() {
		return new CustomerServiceImpl();
	}

}
