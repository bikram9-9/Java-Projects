import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	
	//load the driver and connect to driver in try catch
	//form a connection through DriverManager in try catch
	
public void Connection() {
	String url = "jdbc:mysql://127.0.0.1:3306/telusko?serverTimezone=UTC";
	String uname = "root";
	String pswd = "Bikky_123";
	Connection con =null;
	Statement st;
	
	//Defining variables for queries
	String createTable="CREATE TABLE landmarks(Name VARCHAR(40) PRIMARY KEY, images mediumblob)";
	String getAllImages = "SELECT images FROM landmarks";
	String addRow = "INSERT INTO landmarks(Name, images)  VALUES (?,?)";
	String filePath1 = "/Users/apple/Desktop/tajMahal.jpg";
	String filePath2 = "/Users/apple/Desktop/greatWall.jpg";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace(); 
	}
	
	
	
	try {
		 con = DriverManager.getConnection(url,uname,pswd);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	
	//Create Table and insert images as Blob files into database
	
	try {
		 st = con.createStatement();
		st.executeUpdate(createTable);
			
		//Inserting files into the jdbc
		PreparedStatement ps = con.prepareStatement(addRow);
		ps.setString(1,"Taj Mahal");
		InputStream io = new FileInputStream(new File(filePath1));
		ps.setBlob(2, io);
		ps.executeUpdate();
		
		 io = new FileInputStream(new File(filePath2));
		ps.setString(1, "Great Wall of China");
		ps.setBlob(2, io);
		ps.execute();
		
		
		FileOutputStream out = new FileOutputStream(new File("returned_pic.jpg"));
		ResultSet rs = st.executeQuery(getAllImages);
		while(rs.next()) {
			 io = rs.getBinaryStream("images");
			 //store in an array of bytes
			    byte[] buffer = new byte[1024];
			    //write the array using 
			    while (io.read(buffer) > 0) {
			        out.write(buffer);
		}
		}
			
		
	} catch (SQLException e) {		
		e.printStackTrace();
	}
	catch(FileNotFoundException f) {
		f.printStackTrace();
	}catch(IOException i){
		i.printStackTrace();
	}
	

	
	
}
}
