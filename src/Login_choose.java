import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login_choose {

	public  JFrame frame1;
    public String hairColor="black";
    public Login L1;
    public int userNumber;
    public String userName;
    public String userDept;
    public String studyRoom;
    public String discussLocation;
    public String discussFloor;
    public String discussroomStatus;
    public String studyroomStatus;
    
    //Login_choose函式呼叫initialize()，initialize()這個函式被呼叫了
    //{}-->定義函式
    //()-->呼叫函式
	public Login_choose(int userNumber, String userName,String userDept,String discussroomStatus,String studyroomStatus) {	
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.discussroomStatus=discussroomStatus;
		this.studyroomStatus=studyroomStatus;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame1 = new JFrame();
		frame1.setBounds(100, 100, 518, 375);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JButton logoutbtn = new JButton("登出 Logout");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				Login L_2=new Login();
				L_2.main(null);
			}
		});

		logoutbtn.setBounds(370, 8, 93, 23);
		frame1.getContentPane().add(logoutbtn);
		
		JLabel lblNewLabel = new JLabel("歡迎");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 18, 46, 15);
		frame1.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("討論室預約");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				Discussroom discussroom=new Discussroom(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				discussroom.frame3.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(93, 132, 121, 46);
		frame1.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("自習室劃位");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				Studyroom studyroom=new Studyroom(userNumber,userName,userDept,studyRoom,discussLocation,studyroomStatus);
				studyroom.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(272, 132, 114, 46);
		frame1.getContentPane().add(btnNewButton_2);
		
		
		JLabel userIDlabel = new JLabel(String.valueOf(this.userNumber));
		userIDlabel.setHorizontalAlignment(SwingConstants.CENTER);
		userIDlabel.setBounds(171, 18, 67, 15);
		frame1.getContentPane().add(userIDlabel);
		
		JLabel userNamelable = new JLabel(this.userName);
		userNamelable.setHorizontalAlignment(SwingConstants.CENTER);
		userNamelable.setBounds(258, 18, 67, 15);
		frame1.getContentPane().add(userNamelable);
	}
}
