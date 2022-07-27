import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

public class Login {

	public JFrame frame;
	public JTextField userid;
	public JTextField userpassword;
	public Login_choose L;
	public int userNumber;
	public String discussroomStatus;
	public String studyroomStatus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton loginbtn = new JButton("登入");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//使用 class.forName() 方法來載入我們從 MySQL 官方網站下載的 JDBC Driver。
					Class.forName("com.mysql.jdbc.Driver");
					//getConnection() 方法用於傳遞連線字串，port:3306,資料庫名稱:Library,使用者名稱,使用者密碼
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					int uid=Integer.valueOf( userid.getText());
					int upd=Integer.valueOf(userpassword.getText());
					
					//createStatement()，是為了建立 SQLServerStatement 物件，以便將 SQL 陳述式傳送至資料庫。
					Statement stmt=con.createStatement();
					Statement stmt1=con.createStatement();
					//要執行的sql語法
					String sql="select * from library_user"+" where user_id="+String.valueOf(uid)+" and user_password="+String.valueOf(upd);
					String sql2="select user_name from library_user where user_id="+String.valueOf(uid);
					
					//System.out.println(sql2);
					
					//executeQuery()方法是要把數據庫回傳的查詢結果存放在ResultSet
					ResultSet rs=stmt.executeQuery(sql);
					//ResultSet rs1=stmt1.executeQuery(sql2);
					;
					

					//getString()，是指以String的形式獲取此ResultSet物件的當前行中指定列的值
					/*
					if (rs1.next()) {
						String userName=rs1.getString("user_name");
						System.out.println(userName);
					}*/
					if (rs.next()){
						frame.setVisible(false);
						//Login_choose(input值)
						Login_choose loginChoose=new Login_choose(uid,rs.getString("user_name"),rs.getString("user_department"),rs.getString("discussroom_status"),rs.getString("studyroom_status"));
						String userDept=rs.getString("user_department");
						String userStatus=rs.getString("discussroom_status");
						String studyroomStatus=rs.getString("studyroom_status");
						loginChoose.frame1.setVisible(true);
						
						
					}else {
						JOptionPane.showMessageDialog(null,"帳號或密碼錯誤，請再試一次！");
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(loginbtn, e1);
				}
			}
		});
		
		loginbtn.setBounds(165, 187, 83, 29);
		frame.getContentPane().add(loginbtn);
		
		JLabel lblNewLabel = new JLabel("使用者登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(217, 33, 94, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setBounds(186, 92, 46, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		userid = new JTextField();
		userid.setBounds(238, 89, 96, 21);
		frame.getContentPane().add(userid);
		userid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密碼：");
		lblNewLabel_2.setBounds(186, 132, 46, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		userpassword = new JTextField();
		userpassword.setBounds(238, 129, 96, 21);
		frame.getContentPane().add(userpassword);
		userpassword.setColumns(10);
		
		
		JButton resetbtn = new JButton("關閉視窗");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		resetbtn.setBounds(279, 187, 94, 29);
		frame.getContentPane().add(resetbtn);
		
		JButton btnNewButton = new JButton("管理者登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Manager_login M_1=new Manager_login();
				M_1.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(217, 243, 103, 29);
		frame.getContentPane().add(btnNewButton);
	}
}
		