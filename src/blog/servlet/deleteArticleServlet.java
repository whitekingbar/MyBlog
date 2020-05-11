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
 * Servlet implementation class deleteArticleServlet
 */
@WebServlet("/deleteArticleServlet")
public class deleteArticleServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		HttpSession session = request.getSession();
		String  email= (String) session.getAttribute("email");
		String title= request.getParameter("title");
		articleBean art=new articleBean();
		art.setEmail(email);
		art.setTitle(title);
		art.setTypeId(typeId);
		boolean result=articleDao.deleteSingle(art);
		if(result)
			request.setAttribute("artDelete", "true");
		else
			request.setAttribute("artDelete", "false");
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
