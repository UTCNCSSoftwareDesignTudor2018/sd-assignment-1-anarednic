package entity;

public class Enrolment {
	//attributes
	private int id;
	private Student student;
	private Course course;
	private int grade;
	//constructor
	public Enrolment(Student student, Course course, int grade) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
	//constructor with ID
	public Enrolment(int iD, Student student, Course course, int grade) {
		super();
		this.id = iD;
		this.student = student;
		this.course = course;
		this.grade = grade;
	}
	//constructor empty
	public Enrolment() {
		super();
	}
	//getters and setters
	public int getID() {
		return id;
	}
	public void setID(int iD) {
		id = iD;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
