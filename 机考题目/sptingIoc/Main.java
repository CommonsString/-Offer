package com.main;

import com.entity.StudentController;
import com.entity.StudentService;

public class Main {
	
	
	public static void main(String[] args) {
		// 掉绝对路径
		ClassPathXmlApplationContent content = new ClassPathXmlApplationContent("D:\\ProjectCode\\SpringIoc\\src\\com\\resources\\applation.xml");
		@SuppressWarnings("unused")
		StudentService service = (StudentService) content.getBean("service");
		StudentController controller = (StudentController) content.getBean("controller");
		controller.add();
	}

}
