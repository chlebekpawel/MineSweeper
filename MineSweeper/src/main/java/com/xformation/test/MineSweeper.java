package com.xformation.test;

public interface MineSweeper {
	
	void setMineField(String mineField) throws IllegalArgumentException;
	
	String getHintField() throws IllegalStateException;

}
