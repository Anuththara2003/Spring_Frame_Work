package Documents.AAD.JavaEE.Test_Project.DI;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements DI{
    private Test1 (){
        System.out.println("Test1() Constructor Called");
    }
    @Override
    public void sayHello() {
        System.out.println("Test1() say Hello");
    }
}
