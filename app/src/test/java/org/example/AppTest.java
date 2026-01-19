package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  // You can put your JUnit tests here
  // Feel free to create other files, as needed, to organize your tests

  @Test
  void itWorks() {
    assertEquals(true, true);
  }
  @Test
  void check_helper_methods(){
    Payroll pr = new Payroll();

    assert pr.calculate_gross_income(40, 20.0) == 800.0;

    assert pr.calculate_gross_income(50, 20.0) == 1100.0;

    assert pr.calculate_insurance_cost(2) == 15.00;

    assert pr.calculate_insurance_cost(3) == 35.00;
    assert pr.calculate_insurance_cost(10) == 35.00;

    double income = 1000.0;
    double[] taxes = pr.calculate_gov_tax(income);

    // SocSec: 6% of 1000 = 60
    assert taxes[0] == 60.0;

    // FedTax: 14% of 1000 = 140
    assert taxes[1] == 140.0;

    // StTax: 5% of 1000 = 50
    assert taxes[2] == 50.0;

    // Union Dues: Flat 10
    assert taxes[3] == 10.0;
  }
}
