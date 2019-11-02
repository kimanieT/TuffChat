package tuffChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Main {
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dos;
		
	private JFrame frame;
	private JTextField txtKeyBoard;
	private JLabel lblFriendFullName;
	private JLabel lblFriendChatName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 421);
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

		
		JPanel pnlBackground = new JPanel();
		pnlBackground.setBounds(0, 0, 735, 382);
		frame.getContentPane().add(pnlBackground);
		pnlBackground.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(204, 0, 204));
		pnlMenu.setBounds(0, 0, 172, 382);
		pnlMenu.setLayout(null);
		pnlBackground.add(pnlMenu);
				
		JPanel pnlLogOutMenu = new JPanel();
		pnlLogOutMenu.setBackground(new Color(204, 0, 204));
		pnlLogOutMenu.setLayout(null);
		pnlLogOutMenu.setBounds(0, 199, 173, 49);
		pnlMenu.add(pnlLogOutMenu);
		
		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogOut.setBackground(new Color(204, 51, 204));
		lblLogOut.setForeground(new Color(102, 0, 153));
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setBounds(56, 0, 117, 49);
		pnlLogOutMenu.add(lblLogOut);
		
		JLabel lblLogoutIcon = new JLabel("");
		lblLogoutIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogoutIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoutIcon.setIcon(new ImageIcon(Main.class.getResource("/images/LogoutIcon.png")));
		lblLogoutIcon.setBounds(0, 0, 56, 49);
		pnlLogOutMenu.add(lblLogoutIcon);
		
		
		JPanel pnlFriend = new JPanel();
		pnlFriend.setLocation(171, 0);
		pnlFriend.setSize(564, 382);
		pnlFriend.setLayout(null);
		pnlBackground.add(pnlFriend);
		
		JPanel lblFriendAccount = new JPanel();
		lblFriendAccount.setBounds(0, 0, 563, 68);
		pnlFriend.add(lblFriendAccount);
		lblFriendAccount.setLayout(null);
		
		lblFriendFullName = new JLabel("Full Name");
		lblFriendFullName.setBounds(120, 7, 200, 26);
		lblFriendAccount.add(lblFriendFullName);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(0, 51, 51));
		lblStatus.setBounds(120, 39, 200, 26);
		lblFriendAccount.add(lblStatus);
		
				
		JPanel pnlOption = new JPanel();
		JPanel pnlChat = new JPanel();
		
		pnlOption.setVisible(false);
		
				
		JLabel lblFriendProfilePicture = new JLabel("");
		lblFriendProfilePicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriendProfilePicture.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFriendProfilePicture.setIcon(new ImageIcon(Main.class.getResource("/images/ProfileIcon.png")));
		lblFriendProfilePicture.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlFriend.setVisible(false);
				
				pnlChat.setBounds(172, 0, 563, 382);
				pnlBackground.add(pnlChat);
				pnlChat.setLayout(null);
				pnlChat.setVisible(true);
								
				JPanel pnlChatHeader = new JPanel();
				pnlChatHeader.setBounds(0, 0, 563, 63);
				pnlChat.add(pnlChatHeader);
				pnlChatHeader.setLayout(null);
				
				
				JLabel lblChatStatus = new JLabel("Status");
				lblChatStatus.setBounds(122, 28, 119, 22);
				pnlChatHeader.add(lblChatStatus);
				
				lblFriendChatName = new JLabel("Full name");
				lblFriendChatName.setBounds(122, 0, 119, 22);
				pnlChatHeader.add(lblFriendChatName);
				
				JPanel pnlChatWallpaper = new JPanel();
				pnlChatWallpaper.setBounds(0, 62, 561, 265);
				pnlChat.add(pnlChatWallpaper);
				pnlChatWallpaper.setLayout(null);
				
				JTextArea txtMessage = new JTextArea();
				txtMessage.setBounds(0, 0, 561, 265);
				pnlChatWallpaper.add(txtMessage);
				
				//LGBT
				//BigSix
				
				String msgin = "";
				
				try{
					s = new Socket("127.0.0.1",1201);
					din = new DataInputStream(s.getInputStream());
					dos = new DataOutputStream(s.getOutputStream());
																		
					System.out.println("connected");
					BufferedReader br = new BufferedReader(new InputStreamReader(din));
					
					while ((msgin = br.readLine()) != null) {
					//while (!msgin.equals("exit")){
						msgin = din.readUTF();
						txtMessage.setText(txtMessage.getText().trim()+"\n Server "+msgin);
					}			
					System.out.println("working");
					
				}
				catch(Exception e1){
					System.out.println("not working");
				}
				
				JPanel pnlChatFooter = new JPanel();
				pnlChatFooter.setBounds(0, 325, 563, 57);
				pnlChat.add(pnlChatFooter);
				pnlChatFooter.setLayout(null);
				
				txtKeyBoard = new JTextField();
				txtKeyBoard.setBounds(74, 11, 421, 34);
				pnlChatFooter.add(txtKeyBoard);
				txtKeyBoard.setColumns(10);
				txtKeyBoard.isEnabled();

				JLabel lblMicIcon = new JLabel("");
				lblMicIcon.setIcon(new ImageIcon(Main.class.getResource("/images/micIcon.png")));
				lblMicIcon.setHorizontalAlignment(SwingConstants.CENTER);
				lblMicIcon.setBounds(0, 0, 64, 57);
				pnlChatFooter.add(lblMicIcon);
				
				JLabel lblSend = new JLabel("");
				lblSend.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try{
							String msgout = "";
							msgout = txtKeyBoard.getText().trim();
							dos.writeUTF(msgout);
						}
						catch(Exception ex){
							System.out.print(ex.getMessage());
							System.out.print(ex.getStackTrace());
						}
					}
				});
				lblSend.setIcon(new ImageIcon(Main.class.getResource("/images/sendIcon.png")));
				lblSend.setHorizontalTextPosition(SwingConstants.CENTER);
				lblSend.setHorizontalAlignment(SwingConstants.CENTER);
				lblSend.setBounds(502, 0, 61, 57);
				pnlChatFooter.add(lblSend);
				
				JLabel lblProfilePicture = new JLabel("");
				lblProfilePicture.setHorizontalTextPosition(SwingConstants.CENTER);
				lblProfilePicture.setHorizontalAlignment(SwingConstants.CENTER);
				lblProfilePicture.setIcon(new ImageIcon(Main.class.getResource("/images/ProfileIcon.png")));
				lblProfilePicture.setBounds(0, 0, 104, 63);
				pnlChatHeader.add(lblProfilePicture);

				pnlChat.repaint();
				pnlChat.revalidate();


			}
		});
		lblFriendProfilePicture.setBounds(0, 0, 103, 65);
		lblFriendAccount.add(lblFriendProfilePicture);
				
		JPanel pnlOptionMenu = new JPanel();
		pnlOptionMenu.setBackground(new Color(204, 0, 204));
		pnlOptionMenu.setBounds(0, 139, 173, 49);
		pnlMenu.add(pnlOptionMenu);
		pnlOptionMenu.setLayout(null);
		
		JLabel lblOption = new JLabel("Options");
		lblOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOption.setBackground(new Color(204, 51, 204));
		lblOption.setForeground(new Color(102, 0, 153));
		lblOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlFriend.setVisible(false);
				pnlChat.setVisible(false);	
				
				pnlOption.setBounds(172, 0, 563, 382);
				pnlBackground.add(pnlOption);
				pnlOption.setLayout(null);
				pnlOption.setVisible(true);
								
				JLabel lblChangeAccountDetails = new JLabel("Change Account Deatails");
				lblChangeAccountDetails.setHorizontalAlignment(SwingConstants.CENTER);
				lblChangeAccountDetails.setBounds(0, 266, 563, 35);
				pnlOption.add(lblChangeAccountDetails);
				
				JLabel lblChangeProfilePic = new JLabel("Change Profile Picture");
				lblChangeProfilePic.setHorizontalAlignment(SwingConstants.CENTER);
				lblChangeProfilePic.setBounds(0, 171, 563, 35);
				pnlOption.add(lblChangeProfilePic);
				
				JLabel lblChangeChatWallpaper = new JLabel("Change Chat Wallpaper");
				lblChangeChatWallpaper.setHorizontalAlignment(SwingConstants.CENTER);
				lblChangeChatWallpaper.setBounds(0, 217, 563, 35);
				pnlOption.add(lblChangeChatWallpaper);
				
				JLabel lblDeleteAccount = new JLabel("Delete Account");
				lblDeleteAccount.setHorizontalAlignment(SwingConstants.CENTER);
				lblDeleteAccount.setBounds(0, 312, 563, 35);
				pnlOption.add(lblDeleteAccount);
				
				JPanel pnlTitle = new JPanel();
				pnlTitle.setBounds(0, 0, 563, 44);
				pnlOption.add(pnlTitle);
				pnlTitle.setLayout(null);
				
				JLabel lblTitle = new JLabel("Options");
				lblTitle.setBounds(0, -11, 563, 61);
				pnlTitle.add(lblTitle);
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblAddFriend = new JLabel("Add Friends");
				lblAddFriend.setHorizontalAlignment(SwingConstants.CENTER);
				lblAddFriend.setBounds(0, 118, 563, 35);
				pnlOption.add(lblAddFriend);

				pnlOption.repaint();
				pnlOption.revalidate();
				;
				
			}
		});
		lblOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblOption.setBounds(57, 0, 116, 49);
		pnlOptionMenu.add(lblOption);
		
		JLabel lblOptionIcon = new JLabel("");
		lblOptionIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOptionIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptionIcon.setIcon(new ImageIcon(Main.class.getResource("/images/OptionIcon.png")));
		lblOptionIcon.setBounds(0, 0, 57, 49);
		pnlOptionMenu.add(lblOptionIcon);
		
		JPanel pnlFriendMenu = new JPanel();
		pnlFriendMenu.setBackground(new Color(204, 0, 204));
		pnlFriendMenu.setBounds(0, 73, 173, 55);
		pnlMenu.add(pnlFriendMenu);
		pnlFriendMenu.setLayout(null);
		
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFriends.setBackground(new Color(204, 51, 204));
		lblFriends.setForeground(new Color(102, 0, 153));
		lblFriends.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlOption.setVisible(false);
				pnlFriend.setVisible(true);
				pnlFriend.repaint();
				pnlFriend.validate();
			}
		});
		lblFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriends.setBounds(56, 0, 117, 55);
		pnlFriendMenu.add(lblFriends);
		
		JLabel lblFriendIcon = new JLabel("");
		lblFriendIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFriendIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriendIcon.setIcon(new ImageIcon(Main.class.getResource("/images/friendIcon.png")));
		lblFriendIcon.setBounds(0, 0, 56, 55);
		pnlFriendMenu.add(lblFriendIcon);
				
		
	}
}
