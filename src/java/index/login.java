package index;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/servletsdb";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            /*System.out.println("Connected");*/
            return conn;
        } catch(Exception e){System.out.println(e);}
        return null;
    }
    
    public static String sqlGet(PrintWriter out) throws Exception{
        try{
            String returnable = new String("");
            Connection con = getConnection();
            String sql = "select nume from contacts;";
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            String temp;
            while(result.next()){
                temp = ""+result.getString("nume");
                //out.println(temp);
                returnable = returnable + temp + "\n";
            }
            //out.println(returnable);
            return returnable;
        } catch(SQLException e){
            out.println(e);
        } catch(Exception e) {
            out.println(e);
        } finally {
        }
        /*      
        String[] exploded = b.split("\n");
        for (String s: exploded) {
            out.println(s); 
        }
        */
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pageBody = "";
        try {
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
"    </head>\n" +
"    <body>\n" +
"        <h1>Servlet index at " + request.getContextPath() + "</h1>\n" +
"        <div class=\"menu\">\n" +
"            <a href=\"proiect-servlets-ads/index\">home</a>\n" +
"            <a href=\"proiect-servlets-ads/controlpanel\">controlpanel</a>\n" +
"            <a href=\"proiect-servlets-ads/ads\">ads</a>\n" +
"            <a href=\"proiect-servlets-ads/logout\">logout</a>\n" +
"            <a href=\"proiect-servlets-ads/debug\">debug</a>\n" +
"        </div>\n" +
"        <br/>\n" +
"        <form class=\"form ads\" action=\"login\" method=\"GET\">\n" +
"            <br/><input type=\"text\" name=\"username\" placeholder=\"username\" required />\n" +
"            <input type=\"password\" name=\"password\" placeholder=\"password\" required />\n" +
"            <input type=\"submit\"  name=\"save\" value=\"Save\" />\n" +
"        </form>\n" +
"    </body>\n" +
"</html>";
            out.println("\n" + pageBody + "\n");
        } finally {
            out.close();
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Boolean login = false;
        String pageBody;
        String sql;
        String result;
        String[] exploded;
        try {
            if(user != null && pass != null){
                sql = "SELECT count(user) FROM users"+
                    "WHERE user = '" + user + "'" +
                    " AND pass = '" + pass + "';";
                result = sqlGet(sql);
                out.println("<pre>"+result+"</pre>");
                if (Integer.ParseInt(result) == 1)
                    login = true;
            }
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
"        </style>\n";
            if (login) {
                // check with what user ID I am logged in 
                sql = "SELECT id FROM users"+
                    "WHERE user = '" + user + "'" +
                    " AND pass = '" + pass + "';";
                result = sqlGet(sql);
                out.println("<pre>"+result+"</pre>");   
                // got the id, now storing it in a cookie      
                Cookie uid = new Cookie("uid", result);
                uid.setMaxAge(60*60*24); 
                response.addCookie( uid );
                // done. Now refreshing the page.
                pageBody = pageBody + 
"        <meta http-equiv=\"refresh\" content=\"1; url=ads\" />";
            }
            pageBody = pageBody +
"    </head>\n" +
"    <body>\n" +
"        <h1>Servlet index at " + request.getContextPath() + "</h1>\n" +
"        <div class=\"menu\">\n" +
"            <a href=\"\">home</a>\n" +
"            <a href=\"proiect-servlets-ads/controlpanel\">controlpanel</a>\n" +
"            <a href=\"proiect-servlets-ads/ads\">ads</a>\n" +
"            <a href=\"proiect-servlets-ads/logout\">logout</a>\n" +
"            <a href=\"proiect-servlets-ads/debug\">debug</a>\n" +
"        </div>\n" +
"        <br/>\n" +
"        <form class=\"form ads\" action=\"login\" method=\"GET\">\n" +
"            <br/><input type=\"text\" name=\"username\" placeholder=\"username\" required />\n" +
"            <input type=\"password\" name=\"password\" placeholder=\"password\" required />\n" +
"            <input type=\"submit\"  name=\"save\" value=\"Save\" />\n" +
"        </form>\n" +
"    </body>\n" +
"</html>";
            out.println("\n" + pageBody + "\n");
        }
        finally {
            out.close();
        }
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
