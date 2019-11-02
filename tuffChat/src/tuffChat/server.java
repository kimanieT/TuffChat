package tuffChat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends JFrame {
	
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dos;
		
	private JPanel contentPane;
	private JTextField txtKeyBoard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server frame = new server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtMessage = new JTextArea();
		txtMessage.setBounds(0, 0, 434, 224);
		panel.add(txtMessage);
		
		txtKeyBoard = new JTextField();
		txtKeyBoard.setBounds(0, 235, 313, 20);
		panel.add(txtKeyBoard);
		txtKeyBoard.setColumns(10);
		
		String msgin = "";
		try{
			ss = new ServerSocket(1201);
			s = ss.accept();
			System.out.println("connected");
			           
			din = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(din));
			while ((msgin = br.readLine()) != null) {			
			//while(!msgin.equals("exit")){
				msgin = din.readUTF();
				txtMessage.setText(txtMessage.getText().trim()+"\n "+msgin);
			}	
		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}	
		
		JButton btnSend = new JButton("New button");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String msg = "";
					msg = txtKeyBoard.getText().trim();
					dos.writeUTF(msg);
					
				}
				catch(Exception ex){
					
				}
			}
		});
		btnSend.setBounds(335, 234, 89, 23);
		panel.add(btnSend);
	}
}
