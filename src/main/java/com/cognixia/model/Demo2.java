package com.cognixia.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Demo2 {
	
	public static HashMap<Integer, Employee> empmap = new HashMap<>();
	public static Employee employee = new Employee();
	public static Address address = new Address();
	public static Department department = new Department();
	public static Scanner in = new Scanner(System.in);
	public static Scanner in1 = new Scanner(System.in);
	
	public static void addEmployee() {

		System.out.println("Enter emp id: ");			
		int empId = in1.nextInt();
		employee.setEmpid(empId);
		
		System.out.println("Enter name: ");			
		String name = in.nextLine();
		employee.setName(name);
		
		boolean flag = true;
		int age = 0;
		do {
			System.out.println("Enter age: ");
			try {					
				age = in1.nextInt();
				if (age<18 || age>65) {
					System.out.println("Age can only be a number between 18 and 65.");
					flag = true;
				}
				else
					flag = false;
			}				
			catch (InputMismatchException e) {
				System.out.println("Age must be a number");
				in.next();
				flag = true;
			}
						
		} while (flag);
		employee.setAge(age);
		
//		System.out.println("Enter age: ");			
//		age = in.nextInt();
//		employee.setAge(age);
		
		System.out.println("Enter street: ");
		String street = in.nextLine();
		address.setStreet(street);
		
		System.out.println("Enter city: ");
		String city = in.nextLine();
		address.setCity(city);
			
		System.out.println("Enter zipcode: ");
		int zipcode = in1.nextInt();
		address.setZipcode(zipcode);
					
		employee.setOfficeAddress(address);
		
		System.out.println("Enter salary: ");
		double salary = in1.nextDouble();
		employee.setSalary(salary);
		
		System.out.println("Enter title: ");
		String title = in.next();
		employee.setTitle(title);
		
		System.out.println("Enter department: ");
		String dept = in.next();
		department.setDeptname(dept);
		employee.setDepartment(department);
		
		empmap.put(empId, employee);
		
		System.out.println("Employee added!");
	}
	
	public static void updateEmployee() {
		System.out.println("Enter the emp Id of the employee that you would like to update!");
		int empId = in1.nextInt();
		
		System.out.println("1) Update name");
		System.out.println("2) Update age");
		System.out.println("3) Update address");
		System.out.println("4) Update salary");
		System.out.println("5) Update title");
		System.out.println("6) Update department");
		System.out.println("Select the option based on what you would like to update");
		int updateOption = in1.nextInt();
		
		if (updateOption == 1) { // Update name
			System.out.println("Enter new name: ");
			employee.setName(in.nextLine());
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Name updated!");
		}
		if (updateOption == 2) { // Update age
			System.out.println("Enter new age: ");
			employee.setAge(in1.nextInt());
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Age updated!");
		}
		if (updateOption == 3) { // Update address
			System.out.println("Enter new street: ");
			address.setStreet(in.nextLine());
			
			System.out.println("Enter new city: ");
			address.setCity(in.nextLine());
			
			System.out.println("Enter new zipcode: ");
			address.setZipcode(in1.nextInt());
			
			employee.setOfficeAddress(address);
			
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Address updated!");
		}
		if (updateOption == 4) { // Update salary
			System.out.println("Enter new salary: ");
			employee.setSalary(in1.nextDouble());
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Salary updated!");
		}
		if (updateOption == 5) { // Update title
			System.out.println("Enter new title: ");
			employee.setTitle(in.nextLine());
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Title updated!");
		}
		if (updateOption == 6) { // Update department
			System.out.println("Enter new department: ");
			department.setDeptname(in.nextLine());
			employee.setDepartment(department);
			empmap.put(empId, employee);
			in.nextLine();
			System.out.println("Department updated!");
		}
	}
	
	public static void deleteEmployee() {
		System.out.println("Enter emp id: ");
		int index = in1.nextInt();
		
		if (empmap.containsKey(index) == true) {
			empmap.remove(index);

			System.out.println("Employee with emp id " + index + " has been removed from system.");
		}
		else
			System.out.println("Emp ID does not exist in system!");
	}
	
	public static void getEmployeeById() {
		System.out.println("Enter emp id: ");
		int index = in1.nextInt();
		
		if (empmap.containsKey(index) == true) {
			System.out.println(empmap.get(index));
		}
		else
			System.out.println("Emp ID does not exist in system!");
	}
	
	public static void getEmployeeByName() {
		System.out.println("Enter name: ");
		String name = in.nextLine();
		in.next();		
		
		for(Entry<Integer, Employee> entry: empmap.entrySet()) {
			if (entry.getValue().toString() == name) {
				System.out.println(entry.getKey());
			}
		
			else
				System.out.println(name + "does not exist in system!");	
		}

	}
	
	public static void printAllEmployees() {
		for (Integer key: empmap.keySet()) {
			for (Employee values: empmap.values()) {
				System.out.println(key + " = " + values);
			}		
		}	
	}
	
	public static void getEmployeeByCity() {
		System.out.println("Enter city: ");
		String city = in.nextLine();
		in.nextLine();
		
		if (empmap.containsValue(city.toLowerCase())) {
			int index = 0;
			for(Entry<Integer, Employee> entry: empmap.entrySet()) {
				if(empmap.containsValue(employee.getOfficeAddress())) { 
//				if(entry.getValue().containsValue(employee.getOfficeAddress())) {
			    	  index = entry.getKey();
			      }
			}

			System.out.println(empmap.entrySet());
		}
		else
			System.out.println(city + "does not exist in system!");
	}
	
	public static void exit() {
		try(
				FileOutputStream fos = new FileOutputStream("empmap.obj");
						
				ObjectOutputStream os = new ObjectOutputStream(fos);
						){
					os.writeObject(employee);
				}
				catch (IOException exp) {
					exp.printStackTrace();
				}
	}
	
	public static void main(String[] args) {		
		
		boolean mainpage = true;
		while (mainpage) {
			System.out.println("Choose the following options:");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Get Employee by ID");
			System.out.println("5. Get Employee by Name");
			System.out.println("6. Print all Employees");
			System.out.println("7. Get Employee by City");
			System.out.println("8. Exit");
			
			int option = in1.nextInt();
			
			if (option == 1) { // Add employee
				addEmployee();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
					
			}
			if (option == 2) { // Update employee
				updateEmployee();
				System.out.println("Press 0 to go back to main menu");
				if (in.nextInt() != 0)
					mainpage = false;						
			}
			if (option == 3) { // Delete employee
				deleteEmployee();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
				
			}
			if (option == 4) { // Get employee by id
				getEmployeeById();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
				
			}
			if (option == 5) { // Get employee by name
				getEmployeeByName();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
				
			}
			if (option == 6) { // Print all employees
				printAllEmployees();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
			}
			if (option == 7) { // Get employee by city
				getEmployeeByCity();
				
				System.out.println("Press 0 to go back to main menu");
				
				if (in.nextInt() != 0)
					mainpage = false;
			}
			if (option == 8) { //Exit
				exit();
				mainpage = false;
			}
	
		}
					
	}

}
