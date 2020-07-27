package com.techelevator.tollboothcalculator;

public class Car implements Vehicle{
	private int distance;
	private boolean isPullingTrailer;

	public Car(int distance, boolean isPullingTrailer) { 
		this.distance = distance;
		this.isPullingTrailer = isPullingTrailer;
	}
	
	public String toString() {
		String formattedToll = String.format("$%.2f", calculateToll(distance));
		
		if(isPullingTrailer) {
			return String.format("%1$-16s %2$-22s %3$s", "Car (with trailer)", distance, formattedToll);
		}
		else {
		
			return String.format("%1$-18s %2$-22s %3$s", "Car", distance, formattedToll);
		}
	}
	
	public int getDistance() {
		return distance;
	}

	public boolean isPullingTrailer() {
		return isPullingTrailer;
	}

	public double calculateToll(int distance) {
		double toll = 0.020 * distance;
		
		if (isPullingTrailer) {
			toll += 1.00;
		}
		
		return toll;
	}
	
	

}