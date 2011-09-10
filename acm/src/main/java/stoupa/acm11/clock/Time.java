package stoupa.acm11.clock;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

public class Time implements Comparable<Time> {

	private final int hours;
	private final int minutes;
	
	public Time( int hours, int minutes ) {
		
		this.hours = hours;
		this.minutes = minutes;
		Preconditions.checkArgument( isValid() );
	}

	public Time( int minutes ) {
		
		this.hours = minutes / 60;
		this.minutes = minutes % 60;
	}
	
	/**
	 * Adds the given time to this time. If the result is in another day, 
	 * the day information is lost as this class doesn't track days. 
	 * 
	 * @param addend time to add 
	 * @return resulting time
	 */
	public Time add( Time addend ) {
		
		int minuteSum = this.minutes + addend.minutes; 
		int hoursFromMinutesOver60 = ( minuteSum ) / 60; 

		int resultMinutes = ( minuteSum ) % 60;
		int resultHours = ( this.hours + addend.hours + hoursFromMinutesOver60 ) % 24;
		
		return new Time( resultHours, resultMinutes );
	}

	
	public boolean isBefore( Time other ) {
		
		if ( this.hours < other.hours ) {
			return true;
		} else if ( this.hours > other.hours ) {
			return false;
		}
		// same hours 
		else if ( this.minutes < other.minutes ) {
			return true;
		} else if ( this.minutes > other.minutes ) {
			return false;
		} 
		// same		
		return false;
	}
	
	public boolean isValid() {
		if ( hours < 0 || hours >= 24 ) {
			return false;
		}
		if ( minutes < 0 || minutes >= 60 ) {
			return false;
		}
		return true;
	}
	
	public int compareTo( Time other ) {

		if ( this.equals( other ) ) {
			return 0;
		} else if ( this.isBefore( other ) ) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Time other = (Time) obj;
		if ( !Objects.equal( hours, other.hours ))
			return false;
		if ( !Objects.equal( minutes, other.minutes ) )
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode( hours, minutes );
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add( "hours", hours )
				.add( "minutes", minutes )
				.toString();
	}

	
	
}
