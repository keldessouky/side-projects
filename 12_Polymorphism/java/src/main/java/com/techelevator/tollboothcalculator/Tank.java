package com.techelevator.tollboothcalculator;

public class Tank implements Vehicle {
	private int distance;

	public Tank(int distance) {
		this.distance = distance;
	}

	public String toString() {
		String formattedToll = String.format("$%.2f", calculateToll(distance));

		return String.format("%1$-18s %2$-22s %3$s", "Tank", distance, formattedToll);
	}

	public int getDistance() {
		return distance;
	}

	public double calculateToll(int distance) {
		return 0.0;
	}
}