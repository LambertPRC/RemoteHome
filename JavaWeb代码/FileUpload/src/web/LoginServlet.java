package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.swing.internal.plaf.metal.resources.metal_zh_TW;

import dao.QueryMethods;
import domain.Users;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if(new QueryMethods().selectUsers(new Users(id, password))){
		
		request.getRequestDispatcher("/RecongnizeFlower.jsp").forward(request, response);
		
	}else{
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}