package com.xformation.test;


public final class MineSweeperImpl implements MineSweeper {
	
	private char[][] mineField;
	private char[][] hintField;	
	

	public void setMineField(String mineFieldString) throws IllegalArgumentException {
		validateMineFieldString(mineFieldString);
		String[] mineFieldAsArray = mineFieldString.split("\n");
	    this.mineField = new char[mineFieldAsArray.length][mineFieldAsArray[0].length()];
	    for (int i = 0; i < mineFieldAsArray.length; i++) {
	        mineField[i] = mineFieldAsArray[i].toCharArray();
	    }

	}

	public String getHintField() throws IllegalStateException {
		if (mineField == null)
			throw new IllegalStateException();
		
		return null;
	}
	
	char[][] getMineField() {
		return mineField;
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
