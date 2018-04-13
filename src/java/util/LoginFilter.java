/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.LoginUserInfo;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Casper
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        String pageRequested = req.getRequestURI();

        LoginUserInfo u = (LoginUserInfo) session.getAttribute("user");
        if (u == null) {
            if (!pageRequested.contains("index")) {
                res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (u.isAuthStatus()) {
                if (!pageRequested.contains("resource")) {

                    if (u.hasPerm(pageRequested, req.getContextPath()) || pageRequested.contains("index")) {
                        chain.doFilter(request, response);
                    } else {
                        res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
                    }

                } else {
                    chain.doFilter(request, response);
                }

            } else {
                if (!pageRequested.contains("index")) {
                    res.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
                }
                else{
                    chain.doFilter(request, response);
                }
            }
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
