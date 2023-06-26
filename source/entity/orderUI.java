package entity;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import dao.impl.implassets;
import dao.impl.implmember;
import dao.impl.implorder;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import vo.member;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import vo.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import vo.assets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class orderUI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField assets;
	private JTable table;
	private JTextField rmb;
	private JTextField usd;
	private JTextField jpy;
	private JTextField nt;
	private JTextField urmb;
	private JTextField uusd;
	private JTextField ujpy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderUI frame = new orderUI();
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
	public orderUI() {
		try {
			ObjectInputStream ois=new ObjectInputStream(
					new FileInputStream("member.txt"));
			member m=(member)ois.readObject();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("");
		welcome.setBounds(32, 10, 241, 33);
		contentPane.add(welcome);
		welcome.setText(m.getName()+"歡迎光臨");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 621, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 29, 588, 483);
		panel.add(tabbedPane);
		
		JPanel exchange = new JPanel();
		tabbedPane.addTab("交易", null, exchange, null);
		exchange.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("請輸入存入的金額(台)自由心證");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(42, 25, 278, 23);
		exchange.add(lblNewLabel_3);
		
		assets = new JTextField();
		assets.setText("0");
		assets.setBounds(52, 58, 96, 21);
		exchange.add(assets);
		assets.setColumns(10);
		
		JButton btnNewButton = new JButton("存入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String NAME=m.getName();
				int ASSETS=Integer.parseInt(assets.getText());
				order o=new order();
				Date d=o.getPdate();
				new implorder().add(NAME, ASSETS,d);
				JOptionPane.showMessageDialog(null,"資金已存入帳戶");
				assets.setText("0");
				}
		});
		btnNewButton.setBounds(197, 58, 73, 23);
		exchange.add(btnNewButton);
		
	
		
		JLabel lblNewLabel = new JLabel("請輸入購買外幣的數量");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(64, 106, 182, 45);
		exchange.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("人民幣");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 171, 63, 29);
		exchange.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("美金");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(52, 224, 46, 15);
		exchange.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("日圓");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(52, 275, 46, 15);
		exchange.add(lblNewLabel_4);
		
		rmb = new JTextField();
		rmb.setText("0");
		rmb.setBounds(120, 178, 96, 21);
		exchange.add(rmb);
		rmb.setColumns(10);
		
		usd = new JTextField();
		usd.setText("0");
		usd.setBounds(120, 224, 96, 21);
		exchange.add(usd);
		usd.setColumns(10);
		
		jpy = new JTextField();
		jpy.setText("0");
		jpy.setBounds(120, 275, 96, 21);
		exchange.add(jpy);
		jpy.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("您需要支付的金額");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(336, 117, 151, 23);
		exchange.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("台幣");
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(336, 178, 46, 15);
		exchange.add(lblNewLabel_6);
		
		nt = new JTextField();
		nt.setText("0");
		nt.setBounds(376, 178, 96, 21);
		exchange.add(nt);
		nt.setColumns(10);
		nt.setEditable(false);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查詢\r\n", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane show = new JScrollPane();
		show.setBounds(10, 63, 563, 177);
		panel_2.add(show);
//JTable
		DefaultTableModel model;
		table = new JTable();
		model=new DefaultTableModel();
		Object[] column=new Object[] 
				{
					"ID","人民幣"	,"美金","日圓","日期"
				};
		model.setColumnIdentifiers(column);	
		table.setModel(model);
		
		show.setViewportView(table);

		model.setColumnIdentifiers(column);	
		table.setModel(model);
		
		show.setViewportView(table);
		show.setViewportView(table);
		
		JButton check = new JButton("交易紀錄");
		check.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				
				List<order> l=new implorder().queryAll(m.getName());
				Object[] x=new Object[5];
				
				
				for(order o:l)
				{
					if(o.getRmb()!=0 || o.getUsd()!=0 || o.getJpy()!=0)
					{
					x[0]=o.getId();	
					x[1]=o.getRmb();
					x[2]=o.getUsd();
					x[3]=o.getJpy();
					x[4]=o.getPdate();
					model.addRow(x);
					}
				}
				
			}
		});
		check.setBounds(10, 250, 107, 38);
		panel_2.add(check);
		
		JTextArea output = new JTextArea();
		output.setBounds(353, 250, 220, 101);
		panel_2.add(output);
		
		
		
		String[] currency=new String[] {"NT","RMB","USD"};
		
		JButton btnNewButton_1 = new JButton("交換");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String NAME=m.getName();
				int NT=Integer.parseInt(nt.getText());
				double RMB=Double.parseDouble(rmb.getText());
				double USD=Double.parseDouble(usd.getText());
				double JPY=Double.parseDouble(jpy.getText());
				order o=new order(NAME,NT,RMB,USD,JPY);
				
				assets a=new implassets().queryassets(m.getName());
				int balance=a.getBalance();
				if(balance>=NT)
				{
					new implorder().add(o);
					JOptionPane.showMessageDialog(null,"交易成功");
					rmb.setText("0");
					usd.setText("0");
					jpy.setText("0");
					nt.setText("0");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"您的餘額為:"+balance+"餘額不足請匯入金額");
				}
				
				
				
			
				
		}
	});
		JButton queryassets = new JButton("資產查詢");
		queryassets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				assets a=new implassets().queryall(m.getName());
				output.setText("您目前的資產為台幣:"+a.getBalance()+"元"+
							"\n人民幣:"+a.getTotalrmb()+"元"+
							"\n美金:"+a.getTotalusd()+"元"+
							"\n日圓:"+a.getTotaljpy()+"元");
				
				
				
				
			}
		});	
		queryassets.setBounds(353, 372, 123, 36);
		panel_2.add(queryassets);
		
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("人民幣");
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(127, 259, 46, 15);
		panel_2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("美金");
		lblNewLabel_9.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(128, 315, 28, 23);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("日圓");
		lblNewLabel_10.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(127, 369, 39, 36);
		panel_2.add(lblNewLabel_10);
		
		urmb = new JTextField();
		urmb.setText("0");
		urmb.setBounds(194, 259, 96, 21);
		panel_2.add(urmb);
		urmb.setColumns(10);
		
		uusd = new JTextField();
		uusd.setText("0");
		uusd.setBounds(194, 319, 96, 21);
		panel_2.add(uusd);
		uusd.setColumns(10);
		
		ujpy = new JTextField();
		ujpy.setText("0");
		ujpy.setBounds(194, 380, 96, 21);
		panel_2.add(ujpy);
		ujpy.setColumns(10);
		
		
		btnNewButton_1.setBounds(214, 356, 123, 39);
		exchange.add(btnNewButton_1);
		
		JButton logout = new JButton("登出");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.setVisible(true);
				dispose();
				
			}
		});
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				assets a=new implassets().queryassets(m.getName());
				int balance=a.getBalance();
				
				if (table.getSelectedRow() == -1) {
					 JOptionPane.showMessageDialog(null, "請選擇一行資料");
				    return; 
				}
			
				
				 double URMB = Double.parseDouble(urmb.getText());
			        double UUSD = Double.parseDouble(uusd.getText());
			        double UJPY = Double.parseDouble(ujpy.getText());
			        double totalNT = URMB * 4.33 + UUSD * 31 + UJPY * 0.22;
			        int NT = (int) Math.round(totalNT);
			        int selectedRow = table.getSelectedRow();
			        int ID = (int) table.getValueAt(selectedRow, 0);
			     
			        if(balance>=NT)
			        {
			        order o =new implorder().queryID(ID);
			        o.setNt(NT);
			        o.setRmb(URMB);
			        o.setUsd(UUSD);
			        o.setJpy(UJPY);
			        new implorder().update(o);
			        urmb.setText("0");
			        uusd.setText("0");
			        ujpy.setText("0");
			        JOptionPane.showMessageDialog(null,"修改成功");
			        }
			        else
					{
						JOptionPane.showMessageDialog(null,"您的餘額為:"+balance+"餘額不足請匯入金額");
					}
			    	   
			       
				
			}
		});
		update.setBounds(10, 310, 107, 38);
		panel_2.add(update);
		
		
		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
				   
				    JOptionPane.showMessageDialog(null, "請選擇一行資料");
				    return; 
				}
				int selectedRow = table.getSelectedRow();
				int ID = (int) table.getValueAt(selectedRow, 0);
				new implorder().delete(ID);
				 JOptionPane.showMessageDialog(null,"刪除成功");
			}
		});
		delete.setBounds(10, 371, 107, 38);
		panel_2.add(delete);
		
		logout.setBounds(534, 0, 87, 23);
		panel.add(logout);
		
		JLabel lblNewLabel_7 = new JLabel("簡易外匯系統");
		lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(221, 10, 223, 31);
		panel.add(lblNewLabel_7);
		
		rmb.getDocument().addDocumentListener(new CurrencyDocumentListener());
        usd.getDocument().addDocumentListener(new CurrencyDocumentListener());
        jpy.getDocument().addDocumentListener(new CurrencyDocumentListener());
		 
       
		
			}catch(Exception E){
			E.printStackTrace();
			}
		
	}
	
	 private class CurrencyDocumentListener implements DocumentListener {
         @Override
         public void insertUpdate(DocumentEvent e) {
             updateTotal();
         }

         @Override
         public void removeUpdate(DocumentEvent e) {
             updateTotal();
         }

         @Override
         public void changedUpdate(DocumentEvent e) {
             updateTotal();
         }

         private void updateTotal() {
             double rmbAmount = parseDouble(rmb.getText());
             double usdAmount = parseDouble(usd.getText());
             double jpyAmount = parseDouble(jpy.getText());

            double totalNT =rmbAmount*4.33 + usdAmount*31 + jpyAmount*0.22; // 加總
            int roundedTotalNT = (int) Math.round(totalNT); // 四捨五入後乘以 100
            nt.setText(String.valueOf(roundedTotalNT));
          
         }

         private double parseDouble(String text) {
             try {
                 return Double.parseDouble(text);
             } catch (NumberFormatException e) {
                 return 0.0;
             }
}	
	 }
}
