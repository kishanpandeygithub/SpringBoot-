package in.kishanPandey;

import in.kishanPandey.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JasperInitializer;
import org.apache.jasper.servlet.JspServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class Main {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath = "";

        String baseDoc =
                "D:\\Kishan pandey\\SpringBoot\\Day17_SpringMVC_ViewExample\\src\\main\\webapp";

        Context context = tomcat.addWebapp(contextPath, baseDoc);


        // JSP Configuration
        context.addServletContainerInitializer(
                new JasperInitializer(),
                Set.of()
        );

        Wrapper jspWrapper =
                Tomcat.addServlet(context, "jsp", new JspServlet());

        jspWrapper.setLoadOnStartup(3);

        context.addServletMappingDecoded("*.jsp", "jsp");
        context.addServletMappingDecoded("*.jspx", "jsp");


        // Spring IOC Container
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.setServletContext(context.getServletContext());

        springContext.register(WebConfig.class);


        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        Wrapper dispatcherWrapper = Tomcat.addServlet(
                context,
                "dispatcherServlet",
                dispatcherServlet
        );

        dispatcherWrapper.setLoadOnStartup(1);

        context.addServletMappingDecoded(
                "/",
                "dispatcherServlet"
        );


        // Start Tomcat
        tomcat.start();

        System.out.println("Tomcat started at port 8080");

        tomcat.getServer().await();
    }
}