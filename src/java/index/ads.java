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

public class ads extends HttpServlet {
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
        String sql;
        String result;
        String[] exploded;
        String uid = "";
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
"        <h1>Servlet index at \" + request.getContextPath() + \"</h1>\n" +
"        <div class=\"menu\">\n" +
"            <a href=\"proiect-servlets/home\">home</a>\n" +
"            <a href=\"proiect-servlets/controlpanel\">controlpanel</a>\n" +
"            <a href=\"proiect-servlets/ads\">ads</a>\n" +
"            <a href=\"proiect-servlets/logout\">logout</a>\n" +
"            <a href=\"proiect-servlets/debug\">debug</a>\n" +
"        </div>\n" +
"        <h3>Add AD</h3>\n" +
"        <form class=\"form add\" action=\"ads\" method=\"GET\">\n" +
"            <input type=\"text\" name=\"campaign\" placeholder=\"campaign\" required />\n" +
"            <input type=\"text\" name=\"type\" placeholder=\"type\" required />\n" +
"            <input type=\"text\" name=\"width\" placeholder=\"width\" required />\n" +
"            <input type=\"text\" name=\"height\" placeholder=\"height\" required />\n" +
"            <br/>\n" +
"            <input type=\"text\" name=\"link\" placeholder=\"link\" required />\n" +
"            <input type=\"text\" name=\"show\" placeholder=\"show\" required /> <br/>\n" +
"            <input type=\"submit\"  name=\"save\" value=\"Save\" />\n" +
"            <input type=\"submit\"  name=\"delete\" value=\"Delete\" />\n" +
"        </form>\n" +
"        <h3>See/Edit ADS</h3>";
            
            Cookie[] cookies = request.getCookies();
            for (int i=0; i < cookies.length; i++) {
                if ( (cookies[i].getName()).equals("uid"))
                    uid = cookies[i].getValue();
            }
            sql = "SELECT * FROM ads"+
                "WHERE uid = '" + uid + "';";
            result = sqlGet(sql);
            
            String cell = "";
            int n=0; // 7 collumns
            int length = 0; // counting the result(s)
            String[] exploded = b.split("\n");
            for (String s: exploded) {
                length++;
            }
            for (int i=0;i<n/7;i++) {
                cell = cell + 
    "            <form class=\"ad form\" action=\"ads\" method=\"GET\">\n" +
    "                <input type=\"text\" name=\"id\" value=\""+ exploded[7*i+0]+"\" placeholder=\"id\" required />\n" +
    "                <input type=\"text\" name=\"campaign\" value=\""+ exploded[7*i+1] +"\" placeholder=\"campaign\" required />\n" +
    "                <input type=\"text\" name=\"link\" value=\""+ exploded[7*i+2] +"\" placeholder=\"link\" required />\n" +
    "                <input type=\"text\" name=\"shows\" value=\""+ exploded[7*i+3] +"\" placeholder=\"shows\" required /> <br/>\n" +
    "                <input type=\"text\" name=\"width\" value=\""+ exploded[7*i+4] +"\" placeholder=\"width\" required />\n" +
    "                <input type=\"text\" name=\"height\" value=\""+ exploded[7*i+5] +"\" placeholder=\"height\" required />\n" +
    "                <input type=\"text\" name=\"type\" value=\""+ exploded[7*i+6] +"\" placeholder=\"type\" required />\n" +
    "                <input type=\"submit\"  name=\"update\" value=\"Update\" />\n" +
    "                <input type=\"submit\"  name=\"delete\" value=\"Delete\" />\n" +
    "            </form>";
            }
            
            if(request.getParameter("id").length > 0 &&
               request.getParameter("campaign").length > 0 &&
               request.getParameter("link").length > 0 &&
               request.getParameter("shows").length > 0 &&
               request.getParameter("width").length > 0 &&
               request.getParameter("height").length > 0 &&
               request.getParameter("image").length > 0 ){
                // update
                sql = "UPDATE ads" +
                    "SET" +
                    "link = '"+request.getParameter("link")+"'" +
                    "link = '+""+'" +
                    "link = '+"width"+'" +
                    "link = '+"height""+'" +
                    "link = '+"type"+'" +
                    "WHERE id = '+"id"+';";
                result = sqlGet(sql);
            }
            if(request.getParameter("campaign").length > 0 &&
               request.getParameter("link").length > 0 &&
               request.getParameter("shows").length > 0 &&
               request.getParameter("width").length > 0 &&
               request.getParameter("height").length > 0 &&
               request.getParameter("image").length > 0 ){
                // add
                sql = "SELECT * FROM ads"+
                    "WHERE uid = '" + uid + "';";
                result = sqlGet(sql);
            }
            
            pageBody = pageBody +
"        </div>\n" +
"        <br/>\n" +
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
