package presentation;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import businessLogic.CourseLogic;
import businessLogic.StudentLogic;
import entity.Course;
import entity.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class StudentView {

	private JFrame frame;
	Student sessionStudent = new Student();
	JTextPane textPane = new JTextPane();
	StudentLogic slogic = new StudentLogic();
	CourseLogic clogic = new CourseLogic();
	private JTextField textField;
	Integer list_available_courses[]=new Integer[15];
	
	public StudentView(Student sessionStudent) {
		initialize();
		this.sessionStudent=sessionStudent;
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.setBounds(100, 100, 523, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudent = new JLabel("Student: ");
		lblStudent.setBounds(32, 58, 60, 14);
		frame.getContentPane().add(lblStudent);
		
		textPane.setBackground(null);
		textPane.setBounds(102, 52, 114, 20);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(285, 52, 198, 177);
		frame.getContentPane().add(textPane_1);
		
		JButton btnPersonalData = new JButton("Personal Data");
		btnPersonalData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_1.repaint();
				textPane_1.setText("Name: "+sessionStudent.getName()+"\nCNP: "+sessionStudent.getCNP()
						+"\nE-mail: "+sessionStudent.getEmail()+"\nIdentification Number: "
						+sessionStudent.getIdentificationNr()+"\nGroup: "+sessionStudent.getGroup());
			}
		});
		btnPersonalData.setBounds(51, 112, 182, 23);
		frame.getContentPane().add(btnPersonalData);
		
		JButton btnNewButton = new JButton("Courses and Grades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aux=new String();
				ArrayList<String> s=new ArrayList<String>();
				try {
					s=slogic.coursesAndGrades(sessionStudent.getID());
				} catch (Exception e1) {
				}
				for (int i=0;i<s.size();i++) {
					aux+=s.get(i)+"\n";
				}
				textPane_1.repaint();
				textPane_1.setText(aux);
			}
		});
		btnNewButton.setBounds(51, 160, 182, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnViewAvailableCourses = new JButton("View Available Courses");
		btnViewAvailableCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> s=new ArrayList<String>();
				try {
					s=slogic.availableCourses(sessionStudent.getID());
				} catch (Exception e1) {
				}
				for (int i=0;i<s.size();i++) {
					aux+=s.get(i)+"\n";
				}
				textPane_1.repaint();
				textPane_1.setText(aux);
			}
		});
		btnViewAvailableCourses.setBounds(51, 206, 182, 23);
		frame.getContentPane().add(btnViewAvailableCourses);
		
		JLabel lblNameOfCourse = new JLabel("Course you wish to enroll to: (ID)");
		lblNameOfCourse.setBounds(51, 259, 247, 14);
		frame.getContentPane().add(lblNameOfCourse);
		
		textField = new JTextField();
		textField.setBounds(248, 256, 38, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("now "+sessionStudent.getID());
				int course_id_aux = 0;
				int course_id;
				try {
				course_id_aux = Integer.parseInt(textField.getText());
				}
				catch(Exception j) {
					JOptionPane.showMessageDialog(null, "Please enter an available course ID");	
				}
				course_id=course_id_aux;
				try {
					Course c = clogic.viewCourse(course_id);
					slogic.enrolStudent(sessionStudent, c);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEnroll.setBounds(344, 255, 89, 23);
		frame.getContentPane().add(btnEnroll);
		
	}
}
