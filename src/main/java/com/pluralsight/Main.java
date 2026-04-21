package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("what file do you want to read from? (employees.csv): ");
            String userInputRead = scanner.nextLine();

            System.out.print("what file do you want to write in?: ");
            String userInputWrite = scanner.nextLine();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(userInputRead));

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userInputWrite));

            String line;
            String text;

            while ((line = bufferedReader.readLine()) != null) {

                String splitter = "\\|";

                String[] myArray = line.split(splitter);

                int id = Integer.parseInt(myArray[0].trim());
                String name = myArray[1].trim();
                double hours = Double.parseDouble(myArray[2].trim());
                double pay = Double.parseDouble(myArray[3].trim());

                Employee employee = new Employee(id, name, hours, pay);

                text = String.format("Employee ID: %d, Name: %s, Gross pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                bufferedWriter.write(text);

            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.err.println("Something went wrong reading the files!");
        }
        scanner.close();
    }
}
