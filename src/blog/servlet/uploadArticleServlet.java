package blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.bean.articleBean;
import blog.dao.articleDao;

/**
 * Servlet implementation class uploadArticleServlet
 */
@WebServlet("/uploadArticleServlet")
public class uploadArticleServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		String title=request.getParameter("title");
		String email=(String) request.getSession().getAttribute("email");
		int visible=Integer.parseInt(request.getParameter("visible"));
		String descrip=request.getParameter("info");
		String content=request.getParameter("content");
		articleBean article=new articleBean(typeId,email,title,content,descrip,visible);
		boolean result=articleDao.uploadArticle(article);
		if(result)
		{
			request.setAttribute("artUpload", "true");
		
		}
		else
			request.setAttribute("artUpload", "false");
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
