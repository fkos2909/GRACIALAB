package dev.gracialab.glab.config;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.logout.CompositeLogoutHandler;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessEventPublishingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class LogoutAccessDeniedHandler implements AccessDeniedHandler {

    // Default handler does an internal forward to a specified URL
    private final AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();

    // CompositeLogoutHandler to perform logout activities like normal logout would
    private final LogoutHandler logoutHandler = new CompositeLogoutHandler(
            new CookieClearingLogoutHandler("JSESSIONID"),
            new SecurityContextLogoutHandler(),
            new LogoutSuccessEventPublishingLogoutHandler()
    );

    public LogoutAccessDeniedHandler(String errorPage) {
        accessDeniedHandler.setErrorPage(errorPage);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        accessDeniedHandler.handle(request, response, accessDeniedException);
    }

}