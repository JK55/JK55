package com.tv;

public class TV implements Control {

	@Override
	public void on() {
		System.out.println("TV ON");
	}

	@Override
	public void off() {
		System.out.println("TV OFF");
	}

	@Override
	public void up() {
		System.out.println("TV VOLUME UP");
	}

	@Override
	public void down() {
		System.out.println("TV VOLUME DOWN");
	}

}
