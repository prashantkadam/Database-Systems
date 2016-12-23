package model.driver;

import model.database.DataStore;
import model.database.dao.StudentRegistrationDAO;

public class Driver {
	public static void main(String[] args) {
		DataStore mysql = new DataStore();
		StudentRegistrationDAO registrationDAO = new StudentRegistrationDAO();
		System.out.println(registrationDAO.findAllPrerequisitesCourses("CS", 432));
	}
}
