package com.techelevator.tollboothcalculator;

public class Truck implements Vehicle {
	private int distance;
	private int numberOfAxels;

	public Truck(int distance, int numberOfAxels) {
		this.distance = distance;
		this.numberOfAxels = numberOfAxels;
	}
	
	public String toString() {
		String formattedToll = String.format("$%.2f", calculateToll(distance));
		
		if(numberOfAxels == 4) {
			return String.format("%1$-18s %2$-22s %3$s", "Truck (4 axles)", distance, formattedToll);
		}
		else if (numberOfAxels == 6) {
			return String.format("%1$-18s %2$-22s %3$s", "Truck (6 axles)", distance, formattedToll);
		}
		else {
			return String.format("%1$-18s %2$-22s %3$s", "Truck (8 axles)", distance, formattedToll);
		}
		
	}
	
	public int getDistance() {
		return distance;
	}

	public int getNumberOfAxels() {
		return numberOfAxels;
	}

	public double calculateToll(int distance) {
		double ratePerMile = 0.0;
		
		if (numberOfAxels < 6) {
			ratePerMile = 0.040;
		} else if (numberOfAxels < 8) {
			ratePerMile = 0.045;
		} else {
			ratePerMile = 0.048;
		}
		
		return ratePerMile * distance;
	}
}