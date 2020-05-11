package blog.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import blog.DButil.DBUtil;
import blog.bean.articleBean;

public class articleDao {
	public static boolean uploadArticle(articleBean article)
	{
		boolean result=articleDao.isExist(article.getTypeId(), article.getEmail(), article.getTitle());
		if(result)
			return false;
		
		String sql="insert into article(typeId,email,title,content,descrip,visible)  values(?,?,?,?,?,?);";
		Object [] obs= {article.getTypeId(),article.getEmail(),article.getTitle(),article.getContent(),article.getDescrip(),article.getVisible()};
		DBUtil db = DBUtil.getInstance();
		return  db.executeUpdate(sql, obs);
		
	}
	public static ArrayList<articleBean> queryByEmailAndVisible(String email)
	{
		List articles=new ArrayList<articleBean>();
		DBUtil db=DBUtil.getInstance();
		String sql="select * from article where email=? and visible=1";
		Object [] obs={email};
		ResultSet rs = db.executeQuery(sql, obs);
		try {
			while(rs.next())
			{
				articleBean art=new articleBean();
				art.setContent(rs.getString("content"));
				art.setDescrip(rs.getString("descrip"));
				art.setEmail(rs.getString("email"));
				art.setTitle(rs.getString("title"));
				art.setTypeId(rs.getInt("typeId"));
				art.setVisible(rs.getInt("visible"));
				articles.add(art);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<articleBean>) articles;
	
		
	}

	public static ArrayList<articleBean> queryByEmail(String email)
	{
		List articles=new ArrayList<articleBean>();
		DBUtil db=DBUtil.getInstance();
		String sql="select * from article where email=?";
		Object [] obs={email};
		ResultSet rs = db.executeQuery(sql, obs);
		try {
			while(rs.next())
			{
				articleBean art=new articleBean();
				art.setContent(rs.getString("content"));
				art.setDescrip(rs.getString("descrip"));
				art.setEmail(rs.getString("email"));
				art.setTitle(rs.getString("title"));
				art.setTypeId(rs.getInt("typeId"));
				art.setVisible(rs.getInt("visible"));
				articles.add(art);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<articleBean>) articles;
	
		
	}
	public static ArrayList<articleBean> queryByTitle(String title ,String email)
	{
		ArrayList<articleBean> articles=new ArrayList<>();
		DBUtil db = DBUtil.getInstance();
		String info="%"+title+"%";
		Object [] obs= { info,email};
		String sql="select * from article where title like ? and email= ?";
		ResultSet rs = db.executeQuery(sql, obs);
		try {
			while(rs.next())
			{
				articleBean art=new articleBean();
				art.setContent(rs.getString("content"));
				art.setDescrip(rs.getString("descrip"));
				art.setEmail(rs.getString("email"));
				art.setTitle(rs.getString("title"));
				art.setTypeId(rs.getInt("typeId"));
				art.setVisible(rs.getInt("visible"));
				articles.add(art);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
		
	}
	public static boolean isExist(int typeId,String email,String title)
	{
		int result=0;
		DBUtil db = DBUtil.getInstance();
		String sql="select count(*) from article where typeId=? and email=? and title=?";
		Object[] obs={typeId,email,title};
		ResultSet rs = db.executeQuery(sql, obs);
		try {
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1?true:false;
	}
	
	public static  articleBean querySingle(articleBean art) throws SQLException
	{
		DBUtil db = DBUtil.getInstance();
		String sql="select * from article where email=? and title=? and typeid=?";
		Object obs[]={art.getEmail(),art.getTitle(),art.getTypeId()};
		ResultSet rs = db.executeQuery(sql, obs);
		
		if(rs.next())
		{
			try {
				art.setContent(rs.getString("content"));
				art.setDescrip(rs.getString("descrip"));
				art.setVisible(rs.getInt("visible"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return art;
	}
	public static boolean  deleteSingle(articleBean art)
	{
		if(!articleDao.isExist(art.getTypeId(), art.getEmail(), art.getTitle()))
			return false;
		
		else
		{
			DBUtil db = DBUtil.getInstance();
			String sql="delete  from article where email=? and title=? and typeid=?";
			Object obs[]={art.getEmail(),art.getTitle(),art.getTypeId()};
			return  db.executeUpdate(sql, obs);
		}
		
		
	}
	 public static void main(String args[]) throws SQLException
	 {
//		 ArrayList<articleBean> array = articleDao.queryByEmail("wlx");
//		 for(articleBean art:array){
//			 System.out.println(art.getTitle()+"");
//		 }
		 
//		 articleBean article=new articleBean(1,"wlx","4","abc","abc",0);
//		if(articleDao.uploadArticle(article))
//	System.out.println("插入成功");
//		else
//		System.out.println("插入失败");
//		 if(articleDao.delete(1, "925355386@qq.com", "1"))
//			 System.out.println("已删除");
//		 
		 articleBean art=new articleBean();
		 art.setEmail("925355386@qq.com");
		 art.setTitle("凹凸曼大战");
		 art.setTypeId(1);
	 boolean sg= articleDao.deleteSingle(art);
		 
	 }
	 
	
}
