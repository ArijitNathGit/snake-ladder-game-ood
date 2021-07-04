package org.arijit.snakeladder.model;

public class Player {
	private String name;
	private int position;
	private boolean haveWon;
	
	public int getPosition() { return position; }
	
	public void setPosition(int position) { this.position = position; }
	
	public boolean isHaveWon() { return haveWon; }
	
	public void setHaveWon(boolean haveWon) { this.haveWon = haveWon; }
	
	public String getName() { return name; }

	public Player(String name) {
		super();
		this.name = name;
		this.position = 0;
		this.haveWon = Boolean.FALSE;
	}
}
