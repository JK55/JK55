package com.samsung.biz.nalcoding;

public class A01_Jumsu {
	public static void main(String[] args) {
		
		String hongName = "홍길동";
		int hongKor = 90;
		int hongEng = 75;
		int hongMath = 85;
		int hongTotal = hongKor + hongEng + hongMath;
		int hongAvg = hongTotal / 3;
		System.out.println(hongName+"님의 총점은 "+hongTotal+"이고 평균은 " +hongAvg+"입니다");

		String imName = "임꺽정";
		int imKor = 100;
		int imEng = 95;
		int imMath = 85;
		int imTotal = imKor + imEng + imMath;
		int imAvg = imTotal / 3;
		System.out.println(imName+"님의 총점은 "+imTotal+"이고 평균은 " +imAvg+"입니다");
		
		String jimaeName = "일지매";
		int jimaeKor = 100;
		int jimaeEng = 95;
		int jimaeMath = 100;
		int jimaeTotal = jimaeKor + jimaeEng + jimaeMath;
		int jimaeAvg = jimaeTotal / 3;
		System.out.println(jimaeName+"님의 총점은 "+jimaeTotal+"이고 평균은 " +jimaeAvg+"입니다");
		
		
				
	}
}
