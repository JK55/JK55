package com.tv;

public class Factory {
	
	// 어떤 객체를 사용할지를 결정
	public Object getBean(String tv){
		if(tv.equals("TV")){
			return new TV();
		}else if(tv.equals("Galaxy")){
			return new Galaxy();
		}
		return null;
	}

}
