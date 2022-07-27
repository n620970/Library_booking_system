import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class Manager_studyroom {

	public JFrame frame;
	public int userNumber;
	public String studyroomStatus;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_studyroom window = new Manager_studyroom();
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
	public Manager_studyroom() {
		
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
		frame.setBounds(100, 100, 568, 469);
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
		btnNewButton.setBounds(22, 29, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login l=new Login();
				l.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(437, 29, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("自習室黑名單");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(219, 31, 104, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("學號");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(102, 85, 46, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(198, 85, 46, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("借閱狀態");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(349, 86, 72, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("111356018");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(73, 128, 85, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("胡怡欣");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(198, 128, 46, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("111356019");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(73, 170, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("王大明");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(198, 170, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("李小華");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(198, 212, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("111356020");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setBounds(73, 212, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("蔡小美");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(198, 259, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("陳小鐘");
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setBounds(198, 304, 46, 15);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_5_4 = new JLabel("111356022");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_4.setBounds(73, 304, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_3 = new JLabel("111356021");
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_3.setBounds(73, 259, 85, 15);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		jtb[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNumber=111356018;
				studyroomStatus=jtb[0].getText();
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
				studyroomStatus=jtb[1].getText();
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
				studyroomStatus=jtb[2].getText();
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
				studyroomStatus=jtb[3].getText();
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
				studyroomStatus=jtb[4].getText();
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
				studyroomStatus=jtb[5].getText();
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
				studyroomStatus=jtb[6].getText();
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
				studyroomStatus=jtb[7].getText();
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
				studyroomStatus=jtb[8].getText();
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
				studyroomStatus=jtb[9].getText();
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
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					Statement stmt2=con2.createStatement();
					String sql2="update library_user set studyroom_status = ':studyroom_status' where user_id=':user_id'";
					sql2=sql2.replaceAll(":user_id",String.valueOf(userNumber));
					sql2=sql2.replaceAll(":studyroom_status",studyroomStatus);
					stmt2.executeUpdate(sql2);
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"已更新使用者狀態為"+studyroomStatus);
					frame.setVisible(true);
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(btnNewButton_2, e2);
				}
			}
		});
		btnNewButton_2.setBounds(284, 360, 85, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("確認");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Manager_login ml=new Manager_login();
				ml.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(407, 361, 85, 26);
		frame.getContentPane().add(btnNewButton_3);
	}

}
