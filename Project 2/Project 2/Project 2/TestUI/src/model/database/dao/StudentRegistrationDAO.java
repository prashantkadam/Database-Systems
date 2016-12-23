package model.database.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.ClassInformation;
import model.beans.ClassesTable;
import model.beans.CourseCreditsTable;
import model.beans.CoursesTable;
import model.beans.EnrollmentsTable;
import model.beans.GradesTable;
import model.beans.LogsTable;
import model.beans.PrerequisitesTable;
import model.beans.StudentClassInformation;
import model.beans.StudentsTable;
import model.beans.Table;
import model.database.DataStore;
import oracle.jdbc.OracleTypes;

/**
 * This class contains logic to communicate with database and map retreived
 * information to Data Transfer objects.
 * 
 * @author PRASHANT
 * 
 */
public class StudentRegistrationDAO {

	// Q2
	/**
	 * This method contain logic to execute database procedure
	 * 'proc_show_all_tables'
	 * 
	 * @param tableName
	 *            table name whose contents are to be retrieved.
	 * @return List of tuples in a database table.
	 */
	public List<? extends Table> getTableContents(String tableName) {
		// Prepare to call stored procedure:
		List<? extends Table> table = null;
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.proc_show_all_tables(?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, tableName);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			ds.executeCallableStatement(callableStatement);
			ResultSet rs = (ResultSet) callableStatement.getObject(2);
			switch (tableName) {
			case "students":
				List<StudentsTable> students = new ArrayList<StudentsTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					StudentsTable studentEntry = new StudentsTable(
							rs.getString("B#"), rs.getString("FIRSTNAME"),
							rs.getString("LASTNAME"), rs.getString("STATUS"),
							rs.getFloat("GPA"), rs.getString("EMAIL"),
							rs.getDate("BDATE"), rs.getString("DEPTNAME"));
					students.add(studentEntry);
				}
				table = new ArrayList<StudentsTable>(students);
				break;
			case "classes":
				List<ClassesTable> classes = new ArrayList<ClassesTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					ClassesTable classEntry = new ClassesTable(
							rs.getString("CLASSID"), rs.getString("DEPT_CODE"),
							rs.getInt("COURSE#"), rs.getInt("SECT#"),
							rs.getInt("YEAR"), rs.getString("SEMESTER"),
							rs.getInt("LIMIT"), rs.getInt("CLASS_SIZE"));
					classes.add(classEntry);
				}
				table = new ArrayList<ClassesTable>(classes);
				break;
			case "enrollments":
				List<EnrollmentsTable> enrollments = new ArrayList<EnrollmentsTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					EnrollmentsTable enrollmentsEntry = new EnrollmentsTable(
							rs.getString("B#"), rs.getString("CLASSID"),
							rs.getString("LGRADE"));
					enrollments.add(enrollmentsEntry);
				}
				table = new ArrayList<EnrollmentsTable>(enrollments);
				break;
			case "courses":
				List<CoursesTable> courses = new ArrayList<CoursesTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					CoursesTable coursesEntry = new CoursesTable(
							rs.getString("DEPT_CODE"), rs.getInt("COURSE#"),
							rs.getString("TITLE"));
					courses.add(coursesEntry);
				}
				table = new ArrayList<CoursesTable>(courses);
				break;
			case "grades":
				List<GradesTable> grades = new ArrayList<GradesTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					GradesTable gradesEntry = new GradesTable(
							rs.getString("LGRADE"), rs.getInt("NGRADE"));
					grades.add(gradesEntry);
				}
				table = new ArrayList<GradesTable>(grades);
				break;
			case "course_credit":
				List<CourseCreditsTable> courseCredits = new ArrayList<CourseCreditsTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					CourseCreditsTable courseCreditsEntry = new CourseCreditsTable(
							rs.getInt("COURSE#"), rs.getInt("CREDITS"));
					courseCredits.add(courseCreditsEntry);
				}
				table = new ArrayList<CourseCreditsTable>(courseCredits);
				break;
			case "prerequisites":
				List<PrerequisitesTable> Prerequisites = new ArrayList<PrerequisitesTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					PrerequisitesTable PrerequisitesEntry = new PrerequisitesTable(
							rs.getString("DEPT_CODE"), rs.getInt("COURSE#"),
							rs.getString("PRE_DEPT_CODE"),
							rs.getInt("PRE_COURSE#"));
					Prerequisites.add(PrerequisitesEntry);
				}
				table = new ArrayList<PrerequisitesTable>(Prerequisites);
				break;
			case "logs":
				List<LogsTable> logs = new ArrayList<LogsTable>();
				while (rs.next()) {
					// table = new ArrayList<StudentsTable>();
					LogsTable LogsEntry = new LogsTable(rs.getInt("LOGID"),
							rs.getString("WHO"), rs.getDate("TIME"),
							rs.getString("TABLE_NAME"),
							rs.getString("OPERATION"),
							rs.getString("KEY_VALUE"));
					logs.add(LogsEntry);
				}
				table = new ArrayList<LogsTable>(logs);
				break;
			default:
				throw new IllegalArgumentException();
			}
			// close the result set, statement, and the connection

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}

	// Q3
	/**
	 * This method contain logic to execute database procedure
	 * 'proc_show_student_info'
	 * 
	 * @param bNumber
	 *            bNumber of a student
	 * @return student information.
	 * @throws SQLException
	 *             error returned from the database
	 */
	public List<StudentClassInformation> getStudentInformation(String bNumber)
			throws SQLException {
		List<StudentClassInformation> studentInformationList = new ArrayList<StudentClassInformation>();
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.proc_show_student_info(?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, bNumber);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			ds.executeCallableStatement(callableStatement);
			ResultSet rs = (ResultSet) callableStatement.getObject(2);
			while (rs.next()) {
				StudentClassInformation studentInformation = new StudentClassInformation(
						rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8));
				studentInformationList.add(studentInformation);
			}
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 20001) {
				System.out.println("The B# is invalid.");
				throw new SQLException("The B# is invalid.");
			}
			if (exception.getErrorCode() == 20002) {
				System.out.println("The student has not taken any course.");
				throw new SQLException("The student has not taken any course.");
			}

		}
		return studentInformationList;
	}

	// Q4
	/**
	 * This method contain logic to execute database procedure
	 * 'proc_find_dependent_courses'
	 * 
	 * @param deptCode
	 *            department code.
	 * @param courseNumber
	 *            course number.
	 * @return List of dependent courses.
	 */
	public List<String> findAllPrerequisitesCourses(String deptCode,
			Integer courseNumber) {
		List<String> courseList = new ArrayList<String>();
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.proc_find_dependent_courses(?, ?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, deptCode);
			callableStatement.setInt(2, courseNumber);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			ds.executeCallableStatement(callableStatement);
			ResultSet rs = (ResultSet) callableStatement.getObject(3);
			while (rs.next()) {
				String course = rs.getString(1);
				courseList.add(course);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return courseList;
	}

	// Q5
	/**
	 * This method contain logic to execute database procedure
	 * 'proc_show_class_details'
	 * 
	 * @param classId
	 *            class id.
	 * @return class information
	 * @throws SQLException
	 *             error returned from the database.
	 */
	public List<ClassInformation> getClassInfo(String classId)
			throws SQLException {
		List<ClassInformation> classInformationList = new ArrayList<ClassInformation>();
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.proc_show_class_details(?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, classId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			ds.executeCallableStatement(callableStatement);

			ResultSet rs = (ResultSet) callableStatement.getObject(2);
			while (rs.next()) {
				ClassInformation classInformation = new ClassInformation(
						rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));

				classInformationList.add(classInformation);
			}
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 20001) {
				System.out.println("The classid is invalid.");
				throw new SQLException("The classid is invalid.");
			}
			if (exception.getErrorCode() == 20002) {
				System.out.println("No student has enrolled in the class.");
				throw new SQLException("No student has enrolled in the class.");
			}
		}
		return classInformationList;
	}

	// Q6
	/**
	 * This method contain logic to execute database procedure
	 * 'proc_show_class_details'
	 * 
	 * @param bNumber
	 *            bNumber of a student
	 * @param classId
	 *            class id to enroll in
	 * @return warning message returned from database if any.
	 * @throws SQLException
	 *             error returned from database.
	 */
	public String enrollStudent(String bNumber, String classId)
			throws SQLException {
		String msg = "";
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.enroll_student(?, ?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, bNumber);
			callableStatement.setString(2, classId);
			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			ds.executeCallableStatement(callableStatement);
			if (callableStatement.getObject(3) != null)
				msg = callableStatement.getObject(3).toString();
			System.out.println("msg:::: " + msg);
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 20001) {
				System.out.println("The B# number is invalid.");
				throw new SQLException("The B# number is invalid.");
			}
			if (exception.getErrorCode() == 20002) {
				System.out.println("The classid is invalid.");
				throw new SQLException("The classid is invalid.");
			}
			if (exception.getErrorCode() == 20003) {
				System.out.println("The student is already in the class.");
				throw new SQLException("The student is already in the class.");
			}
			if (exception.getErrorCode() == 20004) {
				System.out
						.println("Students cannot be enrolled in more than four classes in the same semester.");
				throw new SQLException(
						"Students cannot be enrolled in more than four classes in the same semester.");
			}
			if (exception.getErrorCode() == 20005) {
				System.out.println("Prerequisite not satisfied.");
				throw new SQLException("Prerequisite not satisfied.");
			}
			if (exception.getErrorCode() == 20008) {
				System.out.println("The class is full.");
				throw new SQLException("The class is full.");
			}
		}
		return msg;
	}

	// Q7
	/**
	 * This method contain logic to execute database procedure
	 * 'PROC_DELETE_ENROLLMENT'
	 * 
	 * @param bNumber
	 *            bNumber of a student.
	 * @param classId
	 *            class id to drop from.
	 * @return warning message returned from database if any.
	 * @throws SQLException
	 *             error returned from database.
	 */
	public String dropStudentEnrollments(String bNumber, String classId)
			throws SQLException {
		String msg = "";

		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.PROC_DELETE_ENROLLMENT(?, ?, ?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, bNumber);
			callableStatement.setString(2, classId);
			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			ds.executeCallableStatement(callableStatement);
			if (callableStatement.getObject(3) != null)
				msg = callableStatement.getObject(3).toString();
			System.out.println("msg:::: " + msg);
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 20001) {
				System.out.println("The classid is invalid.");
				throw new SQLException("The classid is invalid.");
			}
			if (exception.getErrorCode() == 20002) {
				System.out.println("The B# is invalid.");
				throw new SQLException("The B# is invalid..");
			}
			if (exception.getErrorCode() == 20003) {
				System.out.println("The student is not enrolled in the class.");
				throw new SQLException(
						"The student is not enrolled in the class.");
			}
			if (exception.getErrorCode() == 20004) {
				System.out
						.println("The drop is not permitted because another class uses it as a prerequisite.");
				throw new SQLException(
						"The drop is not permitted because another class uses it as a prerequisite.");
			}
		}
		return msg;
	}

	// Q8
	/**
	 * This method contain logic to execute database procedure
	 * 'PROC_DELETE_STUDENT'
	 * 
	 * @param bNumber
	 *            bNumber of a student.
	 * @throws SQLException
	 *             error returned from a database.
	 */
	public void deleteStudent(String bNumber) throws SQLException {
		try (DataStore ds = new DataStore()) {
			String callableQuery = "{call PACKAGE_SRS.PROC_DELETE_STUDENT(?)}";
			CallableStatement callableStatement = ds.prepareCall(callableQuery);
			callableStatement.setString(1, bNumber);
			ds.executeCallableStatement(callableStatement);
		} catch (SQLException exception) {
			if (exception.getErrorCode() == 20001) {
				System.out.println("The classid is invalid.");
				throw new SQLException("The classid is invalid.");
			}
			if (exception.getErrorCode() == 20002) {
				System.out.println("The B# is invalid.");
				throw new SQLException("The B# is invalid.");
			}
			if (exception.getErrorCode() == 20003) {
				System.out.println("The student is not enrolled in the class.");
				throw new SQLException(
						"The student is not enrolled in the class.");
			}
			if (exception.getErrorCode() == 20004) {
				System.out
						.println("The drop is not permitted because another class uses it as a prerequisite.");
				throw new SQLException(
						"The drop is not permitted because another class uses it as a prerequisite.");
			}
		}
	}
}
