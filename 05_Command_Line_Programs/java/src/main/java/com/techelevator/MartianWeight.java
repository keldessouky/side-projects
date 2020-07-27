package com.techelevator;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
import java.util.Scanner;

public class MartianWeight {

	public static void main(String[] args) {
		Scanner martianWeights = new Scanner(System.in);
		
		System.out.print("Enter a series of Earth weights (space-separated): ");
		String earthWeights = martianWeights.nextLine();
		String[] inputWeights = earthWeights.split(" ");
		for (int i = 0; i < inputWeights.length; i++) {
			String weights = inputWeights[i];
			float weightAsFloat = Float.parseFloat(weights);
			int weightAsInt = (int) weightAsFloat;
			float marsWeight = weightAsFloat * 0.378F;
			int marsWeightInt = (int) marsWeight;

			System.out.println(weightAsInt + " lbs. on Earth, is " + marsWeightInt + " lbs. on Mars.");
			
		

	}  
		martianWeights.close();
}
}

//Scanner martianWeights = new Scanner(System.in);
//
//System.out.print("Enter a series of Earth weights (space-separated): ");
//String earthWeights = martianWeights.nextLine();
//String[] inputWeights = earthWeights.split(" ");
//for (int i = 0; i < inputWeights.length; i++) {
//	String weights = inputWeights[i];
//	float weightAsFloat = Float.parseFloat(weights);
//	//int weightAsInt = (int) weightAsFloat;
//	float marsWeight = weightAsFloat * 0.378F;
//	//int marsWeightInt = (int) marsWeight;
//
////	System.out.printf("%.2f",weightAsFloat + " lbs. on Earth, is " + "%.2f",marsWeight + " lbs. on Mars.");