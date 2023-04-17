package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.controller.JoinMemberDaoImpl;
import prj.java.infomng.model.JoinMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {
	
	JoinMemberDaoImpl dao = JoinMemberDaoImpl.getInstance();
	
	private boolean idCheckBL;
	private JPanel contentPane;
	private Component parent;
	private JPanel panel;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblPw;
	private JLabel lblId;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textId;
	private JTextField textPw;
	private JTextField textCheckPw;
	private JTextField textPhone;
	private JButton btnCheckId;
	private JTextField textEmail;
	private JLabel lblCheckPw;
	private JButton btnJoin;
	private JTextField textBirth;
	private JLabel lblBirth;
	private JLabel lblJoin;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void showSignUpFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame frame = new SignUpFrame(parent);
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
	public SignUpFrame(Component parent) {
		this.parent = parent;
		initialize();
	}

	private void initialize() {		
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
		setBounds(x, y, 484, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 0, 468, 536);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 28));
		lblName.setBounds(12, 98, 124, 43);
		panel.add(lblName);
		
		lblId = new JLabel("아이디");
		lblId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblId.setBounds(12, 151, 124, 43);
		panel.add(lblId);
		
		lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPw.setBounds(12, 256, 163, 43);
		panel.add(lblPw);
		
		lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(12, 415, 124, 43);
		panel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(12, 468, 124, 43);
		panel.add(lblEmail);
		
		textName = new JTextField();
		textName.setFont(new Font("Dialog", Font.PLAIN, 18));
		textName.setBounds(187, 98, 269, 43);
		panel.add(textName);
		textName.setColumns(10);
		
		textId = new JTextField();
		textId.setFont(new Font("Dialog", Font.PLAIN, 18));
		textId.setColumns(10);
		textId.setBounds(187, 151, 269, 43);
		panel.add(textId);
		
		textPw = new JTextField();
		textPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textPw.setColumns(10);
		textPw.setBounds(187, 256, 269, 43);
		panel.add(textPw);
		
		textCheckPw = new JTextField();
		textCheckPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textCheckPw.setColumns(10);
		textCheckPw.setBounds(187, 309, 269, 43);
		panel.add(textCheckPw);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(187, 415, 269, 43);
		panel.add(textPhone);
		
		btnCheckId = new JButton("아이디 중복확인");
		btnCheckId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idCheckBL = dao.idCheck(textId.getText());
				
				if(textId.getText().equals("")) {
					JOptionPane.showMessageDialog(SignUpFrame.this, "아이디를 입력해주세요.");
					return;
				}
				
				if(idCheckBL) {
					JOptionPane.showMessageDialog(SignUpFrame.this, "사용가능한 아이디입니다.");
				} else {
					JOptionPane.showMessageDialog(SignUpFrame.this, "이미 사용중이거나 탈퇴한 아이디입니다.");
				}
			}
		});
		btnCheckId.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCheckId.setBounds(187, 204, 269, 42);
		panel.add(btnCheckId);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(187, 468, 269, 43);
		panel.add(textEmail);
		
		lblCheckPw = new JLabel("비밀번호 확인");
		lblCheckPw.setFont(new Font("Dialog", Font.BOLD, 24));
		lblCheckPw.setBounds(12, 309, 163, 43);
		panel.add(lblCheckPw);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(12, 362, 124, 43);
		panel.add(lblBirth);
		
		textBirth = new JTextField();
		textBirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		textBirth.setColumns(10);
		textBirth.setBounds(187, 362, 269, 43);
		panel.add(textBirth);
		
		lblJoin = new JLabel("회원가입");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setFont(new Font("Dialog", Font.BOLD, 32));
		lblJoin.setBounds(98, 10, 255, 43);
		panel.add(lblJoin);
		
		btnJoin = new JButton("가입");
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUp();
			
		}
			
		});
		btnJoin.setBounds(100, 560, 97, 42);
		contentPane.add(btnJoin);
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 24));
		
		btnCancel = new JButton("취소");
		btnCancel.setBounds(260, 560, 97, 42);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 24));
		
	}

	private void signUp() {
		try {
			String name = textName.getText();
			String id = textId.getText();
			String pw = textPw.getText();
			String birth = textBirth.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			
			JoinMember member = new JoinMember(0, name, id, pw, birth, phone, email);
			if(idCheckBL) {
				dao.memberCreate(member);
				JOptionPane.showMessageDialog(SignUpFrame.this, "회원가입이 완료되었습니다.");
			} else JOptionPane.showMessageDialog(SignUpFrame.this, "양식에 맞게 다시 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
						
		}   catch (Exception e) {
			JOptionPane.showMessageDialog(SignUpFrame.this, "양식에 맞게 다시 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
