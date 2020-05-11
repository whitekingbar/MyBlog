package blog.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.bean.articleBean;
import blog.dao.articleDao;

/**
 * Servlet implementation class friendArticleServlet
 */
@WebServlet("/friendArticleServlet")
public class friendArticleServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String email = request.getParameter("email");
	ArrayList<articleBean> articles = articleDao.queryByEmailAndVisible(email);
	HttpSession session = request.getSession();
	session.setAttribute("otherArticles", articles);
	request.getRequestDispatcher("otherArticle.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
