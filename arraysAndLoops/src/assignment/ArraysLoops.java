package assignment;

/**
 * ArrayLoops covers the Exercise 08 Array and Loops
 * This program does the array operation using various loops.
 *
 */
public class ArraysLoops {

	public static void main(String[] args) {

		int[] numberArray = { 1, 2, 3, 5, 7 };
		int sum = 0;
		System.out.println("Original Number Array"); // prints the original array.
		for (int i = 0; i < numberArray.length; i++)
			System.out.print(numberArray[i] + " ");

		System.out.println("\n \nPrinting Number Array in Reverse Order");

		int index = numberArray.length - 1;
		while (index >= 0) { // print in reverse order

			System.out.print(numberArray[index] + " "); // prints on same line, with spaces
			sum = sum + numberArray[index];// calculating the sum of number in array
			index = index - 1;
			
		}

		System.out.println("\n \nPrinting the length of array \n" + numberArray.length);
		System.out.print("\n \nSum of number in array \n" + sum);

	}
}