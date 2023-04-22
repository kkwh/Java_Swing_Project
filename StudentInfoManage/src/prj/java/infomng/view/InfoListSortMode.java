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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;

public class InfoListSortMode extends JFrame {

	private final StudentInfoManageDaoImpl dao = StudentInfoManageDaoImpl.getInstance();
	
	private static final String[] COLUMN_NAMES = {"이름", "성별", "전화번호", "이메일", "생년월일", "학과", "학번", "평균학점"};
	
	private JPanel contentPane;	
	private Component parent;
	private StudentInfoManageMain app;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private List<StudentInfoManage> studentInfolist;
	private int cid;
	private JTextField textSearch;
	private JPanel panel;
	private JLabel lblSearch;
	private JButton btnSearch;
	private StudentInfoList list;

	/**
	 * Launch the application.
	 */
	public static void showInfoListSortMode(Component parent, StudentInfoManageMain app, StudentInfoList list, int cid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoListSortMode frame = new InfoListSortMode(parent, app, list, cid);
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
	public InfoListSortMode(Component parent, StudentInfoManageMain app, StudentInfoList list, int cid) {
		this.parent = parent;
		this.app = app;
		this.list = list;
		this.cid = cid;
		
		initialize();
		loadStudentInfo();
		
	}
	
	public void resetTableModel() {
		model = new DefaultTableModel(null, COLUMN_NAMES);
		loadStudentInfo();
		table.setModel(model);
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
			JOptionPane.showMessageDialog(InfoListSortMode.this, "Guest는 사용할 수 없는 기능입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
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
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 33, 1174, 301);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(243, 222, 186));
		model = new DefaultTableModel(null, COLUMN_NAMES); 
		table.setModel(model);
		
		 TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);  // 테이블 정렬, 정렬 후 crud 논리적 오류
	        sorter.setComparator(0, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(1, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(3, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(4, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(5, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(6, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        sorter.setComparator(7, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	       
	        table.setRowSorter(sorter);
		
		table.getTableHeader().setFont(new Font("고도체", Font.BOLD, 18));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(171, 196, 170));
		table.getTableHeader().setForeground(new Color(103, 93, 80));
		table.setRowHeight(25);
		
		
		table.setFont(new Font("Dialog", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1174, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSearch = new JLabel("검색:");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSearch.setBounds(366, 0, 57, 33);
		panel.add(lblSearch);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Dialog", Font.PLAIN, 18));
		textSearch.setBounds(430, 0, 256, 33);
		panel.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new DesignedButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textSearch.getText())); // 상단 검색 기능
			}
		});
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSearch.setBounds(699, 0, 68, 33);
		panel.add(btnSearch);
		
		DesignedButton btnDispose = new DesignedButton("정렬모드 종료");
		btnDispose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				list.showStudentInfoFrame(InfoListSortMode.this, app, cid);
			}
		});
		btnDispose.setFont(new Font("Dialog", Font.BOLD, 18));
		btnDispose.setBounds(1039, 0, 134, 33);
		panel.add(btnDispose);
		InfoListSortMode.this.setResizable(false); // 크기 조절 X
		
		
	}
}
