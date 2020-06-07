package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;

public final class entry_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write(" <html>\n");
      out.write(" <head>\n");
      out.write(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write(" <title>Guru Form</title>\n");
      out.write(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write(" <link rel=\"stylesheet\"\n");
      out.write(" \thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write(" <script\n");
      out.write(" \tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write(" <script\n");
      out.write(" \tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n");
      out.write(" <script\n");
      out.write(" \tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\n");
      out.write(" </head>\n");
      out.write(" <body>\n");
      out.write(" \t<div class=\"container pt-3 \">\n");
      out.write(" \t<center>\n");
      out.write("            <label><h3><u>Project Entry</u><h3></label>\n");
      out.write("                        </center>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-8\">\n");
      out.write("                    <form method=\"get\" action=\"saveentry\">\n");
      out.write(" \t\t\t<div class=\"form-group\">\n");
      out.write("                            <label for=\"email\"><b>Project name:</b></label> <input type=\"text\"\n");
      out.write(" \t\t\t\t\tclass=\"form-control\" id=\"email\" placeholder=\"Enter project name\"\n");
      out.write(" \t\t\t\t\tname=\"projectname\">\n");
      out.write(" \t\t\t</div>\n");
      out.write("                        \n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"form-group col-sm-3\">\n");
      out.write("                                <label for=\"email\"><b>Status:</b></label><br> \n");
      out.write("                                    <select class=\"btn btn-primary\" name=\"projectstatus\">\n");
      out.write("                                               ");

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
                                                  
      out.write("\n");
      out.write("                                                <option><a class=\"dropdown-item\" href=\"#\">");
      out.print(rs.getString("status"));
      out.write("</a></option>\n");
      out.write("                                             ");

                                            }
                                            rs.close();
                                            con.close();
                                            
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                              \n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"form-group col-sm-2\">\n");
      out.write("                            <label for=\"email\"><b>Assign To:</b></label>\n");
      out.write("                                <select class=\"btn btn-primary\" name=\"projectassign\">\n");
      out.write("                                      ");

                                             
                                                  //Class.forName("org.sqlite.JDBC");
                                                 Class.forName("com.mysql.jdbc.Driver");

                                                  //con=DriverManager.getConnection("jdbc:sqlite:F:\\java_sql_database\\jvc.db");
                                                  con=DriverManager.getConnection(url,username,pass);
                                                  query="select * from Master_assign";
                                                  st=con.createStatement();
                                                  rs=st.executeQuery(query);
                                                  while(rs.next())
                                                  {
                                          
      out.write("\n");
      out.write("                                    <option><a class=\"dropdown-item\" href=\"#\">");
      out.print(rs.getString("assign"));
      out.write("</a></option>\n");
      out.write("                                     ");

                                        }
                                         rs.close();
                                         con.close();
                                      
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                       \n");
      out.write("                        \n");
      out.write("                    \n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"email\"><b>Notes:</b></label> <input type=\"text\"\n");
      out.write(" \t\t\t\t\tclass=\"form-control\" id=\"email\" placeholder=\"Enter notes\"\n");
      out.write(" \t\t\t\t\tname=\"projectnotes\">\n");
      out.write(" \t\t\t</div>\n");
      out.write("                        \n");
      out.write(" \t\t\t<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("                </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write(" \t</div>\n");
      out.write("        \n");
      out.write("          <div class=\"container pt-3\">            \n");
      out.write("                <table class=\"table table-dark table-hover\">\n");
      out.write("                  <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th><h3><u>Project Name</u></h3></th>\n");
      out.write("                        <th><h3><u>Status</u></h3></th>\n");
      out.write("                        <th><h3><u>Assign</u></h3></th>\n");
      out.write("                        <th><h3><u>Notes</u></h3></th>\n");
      out.write("                        <th><h3><u>Edit</u></h3></th>\n");
      out.write("                        <th><h3><u>Delete</u></h3></th>\n");
      out.write("                        <th><h3><u>Add</u></h3></th>\n");
      out.write("                    </tr>\n");
      out.write("                  </thead>\n");
      out.write("                  <tbody>\n");
      out.write("                      ");

                            
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
                      
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                      <td>");
      out.print(rs.getString("projectname"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getString("status"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getString("assign"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getString("note"));
      out.write("</td>\n");
      out.write("                      <td><a role=\"button\" href=\"updateentry.jsp?Id=");
      out.print(Id);
      out.write("\" class=\"btn btn-primary \" >Edit</a></td>\n");
      out.write("                      <td><a role=\"button\"  href=\"deleteentry.jsp?Id=");
      out.print(Id);
      out.write("\" class=\"btn btn-primary\">Delete</a></td>\n");
      out.write("                      <td><a role=\"button\"  href=\"effort.jsp?Id=");
      out.print(Id);
      out.write("\" class=\"btn btn-primary\">Add Effort</a></td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                     rs.close();
                     con.close();
                    
      out.write("\n");
      out.write("                  </tbody>\n");
      out.write("                </table>\n");
      out.write("        </div>\n");
      out.write(" </body>\n");
      out.write(" </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
