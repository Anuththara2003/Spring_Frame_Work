package Documents.AAD.JavaEE.Test_Project.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype").......

public class TestBean1 {
    public  TestBean1() {
        System.out.println("Test Bean Constructor Called");
    }
}
