package Documents.AAD.JavaEE.Test_Project.Config;

import Documents.AAD.JavaEE.Test_Project.Bean.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project")
public class AppConfig {
    @Bean
    @Scope("prototype")
    public MyConnection myConnection() {
        return new MyConnection();
    }
}
