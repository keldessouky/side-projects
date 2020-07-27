package com.techelevator.tollboothcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TollCalculator {
	
	public static void main (String[] args) {
		List<Vehicle> vehicleToll = new ArrayList<Vehicle>();
		
		int min = 10;
		int max = 241;
		int totesDist = 0;
		double totesRevenue = 0;
		
		Car carNoTrailer = new Car(ThreadLocalRandom.current().nextInt(min, max), false);
		Car carWithTrailer = new Car(ThreadLocalRandom.current().nextInt(min, max), true);
		Tank tank = new Tank(ThreadLocalRandom.current().nextInt(min, max));
		Truck truck6 = new Truck (ThreadLocalRandom.current().nextInt(min, max), 6);
		Truck truck4 = new Truck (ThreadLocalRandom.current().nextInt(min, max), 4);
		Truck truck8 = new Truck(ThreadLocalRandom.current().nextInt(min, max), 8);
		
		
		
		vehicleToll.add(carNoTrailer);
		vehicleToll.add(carWithTrailer);
		vehicleToll.add(tank);
		vehicleToll.add(truck4);
		vehicleToll.add(truck6);
		vehicleToll.add(truck8);
	
		
		System.out.println("Vehicle          Distance Traveled         Toll $");
		System.out.println("--------------------------------------------------");
		
		for (Vehicle vehicle : vehicleToll) {
			System.out.println(vehicle);
			totesDist += vehicle.getDistance();
			totesRevenue += vehicle.calculateToll(vehicle.getDistance());
		}
		String formattedRevenue = String.format("$%.2f", totesRevenue);
		
		System.out.println("\n" + "Total Miles Traveled: " + totesDist);
		System.out.println("Total Tollbooth Revenue: " + formattedRevenue);
	}
}