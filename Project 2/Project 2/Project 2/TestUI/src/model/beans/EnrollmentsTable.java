package model.beans;

public class EnrollmentsTable extends Table {
	private String bNumber = null;
	private String classId = null;
	private String lGrade = null;

	public EnrollmentsTable(String bNumber, String classId, String lGrade) {
		super();
		this.bNumber = bNumber;
		this.classId = classId;
		this.lGrade = lGrade;
	}

	public String getbNumber() {
		return bNumber;
	}

	public void setbNumber(String bNumber) {
		this.bNumber = bNumber;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getlGrade() {
		return lGrade;
	}

	public void setlGrade(String lGrade) {
		this.lGrade = lGrade;
	}

	@Override
	public String toString() {
		return "Enrollments [bNumber=" + bNumber + ", classId=" + classId + ", lGrade=" + lGrade + "]";
	}
}
