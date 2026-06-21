package org.example;

public class PayrollCalculator {

    //set given policies
    final static double basePayRate = 16.78;
    final static double overtimePayRate = (16.78 * 1.5);
    final static double socialSecurityTaxRate = 0.06;
    final static double stateTaxRate = 0.05;
    final static double federalTaxRate = 0.14;
    final static double unionDues = 10;
    final static double insuranceBaseRate = 15;
    final static double insuranceElevatedRate = 35;

    //declare methods

    public double calculateGrossPay (int numHoursWorked) {
        if (numHoursWorked > 40) {
            return ((40 * basePayRate) + ((numHoursWorked-40) * overtimePayRate));
        }
        return numHoursWorked * basePayRate;
    }

    public double calculateSocialSecurityTax (double grossPay) { return grossPay * socialSecurityTaxRate; }

    public double calculateStateTax (double grossPay) { return grossPay*stateTaxRate; }

    public double calculateFederalTax (double grossPay) { return grossPay*federalTaxRate; }

    public double getUnionDues () { return unionDues; }

    public String getPayRate (int numHoursWorked) {
        if (numHoursWorked >  40) {
            return (basePayRate + " $/hr for the first 40 hours and " + overtimePayRate + " $/hr for any overtime");
        }
        return (basePayRate + " $/hr");
    }

    public double calculateInsuranceRate (int numDependents) {
        if (numDependents > 2) {
            return insuranceElevatedRate;
        }
        return insuranceBaseRate;
    }

    public double calculateNetPay (int numHoursWorked, int numDependents) {
        double grossPay = calculateGrossPay(numHoursWorked);
        double insuranceRate = calculateInsuranceRate(numDependents);
        double expenses = grossPay * (socialSecurityTaxRate + stateTaxRate + federalTaxRate) + unionDues + insuranceRate;
        return grossPay - expenses;
    }


}
