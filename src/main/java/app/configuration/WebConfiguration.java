package app.configuration;

import app.interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry
				.addInterceptor(interceptor)
//				.addPathPatterns("/store/order")
//                .addPathPatterns("/user/auth")
                .addPathPatterns("/user/{id}");
//		        .addPathPatterns("/user/");
    }
}
