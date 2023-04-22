package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.design.DesignedButton4;
import prj.java.infomng.design.ImagePanel;
import prj.java.infomng.design.JTextFieldLimit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class CalAvgGradePoint extends JFrame {

	private JPanel contentPane;
	private Component parent;
	private JTextField textInput1;
	private JLabel lblNum1;
	private JLabel lblNum2;
	private JLabel lblNum3;
	private JLabel lblNum4;
	private JLabel lblNum5;
	private JLabel lblNum6;
	private JLabel lblNum7;
	private JLabel lblNum8;
	private JTextField textInput2;
	private JTextField textInput3;
	private JTextField textInput4;
	private JTextField textInput5;
	private JTextField textInput6;
	private JTextField textInput7;
	private JTextField textInput8;
	private JButton btnAdd;
	private int numCount = 1;
	private JButton btnCal;
	private StudentInfoManageMain app;
	
	
	/**
	 * Launch the application.
	 */
	public static void showCalAvgGradePoint(Component parent, StudentInfoManageMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalAvgGradePoint frame = new CalAvgGradePoint(parent, app);
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
	public CalAvgGradePoint(Component parent, StudentInfoManageMain app) {
		this.parent = parent;
		this.app = app;
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("학점계산기");
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
		setBounds(x+827, y+66, 315, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new ImagePanel(new ImageIcon("C:/Users/82104/git/Java_Swing_Project2/StudentInfoManage/images/calavggradepoint.png").getImage());
		panel.setBounds(0, 0, 299, 486);
		contentPane.add(panel);
		
		lblNum1 = new JLabel("1");
		lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum1.setBounds(12, 65, 85, 35);
		lblNum1.setVisible(false);
		panel.add(lblNum1);
		
		textInput1 = new JTextField();
		textInput1.setText("예시) 4.50");
		textInput1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput1.setBounds(109, 65, 178, 35);
		textInput1.setVisible(false);
//		textInput1.setDocument(new JTextFieldLimit(4));
		textInput1.addFocusListener(new FocusListener() {  //TextField 안에 클릭하면 지워지는 글씨
            @Override
            public void focusGained(FocusEvent e) {
            	
                textInput1.setText("");
                textInput1.setDocument(new JTextFieldLimit(4)); // 입력가능한 글자수를 제한
            }

            @Override
            public void focusLost(FocusEvent e) {
            	if(textInput1.getText().equals("")) {            		
            		textInput1.setDocument(new JTextFieldLimit(12));
            		textInput1.setText("예시) 4.50");
            	}
            }
        });
		panel.add(textInput1);
		textInput1.setColumns(10);
		
		lblNum2 = new JLabel("2");
		lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum2.setBounds(12, 110, 85, 35);
		lblNum2.setVisible(false);
		panel.add(lblNum2);
		
		lblNum3 = new JLabel("3");
		lblNum3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum3.setBounds(12, 155, 85, 35);
		lblNum3.setVisible(false);
		panel.add(lblNum3);
		
		lblNum4 = new JLabel("4");
		lblNum4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum4.setBounds(12, 200, 85, 35);
		lblNum4.setVisible(false);
		panel.add(lblNum4);
		
		lblNum5 = new JLabel("5");
		lblNum5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum5.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum5.setBounds(12, 245, 85, 35);
		lblNum5.setVisible(false);
		panel.add(lblNum5);
		
		lblNum6 = new JLabel("6");
		lblNum6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum6.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum6.setBounds(12, 290, 85, 35);
		lblNum6.setVisible(false);
		panel.add(lblNum6);
		
		lblNum7 = new JLabel("7");
		lblNum7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum7.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum7.setBounds(12, 335, 85, 35);
		lblNum7.setVisible(false);
		panel.add(lblNum7);
		
		lblNum8 = new JLabel("8");
		lblNum8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum8.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNum8.setBounds(12, 380, 85, 35);
		lblNum8.setVisible(false);
		panel.add(lblNum8);
		
		textInput2 = new JTextField();
		textInput2.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput2.setColumns(10);
		textInput2.setBounds(109, 110, 178, 35);
		textInput2.setDocument(new JTextFieldLimit(4));
		textInput2.setVisible(false);
		panel.add(textInput2);
		
		textInput3 = new JTextField();
		textInput3.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput3.setColumns(10);
		textInput3.setBounds(109, 155, 178, 35);
		textInput3.setDocument(new JTextFieldLimit(4));
		textInput3.setVisible(false);
		panel.add(textInput3);
		
		textInput4 = new JTextField();
		textInput4.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput4.setColumns(10);
		textInput4.setBounds(109, 200, 178, 35);
		textInput4.setDocument(new JTextFieldLimit(4));
		textInput4.setVisible(false);
		panel.add(textInput4);
		
		textInput5 = new JTextField();
		textInput5.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput5.setColumns(10);
		textInput5.setBounds(109, 245, 178, 35);
		textInput5.setDocument(new JTextFieldLimit(4));
		textInput5.setVisible(false);
		panel.add(textInput5);
		
		textInput6 = new JTextField();
		textInput6.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput6.setColumns(10);
		textInput6.setBounds(109, 290, 178, 35);
		textInput6.setDocument(new JTextFieldLimit(4));
		textInput6.setVisible(false);
		panel.add(textInput6);
		
		textInput7 = new JTextField();
		textInput7.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput7.setColumns(10);
		textInput7.setBounds(109, 335, 178, 35);
		textInput7.setDocument(new JTextFieldLimit(4));
		textInput7.setVisible(false);
		panel.add(textInput7);
		
		textInput8 = new JTextField();
		textInput8.setFont(new Font("Dialog", Font.PLAIN, 18));
		textInput8.setColumns(10);
		textInput8.setBounds(109, 380, 178, 35);
		textInput8.setDocument(new JTextFieldLimit(4));
		textInput8.setVisible(false);
		panel.add(textInput8);
		
		btnAdd = new DesignedButton("추가");
		btnAdd.setText("행 추가");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(numCount) {
				case 1 :
					lblNum1.setVisible(true);
					textInput1.setVisible(true);
					numCount++;
					break;
				case 2 :
					lblNum2.setVisible(true);
					textInput2.setVisible(true);
					numCount++;
					break;
				case 3 :
					lblNum3.setVisible(true);
					textInput3.setVisible(true);
					numCount++;
					break;
				case 4 :
					lblNum4.setVisible(true);
					textInput4.setVisible(true);
					numCount++;
					break;
				case 5 :
					lblNum5.setVisible(true);
					textInput5.setVisible(true);
					numCount++;
					break;
				case 6 :
					lblNum6.setVisible(true);
					textInput6.setVisible(true);
					numCount++;
					break;
				case 7 :
					lblNum7.setVisible(true);
					textInput7.setVisible(true);
					numCount++;
					break;
				case 8 :
					lblNum8.setVisible(true);
					textInput8.setVisible(true);
					numCount++;
					break;
				}
			}   
		});
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 20));
		btnAdd.setBounds(42, 10, 97, 35);
		panel.add(btnAdd);
		
		btnCal = new DesignedButton4("계산");
		btnCal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean result = checkMyPoint();
					if(!result) return;
					
					switch(numCount) {
					case 2 :
						app.setTextAvgGradePoint(textInput1.getText());
						dispose();
						break;
					case 3 :
						double val2 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText());
						val2 /= numCount-1;
						val2 = Math.round(val2 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val2));
						dispose();
						break;
					case 4 :
						double val3 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText());
						val3 /= numCount-1;
						val3 = Math.round(val3 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val3));
						dispose();
						break;
					case 5 :
						double val4 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText()) + Double.parseDouble(textInput4.getText());
						val4 /= numCount-1;
						val4 = Math.round(val4 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val4));
						dispose();
						break;
					case 6 :
						double val5 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText()) + Double.parseDouble(textInput4.getText()) +
						Double.parseDouble(textInput5.getText());
						val5 /= numCount-1;
						val5 = Math.round(val5 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val5));
						dispose();
						break;
					case 7 :
						double val6 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText()) + Double.parseDouble(textInput4.getText()) +
						Double.parseDouble(textInput5.getText()) + Double.parseDouble(textInput6.getText());
						val6 /= numCount-1;
						val6 = Math.round(val6 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val6));
						dispose();
						break;
					case 8 :
						double val7 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText()) + Double.parseDouble(textInput4.getText()) +
						Double.parseDouble(textInput5.getText()) + Double.parseDouble(textInput6.getText()) +
						Double.parseDouble(textInput7.getText());
						val7 /= numCount-1;
						val7 = Math.round(val7 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val7));
						dispose();
						break;
					case 9 :
						double val8 = Double.parseDouble(textInput1.getText()) + Double.parseDouble(textInput2.getText()) + 
						Double.parseDouble(textInput3.getText()) + Double.parseDouble(textInput4.getText()) +
						Double.parseDouble(textInput5.getText()) + Double.parseDouble(textInput6.getText()) +
						Double.parseDouble(textInput7.getText()) + Double.parseDouble(textInput8.getText());
						val8 /= numCount-1;
						val8 = Math.round(val8 * 100) / 100.0;
						app.setTextAvgGradePoint(String.valueOf(val8));
						dispose();
						break;
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(CalAvgGradePoint.this, "양식을 다시 확인해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCal.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCal.setBounds(42, 441, 97, 35);
		panel.add(btnCal);
		
		DesignedButton btnClose = new DesignedButton("추가");
		btnClose.setText("닫기");
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Dialog", Font.BOLD, 20));
		btnClose.setBounds(175, 441, 97, 35);
		panel.add(btnClose);
		
		DesignedButton btnDelete = new DesignedButton("제거");
		btnDelete.setText("행 제거");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(numCount) {
//				case 1 :
//					lblNum1.setVisible(false);
//					textInput1.setVisible(false);
//					break;
				case 2 :
					lblNum1.setVisible(false);
					textInput1.setVisible(false);
					numCount--;
					break;
				case 3 :
					lblNum2.setVisible(false);
					textInput2.setVisible(false);
					numCount--;
					break;
				case 4 :
					lblNum3.setVisible(false);
					textInput3.setVisible(false);
					numCount--;
					break;
				case 5 :
					lblNum4.setVisible(false);
					textInput4.setVisible(false);
					numCount--;
					break;
				case 6 :
					lblNum5.setVisible(false);
					textInput5.setVisible(false);
					numCount--;
					break;
				case 7 :
					lblNum6.setVisible(false);
					textInput6.setVisible(false);
					numCount--;
					break;
				case 8 :
					lblNum7.setVisible(false);
					textInput7.setVisible(false);
					numCount--;
					break;
				case 9 :
					lblNum8.setVisible(false);
					textInput8.setVisible(false);
					numCount--;
					break;
				}
			}
		});
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDelete.setBounds(175, 10, 97, 35);
		panel.add(btnDelete);
		CalAvgGradePoint.this.setResizable(false);
	}
		
		private boolean checkMyPoint() {
			boolean check = true;
			
			switch(numCount) {
			case 2 :
				if (!textInput1.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 3 :
				if (!textInput2.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 4 :
				if (!textInput3.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 5 :
				if (!textInput4.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 6 :
				if (!textInput5.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 7 :
				if (!textInput6.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 8 :
				if (!textInput7.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			case 9 :
				if (!textInput8.getText().matches("\\d\\.\\d{1,2}")) {
					JOptionPane.showMessageDialog(this, "평균학점이 올바른 양식이 아닙니다.", "에러", JOptionPane.ERROR_MESSAGE);
					check = false;
				}
				break;
			}		

			return check;
		}
}
