
package blog.bean;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private final String url = "jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private final String uname = "root";
    private final String upwd = "zyq200727";
    private Connection con = null;
    private	Statement stm=null;
    private String sql="select count* from user where email= ? and upwd= ? ";	
    
    /* 通过构造方法加载数据库驱动 */
    public DB(){
    	try {   		
    		//1加载
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("加载数据库驱动成功！");
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("加载数据库驱动失败！");
    	}    	
    	  try {
              con = DriverManager.getConnection(url, uname, upwd);
              System.out.println("连接成功");
              stm=con.createStatement();
           
          } catch (SQLException e) {
              e.printStackTrace();
          }
    }
 
    /** 
     * @功能 对数据库的增加、修改和删除的操作
     * @参数 sql为要执行的SQL语句
     * @返回值 boolean型值 
     */
    public void  setSql(String sql)
    {
    	this.sql=sql;
    
    }
    /*public void setStat(String email,String upwd) throws SQLException
    {
    	stm.setString(1, email);	
    	stm.setString(2, upwd);
    	
    	
    }*/
    public boolean executeUpdate(String sql) {
    	//System.out.println(sql);
        boolean mark=false;
    
    	try {   	
    		//4执行操作
            int iCount = stm.executeUpdate(sql);
            if(iCount>0)            	
            	mark=true; 
            else
            	mark=false;
        } catch (Exception e) {
            e.printStackTrace();
		    mark=false;
        }
        return mark;
    }
    /* 查询数据库 */
    public ResultSet executeQuery() throws SQLException {
    	 
        ResultSet rs=null;      
        System.out.println("sql:"+sql);

        try {
                rs = stm.executeQuery(sql);
            } 
        catch (Exception e) {
            	e.printStackTrace();
                System.out.println("查询数据库失败！");
            }       
        return rs;
    }
    /* 关闭数据库的操作 */
    public void closed() {
    	if(stm!=null)
			try {
				stm.close();	System.out.println("关闭stm对象成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭stm对象失败！");
			}
    	if(con!=null)
			try {
				con.close();
				System.out.println("关闭con对象成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭con对象失败！");
			}
    }
    public static void main(String[] args) throws SQLException{
	/*	DB d=new DB();
		ResultSet rs = d.executeQuery("select * from user");
		String n1=" ";	String n2=" ";	String n3=" ";
		
		if(rs.next())
		{
			n1=rs.getString("email");
		n2=	rs.getString("uname");
		n3=	rs.getString("upwd");
			
		}
		System.out.println(n1+n2+n3);
	
	  
	    //删除
	    //查询
	    //d.closed();*/
	    
    }}