package gui;

import service.EmployeeManager;
import service.Manager;
import vo.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeUI implements UI {
    Scanner scanner;
    Manager manager;

    public EmployeeUI() {
        scanner = new Scanner(System.in);
        manager = new EmployeeManager();

        String select = null;

        while (true) {
            printMainMenu();
            select = scanner.nextLine();

            switch (select) {
                case "1":
                    insertEmployee();
                    break;
                case "2":
                    findEmployee();
                    break;
                case "3":
                    deleteEmployee();
                    break;
                case "4":
                    manager.showAll();
                    break;
                case "9":
                    System.out.println("End this Application.");
                    System.out.println("Data will be saved.");
                    manager.saveFile();
                    System.exit(0);
            }
        }
    }

    @Override
    public void insertEmployee() {
        System.out.println("==============================");
        System.out.println("====[Kita add new employee]===");
        System.out.println("==============================");
        System.out.println("1. Employee ID number :" + (Employee.serial + 1));
        System.out.println("2. Employee Name : ");
        String name = scanner.nextLine();

        System.out.println("3. Employee Salary : ");
        int salary = scanner.nextInt();

        ArrayList<String> license = new ArrayList<String>();
        while(true){
            Scanner scnForLicense = new Scanner(System.in);
            System.out.println("4. >>>> License : ");
            String temp = scnForLicense.nextLine();

            if(temp.length() == 0){
                break;
            }

            license.add(temp);
        }//while
        Employee employee = new Employee(name,salary,license);
        manager.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee() {
        System.out.println(" > Input EmployeeID Number which you want to delete :");
        String eid = scanner.nextLine();

        if(manager.findEmployee(eid) == null){
            System.out.println("There is no Employee who you find.");
            return;
        }
        else{
            System.out.println("Are you sure delete this employee? (Y/N)");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("y")){
                manager.deleteEmployee(eid);
                return;
            }//if
        }
    }

    @Override
    public void findEmployee() {
        System.out.println(" > Input EmployeeID Number which you want to find :");
        String eid = scanner.nextLine();

        Employee e = manager.findEmployee(eid);
        System.out.println(e);
    }

    @Override
    public void printMainMenu() {
        System.out.println("==============================");
        System.out.println("====[Kita employee manager]===");
        System.out.println("==============================");
        System.out.println("1. Add Employee");
        System.out.println("2. Find Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Show all employee");
        System.out.println("9. Exit");
        System.out.println("==============================");
        System.out.println("** Select Menu Number : ");
    }
}
