package com.xformation.test;


public final class MineSweeperImpl implements MineSweeper {
	
	private char[][] mineField;
	private char[][] hintField;
	private String stringRepresentationOfHintField;

	public void setMineField(String mineFieldString) throws IllegalArgumentException {
		validateMineFieldString(mineFieldString);
		String[] mineFieldAsArray = mineFieldString.split("\n");
	    this.mineField = new char[mineFieldAsArray.length][mineFieldAsArray[0].length()];
	    for (int i = 0; i < mineFieldAsArray.length; i++) {
	        mineField[i] = mineFieldAsArray[i].toCharArray();
	    }
	    setHintField();
	}

	public String getHintField() throws IllegalStateException {
		if (hintField == null) {
			throw new IllegalStateException();
		} else {
			return stringRepresentationOfHintField;
		}					
	}
	
	void setHintField() {
		initializeHintFieldWithMinesAndZerosInPlaceOfDots();
		createCountersForAdjacentMinesInHintField();
		createStringRepresentationOfHintField();
	}

	void initializeHintFieldWithMinesAndZerosInPlaceOfDots() {
		hintField = new char[mineField.length][mineField[0].length];
		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[0].length; j++) {
				if (mineField[i][j] == '.') {
					hintField[i][j] = '0';
				} else if (mineField[i][j] == '*') {
					hintField[i][j] = '*';
				}						
			}
		}
	}
	
	void createCountersForAdjacentMinesInHintField() {
		for (int i = 0; i < hintField.length; i++) {
			for (int j = 0; j < hintField[0].length; j++) {
				if (hintField[i][j] == '*') 
					incrementAllAdjacentPositions(i, j);
			}
		}
	}
	
	void incrementAllAdjacentPositions(int row, int column) {
		incrementPositionInsideHintFieldIfItIsNotMine(row - 1, column - 1);
		incrementPositionInsideHintFieldIfItIsNotMine(row - 1, column);
		incrementPositionInsideHintFieldIfItIsNotMine(row - 1, column + 1);
		incrementPositionInsideHintFieldIfItIsNotMine(row, column - 1);
		incrementPositionInsideHintFieldIfItIsNotMine(row, column + 1);
		incrementPositionInsideHintFieldIfItIsNotMine(row + 1, column - 1);
		incrementPositionInsideHintFieldIfItIsNotMine(row + 1, column);
		incrementPositionInsideHintFieldIfItIsNotMine(row + 1, column + 1);
	}
	
	void incrementPositionInsideHintFieldIfItIsNotMine(int row, int column) {
		if (isPositionInsideHintFieldBoundaries(row, column) && !isMine(row, column))
				hintField[row][column]++;
	}	
	
	boolean isPositionInsideHintFieldBoundaries(int row, int column) {
		if (row > 0 && row <  hintField.length && column > 0 && column < hintField[0].length) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isMine(int row, int column) {
		if (hintField[row][column] == '*') {
			return true;
		} else {
			return false;
		}			
	}	
	
	char[][] getMineField() {
		return mineField;
	}
	
	private void createStringRepresentationOfHintField() {
		// TODO Auto-generated method stub
		
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
