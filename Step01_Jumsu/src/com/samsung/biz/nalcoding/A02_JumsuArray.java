package com.samsung.biz.nalcoding;

public class A02_JumsuArray {
	public static void main(String[] args) {
		
		String[] name = {"홍길동", "임꺽정", "일지매"};
		int[] hong = {90, 75, 85, 0, 0};
		int[] im = {85, 75, 95, 0, 0};
		int[] jimae = {90, 95, 100, 0, 0};
		
		// hong
		for (int i = 0; i < hong.length; i++) {
			hong[3] = hong[0] + hong[1] + hong[2];
		}
		hong[4] = hong[3] / 3;
		
		// im
		for (int i = 0; i < im.length; i++) {
			im[3] = im[0] + im[1] + im[2];
		}
		im[4] = im[3] / 3;
		
		// jimae
		for (int i = 0; i < jimae.length; i++) {
			jimae[3] = jimae[0] + jimae[1] + jimae[2];
		}
		jimae[4] = jimae[3] / 3;
		
		
		//출력
		System.out.println(name[0]+"님의 총점은 "+hong[3]+"이고 평균은 " +hong[4]+"입니다");
		System.out.println(name[1]+"님의 총점은 "+im[3]+"이고 평균은 " +im[4]+"입니다");
		System.out.println(name[2]+"님의 총점은 "+jimae[3]+"이고 평균은 " +jimae[4]+"입니다");
		
	}

}
