package tuffChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoginFrm {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm window = new LoginFrm();
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
	public LoginFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
			UIManager.setLookAndFeel(
				UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 749, 397);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(440, 28, 46, 14);
		panel.add(lblTitle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(321, 119, 94, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(321, 188, 94, 14);
		panel.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(438, 116, 167, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(438, 185, 167, 20);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(278, 274, 89, 23);
		panel.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(418, 274, 89, 23);
		panel.add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(563, 274, 89, 23);
		panel.add(btnExit);
	}
}
