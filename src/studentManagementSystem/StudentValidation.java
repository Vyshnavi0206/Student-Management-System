package studentManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentValidation {
 private Scanner sc=new Scanner(System.in);
 private StudentService service= new StudentService();
 private Login loginUser=new Login();
// to Start Execution
 public void startApp() {
	 
	 String role=chooseRole();
//	 Login for Admin
	 if(role.equals("ADMIN")) {
	 if(!LoginUser()) {
			System.exit(0); 
		 }
	 }
	 while(true) {
		 menu(role);
		 try {
			 int choice=sc.nextInt();
			 if(role.equals("ADMIN")) {
			 switch(choice) {
			 case 1: addStudent();
			         break;
			 case 2: service.viewAllStudents();
			         break;
			 case 3:deleteStudent();
			         break;
			 case 4: updateStudent();
			         break;
			 case 5: System.out.println("Application Closed! Thank You....");
			 System.exit(0);
			 default:System.out.println("Inavalid choice ! Please select again...");
			 }
			 }
//			 STUDENT role
			 else {
				 switch(choice) {
				 case 1: addStudent();
				         break;
				 case 2:System.exit(0);
				       break;
				 default:System.out.println("Invalid choise!");      
				 }
			 }
		 } catch(InputMismatchException e) {
			 System.out.println("Please Enter valid choice!");
			 sc.nextLine();
		 }
	 }
 }
private boolean LoginUser() {
	int attempts=3;
	while(attempts>0) {
		System.out.println("Enter your UserName : ");
		 String username=sc.next();
		
		System.out.println("Enter your Password");
		 String password=sc.next();
		 if(Login.login(username,password)) {
			 System.out.println("Login Sucessfully!");
			 return true;
		 }
		 else {
			 attempts--;
			 System.out.println("Invalid Credentials...!,Attempts left : "+attempts);
		 }
	}
	System.out.println("Too many Attemps! Application closed..");
	return false;
	
	
	
}
// choose role
 private String chooseRole() {
	 System.out.println("\n Select Your Role : ");
	 
	 System.out.println("1.ADMIN");
	 System.out.println("2.STUDENT");
	 System.out.println("Enter Your Role :");
	 int rolechoose=sc.nextInt();
	 if(rolechoose==1) {
		 return "ADMIN";
	 }else if(rolechoose==2) {
		 return "STUDENT";
	 }else {
		 System.out.println("Invalid choice! Defaulting to Student!..");
		 return "STUDENT";
	 }
 }
// to display Menu
 private void menu(String role) {
	 System.out.println("------------Student Management System----------");
	 if(role.equals("ADMIN")) {
		 System.out.println("1.Add Student");
		 System.out.println("2.View All Students");
		 System.out.println("3.Delete Students");
		 System.out.println("4.Update Students");
		 System.out.println("5.Exit");
	 }else {
		 System.out.println("1.Add Student");
		 System.out.println("2.Exit");
	 }
	 
	 System.out.println("Enter your choice : ");
 }
// to add Student
 private void addStudent()  {
	 
	 try {
		 System.out.println("Enter Student ID : ");
		 int id=sc.nextInt();
		 
		 System.out.println("Enter Student Name : ");
		 
		 sc.nextLine();
		 String name=sc.nextLine();
		 
		 
		 System.out.println("Enter Student Marks : ");
		 int marks=sc.nextInt();
		 if(marks<0||marks>100) {
			 throw  new InvalidStudentDataException("Invalid Marks! Please Enter valid Marks(0 to 100");
		 }
		 
		 System.out.println("Enter Student Attendence : ");
		 int attendence=sc.nextInt();
		 if(attendence<=0||attendence>=100) {
			 throw new InvalidStudentDataException("Invalid Number! Please Enter valid number(0 to 100)");
		 }
		 
		 System.out.println("Enter Student fees : ");
		 double fees=sc.nextDouble();
		 if(fees<0) {
			 throw new InvalidStudentDataException("Invalid Number! Please Enter valid number(0 to 100)");
		 }
		 Student student=new Student(name, id, marks, attendence, fees);
		 service.addStudent(student);
		 
	 }
	 catch(InvalidStudentDataException e) {
		 System.out.println("Validation error"+e.getMessage());
	 }
 }

// deleteStudent()
 private void deleteStudent()  {
	 try {
	 System.out.println("Enter Student ID to delete: "); 
	 int id=sc.nextInt();
	 service.deleteStudents(id);
 }catch(StudentNotFoundException e) {
	 System.out.println("Error "+e.getMessage());
 }catch(Exception e) {
	 System.out.println("Please enter valid Input!");
	 sc.nextLine();
 }
 }
//updateStudent()
 private void updateStudent() {
	 try {
		 System.out.println("Enter Student Id to update : ");
		 int id=sc.nextInt();
		 
		 System.out.println("Enter new marks : ");
		 int marks=sc.nextInt();
		 
		 System.out.println("Enter new Attendence : ");
		 int attendence=sc.nextInt();
		 
		 System.out.println("Enter new Fees : ");
		 double fees=sc.nextDouble();
	 }catch(Exception e) {
		 System.out.println("Invalid Input");
		 sc.nextLine();
	 }
 }

}
