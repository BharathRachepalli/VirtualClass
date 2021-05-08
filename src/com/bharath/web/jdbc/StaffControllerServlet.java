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
@WebServlet("/StaffControllerServlet")
public class StaffControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StaffDbUtil staffDbUtil;

	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {

		super.init();
		staffDbUtil = new StaffDbUtil(dataSource);
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

			case "AddStaffDetails":
				AddStaffDetails(request, response);
				break;
			case "StaffPrintList":
				DispalyStaffDetails(request, response);
				break;

			case "Load":
				LoadStafftDetails(request, response);
				break;

			case "Update":
				UpdateStaffDetails(request, response);
				break;

			case "Delete":
				DeleteStaffDetails(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private void UpdateStaffDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");

	staffDbUtil.updateStaff(id, fname, lname);

	DispalyStaffDetails(request, response);
		
	}

	private void DeleteStaffDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		staffDbUtil.deleteStaff(id);
		DispalyStaffDetails(request, response);
	}

//	private void UpdateStudentDetails(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		// TODO Auto-generated method stub
//		int id = Integer.parseInt(request.getParameter("id"));
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//
//		studentDbUtil.updateStudent(id, fname, lname);
//
//		DispalyStudentDetails(request, response);
//	}
//
	private void LoadStafftDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Staff temp = staffDbUtil.getStaff(id);

		request.setAttribute("stu_load", temp);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateStaff.jsp");

		dispatcher.forward(request, response);
	}

	private void DispalyStaffDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Staff> stu = staffDbUtil.GetStaffList();

		request.setAttribute("stu_List", stu);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewStaffDetails.jsp");
		dispatcher.forward(request, response);
	}

	private void AddStaffDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String fname = (String) request.getParameter("sfname");
		String lname = (String) request.getParameter("slname");
		String subj = (String) request.getParameter("ssname");
		String email = (String) request.getParameter("semail");

		Staff stu = new Staff();
		stu.setStaffFName(fname);
		stu.setStaffLName(lname);
		stu.setStaffSubject(subj);
		stu.setStaffEmail(email);

		staffDbUtil.AddStaff(stu);
		DispalyStaffDetails(request, response);
	}
}
