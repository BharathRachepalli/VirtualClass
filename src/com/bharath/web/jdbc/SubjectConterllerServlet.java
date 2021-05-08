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
 * Servlet implementation class SubjectConterllerServlet
 */
@WebServlet("/SubjectConterllerServlet")
public class SubjectConterllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SubjectDbUtil subjectDbUtil;
	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		subjectDbUtil = new SubjectDbUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		if (theCommand == null) {
			theCommand = "Login";
		}

		switch (theCommand) {
		case "AddSubject":
			try {
				addSubject(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "PrintSubjects":
			try {
				listSubjects(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "PrintSubjects1":
			try {
				listSubjects1(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	private void listSubjects1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Subjects> subList = subjectDbUtil.getSubjects();
		request.setAttribute("sub_List", subList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudentDetails.jsp");
		dispatcher.forward(request, response);
	}

	private void addSubject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub

		String sname = request.getParameter("sname");

		subjectDbUtil.SubjectDbUtil(sname);

		listSubjects(request, response);
	}

	private void listSubjects(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Subjects> subList = subjectDbUtil.getSubjects();

		request.setAttribute("sub_List", subList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplaySubjects.jsp");
		dispatcher.forward(request, response);


	}

}
