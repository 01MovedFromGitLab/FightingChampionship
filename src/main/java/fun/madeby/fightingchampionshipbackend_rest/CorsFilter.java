package fun.madeby.fightingchampionshipbackend_rest;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter{

@Override
public void init(FilterConfig filterConfig) throws ServletException {
	Filter.super.init(filterConfig);
}

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                     FilterChain filterChain) throws IOException, ServletException {
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	response.setHeader("Access-Control-Allow-Origin", "*"); //This is a bad idea for a private API
	response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE"); // Left out OPTIONS returns what is available via curl
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers",
		"Origin, X-Requested-With, Content-Type, Accept");
	filterChain.doFilter(servletRequest, servletResponse);
}

@Override
public void destroy() {
	Filter.super.destroy();
}
}
