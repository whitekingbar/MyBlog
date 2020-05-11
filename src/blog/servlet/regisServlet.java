package blog.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.bean.User;
import blog.dao.UserDao;

/**
 * Servlet implementation class regisServlet
 */
@WebServlet("/regisServlet")
public class regisServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		User user=new User();
		user.setEmail(email);
		user.setUname(uname);
		user.setUpwd(upwd);
		boolean flag=false;
		try {
			flag=UserDao.executeInsert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(flag)
			{
				request.setAttribute("regis", "true");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
			else
			{
				request.setAttribute("regis", "false");
				request.getRequestDispatcher("register.jsp").forward(request, response);
				
			 
			}
		
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
