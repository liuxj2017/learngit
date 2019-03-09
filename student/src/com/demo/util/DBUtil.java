package com.demo.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * 
 * @desc: student
 * @author: lxj
 * @createTime: 2019年3月8日 下午6:43:43
 */
public class DBUtil {

	private static String username="root";
	private static String password="123456";
	private static String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private static String driverMySql="com.mysql.jdbc.Driver";
	private  Logger logger = Logger.getLogger(DBUtil.class);
	
	
	 static {
	        try {
	            Class.forName(driverMySql);
	        } catch (ClassNotFoundException e) {
	            throw new ExceptionInInitializerError(e);
	        }
	        
	    }
	
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @desc:close all conn
	 * @author:lxj
	 * @createTime: 2019年3月8日 下午6:43:28
	 * @param conn
	 * @param pstat
	 * @param rs void
	 */
	public  void closeAll(Connection conn,PreparedStatement pstat, ResultSet rs) {
		
		try {
			  if (rs != null) {
	                rs.close();
	            }
	            if (pstat != null) {
	            	pstat.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	
	/**
	 * 
	 * @desc:insert
	 * @author:lxj
	 * @createTime: 2019年3月8日 下午6:42:36
	 * @param sql_save
	 * @param param
	 * @return
	 * @throws SQLException boolean
	 */
	public  int saveInfo(String sql_save,Object param[]) {
		int r=0;
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstat = null;
		try {
			
			pstat=conn.prepareStatement(sql_save);
			for(int i=0;i<param.length;i++)
			{
				pstat.setObject(i+1, param[i]);
			}
			 r=pstat.executeUpdate();
		
		} catch (SQLException e) {
			
				
		}finally {
            closeAll(conn, pstat, null);
        }
		return r;
	}
	
	/**
	 * 
	 * @desc:delete 
	 * @author:lxj
	 * @createTime: 2019年3月8日 下午6:42:22
	 * @param sql_delete
	 * @param param
	 * @return boolean
	 */
	public  int deleteInfo(String sql_delete,Object param[]){
		int r=0;
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstat = null;
		try {
			pstat=conn.prepareStatement(sql_delete);
			for(int i=0;i<param.length;i++)
			{
				pstat.setObject(i+1, param[i]);
			}
			 r=pstat.executeUpdate();
			
			
		} catch (SQLException e) {
			
		
		}
		return r;
			
			
	}
	
	/**
	 * 
	 * @desc:update info
	 * @author:lxj
	 * @createTime: 2019年3月8日 下午6:42:02
	 * @param sql_update
	 * @param param
	 * @return boolean
	 */
	public  int updateInfo(String sql_update,Object param[]){
			int r=0;
			Connection conn=DBUtil.getConnection();
			PreparedStatement pstat = null;
		try {
			pstat=conn.prepareStatement(sql_update);
			for(int i=0;i<param.length;i++)
			{
				pstat.setObject(i+1, param[i]);
			}
			r=pstat.executeUpdate();
			
		} catch (SQLException e) {
			
			logger.info(e);
				
		}
	
	    return r;
	}
	
	/**
	 * 
	 * @desc:query
	 * @author:lxj
	 * @createTime: 2019年3月8日 下午6:41:48
	 * @param sql_query
	 * @param param
	 * @return ResultSet
	 */
	public  ResultSet queryInfo(String sql_query,Object param[]) {
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstat = null;
		 ResultSet rs = null;
		try {
			pstat=conn.prepareStatement(sql_query);
			if(param!=null){
				for(int i=0;i<param.length;i++)
				{
					pstat.setObject(i+1, param[i]);
				}
				 rs=pstat.executeQuery();
			}
			else{
				 rs=pstat.executeQuery(sql_query);
			}
			
		} catch (SQLException e) {
			logger.error(e);
		}
		return rs;
	}
}

	