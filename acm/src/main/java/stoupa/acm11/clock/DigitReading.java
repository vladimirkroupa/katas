package stoupa.acm11.clock;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class DigitReading {

	final static Logger logger = LoggerFactory.getLogger(DigitReading.class);
	
	private final Set<Segment> litSegments;
	private final Set<Segment> offSegments;
	
	public DigitReading( Set<Segment> litSegments, Set<Segment> offSegments ) {
		this.litSegments = ImmutableSet.copyOf( litSegments );
		this.offSegments = ImmutableSet.copyOf( offSegments );
	}

	public Set<Segment> getLitSegments() {
		return litSegments;
	}

	public Set<Segment> getOffSegments() {
		return offSegments;
	}

	public Set<Segment> getUnknownSegments() {
		Set<Segment> knownSegments = Sets.union( litSegments, offSegments );
		return Sets.complementOf( knownSegments );
	}

	public Set<Digit> getPossibleDigits() {
	
		Set<Digit> result = new HashSet<Digit>();
		
		for ( Digit candidate : Digit.values() ) {
			if ( this.couldBe( candidate ) ) {
				result.add( candidate );
			}
		}
		return result;
	}
	
	private boolean couldBe( Digit digit ) {
		
		Set<Segment> mustBeLit = digit.getLitSegments();
		Set<Segment> mustBeOff = digit.getOffSegments();
		
		Set<Segment> offButShouldNot = Sets.intersection( this.offSegments, mustBeLit );
		Set<Segment> litButShouldNot = Sets.intersection( this.litSegments, mustBeOff );
		
		if ( !offButShouldNot.isEmpty() || !litButShouldNot.isEmpty() ) {

			if ( logger.isDebugEnabled() ) {
				_logCouldBe( digit, offButShouldNot, litButShouldNot );
			}
			
			return false;
		}
		return true;
	}
	
	private void _logCouldBe( Digit digit, Set<Segment> offButShouldNot, Set<Segment> litButShouldNot ) {
	
		String logMsg =  "Reading cannot be digit " + digit.value + ". ";
		if ( !litButShouldNot.isEmpty() ) {
			logMsg += "These segments are lit, but must be off: ";
			for ( Segment seg : litButShouldNot ) {
				logMsg += " " + seg;
			}
			logMsg += ". ";
		}
		if ( !offButShouldNot.isEmpty() ) {
			logMsg += "These segments are off, but must be lit: ";
			for ( Segment seg : offButShouldNot ) {
				logMsg += " " + seg;
			}
			logMsg += ".";
		}
		logger.debug( logMsg );
	}
	
}
