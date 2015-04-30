package com.samsung.biz.inher;

public class JumsuTwo {
	
	protected JumsuVO vo = null;
	
	public JumsuTwo() {
		super();
	}

	public JumsuTwo(String name, int kor, int eng){
		vo = new JumsuVO();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
	
	}
	
	public void onTotal(){
		vo.setTotal(vo.getKor()+vo.getEng());
	}
	
	public void onAvg(){
		vo.setAvg(vo.getTotal()/2);
	}
	
	public void display(){
		onTotal();
		onAvg();
		System.out.println(vo.getName()+"님의 총점은 "+vo.getTotal()+"이고 평균은 "+vo.getAvg()+"입니다");
		System.out.println(vo);
	}
	
	public void onTwo(){
		System.out.println("Two Class");
	}
	

}
