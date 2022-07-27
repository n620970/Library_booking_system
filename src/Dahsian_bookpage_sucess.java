import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Dahsian_bookpage_sucess {
	public JFrame frame;
	public int userNumber;
	public String userName;
	public String discussDate;
	public String discussRoom;
	public String discussTime;
	public String userDept;
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
					Dahsian_bookpage_4F_sucess window = new Dahsian_bookpage_4F_sucess();
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
	public Dahsian_bookpage_sucess(int userNumber,String userName,String discussDate,String discussRoom,String discussTime,String userDept,String discussLocation,String userStatus) {
		
		this.userNumber=userNumber;
		this.userName=userName;
		this.discussDate=discussDate;
		this.discussRoom=discussRoom;
		this.discussTime=discussTime;
		this.userDept=userDept;
		this.discussLocation=discussLocation;
		this.discussroomStatus=discussroomStatus;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("使用者學號：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 86, 88, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("使用者姓名：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(151, 123, 88, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(this.userNumber));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(230, 86, 72, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(this.userName);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(238, 123, 64, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("預約日期：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(151, 160, 76, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("預約時段：");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(151, 203, 76, 15);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("討論室：");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(151, 241, 76, 15);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		Dahsian_bookpage d4f=new Dahsian_bookpage(this.userNumber,this.userName,this.userDept,discussLocation,this.discussFloor,this.discussroomStatus);
		
		JLabel lblNewLabel_3_1 = new JLabel(this.discussDate);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(238, 160, 64, 15);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel(this.discussTime);
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(238, 203, 64, 15);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel(this.discussRoom);
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setBounds(238, 241, 64, 15);
		frame.getContentPane().add(lblNewLabel_3_3);
		
		
		//System.out.println(userStatus);
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(discussroomStatus);
				if(discussroomStatus.equals("違規")) {
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null,"違規身分，禁止預約討論室！");
					frame.setVisible(false);
					Login_choose lc=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
					lc.frame1.setVisible(true);
					
				}else if(discussroomStatus.equals("違規")==false) {
					try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
						Class.forName("com.mysql.jdbc.Driver");
						Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
						Statement stmt3=con3.createStatement();
						//String sql3="insert into dahsian_discussroom1 (user_id,user_name,discuss_date,discuss_time,discuss_room) values ("+"'"+userNumber+"','"+userName+"','"+discussDate+"','"+discussTime+"','"+discussRoom+"' )";
						String sql3="insert into dahsian_discussroom1 (user_id,user_name,discuss_date,discuss_time,discuss_room) values (:userNumber,':userName',':discussDate',':discussTime',':discussRoom')";
						sql3=sql3.replaceAll(":userNumber",String.valueOf(userNumber));
						sql3=sql3.replaceAll(":userName",userName);
						sql3=sql3.replaceAll(":discussDate",discussDate);
						sql3=sql3.replaceAll(":discussTime",discussTime);
						sql3=sql3.replaceAll(":discussRoom",discussRoom);
						
						System.out.println(sql3);
						stmt3.executeUpdate(sql3);				
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null,"預約成功！");
						Discussroom_Bookrecord bookrecord=new Discussroom_Bookrecord(userNumber,userName,userDept,discussDate,discussLocation,discussRoom,discussTime);
						bookrecord.frame.setVisible(true);
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(btnNewButton, e1);
					}
				}
			}
		});
		btnNewButton.setBounds(151, 285, 85, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Dahsian_bookpage db4=new Dahsian_bookpage(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				db4.frame6.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(259, 285, 85, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("討論室預約確認");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(112, 23, 283, 23);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
