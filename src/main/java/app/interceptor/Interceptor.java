package app.interceptor;

import app.service.PetService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String key = request.getHeader("Key");
        if (userService.valid(key)) return true;
            else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

    }
}
