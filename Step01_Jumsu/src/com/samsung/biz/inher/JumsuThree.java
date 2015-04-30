package com.samsung.biz.inher;

public class JumsuThree extends JumsuTwo {

	public JumsuThree(){
		super();	//new JumsuTwo()
	}
	
	public JumsuThree(String name, int kor, int eng, int math){
		super(name, kor, eng);
		vo.setMath(math);
	}
	
	public void onTotal(){
		vo.setTotal(vo.getKor()+vo.getEng()+vo.getMath());
	}
	
	public void onAvg(){
		vo.setAvg(vo.getTotal()/3);
	}
	
	public void onThree(){
		System.out.println("Three Class");
	}
	
	
}
