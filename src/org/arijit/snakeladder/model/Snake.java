package org.arijit.snakeladder.model;

public class Snake {
	private int head;
	private int tail;
	
	public int getHead() { return head; }
	
	public int getTail() { return tail; }

	public Snake(int head, int tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null ) return false;
		
		if( !(obj instanceof Snake) ) return false;
		
		if( ((Snake) obj).head != this.head  || ((Snake) obj).tail != this.tail ) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 37;
		result += result * this.head;
		result += 31 * this.tail;
		return result;
	}
}
