package prj.java.infomng.view;

import java.awt.Component;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import prj.java.infomng.controller.JoinMemberDaoImpl;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.DesignedButton2;
import prj.java.infomng.design.DesignedButton3;
import prj.java.infomng.design.DesignedButton5;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.model.JoinMember;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateMyPw extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JPanel panel;
	private int cid;
	private JoinMember member = null;
	private JoinMemberDaoImpl daoJoin = JoinMemberDaoImpl.getInstance();
	private JLabel lblNewLabel;
	private JTextField textNowPw;
	private JTextField textNewPw;
	private JTextField textNewPwCheck;
	private JButton btnConfirm;
	private JButton btnClose;
	
	/**
	 * Launch the application.
	 */
	public static void showUpdateMyPw(Component parent, int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMyPw frame = new UpdateMyPw(parent, cid);
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
	public UpdateMyPw(Component parent, int cid) {
		this.parent = parent;
		this.cid = cid;
		this.member = daoJoin.haveMyInfo(cid);
		initialize();
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("개인정보 수정");
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
        
		setBounds(x, y, 330, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new ImagePanel(new ImageIcon("C:/Users/ITWILL/git/Java_Swing_Project/StudentInfoManage/images/updateinfo.png").getImage());
		panel.setBounds(0, 0, 314, 525);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textNotice = new JTextArea(String.format("안전한 비밀번호로 %s님의 정보를 보호하세요.", member.getName()));
		textNotice.setFont(new Font("고도체", Font.PLAIN, 18));
		textNotice.setBounds(12, 72, 290, 82);
		textNotice.setLineWrap(true);
		textNotice.setEditable(false); // 텍스트에 입력 불가
		panel.add(textNotice);
		
		lblNewLabel = new JLabel("비밀번호 변경");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setBounds(12, 25, 290, 38);
		panel.add(lblNewLabel);
		
		textNowPw = new JTextField();
		textNowPw.setText("현재 비밀번호");
		textNowPw.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
	            @Override
	            public void focusGained(FocusEvent e) {
	                textNowPw.setText("");
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	    
	            }
	        });
		 
		textNowPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNowPw.setBounds(12, 201, 290, 43);
		panel.add(textNowPw);
		textNowPw.setColumns(10);
		
		textNewPw = new JTextField();
		textNewPw.setText("새 비밀번호");
		textNewPw.addFocusListener(new FocusListener() { //TextField 안에 클릭하면 지워지는 글씨
	            @Override
	            public void focusGained(FocusEvent e) {
	                textNewPw.setText("");
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // do nothing
	            }
	        });
		textNewPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPw.setColumns(10);
		textNewPw.setBounds(12, 254, 290, 43);
		panel.add(textNewPw);
		
		textNewPwCheck = new JTextField();
		textNewPwCheck.setText("새 비밀번호 확인");
		textNewPwCheck.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
	            @Override
	            public void focusGained(FocusEvent e) {
	                textNewPwCheck.setText("");
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // do nothing
	            }
	        });
		textNewPwCheck.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPwCheck.setColumns(10);
		textNewPwCheck.setBounds(12, 297, 290, 43);
		panel.add(textNewPwCheck);
		
		btnConfirm = new DesignedButton("확인");
		btnConfirm.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnConfirm.setBounds(12, 398, 290, 43);
		panel.add(btnConfirm);
		
		btnClose = new DesignedButton5("취소");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnClose.setBounds(12, 448, 290, 43);
		panel.add(btnClose);
		
	}
}
