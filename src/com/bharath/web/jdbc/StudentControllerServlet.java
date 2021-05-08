package com.bharath.web.jdbc;

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
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;

	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {

		super.init();
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "Login";
			}
			switch (theCommand) {

			case "AddStudentDetails":
				AddStudentDetails(request, response);
				break;
			case "StudentPrintList":
				DispalyStudentDetails(request, response);
				break;

			case "Load":
				LoadStudentDetails(request, response);
				break;

			case "Update":
				UpdateStudentDetails(request, response);
				break;

			case "Delete":
				DeleteStudentDetails(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void DeleteStudentDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		studentDbUtil.deleteStudent(id);
		DispalyStudentDetails(request, response);
	}

	private void UpdateStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		studentDbUtil.updateStudent(id, fname, lname);

		DispalyStudentDetails(request, response);
	}

	private void LoadStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Students temp = studentDbUtil.getStu(id);

		request.setAttribute("stu_load", temp);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateStu.jsp");

		dispatcher.forward(request, response);
	}

	private void DispalyStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Students> stu = studentDbUtil.GetStudentList();

		request.setAttribute("stu_List", stu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewStudentDetails.jsp");
		dispatcher.forward(request, response);
	}

	private void AddStudentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String fname = (String) request.getParameter("sfname");
		String lname = (String) request.getParameter("slname");
		String subj = (String) request.getParameter("ssname");
		String email = (String) request.getParameter("semail");

		Students stu = new Students();
		stu.setStudentFName(fname);
		stu.setStudentLName(lname);
		stu.setStudentSubject(subj);
		stu.setStudentEmail(email);

		studentDbUtil.AddStudent(stu);
		DispalyStudentDetails(request, response);
	}
}
