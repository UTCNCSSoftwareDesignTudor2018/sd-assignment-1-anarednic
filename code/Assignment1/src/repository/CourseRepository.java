package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import databaseConnection.dbConnection;
import entity.Course;
public class CourseRepository {
	public void createCourse(Course c) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement createquery = con.prepareStatement("INSERT INTO course(name) VALUES ('"
		+c.getName()+"')");
		createquery.executeUpdate();
	}
	public Course readCourse(int id) throws Exception{
		Course course = new Course();
		Connection con = dbConnection.getConnection();
		PreparedStatement readquery = con.prepareStatement("SELECT * FROM course WHERE id="+id);
		ResultSet res = readquery.executeQuery();
		while (res.next()) {
			course.setID(res.getInt("id"));
			course.setName(res.getString("name"));
		}
		return course;
	}
	public void updateCourse(Course c) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement updatequery = con.prepareStatement("UPDATE course SET name='"
		+c.getName()+"' WHERE id="+c.getID());
		updatequery.executeUpdate();
		System.out.println(c.toString());
		System.out.println("Course: "+c.getName()+" was updated");
	}
	public void deleteCourse(final int id) throws Exception {
		Connection con = dbConnection.getConnection();
		PreparedStatement deletequery = con.prepareStatement("DELETE FROM course WHERE id="+id);
		deletequery.executeUpdate();
	}
	public ArrayList<String> viewAllCourses() throws Exception{
		ArrayList<String> courses = new ArrayList<String>();
		Connection con = dbConnection.getConnection();
		PreparedStatement viewAllquery = con.prepareStatement("SELECT course.id, course.name FROM course");
		ResultSet res = viewAllquery.executeQuery();
		while(res.next()) {
			String name = res.getString("course.name");
			String id = res.getString("course.id");
			courses.add(id+" "+name);
		}
		return courses;
	}
}
