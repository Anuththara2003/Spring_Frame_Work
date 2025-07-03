package Documents.AAD.JavaEE.Test_Project.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project.bean")
@PropertySource(value = "classpath:Application.properties")
public class AppConfig {

}
