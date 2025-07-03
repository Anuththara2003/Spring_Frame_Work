package Documents.AAD.JavaEE.Test_Project.bean;


import org.springframework.stereotype.Component;

@Component("sandaru")
public class TestBean2 {
    public TestBean2() {
        System.out.println("Test Bean 2 Constructor Called");
    }
}
