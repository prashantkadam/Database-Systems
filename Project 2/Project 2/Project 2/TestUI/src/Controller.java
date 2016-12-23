import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import model.database.dao.StudentRegistrationDAO;

/**
 * This class contains logic to handle all get requests.
 * 
 * @author PRASHANT
 * 
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * This method is used handle all doGet requests.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "showAllTables":
			getTableContents(request);
			RequestDispatcher rd = request
					.getRequestDispatcher("ViewTables.jsp");
			rd.forward(request, response);
			break;
		case "showStudentInfo1":
			response.sendRedirect("ShowStudentInfo1.jsp");
			break;
		case "showStudentInfo2":
			String bNumber = request.getParameter("txtBNumber");
			showStudentInfo(request, bNumber);
			RequestDispatcher rd1 = request
					.getRequestDispatcher("ShowStudentInfo2.jsp");
			rd1.forward(request, response);
			break;
		case "findPreq1":
			response.sendRedirect("FindPreq1.jsp");
			break;
		case "findPreq2":
			String deptCode = request.getParameter("txtDeptCode");
			Integer courseNumber = Integer.parseInt(request
					.getParameter("txtCourseNumber"));
			findPreq(request, deptCode, courseNumber);
			RequestDispatcher rd2 = request
					.getRequestDispatcher("FindPreq2.jsp");
			rd2.forward(request, response);
			break;
		case "showClassInfo1":
			response.sendRedirect("ShowClassInfo1.jsp");
			break;
		case "showClassInfo2":
			String classIdToSearch = request.getParameter("txtClassId");
			showClassInfo(request, classIdToSearch);
			RequestDispatcher rd5 = request
					.getRequestDispatcher("ShowClassInfo2.jsp");
			rd5.forward(request, response);
			break;
		case "enrollStudent1":
			response.sendRedirect("EnrollStudent1.jsp");
			break;
		case "enrollStudent2":
			String bNumberToEnroll = request.getParameter("txtBNumber");
			String classidToEnroll = request.getParameter("txtClassId");
			enrollStudent(request, bNumberToEnroll, classidToEnroll);
			RequestDispatcher rd3 = request
					.getRequestDispatcher("EnrollStudent2.jsp");
			rd3.forward(request, response);
			break;
		case "dropStudent1":
			response.sendRedirect("DropStudent1.jsp");
			break;
		case "dropStudent2":
			String bNummberToDrop = request.getParameter("txtBNumber");
			String classidToDropFrom = request.getParameter("txtClassId");
			dropStudent(request, bNummberToDrop, classidToDropFrom);
			RequestDispatcher rd4 = request
					.getRequestDispatcher("DropStudent2.jsp");
			rd4.forward(request, response);
			break;
		case "deleteStudent1":
			response.sendRedirect("DeleteStudent1.jsp");
			break;
		case "deleteStudent2":
			String bNumberTodelete = request.getParameter("txtBNumber");
			deleteStudent(request, bNumberTodelete);
			RequestDispatcher rd6 = request
					.getRequestDispatcher("DeleteStudent2.jsp");
			rd6.forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// Q5
	/**
	 * This method contains logic to retrieve information about class.
	 * 
	 * @param request
	 * @param classId
	 */
	private void showClassInfo(HttpServletRequest request, String classId) {
		try {
			StudentRegistrationDAO sdao = new StudentRegistrationDAO();
			List<ClassInformation> classInformationList = sdao
					.getClassInfo(classId);
			request.setAttribute("classInformationList", classInformationList);
		} catch (SQLException e) {

			request.setAttribute("msg", e.getMessage());
		}
	}

	// Q8
	/**
	 * This method contains logic to delete student from the database.
	 * 
	 * @param request
	 * @param bNumber
	 */
	private void deleteStudent(HttpServletRequest request, String bNumber) {
		try {
			StudentRegistrationDAO sdao = new StudentRegistrationDAO();
			sdao.deleteStudent(bNumber);
		} catch (SQLException e) {

			request.setAttribute("msg", e.getMessage());
		}
	}

	// Q7
	/**
	 * This method contains logic to drop student from a class.
	 * 
	 * @param request
	 * @param bNumber
	 * @param classId
	 */
	private void dropStudent(HttpServletRequest request, String bNumber,
			String classId) {
		try {
			StudentRegistrationDAO sdao = new StudentRegistrationDAO();
			String msg = sdao.dropStudentEnrollments(bNumber, classId);
			request.setAttribute("msg", msg);
		} catch (SQLException e) {

			request.setAttribute("msg", e.getMessage());
		}
	}

	// Q6
	/**
	 * This method contains logic to enroll student to a class.
	 * 
	 * @param request
	 * @param bNumber
	 * @param classId
	 */
	private void enrollStudent(HttpServletRequest request, String bNumber,
			String classId) {
		try {
			StudentRegistrationDAO sdao = new StudentRegistrationDAO();
			String msg = sdao.enrollStudent(bNumber, classId);
			request.setAttribute("msg", msg);
		} catch (SQLException e) {

			request.setAttribute("msg", e.getMessage());
		}
	}

	// Q4
	/**
	 * This method contains logic to retrieve multi-level dependent prerequisite
	 * courses.
	 * 
	 * @param request
	 * @param deptCode
	 * @param courseNumber
	 */
	private void findPreq(HttpServletRequest request, String deptCode,
			Integer courseNumber) {
		StudentRegistrationDAO sdao = new StudentRegistrationDAO();
		List<String> preqCourseList = sdao.findAllPrerequisitesCourses(
				deptCode, courseNumber);
		request.setAttribute("preqCourseList", preqCourseList);

	}

	// Q3
	/**
	 * This method contains logic to retrieve student information.
	 * 
	 * @param request
	 * @param bNumber
	 */
	private void showStudentInfo(HttpServletRequest request, String bNumber) {
		try {
			StudentRegistrationDAO sdao = new StudentRegistrationDAO();
			List<StudentClassInformation> studentClassList = sdao
					.getStudentInformation(bNumber);
			request.setAttribute("studentClassList", studentClassList);
		} catch (SQLException e) {

			request.setAttribute("msg", e.getMessage());
		}
	}

	/**
	 * This method is used to retrieve information about all tables in a
	 * database.
	 * 
	 * @param request
	 */
	// Q2
	private void getTableContents(HttpServletRequest request) {
		StudentRegistrationDAO sdao = new StudentRegistrationDAO();

		List<? extends Table> studentList = new ArrayList<StudentsTable>();
		studentList = sdao.getTableContents("students");
		request.setAttribute("studentList", studentList);

		List<? extends Table> classList = new ArrayList<ClassesTable>();
		classList = sdao.getTableContents("classes");
		request.setAttribute("classList", classList);

		List<? extends Table> enrollmentList = new ArrayList<EnrollmentsTable>();
		enrollmentList = sdao.getTableContents("enrollments");
		request.setAttribute("enrollmentList", enrollmentList);

		List<? extends Table> courseList = new ArrayList<CoursesTable>();
		courseList = sdao.getTableContents("courses");
		request.setAttribute("courseList", courseList);

		List<? extends Table> prerequisiteList = new ArrayList<PrerequisitesTable>();
		prerequisiteList = sdao.getTableContents("prerequisites");
		request.setAttribute("prerequisiteList", prerequisiteList);

		List<? extends Table> logList = new ArrayList<LogsTable>();
		logList = sdao.getTableContents("logs");
		request.setAttribute("logList", logList);

		List<? extends Table> gradeList = new ArrayList<GradesTable>();
		gradeList = sdao.getTableContents("grades");
		request.setAttribute("gradeList", gradeList);

		List<? extends Table> courseCreditList = new ArrayList<CourseCreditsTable>();
		courseCreditList = sdao.getTableContents("course_credit");
		request.setAttribute("courseCreditList", courseCreditList);
	}
}
