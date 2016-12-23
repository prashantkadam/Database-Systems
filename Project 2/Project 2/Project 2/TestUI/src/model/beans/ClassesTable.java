package model.beans;

public class ClassesTable extends Table {

	private String classId = null;
	private String deptCode = null;
	private Integer courseNumber = null;
	private Integer sectionNumber = null;
	private Integer year = null;
	private String semester = null;
	private Integer limit = null;
	private Integer classSize = null;

	public ClassesTable(String classId, String deptCode, Integer courseNumber, Integer sectionNumber, Integer year,
			String semester, Integer limit, Integer classSize) {
		super();
		this.classId = classId;
		this.deptCode = deptCode;
		this.courseNumber = courseNumber;
		this.sectionNumber = sectionNumber;
		this.year = year;
		this.semester = semester;
		this.limit = limit;
		this.classSize = classSize;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getClassSize() {
		return classSize;
	}

	public void setClassSize(Integer classSize) {
		this.classSize = classSize;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ClassesTable [deptCode=" + deptCode + ", courseNumber=" + courseNumber + ", sectionNumber="
				+ sectionNumber + ", year=" + year + ", semester=" + semester + ", limit=" + limit + ", classSize="
				+ classSize + "]";
	}
}
