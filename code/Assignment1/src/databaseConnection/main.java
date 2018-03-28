package databaseConnection;

import java.sql.Connection;
import presentation.LoginFrame;

public class main {

	public static void main(String[] args) {
		dbConnection db=new dbConnection();
		try {
			Connection con = db.getConnection();
			//db.createTable();
			new LoginFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
