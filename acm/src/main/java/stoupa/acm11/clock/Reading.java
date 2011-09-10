package stoupa.acm11.clock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * Represents a time reading (hours and minute).
 * 
 * @author stoupa
 */
public class Reading {

	private HoursReading hours;
	private MinutesReading minutes;
	
	public Reading(DigitReading hourDigit1, DigitReading hourDigit2,
			DigitReading minuteDigit1, DigitReading minuteDigit2) {
		
		this.hours = new HoursReading( hourDigit1, hourDigit2 );
		this.minutes = new MinutesReading( minuteDigit1, minuteDigit2 );
	}
	
	public Set<Time> getPossibleValues() {
		
		Set<Time> result = new HashSet<Time>();
		
		Set<Integer> possibleHours = hours.getPossibleValues();
		Set<Integer> possibleMinutes = minutes.getPossibleValues();
		
		@SuppressWarnings("unchecked")
		Set<List<Integer>> combinations = Sets.cartesianProduct( possibleHours, possibleMinutes );
		
		for ( List<Integer> comb : combinations ) {
			Preconditions.checkState( comb.size() == 2 );
			
			int hours = comb.get( 0 );
			int minutes = comb.get( 1 );
			Time singleResult = new Time( hours, minutes ); 
			result.add( singleResult );
		}
		return result;
	}
	
}
