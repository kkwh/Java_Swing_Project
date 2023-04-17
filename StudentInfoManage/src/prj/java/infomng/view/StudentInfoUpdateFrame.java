package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import prj.java.infomng.controller.StudentInfoManageDaoImpl;
import prj.java.infomng.model.StudentInfoManage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfoUpdateFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private StudentInfoList app;
	private JPanel Insertpanel;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textBirth;
	private JTextField textMajor;
	private JTextField textStudentId;
	private JTextField textAvgGradePoint;
	private JLabel lblStudentMng;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblBirth;
	private JLabel lblMajor;
	private JLabel lblStudentId;
	private JLabel lblAvgGradePoint;
	private JComboBox cbGender;
	private JButton btnSave;
	private JButton btnCancel;
	private int cid;
	private StudentInfoManageDaoImpl dao = StudentInfoManageDaoImpl.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void showStudentInfoUpdateFrame(Component parent, StudentInfoList app, int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoUpdateFrame frame = new StudentInfoUpdateFrame(parent, app, cid);
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
	public StudentInfoUpdateFrame(Component parent, StudentInfoList app, int cid) {
		this.parent = parent;
		this.app = app;
		this.cid = cid;
		initialize();
		readStudentInfo();
	}

	private void readStudentInfo() {
		StudentInfoManage studentInfo = dao.read(cid);
		textName.setText(studentInfo.getName());
		textPhone.setText(studentInfo.getPhone());
		textEmail.setText(studentInfo.getEmail());
		textBirth.setText(studentInfo.getBirth());
		textMajor.setText(studentInfo.getMajor());
		textStudentId.setText(studentInfo.getstudentId());
		textAvgGradePoint.setText(studentInfo.getAvgGradePoint());
		
	}

	private void initialize() {
		setTitle("학생 정보관리프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
		
		setBounds(x, y, 858, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Insertpanel = new JPanel();
		Insertpanel.setBackground(SystemColor.activeCaption);
		Insertpanel.setBounds(0, 0, 858, 575);
		contentPane.add(Insertpanel);
		Insertpanel.setLayout(null);
		
		lblStudentMng = new JLabel("학생 정보관리프로그램");
		lblStudentMng.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentMng.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentMng.setBounds(266, 23, 342, 39);
		Insertpanel.add(lblStudentMng);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Dialog", Font.BOLD, 28));
		lblName.setBounds(70, 96, 153, 50);
		Insertpanel.add(lblName);
		
		lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 28));
		lblGender.setBounds(70, 178, 153, 50);
		Insertpanel.add(lblGender);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(70, 258, 153, 50);
		Insertpanel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(70, 342, 153, 50);
		Insertpanel.add(lblEmail);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(471, 96, 153, 50);
		Insertpanel.add(lblBirth);
		
		lblMajor = new JLabel("학과");
		lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajor.setFont(new Font("Dialog", Font.BOLD, 28));
		lblMajor.setBounds(471, 178, 153, 50);
		Insertpanel.add(lblMajor);
		
		lblStudentId = new JLabel("학번");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentId.setBounds(471, 258, 153, 50);
		Insertpanel.add(lblStudentId);
		
		lblAvgGradePoint = new JLabel("평균학점");
		lblAvgGradePoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvgGradePoint.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAvgGradePoint.setBounds(471, 342, 153, 50);
		Insertpanel.add(lblAvgGradePoint);
		
		textName = new JTextField();
		textName.setFont(new Font("Dialog", Font.PLAIN, 20));
		textName.setColumns(10);
		textName.setBounds(216, 96, 204, 50);
		Insertpanel.add(textName);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(216, 258, 204, 50);
		Insertpanel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(216, 342, 204, 50);
		Insertpanel.add(textEmail);
		
		textBirth = new JTextField();
		textBirth.setFont(new Font("Dialog", Font.PLAIN, 20));
		textBirth.setColumns(10);
		textBirth.setBounds(620, 96, 204, 50);
		Insertpanel.add(textBirth);
		
		textMajor = new JTextField();
		textMajor.setFont(new Font("Dialog", Font.PLAIN, 20));
		textMajor.setColumns(10);
		textMajor.setBounds(620, 178, 204, 50);
		Insertpanel.add(textMajor);
		
		textStudentId = new JTextField();
		textStudentId.setFont(new Font("Dialog", Font.PLAIN, 20));
		textStudentId.setColumns(10);
		textStudentId.setBounds(620, 258, 204, 50);
		Insertpanel.add(textStudentId);
		
		textAvgGradePoint = new JTextField();
		textAvgGradePoint.setFont(new Font("Dialog", Font.PLAIN, 20));
		textAvgGradePoint.setColumns(10);
		textAvgGradePoint.setBounds(620, 342, 204, 50);
		Insertpanel.add(textAvgGradePoint);
		
		cbGender = new JComboBox(new String[] {"남성", "여성"});
		cbGender.setFont(new Font("Dialog", Font.PLAIN, 20));
		cbGender.setEditable(true);
		cbGender.setBackground(Color.WHITE);
		cbGender.setBounds(213, 178, 207, 50);
		Insertpanel.add(cbGender);
		
		btnSave = new JButton("수정완료");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudentInfo();
			}
		});
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnSave.setBounds(245, 453, 175, 50);
		Insertpanel.add(btnSave);
		
		btnCancel = new JButton("닫기");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnCancel.setBounds(469, 453, 97, 50);
		Insertpanel.add(btnCancel);
		
		
		
	}

	private void updateStudentInfo() {
		String name = textName.getText();
		String birth = textBirth.getText();
		String gender = cbGender.getSelectedItem().toString();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		String major = textMajor.getText();
		String majorNum = textStudentId.getText();
		String avg = textAvgGradePoint.getText();
		
		StudentInfoManage studentInfoManage = 
				new StudentInfoManage(cid, name, gender, phone, email, birth, major, majorNum, avg);
		
		int confirm = JOptionPane.showConfirmDialog(
				StudentInfoUpdateFrame.this,
				"정말로 업데이트 할까요?",
				"업데이트 확인",
				JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			dao.update(studentInfoManage); 
			app.notifyStudentInfoUpdate();
			dispose(); 		
		}
		
	}

//	private void saveNewStudentInfo() {
//		try {
//			String name = textName.getText();
//			String birth = textBirth.getText();
//			String gender = cbGender.getSelectedItem().toString();
//			String phone = textPhone.getText();
//			String email = textEmail.getText();
//			String major = textMajor.getText();
//			String majorNum = textStudentId.getText();
//			String avg = textAvgGradePoint.getText();
//			
//			StudentInfoManage studentInfoManage = 
//					new StudentInfoManage(0, name, gender, phone, email, birth, major, majorNum, avg);
//			dao.create(studentInfoManage);
//						
//			JOptionPane.showMessageDialog(parent, "저장되었습니다.");
//			
//		}   catch (Exception e) {
//			JOptionPane.showMessageDialog(parent, "양식에 맞게 다시 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
//		}
//		
//		
//	}
}
