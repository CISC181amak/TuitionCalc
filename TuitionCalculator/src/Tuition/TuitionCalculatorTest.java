package Tuition;

import static org.junit.Assert.*;

import org.junit.Test;

public class TuitionCalculatorTest {
	
	TuitionVariables T1 = new TuitionVariables(20, 12520, 1.02, 3.9);
	TuitionVariables T2 = new TuitionVariables(10, 10000, 1.02, 4);
	

	@Test
	public void testOne() {
		assertEquals(T1.getTuitionTotal(12520, 1.02), 51602, 1);
	}
	public void testTwo() {
		assertEquals(T2.getTuitionTotal(10000, 1.02), 41216, 1);
	}
	
}
