package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.controller.JoinMemberDaoImpl;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.design.JTextFieldLimit;
import prj.java.infomng.design.RegexTextField;
import prj.java.infomng.model.JoinMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class SignUpFrame extends JFrame {
	
	private JoinMemberDaoImpl dao = JoinMemberDaoImpl.getInstance();
	
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
	private JTextField textPhone;
	private JButton btnCheckId;
	private JTextField textEmail;
	private JLabel lblCheckPw;
	private JButton btnJoin;
	private JTextField textBirth;
	private JLabel lblBirth;
	private JLabel lblJoin;
	private JButton btnCancel;
	private JPasswordField pwField;
	private JPasswordField pwCheckField;
	private JLabel lblPwTrue;
	private JLabel lblPwFalse;

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
		
		panel =  new ImagePanel(new ImageIcon("C:/Users/82104/git/Java_Swing_Project2/StudentInfoManage/images/signupbg2.png").getImage());
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
		
		RegexTextField phoneField = new RegexTextField("^010-\\d{4}-\\d{4}$");
		textPhone = new JTextField();
		textPhone.setText("예시) 010-1234-5678");
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(187, 415, 269, 43);
		textPhone.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textPhone.setText("");
                textPhone.setDocument(new JTextFieldLimit(13)); // 입력가능한 글자수를 제한
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textPhone.getText().equals("")) {            		
            		textPhone.setDocument(new JTextFieldLimit(18));
            		textPhone.setText("예시) 010-1234-5678");
            	}
            }
        });
		panel.add(textPhone);
		
		btnCheckId = new DesignedButton("아이디 중복확인");
		btnCheckId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idCheckBL = dao.idCheck(textId.getText());
				
				if(textId.getText().equals("")) {
					JOptionPane.showMessageDialog(SignUpFrame.this, "아이디를 입력해주세요.");
					return;
				}
				
				if(idCheckBL) {
					JOptionPane.showMessageDialog(SignUpFrame.this, "사용가능한 아이디입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(SignUpFrame.this, "이미 사용중인 아이디입니다.", "알림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCheckId.setFont(new Font("Dialog", Font.BOLD, 18));
		btnCheckId.setBounds(187, 204, 269, 42);
		panel.add(btnCheckId);
		
		textEmail = new JTextField();
		textEmail.setText("예시) abc@naver.com");
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(187, 468, 269, 43);
		textEmail.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textEmail.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textEmail.getText().equals("")) {            		
            		textEmail.setText("예시) abc@naver.com");
            	}
            }
        });
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
		textBirth.setText("예시) 19961225");
		textBirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		textBirth.setColumns(10);
		textBirth.setBounds(187, 362, 269, 43);
		textBirth.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textBirth.setText("");
                textBirth.setDocument(new JTextFieldLimit(8)); // 입력가능한 글자수를 제한
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textBirth.getText().equals("")) {            		
            		textBirth.setDocument(new JTextFieldLimit(12));
            		textBirth.setText("예시) 19961225");
            	}
            }
        });
		panel.add(textBirth);
		
		lblJoin = new JLabel("회원가입");
		lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoin.setFont(new Font("Dialog", Font.BOLD, 36));
		lblJoin.setBounds(105, 20, 255, 43);
		panel.add(lblJoin);
		
		pwField = new JPasswordField();
		pwField.setFont(new Font("Dialog", Font.PLAIN, 18));
		pwField.setBounds(187, 256, 269, 43);
		pwField.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) { // 비밀번호, 비밀번호 확인 일치 / 불일치 여부 체크 
            	if(new String(pwField.getPassword()).equals(new String(pwCheckField.getPassword()))) {
            		lblPwFalse.setVisible(false);
            		lblPwTrue.setVisible(true);
            	} else {
            		lblPwTrue.setVisible(false);
					lblPwFalse.setVisible(true);
				}
            }
        });
		panel.add(pwField);
		
		pwCheckField = new JPasswordField();
		pwCheckField.setFont(new Font("Dialog", Font.PLAIN, 18));
		pwCheckField.setBounds(187, 309, 269, 43);
		pwCheckField.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) { // 비밀번호, 비밀번호 확인 일치 / 불일치 여부 체크 
            	if(new String(pwField.getPassword()).equals(new String(pwCheckField.getPassword()))) {
            		lblPwFalse.setVisible(false);
            		lblPwTrue.setVisible(true);
            	} else {
            		lblPwTrue.setVisible(false);
					lblPwFalse.setVisible(true);
				}
            }
        });
		panel.add(pwCheckField);
		
		lblPwTrue = new JLabel("비밀번호 일치");
		lblPwTrue.setForeground(Color.BLUE);
		lblPwTrue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPwTrue.setBounds(12, 204, 163, 42);
		lblPwTrue.setVisible(false);
		panel.add(lblPwTrue);
		
		lblPwFalse = new JLabel("비밀번호 불일치");
		lblPwFalse.setForeground(Color.RED);
		lblPwFalse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPwFalse.setBounds(12, 204, 163, 42);
		lblPwFalse.setVisible(false);
		panel.add(lblPwFalse);
		
		btnJoin = new DesignedButton("가입");
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = signUpPreCheckMyInfo();
				if(!result) return;
				signUp();
			
		}
			
		});
		btnJoin.setBounds(100, 560, 97, 42);
		contentPane.add(btnJoin);
		btnJoin.setFont(new Font("Dialog", Font.BOLD, 24));
		
		btnCancel = new DesignedButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(260, 560, 97, 42);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 24));
		SignUpFrame.this.setResizable(false); // 크기 조절 X
		
	}

	private void signUp() {
		try {
			
//			if(!(new String(pwField.getPassword()).equals(new String(pwCheckField.getPassword())))) {
//				JOptionPane.showMessageDialog(SignUpFrame.this, "비밀번호가 일치하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
//				lblPwFalse.setVisible(true);
//				return;
//			}
			
			String name = textName.getText();
			String id = textId.getText();
			String pw = new String(pwField.getPassword());
			String birth = textBirth.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			
			JoinMember member = new JoinMember(0, name, id, pw, birth, phone, email);
			if(idCheckBL) {
				dao.memberCreate(member);
				JOptionPane.showMessageDialog(SignUpFrame.this, "회원가입이 완료되었습니다.");
				dispose();
				
			} else JOptionPane.showMessageDialog(SignUpFrame.this, "양식에 맞게 다시 입력해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
						
		}   catch (Exception e) {
			JOptionPane.showMessageDialog(SignUpFrame.this, "양식에 맞게 다시 입력해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private boolean signUpPreCheckMyInfo() {
		boolean signCheck = true;
		
		if(!(new String(pwField.getPassword()).equals(new String(pwCheckField.getPassword())))) {
			JOptionPane.showMessageDialog(SignUpFrame.this, "비밀번호가 일치하지 않습니다.", "에러", JOptionPane.ERROR_MESSAGE);
			lblPwFalse.setVisible(true);
			signCheck = false;		
		}
		// 정규식을 이용하여 전화번호 양식에 맞는지 검사합니다.
		else if (!textBirth.getText().matches("\\d{8}")) {
		    JOptionPane.showMessageDialog(SignUpFrame.this, "생년월일이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
		    signCheck = false;
		}
		else if (!textPhone.getText().matches("^010-\\d{4}-\\d{4}$")) {
		    JOptionPane.showMessageDialog(SignUpFrame.this, "휴대전화 번호가 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
		    signCheck = false;
		}
		else if (!textEmail.getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
		    JOptionPane.showMessageDialog(SignUpFrame.this, "이메일이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
		    signCheck = false;
		}
		
		return signCheck;
	}
}
