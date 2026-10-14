package in.kishanPandey.Day22_Spring_Intercepror.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.aopalliance.intercept.Interceptor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean  preHandle(
            HttpServletRequest request ,
            HttpServletResponse response ,
            Object handler ){

//        if(handler instanceof  HandlerMethod  method){
//            String controllerName = method.getBeanType().getName();
//            String methodName = method.getMethod().getName();
//
//            System.out.println("PreHandler called");
//            System.out.println("Method name "+ methodName);
//            System.out.println("Controller name "+ controllerName);
//        }

        System.out.println("Incoming Request");
        //http method
        System.out.println("Http method " + request.getMethod());
        ///endpoint
        System.out.println("Request URI " + request.getRequestURI());
        //query paramathers
        System.out.println("Requset Paramethe " + request.getQueryString());
        //client IP
        System.out.println("Client Ip "+ request.getRemoteAddr());
        //headers
        System.out.println("Header " + request.getHeader("token"));

        if(handler instanceof HandlerMethod handlerMethod ){
            System.out.println("Controller "+ handlerMethod.getBeanType().getName());
            System.out.println("Controllr Method "+ handlerMethod.getMethod().getName());
        }
        return true;
    }
//    @Override
//    public  void postHandle(
//            HttpServletRequest request ,
//            HttpServletResponse response ,
//            Object handler ,
//            ModelAndView modelAndView){
//
//        System.out.println("Post handle called");
//    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
            throws Exception {
        System.out.println("Responce Status " + response.getStatus());
        System.out.println("After Completion called ");
    }
}
