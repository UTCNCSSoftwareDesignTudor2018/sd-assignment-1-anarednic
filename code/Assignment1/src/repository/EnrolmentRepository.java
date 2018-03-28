package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import databaseConnection.dbConnection;
import entity.Enrolment;
public class EnrolmentRepository {
	public void createEnrolment(Enrolment e) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement createquery = con.prepareStatement("INSERT INTO enrolment(idStudent, idCourse, grade) VALUES ('"
		+e.getStudent().getID()+"', '"+e.getCourse().getID()+"', '"+e.getGrade()+"')");
		createquery.executeUpdate();
	}
	public Enrolment readEnrolment(int id) throws Exception{
		Enrolment enrolment = new Enrolment();
		Connection con = dbConnection.getConnection();
		PreparedStatement readquery = con.prepareStatement("SELECT * FROM enrolment WHERE id="+id);
		ResultSet res = readquery.executeQuery();
		while (res.next()) {
			enrolment.setGrade(res.getInt("grade"));
		}
		return enrolment;
	}
	public void updateEnrolment(Enrolment e) throws Exception{
		Connection con = dbConnection.getConnection();
		PreparedStatement updatequery = con.prepareStatement("UPDATE enrolment SET name='"
		+e.getGrade()+"' WHERE id="+e.getID());
		updatequery.executeUpdate();
		System.out.println(e.toString());
		System.out.println("Enrolment: "+e.getID()+" was updated");
	}
	public void deleteEnrolment(final int id) throws Exception {
		Connection con = dbConnection.getConnection();
		PreparedStatement deletequery = con.prepareStatement("DELETE FROM enrolment WHERE id="+id);
		deletequery.executeUpdate();
	}
}
