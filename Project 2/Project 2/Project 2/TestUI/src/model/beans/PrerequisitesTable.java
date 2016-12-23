package model.beans;

public class PrerequisitesTable extends Table {
	private String deptCode = null;
	private Integer courseNumber = null;
	private String preDeptCode = null;
	private Integer preCourseNumber = null;

	public PrerequisitesTable(String deptCode, Integer courseNumber, String preDeptCode, Integer preCourseNumber) {
		super();
		this.deptCode = deptCode;
		this.courseNumber = courseNumber;
		this.preDeptCode = preDeptCode;
		this.preCourseNumber = preCourseNumber;
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

	public String getPreDeptCode() {
		return preDeptCode;
	}

	public void setPreDeptCode(String preDeptCode) {
		this.preDeptCode = preDeptCode;
	}

	public Integer getPreCourseNumber() {
		return preCourseNumber;
	}

	public void setPreCourseNumber(Integer preCourseNumber) {
		this.preCourseNumber = preCourseNumber;
	}

	@Override
	public String toString() {
		return "PrerequisitesTable [deptCode=" + deptCode + ", courseNumber=" + courseNumber + ", preDeptCode="
				+ preDeptCode + ", preCourseNumber=" + preCourseNumber + "]";
	}
}
