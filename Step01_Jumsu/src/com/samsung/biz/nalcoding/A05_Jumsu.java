package com.samsung.biz.nalcoding;

// 내가 만든 클래스도 변수명(변수타입)이다.
// 이렇게 만들면 다양한 타입의 변수를 하나의 이름으로 관리할 수 있다.
public class A05_Jumsu {
	
	private String name = "";
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int avg;
	
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
	
	// JVM은 생성자 메소드가 없으면 기본 생성자 메소드를 자동으로 만들어 준다.
	// 형태는 다음과 같다.
	// 생성자 메소드를 프로그래머가 하나라도 만들면 기본 생성자 메소드를 JVM은 만들어 주지 않는다.
	// 따라서 필요하면 꼭 프로그래머가 정의해 주어야 한다.
	
	// 초기화 메소드
	A05_Jumsu(){
	}
	
	// 생성자 오버로딩
	A05_Jumsu(String name, int kor){
		this.name = name;
		this.kor = kor;
	}
	
	A05_Jumsu(String name, int kor, int eng, int math){
		this(name, kor);
		this.eng = eng;
		this.math = math;
	}
	
}
