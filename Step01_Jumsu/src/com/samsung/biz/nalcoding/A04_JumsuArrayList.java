package com.samsung.biz.nalcoding;

import java.util.ArrayList;

public class A04_JumsuArrayList {
	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<>();
		name.add("홍길동");
		name.add("임꺽정");
		name.add("일지매");
		
		ArrayList<Integer> hong = new ArrayList<>();
		hong.add(70);
		hong.add(70);
		hong.add(70);
		
		ArrayList<Integer> im = new ArrayList<>();
		im.add(80);
		im.add(80);
		im.add(80);
		
		ArrayList<Integer> jimae = new ArrayList<>();
		jimae.add(90);
		jimae.add(90);
		jimae.add(90);
		
		
		ArrayList<ArrayList<Integer>> jumsu = new ArrayList<>();
		jumsu.add(hong);
		jumsu.add(im);
		jumsu.add(jimae);

		for (int i = 0; i < jumsu.size(); i++) {
			ArrayList<Integer> su = jumsu.get(i);
			
			int total = 0;
			for (int j = 0; j < su.size(); j++) {
				total = su.get(0)+su.get(1)+su.get(2);
			}
			su.add(total);
			su.add(total / 3);
			
			System.out.println(name.get(i)+"님의 총점은 "+su.get(3)+"이고 평균은 "+su.get(4)+"입니다");
		}
		
	}
	
}
