package entity;

public class Teacher {
	//attributes
	private int id;
	private String name;
	private String email;
	private String password;
	private Course course;
	//constructor
	public Teacher(String name, String email, String password, Course course) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.course = course;
	}
	//constructor with ID
	public Teacher(int iD, String name, String email, String password, Course course) {
		super();
		this.id = iD;
		this.name = name;
		this.email = email;
		this.password = password;
		this.course = course;
	}
	//constructor empty 
	public Teacher() {
		super();
	}
	//getters and setters
	public void setID(int id) {
		this.id=id;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
