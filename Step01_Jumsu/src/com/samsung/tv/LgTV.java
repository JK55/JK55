package com.samsung.tv;

public class LgTV implements TV {

	public void powerOn(){
		System.out.println("LgTV => 전원 켜기");
	}
	
	public void powerOff(){
		System.out.println("LgTV => 전원 끄기");
	}
	
	public void volumeUp(){
		System.out.println("LgTV => 소리 올리기");
	}
	
	public void volumeDown(){
		System.out.println("LgTV => 소리 내리기");
	}

}
