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
		String mineFieldString = "..*.\n..............***********\n\n\n";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test
	public void whenMethodValidateIfStringFormsRectangularIsGivenCorrectStringItShouldNotThrowException() {
		String mineFieldString = "*...\n..*.\n....";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateMineFieldStringIsGivenNullItShouldThrowException() {
		String mineFieldString = null;
		mineSweeperImpl.validateMineFieldString(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateMineFieldStringIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n.....";
		mineSweeperImpl.validateMineFieldString(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateLegalCharactersIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n....a90";
		mineSweeperImpl.validateLegalCharacters(mineFieldString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenMethodValidateIfStringFormsRectangularIsGivenIllegalStringItShouldThrowException() {
		String mineFieldString = "*...\n..*.\n..*..\n....";
		mineSweeperImpl.validateIfStringFormsRectangular(mineFieldString);		
	}	
	

}
