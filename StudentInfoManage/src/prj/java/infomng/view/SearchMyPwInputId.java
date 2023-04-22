package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.net.aso.f;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.model.JoinMember;
import prj.java.infomng.controller.JoinMemberDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchMyPwInputId extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JTextField textId;
	private JLabel lblSearchPw;
	private JLabel lblSearchPwNotice;
	private JButton btnNext;
	private JoinMember member = null;
	private JoinMemberDaoImpl daoJoin = JoinMemberDaoImpl.getInstance();

	/**
	 * Launch the application.
	 */
	public static void showSearchMyPwInputId(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchMyPwInputId frame = new SearchMyPwInputId(parent);
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
	public SearchMyPwInputId(Component parent) {
		this.parent = parent;
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
        
		setBounds(x, y, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new ImagePanel(new ImageIcon("C:/Users/82104/git/Java_Swing_Project2/StudentInfoManage/images/searchpwinputid.png").getImage());
		panel.setBounds(0, 0, 484, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSearchPw = new JLabel("비밀번호 찾기");
		lblSearchPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPw.setFont(new Font("Dialog", Font.BOLD, 32));
		lblSearchPw.setBounds(115, 10, 238, 55);
		panel.add(lblSearchPw);
		
		lblSearchPwNotice = new JLabel("   비밀번호를 찾고자 하는 아이디를 입력해주세요.");
		lblSearchPwNotice.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSearchPwNotice.setBounds(38, 75, 422, 36);
		panel.add(lblSearchPwNotice);
		
		textId = new JTextField();
		textId.setFont(new Font("Dialog", Font.PLAIN, 18));
		textId.setBounds(38, 131, 422, 43);
		panel.add(textId);
		textId.setColumns(10);
		
		btnNext = new DesignedButton("New button");
		btnNext.setText("다음");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					member = daoJoin.idInputHaveInfo(textId.getText());

					if(member.getId().equals(textId.getText())) {
						SearchMyPwForInfo.showSearchMyPwForInfo(SearchMyPwInputId.this, member);
						dispose();
					}
					else JOptionPane.showMessageDialog(SearchMyPwInputId.this, "입력하신 아이디를 찾을 수 없습니다.", "아이디 미일치", JOptionPane.INFORMATION_MESSAGE);

				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(SearchMyPwInputId.this, "입력하신 아이디를 찾을 수 없습니다.", "아이디 미일치", JOptionPane.INFORMATION_MESSAGE);
				}


			}
		});
		btnNext.setFont(new Font("Dialog", Font.BOLD, 28));
		btnNext.setBounds(38, 195, 422, 43);
		panel.add(btnNext);
		
	}
}
