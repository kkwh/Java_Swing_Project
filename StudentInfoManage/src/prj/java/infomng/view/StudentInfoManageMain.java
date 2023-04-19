package prj.java.infomng.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import prj.java.infomng.controller.JoinMemberDaoImpl;
import prj.java.infomng.controller.StudentInfoManageDaoImpl;
import prj.java.infomng.model.StudentInfoManage;
import prj.java.infomng.design.*;

import java.awt.SystemColor;

public class StudentInfoManageMain {

	private JFrame frame;
	private JLabel lblLogin;
	private JTextField textId;
	private JPasswordField textPw;
	private JLabel lblId;
	private JLabel lblPw;
	private JButton btnLogin;
	private ImagePanel LoginPanel;
	private DesignedButton designedButton;
	private JLabel lblStudentMng;
	private JPanel Mainpanel;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblBirth;
	private JLabel lblMajor;
	private JLabel lblStudentId;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textBirth;
	private JTextField textMajor;
	private JTextField textStudentId;
	private JTextField textAvgGradePoint;
	private JComboBox cbGender;
	private JButton btnSave;
	private JButton btnClose;
	private JLabel lblAvgGradePoint;
	private final StudentInfoManageDaoImpl dao = StudentInfoManageDaoImpl.getInstance();
	private final JoinMemberDaoImpl daoJoin = JoinMemberDaoImpl.getInstance();
	private JButton btnGuest;
	private JButton btnSignUp;
	private DesignedButton2 btnList;
	private DesignedButton2 btnMyPage;
	private int loginNum = -1; // cid, guest는 -1.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoManageMain window = new StudentInfoManageMain();
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
	public StudentInfoManageMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setTitle("학생 정보관리프로그램");
		
		Mainpanel = new ImagePanel(new ImageIcon("C:/Users/ITWILL/git/Java_Swing_Project/StudentInfoManage/images/roundedLine.png").getImage());
		Mainpanel.setBackground(SystemColor.activeCaption);
		Mainpanel.setForeground(new Color(255, 255, 255));
		Mainpanel.setBounds(0, 0, 858, 575);
		frame.getContentPane().add(Mainpanel);
		Mainpanel.setLayout(null);
		Mainpanel.setVisible(false);
		
		lblStudentMng = new JLabel("학생 정보관리프로그램");
		lblStudentMng.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentMng.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentMng.setBounds(276, 10, 342, 39);
		Mainpanel.add(lblStudentMng);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 28));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(55, 96, 153, 50);
		Mainpanel.add(lblName);
		
		lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 28));
		lblGender.setBounds(55, 178, 153, 50);
		Mainpanel.add(lblGender);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(55, 258, 153, 50);
		Mainpanel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(55, 342, 153, 50);
		Mainpanel.add(lblEmail);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(432, 96, 153, 50);
		Mainpanel.add(lblBirth);
		
		lblMajor = new JLabel("학과");
		lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajor.setFont(new Font("Dialog", Font.BOLD, 28));
		lblMajor.setBounds(432, 178, 153, 50);
		Mainpanel.add(lblMajor);
		
		lblStudentId = new JLabel("학번");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentId.setBounds(432, 258, 153, 50);
		Mainpanel.add(lblStudentId);
		
		lblAvgGradePoint = new JLabel("평균학점");
		lblAvgGradePoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvgGradePoint.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAvgGradePoint.setBounds(432, 342, 153, 50);
		Mainpanel.add(lblAvgGradePoint);
		
		textName = new JTextField();
		textName.setFont(new Font("Dialog", Font.PLAIN, 20));
		textName.setBounds(216, 96, 204, 50);
		Mainpanel.add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(216, 258, 204, 50);
		Mainpanel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(216, 342, 204, 50);
		Mainpanel.add(textEmail);
		
		textBirth = new JTextField();
		textBirth.setFont(new Font("Dialog", Font.PLAIN, 20));
		textBirth.setColumns(10);
		textBirth.setBounds(600, 96, 204, 50);
		Mainpanel.add(textBirth);
		
		textMajor = new JTextField();
		textMajor.setFont(new Font("Dialog", Font.PLAIN, 20));
		textMajor.setColumns(10);
		textMajor.setBounds(600, 178, 204, 50);
		Mainpanel.add(textMajor);
		
		textStudentId = new JTextField();
		textStudentId.setFont(new Font("Dialog", Font.PLAIN, 20));
		textStudentId.setColumns(10);
		textStudentId.setBounds(600, 258, 204, 50);
		Mainpanel.add(textStudentId);
		
		textAvgGradePoint = new JTextField();
		textAvgGradePoint.setFont(new Font("Dialog", Font.PLAIN, 20));
		textAvgGradePoint.setColumns(10);
		textAvgGradePoint.setBounds(600, 342, 204, 50);
		Mainpanel.add(textAvgGradePoint);
		
		cbGender = new JComboBox(new String[] {"남성", "여성"});
		cbGender.setEditable(true);
		cbGender.setBackground(Color.WHITE);
		cbGender.setFont(new Font("Dialog", Font.PLAIN, 20));
		cbGender.setBounds(213, 178, 207, 50);
		Mainpanel.add(cbGender);
		
		btnSave = new DesignedButton("저장");
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveNewStudentInfo();
				
				
			}
		});
		btnSave.setBounds(323, 453, 97, 50);
		Mainpanel.add(btnSave);
		
		btnClose = new DesignedButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StudentInfoManageMain.main(null);

			}
		});
		btnClose.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnClose.setBounds(469, 453, 97, 50);
		Mainpanel.add(btnClose);
		
		btnList = new DesignedButton2("목록");
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentInfoList.showStudentInfoFrame(frame, StudentInfoManageMain.this);
				
			}
		});
		btnList.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnList.setBounds(707, 10, 97, 50);
		Mainpanel.add(btnList);
		
		btnMyPage = new DesignedButton2("내정보");
		btnMyPage.setText("내 정보");
		btnMyPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginNum == -1) {
					JOptionPane.showMessageDialog(frame, "Guest는 내 정보를 조회할 수 없습니다.");
					return;
				}
				MyPageFrame.showMyPageFrame(frame, loginNum);
			}
		});
		btnMyPage.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnMyPage.setBounds(55, 10, 97, 50);
		Mainpanel.add(btnMyPage);
		LoginPanel = new ImagePanel(new ImageIcon("C:/Users/ITWILL/git/Java_Swing_Project/StudentInfoManage/images/schedule2.png").getImage());
		LoginPanel.setBounds(0, 0, 858, 575);
		frame.getContentPane().add(LoginPanel);
		LoginPanel.setLayout(null);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(626, 10, 146, 55);
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 32));
		LoginPanel.add(lblLogin);
		
		textId = new JTextField();
		textId.setBounds(626, 75, 220, 34);
		textId.setFont(new Font("Dialog", Font.PLAIN, 24));
		LoginPanel.add(textId);
		textId.setColumns(10);
		
		textPw = new JPasswordField();
		textPw.setBounds(626, 119, 220, 34);
		textPw.setFont(new Font("Dialog", Font.PLAIN, 24));
		LoginPanel.add(textPw);
		
		lblId = new JLabel("ID: ");
		lblId.setBounds(560, 75, 69, 34);
		lblId.setFont(new Font("Dialog", Font.BOLD, 30));
		LoginPanel.add(lblId);
		
		lblPw = new JLabel("PW:");
		lblPw.setBounds(545, 119, 69, 34);
		lblPw.setFont(new Font("Dialog", Font.BOLD, 30));
		LoginPanel.add(lblPw);
		
		btnLogin = new DesignedButton("Login");
		btnLogin.setBounds(744, 163, 102, 34);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(daoJoin.loginCheck(textId.getText(), new String(textPw.getPassword()))) {
					loginNum = daoJoin.loginCheckNum(textId.getText(), new String(textPw.getPassword()));
					JOptionPane.showMessageDialog(frame, "로그인 성공");
					LoginPanel.setVisible(false);
					Mainpanel.setVisible(true);
				} else JOptionPane.showMessageDialog(frame, "ID 또는 패스워드를 확인해주세요.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
	
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.PLAIN, 24));
		LoginPanel.add(btnLogin);
		
		btnGuest = new DesignedButton("Guest");
		btnGuest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(frame, "Guest는 기능이 제한됩니다. Login 하시겠습니까?", "알림", 
							  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (confirm == 0) {
				LoginPanel.setVisible(false);
				Mainpanel.setVisible(true);
				}
			}
		});
		btnGuest.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnGuest.setBounds(626, 163, 112, 34);
		LoginPanel.add(btnGuest);
		
		btnSignUp = new DesignedButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame.showSignUpFrame(frame);
			}
		});
		btnSignUp.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnSignUp.setBounds(626, 207, 220, 34);
		LoginPanel.add(btnSignUp);
		frame.setBounds(100, 100, 874, 614);
		frame.setResizable(false); // 크기 조절 X
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void saveNewStudentInfo() {
		try {
			String name = textName.getText();
			String birth = textBirth.getText();
			String gender = cbGender.getSelectedItem().toString();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			String major = textMajor.getText();
			String majorNum = textStudentId.getText();
			String avg = textAvgGradePoint.getText();
			
			StudentInfoManage studentInfoManage = 
					new StudentInfoManage(0, name, gender, phone, email, birth, major, majorNum, avg);
			dao.create(studentInfoManage);
						
			JOptionPane.showMessageDialog(frame, "저장되었습니다.");
			
		}   catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "양식에 맞게 다시 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}


