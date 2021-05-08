package com.bharath.web.assig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class AssigServlet
 */
@WebServlet("/AssigServlet")
public class AssigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AssigServletDb assigServletDb;
	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	public void init() throws ServletException {

		super.init();
		assigServletDb = new AssigServletDb(dataSource);
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

			case "assig":
				StudentsAssig(request, response);
				break;
			case "assigdown":
				StudentsAssigdownload(request, response);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void StudentsAssigdownload(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("subName");
		String email = request.getParameter("email");
		assigServletDb.downloadAssig(id, email);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Staff.jsp");

		dispatcher.forward(request, response);
	}

	private void StudentsAssig(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("subName");
		String email = request.getParameter("email");
		File thefile = new File(request.getParameter("stuAssig"));
		assigServletDb.uploadAssig(id, email, thefile);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Student.jsp");

		dispatcher.forward(request, response);

	}

}
