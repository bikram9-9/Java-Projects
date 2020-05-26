package com.bikram;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	int studentId;
	String studentName;
	//add the student to the database
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		 studentId= Integer.parseInt(req.getParameter("studentId"));
		 studentName = (req.getParameter("studentName"));
		map.put(studentId,studentName);
		PrintWriter pw = res.getWriter();
		pw.println(studentName + " added to our records");
	}
	
	//Retrieve the student name based on ID and print on screen
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		 studentName = map.get(studentId);
		//use response object to get print on the screen
		PrintWriter pw = res.getWriter();
		pw.println("Name of the student is " + studentName);
		
	}
	
	//Delete Student from the database
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException{
		PrintWriter pw = res.getWriter();
		//if student in the records, remove from Hashmap else print
		if(map.containsKey(studentId)) {
			 studentName = map.remove(studentId);
			 pw.println("Successfully removed from records");
		}else {
			pw.println("Student not in the records");
		}
		
		//use response object to get print on the screen
		pw.println(map);
	}


	//Update the Student on a given ID
	public void doPut(HttpServletRequest req, HttpServletResponse res) {
		
	}

}
