import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;


public class Dahsian_bookpage {
	
	CurrentTime currenttime=new CurrentTime();
	public JFrame frame6;
	public int userNumber;
	public String userName;
	public String userDept;
	public String discussDate;
	public String discussRoom;
	public String discussTime;
	public String discussLocation;
	public String discussFloor;
	public String discussroomStatus;
	public String studyroomStatus;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dahsian_bookpage_4F window = new Dahsian_bookpage_4F();
					window.frame6.setVisible(true);
					//java建立mysql資料表語法：
					//Class.forName("com.mysql.jdbc.Driver");
					//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					//Statement stmt3=con.createStatement();
					//String sql3="insert into Dahsian_discussroom (Dahsian_discussroomID,discuss_date,discuss_room,discuss_time) values ("+tglbtnNewToggleButton.                               
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Dahsian_bookpage(int userNumber,String userName,String userDept,String discussLocation,String discussFloor,String discussroomStatus) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.discussLocation=discussLocation;
		this.discussFloor=discussFloor;
		this.discussroomStatus=discussroomStatus;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		
		JToggleButton[] tgButton=new JToggleButton[14];
		tgButton[0]=new JToggleButton(currenttime.time1());
		tgButton[1]=new JToggleButton(currenttime.time2(1));
		tgButton[2]=new JToggleButton(currenttime.time2(2));
		tgButton[3]=new JToggleButton(currenttime.time2(3));
		tgButton[4]=new JToggleButton(currenttime.time2(4));
		tgButton[5]=new JToggleButton(currenttime.time2(5));
		tgButton[6]=new JToggleButton(currenttime.time2(6));
		tgButton[7]=new JToggleButton(currenttime.time2(7));
		tgButton[8]=new JToggleButton(currenttime.time2(8));
		tgButton[9]=new JToggleButton(currenttime.time2(9));
		tgButton[10]=new JToggleButton(currenttime.time2(10));
		tgButton[11]=new JToggleButton(currenttime.time2(11));
		tgButton[12]=new JToggleButton(currenttime.time2(12));
		tgButton[13]=new JToggleButton(currenttime.time2(13));
		
		JToggleButton[] tgButton2=new JToggleButton[4];
		tgButton2[0]=new JToggleButton("401");
		tgButton2[1]=new JToggleButton("402");
		tgButton2[2]=new JToggleButton("403");
		tgButton2[3]=new JToggleButton("404");
		
		JToggleButton[] tgButton3=new JToggleButton[14];
		tgButton3[0]=new JToggleButton("8~9");
		tgButton3[1]=new JToggleButton("9~10");
		tgButton3[2]=new JToggleButton("10~11");
		tgButton3[3]=new JToggleButton("11~12");
		tgButton3[4]=new JToggleButton("12~13");
		tgButton3[5]=new JToggleButton("13~14");
		tgButton3[6]=new JToggleButton("14~15");
		tgButton3[7]=new JToggleButton("15~16");
		tgButton3[8]=new JToggleButton("16~17");
		tgButton3[9]=new JToggleButton("17~18");
		tgButton3[10]=new JToggleButton("18~19");
		tgButton3[11]=new JToggleButton("19~20");
		tgButton3[12]=new JToggleButton("20~21");
		tgButton3[13]=new JToggleButton("21~22");
		
		
		frame6 = new JFrame();
		frame6.setBounds(100, 100, 1016, 603);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Discussroom_floor D_2=new Discussroom_floor(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				D_2.frame4.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 28, 85, 23);
		frame6.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Login L_1=new Login();
				L_1.main(null);
			}
		});
		btnNewButton_1.setBounds(872, 28, 85, 23);
		frame6.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel(discussLocation+this.discussFloor+"討論室");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(393, 32, 209, 15);
		frame6.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("個人資訊");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Personal_information pi=new Personal_information(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				pi.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(20, 189, 85, 29);
		frame6.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("借用紀錄");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Discussroom_Bookrecord bookrecord=new Discussroom_Bookrecord(userNumber,userName,userDept,discussDate,discussLocation,discussRoom,discussTime);
				bookrecord.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(20, 263, 85, 29);
		frame6.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("日期_step1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(127, 189, 70, 15);
		frame6.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("討論室_step2");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(120, 277, 97, 15);
		frame6.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("時段_step3");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(127, 356, 79, 15);
		frame6.getContentPane().add(lblNewLabel_3);
		
		///////////////////日期////////////////////
		tgButton[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[0].getText();
				for(int i=0;i<14;i++) {
					if(i==0) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[1].getText();
				for(int i=0;i<14;i++) {
					if(i==1) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[2].getText();
				for(int i=0;i<14;i++) {
					if(i==2) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[3].getText();
				for(int i=0;i<14;i++) {
					if(i==3) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[4].getText();
				for(int i=0;i<14;i++) {
					if(i==4) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[5].getText();
				for(int i=0;i<14;i++) {
					if(i==5) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[6].getText();
				for(int i=0;i<14;i++) {
					if(i==6) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[7].getText();
				for(int i=0;i<14;i++) {
					if(i==7) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[8].getText();
				for(int i=0;i<14;i++) {
					if(i==8) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[9].getText();
				for(int i=0;i<14;i++) {
					if(i==9) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[10].getText();
				for(int i=0;i<14;i++) {
					if(i==10) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[11].getText();
				for(int i=0;i<14;i++) {
					if(i==11) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[12].getText();
				for(int i=0;i<14;i++) {
					if(i==12) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussDate=tgButton[13].getText();
				for(int i=0;i<14;i++) {
					if(i==13) {
						continue;
					}else if (tgButton[i].isSelected()) {
						tgButton[i].setSelected(false);
					}else if (tgButton[i].isSelected()==false) {
						tgButton[i].setSelected(false);
					}
				}
			}
		});
		//日期//
		
		//討論室//
		tgButton2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussRoom=tgButton2[0].getText();
				for(int i=0;i<4;i++) {
					if(i==0) {
						continue;
					}else if (tgButton2[i].isSelected()) {
						tgButton2[i].setSelected(false);
					}else if (tgButton2[i].isSelected()==false) {
						tgButton2[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton2[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussRoom=tgButton2[1].getText();
				for(int i=0;i<4;i++) {
					if(i==1) {
						continue;
					}else if (tgButton2[i].isSelected()) {
						tgButton2[i].setSelected(false);
					}else if (tgButton2[i].isSelected()==false) {
						tgButton2[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton2[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussRoom=tgButton2[2].getText();
				for(int i=0;i<4;i++) {
					if(i==2) {
						continue;
					}else if (tgButton2[i].isSelected()) {
						tgButton2[i].setSelected(false);
					}else if (tgButton2[i].isSelected()==false) {
						tgButton2[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton2[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussRoom=tgButton2[3].getText();
				for(int i=0;i<4;i++) {
					if(i==3) {
						continue;
					}else if (tgButton2[i].isSelected()) {
						tgButton2[i].setSelected(false);
					}else if (tgButton2[i].isSelected()==false) {
						tgButton2[i].setSelected(false);
					}
				}
			}
		});
		//討論室//
		
		//時間//
		tgButton3[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[0].getText();
;				for(int i=0;i<14;i++) {
					if(i==0) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[1].getText();
				for(int i=0;i<14;i++) {
					if(i==1) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[2].getText();
				for(int i=0;i<14;i++) {
					if(i==2) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[3].getText();
				for(int i=0;i<14;i++) {
					if(i==3) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[4].getText();
				for(int i=0;i<14;i++) {
					if(i==4) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[5].getText();
				for(int i=0;i<14;i++) {
					if(i==5) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[6].getText();
				for(int i=0;i<14;i++) {
					if(i==6) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[7].getText();
				for(int i=0;i<14;i++) {
					if(i==7) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[8].getText();
				for(int i=0;i<14;i++) {
					if(i==8) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[9].getText();
				for(int i=0;i<14;i++) {
					if(i==9) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[10].getText();
				for(int i=0;i<14;i++) {
					if(i==10) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[11].getText();
				for(int i=0;i<14;i++) {
					if(i==11) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[12].getText();
				for(int i=0;i<14;i++) {
					if(i==12) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		tgButton3[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussTime=tgButton3[13].getText();
				for(int i=0;i<14;i++) {
					if(i==13) {
						continue;
					}else if (tgButton3[i].isSelected()) {
						tgButton3[i].setSelected(false);
					}else if (tgButton3[i].isSelected()==false) {
						tgButton3[i].setSelected(false);
					}
				}
			}
		});
		
		//時間//
		
		tgButton[0].setBounds(235, 167, 79, 23);
		frame6.getContentPane().add(tgButton[0]);
		
		//JToggleButton tglbtnNewToggleButton8 = new JToggleButton(currenttime.time2(7));
		tgButton[7].setBounds(235, 199, 79, 23);
		frame6.getContentPane().add(tgButton[7]);
		
		//JToggleButton tglbtnNewToggleButton9 = new JToggleButton(currenttime.time2(8));
		tgButton[8].setBounds(324, 199, 79, 23);
		frame6.getContentPane().add(tgButton[8]);
		
		//JToggleButton tglbtnNewToggleButton2 = new JToggleButton(currenttime.time2(1));
		tgButton[1].setBounds(324, 167, 79, 23);
		frame6.getContentPane().add(tgButton[1]);
		
		//JToggleButton tglbtnNewToggleButton3 = new JToggleButton(currenttime.time2(2));
		tgButton[2].setBounds(413, 167, 79, 23);
		frame6.getContentPane().add(tgButton[2]);
		
		//JToggleButton tglbtnNewToggleButton4 = new JToggleButton(currenttime.time2(3));
		tgButton[3].setBounds(502, 167, 79, 23);
		frame6.getContentPane().add(tgButton[3]);
		
		//JToggleButton tglbtnNewToggleButton10 = new JToggleButton(currenttime.time2(9));
		tgButton[9].setBounds(413, 199, 79, 23);
		frame6.getContentPane().add(tgButton[9]);
		
		//JToggleButton tglbtnNewToggleButton11 = new JToggleButton(currenttime.time2(10));
		tgButton[10].setBounds(502, 199, 79, 23);
		frame6.getContentPane().add(tgButton[10]);
		
		//JToggleButton tglbtnNewToggleButton5 = new JToggleButton(currenttime.time2(4));
		tgButton[4].setBounds(591, 167, 79, 23);
		frame6.getContentPane().add(tgButton[4]);
		
		//JToggleButton tglbtnNewToggleButton6 = new JToggleButton(currenttime.time2(5));
		tgButton[5].setBounds(680, 167, 79, 23);
		frame6.getContentPane().add(tgButton[5]);
		
		//JToggleButton tglbtnNewToggleButton12 = new JToggleButton(currenttime.time2(11));
		tgButton[11].setBounds(591, 199, 79, 23);
		frame6.getContentPane().add(tgButton[11]);
		
		//JToggleButton tglbtnNewToggleButton13 = new JToggleButton(currenttime.time2(12));
		tgButton[12].setBounds(680, 199, 79, 23);
		frame6.getContentPane().add(tgButton[12]);
		
		//JToggleButton tglbtnNewToggleButton7 = new JToggleButton(currenttime.time2(6));
		tgButton[6].setBounds(775, 167, 79, 23);
		frame6.getContentPane().add(tgButton[6]);
		
		//JToggleButton tglbtnNewToggleButton14 = new JToggleButton(currenttime.time2(13));
		tgButton[13].setBounds(775, 199, 79, 23);
		frame6.getContentPane().add(tgButton[13]);
		
		
		tgButton2[0].setBounds(235, 268, 79, 23);
		frame6.getContentPane().add(tgButton2[0]);
		
		tgButton2[1].setBounds(324, 268, 79, 23);
		frame6.getContentPane().add(tgButton2[1]);
		
		tgButton2[2].setBounds(413, 268, 79, 23);
		frame6.getContentPane().add(tgButton2[2]);
		
		tgButton2[3].setBounds(502, 268, 79, 23);
		frame6.getContentPane().add(tgButton2[3]);
		
		tgButton3[0].setBounds(231, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[0]);
		
		tgButton3[1].setBounds(320, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[1]);
		
		
		tgButton3[6].setBounds(231, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[6]);
		
		tgButton3[7].setBounds(320, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[7]);
		
		
		tgButton3[2].setBounds(409, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[2]);
		
		
		tgButton3[3].setBounds(498, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[3]);
		
	
		tgButton3[8].setBounds(409, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[8]);
		
		
		tgButton3[9].setBounds(498, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[9]);
		
		
		tgButton3[4].setBounds(587, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[4]);
		
		
		tgButton3[5].setBounds(676, 342, 79, 23);
		frame6.getContentPane().add(tgButton3[5]);
		
		
		tgButton3[10].setBounds(587, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[10]);
		
		
		tgButton3[11].setBounds(676, 375, 79, 23);
		frame6.getContentPane().add(tgButton3[11]);
		

		tgButton3[12].setBounds(231, 408, 79, 23);
		frame6.getContentPane().add(tgButton3[12]);
		
		
		tgButton3[13].setBounds(320, 408, 79, 23);
		frame6.getContentPane().add(tgButton3[13]);
		
		JLabel lblNewLabel_4 = new JLabel("歡迎");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(367, 76, 46, 15);
		frame6.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(userNumber));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(435, 76, 85, 15);
		frame6.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(userName);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(543, 76, 76, 15);
		frame6.getContentPane().add(lblNewLabel_6);
		
		
		JButton btnNewButton_6 = new JButton("預約");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Dahsian_bookpage_sucess D4S=new Dahsian_bookpage_sucess(userNumber,userName,discussDate,discussRoom,discussTime,userDept,discussLocation,discussroomStatus);
				D4S.frame.setVisible(true);
			}
		});
		
		btnNewButton_6.setBounds(801, 443, 85, 23);
		frame6.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("違規紀錄");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.setVisible(false);
				Discussroom_Violationrecord dv=new Discussroom_Violationrecord();
				dv.frame.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(20, 339, 85, 32);
		frame6.getContentPane().add(btnNewButton_5);
	}

}
