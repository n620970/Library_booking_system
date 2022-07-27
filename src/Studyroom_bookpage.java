import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;

public class Studyroom_bookpage {

	public JFrame frame;
	public int userNumber;
	public String userName;
	public String userDept;
	public String studyRoom;
	public String discussLocation;
	public String discussFloor;
	public String borrowTime;
    public String discussroomStatus;
    public String studyroomStatus;
	public int totalNumber=15;
	public int isSelectedNumber;
	public int remainNumber=totalNumber-isSelectedNumber;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studyroom_A_bookpage window = new Studyroom_A_bookpage();
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
	public Studyroom_bookpage(int userNumber,String userName,String userDept,String studyRoom,String discussLocation,String studyroomStatus) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.studyRoom=studyRoom;
		this.discussLocation=discussLocation;
		this.studyroomStatus=studyroomStatus;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JToggleButton[] tgb=new JToggleButton[15];
		tgb[0]=new JToggleButton(this.studyRoom+"_1");
		tgb[1]=new JToggleButton(this.studyRoom+"_2");
		tgb[2]=new JToggleButton(this.studyRoom+"_3");
		tgb[3]=new JToggleButton(this.studyRoom+"_4");
		tgb[4]=new JToggleButton(this.studyRoom+"_5");
		tgb[5]=new JToggleButton(this.studyRoom+"_6");
		tgb[6]=new JToggleButton(this.studyRoom+"_7");
		tgb[7]=new JToggleButton(this.studyRoom+"_8");
		tgb[8]=new JToggleButton(this.studyRoom+"_9");
		tgb[9]=new JToggleButton(this.studyRoom+"_10");
		tgb[10]=new JToggleButton(this.studyRoom+"_11");
		tgb[11]=new JToggleButton(this.studyRoom+"_12");
		tgb[12]=new JToggleButton(this.studyRoom+"_13");
		tgb[13]=new JToggleButton(this.studyRoom+"_14");
		tgb[14]=new JToggleButton(this.studyRoom+"_15");
		
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom studyroom=new Studyroom(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				studyroom.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 26, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login=new Login();
				login.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(712, 26, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel(studyRoom+"自習室");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(331, 30, 147, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("總位數：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 124, 71, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("空位：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(53, 168, 46, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("已選：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(53, 217, 46, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(String.valueOf(totalNumber));
		
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(107, 124, 46, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(remainNumber));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(109, 168, 46, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(String.valueOf(isSelectedNumber));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(107, 217, 46, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		tgb[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[0].getText();
				for(int i=0;i<15;i++) {
					if(i==0) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[1].getText();
				for(int i=0;i<15;i++) {
					if(i==1) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[2].getText();
				for(int i=0;i<15;i++) {
					if(i==2) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[3].getText();
				for(int i=0;i<15;i++) {
					if(i==3) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[4].getText();
				for(int i=0;i<15;i++) {
					if(i==4) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[5].getText();
				for(int i=0;i<15;i++) {
					if(i==5) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[6].getText();
				for(int i=0;i<15;i++) {
					if(i==6) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[7].getText();
				for(int i=0;i<15;i++) {
					if(i==7) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[8].getText();
				for(int i=0;i<15;i++) {
					if(i==8) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[9].getText();
				for(int i=0;i<15;i++) {
					if(i==9) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[10].getText();
				for(int i=0;i<15;i++) {
					if(i==10) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[11].getText();
				for(int i=0;i<15;i++) {
					if(i==11) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[12].getText();
				for(int i=0;i<15;i++) {
					if(i==12) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[13].getText();
				for(int i=0;i<15;i++) {
					if(i==13) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=tgb[14].getText();
				for(int i=0;i<15;i++) {
					if(i==14) {
						continue;
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}else if(tgb[i].isSelected()) {
						tgb[i].setSelected(false);
					}
				}
			}
		});
		
		tgb[0].setBounds(220, 92, 77, 23);
		frame.getContentPane().add(tgb[0]);
		
		
		tgb[1].setBounds(307, 92, 77, 23);
		frame.getContentPane().add(tgb[1]);
		
		
		tgb[2].setBounds(401, 92, 77, 23);
		frame.getContentPane().add(tgb[2]);
		
		
		tgb[3].setBounds(500, 92, 77, 23);
		frame.getContentPane().add(tgb[3]);
		
		
		tgb[4].setBounds(589, 92, 77, 23);
		frame.getContentPane().add(tgb[4]);
		
		
		tgb[5].setBounds(220, 142, 77, 23);
		frame.getContentPane().add(tgb[5]);
		

		tgb[6].setBounds(307, 142, 77, 23);
		frame.getContentPane().add(tgb[6]);
		

		tgb[7].setBounds(401, 142, 77, 23);
		frame.getContentPane().add(tgb[7]);
		

		tgb[8].setBounds(500, 142, 77, 23);
		frame.getContentPane().add(tgb[8]);
		

		tgb[9].setBounds(589, 142, 77, 23);
		frame.getContentPane().add(tgb[9]);
		

		tgb[10].setBounds(220, 195, 77, 23);
		frame.getContentPane().add(tgb[10]);
		

		tgb[11].setBounds(307, 195, 77, 23);
		frame.getContentPane().add(tgb[11]);
		

		tgb[12].setBounds(401, 195, 77, 23);
		frame.getContentPane().add(tgb[12]);
		

		tgb[13].setBounds(500, 195, 77, 23);
		frame.getContentPane().add(tgb[13]);
		

		tgb[14].setBounds(589, 195, 77, 23);
		frame.getContentPane().add(tgb[14]);
		
		JButton btnNewButton_2 = new JButton("預約");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom_success sas=new Studyroom_success(userNumber,userName,studyRoom,discussLocation,userDept,borrowTime,discussFloor,studyroomStatus);
				sas.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(712, 370, 85, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("個人資訊");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Personal_information pf=new Personal_information(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				pf.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(53, 271, 85, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("借用紀錄");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom_Bookrecord sb=new Studyroom_Bookrecord(userNumber,userName,userDept,studyRoom,discussLocation,discussFloor,borrowTime);
				sb.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(53, 321, 85, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("違規紀錄");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom_Violationrecord sv=new Studyroom_Violationrecord();
				sv.frame.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(53, 370, 85, 23);
		frame.getContentPane().add(btnNewButton_5);
	}

}
