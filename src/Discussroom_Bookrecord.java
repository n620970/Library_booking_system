import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;

public class Discussroom_Bookrecord {

	public JFrame frame;
	public int userNumber;
	public String userName;
	public String userDept;
	public String discussDate;
	public String discussLocation;
	public String discussRoom;
	public String discussTime;
	public String discussFloor;
	public String discussroomStatus;
	public String studyroomStatus;
	
	Dahsian_bookpage_sucess db4s =new Dahsian_bookpage_sucess(userNumber,userName,discussDate,discussRoom,discussTime,userDept,discussLocation,discussroomStatus);
	public JToggleButton tglbtnNewToggleButton = new JToggleButton("預約中");
	public JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("已取消預約");
	JButton btnNewButton_4 = new JButton("取消");
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookrecord window = new bookrecord();
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
	public Discussroom_Bookrecord(int userNumber,String userName,String userDept,String discussDate,String discussLocation,String discussRoom,String discussTime) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.discussDate=discussDate;
		this.discussLocation=discussLocation;
		this.discussRoom=discussRoom;
		this.discussTime=discussTime;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		tglbtnNewToggleButton_1.setEnabled(false);
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login=new Login();
				login.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(732, 24, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("個人討論室借用紀錄");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(318, 20, 200, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("預約");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Discussroom discussroom=new Discussroom(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				discussroom.frame3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(21, 167, 85, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("個人資訊");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Personal_information pi=new Personal_information(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				pi.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(21, 253, 85, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login_choose login_choose=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
				login_choose.frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(21, 24, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("借用狀態");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(321, 113, 100, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(this.discussDate);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(191, 206, 67, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(this.discussLocation);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(255, 204, 85, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(this.discussRoom);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(336, 206, 85, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(this.discussTime);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(419, 206, 85, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("取消預約");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(701, 115, 76, 19);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnNewToggleButton.setEnabled(false);
				if(tglbtnNewToggleButton_1.isSelected()) {
					tglbtnNewToggleButton_1.setSelected(true);
				}else if(tglbtnNewToggleButton_1.isSelected()==false) {
					tglbtnNewToggleButton_1.setSelected(true);
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					Statement stmt4=con4.createStatement();
					String sql4="delete from dahsian_discussroom1 where user_id=':user_id' and discuss_date=':discuss_date' and discuss_room=':discuss_room'";
					sql4=sql4.replaceAll(":user_id",String.valueOf(userNumber));
					sql4=sql4.replaceAll(":discuss_date",discussDate);
					sql4=sql4.replaceAll(":discuss_room",discussRoom);
					stmt4.executeUpdate(sql4);
					frame.setVisible(true);
					
					btnNewButton_4.setEnabled(false);
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(btnNewButton_4, e2);
				}
			}
		});
		btnNewButton_4.setBounds(701, 198, 76, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_9 = new JLabel("日期");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(203, 167, 46, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("地點");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(270, 167, 46, 15);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("討論室");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(352, 167, 46, 15);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("時段");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(440, 167, 46, 15);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_7 = new JLabel("預約狀態");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(535, 167, 67, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		tglbtnNewToggleButton.setBounds(514, 198, 117, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		
		tglbtnNewToggleButton_1.setBounds(514, 243, 117, 23);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		

	}
}
