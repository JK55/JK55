package com.samsung.biz.nalcoding;

public class A03_JumsuTwoArray {
	public static void main(String[] args) {
		
		String[] name = {"홍길동", "임꺽정", "일지매"};
		//int[] hong = {90, 75, 85, 0, 0};
		//int[] im = {85, 75, 95, 0, 0};
		//int[] jimae = {90, 95, 100, 0, 0};
		
		int[][] jumsu = {{90, 75, 85, 0, 0}, {85, 75, 95, 0, 0}, {90, 95, 100, 0, 0}};
	
		for (int i = 0; i < jumsu.length; i++) {	//3
			for (int j = 0; j < 3; j++) {
				jumsu[i][3] = jumsu[i][3] + jumsu[i][j];
			}
			jumsu[i][4] = jumsu[i][3] / 3;
			
			System.out.println(name[i]+"님의 총점은 "+jumsu[i][3]+"이고 평균은 "+jumsu[i][4]+"입니다");
		}
	
	}
	
	
}
