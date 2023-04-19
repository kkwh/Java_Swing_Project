package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.controller.JoinMemberDaoImpl;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.DesignedButton2;
import prj.java.infomng.design.DesignedButton3;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.model.JoinMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPageFrame extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JLabel lblName;
	private JLabel lblNewLabel_7;
	private int cid;
	private JoinMemberDaoImpl daoJoin = JoinMemberDaoImpl.getInstance();
	private JLabel lblId;
	private JLabel lblPw;
	private JLabel lblBirth;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JPasswordField passwordField;
	private JTextField textMyName;
	private JTextField textMyId;
	private JTextField textMybirth;
	private JTextField textMyPhone;
	private JTextField textMyEmail;
	private JButton btnNameUpdate;
	private JButton btnPwUpdate;
	private JButton btnBirthUpdate;
	private JButton btnLogout;
	private JButton btnWithdraw;
	private JButton btnClose;
	private JButton btnEamilUpdate;
	private JButton btnPhoneUpdate;

	/**
	 * Launch the application.
	 */
	public static void showMyPageFrame(Component parent, int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPageFrame frame = new MyPageFrame(parent, cid);
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
	public MyPageFrame(Component parent, int cid) {
		this.parent = parent;
		this.cid = cid;
		
		initialize();
		showMyInfo();
		
	}

	private void showMyInfo() {
		JoinMember member = daoJoin.haveMyInfo(cid);
		textMyName.setText(member.getName());
		textMyId.setText(member.getId());
		passwordField.setText(member.getPw());
		textMybirth.setText(member.getBirth());
		textMyPhone.setText(member.getPhone());
		textMyEmail.setText(member.getEmail());
		
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
		
		lblId = new JLabel("아이디");
		lblId.setFont(new Font("Dialog", Font.BOLD, 28));
		lblId.setBounds(12, 160, 124, 43);
		panel.add(lblId);
		
		lblPw = new JLabel("비밀번호");
		lblPw.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPw.setBounds(12, 220, 124, 43);
		panel.add(lblPw);
		
		lblBirth = new JLabel("생년월일");
		lblBirth.setFont(new Font("Dialog", Font.BOLD, 28));
		lblBirth.setBounds(12, 280, 124, 43);
		panel.add(lblBirth);
		
		lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 28));
		lblPhone.setBounds(12, 340, 124, 43);
		panel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 28));
		lblEmail.setBounds(12, 400, 124, 43);
		panel.add(lblEmail);
		
		lblNewLabel_7 = new JLabel("마이페이지");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblNewLabel_7.setBounds(101, 10, 239, 70);
		panel.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBounds(137, 220, 220, 43);
		passwordField.setEditable(false);
		panel.add(passwordField);
		
		textMyName = new JTextField();
		textMyName.setFont(new Font("Dialog", Font.PLAIN, 18));
		textMyName.setBounds(137, 100, 220, 43);
		panel.add(textMyName);
		textMyName.setColumns(10);
		textMyName.setEditable(false);
		
		textMyId = new JTextField();
		textMyId.setFont(new Font("Dialog", Font.PLAIN, 18));
		textMyId.setColumns(10);
		textMyId.setBounds(137, 160, 220, 43);
		panel.add(textMyId);
		textMyId.setEditable(false);
		
		textMybirth = new JTextField();
		textMybirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		textMybirth.setColumns(10);
		textMybirth.setBounds(137, 280, 220, 43);
		panel.add(textMybirth);
		textMybirth.setEditable(false);
		
		textMyPhone = new JTextField();
		textMyPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
		textMyPhone.setColumns(10);
		textMyPhone.setBounds(137, 340, 220, 43);
		panel.add(textMyPhone);
		textMyPhone.setEditable(false);
		
		textMyEmail = new JTextField();
		textMyEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		textMyEmail.setColumns(10);
		textMyEmail.setBounds(137, 400, 220, 43);
		panel.add(textMyEmail);
		textMyEmail.setEditable(false);
		
		btnClose = new DesignedButton("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.BOLD, 24));
		btnClose.setBounds(353, 464, 97, 43);
		panel.add(btnClose);
		
		btnWithdraw = new DesignedButton2("회원탈퇴");
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				withdrawMember();
			
			}
		});
		btnWithdraw.setFont(new Font("Dialog", Font.BOLD, 20));
		btnWithdraw.setBounds(12, 25, 97, 43);
		panel.add(btnWithdraw);
		
		btnLogout = new DesignedButton2("로그아웃");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				((Window) parent).dispose();
				StudentInfoManageMain.main(null);
			}
		});
		btnLogout.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogout.setBounds(353, 25, 97, 43);
		panel.add(btnLogout);
		
		btnNameUpdate = new DesignedButton3("수정");
		btnNameUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNameUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNameUpdate.setBounds(369, 100, 81, 43);
		panel.add(btnNameUpdate);
		
		btnPwUpdate = new DesignedButton3("수정");
		btnPwUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPwUpdate.setBounds(369, 220, 81, 43);
		panel.add(btnPwUpdate);
		
		btnBirthUpdate = new DesignedButton3("수정");
		btnBirthUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBirthUpdate.setBounds(369, 280, 81, 43);
		panel.add(btnBirthUpdate);
		
		btnPhoneUpdate = new DesignedButton3("수정");
		btnPhoneUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPhoneUpdate.setBounds(369, 340, 81, 43);
		panel.add(btnPhoneUpdate);
		
		btnEamilUpdate = new DesignedButton3("수정");
		btnEamilUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		btnEamilUpdate.setBounds(369, 400, 81, 43);
		panel.add(btnEamilUpdate);
		MyPageFrame.this.setResizable(false);
		
	}

	private void withdrawMember() {
		int confirm = JOptionPane.showConfirmDialog(MyPageFrame.this, "정말로 계정을 탈퇴하시겠습니까?", "회원탈퇴",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(confirm == JOptionPane.YES_OPTION) {
			String deletePw = JOptionPane.showInputDialog(MyPageFrame.this, "비밀번호를 입력해주세요.",
					"회원탈퇴", JOptionPane.INFORMATION_MESSAGE);
			if(deletePw.equals(daoJoin.haveMyInfo(cid).getPw())) {
				daoJoin.withdrawMember(cid);
				JOptionPane.showMessageDialog(MyPageFrame.this, "회원탈퇴가 완료되었습니다.", "회원탈퇴 완료", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				((Window) parent).dispose();
				StudentInfoManageMain.main(null);
			} else if(deletePw == null) {
				return;
			} else {
				JOptionPane.showMessageDialog(MyPageFrame.this, "비밀번호가 일치하지 않습니다.", "회원탈퇴 실패", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}


	}
}
