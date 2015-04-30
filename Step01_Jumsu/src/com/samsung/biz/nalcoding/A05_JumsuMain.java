package com.samsung.biz.nalcoding;

public class A05_JumsuMain {
	public static void main(String[] args) {
		
		A05_JumsuDAO hong = new A05_JumsuDAO("홍길동", 95, 75, 65);
		hong.display();
		
		A05_JumsuDAO im = new A05_JumsuDAO("임꺽정", 95, 100, 85);
		im.display();
		

/*		//A05_Jumsu hong = new A05_Jumsu();
		
		hong.name = "홍길동";
		hong.kor = 90;
		hong.eng = 80;
		hong.math = 70;
		hong.total = hong.kor + hong.eng + hong.math;
		hong.avg = hong.total / 3;
		
		// 메소드도 똑같이 호출한다. 단 메소드는 ()가 붙는다.
		A05_Jumsu hong = new A05_Jumsu("홍길동", 90, 85, 65);
		//hong.onTotal();
		//hong.onAvg();
		
		A05_Jumsu im = new A05_Jumsu("임꺽정", 100, 80, 70);
		im.onTotal();
		im.onAvg();
		
		A05_Jumsu jimae = new A05_Jumsu("일지매", 60, 80, 70);
		jimae.onTotal();
		jimae.onAvg();
		
		A05_Jumsu 신천재 = new A05_Jumsu();
		System.out.println(hong.name+"님의 총점은 "+hong.total+"이고 평균은 "+hong.avg+"입니다");
		
		hong.display();
		im.display();
		jimae.display();
		
		A05_Jumsu nol = new A05_Jumsu();
		nol.setName("놀부");
		nol.setKor(95);
		nol.setEng(35);
		nol.setMath(74);
		nol.setTotal(nol.getKor()+nol.getEng()+nol.getMath());
		nol.setAvg(nol.getTotal()/3);
		nol.display();*/
		
	}
}
