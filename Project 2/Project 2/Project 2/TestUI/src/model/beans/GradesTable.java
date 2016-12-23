package model.beans;

public class GradesTable extends Table {
	private String lGrade = null;
	private Integer nGrade = null;

	public GradesTable(String lGrade, Integer nGrade) {
		super();
		this.lGrade = lGrade;
		this.nGrade = nGrade;
	}

	public String getlGrade() {
		return lGrade;
	}

	public void setlGrade(String lGrade) {
		this.lGrade = lGrade;
	}

	public Integer getnGrade() {
		return nGrade;
	}

	public void setnGrade(Integer nGrade) {
		this.nGrade = nGrade;
	}

	@Override
	public String toString() {
		return "GradesTable [lGrade=" + lGrade + ", nGrade=" + nGrade + "]";
	}
}
