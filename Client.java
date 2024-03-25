package com.itheima.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.itheima.dao.ICustomerDao;
import com.itheima.service.ICustomerService;
/**
 * spring的入门案例
 * @author 86131
 *
 */
public class Client {
	
	/**
	 * ClassPathXmlApplicationContext:它是只能加载类路径下的配置文件，我们用上面的这个，因为配置文件应该和工程搁在一起
	 * FileSystemXmlApplicationContext：它是可以加载磁盘任意位置的配置文件
	 * @param args
	 */

	public static void main(String[] args) {
		//1.获取容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		//2.根据bean的id获取对象
		ICustomerService cs=(ICustomerService) ac.getBean("customerService");
		
//		ICustomerDao cdao=ac.getBean("customerDao");
//		System.out.println(cs);
//		System.out.println(cdao);
		cs.saveCustomer();

	}

}
