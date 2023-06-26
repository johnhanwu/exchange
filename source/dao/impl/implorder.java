package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import dao.DBConnection;
import dao.hwporderdao;
import vo.member;
import vo.order;

public class implorder implements hwporderdao {

	public static void main(String[] args) {
		/*order o=new order();
		java.sql.Timestamp d=new java.sql.Timestamp(o.getPdate().getTime());
		System.out.print(d);*/
		/*order o=new order();
		java.sql.Date d=new java.sql.Date(o.getPdate().getTime());
		System.out.print(d);*/
		order o=new implorder().queryID(2);
		System.out.print(o);
	}

	

	

//新增訂單
	public void add(order o) {
		Connection conn=DBConnection.getDB();
		String sql="insert into porder(name,nt,rmb,usd,jpy,pdate)"
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, o.getName());
			ps.setDouble(2,o.getNt());
			ps.setDouble(3,o.getRmb());
			ps.setDouble(4, o.getUsd());
			ps.setDouble(5, o.getJpy());
			//java.sql.Timestamp d=new java.sql.Timestamp(o.getPdate().getTime());
			java.sql.Timestamp d=new java.sql.Timestamp(o.getPdate().getTime());
			ps.setTimestamp(6, d);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


//新增資產	
	public void add(String name, int assets,Date pdate) {
		Connection conn=DBConnection.getDB();
		String sql="insert into porder(name,assets,pdate)"
				+ "values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, assets);
			order o=new order();
			java.sql.Timestamp d=new java.sql.Timestamp(o.getPdate().getTime());
			ps.setTimestamp(3, d);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//read	
	public List<order> queryAll(String name) {
		Connection conn=DBConnection.getDB();
		String sql="select * from porder where name=?";
		List<order> l=new ArrayList();
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order o=new order();
				o.setId(rs.getInt("id"));
				o.setRmb(rs.getDouble("rmb"));
				o.setUsd(rs.getDouble("usd"));
				o.setJpy(rs.getDouble("jpy"));
				o.setPdate(rs.getTimestamp("pdate"));
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

//update	
	public void update(order o) {
		Connection conn=DBConnection.getDB();
		String sql="update porder set nt=?,rmb=?,usd=?,jpy=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, o.getNt());
			ps.setDouble(2, o.getRmb());
			ps.setDouble(3, o.getUsd());
			ps.setDouble(4, o.getJpy());
			ps.setInt(5,o.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"請選擇要修改的資料");
			e.printStackTrace();
		}
	}





	@Override
	public order queryID(int id) {
		Connection conn=DBConnection.getDB();
		String sql="select * from porder where id=?";
		order o=new order();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				o.setId(rs.getInt("id"));
				o.setNt(rs.getInt("nt"));
				o.setRmb(rs.getDouble("rmb"));
				o.setUsd(rs.getDouble("usd"));
				o.setJpy(rs.getDouble("jpy"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}





	@Override
	public void delete(int id) {
		Connection conn=DBConnection.getDB();
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}





	
	

}

		
	

