package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.sql.*;

public final class project_005fstatus_005ftable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("     \t<center>\n");
      out.write("            <label><h3><u>Project Status Table</u><h3></label>\n");
      out.write("                        </center>\n");
      out.write("          <div class=\"container pt-3\">            \n");
      out.write("                <table class=\"table table-dark table-hover\">\n");
      out.write("                  <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th><h3><u></u></h3></th>\n");
      out.write("                        <th><h3><u>Status 1</u></h3></th>\n");
      out.write("                        <th><h3><u>Status 2</u></h3></th>\n");
      out.write("                        <th><h3><u>Status 3</u></h3></th>\n");
      out.write("                        <th><h3><u>Status 4</u></h3></th>\n");
      out.write("                        <th><h3><u>Status 5</u></h3></th>\n");
      out.write("                    </tr>\n");
      out.write("                  </thead>\n");
      out.write("                  <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                       <td><h3><u>Project 1</u></h3></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                     <tr>\n");
      out.write("                       <td><h3><u>Project 2</u></h3></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                     <tr>\n");
      out.write("                       <td><h3><u>Project 3</u></h3></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                     <tr>\n");
      out.write("                       <td><h3><u>Project 4</u></h3></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                     <tr>\n");
      out.write("                       <td><h3><u>Project 5</u></h3></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                       <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
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
