package Documents.AAD.JavaEE.Test_Project.bean;


import org.springframework.stereotype.Component;

@Component
public class SpringBean {
    public SpringBean() {
        System.out.println("Spring Bean Constructor Called");
    }
    public void test() {
        System.out.println("Spring Bean Method Called");
    }
}
