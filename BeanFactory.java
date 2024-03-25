package day63_ee267_01factory_;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BeanFactory {
	
//	3.它只能读取类路径下的，不再类路径下读取不了
//	注意：方法参数的写法是按照包名，类名的方式写的，所以请不要写扩展名
	private static ResourceBundle bundle=ResourceBundle.getBundle("bean");
	
//	定义一个容器，用于存放我们要使用的对象
	private static Map<String,Object> beans=new HashMap<String,Object>();
	
//	使用静态代码，初始化map
	static {
		try {
			//		1.读取配置文件中所有的配置：key的部分
					Enumeration<String> keys=bundle.getKeys();
			//		2.遍历keys
					while(keys.hasMoreElements()) {
			//			3.取出一个key
						String key=keys.nextElement();
			//			4.根据key获取beanPath
						String beanPath=bundle.getString(key);
			//			5.根据beanPath反射创建类对象
						Object value=Class.forName(beanPath).newInstance();
		//				6.把key和value存入map中
						beans.put(key, value);
					}
		} catch (Exception e) {
			throw new ExceptionInInitializerError("创建容器失败，程序停止执行!");
		}
	}
	
	/**
	 * 根据Bean的唯一标识获取对象
	 * @param beanName
	 * @return
	 */
	public static Object  getBean(String beanName) {
		return beans.get(beanName);
	}
	/*
	 * // 根据bean的名称创建类对象 public static Object getBean(String beanName) { try { //
	 * 1.读取配置文件，跟beanName获取全限定类名 String beanPath=bundle.getString(beanName); return
	 * Class.forName(beanPath).newInstance();
	 * 
	 * }catch(Exception e) { throw new RuntimeException(e); } }
	 */

}
