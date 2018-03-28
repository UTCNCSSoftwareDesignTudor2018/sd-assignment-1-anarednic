package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import databaseConnection.dbConnection;
import entity.Student;

public class StudentRepository {
	public void createStudent(Student student) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement createquery = con.prepareStatement("INSERT INTO student(name,cnp,email,password,identificationNr,studentGroup) VALUES ('"
		+student.getName()+"', '"+student.getCNP()+"', '"+student.getEmail()+"', '"+student.getPassword()+"', '"
		+student.getIdentificationNr()+"', '"+student.getGroup()+"')");
		createquery.executeUpdate();
	}
	public Student readStudent(int id) throws Exception{
		Student student = new Student();
		Connection con = dbConnection.getConnection();
		PreparedStatement readquery = con.prepareStatement("SELECT * FROM student WHERE id="+id);
		ResultSet res = readquery.executeQuery();
		while (res.next()) {
			student.setId(res.getInt("id"));
			student.setName(res.getString("name"));
			student.setCNP(res.getString("cnp"));
			student.setEmail(res.getString("email"));
			student.setPassword(res.getString("password"));
			student.setIdentificationNr(res.getString("identificationNr"));
			student.setGroup(res.getString("studentGroup"));
		}
		return student;
	}
	public void updateStudent(Student student2) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement updatequery = con.prepareStatement("UPDATE student SET name='"
		+student2.getName()+"', cnp='"+student2.getCNP()+"', email='"+student2.getEmail()+"', password='"+student2.getPassword()
		+"', identificationNr='"+student2.getIdentificationNr()+"', studentGroup='"+student2.getGroup()+"' WHERE id="+student2.getID());
		updatequery.executeUpdate();
	}
	public void deleteStudent(final int id) throws Exception {
		Connection con = dbConnection.getConnection();
		PreparedStatement deletequery = con.prepareStatement("DELETE FROM student WHERE id="+id);
		deletequery.executeUpdate();
	}
	public ArrayList<String> viewAllStudents() throws Exception{
		ArrayList<String> students = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement viewAllquery = con.prepareStatement("SELECT student.id, student.name, student.studentGroup FROM student");
		ResultSet res = viewAllquery.executeQuery();
		while(res.next()) {
			String name = res.getString("student.name");
			String group = res.getString("student.studentGroup");
			int id=res.getInt("student.id");
			students.add(id+" "+name+" "+group);
		}
		return students;
	}
	public ArrayList<String> loginStudentEmail() throws Exception{
		ArrayList<String> studentemails = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement emailquery = con.prepareStatement("SELECT student.email FROM student");
		ResultSet res = emailquery.executeQuery();
		while(res.next()) {
			String email = res.getString("student.email");
			studentemails.add(email);
		}
		return studentemails;
	}
	public ArrayList<String> loginStudentPassword() throws Exception{
		ArrayList<String> studentpasswords = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement passwordquery = con.prepareStatement("SELECT student.password FROM student");
		ResultSet res = passwordquery.executeQuery();
		while(res.next()) {
			String password = res.getString("student.password");
			studentpasswords.add(password);
		}
		return studentpasswords;
	}
	public Student studentInfoGivenEmail(String emailGiven) throws Exception{
		Connection con = dbConnection.getConnection();
		Student student = new Student();
		PreparedStatement infoquery = con.prepareStatement("SELECT * FROM student WHERE email='"+emailGiven+"'");
		ResultSet res = infoquery.executeQuery();
		while(res.next()) {
			student.setId(res.getInt("id"));
			student.setName(res.getString("name"));
			student.setEmail(res.getString("email"));
			student.setPassword(res.getString("password"));
			student.setCNP(res.getString("cnp"));
			student.setIdentificationNr(res.getString("identificationNr"));
			student.setGroup(res.getString("studentGroup"));
		}
		return student;
	}
}
