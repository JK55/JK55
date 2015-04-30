package com.score;

public class VO {
	
	private String subject;
	private int korean;
	private int math;
	private int total;
	private int avg;
	
	public VO() {
		super();
	}
	public VO(String subject, int korean, int math) {
		super();
		this.subject = subject;
		this.korean = korean;
		this.math = math;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "VO [subject=" + subject + ", korean=" + korean + ", math="
				+ math + ", total=" + total + ", avg=" + avg + "]";
	}

	

}
