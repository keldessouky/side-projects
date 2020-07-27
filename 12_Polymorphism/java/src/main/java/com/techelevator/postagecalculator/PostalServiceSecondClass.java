package com.techelevator.postagecalculator;

public class PostalServiceSecondClass implements DeliveryDriver {
	private int distance;
	private int weight;

	public PostalServiceSecondClass(int distance, int weight) {
		this.distance = distance;
		this.weight = weight;
	}
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distance, weight));
		return String.format("%1$-31s %2$s", "Postal Service (2nd Class)", formattedRate);
	}

	@Override
	public double calculateRate(int distance, double weight) {
		
		double ratePerMile = 0.00;



		if (weight <= 2) {
			ratePerMile = 0.0035;
		} 
		else if (weight <= 8) {
			ratePerMile = 0.0040;
		} 
		else if (weight <= 15) {
			ratePerMile = 0.0047;
		} 
		else if (weight <= 16) {
			ratePerMile = 0.0195;
		} 
		else if (weight <= 128) {
			ratePerMile = 0.0450;
		} 
		else {
			ratePerMile = 0.0500;
		}

		 return distance * ratePerMile;
		
		
	}

	public int getDistance() {
		return distance;
	}

	public int getWeight() {
		return weight;
	}

}
