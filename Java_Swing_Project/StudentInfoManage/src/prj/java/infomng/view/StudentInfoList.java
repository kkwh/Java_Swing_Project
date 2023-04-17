package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JPanel panelBtn;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;

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
	
	public void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		loadStudentInfo();
		table.setModel(model);
	}
	
	public void notifyStudentInfoCreate() {
		resetTableModel();
		JOptionPane.showMessageDialog(StudentInfoList.this, "새 학생 정보 저장 성공");
		
	}
	
	public void notifyStudentInfoUpdate() {
		resetTableModel();
		JOptionPane.showMessageDialog(StudentInfoList.this, "프로그램 업데이트 성공");
	}
	
	private void loadStudentInfo() {
		studentInfolist = dao.read();
		for (StudentInfoManage s : studentInfolist) {
            Object[] row = {s.getName(), s.getGender(), s.getPhone(), s.getEmail(), s.getBirth(), s.getMajor(),
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
		setBounds(x, y, 1195, 378);
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
		
		panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		btnInsert = new JButton("학생 정보 추가");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentInfoCreateFrame.showStudentInfoCreateFrame(parent, StudentInfoList.this);
			}
		});
		btnInsert.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnInsert);
		
		btnUpdate = new JButton("학생 정보 수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStudentInfo();
			}
		});
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnUpdate);
		
		btnDelete = new JButton("학생 정보 삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteStudentInfo();
			}
		});
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnDelete);
		
		btnSearch = new JButton("학생 정보 검색");
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnSearch);
		
	}

	private void updateStudentInfo() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(StudentInfoList.this,
					"업데이트할 행을 먼저 선택하세요...",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int cid = studentInfolist.get(row).getCid();
		StudentInfoUpdateFrame.showStudentInfoUpdateFrame(StudentInfoList.this, StudentInfoList.this , cid); 
		
	}

	private void deleteStudentInfo() {

		int row = table.getSelectedRow();

		if(row == -1) {
			JOptionPane.showMessageDialog(
					StudentInfoList.this,
					"삭제하려는 행을 먼저 선택하세요...",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(
				StudentInfoList.this,
				"정말 삭제할까요?",
				"삭제 확인",
				JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			int cid = studentInfolist.get(row).getCid();
			dao.delete(cid); 
			model.removeRow(row);

			JOptionPane.showMessageDialog(StudentInfoList.this, "삭제 성공");


		}

	}

}
