import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studyroom {

	public JFrame frame;
	public JButton btnNewButton_2 = new JButton("A區");
	public JButton btnNewButton_3 = new JButton("A1區");
	public JButton btnNewButton_4 = new JButton("B區");
	public JButton btnNewButton_5 = new JButton("B1區");
	public JButton btnNewButton_6 = new JButton("C區");
	public JButton btnNewButton_7 = new JButton("C1區");
	public int userNumber;
	public String userName;
	public String userDept;
	public String studyRoom;
	public String discussLocation;
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
					Studyroom window = new Studyroom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public Studyroom(int userNumber,String userName,String userDept,String studyRoom,String discussLocation,String studyroomStatus) {
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
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login_choose Lc=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
				Lc.frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(23, 23, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login L=new Login();
				L.frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(515, 23, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("自習室");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 27, 85, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("一般區");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(119, 105, 80, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("筆電區");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(258, 105, 67, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("寧靜區");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(376, 105, 85, 15);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_2.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(119, 152, 85, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_3.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_3.setBounds(119, 208, 85, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_4.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_4.setBounds(250, 152, 85, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_5.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_5.setBounds(250, 208, 85, 23);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_6.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_6.setBounds(376, 152, 85, 23);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyRoom=btnNewButton_7.getText();
				frame.setVisible(false);
				Studyroom_bookpage sab=new Studyroom_bookpage(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				sab.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_7.setBounds(376, 208, 85, 23);
		frame.getContentPane().add(btnNewButton_7);
	}
}
