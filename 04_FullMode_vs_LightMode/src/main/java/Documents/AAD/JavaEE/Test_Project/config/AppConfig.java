package Documents.AAD.JavaEE.Test_Project.config;

import Documents.AAD.JavaEE.Test_Project.Bean.SpringBeanOne;
import Documents.AAD.JavaEE.Test_Project.Bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project.Bean")
public class AppConfig {

//    InterBean dependency not satisfied
    @Bean
    public SpringBeanOne springBeanOne() {

        SpringBeanTwo springBeanTwo1 =  springBeanTwo();
        SpringBeanTwo springBeanTwo2 = springBeanTwo();

        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);


        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo springBeanTwo() {
        return new SpringBeanTwo();
    }
}
