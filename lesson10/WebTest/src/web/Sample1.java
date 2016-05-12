package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Sample1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = response.getWriter();
        pw.println("Some text<br>");
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy");
    }

}
