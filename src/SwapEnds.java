import java.util.Scanner;

public class SwapEnds {
    //Create an integer array method called SwapEnds that takes in an integer array "nums".
    // Given an array of ints, swap the first and last elements in the array. Return the modified
    // array. The array length will be at least 1.
    //
    //For example:
    //swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    //swapEnds([1, 2, 3]) → [3, 2, 1]
    //swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]

    public static void main(String[] args) {


        System.out.println("please enter a selection of numbers separated by space: ");

        try (Scanner input = new Scanner(System.in)) {

            String[] response = input.nextLine().split(" ");
            System.out.print("your array entered is: ");
            arrayPrinter(response);

            System.out.println();

            if (response.length > 1) {
                swapEnds(response);
            } else {
                System.out.println("please enter more numbers!");
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    public static String[] arrayPrinter(String[] response) {
        for (String num : response) {
            System.out.print(num + " ");
        }
        return response;
    }

    public static String[] swapEnds(String[] response) {

        int finalSpot = response.length - 1;
        String lastEntry = response[finalSpot];
        String firstEntry = response[0];
        response[0] = lastEntry;
        response[finalSpot] = firstEntry;
        System.out.print("after applying SwapEnds: ");
        for (String num : response) {
            System.out.print(num + " ");
        }

        return response;
    }

}
