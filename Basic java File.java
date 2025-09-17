
package EmployeeManagementSystem;

//imoporting the required 
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

//main class
public class Main {
    //creating a printwriter object
    public static PrintWriter pw;

//main method
    public static void main(String[] args) throws Exception {
        
        //creating input file object
        File inFile = new File("input.txt");
        //creating output file object
        File outFile = new File("output.txt");

//checking if the input file exists
if (!inFile.exists()) {
            System.out.println("input File does not exist");
            System.exit(0);
        }

//creating a scanner and printwriter object
        Scanner sc = new Scanner(inFile);
         pw = new PrintWriter(outFile);
        
        //creating an object of EmployeeManagementSystem
         EmployeeManagementSystem ems = new EmployeeManagementSystem();

//while loop to read the input file
         while (sc.hasNext()) {
            
            // Read the command line
            String command_line = sc.nextLine();
            
            // Split the data in the command line
            String [] details = command_line.split(",");

            // Check the command and call the appropriate method

            // Add_Manager,Name,Id,Salary
         if (details[0].equals("Add_Manager")) {
                // Get the name, id and salary of the manager
            String name = details[1].trim();
            int id = Integer.parseInt(details[2].trim());
            double salary = Double.parseDouble(details[3].trim());
                // Create a manager object
            Manager manager = new Manager(name, id, salary);
                // Add the manager to the system
            String result = ems.addEmployee(manager);
                // Print the result in the output file
            pw.println(result);
            
         }
            // Add_Designer,Name,Id,Salary
         else if (details[0].equals("Add_Designer")) {
                // Get the name, id and salary of the designer
            String name = details[1].trim();
            int id = Integer.parseInt(details[2].trim());
            double salary = Double.parseDouble(details[3].trim());
                // Create a designer object
            Designer designer = new Designer(name, id, salary);
                // Add the designer to the system
            String result = ems.addEmployee(designer);
                // Print the result in the output file
            pw.println(result);
            
         }
            // Add_Developer,Name,Id,Salary
        else if (details[0].equals("Add_Developer")) {
                // Get the name, id and salary of the developer
            String name = details[1].trim();
            int id = Integer.parseInt(details[2].trim());
            double salary = Double.parseDouble(details[3].trim());
                // Create a developer object
            Developer developer = new Developer(name, id, salary);
                // Add the developer to the system
            String result = ems.addEmployee(developer);
                // Print the result in the output file
            pw.println(result);
            
        
        }
        // Give_leave , ManagerId, EmployeeId, StartDate, Days
     else if (details[0].equals("Give_Leave")) {
                // Get the manager id, employee id, start date and days of leave
        int managerId = Integer.parseInt(details[1].trim());
        int employeeId = Integer.parseInt(details[2].trim());
        LocalDate startDate = LocalDate.parse(details[3].trim());
        int days = Integer.parseInt(details[4].trim());
               // Give leave to the employee
        String result = ems.approveLeave(managerId, employeeId, startDate, days);
                // Print the result in the output file
        pw.println(result);


    }
        // Change_State, ManagerId, EmployeeId, State
    else if (details[0].equals("Change_State")){
        // Get the manager id, employee id and state
        int managerId = Integer.parseInt(details[1].trim());
        int employeeId = Integer.parseInt(details[2].trim());
        String state = details[3].trim();
        // Change the state of the employee
        String result = ems.markEmployeeAsWorking(managerId, employeeId);
        // Print the result in the output file
        pw.println(result);
    }
    // del_Employee, Id
    else if (details[0].equals("del_Employee")){
        // Get the id of the employee
        int id = Integer.parseInt(details[1].trim());
        // Remove the employee
        String result = ems.removeEmployee(id);
        // Print the result in the output file
        pw.println(result);
    }
    // printAllEmployees
    else if(details[0].equals("printAllEmployees")){
        // Print all the employees
        String result = ems.printAllEmployees();
        // Print the result in the output file
        pw.println(result);

    }
    // print_Leave_Records, Id
    else if(details[0].equals("print_Leave_Records")){
        // Get the id of the employee
        int id = Integer.parseInt(details[1].trim());
        // Print the leave records of the employee
        String result = ems.printEmployeeLeaveRecords(id);
        // Print the result in the output file
        pw.println(result);
    }

}
//closing the scanner and printwriter
pw.close();
pw.flush();
    }
}
