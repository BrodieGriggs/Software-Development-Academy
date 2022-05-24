package unitTesting.Main;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Main;

public class Main_showInfo_Tests {
	
	// keep default PrintStream for teardown after testing
	private PrintStream standardOut = System.out;
	
	private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	@Before
	public void setup() {
		// reassign the standard output stream to a new PrintStream with a ByteArrayOutputStream
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	public void test01() {
		// showInfo takes an int[2] position
		int[] position = {3, 7};
		
		// expected string
		String expectedStr = "(3,7)    A: ← ,  W: ↑ ,  D: → ,  S: ↓";
		
		Main.showInfo(position);
		
		assertEquals(expectedStr, outputStreamCaptor.toString().trim());
	}
	
	@Test
	public void test02() {
		int[] position = {0, 0};
		String expectedStr = "(0,0)    A: ← ,  W: ↑ ,  D: → ,  S: ↓";
		Main.showInfo(position);
		assertEquals(expectedStr, outputStreamCaptor.toString().trim());
	}
	@Test
	public void test03() {
		int[] position = {-1, -1};
		String expectedStr = "(-1,-1)    A: ← ,  W: ↑ ,  D: → ,  S: ↓";
		Main.showInfo(position);
		assertEquals(expectedStr, outputStreamCaptor.toString().trim());
	}
	
	@After
	public void tearDown() {
		// Assign the standard output stream
		System.setOut(standardOut);
	}

}
