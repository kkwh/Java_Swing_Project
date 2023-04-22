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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import prj.java.infomng.controller.StudentInfoManageDaoImpl;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.design.JTextFieldLimit;
import prj.java.infomng.model.StudentInfoManage;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class StudentInfoCreateFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private StudentInfoList app;
	private JPanel Insertpanel;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textBirth;
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
	private StudentInfoManageDaoImpl dao = StudentInfoManageDaoImpl.getInstance();
	private JComboBox cbMajor;
	
	/**
	 * Launch the application.
	 */
	public static void showStudentInfoCreateFrame(Component parent, StudentInfoList app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoCreateFrame frame = new StudentInfoCreateFrame(parent, app);
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
	public StudentInfoCreateFrame(Component parent, StudentInfoList app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	private void initialize() {
		setTitle("학생 정보관리프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (app != null) {
            x = app.getX();
            y = app.getY();
        }
		
		setBounds(x, y, 874, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Insertpanel = new ImagePanel(new ImageIcon("C:/Users/82104/git/Java_Swing_Project2/StudentInfoManage/images/roundedLine.png").getImage());
		Insertpanel.setBackground(SystemColor.activeCaption);
		Insertpanel.setBounds(0, 0, 858, 575);
		contentPane.add(Insertpanel);
		Insertpanel.setLayout(null);
		
		lblStudentMng = new JLabel("학생 정보관리프로그램");
		lblStudentMng.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentMng.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentMng.setBounds(276, 10, 342, 39);
		Insertpanel.add(lblStudentMng);
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Dialog", Font.BOLD, 28));
		lblName.setBounds(55, 96, 153, 50);
		Insertpanel.add(lblName);
		
		lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Dialog", Font.BOLD, 28));
		lblGender.setBounds(55, 178, 153, 50);
		Insertpanel.add(lblGender);
		
		lblPhone = new JLabel("연락처");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(55, 258, 153, 50);
		Insertpanel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(55, 342, 153, 50);
		Insertpanel.add(lblEmail);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(432, 96, 153, 50);
		Insertpanel.add(lblBirth);
		
		lblMajor = new JLabel("학과");
		lblMajor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMajor.setFont(new Font("Dialog", Font.BOLD, 28));
		lblMajor.setBounds(432, 178, 153, 50);
		Insertpanel.add(lblMajor);
		
		lblStudentId = new JLabel("학번");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblStudentId.setBounds(432, 258, 153, 50);
		Insertpanel.add(lblStudentId);
		
		lblAvgGradePoint = new JLabel("평균학점");
		lblAvgGradePoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvgGradePoint.setFont(new Font("Dialog", Font.BOLD, 28));
		lblAvgGradePoint.setBounds(432, 342, 153, 50);
		Insertpanel.add(lblAvgGradePoint);
		
		textName = new JTextField();
		textName.setFont(new Font("Dialog", Font.PLAIN, 20));
		textName.setColumns(10);
		textName.setBounds(216, 96, 204, 50);
		Insertpanel.add(textName);
		
		textPhone = new JTextField();
		textPhone.setText("양식) 010-1234-5678");
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(216, 258, 204, 50);
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
            		textPhone.setText("양식) 010-1234-5678");
            	}
            }
        });
		Insertpanel.add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setText("양식) abc@naver.com");
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(216, 342, 204, 50);
		textEmail.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {            	
                textEmail.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textEmail.getText().equals("")) {            		
            		textEmail.setText("양식) abc@naver.com");
            	}
            }
        });
		Insertpanel.add(textEmail);
		
		textBirth = new JTextField();
		textBirth.setText("양식) 19961225");
		textBirth.setFont(new Font("Dialog", Font.PLAIN, 20));
		textBirth.setColumns(10);
		textBirth.setBounds(600, 96, 204, 50);
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
            		textBirth.setText("양식) 19961225");
            	}
            }
        });
		Insertpanel.add(textBirth);
		
		textStudentId = new JTextField();
		textStudentId.setText("양식) 2023510010");
		textStudentId.setFont(new Font("Dialog", Font.PLAIN, 20));
		textStudentId.setColumns(10);
		textStudentId.setBounds(600, 258, 204, 50);
		textStudentId.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textStudentId.setText("");
                textStudentId.setDocument(new JTextFieldLimit(10)); // 입력가능한 글자수를 제한
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textStudentId.getText().equals("")) {            		
            		textStudentId.setDocument(new JTextFieldLimit(16));
            		textStudentId.setText("양식) 2023510010");
            	}
            }
        });
		Insertpanel.add(textStudentId);
		
		textAvgGradePoint = new JTextField();
		textAvgGradePoint.setText("양식) 4.50");
		textAvgGradePoint.setFont(new Font("Dialog", Font.PLAIN, 20));
		textAvgGradePoint.setColumns(10);
		textAvgGradePoint.setBounds(600, 342, 204, 50);
		textAvgGradePoint.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textAvgGradePoint.setText("");
                textAvgGradePoint.setDocument(new JTextFieldLimit(4)); // 입력가능한 글자수를 제한
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textAvgGradePoint.getText().equals("")) {            		
            		textAvgGradePoint.setDocument(new JTextFieldLimit(12));
            		textAvgGradePoint.setText("양식) 4.50");
            	}
            }
        });
		Insertpanel.add(textAvgGradePoint);
		
		cbGender = new JComboBox(new String[] {"남성", "여성"});
		cbGender.setFont(new Font("Dialog", Font.PLAIN, 20));
		cbGender.setBackground(Color.WHITE);
		cbGender.setBounds(213, 178, 207, 50);
		Insertpanel.add(cbGender);
		
		btnSave = new DesignedButton("저장");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = createPreCheckMyInfo();
				if(!result) return;
				
				saveNewStudentInfo();
			}
		});
		btnSave.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnSave.setBounds(323, 485, 97, 50);
		Insertpanel.add(btnSave);
		
		btnCancel = new DesignedButton("닫기");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnCancel.setBounds(469, 485, 97, 50);
		Insertpanel.add(btnCancel);
		
		cbMajor = new JComboBox(new String[] {"건축공학과", "경영학과", "경제학과", "교육공학과", "국어국문학과", "국제무역학과", "글로벌비즈니스학과"
				, "기계공학과", "문화콘텐츠학과", "물리학과", "미디어커뮤니케이션학과", "사학과", "산업공학과", "산업디자인학과", "생물공학과", "수학과", "수학교육과", "영어교육과", "음악교육과", "응용통계학과"
				, "의상디자인학과", "일어교육과", "전기공학과", "전자공학과", "정치외교학과", "중어중문학과", "지리학과", "철학과", "체육교육과", "컴퓨터공학과", "행정학과", "화학과"
				, "화학공학과", "환경공학과"});
		cbMajor.setFont(new Font("Dialog", Font.PLAIN, 20));
		cbMajor.setBackground(Color.WHITE);
		cbMajor.setBounds(597, 178, 207, 50);
		Insertpanel.add(cbMajor);
		StudentInfoCreateFrame.this.setResizable(false); // 크기 조절 X
		
		
		
	}

	private void saveNewStudentInfo() {
		try {
			String name = textName.getText();
			String birth = textBirth.getText();
			String gender = cbGender.getSelectedItem().toString();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			String major = cbMajor.getSelectedItem().toString();
			String majorNum = textStudentId.getText();
			String avg = textAvgGradePoint.getText();
			
			StudentInfoManage studentInfoManage = 
					new StudentInfoManage(0, name, gender, phone, email, birth, major, majorNum, avg);
			dao.create(studentInfoManage);
						
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
			
		}   catch (Exception e) {
			JOptionPane.showMessageDialog(this, "양식에 맞게 다시 입력해주세요.", "알림", JOptionPane.ERROR_MESSAGE);
		}
		
		app.notifyStudentInfoCreate();
		
		dispose();
				
	}
	
	
	private boolean createPreCheckMyInfo() {
		boolean saveCheck = true;

		// 정규식을 이용하여 전화번호 양식에 맞는지 검사합니다.
		if (!textBirth.getText().matches("\\d{8}")) {
			JOptionPane.showMessageDialog(this, "생년월일이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
			saveCheck = false;
		}
		else if (!textPhone.getText().matches("^010-\\d{4}-\\d{4}$")) {
		    JOptionPane.showMessageDialog(this, "연락처가 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
		    saveCheck = false;
		}
		else if (!textEmail.getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
		    JOptionPane.showMessageDialog(this, "이메일이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
		    saveCheck = false;
		}
		else if (!textStudentId.getText().matches("\\d{10}")) {
			JOptionPane.showMessageDialog(this, "학번이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
			saveCheck = false;
		}
		else if (!textAvgGradePoint.getText().matches("\\d\\.\\d{1,2}")) {
			JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
			saveCheck = false;
		}
		
		
		return saveCheck;
	}
}
