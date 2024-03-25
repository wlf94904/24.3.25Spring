package com.itheima.factory;

/**
 * 模拟一个静态工厂
 */
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

public class StaticFactory {
	
	public static ICustomerService getCustomerService() {
		return new CustomerServiceImpl();
	}

}
