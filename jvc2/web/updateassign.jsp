<%-- 
    Document   : update
    Created on : 4 May, 2020, 11:30:36 PM
    Author     : Minshu Kumar
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Guru Form</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet"
 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <script
 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script
 	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
 <script
 	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 
 <%!
     String Id; 
 %>
 </head>
 <body>
 	<div class="container pt-3 ">
 	<center>
            <label><h3>Assign Update<h3></label>
 	</center>
            <div class="row">
                <div class="col-sm-8">
                    <form method="get" action="updateassignservlet">
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
                             Cookie co=new Cookie("Id",Id+"");
                             response.addCookie(co);
                              con=DriverManager.getConnection(url,username,pass);
                              pst=con.prepareStatement("select * from Master_assign where Id =?");
                              pst.setString(1, Id);
                              rs=pst.executeQuery();
                              while(rs.next())
                              {
                      %>
 			<div class="form-group">
                            <label for="email"><b>Assign:</b></label> 
                                <input type="text" value="<%=rs.getString("assign")%>"
 					class="form-control" id="email" placeholder="Enter assign"
 					name="assign1update">
 			</div>
 			<button type="submit" name="updateassign" class="btn btn-primary">Update</button>
                        <%
                            }
                        %>
                </form>
                </div>
            </div>
 	</div>
       
 </body>
 </html>

