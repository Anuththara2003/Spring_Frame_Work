package Documents.AAD.JavaEE.Test_Project.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean  implements InitializingBean {

    @Value("${os.name}")
    private String osName;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(osName);
    }
}
