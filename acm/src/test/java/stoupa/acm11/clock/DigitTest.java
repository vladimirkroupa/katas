package stoupa.acm11.clock;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class DigitTest {

	@Test
	public void testFour() {
		Digit four = Digit.FOUR;
		Set<Segment> expectedLit = Sets.newHashSet( Segment.UPPER_LEFT, Segment.MIDDLE, Segment.LOWER_RIGHT );
		Set<Segment> expectedOff = Sets.complementOf( expectedLit );
		Set<Segment> actualLit = four.getLitSegments();
		Set<Segment> actualOff = four.getOffSegments();
		assertEquals( expectedLit, actualLit );
		assertEquals( expectedOff, actualOff );
	}
	
}
