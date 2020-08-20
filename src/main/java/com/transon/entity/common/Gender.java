package com.transon.entity.common;

public enum Gender {
	Male(1),
	Female(2),
	Other(0);
	
	private int value;
	Gender(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
