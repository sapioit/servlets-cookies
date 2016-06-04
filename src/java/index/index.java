
package index;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author SapioiT
 */
@WebServlet(name = "index_1", urlPatterns = {"/index_1"})
public class index extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("" +
"<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>JSP Page</title>\n" +
"        <style>\n" +
"            * { paddimg: 0; margin: 0; border: 0; border: none; vertical-align: baseline; }\n" +
"            body {\n" +
"                background-color: #eee;\n" +
"            }\n" +
"            .menu {\n" +
"                display: inline-block;\n" +
"                text-align: center;\n" +
"              \n" +
"            }\n" +
"            .menu a {\n" +
"                padding: 15px;\n" +
"                display: inline-block;\n" +
"                float: left;\n" +
"                text-decoration: none;\n" +
"                font-weight: bold;\n" +
"                color: #9892a2;\n" +
"                font-size: 20px;\n" +
"                font-family: \"'Lucida Console', Consolas, Serif\";\n" +
"            }\n" +
"            .menu a:last-child {\n" +
"                color: #bb92a2;\n" +
"            }\n" +
"            .menu a:hover {\n" +
"                color: #444;\n" +
"            }\n" +
"            .form {\n" +
"                font-size: 14px;\n" +
"            }\n" +
"            .form * {\n" +
"                float: left;\n" +
"                margin: 5px;\n" +
"            }\n" +
"            .form input[type=\"email\"]{\n" +
"                width: 150px;\n" +
"            }\n" +
"            .form input[type=\"password\"]{\n" +
"                width: 100px;\n" +
"            }\n" +
"            .form input[type=\"submit\"]{\n" +
"                width: 50px;\n" +
"            }\n" +
"            .adscode {\n" +
"                width: 300px;\n" +
"                height: 50px;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Servlet index at \" + request.getContextPath() + \"</h1>\n" +
"        <div class=\"menu\">\n" +
"            <a href=\"controlpanel\">controlpanel</a>\n" +
"            <a href=\"ads\">ads</a>\n" +
"            <a href=\"login\">login</a>\n" +
"            <a href=\"logout\">logout</a>\n" +
"            <a href=\"debug\">debug</a>\n" +
"        </div>\n" +
"    </body>\n" +
"</html>");
            out.println("");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Reinstalls the Database";
    }
}
