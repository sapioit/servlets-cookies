package index;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class debug extends HttpServlet {
    
    
    /*
    public static void sqlQuery(PrintWriter out, String sql) throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement(sql);
            create.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed");
        }
    }
    */
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
    
    public static Connection getConnection(PrintWriter out) throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String db = "servletsdb";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url + db, username, password);
            //out.println("Connected");
            return conn;
        } catch(Exception e){
            out.println(e);
        }
        return null;
    }
    
    public static void createTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement(
                " CREATE TABLE IF NOT EXISTS users " +
                "(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                " user      VARCHAR(128)  NOT NULL, " + 
                " pass      VARCHAR(128)  NOT NULL, " + 
                " credits   int );" +
                " " +
                " CREATE TABLE IF NOT EXISTS contacts " +
                "(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
                " campaign  VARCHAR(16)  NOT NULL, " + 
                " link      VARCHAR(256)  NOT NULL, " + 
                " show      VARCHAR(256)  NOT NULL, " + 
                " width     int, " + 
                " height    int, " +
                " type      tinyint(2) ); "
            );
            create.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed");
        }
    }
    
    public static void populateTable() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement( ""
                + "INSERT INTO contacts "
                + "(nume, prenume, mobil, fix, email, adresa, oras, judet, codpostal)"
                + " values "
                + "('test', 'test', 'test', '', 'test@example.com', '', '', '', ''),"
                + "('Sapioit', 'Deicider', '0723822719', '', 'sapioit@gmail.com', '', '', '', ''),"
                + "('gogu', 'gheorghe', '048651', '045645654', 'sapioit@yandex.com', '', '', '', ''),"
                + "('gelu-gelosu'', 'Mihai', '452146502', '', 'a.mail@example.com', '', '', '', '');"
            );
            create.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Completed");
        }
    }
    
    /**************************************************************************/
    
    public static String sqlGet(PrintWriter out) throws Exception{
        try{
            String returnable = new String("");
            Connection con = getConnection();
            String sql = "select nume from contacts;";
            
            //Statement statement = con.createStatement();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            /*
            Statement statement = con.createStatement();
            ResultSet result = statement.execute(sql);s
            */
            /*
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            */
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
            //out.println("Completed sqlGet(\" select name from contacts; \");");
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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n<html>\n<head>\n<title>Servlet debug</title>");            
            out.println("</head>\n<body>\n<h1>Servlet debug at " + request.getContextPath() + "</h1>");
            out.println("<pre>");
            out.println("-Populating Table<br/>");
            String sql = "INSERT INTO contacts ("
                + "nume, prenume, mobil, fix, email, adresa, oras, judet, codpostal"
                + ") values ("
                + "'Sapioit', 'Deicider', '0723822719', '', 'sapioit@gmail.com', '', '', '', ''"
                + "), ("
                + "'gogu', 'gheorghe', '048651', '045645654', 'sapioit@yandex.com', '', '', '', ''"
                + "), ("
                + "'gelu-gelosu'', 'Mihai', '452146502', '', 'a.mail@example.com', '', '', '', ''"
                + ");";
            out.println("-viewRESULTS :<br/>");
            try{
                /*
                createTable();
                out.println("--created<br/>");
                populateTable();
                out.println("--populated<br/>");
                */
                //sqlGet(out);
                String b = sqlGet(out);
                //out.println(b+"<br/>---");
                String[] exploded = b.split("\n");
                for (String s: exploded) {
                    out.println(s); 
                }
                
                out.println("--get<br/>");
            } catch(Exception e) {
                out.println(e);
            }
            out.println("</pre>");
            out.println("<br/>Goodbye!");
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



/*
sql = " CREATE TABLE IF NOT EXISTS contacts " +
    "(ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, " +
    " nume         VARCHAR(256)  NOT NULL, " + 
    " prenume      VARCHAR(256)  NOT NULL, " + 
    " mobil        VARCHAR(15)   NOT NULL, " + 
    " fix          VARCHAR(15)           , " + 
    " email        VARCHAR(256)  NOT NULL, " +
    " adresa       VARCHAR(256)          , " +  
    " oras         VARCHAR(64)           , " +
    " judet        VARCHAR(64)           , " +
    " codpostal    VARCHAR(12)           ); ";

sql = "INSERT INTO contacts ("
    + "nume, prenume, mobil, fix, email, adresa, oras, judet, codpostal"
    + ") values ("
    + "'Sapioit', 'Deicider', '0723822719', '', 'sapioit@gmail.com', '', '', '', ''"
    + "), ("
    + "'gogu', 'gheorghe', '048651', '045645654', 'sapioit@yandex.com', '', '', '', ''"
    + "), ("
    + "'gelu-gelosu'', 'Mihai', '452146502', '', 'a.mail@example.com', '', '', '', ''"
    + ");";
*/






