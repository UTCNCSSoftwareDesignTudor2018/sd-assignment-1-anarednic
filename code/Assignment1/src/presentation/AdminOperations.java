package presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLogic.CourseLogic;
import businessLogic.StudentLogic;
import businessLogic.TeacherLogic;
import entity.Course;
import entity.Student;
import entity.Teacher;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class AdminOperations {

	private JFrame frame;
	private JTextField textField_TeacherName;
	private JTextField textField_TeacherEmail;
	private JTextField textField_TeacherPassword;
	private TeacherLogic teacherlogic = new TeacherLogic();
	private StudentLogic studentlogic = new StudentLogic();
	private CourseLogic courselogic = new CourseLogic();
	private JTextField textField_sname;
	private JTextField textField_semail;
	private JTextField textField_spass;
	private JTextField textField_scnp;
	private JTextField textField_sidnr;
	private JTextField textField_sgroup;
	private JTextField textField_courseName;
	private JTextField textField_idt;
	private JTextField textField_ids;
	private JTextField textField_idc;
	JLabel label_adminName = new JLabel("");

	public AdminOperations() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 792, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add a new Teacher");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(153, 50, 204));
		lblNewLabel.setBounds(31, 40, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel labelName = new JLabel("Name:");
		labelName.setBounds(31, 80, 46, 14);
		frame.getContentPane().add(labelName);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(31, 105, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(31, 130, 69, 14);
		frame.getContentPane().add(lblPassword);
		
		textField_TeacherName = new JTextField();
		textField_TeacherName.setBounds(98, 77, 100, 20);
		frame.getContentPane().add(textField_TeacherName);
		textField_TeacherName.setColumns(10);
		
		textField_TeacherEmail = new JTextField();
		textField_TeacherEmail.setBounds(98, 102, 100, 20);
		frame.getContentPane().add(textField_TeacherEmail);
		textField_TeacherEmail.setColumns(10);
		
		textField_TeacherPassword = new JTextField();
		textField_TeacherPassword.setBounds(98, 127, 100, 20);
		frame.getContentPane().add(textField_TeacherPassword);
		textField_TeacherPassword.setColumns(10);
		
		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if ((textField_TeacherName.getText().isEmpty())||(textField_TeacherEmail.getText().isEmpty())||(textField_TeacherPassword.getText().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Please introduce all data");					
					} else {
					String regex_email="^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
					Pattern p =Pattern.compile(regex_email);
					Matcher m = p.matcher(textField_TeacherEmail.getText());
					if(m.find()==false) {
						JOptionPane.showMessageDialog(null, "Invalid Teacher E-mail");					
					}else
					teacherlogic.addNewTeacher(new Teacher(textField_TeacherName.getText(),textField_TeacherEmail.getText(),textField_TeacherPassword.getText(),null));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAddTeacher.setBounds(70, 155, 128, 23);
		frame.getContentPane().add(btnAddTeacher);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(492, 155, 208, 263);
		frame.getContentPane().add(textPane);
		
		JButton btnViewAllTeachers = new JButton("View All Teachers");
		btnViewAllTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> t=new ArrayList<String>();
				try {
					t=teacherlogic.viewAllTeachers();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<t.size();i++) {
					aux=aux+t.get(i)+"\n";
				}
				textPane.repaint();
				textPane.setText(aux);
			}
		});
		btnViewAllTeachers.setBounds(492, 36, 152, 23);
		frame.getContentPane().add(btnViewAllTeachers);
		
		textField_sname = new JTextField();
		textField_sname.setBounds(322, 77, 100, 20);
		frame.getContentPane().add(textField_sname);
		textField_sname.setColumns(10);
		
		textField_semail = new JTextField();
		textField_semail.setBounds(322, 102, 100, 20);
		frame.getContentPane().add(textField_semail);
		textField_semail.setColumns(10);
		
		textField_spass = new JTextField();
		textField_spass.setBounds(322, 127, 100, 20);
		frame.getContentPane().add(textField_spass);
		textField_spass.setColumns(10);
		
		JLabel lblAddANew = new JLabel("Add a new Student");
		lblAddANew.setForeground(new Color(255, 0, 0));
		lblAddANew.setBackground(new Color(186, 85, 211));
		lblAddANew.setBounds(256, 40, 106, 14);
		frame.getContentPane().add(lblAddANew);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(256, 80, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(256, 105, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(256, 130, 69, 14);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblNewLabel_1 = new JLabel("CNP:");
		lblNewLabel_1.setBounds(256, 155, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblIdentificationNumber = new JLabel("Identification Number: ");
		lblIdentificationNumber.setBounds(256, 186, 137, 14);
		frame.getContentPane().add(lblIdentificationNumber);
		
		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(256, 211, 46, 14);
		frame.getContentPane().add(lblGroup);
		
		textField_scnp = new JTextField();
		textField_scnp.setBounds(322, 152, 100, 20);
		frame.getContentPane().add(textField_scnp);
		textField_scnp.setColumns(10);
		
		textField_sidnr = new JTextField();
		textField_sidnr.setBounds(383, 183, 39, 20);
		frame.getContentPane().add(textField_sidnr);
		textField_sidnr.setColumns(10);
		
		textField_sgroup = new JTextField();
		textField_sgroup.setBounds(322, 211, 100, 20);
		frame.getContentPane().add(textField_sgroup);
		textField_sgroup.setColumns(10);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((textField_sname.getText().isEmpty())||(textField_semail.getText().isEmpty())||(textField_spass.getText().isEmpty())||(textField_sidnr.getText().isEmpty())||(textField_sgroup.getText().isEmpty())) {
						JOptionPane.showMessageDialog(null, "Please introduce all data");					
					} else {
					String regex_email="^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
					Pattern p =Pattern.compile(regex_email);
					Matcher m = p.matcher(textField_semail.getText());
					if(m.find()==false) {
						JOptionPane.showMessageDialog(null, "Invalid Student E-mail");					
					}else
					studentlogic.addStudent(new Student(textField_sname.getText(),textField_scnp.getText(),
							textField_semail.getText(),textField_spass.getText(),textField_sidnr.getText(),textField_sgroup.getText(),null));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddStudent.setBounds(294, 242, 128, 23);
		frame.getContentPane().add(btnAddStudent);
		
		JLabel lblAddANew_1 = new JLabel("Add a new Course");
		lblAddANew_1.setForeground(new Color(255, 0, 0));
		lblAddANew_1.setBounds(31, 262, 105, 14);
		frame.getContentPane().add(lblAddANew_1);
		
		textField_courseName = new JTextField();
		textField_courseName.setBounds(98, 296, 100, 20);
		frame.getContentPane().add(textField_courseName);
		textField_courseName.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(31, 299, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					courselogic.addNewCourse(new Course(textField_courseName.getText(),null,null));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddCourse.setBounds(70, 327, 128, 23);
		frame.getContentPane().add(btnAddCourse);
		
		JButton btnViewAllStudents = new JButton("View All Students");
		btnViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> s=new ArrayList<String>();
				try {
					s=studentlogic.viewAllStudents();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<s.size();i++) {
					aux=aux+s.get(i)+"\n";
				}
				textPane.repaint();
				textPane.setText(aux);
			}
		});
		btnViewAllStudents.setBounds(492, 76, 152, 23);
		frame.getContentPane().add(btnViewAllStudents);
		
		JButton btnViewAllCourses = new JButton("View All Courses");
		btnViewAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> c=new ArrayList<String>();
				try {
					c=courselogic.viewAllCourses();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<c.size();i++) {
					aux=aux+c.get(i)+"\n";
				}
				textPane.repaint();
				textPane.setText(aux);
			}
		});
		btnViewAllCourses.setBounds(492, 115, 152, 23);
		frame.getContentPane().add(btnViewAllCourses);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(31, 189, 29, 14);
		frame.getContentPane().add(lblId);
		
		textField_idt = new JTextField();
		textField_idt.setBounds(31, 208, 29, 20);
		frame.getContentPane().add(textField_idt);
		textField_idt.setColumns(10);
		
		JButton btnDeleteTeacher = new JButton("Delete Teacher");
		btnDeleteTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					teacherlogic.deleteTeacher(Integer.parseInt(textField_idt.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteTeacher.setBounds(70, 212, 128, 23);
		frame.getContentPane().add(btnDeleteTeacher);
		
		JButton btnUpdateTeacher = new JButton("Update Teacher");
		btnUpdateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int idt = Integer.parseInt(textField_idt.getText());
				Teacher new_teacher=new Teacher();
				new_teacher = teacherlogic.viewTeacher(idt);
				new_teacher.setEmail(textField_TeacherEmail.getText());
				new_teacher.setName(textField_TeacherName.getText());
				new_teacher.setPassword(textField_TeacherPassword.getText());
				teacherlogic.updateTeacher(new_teacher);
				}
				catch (Exception e1) {
				}
			}
		});
		btnUpdateTeacher.setBounds(70, 182, 128, 23);
		frame.getContentPane().add(btnUpdateTeacher);
		
		JButton btnNewButton = new JButton("Update Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int ids = Integer.parseInt(textField_ids.getText());
				Student new_student=new Student();
				new_student = studentlogic.viewStudent(ids);
				new_student.setEmail(textField_semail.getText());
				new_student.setName(textField_sname.getText());
				new_student.setPassword(textField_spass.getText());
				new_student.setCNP(textField_scnp.getText());
				new_student.setIdentificationNr(textField_sidnr.getText());
				new_student.setGroup(textField_sgroup.getText());
				studentlogic.updateStudent(new_student);
				}
				catch (Exception e1) {
				}
			}
		});
		btnNewButton.setBounds(294, 276, 128, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					studentlogic.deleteStudent(Integer.parseInt(textField_ids.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteStudent.setBounds(294, 310, 128, 23);
		frame.getContentPane().add(btnDeleteStudent);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(256, 280, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		textField_ids = new JTextField();
		textField_ids.setBounds(256, 299, 29, 20);
		frame.getContentPane().add(textField_ids);
		textField_ids.setColumns(10);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(70, 361, 128, 23);
		frame.getContentPane().add(btnUpdateCourse);
		
		JButton btnNewButton_1 = new JButton("Delete Course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					courselogic.deleteCourse(Integer.parseInt(textField_idc.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(70, 395, 128, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblId_2 = new JLabel("ID:");
		lblId_2.setBounds(31, 365, 46, 14);
		frame.getContentPane().add(lblId_2);
		
		textField_idc = new JTextField();
		textField_idc.setBounds(31, 384, 29, 20);
		frame.getContentPane().add(textField_idc);
		textField_idc.setColumns(10);
		
		JLabel lblAdministrator = new JLabel("Administrator:");
		lblAdministrator.setBounds(31, 11, 93, 14);
		frame.getContentPane().add(lblAdministrator);
		
		label_adminName.setBounds(124, 11, 106, 14);
		frame.getContentPane().add(label_adminName);
	}
}
