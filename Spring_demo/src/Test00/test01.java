


import main.Controller.testController;
import main.Controller.testController2;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-15 09:13
 * @description:
 ************************************************************/
public class test01 {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


       // testController controller = (testController) classPathXmlApplicationContext.getBean("controller");
        testController2 controller = (testController2) classPathXmlApplicationContext.getBean("aa");
        controller.findController();

    }


}
