package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnection;

import dao.hwmemberdao;
import vo.member;

public class implmember implements hwmemberdao {

	public static void main(String[] args) {
		/*member m=new member("john","root","1234","abc@123","111");
		new implmember().add(m);*/
		System.out.print(new implmember().query("abc"));
	}

	@Override
	public void add(member m) {
		Connection conn=DBConnection.getDB();
		String sql="insert into member(name,username,password,email,mobile)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getMobile());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	@Override
	public member query(String username, String password) {
		Connection conn=DBConnection.getDB();
		String sql="select * from member where username=? and password=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setEmail(rs.getString("email"));
				m.setMobile(rs.getString("mobile"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public boolean query(String username) {
		Connection conn=DBConnection.getDB();
		String sql="select * from member where username=?";
		boolean x=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				x=true;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public boolean query2(String password) {
		Connection conn=DBConnection.getDB();
		String sql="select * from member where password=?";
		boolean x=false;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				x=true;
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public void update(int nt,String name) {
		Connection conn=DBConnection.getDB();
		String sql="update porder set nt=? where name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			member m=new member();
			ps.setInt(1,nt);
			ps.setString(2,name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
