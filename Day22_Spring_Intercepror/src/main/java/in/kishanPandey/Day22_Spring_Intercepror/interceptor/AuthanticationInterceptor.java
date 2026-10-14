package in.kishanPandey.Day22_Spring_Intercepror.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthanticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean  preHandle(
            HttpServletRequest request ,
            HttpServletResponse response ,
            Object handler ){
        String apiKey = request.getHeader("x-api-key");
        if(apiKey!=null && !apiKey.equals("secteat123")){
            return false;
        }
        return true;
    }
}
