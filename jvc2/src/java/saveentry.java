/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minshu Kumar
 */
public class saveentry extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
           if(req.getParameter("projectname")!="")
           {
             try {
                  String name=req.getParameter("projectname");
                  String status=req.getParameter("projectstatus");
                  String assign=req.getParameter("projectassign");
                  String note=req.getParameter("projectnotes");
                  
                  Properties p=new Properties();
                InputStream is=new FileInputStream("db.properties");
                p.load(is);

                String url=p.getProperty("url");
                String username=p.getProperty("username");
                String pass=p.getProperty("pass");
                
                  
                  Connection con;
                  PreparedStatement pst;
                  //Class.forName("org.sqlite.JDBC");
                 Class.forName("com.mysql.jdbc.Driver");
                  
                  //con=DriverManager.getConnection("jdbc:sqlite:F:\\java_sql_database\\jvc.db");
                  con=DriverManager.getConnection(url,username,pass);
                  Statement s=con.createStatement();
                  pst=con.prepareStatement("INSERT INTO projectentry(projectname,status,assign,note) VALUES(?,?,?,?)");
                  pst.setString(1, name);
                  pst.setString(2, status);
                  pst.setString(3, assign);
                  pst.setString(4, note);
                  
                  pst.executeUpdate();
                  con.close();
                  pst.close();
                  
                  PrintWriter out=res.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Entry Saved!');");
                    out.println("location='entry.jsp';");
                    out.println("</script>");
              } catch (Exception e) {
                 System.out.println(e.getMessage());
              } 
           }
          else
          {
              res.sendRedirect("entry.jsp");
          }
    }
}
