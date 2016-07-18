package com.xformation.test;
import org.junit.Test;



public class MineSweeperImplTest {
	
	MineSweeperImpl mineSweeperImpl = new MineSweeperImpl();
	
	@Test
	public void whenMethodValidateMineFieldStringIsGivenCorrectStringItShouldNotThrowException() {
		String mineFieldString =  "*...\n..*.\n....";
		mineSweeperImpl.validateMineFieldString(mineFieldString);
	}
	
	@Test
	public void whenMethodValidateLegalCharactersIsGivenCorrectStringItShouldNotThrowException() {
		String mineFieldString = "abc";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test
	public void whenMethodValidateIfStringFormsRectangularIsGivenCorrectStringItShouldNotThrowException() {
		String mineFieldString = "abc";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateMineFieldStringIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "abc";;
		mineSweeperImpl.validateMineFieldString(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateLegalCharactersIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "abc";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateIfStringFormsRectangularIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "bc";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);
	}

}
