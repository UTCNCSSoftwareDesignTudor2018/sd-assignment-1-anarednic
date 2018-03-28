package businessLogic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import databaseConnection.dbConnection;
import entity.Course;
import entity.Enrolment;
import entity.Student;
import repository.StudentRepository;

public class StudentLogic {
	StudentRepository studentRepo = new StudentRepository();
	EnrolmentLogic elogic = new EnrolmentLogic();
	public void addStudent(Student s) throws Exception {
		studentRepo.createStudent(s);
	}
	public Student viewStudent(int id) throws Exception{
		return studentRepo.readStudent(id);
	}
	public void updateStudent(Student s) throws Exception{
		studentRepo.updateStudent(s);
	}
	public void deleteStudent(int id) throws Exception{
		studentRepo.deleteStudent(id);
	}
	public ArrayList<String> viewAllStudents() throws Exception{
		return studentRepo.viewAllStudents();
	}
	public Student studentInfoGivenEmail(String email) throws Exception {
		return studentRepo.studentInfoGivenEmail(email);
	}
	public ArrayList<String> coursesAndGrades(int studentID){
		ArrayList<String> cg=new ArrayList<String>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement cgquery=con.prepareStatement("select course.name, enrolment.grade from course "
					+ "join enrolment on course.id=enrolment.idCourse "
					+ "join student on enrolment.idStudent=student.id where student.id="+studentID);
			ResultSet res=cgquery.executeQuery();
			while(res.next()) {
				String course=res.getString("course.name");
				int grade=res.getInt("enrolment.grade");
				cg.add(course+" "+grade);
			}
		} catch (Exception e) {}
		return cg;
	}
	public ArrayList<String> availableCourses(int studentID){
		ArrayList<String> cg=new ArrayList<String>();
		try {
			Connection con = dbConnection.getConnection();
			PreparedStatement cgquery=con.prepareStatement("select course.id, course.name from course "
					+ "where id not in (select course.id from course "
					+ "join enrolment on course.id=enrolment.idCourse "
					+ "join student on enrolment.idStudent=student.id where student.id="+studentID+")");
			ResultSet res=cgquery.executeQuery();
			while(res.next()) {
				int id=res.getInt("course.id");
				String course=res.getString("course.name");
				cg.add(id+" "+course);
			}
		} catch (Exception e) {}
		return cg;
	}
	public void enrolStudent(Student s, Course c) throws Exception {
		Enrolment e=new Enrolment(s,c,-1);
		elogic.addGrade(e);
	}
}
