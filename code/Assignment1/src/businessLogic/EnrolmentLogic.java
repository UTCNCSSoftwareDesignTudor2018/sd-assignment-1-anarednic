package businessLogic;

import entity.Enrolment;
import repository.EnrolmentRepository;

public class EnrolmentLogic {
public EnrolmentRepository erepo = new EnrolmentRepository();
	
	public void addGrade(Enrolment e) throws Exception {
		erepo.createEnrolment(e);
	}
	public Enrolment viewGrade(int id) throws Exception{
		return erepo.readEnrolment(id);
	}
	public void updateGrade(Enrolment e) throws Exception{
		erepo.updateEnrolment(e);
	}
	public void deleteGrade(int id) throws Exception{
		erepo.deleteEnrolment(id);
	}
}
