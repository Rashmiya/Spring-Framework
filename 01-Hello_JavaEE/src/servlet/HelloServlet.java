package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

        PrintWriter writer = resp.getWriter();
       /* writer.write("<h1>This is your response</h1>"); */

        writer.write("<ul>");
        writer.write("<li>"+id+"</li>");
        writer.write("<li>"+name+"</li>");
        writer.write("<li>"+address+"</li>");
        writer.write("<li>"+salary+"</li>");
        writer.write("</ul>");

    }

    /*servlet ekata monawahri enawanm e ena hemdema,"HttpServletRequest" object eka through catch krgnna puluwn.*/
    /*default request method eka = GET*/
    /**/

}
