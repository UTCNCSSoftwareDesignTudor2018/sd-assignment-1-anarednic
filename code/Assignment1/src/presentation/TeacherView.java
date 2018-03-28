package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import businessLogic.TeacherLogic;
import entity.Teacher;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TeacherView {

	private JFrame frame;
	JLabel labelTeacherName = new JLabel("");
	Teacher sessionTeacher = new Teacher();
	TeacherLogic tlogic = new TeacherLogic();

	public TeacherView(Teacher sessionTeacher) {
		initialize();
		this.sessionTeacher=sessionTeacher;
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 386, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeacher = new JLabel("Teacher:");
		lblTeacher.setBounds(60, 47, 78, 14);
		frame.getContentPane().add(lblTeacher);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(60, 115, 241, 123);
		frame.getContentPane().add(textPane);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> s=new ArrayList<String>();
				try {
					s=tlogic.studentsOfATeacher(sessionTeacher.getID());
				} catch (Exception e1) {
				}
				for (int i=0;i<s.size();i++) {
					aux+=s.get(i)+"\n";
				}
				textPane.repaint();
				textPane.setText(aux);
			}
		});
		btnStudents.setBounds(60, 81, 89, 23);
		frame.getContentPane().add(btnStudents);
		
		JButton btnNewButton = new JButton("Grades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux=new String();
				ArrayList<String> s=new ArrayList<String>();
				try {
					s=tlogic.gradesOfATeacher(sessionTeacher.getID());
				} catch (Exception e1) {
				}
				for (int i=0;i<s.size();i++) {
					aux+=s.get(i)+"\n";
				}
				textPane.repaint();
				textPane.setText(aux);
			}
		});
		btnNewButton.setBounds(212, 81, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		labelTeacherName.setBounds(142, 47, 175, 14);
		frame.getContentPane().add(labelTeacherName);
	}
}
