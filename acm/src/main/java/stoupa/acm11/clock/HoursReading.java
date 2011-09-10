package stoupa.acm11.clock;

/**
 * Represents a hours reading.
 * 
 * @author stoupa
 */
public class HoursReading extends TwoDigitReading {

	public HoursReading(DigitReading hourDigit1, DigitReading hourDigit2) {
		
		super(hourDigit1, hourDigit2);
	}

	@Override
	public boolean isPossibleValue(int value) {
		
		if ( value >= 0 && value < 24  ) {
	    	return true;
	    }
		return false;
	}
	
}
