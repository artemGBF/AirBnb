package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath1 = getServletContext().getRealPath("data");
        resp.getWriter().write(realPath1);

        /*String realPath2 = getServletContext().getRealPath("WEB-INF");
        resp.getWriter().write(realPath2);*/
    }
}
