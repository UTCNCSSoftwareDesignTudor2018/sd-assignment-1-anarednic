package businessLogic;

import java.util.ArrayList;

import entity.Course;
import repository.CourseRepository;

public class CourseLogic {
	public CourseRepository crepo = new CourseRepository();
	public void addNewCourse(Course c) throws Exception {
		crepo.createCourse(c);
	}
	public Course viewCourse(int id) throws Exception {
		return crepo.readCourse(id);
	}
	public void updateCourse(Course c) throws Exception {
		crepo.updateCourse(c);
	}
	public void deleteCourse(int id) throws Exception {
		crepo.deleteCourse(id);
	}
	public ArrayList<String> viewAllCourses() throws Exception{
		return crepo.viewAllCourses();
	}
}
