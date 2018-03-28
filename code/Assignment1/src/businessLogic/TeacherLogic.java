package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import databaseConnection.dbConnection;
import entity.Teacher;
import repository.TeacherRepository;

public class TeacherLogic {
	public TeacherRepository trepo = new TeacherRepository();
	
	public void addNewTeacher(Teacher t) throws Exception {
		trepo.createTeacher(t);
	}
	public Teacher viewTeacher(int id) throws Exception{
		return trepo.readTeacher(id);
	}
	public void updateTeacher(Teacher s) throws Exception{
		trepo.updateTeacher(s);
	}
	public void deleteTeacher(int id) throws Exception{
		trepo.deleteTeacher(id);
	}
	public ArrayList<String> viewAllTeachers() throws Exception{
		return trepo.viewAllTeachers();
	}
	public Teacher teacherInfoGivenEmail(String email) throws Exception {
		return trepo.teacherInfoGivenEmail(email);
	}
	
	public ArrayList<String> studentsOfATeacher(int teacherID){
		ArrayList<String> students = new ArrayList<String>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement studentsquery = con.prepareStatement("SELECT student.name, student.studentGroup FROM student "
					+ "JOIN enrolment ON student.id = enrolment.idStudent "
					+ "JOIN teacher ON enrolment.idCourse=teacher.idCourse WHERE teacher.id = "+teacherID);
			ResultSet res = studentsquery.executeQuery();
			while (res.next()) {
				String student_name=res.getString("student.name");
				String student_group=res.getString("student.studentGroup");
				String finalres=student_name+" "+student_group;
				students.add(finalres);
			}
		}
		catch (Exception e){
		}
		return students;
	}
	public ArrayList<String> gradesOfATeacher(int teacherID){
		ArrayList<String> grades = new ArrayList<String>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement gradesquery = con.prepareStatement("SELECT student.name, enrolment.grade FROM student " + 
					"JOIN enrolment ON student.id=enrolment.idStudent " + 
					"JOIN teacher ON enrolment.idCourse=teacher.idCourse WHERE teacher.id="+teacherID);
			ResultSet res = gradesquery.executeQuery();
			while (res.next()) {
				String name=res.getString("student.name");
				String grade=res.getString("enrolment.grade");
				String finalres=name+" "+grade;
				grades.add(finalres);
			}
		}
		catch(Exception e) {
		}
		return grades;
	}
}
