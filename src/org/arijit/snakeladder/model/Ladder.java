package org.arijit.snakeladder.model;

public class Ladder {
	private int start;
	private int end;
	
	public int getStart() { return start; }
	
	public int getEnd() { return end; }

	public Ladder(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null ) return false;
		
		if( !(obj instanceof Ladder) ) return false;
		
		if( ((Ladder) obj).start != this.start  || ((Ladder) obj).end != this.end ) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 37;
		result += result * this.start;
		result += 31 * this.end;
		return result;
	}
}
