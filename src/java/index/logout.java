package index;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logout extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pageBody = "";
        String sql;
        String result;
        String[] exploded;
        try {
            Cookie uid = new Cookie("uid", result);
            uid.setMaxAge(1); 
            response.addCookie( uid );
            pageBody = "" + 
"<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>JSP Page</title>\n" +
"        <style>\n" +
"            * { paddimg: 0; margin: 0; border: 0; border: none; vertical-align: baseline; }\n" +
"            body {\n" +
"                background-color: #eee;\n" +
"                text-align: center;\n" +
"                color: #9892a2;\n" +
"            }\n" +
"            body * {\n" +
"                text-align: left;\n" +
"            }\n" +
"            /*\n" +
"            @media all and (min-width: 600px) {\n" +
"                body {\n" +
"                  padding: 0%;\n" +
"                }\n" +
"            }\n" +
"            */\n" +
"            input[type=\"submit\"]{\n" +
"                background-color: #9892a2;\n" +
"                color: #fff;\n" +
"            }\n" +
"            input[type=\"submit\"][name=\"delete\"]{\n" +
"                background-color: #bb92a2;\n" +
"            }\n" +
"            .menu {\n" +
"                display: inline-block;\n" +
"                text-align: center;\n" +
"              \n" +
"            }\n" +
"            .menu a {\n" +
"                padding: 16px;\n" +
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
"                height: 16px;\n" +
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
"            .ads {\n" +
"                min-width: 320px;\n" +
"                max-width: 984px;\n" +
"                margin: 15px;\n" +
"                display: inline-block;\n" +
"                text-decoration: none;\n" +
"                /*font-weight: bold;*/\n" +
"                color: #9892a2;\n" +
"                font-size: 20px;\n" +
"                font-family: \"'Lucida Console', Consolas, Serif\";\n" +
"            }\n" +
"            ads a {\n" +
"                color: #bb92a2;\n" +
"            }\n" +
"            .ad {\n" +
"                width: 320px;\n" +
"                background-color: #f3f3f3;\n" +
"                display: inline-block;\n" +
"                margin-bottom: 13px;\n" +
"            }\n" +
"            .add {\n" +
"                max-width: 984px;\n" +
"                max-height: 140px;\n" +
"                background-color: #f3f3f3;\n" +
"                display: inline-block;\n" +
"                margin: 15px;\n" +
"            }\n" +
"            .form input[name=\"link\"], .form input[name=\"show\"]{\n" +
"                width: 310px;\n" +
"            }\n" +
"            .adscode {\n" +
"                width: 300px;\n" +
"                height: 50px;\n" +
"            }\n" +
"        </style>\n" +
"        <meta http-equiv=\"refresh\" content=\"3; url=proiect-servlets/index\" />\n" +
"    </head>\n" +
"    <body>\n" +
"        <h1>Servlet index at " + request.getContextPath() + "</h1>\n" +
"        <div class=\"menu\">\n" +
"            <a href=\"\">home</a>\n" +
"            <a href=\"controlpanel\">controlpanel</a>\n" +
"            <a href=\"ads\">ads</a>\n" +
"            <a href=\"login\">login</a>\n" +
"            <a href=\"debug\">debug</a>\n" +
"        </div>\n" +
"        <br/>\n" +
"        <h2>You are now logged out.</h2>\n" +
"    </body>\n" +
"</html>";
            out.println(pageBody);
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
        return "Short description";
    }

}
