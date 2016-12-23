package model.beans;

public class StudentClassInformation {
	private String classid = null;
	private String deptCode = null;
	private Integer courseNumber = null;
	private Integer sectionNumber = null;
	private Integer year = null;
	private String semester = null;
	private String lGrade = null;
	private String nGrade = null;

	public StudentClassInformation(String classid, String deptCode, Integer courseNumber, Integer sectionNumber,
			Integer year, String semester, String lGrade, String nGrade) {
		super();
		this.classid = classid;
		this.deptCode = deptCode;
		this.courseNumber = courseNumber;
		this.sectionNumber = sectionNumber;
		this.year = year;
		this.semester = semester;
		this.lGrade = lGrade;
		this.nGrade = nGrade;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public Integer getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(Integer sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getlGrade() {
		return lGrade;
	}

	public void setlGrade(String lGrade) {
		this.lGrade = lGrade;
	}

	public String getnGrade() {
		return nGrade;
	}

	public void setnGrade(String nGrade) {
		this.nGrade = nGrade;
	}

	@Override
	public String toString() {
		return "StudentClassInformation [classid=" + classid + ", deptCode=" + deptCode + ", courseNumber="
				+ courseNumber + ", sectionNumber=" + sectionNumber + ", year=" + year + ", semester=" + semester
				+ ", lGrade=" + lGrade + ", nGrade=" + nGrade + "]";
	}
}
