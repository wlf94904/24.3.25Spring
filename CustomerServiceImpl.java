package day63_ee267_01factory_;

public class CustomerServiceImpl implements IcustomerService{
	
	private IcustomerDao customerDao=(IcustomerDao) BeanFactory.getBean("CUSTOMERDAO");
	
	

}
