package model.beans;

public class ClassInformation {
	private String bNUmber = null;
	private String firstName = null;
	private String classId = null;
	private String title = null;


	public ClassInformation(String bNUmber, String firstName, String classId,
			String title) {
		this.bNUmber = bNUmber;
		this.firstName = firstName;
		this.classId = classId;
		this.title = title;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getDeptCode() {
		return classId;
	}

	public void setDeptCode(String deptCode) {
		this.classId = deptCode;
	}

	/**
	 * @return the bNUmber
	 */
	public String getbNUmber() {
		return bNUmber;
	}

	/**
	 * @param bNUmber the bNUmber to set
	 */
	public void setbNUmber(String bNUmber) {
		this.bNUmber = bNUmber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
