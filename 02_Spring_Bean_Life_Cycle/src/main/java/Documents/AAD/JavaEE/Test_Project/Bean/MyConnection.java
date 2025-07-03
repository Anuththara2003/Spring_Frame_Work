package Documents.AAD.JavaEE.Test_Project.Bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    //the state of instantiation
    public MyConnection() {
        System.out.println("MyConnection constructor called");
    }

    //there is co method to find the state of populate properties

    //bean name aware
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName called");
    }

    //bean factory aware
    // add dependancy injection to bean
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SetBean factory called");
    }

    //disposable bean
    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection destroyed");
    }

// AOP and DP
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware called");
    }

    //complete bean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean called");
    }
}