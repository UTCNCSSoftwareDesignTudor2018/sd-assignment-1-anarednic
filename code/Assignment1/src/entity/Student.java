package entity;

import java.util.List;

public class Student {
	//attributes
	private int id;
	private String name;
	private String cnp;
	private String email;
	private String password;
	private String identificationNr;
	private String group;
	private List <Enrolment> enrolments;
	//constructor
	public Student(String name, String cNP, String email, String password, String identificationNr,
			String group, List<Enrolment> enrolments) {
		super();
		this.name = name;
		this.cnp = cNP;
		this.email = email;
		this.password = password;
		this.identificationNr = identificationNr;
		this.group = group;
		this.enrolments = enrolments;
	}
	//constructor with ID
	public Student(int id, String name, String cNP, String email, String password, String identificationNr,
			String group, List<Enrolment> enrolments) {
		super();
		this.id=id;
		this.name = name;
		this.cnp = cNP;
		this.email = email;
		this.password = password;
		this.identificationNr = identificationNr;
		this.group = group;
		this.enrolments = enrolments;
	}
	//constructor empty
	public Student() {
		super();
	}
	//getters and setters
	public String getCNP() {
		return cnp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCNP(String cNP) {
		cnp = cNP;
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
	public String getIdentificationNr() {
		return identificationNr;
	}
	public void setIdentificationNr(String identificationNr) {
		this.identificationNr = identificationNr;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<Enrolment> getEnrolments() {
		return enrolments;
	}
	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cnp=" + cnp + ", email=" + email + ", password=" + password
				+ ", identificationNr=" + identificationNr + ", group=" + group + ", enrolments=" + enrolments + "]";
	}
	
}
