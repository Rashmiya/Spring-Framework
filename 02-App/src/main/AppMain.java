package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/item")
public class AppMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*catch the user inputs*/
        String item_name = req.getParameter("item_name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        String qty = req.getParameter("qty");

        /*deliver a response*/
        PrintWriter writer = resp.getWriter();
        writer.write("<table border='1' width='100%'>");

        writer.write("<thead>");
        writer.write("<tr><th>Item Name</th><th>Description</th><th>Price</th><th>Qty</th></tr>");
        writer.write("</thead>");

        writer.write("<tbody>");
        writer.write("<tr><th>"+item_name+"</th><th>"+description+"</th><th>"+price+"</th><th>"+qty+"</th></tr>");
        writer.write("</tbody>");

        writer.write("</table>");

       /* writer.write("<h1>"+item_name+"</h1>")
       writer.write("<h1>"+description+"</h1>");
        writer.write("<h1>"+price+"</h1>");
        writer.write("<h1>"+qty+"</h1>");*/

    }
}
