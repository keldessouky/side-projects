package com.techelevator;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
	
	Scanner bill = new Scanner(System.in);

	System.out.print("Please enter the amount of your bill: ");
	String billTotal = bill.nextLine();
	float billTotalFloat = Float.parseFloat(billTotal);
	
	System.out.print("Please enter the amount tendered: ");
	String amountTendered = bill.nextLine();
	float amountTenderedFloat = Float.parseFloat(amountTendered);
	
	float change = amountTenderedFloat - billTotalFloat;
	
	System.out.println("The change required is " + change);
	
	
	
	bill.close();
	}
	

}
