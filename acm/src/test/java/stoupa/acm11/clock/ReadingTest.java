package stoupa.acm11.clock;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class ReadingTest {

	private static Set<Segment> ALL_SEGS = EnumSet.allOf( Segment.class );
	
	@Test
	public void test2340() {
		
		DigitReading two = new DigitReading( Digit.TWO ); 
		DigitReading three = new DigitReading( Digit.THREE );
		DigitReading four = new DigitReading( Digit.FOUR );
		DigitReading zero = new DigitReading( Digit.ZERO );
		
		Set<Time> expected = Sets.newHashSet( new Time( 23, 40 ) ); 
		
		testPossibleValuesBase( two, three, four, zero, expected );
	}
	
	@Test
	public void test0000() {
		
		DigitReading zero = new DigitReading( Digit.ZERO );
		
		Set<Time> expected = Sets.newHashSet( new Time( 0, 0 ) ); 
		
		testPossibleValuesBase( zero, zero, zero, zero, expected );
	}

	@Test
	public void testAllValues() {
		
		Set<Segment> lit = Collections.emptySet();
		Set<Segment> off = Collections.emptySet();
		DigitReading anything = new DigitReading( lit, off );
		
		Set<Time> expected = Sets.newHashSet();
		for ( int hour = 0; hour < 24; hour++ ) {
			for ( int minute = 0; minute < 60; minute++ ) {
				expected.add( new Time( hour, minute ) );
			}
		}
		
		testPossibleValuesBase( anything, anything, anything, anything, expected);
	}
	

	@Test
	public void testImpossible() {
		
		DigitReading two = new DigitReading( Digit.TWO ); 
		DigitReading three = new DigitReading( Digit.THREE );
		DigitReading six = new DigitReading( Digit.SIX );
		DigitReading zero = new DigitReading( Digit.ZERO );
		
		Set<Time> expected = Collections.emptySet(); 
		
		testPossibleValuesBase( two, three, six, zero, expected );
	}

	@Test
	public void testNoMatch() {
		
		Set<Segment> lit = Sets.newHashSet( Segment.TOP, Segment.UPPER_LEFT, Segment.LOWER_LEFT);
		Set<Segment> off = Sets.newHashSet( Sets.difference( ALL_SEGS, lit ) );
		DigitReading wtf = new DigitReading( lit, off ); 
		
		Set<Time> expected = Collections.emptySet(); 
		
		testPossibleValuesBase( wtf, wtf, wtf, wtf, expected );
	}
	
	
	private void testPossibleValuesBase( DigitReading h1, DigitReading h2,
			DigitReading m1, DigitReading m2,
			Set<Time> expected ) {

		Reading instance = new Reading( h1, h2, m1, m2 );
		
		Set<Time> actual = instance.getPossibleValues();
		assertEquals( expected, actual );
	}
	
}

