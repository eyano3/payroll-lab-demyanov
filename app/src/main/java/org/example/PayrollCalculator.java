package org.example;

//set given policies
final static double basePayRate = 16.78;
final static double overtimePayRate = (16.78 * 1.5);
final static double socialSecurityTaxRate = 0.06;
final static double stateTaxRate = 0.05;
final static double federalTaxRate = 0.14;
final static double unionDues = 10;
final static double insuranceBaseRate = 15;
final static double insuranceElevatedRate = 35;

public class PayrollCalculator {

    public double calculateGrossPay (int numHoursWorked, int numDependents) {

    }

    public double calculateSocialSecurityTax (double grossPay) {

    }

    public double calculateStateTax (double grossPay) {

    }

    public double calculateFederalTax (double grossPay) {

    }

    public double getUnionDues () {
        return unionDues;
    }

    public String getPayRate (int numHoursWorked) {

    }

    public double calculateInsuranceRate (int numDependents) {

    }

    public double calculateNetPay (int numHoursWorked, int numDependents) {

    }


}
