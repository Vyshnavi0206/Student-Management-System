package studentManagementSystem;

import java.util.ArrayList;

public class StudentService {
//	Collection to Store Student Object
	 private ArrayList<Student> studentList=new ArrayList<Student>(); 
// addStudent()
	 public void addStudent(Student student) throws InvalidStudentDataException {
		 if(student==null) {
			System.out.println("Create an Student Object");
			return;
		 }
		 if(student.getMarks()<0) {
			 System.out.println("Marks cannot be negative  ");
			 return;
		 }
		 if(student.getAttendence()<0||student.getAttendence()>100) {
			 System.out.println("Attendence must be between 0 and 100");
			 return;
		 }
		 if(student.getFees()<0) {
			 System.out.println("fees cannot be negative");
			 return;
		 }
		 studentList.add(student);
		 System.out.println("Student added Successfully!");
	 }
//	 view all Students
	 public void viewAllStudents() {
		 if(studentList.isEmpty()) {
			 System.out.println("No student records Found");
		 }else {
			 for(Student s:studentList) {
				 System.out.println(s);
			 }
		 }
	 }
	 // deleting the Students by id
	 public void deleteStudents(int id) throws StudentNotFoundException {
		 boolean removed=false;
		 for(Student s:studentList) {
			 if(s.getId()==id) {
			 studentList.remove(s);
			 removed=true;
			 System.out.println("Student deleted Successfully!");
			break;
		 }
		 } 
		 if(!removed) {
				 throw new StudentNotFoundException("Student with ID : "+id + " not found");
				
			 }
	 }
//	 updating the marks,attendence,marks
	 public boolean updateStudent(int id,int marks,int attendence,double fees) {
		 for(Student s:studentList) {
			 if(s.getId()==id) {
				 s.setMarks(marks);
				 s.setAttendence(attendence);
				 s.setFees(fees);
				 return true;
			 }
		 }
		 System.out.println("Student with ID : "+id + " not found");
		 return false;
	 }
}
