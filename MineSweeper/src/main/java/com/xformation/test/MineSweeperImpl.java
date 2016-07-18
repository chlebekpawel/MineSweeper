package com.xformation.test;


public class MineSweeperImpl implements MineSweeper {
	
	private char[] mineField;
	private char[][] hintField;	
	

	public void setMineField(String mineFieldString) throws IllegalArgumentException {
		

	}

	public String getHintField() throws IllegalStateException {
		
		
		return null;
	}
	
	void validateMineFieldString(String mineFieldString) {
		if (mineFieldString == null)
			throw new IllegalArgumentException();
		validateLegalCharacters(mineFieldString);
		validateIfStringFormsRectangular(mineFieldString);
	}
	
	void validateLegalCharacters(String mineFieldString) {		
		for (char c : mineFieldString.toCharArray()) {
			if (c != '*' && c != '.' && c != '\n')
				throw new IllegalArgumentException();
		}		
	}
	
	void validateIfStringFormsRectangular(String mineFieldString) {
		String[] arrayOfRows = mineFieldString.split("\n");
		int lengthOfAFirstRow = arrayOfRows[0].length();		
		for (String row : arrayOfRows) {
			if (row.length() != lengthOfAFirstRow)
				throw new IllegalArgumentException();
		}		
	}	
}
