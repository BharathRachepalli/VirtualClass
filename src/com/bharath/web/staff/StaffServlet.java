package com.bharath.web.staff;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StaffServlet
 */
@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StaffServletDb staffServletDb;
	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	public void init() throws ServletException {

		super.init();
		staffServletDb = new StaffServletDb(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "Login";
			}
			switch (theCommand) {

			case "PrintStudents":
				StudentsDetails(request, response);
				break;
			case "PrintStudents1":
				StudentsDetails1(request, response);
				break;
			case "Load":
				LoadStudentDetails(request, response);
				break;
			case "Update":
				UpdateStudentMarks(request, response);
				break;

			case "PrintStaff":
				StaffDetails(request, response);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void StudentsDetails1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String sub = request.getParameter("subName");

		List<Student> stu = staffServletDb.getStudentDetails1(sub);

		request.setAttribute("stu_List", stu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayStudentsForStudents.jsp");
		dispatcher.forward(request, response);
	}

	private void StaffDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String sub = request.getParameter("subName");

		List<Staff> stu = staffServletDb.getStaffDetails(sub);

		request.setAttribute("stu_List", stu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayStaffForStaff.jsp");
		dispatcher.forward(request, response);
	}

	private void UpdateStudentMarks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(request.getParameter("id"));
		int marks = Integer.parseInt(request.getParameter("marks"));

		staffServletDb.UpdateMarks(id, marks);
		StudentsDetails(request, response);
	}

	private void LoadStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Student temp = staffServletDb.getStudent(id);
		request.setAttribute("stu_load", temp);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateMarks.jsp");

		dispatcher.forward(request, response);
	}

	private void StudentsDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String sub = request.getParameter("subName");

		List<Student> stu = staffServletDb.getStudentDetails(sub);

		request.setAttribute("stu_List", stu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayStudentsForStaff.jsp");
		dispatcher.forward(request, response);
	}
}
