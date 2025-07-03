package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.bean.MyConnection;
import Documents.AAD.JavaEE.Test_Project.bean.SpringBean;
import Documents.AAD.JavaEE.Test_Project.bean.TestBean1;
import Documents.AAD.JavaEE.Test_Project.bean.TestBean2;
import Documents.AAD.JavaEE.Test_Project.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APPInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();


//        SpringBean springBean = context.getBean(SpringBean.class);
//        springBean.test();
//        System.out.println(springBean);

//        SpringBean springBean2 = context.getBean(SpringBean.class);
//        springBean2.test();
//        System.out.println(springBean2);


//
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);


//        Runtime.getRuntime().addShutdownHook(new Thread(){
//                @Override
//                public void run() {
//                    context.close();
//                }
//                }
//        );


        //class name

//        SpringBean springBean = context.getBean(SpringBean.class);
//        System.out.println(springBean);
//
//        //Bean Id

//        SpringBean springBean1 = (SpringBean)context.getBean("springBean");
//        System.out.println(springBean1);
//        TestBean1 testBean1 = (TestBean1) context.getBean("testBean1");
//        System.out.println(testBean1);
//
//        //beanId and class name

//        TestBean2 testBean2 = (TestBean2) context.getBean("sandaru");
//        System.out.println(testBean2);
//
//        context.registerShutdownHook();


//        TestBean2 testBean2 = context.getBean(TestBean2.class);
//        System.out.println(testBean2);

//        context.close();


//        MyConnection myConnection = context.getBean(MyConnection.class);
//        System.out.println(myConnection);
//        //bean  by method name
//        MyConnection myConnection1 = (MyConnection) context.getBean("sandaru");
//        System.out.println(myConnection1);
//        //beanID + Class name
//        MyConnection myConnection2 = (MyConnection) context.getBean("sandaru", MyConnection.class);
//        System.out.println(myConnection2);
//




//        2025/60/19

        TestBean1 bean1 = context.getBean(TestBean1.class);
        TestBean1 bean2 = context.getBean(TestBean1.class);

        System.out.println(bean1);
        System.out.println(bean2);


        MyConnection connection1 = context.getBean(MyConnection.class);
        MyConnection connection2 = context.getBean(MyConnection.class);

        System.out.println(connection1);
        System.out.println(connection2);


        context.registerShutdownHook();



    }
}