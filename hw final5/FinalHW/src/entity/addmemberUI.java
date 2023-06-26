package entity;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DBConnection;
import dao.impl.implmember;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import vo.member;
public class addmemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField email;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addmemberUI frame = new addmemberUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addmemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 553, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 26));
		lblNewLabel.setBounds(213, 0, 119, 80);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(102, 93, 64, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(102, 135, 46, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("密碼:");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(102, 173, 64, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email:");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(307, 90, 74, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話:");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(309, 135, 58, 25);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(163, 100, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(163, 142, 96, 21);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(163, 180, 96, 21);
		panel.add(password);
		password.setColumns(10);
		
		email = new JTextField();
		email.setBounds(378, 100, 96, 21);
		panel.add(email);
		email.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(378, 142, 96, 21);
		panel.add(mobile);
		mobile.setColumns(10);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String USERNAME=username.getText();
				if(new implmember().query(USERNAME))
				{
					JOptionPane.showMessageDialog(null, "帳號重複,請重新註冊");
				}
				else
				{
					String NAME=name.getText();
					String PASSWORD=password.getText();
					String EMAIL=email.getText();
					String MOBILE=mobile.getText();
					loginUI l=new loginUI();
					member m=new member(NAME,USERNAME,PASSWORD,EMAIL,MOBILE);
					new implmember().add(m);
					JOptionPane.showMessageDialog(null, "註冊成功,請重新登入");
					l.setVisible(true);
					dispose();
				}
			
				
				
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton.setBounds(192, 247, 87, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnNewButton_1.setBounds(309, 247, 87, 23);
		panel.add(btnNewButton_1);
	}
}
