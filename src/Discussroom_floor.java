import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Discussroom_floor {

	public JFrame frame4;
	public int userNumber;
	public String userName;
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
					Dahsian_floor window = new Dahsian_floor();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Discussroom_floor(int userNumber,String userName,String userDept,String discussLocation,String discussFloor,String discussroomStatus) {
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
		frame4 = new JFrame();
		frame4.setBounds(100, 100, 553, 457);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4.setVisible(false);
				Discussroom D_1=new Discussroom(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				D_1.frame3.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 28, 85, 23);
		frame4.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4.setVisible(false);
				Login L_2=new Login();
				L_2.main(null);
			}
		});
		btnNewButton_1.setBounds(416, 28, 85, 23);
		frame4.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel(discussLocation+"討論室");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 32, 198, 15);
		frame4.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("樓層");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(229, 135, 46, 15);
		frame4.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_6 = new JButton("4F");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussFloor=btnNewButton_6.getText();
				frame4.setVisible(false);
				Dahsian_bookpage D_3=new Dahsian_bookpage(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus) ;
				D_3.frame6.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(212, 289, 85, 29);
		frame4.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_2 = new JLabel("歡迎");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(141, 71, 55, 15);
		frame4.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(String.valueOf(this.userNumber));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(213, 71, 71, 15);
		frame4.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(this.userName);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(303, 71, 65, 15);
		frame4.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_6_1 = new JButton("5F");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussFloor=btnNewButton_6_1.getText();
				frame4.setVisible(false);
				Dahsian_bookpage D_3=new Dahsian_bookpage(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus) ;
				D_3.frame6.setVisible(true);
			}
		});
		btnNewButton_6_1.setBounds(212, 232, 85, 29);
		frame4.getContentPane().add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("6F");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussFloor=btnNewButton_6_2.getText();
				frame4.setVisible(false);
				Dahsian_bookpage D_3=new Dahsian_bookpage(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus) ;
				D_3.frame6.setVisible(true);
			}
		});
		btnNewButton_6_2.setBounds(212, 176, 85, 29);
		frame4.getContentPane().add(btnNewButton_6_2);
	}
}
