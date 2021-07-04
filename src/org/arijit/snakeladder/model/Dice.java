package org.arijit.snakeladder.model;

public class Dice {
	private int minValue;
	private int maxvalue;
	private int currentValue;
	
	public Dice(int minValue, int maxvalue) {
		super();
		this.minValue = minValue;
		this.maxvalue = maxvalue;
	}

	public int getMinValue() { return minValue; }

	public int getMaxvalue() { return maxvalue; }

	public int getCurrentValue() { return currentValue; }
	
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	
	public int roll() {
		return this.getRandomNumber(minValue, maxvalue + 1);
	}
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
}
