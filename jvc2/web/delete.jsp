<%-- 
    Document   : delete
    Created on : 4 May, 2020, 11:56:12 PM
    Author     : Minshu Kumar
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%!
     String Id; 
 %>
 
     <%
         Properties p=new Properties();
                            InputStream is=new FileInputStream("db.properties");
                            p.load(is);

                            String url=p.getProperty("url");
                            String username=p.getProperty("username");
                            String pass=p.getProperty("pass");

                              ResultSet rs;
                              Connection con;
                              PreparedStatement pst;
                              //Class.forName("org.sqlite.JDBC");
                             Class.forName("com.mysql.jdbc.Driver");

                              //con=DriverManager.getConnection("jdbc:sqlite:F:\\java_sql_database\\jvc.db");
                              
                              Id=request.getParameter("Id");
                              con=DriverManager.getConnection(url,username,pass);
                              pst=con.prepareStatement("delete from master_status where Id =?");
                              pst.setString(1,Id);
                              pst.executeUpdate();
                              out.println(Id);
     %>
                              <script>
                                  
                                  alert("Status Deleted!");
                                  location="status.jsp";
                              </script>
