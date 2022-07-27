import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class Manager_discussroom {

	public JFrame frame;
	public int userNumber;
	public String discussroomStatus;
	
	
	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_discussroom window = new Manager_discussroom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Manager_discussroom() {
		this.userNumber=userNumber;
		this.discussroomStatus=discussroomStatus;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JToggleButton[] jtb=new JToggleButton[10];
		jtb[0]=new JToggleButton("正常");
		jtb[1]=new JToggleButton("違規");
		jtb[2]=new JToggleButton("正常");
		jtb[3]=new JToggleButton("違規");
		jtb[4]=new JToggleButton("正常");
		jtb[5]=new JToggleButton("違規");
		jtb[6]=new JToggleButton("正常");
		jtb[7]=new JToggleButton("違規");
		jtb[8]=new JToggleButton("正常");
		jtb[9]=new JToggleButton("違規");
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 587, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Manager_page mp=new Manager_page();
				mp.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 30, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Manager_login ml=new Manager_login();
				ml.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(458, 30, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("討論室黑名單");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(233, 30, 99, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("學號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(97, 94, 46, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(193, 94, 46, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("借閱狀態");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(344, 95, 72, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("胡怡欣");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(193, 137, 46, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("王大明");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(193, 179, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("李小華");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(193, 221, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("蔡小美");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(193, 268, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("陳小鐘");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setBounds(193, 313, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_5 = new JLabel("111356018");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(68, 137, 85, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("111356019");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(68, 179, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("111356020");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setBounds(68, 221, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("111356021");
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_3.setBounds(68, 268, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("111356022");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4.setBounds(68, 313, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_4);
		
		jtb[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356018;
				discussroomStatus=jtb[0].getText();
				for(int i=0;i<10;i++) {
					if(i==0) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356018;
				discussroomStatus=jtb[1].getText();
				for(int i=0;i<10;i++) {
					if(i==1) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356019;
				discussroomStatus=jtb[2].getText();
				for(int i=0;i<10;i++) {
					if(i==2) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356019;
				discussroomStatus=jtb[3].getText();
				for(int i=0;i<10;i++) {
					if(i==3) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356020;
				discussroomStatus=jtb[4].getText();
				for(int i=0;i<10;i++) {
					if(i==4) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356020;
				discussroomStatus=jtb[5].getText();
				for(int i=0;i<10;i++) {
					if(i==5) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356021;
				discussroomStatus=jtb[6].getText();
				for(int i=0;i<10;i++) {
					if(i==6) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356021;
				discussroomStatus=jtb[7].getText();
				for(int i=0;i<10;i++) {
					if(i==7) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356022;
				discussroomStatus=jtb[8].getText();
				for(int i=0;i<10;i++) {
					if(i==8) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356022;
				discussroomStatus=jtb[9].getText();
				for(int i=0;i<10;i++) {
					if(i==9) {
						continue;
					}else if(jtb[i].isSelected()) {
						jtb[i].setSelected(false);
					}else if(jtb[i].isSelected()==false) {
						jtb[i].setSelected(false);
					}
				}
			}
		});
		
		jtb[0].setBounds(297, 126, 72, 26);
		frame.getContentPane().add(jtb[0]);
		
		
		jtb[1].setBounds(393, 126, 72, 26);
		frame.getContentPane().add(jtb[1]);
		
		
		jtb[2].setBounds(297, 173, 72, 26);
		frame.getContentPane().add(jtb[2]);
		
		
		jtb[3].setBounds(393, 173, 72, 26);
		frame.getContentPane().add(jtb[3]);
		
		
		jtb[4].setBounds(297, 215, 72, 26);
		frame.getContentPane().add(jtb[4]);
		
		
		jtb[5].setBounds(393, 215, 72, 26);
		frame.getContentPane().add(jtb[5]);
		
		
		jtb[6].setBounds(297, 262, 72, 26);
		frame.getContentPane().add(jtb[6]);
		
		
		jtb[7].setBounds(393, 262, 72, 26);
		frame.getContentPane().add(jtb[7]);
		
		
		jtb[8].setBounds(297, 307, 72, 26);
		frame.getContentPane().add(jtb[8]);
		
		
		jtb[9].setBounds(393, 307, 72, 26);
		frame.getContentPane().add(jtb[9]);
		
		JButton btnNewButton_2 = new JButton("更改狀態");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					Statement stmt1=con1.createStatement();
					String sql1="update library_user set discussroom_status = ':discussroom_status' where user_id=':user_id'";
					sql1=sql1.replaceAll(":user_id",String.valueOf(userNumber));
					sql1=sql1.replaceAll(":discussroom_status",discussroomStatus);
					stmt1.executeUpdate(sql1);
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"已更新使用者狀態為"+discussroomStatus);
					frame.setVisible(true);
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btnNewButton_2, e1);
				}
			}
		});
		btnNewButton_2.setBounds(270, 378, 99, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("確認");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Manager_login ml=new Manager_login();
				ml.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(398, 379, 93, 32);
		frame.getContentPane().add(btnNewButton_3);
	}
}
