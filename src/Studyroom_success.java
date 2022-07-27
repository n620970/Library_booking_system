import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Studyroom_success {

	public JFrame frame;	
	public int userNumber;
	public String userName;
	public String studyRoom;
	public String discussLocation;
	public String userDept;
	public String borrowTime;
	public String discussFloor;
    public String discussroomStatus;
    public String studyroomStatus;
	CurrentTime currenttime=new CurrentTime();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studyroom_A_success window = new Studyroom_A_success();
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
	public Studyroom_success(int userNumber,String userName,String studyRoom,String discussLocation,String userDept,String borrowTime,String discussFloor,String studyroomStatus) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.studyRoom=studyRoom;
		this.discussLocation=discussLocation;
		this.userDept=userDept;
		this.borrowTime=borrowTime;
		this.discussFloor=discussFloor;
		this.studyroomStatus=studyroomStatus;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(studyRoom+"自習室預約確認");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 24, 218, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("使用者學號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(136, 68, 88, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("使用者姓名：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(136, 105, 88, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("自習室：");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(136, 149, 76, 15);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(this.userNumber));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(230, 68, 67, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(this.userName);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(230, 105, 67, 15);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_4 = new JLabel(this.studyRoom);
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setBounds(230, 149, 67, 15);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowTime=currenttime.time3();
				if(studyroomStatus.equals("違規")) {
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"違規身分，禁止預約討論室！");
					frame.setVisible(false);
					Login_choose lc=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
					lc.frame1.setVisible(true);
				}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
						Statement stmt5=con5.createStatement();
						String sql5="insert into studyroom (user_id,user_name,study_room,study_location) values (':user_id',':user_name',':study_room',':study_location')";
						sql5=sql5.replaceAll(":user_id",String.valueOf(userNumber));
						sql5=sql5.replaceAll(":user_name",userName);
						sql5=sql5.replaceAll(":study_room",studyRoom);
						sql5=sql5.replaceAll(":study_location",discussLocation);
						
						stmt5.executeUpdate(sql5);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"預約成功！");
						Studyroom_Bookrecord sb=new Studyroom_Bookrecord(userNumber,userName,userDept,studyRoom,discussLocation,discussFloor,borrowTime);
						sb.frame.setVisible(true);
					}catch(Exception e5) {
						JOptionPane.showMessageDialog(btnNewButton, e5);
					}
				}
			}
		});
		btnNewButton.setBounds(127, 277, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(266, 277, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("位置：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(136, 191, 63, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(this.discussLocation);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(235, 191, 62, 15);
		frame.getContentPane().add(lblNewLabel_4);
	}

}
