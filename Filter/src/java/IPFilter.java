/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author SHREEJI
 */
public class IPFilter implements Filter {
    static String ip="127.0.0.1";
    FilterConfig fc=null;
    public void init(FilterConfig fc) throws ServletException {
    this.fc=fc;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    
    out.print("<h1> IP Filter </h1>");
    String userip=req.getRemoteAddr();
    out.print(userip);
    if(userip.equals(ip)){
        fc.doFilter(req, res);
    }else{
        out.print("Not allow Your IP.");
    }
    }

    
    public void destroy() {
    
    }
    
}
