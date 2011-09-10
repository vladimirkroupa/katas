package stoupa.acm11.clock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * Base class representing a two digits reading. 
 * 
 * @author stoupa
 */
public abstract class TwoDigitReading {

	protected final DigitReading digit1;
	protected final DigitReading digit2;
	
	public TwoDigitReading( DigitReading digit1, DigitReading digit2 ) {
		this.digit1 = digit1;
		this.digit2 = digit2;
	}

	/**
	 * Returns all possible values that the current reading could represent. 
	 * 
	 * @return set of all possible values
	 */
	public Set<Integer> getPossibleValues() {

		Set<Integer> result = new HashSet<Integer>();

		Set<Digit> minuteTens = digit1.getPossibleDigits();
		Set<Digit> minutes = digit2.getPossibleDigits();

		@SuppressWarnings("unchecked")
		Set<List<Digit>> combinations = Sets.cartesianProduct( minuteTens, minutes );
		for ( List<Digit> comb : combinations ) {
			Preconditions.checkState( comb.size() == 2 );

			String intValue = "" + comb.get( 0 ).value + comb.get( 1 ).value;
			int singleResult = Integer.parseInt( intValue );
			if ( isPossibleValue( singleResult ) ) {
				result.add( singleResult );
			}
		}
		return result;
	}

	/**
	 * Determines if the given two-digit value is valid.
	 * 
	 * @param value value to evaluate
	 * @return true if value is valid, false otherwise
	 */
	public abstract boolean isPossibleValue( int value );
	
}
