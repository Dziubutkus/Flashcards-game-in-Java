// Author: Dziugas Butkus
// Description: Program generates 10 random questions of 3 types, user has to answer as many as he can. 

import java.util.Scanner;

public class Flashcards2
{
	public static Scanner input = new Scanner(System.in);
	public static double EPSILON = 1E-14;
	public static void main( String[ ] args )
	{
		double lowest; // Lowest range of math problems
		double highest; // Highest range of math problems
		int type; // Question type
		int number1, number2; // Random integers for equations
		double number3 = 0, number4 = 0; // Random real numbers for equations
		char play; // Do you want to play again?
		int scoreInt = 0, scoreDbl = 0, scoreMod = 0; // Track scores of different types of questions
		int realq = 0, intq = 0, modq = 0; // Number of question types
		int score = 0; // Player's score
		boolean rightOrWrong; // Returns true if user's answer is correct, false if incorrect
		
		System.out.println ( "Set the range for the equation.\nEnter the lowest number: " );
		lowest = input.nextDouble ( );
		do { // Setting the range for problems
			System.out.println ( "Enter the highest number: " );
			highest = input.nextDouble ( );
			if(highest <= lowest)
			{
				System.out.println ( "Your highest value can't be lower or equal to lowest." );
			}
		}while(highest <= lowest);
		
		for(int i = 0; i < 10; i++) // 10 questions max
		{
			// Generate question type
			type = (int)((Math.random() * 3) + 1);
			switch(type)
			{
				case 1:
					number3 = generateNumber(highest, lowest);
					number4 = generateNumber(highest, lowest);
					number3 = Math.round ( number3 * 100.0 ) / 100.0; // Rounds number to 2 decimal points
					number4 = Math.round ( number4 * 100.0 ) / 100.0;
					if(number4 == 0) // To prevent 'number/0' from happening
					{
						i--;
					}
					else
					{
						rightOrWrong = realDivision(number3, number4);
						if(rightOrWrong == true)
						{
							score++;
							scoreDbl++;
						}
						realq++;
					}
					break;
				case 2:
					number1 = (int)generateNumber(highest, lowest);
					number2 = (int)generateNumber(highest, lowest);
					if(number2 == 0)
					{
						i--;
					}
					else
					{
						rightOrWrong = integerDivision(number1, number2);
						if(rightOrWrong == true)
						{
							score++;
							scoreInt++;
						}
						intq++;
					}
					break;
				case 3:
					number1 = (int)generateNumber(highest, lowest);
					number2 = (int)generateNumber(highest, lowest);
					if(number2 == 0)
					{
						i--;
					}
					else
					{
						number3 = number1 * 1.0;
						number4 = number2 * 1.0;
						rightOrWrong = modulusDivision(number3, number4);
						if(rightOrWrong == true)
						{
							score++;
							scoreMod++;
						}
						modq++;
					}
					break;
				}
				if(i == 9)
				{
					System.out.println ( "\nYour score is: " + score + " out of 10");
					System.out.println ("Real division correct answers: " + scoreDbl + " out of " + realq +
							"\nInteger division correct answers: " + scoreInt + " out of " + intq + "\nModulus division correct answers: "
							+ scoreMod + " out of " + modq);
					System.out.println("Do you want to try the quiz again? (Type \'y\' if yes):");
					play = input.next ( ).charAt ( 0 );
					if(play == 'y')
					{
						i = 0;
						score = 0;
						System.out.println ( "Set the range for the equation.\nEnter the lowest number: " );
						lowest = input.nextDouble ( );
						System.out.println ( "Enter the highest number: " );
						highest = input.nextDouble ( );
					}
				}
			}
			input.close();
	}
	
	/*
	 * generateNumber
	 * Generates random number between lowest and highest passed numbers
	 * returns number as double
	 * Author: Dziugas Butkus
	 */
	public static double generateNumber(double highest, double lowest)
	{
		double number;
		number = Math.random() * (highest - lowest + 1) + lowest;
		return number;
	}
	
	/*
	 * integerDivision
	 * generates an integer division problem, user has to answer it
	 * returns true or false depending if the answer is correct
	 * Author: Dziugas Butkus
	 */
	public static boolean integerDivision(int number1, int number2)
	{
		int answer;
		boolean rightOrWrong;
		System.out.println ( "\nInteger division question\nEnter the answer for the following problem: " );
		System.out.print ( number1 + " / " + number2 + " = " );
		answer = input.nextInt ( );
		System.out.println (  );
		if(answer == number1 / number2)
		{
			System.out.println ( "The answer is CORRECT!" );
			rightOrWrong = true;
		}
		else
		{
			System.out.println ( "The answer is WRONG! The right answer is: " + number1 / number2 );
			rightOrWrong = false;
		}
		return rightOrWrong;
	}
	
	/*
	 * modulusDivision
	 * generates a modulus division problem, user has to answer it
	 * returns true or false depending if the answer is correct
	 * Author: Dziugas Butkus
	 */
	public static boolean modulusDivision(double number3, double number4)
	{
		double answer;
		boolean rightOrWrong;
		System.out.println ( "\nModulus division question\nEnter the answer for the following problem: " );
		System.out.print ( number3 + " / " + number4 + " = " );
		answer = input.nextDouble ( );
		System.out.println (  );
		if(answer == number3 / number4)
		{
			System.out.println ( "The answer is CORRECT!" );
			rightOrWrong = true;
		}
		else
		{
			System.out.println ( "The answer is WRONG! The right answer is: " + number3 / number4 );
			rightOrWrong = false;
		}
		return rightOrWrong;
	}
	
	/*
	 * realDivision
	 * generates a real division problem, user has to answer it
	 * returns true or false depending if the answer is correct
	 * Author: Dziugas Butkus
	 */
	public static boolean realDivision(double number3, double number4)
	{
		double answer;
		boolean rightOrWrong;
		System.out.println ( "\nReal division question\nEnter the answer for the following problem(round to 2 decimal points): " );
		System.out.print ( number3 + " / " + number4 + " = " );
		answer = input.nextDouble ( );
		System.out.println (  );
		if(answer == Math.round(number3 / number4 * 100.0) / 100.0)
		{
			System.out.println ( "The answer is CORRECT!" );
			rightOrWrong = true;
		}
		else
		{
			System.out.println ( "The answer is WRONG! The right answer is: " + Math.round(number3 / number4 * 100.0) / 100.0 );
			rightOrWrong = false;
		}
		return rightOrWrong;
	}
}

// Problems: did not like the EPSILON thing. Kept Math.round as it gives me accurate results