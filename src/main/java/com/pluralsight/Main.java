package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String splitter = "\\|";

                String[] myArray = line.split(splitter);

                int id = Integer.parseInt(myArray[0].trim());
                String name = myArray[1].trim();
                double hours = Double.parseDouble(myArray[2].trim());
                double pay = Double.parseDouble(myArray[3].trim());

                Employee employee = new Employee(id,name,hours,pay);

                System.out.printf("Employee ID: %d, Name: %s, Gross pay: $%.2f%n",
                        employee.getEmployeeId(),employee.getName(),employee.getGrossPay());

                //System.out.printf(employee.getEmployeeId()+ ": " + employee.getName() + " Made $" + employee.getGrossPay()+"\n");

            }

            bufferedReader.close();

        } catch (Exception ex) {
            System.err.println("Something went wrong reading the files!");
        }
    }
}
