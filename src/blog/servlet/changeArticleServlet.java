package blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.bean.articleBean;
import blog.dao.articleDao;

/**
 * Servlet implementation class changeArticleServlet
 */
@WebServlet("/changeArticleServlet")
public class changeArticleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		articleBean oldArt = (articleBean) session.getAttribute("oldArticle");
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		String title=request.getParameter("title");
		String email=(String) request.getSession().getAttribute("email");
		int visible=Integer.parseInt(request.getParameter("visible"));
		String descrip=request.getParameter("descrip");
		String content=request.getParameter("content");
		if(articleDao.isExist(typeId, email, title))
		{
			request.setAttribute("artUpdate", "false");
			request.getRequestDispatcher("articleServlet").forward(request, response);
		}
		articleBean article=new articleBean(typeId,email,title,content,descrip,visible);
		articleDao.deleteSingle(oldArt);
		if(articleDao.uploadArticle(article))
		{
			request.setAttribute("artUpdate", "true");
		}
		else
			request.setAttribute("artUpdate", "false");
		request.getRequestDispatcher("articleServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
