package stoupa.acm11.clock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public class MinutesReading {

	private DigitReading minuteDigit1;
	private DigitReading minuteDigit2;

	public MinutesReading(DigitReading minuteDigit1, DigitReading minuteDigit2) {
		this.minuteDigit1 = minuteDigit1;
		this.minuteDigit2 = minuteDigit2;
	}
	
	// TODO: extract method
	public Set<Integer> getPossibleValues() {
		
		Set<Integer> result = new HashSet<Integer>();
		
		Set<Digit> minuteTens = minuteDigit1.getPossibleDigits();
		Set<Digit> minutes = minuteDigit2.getPossibleDigits();
		
		@SuppressWarnings("unchecked")
		Set<List<Digit>> combinations = Sets.cartesianProduct( minuteTens, minutes );
		for ( List<Digit> comb : combinations ) {
			Preconditions.checkState( comb.size() == 2 );
			
			String intValue = "" + comb.get( 0 ).value + comb.get( 1 ).value;
		    int singleResult = Integer.parseInt( intValue );
		    if ( singleResult >= 0 && singleResult < 60 ) {
		    	result.add( singleResult );
		    }
		}
		return result;
	}
	
}
