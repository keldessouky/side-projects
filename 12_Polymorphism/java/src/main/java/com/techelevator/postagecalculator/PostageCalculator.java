package com.techelevator.postagecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostageCalculator {
	
	
	public static void main (String[] args) {
	
	List<DeliveryDriver> listOfCarriers = new ArrayList<DeliveryDriver>();

	
	
	Scanner input = new Scanner(System.in);  //reference scanner notes for this
	
	System.out.print("Please enter the weight of the package? ");
	
	int weight = Integer.parseInt(input.nextLine());
	
	
	
	Scanner secondInput = new Scanner(System.in);  //reference scanner notes for this
	
	System.out.print("(P)ounds or (O)unces? ");
	
	String PoundsOrOuncesAnswer = secondInput.nextLine();
	
	if(PoundsOrOuncesAnswer.equalsIgnoreCase("P")) {
		weight = weight * 16;
		
	}
	
	
	
	Scanner thirdInput = new Scanner(System.in);  //reference scanner notes for this
	
	System.out.print("What distance will it be traveling? ");
	
	int distance = Integer.parseInt(thirdInput.nextLine());
	
	listOfCarriers.add(new PostalServiceFirstClass(distance, weight));
	listOfCarriers.add(new PostalServiceSecondClass(distance, weight));
	listOfCarriers.add(new PostalServiceThirdClass(distance, weight));
	listOfCarriers.add(new FexEd(distance, weight));
	listOfCarriers.add(new SPUFourDayGround(distance, weight));
	listOfCarriers.add(new SPUTwoDayBusiness(distance, weight));
	listOfCarriers.add(new SPUNextDay(distance, weight));
	
	
	System.out.println("\n"+ "Delivery Method                 $ cost");
	System.out.println("--------------------------------------");
	
	for (DeliveryDriver carrier : listOfCarriers) {
		System.out.println(carrier);
	}
	
	input.close();
	secondInput.close();
	thirdInput.close();
}
}