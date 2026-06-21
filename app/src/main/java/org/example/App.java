package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    //initialize Scanner, Calculator, and Formatter
    Scanner scanner = new Scanner(System.in);
    PayrollCalculator calculator = new PayrollCalculator();
    PayrollFormatter formatter = new PayrollFormatter();


    //welcome user and request their input
    System.out.println("Welcome to the Payroll Calculator Program!");

    System.out.print("Enter the number of hours you worked this week: ");
    int numHoursWorked = scanner.nextInt();

    System.out.print("Enter the number of dependents you have: ");
    int numDependents = scanner.nextInt();

    scanner.close();

    //calculate values

    double grossPay = calculator.calculateGrossPay(numHoursWorked, numDependents);

    double socialSecurityTax = calculator.calculateSocialSecurityTax(grossPay);

    double stateTax = calculator.calculateStateTax(grossPay);

    double federalTax = calculator.calculateFederalTax(grossPay);

    String payRate = calculator.getPayRate(numHoursWorked);

    double insuranceCharge = calculator.calculateInsuranceRate(numDependents);

    double unionsDues = calculator.getUnionDues();

    double netPay = calculator.calculateNetPay(numHoursWorked, numDependents);

    //print output and thank user

    System.out.println(formatter.formatRegularEmployee(numHoursWorked, payRate, grossPay, socialSecurityTax, stateTax, federalTax, unionDues, insuranceCharge,  netPay);
    System.out.println("Thank you for using the Payroll Calculator Program!");
  }
}
