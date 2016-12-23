package model.beans;

public class CoursesTable extends Table {
	private String deptCode = null;
	private Integer courserNumber = null;
	private String title = null;

	public CoursesTable(String deptCode, Integer courserNumber, String title) {
		super();
		this.deptCode = deptCode;
		this.courserNumber = courserNumber;
		this.title = title;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Integer getCourserNumber() {
		return courserNumber;
	}

	public void setCourserNumber(Integer courserNumber) {
		this.courserNumber = courserNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "CoursesTable [deptCode=" + deptCode + ", courserNumber=" + courserNumber + ", title=" + title + "]";
	}
}
