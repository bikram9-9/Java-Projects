import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

@WebServlet("/fileUpload") 
@MultipartConfig(maxFileSize = 1024 * 1024 * 2000)
public class UploadServlet extends HttpServlet{

    List<FileItem>  multifiles;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		
		PrintWriter out = res.getWriter();
		
		// the way to fetch is using ServletFileUpload class
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		try {
		 multifiles = sf.parseRequest(new ServletRequestContext(req));
		} catch (FileUploadException e) {
			out.println("files not added");
			e.printStackTrace();
		}
		
		String filePath = getServletContext().getInitParameter("uploadPath");
		
		for(FileItem item: multifiles) {
				try {
					item.write(new File(filePath + item.getName()));
					out.println("File Successfully uploaded to server");
				} catch (Exception e) {
					e.printStackTrace();
				}	
		}
		
	}
}
	
		
	
	
