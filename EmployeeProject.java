import java.util.*;
abstract class Employee{
	private String name;
	private int id;

	public Employee(String name,int id){
		this.name=name;
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}

 public abstract double calculateSal();

	public String toString(){
		return "Employee[ Name: ]"+name+" Id: "+id+" Salary: "+calculateSal()+"]";
	}
}


class FullTimeEmployee extends Employee{
	private double monthlySal;


	public FullTimeEmployee(String name,int id,double monthlySal){
		super(name,id);
		this.monthlySal=monthlySal;
	}

	@Override
	public double calculateSal(){
		return monthlySal;
	}

}
class PartTimeEmployee extends Employee{
	private int hoursWork;
	private double hourlyRate;


	public PartTimeEmployee(String name,int id,int hoursWork,double hourlyRate){
		super(name,id);
		this.hoursWork=hoursWork;
		this.hourlyRate=hourlyRate;
	}
	@Override
	public double calculateSal(){
		return hoursWork*hourlyRate;
	}

}
class PayrollSystem{
	private ArrayList<Employee> employeeList;

	public PayrollSystem(){
		employeeList= new ArrayList<>();
	}

	public void addEmployee(Employee e){
		employeeList.add(e);
	}
	public void removeEmployee(int id) {
		for(Employee e: employeeList){
			if(e.getId()==id){
				employeeList.remove(e);
				break;
			}
		}
	}
	public void displayEmployee(){
		for(Employee e: employeeList){
			System.out.println(e);
			
		}
	}

}

public class EmployeeProject{
	public static void main(String[] args) {
		PayrollSystem obj=new PayrollSystem();
		FullTimeEmployee emp1=new FullTimeEmployee("Ravinder",1,70000);
		PartTimeEmployee emp2=new PartTimeEmployee("Anshika",2,48,100);

		obj.addEmployee(emp1);
		obj.addEmployee(emp2);
		System.out.println("the initial employee details:");
		obj.displayEmployee();
		obj.removeEmployee(2);
		System.out.println("after removing part time employee");
		obj.displayEmployee();
	}
}