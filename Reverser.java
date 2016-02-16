import java.util.Scanner;

public class Reverser {

	static long Reverse(long num) {
		if (num != 0) {

			// prints the last digit of the number entered
			System.out.print(num % 10);

			// truncates the last digit of the number, and calls the function on
			// the new, truncated number.
			return Reverse(num / 10);

		} else {
			// breaks recursion and exits the function when there are no more
			// digits in the number
			return 0;
		}

	}

	public static void main(String[] args) {

		System.out.print("Please enter the number you want reversed: ");
		// setting up the input system
		Scanner number = new Scanner(System.in);
		long num = number.nextLong();
		//closing System.in after the long variable "number" is stored in the long variable "num"
		number.close();
		// prints out the reversed number
		System.out.print("\n" + "Your number reversed is: ");
		Reverse(num);
	}

}
