package in.kishanPandey;

import in.kishanPandey.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {
        //boiler plate code
        //create the tomcat object
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath = "";
        String baseDoc =
                "D:\\Kishan pandey\\SpringBoot\\Day16_SpringMVC_demo\\src\\main\\webapp";

        Context context = tomcat.addContext("", baseDoc);

        //ioc container
        AnnotationConfigWebApplicationContext springContex =new AnnotationConfigWebApplicationContext();
        springContex.register(WebConfig.class);
        //dispattcher servlet
        DispatcherServlet dispatcherServlet  =
                new DispatcherServlet(springContex);

        Tomcat.addServlet( context , "dispatcherServlet" ,dispatcherServlet);

        context.addServletMapping("/", "dispatcherServlet");

        tomcat.start();
        System.out.println("Tomcat start at the port no 8080");

        tomcat.getServer().await();
    }
}

//stident pojo class
//create and get operation
