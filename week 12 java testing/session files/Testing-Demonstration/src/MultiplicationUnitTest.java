import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultiplicationUnitTest {
	// initialise class to be tested
	public static Calculator calc;
	
	@BeforeClass // runs before everything
	public static void setUpBeforeClass() {
		calc = new Calculator();
	}
	
	@AfterClass // runs after everything
	public static void tearDownAfterClass() {}
	
	@Before // runs before each test
	public void setUp() {}
	
	@After // runs after each test
	public void close() {}
	
	@Test
	public void test1() {
		int answer = calc.multiply(4, 6);
		assertEquals("Expected 24 but got something else", 24, answer);
	}
	@Test
	public void test2() {
		int answer = calc.multiply(190, 10);
		assertEquals("Expected 1900 but got something else", 1900, answer);
	}
	@Test
	public void test3() {
		int answer = calc.multiply(0, 0);
		assertEquals("Expected 0 but got something else", 0, answer);
	}
	@Test
	public void test4() {
		int answer = calc.multiply(4000, 6000);
		assertEquals("Expected 24000000 but got something else", 24000000, answer);
	}
}