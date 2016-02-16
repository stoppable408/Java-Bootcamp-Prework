import java.util.Scanner;

/* Lennon Turner
 * 
 * DateCalc.Java
 * 
 * Console Application designed to take as input two dates in the form (Year, month, day), and return as output the total distance between the two dates in Years, Months, and Days.
 * 
 */
public class DateCalc {

	// *************************FUNCTION
	// PROTOTYPES*******************************//

	// Function getDate is designed to allow the user to input certain values
	// for dates, and accepts four arguments. the first argument is of type
	// Scanner, and moves the input from the main function, into the getDate
	// function. The second argument is of type string, and allows for the
	// substitution of words in the output, so
	// running the function with the input as "start year" changes the output to
	// "Enter start year: ".
	// the two integer arguments set a limit on acceptable values. it will
	// reject items greater than maxRange or less than then minRange, putting
	// the user in a do-while loop to retrieve an acceptable value
	static int getDate(Scanner input, String name, int minRange, int maxRange) {

		System.out.print("Enter " + name + ": ");
		int date = input.nextInt();
		if ((date < minRange) || (date > maxRange)) {
			do {
				System.out.print("Invalid entry, please enter a value between " + minRange + " and " + maxRange + ": ");
				date = input.nextInt();
			} while ((date > maxRange) || (date < minRange));

		} else {

			return date;
		}

		return date;

	}

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
		Scanner input = new Scanner(System.in);
		boolean twentyeight = false;
		boolean twentynine = false;
		boolean thirty = false;
		boolean leapyear = false;
		int startDay, startMonth, startYear, endDay, endYear, endMonth;

		// prompting user to enter the start year
		startYear = getDate(input, "start year", 1, 9999);
		// checks if the year is a leap year.
		if ((startYear % 4 == 0) && (startYear % 100 != 0)) {
			leapyear = true;
		}
		if ((startYear % 4 == 0) && (startYear % 100 == 0) && (startYear % 400 == 0)) {
			leapyear = true;
		}
		// prompting user to enter the start month
		startMonth = getDate(input, "start month", 1, 12);

		// the month has 29 days if it's February and a leap year
		if ((startMonth == 2) && (leapyear == true)) {
			startDay = getDate(input, "start day", 1, 29);
			twentynine = true;
		}
		// the month has 28 days if it's February and not a leap year
		else if ((startMonth == 2) && (leapyear == false)) {
			startDay = getDate(input, "start day", 1, 28);
			twentyeight = true;
		}
		// the month has 30 days if it's April, June, September, or November
		else if (((startMonth == 4) || (startMonth == 6) || (startMonth == 9) || (startMonth == 11))) {
			startDay = getDate(input, "start day", 1, 30);
			thirty = true;
		}
		// all other months have 31 days.
		else {
			startDay = getDate(input, "start day", 1, 31);
		}

		// prompting user to enter the end year
		endYear = getDate(input, "end year", 1, 9999);

		// prompting user to enter the end month
		endMonth = getDate(input, "end month", 1, 12);

		// the month has 29 days if it's February and a leap year
		if ((endMonth == 2) && (leapyear == true)) {
			endDay = getDate(input, "end day", 1, 29);
			twentynine = true;
		}
		// the month has 28 days if it's February and not a leap year
		else if ((endMonth == 2) && (leapyear == false)) {
			endDay = getDate(input, "end day", 1, 28);
			twentyeight = true;
		}
		// the month has 30 days if it's April, June, September, or November
		else if ((endMonth == 4) || (endMonth == 6) || (endMonth == 9) || (endMonth == 11)) {
			endDay = getDate(input, "end day", 1, 30);
			if (endMonth < startMonth) {
				thirty = true;
			}

		}
		// all other months have 31 days.
		else {
			endDay = getDate(input, "end day", 1, 31);
			if (startMonth > endMonth) {
				if (thirty == false) {
					thirty = true;
				} else {
					thirty = false;
				}
			}
		}
		input.close();
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
			if ((yearTotal == 0) && (monthTotal == 0)) {
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
