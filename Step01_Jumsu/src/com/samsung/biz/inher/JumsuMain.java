package com.samsung.biz.inher;

import java.util.ArrayList;

public class JumsuMain {
	public static void main(String[] args) {
		
/*		JumsuTwo hong = new JumsuTwo("홍길동", 100, 95);
		hong.display();
		
		JumsuThree im = new JumsuThree("임꺽정", 100, 95, 45);
		im.display();
		
		JumsuFour jimae = new JumsuFour("일지매", 75, 95, 45, 95);
		jimae.display();*/
		
		
		// 내가 만든 클래스도 변수의 타입
		// 상속관계에서는 부모는 자식보다 큰 타입이다
		// 따라서 다음과 같은 정의가 가능
		// JumsuTwo > JumsuThree
		// JumsuTwo > JumsuFour
		
		/*JumsuTwo hong = new JumsuTwo("홍길동", 100, 95);
		JumsuTwo im = new JumsuThree("임꺽정", 100, 95, 45);
		JumsuTwo jimae = new JumsuFour("일지매", 75, 95, 45, 95);*/
		
		JumsuTwo test = new JumsuThree("임꺽정", 100, 95, 45);
		test.onTwo();
		
		int top = 0;
		JumsuTwo topPerson = null;
		
		//JumsuTwo[] jumsu = {hong, im, jimae};
		ArrayList<JumsuTwo> jumsu = new ArrayList<>();
		jumsu.add(new JumsuTwo("홍길동", 100, 95));
		jumsu.add(new JumsuThree("임꺽정", 100, 95, 45));
		jumsu.add(new JumsuFour("일지매", 75, 95, 45, 95));
		
		for (JumsuTwo su : jumsu) {
			su.display();
			
			if(su.vo.getAvg()>top){
				top = su.vo.getAvg();
				topPerson = su;
			}
		}
		
/*		for (int i = 0; i < jumsu.size(); i++) {
			JumsuTwo su = jumsu.get(i);
			su.display();
			
			if(su.vo.getAvg()>top){
				top = su.vo.getAvg();
				topPerson = su;
			}
		}*/
		
		System.out.println(top);
		System.out.println(topPerson.vo.getName());
		
		
/*		JumsuVO vo1 = new JumsuVO();
		vo1.setName("홍길동");
		vo1.setKor(100);
		vo1.setEng(75);
		
		System.out.println(vo1);
		
		
		JumsuVO vo2 = new JumsuVO();
		vo2.setName("홍길동");
		vo2.setKor(100);
		vo2.setEng(75);
		
		System.out.println(vo2);
		
		System.out.println("vol => "+vo1.hashCode());
		System.out.println("vol => "+vo2.hashCode());
		if(vo1.equals(vo2)){
			System.out.println("같은 객체");
		}else{
			System.out.println("다른 객체");
		}*/
		
	}

}
