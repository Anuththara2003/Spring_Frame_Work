package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.bean.SpringBeanOne;
import Documents.AAD.JavaEE.Test_Project.bean.SpringBeanTwo;
import Documents.AAD.JavaEE.Test_Project.config.AppConfig;
import Documents.AAD.JavaEE.Test_Project.config.AppConfig1;
import Documents.AAD.JavaEE.Test_Project.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        context.register(AppConfig1.class);
//        context.register(AppConfig2.class);
//        context.refresh();
//        SpringBeanOne springBeanOne1 = context.getBean(SpringBeanOne.class);
//        SpringBeanOne springBeanOne2 = context.getBean(SpringBeanOne.class);
//        System.out.println(springBeanOne1);
//        System.out.println(springBeanOne2);
//
//        SpringBeanTwo springBeanTwo1 = context.getBean(SpringBeanTwo.class);
//        SpringBeanTwo springBeanTwo2 = context.getBean(SpringBeanTwo.class);
//        System.out.println(springBeanTwo1);
//        System.out.println(springBeanTwo2);


        context.register(AppConfig.class);
        context.refresh();


        context.registerShutdownHook();
    }
}