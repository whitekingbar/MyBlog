package blog.dao;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import blog.DButil.DBUtil;
import blog.bean.DB;
import blog.bean.User;

public class UserDao {
	

	public static ArrayList<User> queryByPage(int pageNum,int pageSize,String info)
	{
		DBUtil DB = DBUtil.getInstance();
		ArrayList<User> users=new ArrayList<User>();
		String sql="select uname,email from User where uname like ? or email like ? limit ?,? ";
		String str="%"+info+"%";
		Object obs[]={str,str,pageNum*pageSize,pageSize};
		ResultSet rs = DB.executeQuery(sql, obs);
		try {
			while(rs.next())
			{
				String name=rs.getString("uname");
				String email=rs.getString("email");
				User user=new User();
				user.setEmail(email);
				user.setUname(name);
				users.add(user);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return users; 
	}
	
	
	
	public static boolean executeInsert(User user) throws SQLException
	{
		DBUtil DB = DBUtil.getInstance();
		
		if(UserDao.isExist(user))
			return false;
		else
		{
			String sql="insert into user(email,uname,upwd) values(?,?,?)";
			Object[] obs={user.getEmail(),user.getUname(),user.getUpwd()};
			return DB.executeUpdate(sql,obs );
		}
		
		
	}
	public static boolean  executeQueryLog(User user) throws SQLException
	{
		DBUtil DB = DBUtil.getInstance();
		int res=0;
		String sql="select count(*) from user where email=? and upwd=?  ";
		Object[] obs={user.getEmail(),user.getUpwd()};
		 ResultSet rs = DB.executeQuery(sql, obs);
		 if(rs.next())
			try {
				res=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 if(res==1)
			 return true;
		 else
			 return false;
		
	}
	public static boolean  isExist(User user) throws SQLException
	{
		DBUtil DB = DBUtil.getInstance();
		int res=0;
		String sql="select count(*) from user where email=?";
		Object[] obs={user.getEmail()};
		 ResultSet rs = DB.executeQuery(sql, obs);
		 if(rs.next())
			try {
				res=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 if(res==1)
			 return true;
		 else
			 return false;
	}
	public static void main(String args[])
	{
		
		UserDao ud=new UserDao();
//		if(		ud.executeInsert(user))
//		{
//			System.out.println("插入成共");
//
//		}
//		else
//		{
//			System.out.println("插入失败");
//		}
//		try {
//			if(ud.executeQueryLog(user))
//				System.out.println("此人存在");
//			else
//				System.out.println("此人不存在");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ArrayList<User> queryByPage=new ArrayList<>();
		queryByPage = UserDao.queryByPage(0, 3, "y");
		for(User user:queryByPage)
		{
			System.out.println("name" +user.getUname()+"email"+user.getEmail());
		}
	}


}

