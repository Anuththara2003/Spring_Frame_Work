package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();





        context.registerShutdownHook();
    }
}