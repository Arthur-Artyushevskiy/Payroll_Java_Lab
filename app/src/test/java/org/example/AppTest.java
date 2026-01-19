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

    assert pr.calculate_gross_income(50, 20.12) - 1106.6 <= 0.00001;

    assert pr.calculate_insurance_cost(2) == 15.00;

    assert pr.calculate_insurance_cost(3) == 35.00;
    assert pr.calculate_insurance_cost(10) == 35.00;


  }
  @Test
  void check_tax_helper_method(){
      Payroll pr = new Payroll();
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

      double income_2 = 2.34;
      double[] taxes_2 = pr.calculate_gov_tax(income_2);

      // SocSec: 6% of 2.34 = 0.1404
      assert taxes_2[0] - 0.1404 <= 0.00001;

      // FedTax: 14% of 2.34 = 0.3276
      assert taxes_2[1] - 0.3276 <= 0.00001;

      // StTax: 5% of 2.34 = 0.117
      assert taxes_2[2] - 0.117 <= 0.00001;

      // Union Dues: Flat 10
      assert taxes_2[3] == 10.0;
  }
}
