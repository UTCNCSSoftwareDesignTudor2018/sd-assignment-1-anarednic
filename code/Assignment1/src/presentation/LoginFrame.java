package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businessLogic.StudentLogic;
import businessLogic.TeacherLogic;
import entity.Student;
import entity.Teacher;
import repository.StudentRepository;
import repository.TeacherRepository;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;

public class LoginFrame {

	private JFrame frame;
	private JTextField textField_email;
	private JTextField textField_password;
	private TeacherLogic tlogic = new TeacherLogic();
	private StudentLogic slogic = new StudentLogic();
	private Teacher sessionTeacher = new Teacher();
	private Student sessionStudent = new Student();
	public LoginFrame() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 440, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Log-in");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblLogin.setForeground(new Color(128, 0, 0));
		lblLogin.setBounds(173, 28, 63, 23);
		frame.getContentPane().add(lblLogin);

		textField_email = new JTextField();
		textField_email.setBounds(159, 77, 203, 20);
		frame.getContentPane().add(textField_email);
		textField_email.setColumns(10);

		textField_password = new JPasswordField();
		textField_password.setBounds(159, 108, 203, 20);
		frame.getContentPane().add(textField_password);
		textField_password.setColumns(10);

		JLabel lblUsername = new JLabel("E-mail");
		lblUsername.setBounds(59, 80, 63, 14);
		frame.getContentPane().add(lblUsername);

		JLabel lblParola = new JLabel("Password");
		lblParola.setBounds(59, 111, 63, 14);
		frame.getContentPane().add(lblParola);

		JCheckBox chckbxIAmA = new JCheckBox("I am a Teacher");
		chckbxIAmA.setBackground(null);
		chckbxIAmA.setBounds(59, 152, 109, 23);
		frame.getContentPane().add(chckbxIAmA);
		
		JCheckBox chckbxRunAsAdministrator = new JCheckBox("Run as Administrator");
		chckbxRunAsAdministrator.setBackground(null);
		chckbxRunAsAdministrator.setBounds(211, 152, 151, 23);
		frame.getContentPane().add(chckbxRunAsAdministrator);

		JButton btnConnect = new JButton("Connect");
		btnConnect.setBackground(new Color(250, 235, 215));
		btnConnect.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				if ((textField_email.getText().isEmpty()) || (textField_password.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Please introduce both e-mail and password");
				} 
				else {									
					String regex_email="^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,6}$";
					Pattern p =Pattern.compile(regex_email);
					Matcher m = p.matcher(textField_email.getText());
					if(m.find()==false) {
						JOptionPane.showMessageDialog(null, "Invalid e-mail");					
					}
					else if (chckbxIAmA.isSelected()) {
						TeacherRepository teacherRepo = new TeacherRepository();
						ArrayList<String> emails = new ArrayList<String>();
						ArrayList<String> passwords = new ArrayList<String>();
						emails = teacherRepo.loginTeacherEmail();
						passwords = teacherRepo.loginTeacherPassword();
						boolean success = false;
						for (int i=0; i<emails.size(); i++) {
							String auxEmail = emails.get(i);
							String auxPass = passwords.get(i);
							if ((auxEmail.equals(textField_email.getText()))
									&& (auxPass.equals(textField_password.getText()))) {
								success = true;
							}
						}
						if (success) {
							if (chckbxRunAsAdministrator.isSelected()) {
								AdminOperations adminop = new AdminOperations();
								Teacher t = tlogic.teacherInfoGivenEmail(textField_email.getText());
								sessionTeacher = t;
								adminop.label_adminName.setText(t.getName());
								frame.setVisible(false);
							}
							else {
								Teacher t = tlogic.teacherInfoGivenEmail(textField_email.getText());
								sessionTeacher = t;
								TeacherView tview = new TeacherView(sessionTeacher);
								tview.labelTeacherName.setText(t.getName());
								frame.setVisible(false);
							}
							}
						else {JOptionPane.showMessageDialog(null, "E-mail or password incorrect");}
					} else {
						StudentRepository studentRepo = new StudentRepository();
						ArrayList<String> emails = new ArrayList<String>();
						ArrayList<String> passwords = new ArrayList<String>();
						emails = studentRepo.loginStudentEmail();
						passwords = studentRepo.loginStudentPassword();
						boolean success = false;
						for (int i = 0; i < emails.size(); i++) {
							String auxEmail = emails.get(i);
							String auxPass = passwords.get(i);
							if ((auxEmail.equals(textField_email.getText()))
									&& (auxPass.equals(textField_password.getText()))) {
								success = true;
							}
						}
						if (success) {
							frame.setVisible(false);
							Student s = slogic.studentInfoGivenEmail(textField_email.getText());
							sessionStudent = s;
							StudentView sview = new StudentView(sessionStudent);
							sview.textPane.setText(s.getName());
							}
						else {JOptionPane.showMessageDialog(null, "E-mail or password incorrect");}
					}
				}
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, "Log-in failed");
				}
			}
		});
		btnConnect.setBounds(159, 197, 109, 23);
		frame.getContentPane().add(btnConnect);
	}
}
