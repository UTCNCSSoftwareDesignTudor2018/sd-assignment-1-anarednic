package databaseConnection;

//import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbConnection {
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/assignment1";
			String username = "root";
			String password = "anarednic";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTED TO DATABASE");
			return conn;
		} catch (Exception e) {
			System.out.println("CAN'T ESTABLISH CONNECTION");
		}
		return null;
	}

	public static void createTable() throws Exception {
		Connection con = getConnection();
		try {
			
			PreparedStatement createStudents = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS student("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "name varchar(255) NOT NULL, "
					+ "cnp varchar(10), "
					+ "email varchar(255) NOT NULL, "
					+ "password varchar(255) NOT NULL, "
					+ "identificationNr varchar(255) NOT NULL, "
					+ "studentGroup varchar(255) NOT NULL, "
					+ "PRIMARY KEY(id))");
			PreparedStatement createTeacher = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS teacher("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "name varchar(255) NOT NULL, "
					+ "email varchar(255) NOT NULL, "
					+ "password varchar(255) NOT NULL, "
					+ "idCourse int, "
					+ "PRIMARY KEY(id))");
			PreparedStatement createCourses = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS course("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "name varchar(255) NOT NULL, "
					+ "PRIMARY KEY(id))");
			PreparedStatement createEnrolment = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS enrolment("
					+ "id int NOT NULL AUTO_INCREMENT, "
					+ "idStudent int, "
					+ "idCourse int, "
					+ "grade int, "
					+ "PRIMARY KEY(id))");
					
			createCourses.executeUpdate();
			createStudents.executeUpdate();
			createEnrolment.executeUpdate();
			createTeacher.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		   /*PreparedStatement fk_teachercourse = con.prepareStatement("ALTER TABLE teacher "
		   		+ "ADD CONSTRAINT fk_teachercourse FOREIGN KEY (idCourse) REFERENCES course(id)");
		   fk_teachercourse.executeUpdate();
		   PreparedStatement fk_courseenrolment = con.prepareStatement("ALTER TABLE enrolment "
		   		+ "ADD CONSTRAINT fk_courseenrolment FOREIGN KEY (idCourse) REFERENCES course(id)");
		   fk_courseenrolment.executeUpdate();
		   PreparedStatement fk_studentenrolment = con.prepareStatement("ALTER TABLE enrolment "
		   		+ "ADD CONSTRAINT fk_studentenrolment FOREIGN KEY (idStudent) REFERENCES student(id)");
		   fk_studentenrolment.executeUpdate();*/
			System.out.println("SUCCESSFULLY CREATED TABLES");
		}
	}
}
