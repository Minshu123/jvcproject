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
 </head>
 <body>
 	<div class="container pt-3 ">
 	<center>
            <label><h3><u>Project Entry</u><h3></label>
                        </center>
            <div class="row">
                <div class="col-sm-8">
                    <form method="get" action="saveentry">
 			<div class="form-group">
                            <label for="email"><b>Project name:</b></label> <input type="text"
 					class="form-control" id="email" placeholder="Enter project name"
 					name="projectname">
 			</div>
                        
                        <div class="row">
                            <div class="form-group col-sm-3">
                                <label for="email"><b>Status:</b></label><br> 
                                    <select class="btn btn-primary" name="projectstatus">
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
                                                          con=DriverManager.getConnection(url,username,pass);
                                                          String query="select * from master_status";
                                                          Statement st=con.createStatement();
                                                          rs=st.executeQuery(query);
                                                          while(rs.next())
                                                          {
                                                  %>
                                                <option><a class="dropdown-item" href="#"><%=rs.getString("status")%></a></option>
                                             <%
                                            }
                                            rs.close();
                                            con.close();
                                            %>
                                    </select>
                              
                            </div>
                            
                            <div class="form-group col-sm-2">
                            <label for="email"><b>Assign To:</b></label>
                                <select class="btn btn-primary" name="projectassign">
                                      <%
                                             
                                                  //Class.forName("org.sqlite.JDBC");
                                                 Class.forName("com.mysql.jdbc.Driver");

                                                  //con=DriverManager.getConnection("jdbc:sqlite:F:\\java_sql_database\\jvc.db");
                                                  con=DriverManager.getConnection(url,username,pass);
                                                  query="select * from Master_assign";
                                                  st=con.createStatement();
                                                  rs=st.executeQuery(query);
                                                  while(rs.next())
                                                  {
                                          %>
                                    <option><a class="dropdown-item" href="#"><%=rs.getString("assign")%></a></option>
                                     <%
                                        }
                                         rs.close();
                                         con.close();
                                      %>
                                </select>
                            </div>
                        </div>
                       
                        
                    
                        
                        <div class="form-group">
                            <label for="email"><b>Notes:</b></label> <input type="text"
 					class="form-control" id="email" placeholder="Enter notes"
 					name="projectnotes">
 			</div>
                        
 			<button type="submit" class="btn btn-primary">Submit</button>
                </form>
                </div>
            </div>
 	</div>
        
          <div class="container pt-3">            
                <table class="table table-dark table-hover">
                  <thead>
                    <tr>
                        <th><h3><u>Project Name</u></h3></th>
                        <th><h3><u>Status</u></h3></th>
                        <th><h3><u>Assign</u></h3></th>
                        <th><h3><u>Notes</u></h3></th>
                        <th><h3><u>Edit</u></h3></th>
                        <th><h3><u>Delete</u></h3></th>
                        <th><h3><u>Add</u></h3></th>
                    </tr>
                  </thead>
                  <tbody>
                      <%
                            
                            p.load(is);
                              //Class.forName("org.sqlite.JDBC");
                             Class.forName("com.mysql.jdbc.Driver");

                              //con=DriverManager.getConnection("jdbc:sqlite:F:\\java_sql_database\\jvc.db");
                              con=DriverManager.getConnection(url,username,pass);
                              query="select * from projectentry";
                              st=con.createStatement();
                              rs=st.executeQuery(query);
                              while(rs.next())
                              {
                              String Id=rs.getString("Id");
                      %>
                    <tr>
                      <td><%=rs.getString("projectname")%></td>
                      <td><%=rs.getString("status")%></td>
                      <td><%=rs.getString("assign")%></td>
                      <td><%=rs.getString("note")%></td>
                      <td><a role="button" href="updateentry.jsp?Id=<%=Id%>" class="btn btn-primary " >Edit</a></td>
                      <td><a role="button"  href="deleteentry.jsp?Id=<%=Id%>" class="btn btn-primary">Delete</a></td>
                      <td><a role="button"  href="effort.jsp?Id=<%=Id%>" class="btn btn-primary">Add Effort</a></td>
                    </tr>
                    <%
                        }
                     rs.close();
                     con.close();
                    %>
                  </tbody>
                </table>
        </div>
 </body>
 </html>
