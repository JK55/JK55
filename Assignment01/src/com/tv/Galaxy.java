package com.tv;

public class Galaxy implements Control {

	@Override
	public void on() {
		System.out.println("Galaxy ON");
	}

	@Override
	public void off() {
		System.out.println("Galaxy OFF");
	}

	@Override
	public void up() {
		System.out.println("Galaxy VOLUME UP");
	}

	@Override
	public void down() {
		System.out.println("Galaxy VOLUME DOWN");
	}

}
