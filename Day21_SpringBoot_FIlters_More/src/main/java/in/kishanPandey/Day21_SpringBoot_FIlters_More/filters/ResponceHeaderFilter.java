package in.kishanPandey.Day21_SpringBoot_FIlters_More.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpTimeoutException;
import java.util.UUID;

//@Component
public class ResponceHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestId = UUID.randomUUID().toString();
        httpServletResponse.setHeader("x-request-id" , requestId);
        filterChain.doFilter(servletRequest ,servletResponse);

    }
}
