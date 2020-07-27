package com.techelevator.postagecalculator;

public class PostalServiceThirdClass implements DeliveryDriver {
	private int distance;
	private int weight;

	public PostalServiceThirdClass(int distance, int weight) {
		this.distance = distance;
		this.weight = weight;
	}
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distance, weight));
		return String.format("%1$-31s %2$s", "Postal Service (3rd Class)", formattedRate);
	}

	@Override
	public double calculateRate(int distance, double weight) {
		
		double ratePerMile = 0.00;



		if (weight <= 2) {
			ratePerMile = 0.0020;
		} 
		else if (weight <= 8) {
			ratePerMile = 0.0022;
		} 
		else if (weight <= 15) {
			ratePerMile = 0.0024;
		} 
		else if (weight <= 16) {
			ratePerMile = 0.0150;
		} 
		else if (weight <= 128) {
			ratePerMile = 0.0160;
		} 
		else {
			ratePerMile = 0.0170;
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
