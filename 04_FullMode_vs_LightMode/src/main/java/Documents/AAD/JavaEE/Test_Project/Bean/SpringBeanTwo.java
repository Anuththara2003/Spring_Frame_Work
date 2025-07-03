package Documents.AAD.JavaEE.Test_Project.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanTwo implements InitializingBean , BeanNameAware , DisposableBean , BeanFactoryAware, ApplicationContextAware {

    public SpringBeanTwo(){
        System.out.println("SpringBeanTwo Constructor called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactory called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanName called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertiesSet called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext called");
    }
}
