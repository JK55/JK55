package com.score;

public class Main {
	public static void main(String[] args) {
		
		Score first = new Midterm("1", 90);
		Score second = new Final("2", 100, 100);
		
		first.print();
		second.print();
	}

}
