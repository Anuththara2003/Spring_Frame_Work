package Documents.AAD.JavaEE.Test_Project.DI;

import Documents.AAD.JavaEE.Test_Project.Bean.DIInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DIInterface {

    //property injection
   // @Autowired  //(constructor injection  krddi meka aniwarya naha)
    DI di;

    //constructor injection

   /* public Test2(DI di) {
//        System.out.println("Test2() Constructor Called");
        this.di = di;
        System.out.println("Test2() Constructor Called");

    }

    */


    // Setter injection
    @Autowired
    public void setterMethod(DI di) {
        this.di = di;
    }

    public void test() {
        di.sayHello();
    }


    // Interface injection

    @Autowired
    @Override
    public void inject(DI test1) {
        this.di = test1;
    }
}
