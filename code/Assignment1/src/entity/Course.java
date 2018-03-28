package entity;

import java.util.List;

public class Course {
	//attributes
	private int id;
	private String name;
	private Teacher teacher;
	private List<Enrolment> enrolments;
	//constructor
	public Course(String name, Teacher teacher, List<Enrolment> enrolments) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.enrolments = enrolments;
	}
	//constructor with ID
	public Course(int iD, String name, Teacher teacher, List<Enrolment> enrolments) {
		super();
		this.id = iD;
		this.name = name;
		this.teacher = teacher;
		this.enrolments = enrolments;
	}
	//empty constructor
	public Course() {
		super();
	}
	//getters and setters
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Enrolment> getEnrolments() {
		return enrolments;
	}
	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}
}
