package org.arijit.snakeladder.model;

public class Board {
	private int size;
	private int start;
	private int end;
	
	public int getSize() { return size; }
	
	public int getStart() {	return start; }
	
	public int getEnd() { return end; }

	public Board(int size) {
		super();
		this.size = size;
		this.start = 1;
		this.end = start + size - 1;
	}	
}
