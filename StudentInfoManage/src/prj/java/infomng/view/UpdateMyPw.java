package prj.java.infomng.view;

import java.awt.Component;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JPasswordField;
import java.awt.Color;

public class UpdateMyPw extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JPanel panel;
	private int cid;
	private JoinMember member = null;
	private JoinMemberDaoImpl daoJoin = JoinMemberDaoImpl.getInstance();
	private JLabel lblNewLabel;
	private JButton btnConfirm;
	private JButton btnClose;
	private JPasswordField textNowPw;
	private JPasswordField textNewPw;
	private JPasswordField textNewPwCheck;
	private JTextField textNowPwNotice;
	private JTextField textNewPwNotice;
	private JTextField textNewPwCheckNotice;
	private JTextArea textNotice;
	private JLabel lblPwCheckTrue;
	private JLabel lblPwCheckFalse;
	
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
		setTitle("비밀번호 변경");
		
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
		
		textNowPwNotice = new JTextField();
		textNowPwNotice.setText("현재 비밀번호");
		textNowPwNotice.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNowPwNotice.setColumns(10);
		textNowPwNotice.setBounds(12, 201, 290, 43);
		textNowPwNotice.setVisible(true);
		textNowPwNotice.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                textNowPwNotice.setVisible(false);
                textNowPw.setVisible(true);
                textNowPw.requestFocus(); // 커서 자동 활성화
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            	
            }
        });		
		panel.add(textNowPwNotice);
		
		textNewPwCheckNotice = new JTextField();
		textNewPwCheckNotice.setText("새 비밀번호 확인");
		textNewPwCheckNotice.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPwCheckNotice.setColumns(10);
		textNewPwCheckNotice.setBounds(12, 297, 290, 43);
		textNewPwCheckNotice.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                textNewPwCheckNotice.setVisible(false);
                textNewPwCheck.setVisible(true);
                textNewPwCheck.requestFocus(); // 커서 자동 활성화
            }

            @Override
            public void focusLost(FocusEvent e) {
            	
            }
        });
		panel.add(textNewPwCheckNotice);
		
		textNewPwNotice = new JTextField();
		textNewPwNotice.setText("새 비밀번호");
		textNewPwNotice.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPwNotice.setColumns(10);
		textNewPwNotice.setBounds(12, 254, 290, 43);
		textNewPwNotice.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                textNewPwNotice.setVisible(false);
                textNewPw.setVisible(true);
                textNewPw.requestFocus(); // 커서 자동 활성화
            }

            @Override
            public void focusLost(FocusEvent e) {
            	
            }
        });
		panel.add(textNewPwNotice);
		
		textNotice = new JTextArea(String.format("안전한 비밀번호로 %s님의 정보를 보호하세요.", member.getName()));
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
		
		btnConfirm = new DesignedButton("확인");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updatePwOrShowMessage();
			}
		});
		btnConfirm.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnConfirm.setBounds(12, 398, 290, 43);
		panel.add(btnConfirm);
		
		btnClose = new DesignedButton5("취소");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.PLAIN, 24));
		btnClose.setBounds(12, 448, 290, 43);
		panel.add(btnClose);
		
		textNowPw = new JPasswordField();
		textNowPw.setToolTipText("");
		textNowPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNowPw.setBounds(12, 201, 290, 43);
		textNowPw.setVisible(false); // 처음에 비밀번호 텍스트는 안보이게
		textNowPw.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(new String(textNowPw.getPassword()).equals("")) {
            		textNowPw.setVisible(false);
            		textNowPwNotice.setVisible(true);
            	}
            }
        });
		panel.add(textNowPw);
		
		textNewPw = new JPasswordField();
		textNewPw.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPw.setBounds(12, 254, 290, 43);
		textNewPw.setVisible(false);
		textNewPw.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(new String(textNewPw.getPassword()).equals("")) {
            		textNewPw.setVisible(false);
            		textNewPwNotice.setVisible(true);
            	}
            	
            	if(new String(textNewPw.getPassword()).equals(new String(textNewPwCheck.getPassword()))) {
            		lblPwCheckFalse.setVisible(false);
            		lblPwCheckTrue.setVisible(true);
            	} else {
            		lblPwCheckTrue.setVisible(false);
					lblPwCheckFalse.setVisible(true);
				}
            }
        });
		panel.add(textNewPw);
		
		textNewPwCheck = new JPasswordField();
		textNewPwCheck.setFont(new Font("Dialog", Font.PLAIN, 18));
		textNewPwCheck.setBounds(12, 297, 290, 43);
		textNewPwCheck.setVisible(false);
		textNewPwCheck.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(new String(textNewPwCheck.getPassword()).equals("")) {
            		textNewPwCheck.setVisible(false);
            		textNewPwCheckNotice.setVisible(true);
            	}
            	
            	if(new String(textNewPw.getPassword()).equals(new String(textNewPwCheck.getPassword()))) {
            		lblPwCheckFalse.setVisible(false);
            		lblPwCheckTrue.setVisible(true);
            	} else {
            		lblPwCheckTrue.setVisible(false);
					lblPwCheckFalse.setVisible(true);
				}
            }
        });
		panel.add(textNewPwCheck);
		
		lblPwCheckTrue = new JLabel("비밀번호 일치");
		lblPwCheckTrue.setForeground(Color.BLUE);
		lblPwCheckTrue.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPwCheckTrue.setBounds(12, 350, 290, 43);
		lblPwCheckTrue.setVisible(false);
		panel.add(lblPwCheckTrue);
		
		lblPwCheckFalse = new JLabel("비밀번호 불일치");
		lblPwCheckFalse.setForeground(Color.RED);
		lblPwCheckFalse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPwCheckFalse.setBounds(12, 350, 290, 43);
		lblPwCheckFalse.setVisible(false);
		panel.add(lblPwCheckFalse);
		
		UpdateMyPw.this.setResizable(false); // 크기 조절 X
		
	}

	private void updatePwOrShowMessage() {
		if(member.getPw().equals(new String(textNowPw.getPassword()))) {
			if(new String(textNewPw.getPassword()).equals(new String(textNewPwCheck.getPassword()))) {
				if(!(new String(textNowPw.getPassword()).equals(new String(textNewPw.getPassword())))) {
					daoJoin.updateMyPw(cid, new String(textNewPw.getPassword()));
					JOptionPane.showMessageDialog(UpdateMyPw.this, "비밀번호 변경이 완료되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else JOptionPane.showMessageDialog(UpdateMyPw.this, "변경하시려는 비밀번호가 현재 비밀번호와 같습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
			} else JOptionPane.showMessageDialog(UpdateMyPw.this, "변경하시려는 비밀번호가 일치하지 않습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		} else JOptionPane.showMessageDialog(UpdateMyPw.this, "현재 비밀번호가 일치하지 않습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
