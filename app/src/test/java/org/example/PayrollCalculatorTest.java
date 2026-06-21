package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayrollCalculatorTest {

  PayrollCalculator calculator = new PayrollCalculator();

  @Test
  void calculateGrossPayWithZeroHours() {
    assertEquals(0.0, calculator.calculateGrossPay(0));
  }


  @Test
  void calculateGrossPayWithOneHour() {
    assertEquals(16.78, calculator.calculateGrossPay(1));
  }


  @Test
  void calculateGrossPayWithManyRegularHours() {
    assertEquals(16.78 * 30, calculator.calculateGrossPay(30));
  }


  @Test
  void calculateGrossPayWithExactlyFortyHours() {
    assertEquals(16.78 * 40, calculator.calculateGrossPay(40));
  }

  @Test
  void calculateGrossPayWithOvertimeHours() {
    assertEquals((16.78 * 40) + ((16.78 * 1.5) * 1), calculator.calculateGrossPay(41));
  }

  @Test
  void calculateSocialSecurityTax() {
    assertEquals(100 * 0.06, calculator.calculateSocialSecurityTax(100));
  }

  @Test
  void calculateFederalTax() {
    assertEquals(100 * 0.14, calculator.calculateFederalTax(100));
  }

  @Test
  void calculateStateTax() {
    assertEquals(100 * 0.05, calculator.calculateStateTax(100));
  }

  @Test
  void getPayRateWithRegularHours() {
    assertEquals("16.78 $/hr", calculator.getPayRate(40));
  }

  @Test
  void getPayRateWithOvertimeHours() {
    assertEquals(
            "16.78 $/hr for the first 40 hours and 25.17 $/hr for any overtime",
            calculator.getPayRate(41)
    );
  }


  @Test
  void calculateInsuranceRateWithZeroDependents() {
    assertEquals(15.0, calculator.calculateInsuranceRate(0));
  }


  @Test
  void calculateInsuranceRateWithTwoDependents() {
    assertEquals(15.0, calculator.calculateInsuranceRate(2));
  }


  @Test
  void calculateInsuranceRateWithThreeDependents() {
    assertEquals(35.0, calculator.calculateInsuranceRate(3));
  }


  @Test
  void calculateInsuranceRateWithManyDependents() {
    assertEquals(35.0, calculator.calculateInsuranceRate(5));
  }

  @Test
  void calculateNetPayWithNoHoursAndNoDependents() {
    assertEquals(-25.0, calculator.calculateNetPay(0, 0));
  }

  @Test
  void calculateNetPayWithRegularHoursAndFewDependents() {
    double grossPay = 16.78 * 40;
    double taxes = grossPay * (0.06 + 0.14 + 0.05);
    double expectedNetPay = grossPay - taxes - 10 - 15;

    assertEquals(expectedNetPay, calculator.calculateNetPay(40, 2));
  }

  @Test
  void calculateNetPayWithOvertimeAndThreeDependents() {
    double grossPay = (16.78 * 40) + ((16.78 * 1.5) * 1);
    double taxes = grossPay * (0.06 + 0.14 + 0.05);
    double expectedNetPay = grossPay - taxes - 10 - 35;

    assertEquals(expectedNetPay, calculator.calculateNetPay(41, 3));
  }
}


