package org.example;

public class PayrollFormatter {
    public String formatRegularEmployee (int numHoursWorked, String payRate, double grossPay,
                                         double socialSecurityTax, double stateTax, double federalTax,
                                         double unionDues, double insuranceCharge, double netPay) {
        return String.format(
                "%nPayroll Stub:%n%n" +
                        "     Hours:   %.1f%n" +
                        "      Rate:   %s%n" +
                        "     Gross:   $ %.2f%n%n" +
                        "    SocSec:   $ %.2f%n" +
                        "    FedTax:   $ %.2f%n" +
                        "     StTax:   $ %.2f%n" +
                        "     Union:   $ %.2f%n" +
                        "       Ins:   $ %.2f%n%n" +
                        "       Net:   $ %.2f",
                (double) numHoursWorked,
                payRate,
                grossPay,
                socialSecurityTax,
                federalTax,
                stateTax,
                unionDues,
                insuranceCharge,
                netPay
        );
    }
}
