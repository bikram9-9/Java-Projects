
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;

@WebServlet("/fileDownload")

public class DownloadServlet extends HttpServlet {
	
	String downloadFilePath = getServletConfig().getInitParameter("downloadPath");
	String uploadFilePath = getServletContext().getInitParameter("uploadPath");
	String filename = "minors.pdf";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		PrintWriter out = res.getWriter();
		
		FileInputStream fileInputStream = new FileInputStream(uploadFilePath+ filename);
		
		int i = 0;
		while((i = fileInputStream.read()) != -1 ) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
		out.println(filename);
	}
}
