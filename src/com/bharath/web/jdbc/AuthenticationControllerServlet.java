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
 * Servlet implementation class AuthenticationControllerServlet
 */
@WebServlet("/AuthenticationControllerServlet")
public class AuthenticationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthenticationDbUtil authenticationDbUtil;
	@Resource(name = "jdbc/assignment")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			authenticationDbUtil = new AuthenticationDbUtil(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "Login";
			}

			switch (theCommand) {
			case "Login":
				loginAuth(request, response);
				break;
			case "PrintList":
				printAuth(request, response);
				break;
			case "PrintList1":
				printAuth1(request, response);
				break;
			case "PrintList2":
				printAuth2(request, response);
				break;
			case "AddStudent":
				addStudent(request, response);
				break;
			case "Load":
				loadAuth(request, response);
				break;
			case "Update":
				updateAuth(request, response);
				break;
			}

		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void printAuth1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Authentication> authList = authenticationDbUtil.getAuthentication();

		request.setAttribute("auth_List", authList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudentDetails.jsp");
		dispatcher.forward(request, response);
	}
	private void printAuth2(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Authentication> authList = authenticationDbUtil.getAuthentication();

		request.setAttribute("auth_List", authList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStaffDetails.jsp");
		dispatcher.forward(request, response);
	}
	private void updateAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String aEmail = (String)request.getParameter("aEmail");
		
		String password = request.getParameter("pwd");
		String logintype = request.getParameter("logintype");
		
		authenticationDbUtil.updateAuth(aEmail,password,logintype);
		
		printAuth(request, response);
		
	}

	private void loadAuth(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		
		Authentication temp = authenticationDbUtil.getAuth(email);
		
		request.setAttribute("auth_load", temp);
		
//		System.out.println(temp);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateAuth.jsp");
		
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String logintype = request.getParameter("logintype");
		
		Authentication aut = new Authentication();
		aut.setEmail(email);
		aut.setPwd(password);
		aut.setLogintype(logintype);
		
		authenticationDbUtil.addAuthentication(aut);
		
		printAuth(request, response);
	}

	private void loginAuth(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<Authentication> authList = authenticationDbUtil.getAuthentication();

		for (Authentication i : authList) {
			if (i.getEmail().equalsIgnoreCase(request.getParameter("email"))
					&& i.getPwd().equalsIgnoreCase(request.getParameter("pwd"))
					&& i.getLogintype().equalsIgnoreCase(request.getParameter("logintype"))) {
				if("admin".equalsIgnoreCase(request.getParameter("logintype"))) {
					request.setAttribute("welcomeNote", "Welcome Admin");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin.jsp");
					dispatcher.forward(request, response);
					
				}
				else if("staff".equalsIgnoreCase(request.getParameter("logintype"))) {
					request.setAttribute("welcomeNote", "Welcome staff");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Staff.jsp");
					dispatcher.forward(request, response);
					
				}
				else if("customer".equalsIgnoreCase(request.getParameter("logintype"))) {
					request.setAttribute("welcomeNote", "Welcome customer");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Student.jsp");
					dispatcher.forward(request, response);
				}
				else if("employee".equalsIgnoreCase(request.getParameter("logintype"))) {
					request.setAttribute("welcomeNote", "Welcome Employee");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Student.jsp");
					dispatcher.forward(request, response);
				}
				else if("businesspartner".equalsIgnoreCase(request.getParameter("logintype"))) {
					request.setAttribute("welcomeNote", "Welcome BusinessPartner");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Student.jsp");
					dispatcher.forward(request, response);
				}
				
			}
			
		}

	}

	private void printAuth(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<Authentication> authList = authenticationDbUtil.getAuthentication();

		request.setAttribute("auth_List", authList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DisplayAuth.jsp");
		dispatcher.forward(request, response);

	}

}
