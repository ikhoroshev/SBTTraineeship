package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Sample5 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Cookie c = new Cookie("visited", "true");
        response.addCookie(c);

        PrintWriter pw = response.getWriter();

        String str = request.getParameter("param");
        pw.println("Param = " + str + "<br>");

        if (str == null || "".equals(str)) {
            pw.println("The default case");
        } else if ("r".equals(str)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("session_parameter", "session_value");
            response.sendRedirect("/show.jsp?parameter=Redirect");
        } else if ("f".equals(str)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("session_parameter", "session_value!!!");
            getServletContext().getRequestDispatcher("/show.jsp?parameter=Forward").forward(request, response);
        } else {
            pw.println("Something different");
        }
        pw.println("<br>");

        Cookie[] cookies = request.getCookies();
        boolean visited = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visited".equals(cookie.getName())) {
                    visited = true;
                }
                pw.println(cookie.getName() + " : " + cookie.getValue() + "<br>");
            }
        }

        if (visited) {
            pw.println("Hello снова");
        } else {
            pw.println("Hello");
        }
        pw.println("<br>");

        pw.println("Admin email: " + getServletContext().getInitParameter("email"));
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        System.out.println("init");

        ServletContext context = config.getServletContext();
        String isDebug = config.getInitParameter("debug");

        System.out.println("Admin email: " + context.getInitParameter("email"));

        System.out.println("debug = " + isDebug);
    }

    public void destroy() {
        System.out.println("destroy");
    }

}
