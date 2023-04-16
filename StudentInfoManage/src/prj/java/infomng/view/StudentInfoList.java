package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.controller.StudentInfoManageDaoImpl;
import prj.java.infomng.model.StudentInfoManage;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class StudentInfoList extends JFrame {

	private final StudentInfoManageDaoImpl dao = StudentInfoManageDaoImpl.getInstance();
	
	private static final String[] COLUMN_NAMES = {"이름", "성별", "전화번호", "이메일", "생년월일", "학과", "학번", "평균학점"};
	
	private JPanel contentPane;	
	private Component parent;
	private StudentInfoManageMain app;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private List<StudentInfoManage> studentInfolist;

	/**
	 * Launch the application.
	 */
	public static void showStudentInfoFrame(Component parent, StudentInfoManageMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoList frame = new StudentInfoList(parent, app);
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
	public StudentInfoList(Component parent, StudentInfoManageMain app) {
		this.parent = parent;
		this.app = app;
		initialize();
		loadStudentInfo();
		
	}

	private void loadStudentInfo() {
		studentInfolist = dao.read();
		for (StudentInfoManage s : studentInfolist) {
            Object[] row = {s.getName(), s.getGender(), s.getPhone(), s.getEmail(), s.getBirht(), s.getMajor(),
            				s.getstudentId(), s.getAvgGradePoint()};
            model.addRow(row);
        }
	}

	public void initialize() {
		setTitle("학생 정보관리프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		int x = 100;
        int y = 100;
        if (parent != null) {
            x = parent.getX();
            y = parent.getY();
        }
		setBounds(x, y, 595, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		table.setModel(model);
		
		table.setFont(new Font("Dialog", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
	}

}
