package com.samsung.biz.nalcoding;

public class A05_JumsuDAO {
	
	private A05_Jumsu vo = null;
	
	public A05_JumsuDAO(String name, int kor, int eng, int math){
		vo = new A05_Jumsu();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMath(math);
	}
	
	void onTotal(){
		vo.setTotal(vo.getKor()+vo.getEng()+vo.getMath());
	}
	
	void onAvg(){
		vo.setAvg(vo.getTotal()/3);
	}
	
	void onAvg(int su){
		vo.setAvg(vo.getTotal()/su);
	}
	
	void display(){
		onTotal();
		onAvg();
		System.out.println(vo.getName()+"님의 총점은 "+vo.getTotal()+"이고 평균은 "+vo.getAvg()+"입니다");
	}

}
