package com.samsung.biz.impl;

public class JumsuFactory {

	// 말 그대로 클래스 공장. 어떤 클래스를 사용할지 정해서
	// 그 클래스를 생성해서 리턴하는 목적으로 만드는 클래스
	
	public Object getBean(){
		Jumsu jumsu = new Three("홍길동", 90, 80, 100);
		return jumsu;
		
	}
	
}
