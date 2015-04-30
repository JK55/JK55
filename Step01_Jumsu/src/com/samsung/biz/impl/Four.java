package com.samsung.biz.impl;

import com.samsung.biz.inher.JumsuVO;

public class Four implements Jumsu {
	
	protected JumsuVO vo = null;

	public Four(String name, int kor, int eng, int math, int java){
		vo = new JumsuVO();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMath(math);
		vo.setJava(java);
	}
	
	public void onTotal(){
		vo.setTotal(vo.getKor()+vo.getEng()+vo.getMath()+vo.getJava());
	}
	
	public void onAvg(){
		vo.setAvg(vo.getTotal()/4);
	}
	
	public void onFour(){
		System.out.println("Four Class");
	}
	
	public void display(){
		onTotal();
		onAvg();
		System.out.println(vo.getName()+"님의 총점은 "+vo.getTotal()+"이고 평균은 "+vo.getAvg()+"입니다");
	}

	
}
