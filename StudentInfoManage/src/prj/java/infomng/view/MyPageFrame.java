package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.design.ImagePanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MyPageFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JLabel lblName;
	private JLabel lblMyName;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void showMyPageFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageFrame frame = new MyPageFrame(parent);
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
	public MyPageFrame(Component parent) {
		this.parent = parent;
		
		initialize();
	}

	private void initialize() {
		setTitle("마이페이지");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
        
		setBounds(x, y, 478, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new ImagePanel(new ImageIcon("C:/Users/ITWILL/git/Java_Swing_Project/StudentInfoManage/images/mypage.png").getImage());
		panel.setBounds(0, 0, 462, 528);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 28));
		lblName.setBounds(12, 100, 124, 43);
		panel.add(lblName);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblId.setBounds(12, 160, 124, 43);
		panel.add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPw.setBounds(12, 220, 124, 43);
		panel.add(lblPw);
		
		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(12, 280, 124, 43);
		panel.add(lblBirth);
		
		JLabel lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(12, 340, 124, 43);
		panel.add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(12, 400, 124, 43);
		panel.add(lblEmail);
		
		lblMyName = new JLabel("");
		lblMyName.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyName.setBounds(187, 100, 263, 43);
		panel.add(lblMyName);
		
		JLabel lblMyId = new JLabel("");
		lblMyId.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyId.setBounds(187, 160, 263, 43);
		panel.add(lblMyId);
		
		JLabel lblMyPw = new JLabel("");
		lblMyPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyPw.setBounds(187, 220, 263, 43);
		panel.add(lblMyPw);
		
		JLabel lblNewLabel_6_3 = new JLabel("");
		lblNewLabel_6_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_6_3.setBounds(187, 240, 263, 43);
		panel.add(lblNewLabel_6_3);
		
		JLabel lblMyBirth = new JLabel("");
		lblMyBirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyBirth.setBounds(187, 280, 263, 43);
		panel.add(lblMyBirth);
		
		JLabel lblMyPhone = new JLabel("");
		lblMyPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyPhone.setBounds(187, 340, 263, 43);
		panel.add(lblMyPhone);
		
		lblNewLabel_7 = new JLabel("마이페이지");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblNewLabel_7.setBounds(101, 10, 239, 70);
		panel.add(lblNewLabel_7);
		
		JLabel lblMyEmail = new JLabel("");
		lblMyEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblMyEmail.setBounds(187, 400, 263, 43);
		panel.add(lblMyEmail);
		
	}
}
