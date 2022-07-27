import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Discussroom {

	public JFrame frame3;
	public String discussLocation;
    public int userNumber;
    public String userName;
    public String userDept;
    public String discussFloor;
    public String discussroomStatus;
    public String studyroomStatus;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Discussroom window = new Discussroom();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Discussroom(int userNumber,String userName,String userDept,String discussLocation,String discussFloor,String discussroomStatus) {
		this.userNumber=userNumber;
		this.userName=userName;
		this.userDept=userDept;
		this.discussLocation=discussLocation;
		this.discussroomStatus=discussroomStatus;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame3 = new JFrame();
		frame3.setBounds(100, 100, 616, 413);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("登出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
				Login L_2=new Login();
				L_2.main(null);
			}
		});
		btnNewButton.setBounds(492, 20, 85, 23);
		frame3.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("討論室預約");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(256, 24, 85, 15);
		frame3.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("達賢圖書館");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=btnNewButton_2.getText();
				frame3.setVisible(false);
				Discussroom_floor D_2=new Discussroom_floor(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				D_2.frame4.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(329, 154, 124, 45);
		frame3.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("回上一頁");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
				Login_choose Lc=new Login_choose(userNumber,userName,userDept,discussroomStatus,studyroomStatus);
				Lc.frame1.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(25, 20, 85, 23);
		frame3.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("歡迎");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(175, 61, 58, 15);
		frame3.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(this.userNumber));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(256, 61, 74, 15);
		frame3.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(this.userName);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(357, 61, 65, 15);
		frame3.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_2_1 = new JButton("中正圖書館");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discussLocation=btnNewButton_2_1.getText();
				frame3.setVisible(false);
				Discussroom_floor D_2=new Discussroom_floor(userNumber,userName,userDept,discussLocation,discussFloor,discussroomStatus);
				D_2.frame4.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(149, 155, 129, 45);
		frame3.getContentPane().add(btnNewButton_2_1);
	}
}
