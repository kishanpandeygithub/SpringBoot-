package in.kishanPandey.Day22_Spring_Intercepror.config;

import in.kishanPandey.Day22_Spring_Intercepror.interceptor.AuthanticationInterceptor;
import in.kishanPandey.Day22_Spring_Intercepror.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptor loggingInterceptor;
    public AuthanticationInterceptor authanticationInterceptor;
    public  WebConfig(LoggingInterceptor interceptor , AuthanticationInterceptor authanticationInterceptor){
        this.loggingInterceptor= interceptor;
        this.authanticationInterceptor = authanticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/admin/*").order(1);
        registry.addInterceptor(authanticationInterceptor).order(3);
    }
}
