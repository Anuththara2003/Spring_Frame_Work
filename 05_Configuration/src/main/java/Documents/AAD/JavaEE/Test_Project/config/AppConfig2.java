package Documents.AAD.JavaEE.Test_Project.config;

import Documents.AAD.JavaEE.Test_Project.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig2 {
    @Bean
    public SpringBeanTwo springBeanTwo() {
        return new SpringBeanTwo();
    }
}
