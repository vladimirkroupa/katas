package stoupa.acm11.clock;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class HoursReadingTest {

	@Test
	public void testMidnight() {
		
		DigitReading perfectZero = new DigitReading( Digit.ZERO ); 
		
		Set<Integer> expected = Sets.newHashSet( 0 ); 
		
		testPossibleValuesBase( perfectZero, perfectZero, expected );
	}
	
	@Test
	public void test24Illegal() {
	
		DigitReading perfectTwo = new DigitReading( Digit.TWO );
		DigitReading perfectFour = new DigitReading( Digit.FOUR ); 
		
		Set<Integer> expected = Collections.emptySet(); 
		
		testPossibleValuesBase( perfectTwo, perfectFour, expected );		
	}
		
	private void testPossibleValuesBase( DigitReading r1, DigitReading r2, Set<Integer> expected ) {

		HoursReading instance = new HoursReading( r1, r2 );
		
		Set<Integer> actual = instance.getPossibleValues();
		assertEquals( expected, actual );
	}

}
