package model.beans;

public class CourseCreditsTable extends Table {

	private Integer courseNumber = null;
	private Integer credits = null;

	public CourseCreditsTable(Integer courseNumber, Integer credits) {
		super();
		this.courseNumber = courseNumber;
		this.credits = credits;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "CourseCreditsTable [courseNumber=" + courseNumber + ", credits=" + credits + "]";
	}
}
