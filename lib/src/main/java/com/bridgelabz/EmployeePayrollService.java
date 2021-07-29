package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	 public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

	    private List<EmployeePayrollData> employeepayrollList;

	    public EmployeePayrollService() {
	    }

	    public EmployeePayrollService(List<EmployeePayrollData> employeepayrollList) {
	        this.employeepayrollList = employeepayrollList;
	    }

	    public static void main(String[] args) {
	        ArrayList<EmployeePayrollData> employeepayrollList = new ArrayList<>();
	        EmployeePayrollService employeepayrollservice = new EmployeePayrollService(employeepayrollList);
	        Scanner consoleInputReader = new Scanner(System.in);
	        employeepayrollservice.readEmployeePayrollData(consoleInputReader);
	        employeepayrollservice.writeEmployeePayrollData(IOService.CONSOLE_IO);
	    }

	    private void readEmployeePayrollData(Scanner consoleInputReader) {
	        System.out.println("Enter Employee ID: ");
	        int id = consoleInputReader.nextInt();
	        System.out.println("Enter Employee Name: ");
	        String name = consoleInputReader.next();
	        System.out.println("Enter Employee Salary: ");
	        double salary = consoleInputReader.nextDouble();
	        employeepayrollList.add(new EmployeePayrollData(id, name, salary));
	    }

	    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService){
	        if (ioService.equals(IOService.DB_IO))
	            this.employeepayrollList = new EmployeePayrolDBservice().readData();
	        return employeepayrollList;

	    }

	    public void writeEmployeePayrollData(IOService ioService) {
	        if (ioService.equals(IOService.CONSOLE_IO))
	            System.out.println("\n Writting Employee payroll to Console\n" + employeepayrollList);
	        else if (ioService.equals(IOService.FILE_IO))
	            new EmployeePayrolFileIOservice().writeData(employeepayrollList);
	    }

	    public void printData(IOService ioService) {
	        if (ioService.equals(IOService.FILE_IO))
	            new EmployeePayrolFileIOservice().printData();
	    }

	    public long countEntries(IOService ioService) {
	        if (ioService.equals(IOService.FILE_IO))
	            return new EmployeePayrolFileIOservice().countEntries();
	        return 0;
	    }
	}