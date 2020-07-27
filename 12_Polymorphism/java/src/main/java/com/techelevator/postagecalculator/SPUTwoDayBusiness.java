package com.techelevator.postagecalculator;

public class SPUTwoDayBusiness implements DeliveryDriver {
	
	private int distance;
	private int weight;
	
	public SPUTwoDayBusiness(int distance, int weight) {
		this.distance = distance;
		this.weight = weight;
	}

	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distance, weight));
		return String.format("%1$-31s %2$s", "SPU (2-Day Business)", formattedRate);
	}
	public int getDistance() {
		return distance;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public double calculateRate(int distance, double weight) {
		
		double rate;
		double ouncesToPounds = weight/16;
		ouncesToPounds = ouncesToPounds * 0.050;
		rate = ouncesToPounds * distance;
		return rate;
	}
	
	

}
