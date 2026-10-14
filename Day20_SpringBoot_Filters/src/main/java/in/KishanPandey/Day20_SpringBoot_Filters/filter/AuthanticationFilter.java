package in.KishanPandey.Day20_SpringBoot_Filters.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthanticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponce = (HttpServletResponse) servletResponse;
//        System.out.println(httpRequest.getHeader("token"));
        String token = httpRequest.getParameter("token");
        String apiKey = httpRequest.getHeader("x-api-key");
        if (token == null || !token.equals("12345")) {
//            httpResponce.setStatus(401);
            httpResponce.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (apiKey == null || !apiKey.equals("secret123")) {
            httpResponce.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponce.setContentType("application/json");
            httpResponce.getWriter().write(
                    "{\n" +
                            "    \"id\":1 ,\n" +
                            "    \"name\":\"Kishan\" ,\n" +
                            "    \"email\": \"kishan@gmail.com\"\n" +
                            "}"
            );
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
