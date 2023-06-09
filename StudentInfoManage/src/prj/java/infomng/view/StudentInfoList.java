package prj.java.infomng.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prj.java.infomng.controller.StudentInfoManageDaoImpl;
import prj.java.infomng.design.DesignedButton;
import prj.java.infomng.model.StudentInfoManage;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.Icon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JButton btnRefresh;
	private int cid;
	private JButton btnSortMode;

	/**
	 * Launch the application.
	 */
	public static void showStudentInfoFrame(Component parent, StudentInfoManageMain app, int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoList frame = new StudentInfoList(parent, app, cid);
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
	public StudentInfoList(Component parent, StudentInfoManageMain app, int cid) {
		this.parent = parent;
		this.app = app;
		this.cid = cid;
		initialize();
		loadStudentInfo();
		
	}
	
	public void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		loadStudentInfo();
		table.setModel(model);
	}
	
	public void notifyStudentInfoRefesh() {
		resetTableModel();
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
	
	private int guestCheck() {
		if(cid == -1) {
			JOptionPane.showMessageDialog(StudentInfoList.this, "Guest는 사용할 수 없는 기능입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
		}
		return cid;
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
		table.setBackground(new Color(243, 222, 186));
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		table.setModel(model);
		
//		 TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);  // 테이블 정렬, 정렬 후 crud 논리적 오류
//	        sorter.setComparator(0, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(1, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(3, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(4, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(5, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(6, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	        sorter.setComparator(7, new Comparator<String>() {
//	            public int compare(String o1, String o2) {
//	                return o1.compareTo(o2);
//	            }
//	        });
//	       
//	        table.setRowSorter(sorter);
		
		table.getTableHeader().setFont(new Font("고도체", Font.BOLD, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(171, 196, 170));
		table.getTableHeader().setForeground(new Color(103, 93, 80));
		table.setRowHeight(25);
		
		
		table.setFont(new Font("Dialog", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		btnInsert = new DesignedButton("학생 정보 추가");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(guestCheck() == -1) return;
				StudentInfoCreateFrame.showStudentInfoCreateFrame(parent, StudentInfoList.this);
			}
		});
		btnInsert.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnInsert);
		
		btnUpdate = new DesignedButton("학생 정보 수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(guestCheck() == -1) return;
				updateStudentInfo();
			}
		});
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnUpdate);
		
		btnDelete = new DesignedButton("학생 정보 삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(guestCheck() == -1) return;
				deleteStudentInfo();
			}
		});
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnDelete);
		
		btnSearch = new DesignedButton("학생 정보 검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				searchStudentInfo();
			}
		});
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnSearch);
		
		btnRefresh = new DesignedButton("목록 전체 보기");
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyStudentInfoRefesh();
			}
		});
		btnRefresh.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnRefresh);
		
		btnSortMode = new DesignedButton("정렬 모드");
		btnSortMode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				InfoListSortMode.showInfoListSortMode(StudentInfoList.this, app, StudentInfoList.this ,cid);
			}
		});
		btnSortMode.setFont(new Font("Dialog", Font.BOLD, 18));
		panelBtn.add(btnSortMode);
		StudentInfoList.this.setResizable(false); // 크기 조절 X
		
		
	}

	private void searchStudentInfo() {
		String keyword = "";
		try {
			keyword = JOptionPane.showInputDialog(StudentInfoList.this, "검색어", "검색", JOptionPane.QUESTION_MESSAGE);
			if(keyword.equals("")) {
				JOptionPane.showMessageDialog(StudentInfoList.this, "검색어를 입력하세요.");
				return;
			}
		}
		catch (Exception e) {
			return;
		}
		
		studentInfolist = dao.read(keyword);
		
		model = new DefaultTableModel(null, COLUMN_NAMES);
		for (StudentInfoManage s : studentInfolist) {
			Object[] row = { s.getName(), s.getGender(), s.getPhone(), s.getEmail(),
							 s.getBirth(), s.getMajor(), s.getstudentId(), s.getAvgGradePoint()};
			model.addRow(row);
		}
		table.setModel(model);
		
	}

	private void updateStudentInfo() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(StudentInfoList.this,
					"수정하려는 행을 선택하세요.",
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
					"삭제하려는 행을 선택하세요.",
					"경고",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(
				StudentInfoList.this,
				"정말 삭제하시겠습니까?",
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
