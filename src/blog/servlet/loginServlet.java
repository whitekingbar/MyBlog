package blog.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.bean.User;
import blog.dao.UserDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

			User user;
			String email=request.getParameter("uemail");
			session.setAttribute("email", email);
			String upwd=request.getParameter("upwd");
			System.out.println("email:"+email+"pwd"+upwd);
			user=new User(email,upwd);
			UserDao ud=new UserDao();		
			boolean flag=false;
			try {
				flag=ud.executeQueryLog(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag)
				request.getRequestDispatcher("main.jsp").forward(request, response);
			else
			{
				request.setAttribute("login", "登陆失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			 
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
