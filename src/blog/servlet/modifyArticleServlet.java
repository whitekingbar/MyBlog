package blog.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.bean.articleBean;
import blog.dao.articleDao;

/**
 * Servlet implementation class modifyArticleServlet
 */
@WebServlet("/modifyArticleServlet")
public class modifyArticleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		articleBean art=new articleBean();
		art.setEmail(email);
		art.setTitle(title);
		art.setTypeId(typeId);
		try {
			 articleDao.querySingle(art);
			session.setAttribute("oldArticle", art);
			 request.getRequestDispatcher("modifyArticle.jsp").forward(request, response);;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
