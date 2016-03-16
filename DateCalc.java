import java.util.Scanner;

/* Lennon Turner
 * 
 * DateCalc.Java
 * 
 * Console Application designed to take as input two dates in the form (Year, month, day), and return as output the total distance between the two dates in Years, Months, and Days.
 * 
 */
public class DateCalc {

	// Function monthName is designed to change month numbers into their name
	// equivalent, it accepts as input an integer number that represents the
	// number of the month, and returns, as output, a String representing the
	// name of the month.
	static String monthName(int monthNum) {
		int num = monthNum;
		String monthName;
		switch (num) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;

		default:
			monthName = "Invalid Month";
		}
		return monthName;
	}

	// Function dayEnding places proper endings on the day of the month. takes
	// as an argument an integer representing the day of the month, and outputs
	// the proper ending as type String.
	static String dayEnding(int day) {
		String ending;
		switch (day) {
		case 1:
		case 21:
		case 31:
			ending = "st";
			break;
		case 2:
		case 22:
			ending = "nd";
			break;
		case 3:
		case 23:
			ending = "rd";
			break;
		default:
			ending = "th";

		}
		return day + ending;
	}
	// ******END OF FUNCTION PROTOTYPES***//

	// ******MAIN FUNCTION***////
	public static void main(String[] args) {

		boolean leapyear = false, twentyeight = false, twentynine = false, thirty = false;

		// Setting up the input for the start date.
		Scanner number = new Scanner(System.in);
		System.out.print("Enter start date (Format: MMDDYYYY): ");
		String startDate = number.nextLine();

		// changes the string 'startdate' into an array of characters
		char[] integer = startDate.toCharArray();

		// checks to see if the user has entered the appropriate number of
		// characters. if not, it asks the user for the input again.
		if (integer.length != 8) {
			do {
				System.out.println("Invalid Input. Please try again");
				startDate = number.nextLine();
				integer = startDate.toCharArray();
			} while (integer.length != 8);
		}

		// creates an empty integer array that's the same length of the
		// character array, then proceeds to use a for loop to populate the
		// integer array with the integer equivalent of the characters from the
		// character array.
		int[] numspace = new int[startDate.length()];
		for (int i = 0; i < integer.length; i++) {
			numspace[i] = startDate.charAt(i) - '0';
		}

		// Calculates the start Year, Month, and Day from the integer array and
		// places them in a variable.
		int startYear = ((numspace[4] * 1000) + (numspace[5] * 100) + (numspace[6] * 10) + numspace[7]);
		int startMonth = ((numspace[0] * 10) + numspace[1]);
		int startDay = ((numspace[2] * 10) + numspace[3]);

		// Checks to see if the start year is a leap year.
		if ((startYear % 4 == 0) && (startYear % 100 != 0)) {
			leapyear = true;
		}
		if ((startYear % 4 == 0) && (startYear % 100 == 0) && (startYear % 400 == 0)) {
			leapyear = true;
		}

		// Checks to make sure the year is greater than 1 and less than 9999. if
		// not, it will ask the user for new input.
		if ((startYear < 1) || (startYear > 9999)) {
			Scanner year = new Scanner(System.in);
			do {
				System.out.print("Invalid Year. Please enter a value between 1 and 9999: ");
				startYear = year.nextInt();
			} while ((startYear < 1) || (startYear > 9999));
			year.close();
		}

		// Checks to make sure the month is within the acceptable range of 1-12
		if ((startMonth < 1) || (startMonth > 12)) {
			Scanner month = new Scanner(System.in);
			do {
				System.out.print("Invalid Month. Please enter a value between 1 and 12: ");
				startMonth = month.nextInt();
			} while ((startMonth < 1) || (startMonth > 12));
			month.close();
		}

		// Only allows certain days depending on the month, and whether or not
		// it's a leap year.
		// if the month is February, and it's a leap year, then the month can
		// only have a maximum of 29 days.
		if ((startMonth == 2) && (leapyear == true)) {
			twentynine = true;
			if (startDay > 29) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. February only has 29 days. Please choose a day that is less than 30:");
					startDay = day.nextInt();
				} while (startDay > 29);
				day.close();
			}
		}

		// if the month is February and it's not a leap year, the month has a
		// maximum of 28 days.
		else if ((startMonth == 2) && (leapyear == false)) {
			twentyeight = true;
			if (startDay > 28) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. February only has 28 days. Please choose a day that is less than 29:");
					startDay = day.nextInt();
				} while (startDay > 28);
				day.close();
			}
		}
		// if the month has 30 days, the maximum amount of days is 30.
		else if (((startMonth == 4) || (startMonth == 6) || (startMonth == 9) || (startMonth == 11))) {
			thirty = true;
			if (startDay > 30) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. this month only has 30 days. Please choose a day that is less than 31:");
					startDay = day.nextInt();
				} while (startDay > 30);
				day.close();
			}
		}

		// otherwise, all other months have 31 days
		else {
			if (startDay > 31) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. this month only has 31 days. Please choose a day that is less than 32:");
					startDay = day.nextInt();
				} while (startDay > 31);
				day.close();
			}

		}

		// asking the user for input for the end date.
		System.out.print("Enter end date (Format: MMDDYYYY): ");
		String endDate = number.nextLine();
		integer = endDate.toCharArray();

		// if the end date is less than 8 characters, it's invalid.
		if (integer.length != 8) {
			do {
				System.out.println("Invalid Input. Please try again");
				startDate = number.nextLine();
				integer = endDate.toCharArray();
			} while (integer.length != 8);
		}

		// populating an integer array with the items from the character array
		numspace = new int[endDate.length()];
		for (int i = 0; i < integer.length; i++) {
			numspace[i] = endDate.charAt(i) - '0';
		}

		// calculates the end year, month, and day using the numbers from the
		// array
		int endYear = ((numspace[4] * 1000) + (numspace[5] * 100) + (numspace[6] * 10) + numspace[7]);
		int endMonth = ((numspace[0] * 10) + numspace[1]);
		int endDay = ((numspace[2] * 10) + numspace[3]);

		// if the month is February, and it's a leap year, then the month can
		// only have a maximum of 29 days.

		if ((endMonth == 2) && (leapyear == true)) {
			twentynine = true;
			if (endDay > 29) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. February only has 29 days. Please choose a day that is less than 30:");
					endDay = day.nextInt();
				} while (endDay > 29);
				day.close();
			}
		}
		// if the month is February and it's not a leap year, the month has a
		// maximum of 28 days.

		else if ((endMonth == 2) && (leapyear == false)) {
			twentyeight = true;
			if (endDay > 28) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. February only has 28 days. Please choose a day that is less than 29:");
					endDay = day.nextInt();
				} while (endDay > 28);
				day.close();
			}
		}
		// if the month has 30 days, the maximum amount of days is 30.

		else if (((endMonth == 4) || (endMonth == 6) || (endMonth == 9) || (endMonth == 11))) {
			thirty = true;
			if (endDay > 30) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. this month only has 30 days. Please choose a day that is less than 31:");
					endDay = day.nextInt();
				} while (endDay > 30);
				day.close();
			}
		}
		// otherwise, all other months have 31 days

		else {
			if (endDay > 31) {
				Scanner day = new Scanner(System.in);
				do {
					System.out.print(
							"Invalid Date. this month only has 31 days. Please choose a day that is less than 32:");
					endDay = day.nextInt();
				} while (endDay > 31);
				day.close();
			}

		}

		number.close();
		// subtracts the two dates from each other to get the total years, days
		// and months
		int yearTotal = endYear - startYear;
		int dayTotal = endDay - startDay;
		int monthTotal = endMonth - startMonth;

		// if the user inputs a date later than the end date, as the start date,
		// this block of code will reverse the two dates to make the subtraction
		// work.
		if (endYear < startYear) {
			yearTotal = startYear - endYear;
			dayTotal = startDay - endDay;
			monthTotal = startMonth - endMonth;
		}
		// if the user inputs a date later than the end date, but with the same
		// year (thus invalidating the above if-statement) this will invert the
		// month and day values.
		else if ((yearTotal == 0) && (endMonth < startMonth)) {
			dayTotal = startDay - endDay;
			monthTotal = startMonth - endMonth;

		}
		// if the user inputs a date later than the end dates, but with
		// equivalent year and month values, it will only invert the day value.
		else if ((yearTotal == 0) && (monthTotal == 0) && (endDay < startDay)) {
			dayTotal = startDay - endDay;
		}

		// if the total number of days is negative, it will subtract one from
		// the month value, and add a number to the day value.
		if ((dayTotal) < 0) {
			monthTotal -= 1;

			boolean withinMonth = false;
			if (monthTotal == 0) {
				withinMonth = true;
			}
			// only adds 28 days if the month is February
			if ((withinMonth == true) && (twentyeight == true))
				dayTotal = 28 + dayTotal;
			else if ((withinMonth == true) && (twentynine == true)) {
				dayTotal = 29 + dayTotal;
			}

			else if ((withinMonth == true) && (thirty == true)) {
				dayTotal = 30 + dayTotal;
			} else {
				dayTotal = 31 + dayTotal;
			}
		}

		// if the total number of months is negative, it will subtract one from
		// the year value, and add 12 to the month value
		if ((monthTotal) < 0) {
			yearTotal -= 1;
			monthTotal = 12 + monthTotal;
		}
		// Translates the month number into the name of the month.
		String startMonthName = monthName(startMonth);
		String endMonthName = monthName(endMonth);
		String startDayEnd = dayEnding(startDay);
		String endDayEnd = dayEnding(endDay);
		System.out.println("The total number of Years, Months, and Days from " + startMonthName + ", " + startDayEnd
				+ ", " + startYear + " to " + endMonthName + ", " + endDayEnd + ", " + endYear + " is:");

		// Changes plural words to the singular form if there is only one of
		// them.
		String yearWord = "Years";
		String monthWord = "Months";
		String dayWord = "Days";
		if (yearTotal == 1) {
			yearWord = "Year";
		}
		if (monthTotal == 1) {
			monthWord = "Month";
		}
		if (dayTotal == 1) {
			dayWord = "Day";
		}

		System.out.println(yearTotal + " " + yearWord + ", " + monthTotal + " " + monthWord + ", and " + dayTotal + " "
				+ dayWord + ".");
	}
}
