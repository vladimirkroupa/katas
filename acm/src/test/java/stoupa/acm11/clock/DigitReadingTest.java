package stoupa.acm11.clock;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

import static org.junit.Assert.*;

public class DigitReadingTest {

	@Test
	public void testNoInfoGiven() {
		
		Set<Segment> lit = Collections.<Segment>emptySet();
		Set<Segment> off = Collections.<Segment>emptySet();
		Set<Digit> expected = EnumSet.allOf( Digit.class );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testNoMatch() {
		
		Set<Segment> lit = EnumSet.of( Segment.UPPER_LEFT, Segment.LOWER_LEFT );
		Set<Segment> off = EnumSet.of( Segment.UPPER_RIGHT, Segment.LOWER_RIGHT );
		Set<Digit> expected = Collections.emptySet();
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testThreeEightNine() {
		
		Set<Segment> all = EnumSet.allOf( Segment.class );
		Set<Segment> lit = Sets.difference( all, Sets.newHashSet( Segment.UPPER_LEFT,  Segment.LOWER_LEFT ) );
		Set<Segment> off = Collections.emptySet();
		Set<Digit> expected = Sets.newHashSet( Digit.THREE, Digit.EIGHT, Digit.NINE );
		
		digitTestBase( lit, off, expected );
	}

	@Test
	public void testFourFiveSix() {
		
		Set<Segment> lit = EnumSet.of( Segment.UPPER_LEFT, Segment.MIDDLE, Segment.LOWER_RIGHT );
		Set<Segment> off = EnumSet.of( Segment.UPPER_RIGHT );
		Set<Digit> expected = Sets.newHashSet( Digit.FOUR, Digit.FIVE, Digit.SIX );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectZero() {

		Set<Segment> all = EnumSet.allOf( Segment.class );
		Set<Segment> lit = Sets.difference( all, Sets.newHashSet( Segment.MIDDLE) );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.ZERO );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectOne() {

		Set<Segment> lit = EnumSet.of( Segment.UPPER_RIGHT, Segment.LOWER_RIGHT );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.ONE );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectTwo() {

		Set<Segment> off = EnumSet.of( Segment.UPPER_LEFT, Segment.LOWER_RIGHT );
		Set<Segment> lit = Sets.complementOf( off ); 
		Set<Digit> expected = Sets.newHashSet( Digit.TWO );
		
		digitTestBase( lit, off, expected );
	}

	@Test
	public void testPerfectThree() {

		Set<Segment> off = EnumSet.of( Segment.UPPER_LEFT, Segment.LOWER_LEFT );
		Set<Segment> lit = Sets.complementOf( off );
		Set<Digit> expected = Sets.newHashSet( Digit.THREE );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectFour() {
	
		Set<Segment> lit = EnumSet.of( Segment.UPPER_LEFT, Segment.MIDDLE, Segment.LOWER_RIGHT );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.FOUR );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectFive() {
	
		Set<Segment> lit = EnumSet.of( Segment.TOP, Segment.UPPER_LEFT, Segment.MIDDLE, Segment.LOWER_RIGHT, Segment.BOTTOM );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.FIVE );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectSix() {
	
		Set<Segment> off = EnumSet.of( Segment.UPPER_RIGHT );
		Set<Segment> lit = Sets.complementOf( off );
		Set<Digit> expected = Sets.newHashSet( Digit.SIX );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectSeven() {
	
		Set<Segment> lit = EnumSet.of( Segment.TOP, Segment.UPPER_RIGHT, Segment.LOWER_RIGHT );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.SEVEN );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectEight() {
	
		Set<Segment> lit = EnumSet.allOf( Segment.class );
		Set<Segment> off = Sets.complementOf( lit );
		Set<Digit> expected = Sets.newHashSet( Digit.EIGHT );
		
		digitTestBase( lit, off, expected );
	}
	
	@Test
	public void testPerfectNine() {
	
		Set<Segment> off = EnumSet.of( Segment.LOWER_LEFT );
		Set<Segment> lit = Sets.complementOf( off );
		Set<Digit> expected = Sets.newHashSet( Digit.NINE );
		
		digitTestBase( lit, off, expected );
	}
	
	private void digitTestBase( Set<Segment> lit, Set<Segment> off, Set<Digit> expected ) {
		
		DigitReading instance = new DigitReading( lit, off );
		Set<Digit> actual = instance.getPossibleDigits();
		assertEquals( expected, actual );
	}
	
}
