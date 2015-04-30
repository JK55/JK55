package com.score;

public class Final implements Score {
	
	protected VO vo = null;
	
	public Final() {
		super();
	}

	public Final(String subject, int korean, int math){
		vo = new VO();
		vo.setSubject(subject);
		vo.setKorean(korean);
		vo.setMath(math);
	}
	
	
	public void onTwo(){
		System.out.println("Two Class");
	}



	@Override
	public void total() {
		vo.setTotal(vo.getKorean()+vo.getMath());
	}

	@Override
	public void avg() {
		vo.setAvg(vo.getTotal()/2);
	}

	@Override
	public void print() {
		total();
		avg();
		System.out.println(vo.getSubject()+"학기의 총점은"+vo.getTotal()+"이고 평균은"+vo.getAvg());
		
	}

}
