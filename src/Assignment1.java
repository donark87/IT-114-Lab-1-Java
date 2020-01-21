//===================================================
// Name         : Donark Patel
// SID          : 31327058
// Course       : IT114
// Section      : 451
// Instructor   : Maura Deek
// Assignment # : Programming Assignment 1
// Date         : 9/20/2019
// Description  : This program is too add and display student's information.
//===================================================


import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class Assignment1{

public static void main (String[]args){

		int studentID = 0; //studentID stores student's ID
	    String firstName = ""; //firstName stores student's first name
		String lastName = "";  //lastName stores student's last name
		String emailAddress = "";  //emailAddress stores student's email address
	    int age = 0; //age stores student's age.
		int numberOfStudents = 0; // Number of student records

		String input;
		Boolean validateInput = false;



		//Create a Scanner object to receive input from the user
		Scanner keyboard = new Scanner (System.in);
		do{
		//Prompt users to indicate how many recodes to need to be created.
		System.out.println("How many student’s information you want to enter? ");
		input = keyboard.next();
		if(isNumber(input))
		{
			int temp = Integer.parseInt(input);
			  if(temp < 11 && temp > 0)
			  {
				  numberOfStudents = temp;
					validateInput = true;
				}
				else{
					JOptionPane.showMessageDialog(null,"Input valid number, Enter number between 1 to 10");
					validateInput = false;
					}
		}

		else
		{
		JOptionPane.showMessageDialog(null,"Input valid number");
		validateInput = false;

		}
		}while(validateInput == false);




		//Array to store all student records.
		Student[] studentArray = new Student[numberOfStudents];

		//For loop to insert student information
		for(int j = 0; j<numberOfStudents; j++  ){

		System.out.println("\n\nStudent " + (j+1) + " information: ");
		do{
		//Prompt the user to enter student's ID
		System.out.println("Enter student's ID");
		input = keyboard.next();
		if(isNumber(input))
		{
		studentID = Integer.parseInt(input);
		validateInput = true;
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid number");
		validateInput = false;
		}
		}while(validateInput == false);



		do{
		//Prompt the user to enter student's first name
		System.out.println("Enter student's first name");
		input = keyboard.next();
		if(isOnlyAlphabet(input))
		{
		firstName = input;
		validateInput = true;
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid first name");
		validateInput = false;
		}
		}while(validateInput == false);


		do{
		//Prompt the user to enter student's last name
		System.out.println("Enter student's last name");
		input = keyboard.next();
		if(isOnlyAlphabet(input))
		{
		lastName = input;
		validateInput = true;
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid last name");
		validateInput = false;
		}
		}while(validateInput == false);


		do{
		//Prompt the user to enter student's email address
		System.out.println("Enter student's email address");
		input = keyboard.next();
		if(isValidEmail(input))
		{
		emailAddress = input;
		validateInput = true;
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid email address");
		validateInput = false;
		}
		}while(validateInput == false);

		do{
		//Prompt the user to enter student's age
		System.out.println("Enter student's age");
		input = keyboard.next();
		if(isNumber(input))
		{
			int ageTemp = Integer.parseInt(input);
				if(ageTemp > 0)
					{
					age = ageTemp;
					validateInput = true;
					}
				else
					{
					JOptionPane.showMessageDialog(null,"Input valid number. Enter number grater then zero");
					validateInput = false;
					}
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid number");
		validateInput = false;
		}
		}while(validateInput == false);


		//Array for grades
		int[] arrayGrade = new int[5];

		//Prompt the user to enter student's assignment Grade using For loop
		for(int i=0; i<5; i++){
		do{
		System.out.println("Enter student's assignment " + (i+1) + " grade");
		input = keyboard.next();
		if(isNumber(input))
		{
			int gradeTemp = Integer.parseInt(input);
				 if(gradeTemp < 101 && gradeTemp > -1){
					arrayGrade[i] = gradeTemp;
					validateInput = true;}
				else{
					JOptionPane.showMessageDialog(null,"Input valid number, Enter number between 0 to 100");
					validateInput = false;

					}
		}
		else
		{
		JOptionPane.showMessageDialog(null,"Input valid number");
		validateInput = false;
				}
		}while(validateInput == false);

		}

		//Declare and instantiate a Student object
		Student newStudent = new Student(studentID, firstName, lastName, emailAddress, age,arrayGrade);


		//Inserting newStudent object data in StudentArray
		studentArray [j] = newStudent;

		}

		//Prompt the user to indicate if they want to display data of all students.
		System.out.println("\n\nEnter number 1 to display the entire roster");
		System.out.println("\n\nEnter Student's ID to display to display a specific student information");
		System.out.println("\n\nEnter number 3 to exit");
		int temp = keyboard.nextInt();


	while(temp!= 3){

		//Prompt the user to indicate if they want to display data of all students.


		if (temp == 1){
			//For loop to display all student information.
			for(int a = 0; a<numberOfStudents; a++  ){
				studentArray [a].PrintStudentRecord();
					}

			}
		// else if statement to find the student ID
		else if (temp != 1){
			for(int b = 0; b<numberOfStudents; b++  ){
				int tempStudentID = studentArray [b].getStudentID();
					//if statement to validate if student id was found
					if(temp == tempStudentID){							//if statement to validate if student id was found
							studentArray [b].PrintStudentRecord();

						}
						}

			}

		//else print error message
		else{
			System.out.println("\n Invalid entry: Please enter correct ID number or enter 1 to display all students information");

			}
		System.out.println("\n\nEnter number 1 to display the entire roster");
		System.out.println("\n\nEnter Student's ID to display to display a specific student information");
		System.out.println("\n\nEnter number 3 to exit");
		temp = keyboard.nextInt();

		}
		keyboard.close();

}
		public static boolean isNumber(String in)
		{
			try
			{
				Integer.parseInt(in);
				return true;
			}
			catch (Exception E)
			{
			return false;
			}
		}
		public static boolean isOnlyAlphabet(String al)
		{
			return ((!al.equals("")) && (al.matches("^[a-zA-Z]*$"))&& (al != null));
		}

		public static boolean isValidEmail(String email)
			{
				String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
									"[a-zA-Z0-9_+&*-]+)*@" +
									"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
									"A-Z]{2,7}$";

				Pattern p1 = Pattern.compile(regex);
				if (email == null)
					return false;
				return p1.matcher(email).matches();
			}

}
