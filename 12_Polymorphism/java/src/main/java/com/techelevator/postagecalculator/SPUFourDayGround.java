package com.techelevator.postagecalculator;

public class SPUFourDayGround implements DeliveryDriver{

	
	private int distance;
	private int weight;
	
	
	public SPUFourDayGround(int distance, int weight) {
		this.distance = distance;
		this.weight = weight;
	}
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distance, weight));
		return String.format("%1$-31s %2$s", "SPU (4-Day Ground)", formattedRate);
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
		ouncesToPounds = ouncesToPounds * 0.005;
		rate = ouncesToPounds * distance;
		return rate;
	}
	
	

}
