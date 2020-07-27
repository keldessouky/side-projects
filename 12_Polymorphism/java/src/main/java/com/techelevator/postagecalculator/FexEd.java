package com.techelevator.postagecalculator;

public class FexEd implements DeliveryDriver {
	private int distance;
	private int weight;
	
	
	public FexEd (int distance, int weight) {
		this.distance = distance;
		this.weight = weight;
	}
	
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distance, weight));
		return String.format("%1$-31s %2$s", "FexEd", formattedRate);
	}
		
	public int getDistance() {
		return distance;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 20.00;
		
		if(distance > 500) {
			rate += 5.00;
		}
		if(weight > 48) {
			rate += 3.00;
		}
		return rate;
	}

}
