package com.spring.wc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*Another method*/
//    public class AppInititalizer implements WebApplicationInitializer {
//        @Override
//        public void onStartup(ServletContext container) {
//            AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//            ctx.register(MVCConfigurer.class);
//            ctx.setServletContext(container);
//            ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(ctx));
//            dispatcher.setLoadOnStartup(1);
//            dispatcher.addMapping("/");
//        }
//    }
    /*Recommended method for applications that use Java-based Spring configuration*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MyWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
