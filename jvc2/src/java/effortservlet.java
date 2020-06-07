/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Minshu Kumar
 */
public class effortservlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
        try {
          List<FileItem> multifiles = sf.parseRequest((RequestContext) req);
          for(FileItem item:multifiles)
          {
              item.write(new File("F:\\task\\"+item.getName()));
              PrintWriter out=res.getWriter();
                out.println(item.getName()+"");
          }
        } catch (FileUploadException ex) {
            Logger.getLogger(effortservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(effortservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
