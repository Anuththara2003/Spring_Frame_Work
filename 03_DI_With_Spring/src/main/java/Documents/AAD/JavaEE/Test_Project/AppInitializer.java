package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.Bean.Boy;
import Documents.AAD.JavaEE.Test_Project.DI.Test2;
import Documents.AAD.JavaEE.Test_Project.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
//
//        Boy boy = context.getBean(Boy.class);
//        boy.chatwithgirl();

        Test2 test2 = context.getBean(Test2.class);
        test2.test();


      context.registerShutdownHook();

    }
}