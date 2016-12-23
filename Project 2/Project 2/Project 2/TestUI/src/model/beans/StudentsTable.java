package model.beans;

import java.sql.Date;

public class StudentsTable extends Table {

	private String bNumber = null;
	private String firstName = null;
	private String lastName = null;
	private String status = null;
	private Float gpa = null;
	private String email = null;
	private Date bDate = null;
	private String deptName = null;

	public StudentsTable(String bNumber, String firstName, String lastName, String status, Float number, String email,
			Date bDate, String deptName) {
		super();
		this.bNumber = bNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
		this.gpa = number;
		this.email = email;
		this.bDate = bDate;
		this.deptName = deptName;
	}

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "StudentsTable [bNumber=" + bNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", status="
				+ status + ", gpa=" + gpa + ", email=" + email + ", bDate=" + bDate + ", deptName=" + deptName + "]";
	}
}
