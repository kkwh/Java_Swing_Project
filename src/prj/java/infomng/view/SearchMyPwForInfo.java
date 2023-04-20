package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.design.JTextFieldLimit;
import prj.java.infomng.model.JoinMember;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class SearchMyPwForInfo extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JoinMember member = null;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private JLabel lblNotice2;
	private JLabel lblNotice1;
	private JLabel lblPwSearchTitle;
	private JPanel panel;
	private JTextField textPhone;
	private JTextField textEmail;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void showSearchMyPwForInfo(Component parent, JoinMember member) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMyPwForInfo frame = new SearchMyPwForInfo(parent, member);
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
	public SearchMyPwForInfo(Component parent, JoinMember member) {
		this.parent = parent;
		this.member = member;
		initialize();
		
	}

	private void initialize() {
		setTitle("비밀번호 찾기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
        
		setBounds(x, y, 500, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new ImagePanel(new ImageIcon("C:/Users/ITWILL/git/Java_Swing_Project/StudentInfoManage/images/searchpwotherinfo.png").getImage());
		panel.setBounds(0, 0, 484, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPwSearchTitle = new JLabel("비밀번호 찾기");
		lblPwSearchTitle.setFont(new Font("Dialog", Font.BOLD, 32));
		lblPwSearchTitle.setBounds(130, 10, 238, 55);
		panel.add(lblPwSearchTitle);
		
		lblNotice1 = new JLabel("   비밀번호를 찾기 위해 가입할 때 입력하신");
		lblNotice1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNotice1.setBounds(38, 75, 422, 36);
		panel.add(lblNotice1);
		
		lblNotice2 = new JLabel("   휴대전화 번호와 이메일을 입력해주세요.");
		lblNotice2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNotice2.setBounds(38, 102, 422, 36);
		panel.add(lblNotice2);
		
		lblPhone = new JLabel("휴대전화");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPhone.setBounds(38, 155, 105, 43);
		panel.add(lblPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 24));
		lblEmail.setBounds(38, 208, 105, 43);
		panel.add(lblEmail);
		
		textPhone = new JTextField();
		textPhone.setText("예시) 010-1234-5678");
		textPhone.setFont(new Font("Dialog", Font.PLAIN, 18));
		textPhone.setBounds(155, 155, 305, 43);
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
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText("예시) abc@naver.com");
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(155, 208, 305, 43);
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
		
		btnSearch = new DesignedButton("찾기");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textPhone.getText().equals(member.getPhone()) && textEmail.getText().equals(member.getEmail())) {
					JOptionPane.showMessageDialog(SearchMyPwForInfo.this, String.format("해당 계정의 비밀번호는 %s입니다.", member.getPw()),
												  "비밀번호 찾기 성공", JOptionPane.INFORMATION_MESSAGE);
				} else JOptionPane.showMessageDialog(SearchMyPwForInfo.this, "입력하신 휴대전화 또는 이메일이 계정의 정보와 일치하지 않습니다.",
						  						  "비밀번호 찾기 실패", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 28));
		btnSearch.setBounds(38, 293, 422, 43);
		panel.add(btnSearch);
	}

}
