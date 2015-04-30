package com.score;

public class Midterm implements Score{
	
	protected VO vo = null;
	
	public Midterm() {
		super();
	}

	public Midterm(String subject, int korean){
		vo = new VO();
		vo.setSubject(subject);
		vo.setKorean(korean);
	}
	
	
	public void onTwo(){
		System.out.println("Two Class");
	}



	@Override
	public void total() {
		vo.setTotal(vo.getKorean());
	}

	@Override
	public void avg() {
		vo.setAvg(vo.getTotal()/1);
	}

	@Override
	public void print() {
		total();
		avg();
		System.out.println(vo.getSubject()+"학기의 총점은"+vo.getTotal()+"이고 평균은"+vo.getAvg());
		
	}

}
