package stoupa.acm11.clock;

import java.util.EnumSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public enum Digit {

	ZERO( 0 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.MIDDLE );
			return EnumSet.complementOf( unLit );
		}
	},
	
	ONE( 1 ) {
		@Override
		public Set<Segment> getLitSegments() {
			return EnumSet.of( Segment.UPPER_RIGHT, Segment.LOWER_RIGHT );
		}
	},
	
	TWO( 2 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.UPPER_LEFT, Segment.LOWER_RIGHT );
			return EnumSet.complementOf( unLit );
		}
	},
	
	THREE( 3 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.UPPER_LEFT, Segment.LOWER_LEFT );
			return EnumSet.complementOf( unLit );
		}
	},
	
	FOUR( 4 ) {
		@Override
		public Set<Segment> getLitSegments() {
			return EnumSet.of( Segment.UPPER_LEFT, Segment.MIDDLE, Segment.LOWER_RIGHT );
		}
	},
	
	FIVE( 5 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.UPPER_RIGHT, Segment.LOWER_LEFT );
			return EnumSet.complementOf( unLit );
		}
	},
	
	SIX( 6 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.UPPER_RIGHT );
			return EnumSet.complementOf( unLit );
		}
	},
	
	SEVEN( 7 ) {
		@Override
		public Set<Segment> getLitSegments() {
			return EnumSet.of( Segment.TOP, Segment.UPPER_RIGHT, Segment.LOWER_RIGHT );
		}
	},
	
	EIGHT( 8 ) {
		@Override
		public Set<Segment> getLitSegments() {
			return EnumSet.allOf( Segment.class );
		}
	},
	
	NINE( 9 ) {
		@Override
		public Set<Segment> getLitSegments() {
			EnumSet<Segment> unLit = EnumSet.of( Segment.LOWER_LEFT );
			return EnumSet.complementOf( unLit );
		}
	};
	
	abstract public Set<Segment> getLitSegments();
	
	public Set<Segment> getOffSegments() {
		
		return Sets.complementOf( getLitSegments() ); 
	}
	
	public final int value;
	
	private Digit( int value ) {
		this.value = value;
	}

	static Digit getDigitFor( int value ) {
		Preconditions.checkArgument( value >= 0 && value <= 9, "Digit value must be between 0 and 9 " );
		
		switch ( value ) {
			case 0 : return ZERO; 
			case 1 : return ONE;
			case 2 : return TWO;
			case 3 : return THREE;
			case 4 : return FOUR;
			case 5 : return FIVE;
			case 6 : return SIX;
			case 7 : return SEVEN;
			case 8 : return EIGHT;
			case 9 : return NINE;
		}
		throw new IllegalStateException( "Supposed to be unreachable!" );
	}
	
	@Override
	public String toString() {
		return "Digit [" + value + "]";
	}
	
}
