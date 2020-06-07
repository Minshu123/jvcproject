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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minshu Kumar
 */
public class updateentryservlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        String id="" ;
         Cookie co[]=req.getCookies();
         for(Cookie c:co)
         {
             if(c.getName().equals("Id"))
             {
                 id=c.getValue();
             }
         }
         PrintWriter out =res.getWriter();
         if(req.getParameter("projectnameupdate")!=""&&req.getParameter("projectnotesupdate")!="")
         {
             String nameupdate=req.getParameter("projectnameupdate");
             String statusupdate=req.getParameter("projectstatusupdate");
             String assignupdate=req.getParameter("projectassignupdate");
             String noteupdate=req.getParameter("projectnotesupdate");
               Properties p=new Properties();
               InputStream is=new FileInputStream("db.properties");
               p.load(is);

               String url=p.getProperty("url");
               String username=p.getProperty("username");
               String pass=p.getProperty("pass");

                ResultSet rs;
                Connection con;
                PreparedStatement pst;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(url,username,pass);
                pst=con.prepareStatement("update projectentry set projectname = ?,status = ?,assign = ?,note = ? where Id =?");
                pst.setString(1, nameupdate);
                pst.setString(2, statusupdate);
                pst.setString(3, assignupdate);
                pst.setString(4, noteupdate);
                pst.setString(5,id);
                pst.executeUpdate();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Project Entry Updated!');");
                out.println("location='entry.jsp';");
                out.println("</script>");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(updateassignservlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(updateassignservlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                
         }
         else
         {
             res.sendRedirect("updateentry.jsp?Id="+id);
         }
    }
}
