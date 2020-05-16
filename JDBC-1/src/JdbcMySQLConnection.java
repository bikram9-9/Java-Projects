/*
 * import package 
 * load driver and register
 * load connection
 * create statement
 * execute query 
 * process the results 
 * close
 */
import java.sql.*;

public class JdbcMySQLConnection {
	public static void main(String[] args) throws Exception {
		
		//need to include serverTimezone=UTC in the url
		String url = "jdbc:mysql://127.0.0.1:3306/telusko?serverTimezone=UTC";
		String uname = "root";
		String pswd = "Bikky_123";
		String getAll = "SELECT * FROM TELUSKO.EMPLOYEE;";
		String createTable = "CREATE TABLE Animals(id INT PRIMARY KEY,emp_name VARCHAR(48) NOT NULL,age INT,gender VARCHAR(7));";
		String insert = "INSERT INTO TELUSKO.Animals(id,emp_name,age,gender) VALUES "
				+ "(?,?,?,?);";
		String callQ = "call get_legal_age()";
		//connect to the driver here 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create connection by creating an instance using Drivermanager.getConnection
		//getConnection() has 3 parameters - url, username, pswd
		Connection con = DriverManager.getConnection(url, uname, pswd);
		
		
//		//Create a statement using connection.createStatement method
		Statement st = con.createStatement();
		 st.executeUpdate(createTable);
		
		//use prepared statement 
		PreparedStatement ps = con.prepareStatement(insert);
		ps.setInt(1,1);
		ps.setString(2, "Bikram");
		ps.setInt(3,21);
		ps.setString(4,"Male");
		
	 ps.executeUpdate();
		
		//use callable Statement
	 CallableStatement callable = con.prepareCall(callQ); 
	
	 
	 ResultSet rs = callable.executeQuery();
	 while(rs.next()) {
		 String name = rs.getString(1);
		 System.out.println( name );
	 }
		
		//use ResultSet
	 ResultSet rt =st.executeQuery(getAll);
	 while(rt.next()) {
		 int id = rt.getInt(1);
		 String name = rt.getNString(2);
		 int age = rt.getInt(3);
		 String gender = rt.getNString(4);
		 System.out.println(id + " "+ name + " " + age + " " + gender);
	 }
	
		

		 
	}
	

}
