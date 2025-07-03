package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.Bean.MyConnection;
import Documents.AAD.JavaEE.Test_Project.Bean.TestBean1;
import Documents.AAD.JavaEE.Test_Project.Config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//        TestBean1 testBean2 = context.getBean(TestBean1.class);
//        System.out.println(testBean2);


        MyConnection myConnection = context.getBean(MyConnection.class);
        System.out.println(myConnection);
        MyConnection myConnection1 = context.getBean(MyConnection.class);
        System.out.println("................................");
        System.out.println(myConnection1);


      context.registerShutdownHook();

    }
}