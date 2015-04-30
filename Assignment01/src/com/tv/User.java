package com.tv;

public class User {
	public static void main(String[] args) {
		
		Factory factory = new Factory();
		Control control = (Control)factory.getBean("TV");
		//Control control = (Control)factory.getBean("Galaxy");
		
		control.on();
		control.up();
		control.down();
		control.off();
		
	}

}
