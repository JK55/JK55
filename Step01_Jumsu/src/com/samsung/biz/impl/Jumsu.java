package com.samsung.biz.impl;

// 단지 부모 역할만 할 껍데기 클래스
public interface Jumsu {

	// 다형성을 위해 자식들이 호출되어 사용될 껍데기 메소드만 정의한다
	public void onTotal();
	public void onAvg();
	public void display();
	
	
}
