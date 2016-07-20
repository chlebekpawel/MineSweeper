package com.xformation.test;

import static org.junit.Assert.*;
import org.junit.Test;



public class MineSweeperImplTest {
	
	MineSweeperImpl mineSweeperImpl = new MineSweeperImpl();
	
	@Test
	public void whenMethodSetMineFieldIsCalledThenItShouldCreateMineField() {
		mineSweeperImpl.setMineField("*...\n..*.\n....");	    
	    char[][] expectedArray = {{'*','.', '.','.'}, {'.','.','*','.'}, {'.','.','.','.'}};
	    assertArrayEquals(expectedArray, mineSweeperImpl.getMineField());
	    
	    
	}
	
	@Test
	public void whenMethodGetHintFieldIsCalledThenItShouldReturnStringRepresentationOfHintField() {
		mineSweeperImpl.setMineField("*...\n..*.\n....");	    
	    char[][] expectedArray = {{'*','.', '.','.'}, {'.','.','*','.'}, {'.','.','.','.'}};
	    assertArrayEquals(expectedArray, mineSweeperImpl.getMineField());
	    
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodSetMineFieldIsCalledWithInvalidInputThenItShouldThrowException() {
		mineSweeperImpl.setMineField("*...\n..*..\n....");	    
	    char[][] expectedArray = {{'*','.', '.','.'}, {'.','.','*','.'}, {'.','.','.','.'}};
	    assertArrayEquals(expectedArray, mineSweeperImpl.getMineField());
	}
	
	@Test
	public void whenMethodValidateMineFieldStringIsGivenCorrectStringThenItShouldNotThrowException() {
		String mineFieldString =  "*...\n..*.\n....";
		mineSweeperImpl.validateMineFieldString(mineFieldString);
	}
	
	@Test
	public void whenMethodValidateLegalCharactersIsGivenCorrectStringThenItShouldNotThrowException() {
		String mineFieldString = "..*.\n..............***********\n\n\n";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test
	public void whenMethodValidateIfStringFormsRectangularIsGivenCorrectStringThenItShouldNotThrowException() {
		String mineFieldString = "*...\n..*.\n....";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateMineFieldStringIsGivenNullThenItShouldThrowException() {
		String mineFieldString = null;		
		mineSweeperImpl.validateMineFieldString(mineFieldString);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateMineFieldStringIsGivenIllegalStringThenItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n.....";		
		mineSweeperImpl.validateMineFieldString(mineFieldString);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateLegalCharactersIsGivenIllegalStringThenItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n....a90";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateIfStringFormsRectangularIsGivenIllegalStringThenItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n..*..\n....";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);		
	}
}
