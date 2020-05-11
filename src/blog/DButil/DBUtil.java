package blog.DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {

		private final  String url = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	    private final  String uname = "root";
	    private final String upwd = "zyq200727";
	    private static DBUtil instance;
	    private DBUtil()
	    {
	    	
	    }
	    public static  DBUtil getInstance(){
	        if(instance==null)
	        	instance=new DBUtil();
	        return instance;
	     }
	   
	public  boolean executeUpdate(String sql,Object obs[])
	{
		int rs=0;
		 Connection con =null;
		 PreparedStatement psmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upwd);
			psmt= con.prepareStatement(sql);
			for(int i=0;i<obs.length;i++)
				{
				psmt.setObject(i+1, obs[i]);
				}
			rs=psmt.executeUpdate();
			
			}	
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally
			{
				if(psmt!=null)
					try {
						psmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if(con!=null)
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		if(rs>0)
			return true;
		else
			return false;
		
		 
	}
	
	public  ResultSet executeQuery(String sql,Object obs[])
	{
		
		 Connection con =null;
		 PreparedStatement psmt=null;
		 ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, upwd);
			psmt= con.prepareStatement(sql);
			for(int i=0;i<obs.length;i++)
				{
				psmt.setObject(i+1, obs[i]);
				}
				rs=psmt.executeQuery();
			
			}	
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		 
	}
	


}

