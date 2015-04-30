package com.samsung.biz.inher;

public class JumsuVO {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int java;
	
	private int total;
	private int avg;
	
	
	public JumsuVO() {
		super();
	}

	public JumsuVO(String name, int kor, int eng, int math, int java,
			int total, int avg) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.java = java;
		this.total = total;
		this.avg = avg;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
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
		return "JumsuVO [name=" + name + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + ", java=" + java + ", total=" + total
				+ ", avg=" + avg + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avg;
		result = prime * result + eng;
		result = prime * result + java;
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + total;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JumsuVO other = (JumsuVO) obj;
		if (avg != other.avg)
			return false;
		if (eng != other.eng)
			return false;
		if (java != other.java)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	

	
}
