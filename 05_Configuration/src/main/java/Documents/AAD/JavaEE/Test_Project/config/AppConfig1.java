package Documents.AAD.JavaEE.Test_Project.config;

import Documents.AAD.JavaEE.Test_Project.bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project")
public class AppConfig1 {
    @Bean
    public SpringBeanOne springBeanOne() {
        return new SpringBeanOne();
    }

}
