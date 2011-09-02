package stoupa.acm11.clock;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class MinutesReadingTest {

	private static Set<Segment> all = EnumSet.allOf( Segment.class );
	
	@Test
	public void testPossibleValuesNoInfoGiven() {
		
		Set<Segment> lit = Collections.emptySet();
		Set<Segment> off = Collections.emptySet();
		DigitReading anything = new DigitReading( lit, off );
		
		Set<Integer> expected = new HashSet<Integer>();
		for ( int minute = 0; minute < 60; minute++ ) {
			expected.add( minute );
		}
		
		testPossibleValuesBase( anything, anything, expected );
	}

	@Test
	public void testPossibleValues3s8s9s() {

		Set<Segment> lit = Sets.difference( all, Sets.newHashSet( Segment.UPPER_LEFT, Segment.LOWER_LEFT ) );
		Set<Segment> off = Collections.emptySet();
		DigitReading threeEightNine = new DigitReading( lit, off ); 
		
		Set<Integer> expected = Sets.newHashSet( 33, 38, 39 ); 
		
		testPossibleValuesBase( threeEightNine, threeEightNine, expected );
	}
	
	@Test
	public void testPossibleValuesNoMatch() {
		
		Set<Segment> lit = Sets.newHashSet( Segment.TOP, Segment.BOTTOM );
		Set<Segment> off = Sets.complementOf( lit );
		DigitReading nothing = new DigitReading( lit, off );
		
		Set<Integer> expected = Collections.emptySet();
		
		testPossibleValuesBase( nothing, nothing, expected );
	}
	
	@Test
	public void testPossibleValues90() {
		
		Set<Segment> lit9 = Sets.difference( all, Sets.newHashSet( Segment.LOWER_LEFT ) );
		Set<Segment> off9 = Sets.complementOf( lit9 );
		DigitReading nine = new DigitReading( lit9, off9 );
		
		Set<Segment> lit0 = Sets.difference( all, Sets.newHashSet( Segment.MIDDLE ) );
		Set<Segment> off0 = Sets.complementOf( lit0 );
		DigitReading zero = new DigitReading( lit0, off0 );
		
		Set<Integer> expected = Collections.emptySet();
		
		testPossibleValuesBase( nine, zero, expected );
	}
	
	@Test
	public void testPossibleValues09() {
		
		Set<Segment> lit9 = Sets.difference( all, Sets.newHashSet( Segment.LOWER_LEFT ) );
		Set<Segment> off9 = Sets.complementOf( lit9 );
		DigitReading nine = new DigitReading( lit9, off9 );
		
		Set<Segment> lit0 = Sets.difference( all, Sets.newHashSet( Segment.MIDDLE ) );
		Set<Segment> off0 = Sets.complementOf( lit0 );
		DigitReading zero = new DigitReading( lit0, off0 );
		
		Set<Integer> expected = Sets.newHashSet( 9 );
		
		testPossibleValuesBase( zero, nine, expected );
	}
	
	private void testPossibleValuesBase( DigitReading r1, DigitReading r2, Set<Integer> expected ) {

		MinutesReading instance = new MinutesReading( r1, r2 );
		
		Set<Integer> actual = instance.getPossibleValues();
		assertEquals( expected, actual );
	}
}
