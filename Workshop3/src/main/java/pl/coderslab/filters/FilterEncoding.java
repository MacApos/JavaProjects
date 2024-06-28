package pl.coderslab.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class FilterEncoding implements Filter {
    private String charsetEncoding = "utf-8";
    private String contentType = "text/html;charset=utf-8";

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(charsetEncoding);
        response.setContentType(contentType);
        response.setCharacterEncoding(charsetEncoding);
        filterChain.doFilter(request, response);

    }
}