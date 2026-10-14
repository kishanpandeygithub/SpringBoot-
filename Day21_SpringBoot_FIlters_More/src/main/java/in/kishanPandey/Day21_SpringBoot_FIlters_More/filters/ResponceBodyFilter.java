package in.kishanPandey.Day21_SpringBoot_FIlters_More.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
//@Component
public class ResponceBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //by this we wrap the actual responce  , mean that the dispatcher feet that it is writting the actual responce but actually it is not
        ContentCachingResponseWrapper wrappedResponce  =new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(servletRequest , wrappedResponce);

        //in the wrapperResonce when somthig is weitten
        ///through the weapperResponce.getWritter().write() is is written in the output stream
        //the responce which came from dispactcher is in the form of the byte array

        //by this method we convert it in to the streamofBytes array
        byte[]  originalBodyBytes =  wrappedResponce.getContentAsByteArray();

        //this string creation constructor convert the byteArray into the string
        String originalBody  =new String(originalBodyBytes);

        //but this string is raw , means it has the opening and closing bracket
        String modifiedBody =
                //this is the java text block java 15 feature
                """
                {
                   "originalResponce" : %s ,
                   "appName" : "Student Management System"
                }
                """ .formatted(originalBody);

        //before writting we have to clear the buffer
        wrappedResponce.resetBuffer();
        //writting the modified responce to the wrapped responce
        wrappedResponce.getWriter().write(modifiedBody);
        //now copy the wrapped responce to the actual httpServletResponce
        wrappedResponce.copyBodyToResponse();
    }
}
