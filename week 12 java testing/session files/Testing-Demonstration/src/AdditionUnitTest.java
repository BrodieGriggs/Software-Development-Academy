import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionUnitTest {
	// initialise class to be tested
	public static Calculator calc;
	
	@BeforeClass // runs before everything
	public static void setUpBeforeClass() {
		System.out.println("Calculator.add() testing started.");
		calc = new Calculator();
	}
	
	@AfterClass // runs after everything
	public static void tearDownAfterClass() {
		System.out.println("Calculator.add() testing ended.");
	}
	
	@Before // runs before each test
	public void setUp() {}
	
	@After // runs after each test
	public void close() {}
	
	@Test
	public void test1() {
		int answer = calc.add(4, 6);
		assertEquals("Expected 10 but got something else", 10, answer);
	}
	@Test
	public void test2() {
		int answer = calc.add(190, 10);
		assertEquals("Expected 200 but got something else", 200, answer);
	}
	@Test
	public void test3() {
		int answer = calc.add(0, 0);
		assertEquals("Expected 0 but got something else", 0, answer);
	}
	@Test
	public void test4() {
		int answer = calc.add(4000, 6000);
		assertEquals("Expected 10000 but got something else", 10000, answer);
	}
}