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
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Studyroom_Bookrecord {

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
	CurrentTime currenttime=new CurrentTime();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studyroom_Bookrecord window = new Studyroom_Bookrecord();
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
	public Studyroom_Bookrecord(int userNumber,String userName,String userDept,String studyRoom,String discussLocation,String discussFloor,String borrowTime) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.studyRoom=studyRoom;
		this.discussFloor=discussFloor;
		this.discussLocation=discussLocation;
		this.borrowTime=borrowTime;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 816, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login_choose ls=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
				ls.frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 34, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login l= new Login();
				l.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(670, 34, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("個人自習室借用紀錄");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(326, 34, 139, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("預約");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Studyroom_bookpage sb =new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sb.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(31, 166, 85, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("個人資訊");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Personal_information pi=new Personal_information(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				
			}
		});
		btnNewButton_3.setBounds(31, 238, 85, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("借用狀態");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(310, 110, 90, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("取消座位");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(572, 106, 75, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("取消");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					Statement stmt5=con5.createStatement();
					String sql5="delete from studyRoom where user_id=':user_id' and study_room=':study_room' and study_location=':study_location'";
					sql5=sql5.replaceAll(":user_id",String.valueOf(userNumber));
					sql5=sql5.replaceAll(":study_room",studyRoom);
					sql5=sql5.replaceAll(":study_location",discussLocation);
					stmt5.executeUpdate(sql5);
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"刪除成功！");
					btnNewButton_4.setEnabled(false);
					
				}catch(Exception e5) {
					JOptionPane.showMessageDialog(btnNewButton_4, e5);
				}
			}
		});
		
		btnNewButton_4.setBounds(572, 195, 85, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(177, 158, 46, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("區域");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(373, 158, 46, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label = new JLabel("座位");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(468, 158, 46, 15);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_5 = new JLabel("時間");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(272, 158, 46, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel(currenttime.time1());
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(177, 199, 46, 15);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(borrowTime);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(246, 199, 100, 15);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(studyRoom);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(373, 199, 46, 15);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel(discussLocation);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(468, 199, 46, 15);
		frame.getContentPane().add(lblNewLabel_10);
	}
}
