package Documents.AAD.JavaEE.Test_Project;

import Documents.AAD.JavaEE.Test_Project.config.WebAppConfig;
import Documents.AAD.JavaEE.Test_Project.config.WebRootConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[] { WebRootConfig.class };
    }

    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{ WebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}