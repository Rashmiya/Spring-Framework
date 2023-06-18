package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customer")   /*ena request eka catch karagnnawa*/
//ethkota form eka submit krnkota e adala data tika ewith wetenne methnata.
//servlets kiyana aspect eka thulin thama , WebServlet annotation eka enne.
public class HelloServlet extends HttpServlet {
    // customer kiyna location ekata ena data tika catch karagenimta awashya krna methods tika thiyenne me HttpServlet eka ethule.
    //e hinda thama eka inherit krgnne.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String salary = req.getParameter("salary");
        System.out.println(id+"-"+name+"-"+address+"-"+salary);
    }

}
