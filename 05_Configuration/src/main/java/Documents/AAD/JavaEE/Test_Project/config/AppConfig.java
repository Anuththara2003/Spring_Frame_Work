package Documents.AAD.JavaEE.Test_Project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppConfig1.class, AppConfig2.class})
//@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project")
public class AppConfig {

}
