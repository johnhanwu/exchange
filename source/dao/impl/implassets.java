package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnection;
import dao.hwassetsdao;
import vo.assets;
import vo.order;

public class implassets implements hwassetsdao{

	public static void main(String[] args) {
		
		
		//new implassets().queryassets("student");
		assets a=new implassets().queryall("teacher");
		System.out.print(a);
	}

	@Override
	public assets queryassets(String name) {
		Connection conn=DBConnection.getDB();
		String sql="select * from assets where name=?";
		assets a=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	a=new assets();
				a.setBalance(rs.getInt("balance"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
}

	@Override
	public assets queryall(String name) {
		Connection conn=DBConnection.getDB();
		String sql="select * from assets where name=?";
		assets a=new assets();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				a.setTotalrmb(rs.getDouble("totalrmb"));
				a.setTotalusd(rs.getDouble("totalusd"));
				a.setTotaljpy(rs.getDouble("totaljpy"));
				a.setBalance(rs.getInt("balance"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
}