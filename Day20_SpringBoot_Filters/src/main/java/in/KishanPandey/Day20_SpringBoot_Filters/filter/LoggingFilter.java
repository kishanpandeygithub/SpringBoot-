package in.KishanPandey.Day20_SpringBoot_Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse
            , FilterChain filterChain)
            throws IOException, ServletException {
//        System.out.println("Request Enterd in the logging filter");
//        filterChain.doFilter(request , response);
//        System.out.println("Request exiting form the logging filter");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponce = (HttpServletResponse) servletResponse;

        String requestId = UUID.randomUUID().toString();
        Long startTime = System.currentTimeMillis();
        httpResponce.setHeader("X-Request_ID", requestId);

        System.out.println("Incoming Request : "
                + httpRequest.getMethod() + " " +
                httpRequest.getRequestURI());
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            //responce status log
            Long outTime = System.currentTimeMillis();
            System.out.println(outTime - startTime);
            System.out.println("Responce Status : " +
                    httpResponce.getStatus());
        }


    }

}
