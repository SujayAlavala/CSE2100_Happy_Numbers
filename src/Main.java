import java.math.BigInteger;
import java.util.LinkedList;
/*
 * Sujay Alavala
 * Wei Wei
 * 9/23/16
 * CSE2100
 */


public class Main { //This class is where I test the numbers from 1-10000
					//I also test numbers that have at least 20 digits
	
	public static void main(String[] args) {
		
		for(int j = 1; j<10001;j++){ //This for loop goes through the numbers 1-10,000 
			ishappy("" + j, "" + j); //Converts each number into a string and then calls the ishappy method
		}
		
		System.out.print("Test:"); //Test of a 20 digit happy number
		ishappy20("5165135131351351351226122","5165135131351351351226122");
		System.out.print("Test:"); //Test of a 20 digit unhappy number
		ishappy20("5165135131351351351226124","5165135131351351351226124");
		
	}
	
	public static long sumofnum(String input){ //This takes the number as a string and sums the squares of each digit in the number and returns a long with the total.
		long total = 0;
		for(int i = 0; i <input.length(); i++){
			char number = input.charAt(i);    //extracts each digit in a number as a char	
			long sum = (long) Math.pow(Character.getNumericValue(number), 2); //Gets the numeric value of the char and then casts it as a long and then squares the number
			total += sum;	// stores the total of the squares
		}
		return total; //returns the total sum of the squares of each digit
	}
	public static void ishappy(String number, String input){ //Checks if the number is happy or not
		LinkedList<String> happylist = new LinkedList<String>(); //Creates a happy linked list
		LinkedList<String> unhappylist = new LinkedList<String>(); //Creates a unhappy linked list
		long tester = sumofnum(input); //sets up a long that stores the output of sumofnum for later
		int cond = 0; //Int Condition statement for if statement later 
		BigInteger number2 = new BigInteger(number); //Creates instance of BigInteger with the value of 'number'(parameter)
		BigInteger min = new BigInteger("9000"); //Creats a BigInteger with the value of 9000
		if(cond == 0){ //Condition statement to break out of the loop
			if(tester == 1){ //if the output of sumofnum = 1, then the number is happy
				cond = 1; //So it breaks out of the loop
				happylist.addLast(number); //adds the number to the happy linked list
				if(number2.compareTo(min) > 0){ //if the parameter is > than 9000 it will print that its a happy number
					System.out.println("The number " + number + " is a happy number");
				}
			}
			else if(unhappylist.contains(number)){ //compares the number to the existing list of unhappy numbers 
				cond = 1;
			}
			else if(tester == 4){ //If the output of sumofnum = 4 then it's an unhappy number
				cond = 1; //breaks the loop
				unhappylist.addLast(number); //adds number to the unhappy list
				//System.out.println("The number " + number + " is an unhappy number");
			}
			else{
				ishappy(number, "" + tester); //If it does not meet any requirments it recurses back to ishappy, but with a new String, its the value from sumofnums
			}
		}
	}
	public static long sumof20(String input){ //This is for testing numbers with greater than 20 digits
											  //I could have done this in my other method, but I didn't want to add it to my linked list
		long total = 0;
		for(int i = 0; i <input.length(); i++){
			char numberAt = input.charAt(i);
			long sum = (long) Math.pow(Character.getNumericValue(numberAt), 2);
			total += sum;	
		}
		return total;
	}
	
	public static void ishappy20(String number, String input){ //Again this is for testing for numbers with greater than 20 digits
		 													   //It does the exact same thing as above, but has a few less steps and prints out the intermediate results
		long tester = sumof20(input);
		int cond = 0;
		if(cond == 0){
			if(tester == 1){
				cond = 1;
				System.out.println(input); //Prints the intermediate result
				System.out.println("The number " + number + " is a happy number");
			}
			else if(tester == 4){
				cond = 1;
				System.out.println(input); //Prints intermediate result
				System.out.println("The number " + number + " is a unhappy number");
			}
			else{
				System.out.println(input);
				ishappy20(number, "" + sumof20(input));
			}
		}
	}

	
	
}