package com.samsung.biz.impl;
import com.samsung.biz.inher.JumsuVO;

public class Three implements Jumsu {

	protected JumsuVO vo = null;
	
	public Three(){
		super();	//new JumsuTwo()
	}
	
	public Three(String name, int kor, int eng, int math){
		vo = new JumsuVO();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
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
	
	public void display(){
		onTotal();
		onAvg();
		System.out.println(vo.getName()+"님의 총점은 "+vo.getTotal()+"이고 평균은 "+vo.getAvg()+"입니다");
	}
	

}
