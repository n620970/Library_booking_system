import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Manager_login {

	public JFrame frame;
	public JTextField Managerid;
	public JTextField Managerpassword;

	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_login window = new Manager_login();
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
	public Manager_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理者登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(186, 40, 88, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(137, 101, 46, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(137, 153, 46, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		Managerid = new JTextField();
		Managerid.setBounds(186, 98, 96, 21);
		frame.getContentPane().add(Managerid);
		Managerid.setColumns(10);
		
		Managerpassword = new JTextField();
		Managerpassword.setBounds(183, 150, 96, 21);
		frame.getContentPane().add(Managerpassword);
		Managerpassword.setColumns(10);
		
		JButton Managerbtn = new JButton("登入");
		Managerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","123456789");
					int uid1=Integer.valueOf( Managerid.getText());
					int upd1=Integer.valueOf( Managerpassword.getText());
					Statement stmt1=con1.createStatement();
					String sql1="select * from library_manager"+" where manager_id="+String.valueOf(uid1)+" and manager_password="+String.valueOf(upd1);
					ResultSet rs1=stmt1.executeQuery(sql1);
					if (rs1.next()) {
						frame.setVisible(false);
						Manager_page mp=new Manager_page();
						mp.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"帳號或密碼錯誤，請再試一次！");
					}
					
				}catch(Exception e2) {
					Manager_login M=new Manager_login();
				}
			}
		});
		Managerbtn.setBounds(119, 202, 85, 23);
		frame.getContentPane().add(Managerbtn);
		
		JButton btnNewButton = new JButton("使用者登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login L=new Login();
				L.main(null);
			}
		});
		btnNewButton.setBounds(242, 202, 112, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
