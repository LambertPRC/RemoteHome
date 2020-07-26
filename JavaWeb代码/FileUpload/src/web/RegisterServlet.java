package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QueryMethods;
import domain.Users;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(new QueryMethods().insetUsers(new Users(id, password))){
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}else{
			response.getWriter().write("Registration failed, please try again!");
		}
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}