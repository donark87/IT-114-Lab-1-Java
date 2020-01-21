//===================================================
// Name         : Donark Patel
// SID          : 31327058
// Course       : IT114
// Section      : 451
// Instructor   : Maura Deek
// Assignment # : Programming Assignment 1
// Date         : 9/20/2019
// Class  : This class created student object. 
//===================================================


public class Student{

	private int studentID; //studentID stores student's ID
	private String firstName; //firstName stores student's first name
	private String lastName;  //lastName stores student's last name
	private String emailAddress;  //emailAddress stores student's email address
	private int age; //age stores student's age.
	private int[] grades; //grades array stores students grade


	/**
       	Constructor with parameters
       	sID  Student's ID
       	sFirst Studetnt's First Name
       	sLast Student's Last Name
       	sEmail Student's Email Address
       	sAge Student's Age
       	sGrade array of Student's Grade
	*/

		public Student(int sID, String sFirst, String sLast, String sEmail, int sAge, int [] sGrade)
		{
		studentID = sID;
		firstName = sFirst;
		lastName = sLast;
		emailAddress = sEmail;
		age = sAge;
		grades = sGrade;
		}
		//Print method to print student information.
		public void PrintStudentRecord()
		{

			System.out.println("\n\nID:" + studentID);
			System.out.println("First Name:" + firstName);
			System.out.println("Last Name:" + lastName);
			System.out.println("Email:" + emailAddress);
			System.out.println("Age:" + age);
			System.out.println("Assignment 1 grade: " + grades[0]);
			System.out.println("Assignment 2 grade: " + grades[1]);
			System.out.println("Assignment 3 grade: " + grades[2]);
			System.out.println("Assignment 4 grade: " + grades[3]);
			System.out.println("Assignment 5 grade: " + grades[4]);
			System.out.println("Average: " + average());
			System.out.println("Letter Grade: " + letterGrade());
		}
		//Method to return Student ID
		public int getStudentID()
		{
			return studentID;
		}
		//Method to calculate average
		public double average()
		{

			double sum = 0;
			for(int i=0; i<5; i++)
			sum += grades[i];

			double average = sum / 5;

			return average;
		}
		// Method to calculate letter grade
		public char letterGrade()
		{
			double score = average();
			if (score >=90 ){
				return 'A';}
			else if (score >= 80){
				return 'B';}
			else if (score >= 70){
				return 'C';}
			else if (score >= 60){
				return 'D';}
			else return 'F';

		}

}