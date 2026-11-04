package studentManagementSystem;

public class Student{
//	Instance of Variables
	private String Name;
	private int Id;
	private int Marks;
	private int attendence;
	private double fees;
//	Default Constructor
	public Student() {
		
	}
//	Parameterized constructor
	public Student(String Name, int Id, int marks, int attendence, double fees) {
		this.Name = Name;
		this.Id = Id;
		this.Marks = marks;
		this.attendence = attendence;
		this.fees = fees;
	}
	
//Generating getter's and setter's method	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		Name = Name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		Id = Id;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
	public int getAttendence() {
		return attendence;
	}
	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
//Overriding toString()	
	@Override
	public String toString() {
		return "Student {Name=" + Name + ", Id=" + Id + ", Marks=" + Marks + ", attendence="
				+ attendence + ", fees=" + fees + "}";
	}
	
	
	
	
}
