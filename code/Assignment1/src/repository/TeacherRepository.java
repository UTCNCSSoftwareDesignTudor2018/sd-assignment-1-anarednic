package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import databaseConnection.dbConnection;
import entity.Teacher;
public class TeacherRepository {
	public void createTeacher(Teacher t) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement createquery = con.prepareStatement("INSERT INTO teacher(name,email,password) VALUES ('"
		+t.getName()+"', '"+t.getEmail()+"', '"+t.getPassword()+"')");
		createquery.executeUpdate();
	}
	public Teacher readTeacher(int id) throws Exception{
		Teacher teacher = new Teacher();
		Connection con = dbConnection.getConnection();
		PreparedStatement readquery = con.prepareStatement("SELECT * FROM teacher WHERE id="+id);
		ResultSet res = readquery.executeQuery();
		while (res.next()) {
			teacher.setID(res.getInt("id"));
			teacher.setName(res.getString("name"));
			teacher.setEmail(res.getString("email"));
			teacher.setPassword(res.getString("password"));
		}
		return teacher;
	}
	public void updateTeacher(Teacher t) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement updatequery = con.prepareStatement("UPDATE teacher SET name='"
		+t.getName()+"', email='"+t.getEmail()+"', password='"+t.getPassword()+"' WHERE id='"+t.getID()+"'");
		updatequery.execute();
	}
	public void deleteTeacher(final int id) throws Exception {
		Connection con = dbConnection.getConnection();
		PreparedStatement deletequery = con.prepareStatement("DELETE FROM teacher WHERE id="+id);
		deletequery.executeUpdate();
	}
	public ArrayList<String> viewAllTeachers() throws Exception{
		ArrayList<String> teachers = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement viewAllquery = con.prepareStatement("SELECT teacher.id, teacher.name FROM teacher");
		ResultSet res = viewAllquery.executeQuery();
		while(res.next()) {
			String name = res.getString("teacher.name");
			int id = res.getInt("teacher.id");
			teachers.add(id+" "+name);
		}
		return teachers;
	}
	public ArrayList<String> loginTeacherEmail() throws Exception{
		ArrayList<String> teacheremails = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement emailquery = con.prepareStatement("SELECT teacher.email FROM teacher");
		ResultSet res = emailquery.executeQuery();
		while(res.next()) {
			String email = res.getString("teacher.email");
			teacheremails.add(email);
		}
		return teacheremails;
	}
	public ArrayList<String> loginTeacherPassword() throws Exception{
		ArrayList<String> teacherpasswords = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement passwordquery = con.prepareStatement("SELECT teacher.password FROM teacher");
		ResultSet res = passwordquery.executeQuery();
		while(res.next()) {
			String password = res.getString("teacher.password");
			teacherpasswords.add(password);
		}
		return teacherpasswords;
	}
	public Teacher teacherInfoGivenEmail(String emailGiven) throws Exception{
		Connection con = dbConnection.getConnection();
		Teacher teacher = new Teacher();
		PreparedStatement infoquery = con.prepareStatement("SELECT * FROM teacher WHERE email='"+emailGiven+"'");
		ResultSet res = infoquery.executeQuery();
		while(res.next()) {
			teacher.setID(res.getInt("id"));
			teacher.setName(res.getString("name"));
			teacher.setEmail(res.getString("email"));
			teacher.setPassword(res.getString("password"));
		}
		return teacher;
	}
}
