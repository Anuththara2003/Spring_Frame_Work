package Documents.AAD.JavaEE.Test_Project.config;


import Documents.AAD.JavaEE.Test_Project.bean.MyConnection;
import Documents.AAD.JavaEE.Test_Project.bean.TestBean2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan(basePackages = "Documents.AAD.JavaEE.Test_Project")
@ComponentScan(basePackageClasses = TestBean2.class)
public class AppConfig {

    @Bean("sandaru")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyConnection myConnection() {
        return new MyConnection();
    }
}
