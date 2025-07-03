package Documents.AAD.JavaEE.Test_Project.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("Sandaru-Perera")
    private String  name;

    @Value("sadnjaudnandlannlnla")
    private String key;

    public SpringBean(){
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
        System.out.println(key);

    }


//    @Autowired(required = false)
//    public SpringBean(@Value("sandaru-perera")String name ,@Value("200")int number, @Value("true")boolean value) {
//            System.out.println("Spring Bean Constructor created");
//            System.out.println("Spring Bean Name : " + name);
//            System.out.println("Spring Bean Number : " + number);
//            System.out.println("Spring Bean Value : " + value);
//
//    }
//
//    @Autowired(required = false)
//    public SpringBean(@Value("sandaru-perera")String name ,@Value("200")int number,@Value("21")int age,@Value("Banaragama")String address) {
//            System.out.println("Spring Bean Constructor created");
//            System.out.println("Spring Bean Name : " + name);
//            System.out.println("Spring Bean Number : " + number);
//            System.out.println("Spring Bean Age : " + age);
//            System.out.println("Spring Bean Address : " + address);
//    }
}
