package stoupa.acm11.clock;

/**
 * Represents a minutes reading.
 * 
 * @author stoupa
 */
public class MinutesReading extends TwoDigitReading {

	public MinutesReading( DigitReading minuteDigit1, DigitReading minuteDigit2 ) {
		
		super( minuteDigit1, minuteDigit2 );
	}

	@Override
	public boolean isPossibleValue( int value ) {
		
		if ( value >= 0 && value < 60 ) {
	    	return true;
	    }
		return false;
	}
	
}
