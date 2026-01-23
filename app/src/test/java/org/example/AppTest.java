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
  void check_gross_income() {
      Payroll pr = new Payroll();

      assertEquals(800.0, pr.calculate_gross_income(40, 20.0));

      assertEquals(1106.6, pr.calculate_gross_income(50, 20.12), 0.001);
  }
  @Test
  void check_insurance_cost(){
      Payroll pr = new Payroll();

      assertEquals(15.00, pr.calculate_insurance_cost(2));
      assertEquals(35.00, pr.calculate_insurance_cost(3));
      assertEquals(35.00, pr.calculate_insurance_cost(10));
  }

  @Test
  void check_tax_helper_method(){
      Payroll pr = new Payroll();
      double income = 1000.0;
      double[] taxes = pr.calculate_gov_tax(income);

      // SocSec: 6% of 1000 = 60
      assertEquals(60.0, taxes[0]);

      // FedTax: 14% of 1000 = 140
      assertEquals(140.0, taxes[1]);

      // StTax: 5% of 1000 = 50
      assertEquals(50.0, taxes[2]);

      // Union Dues: Flat 10
      assertEquals(10.0, taxes[3]);

      double income_2 = 2.34;
      double[] taxes_2 = pr.calculate_gov_tax(income_2);


      // SocSec: 6% of 2.34 = 0.1404
      assertEquals(0.1404, taxes_2[0], 0.00001);

      // FedTax: 14% of 2.34 = 0.3276
      assertEquals(0.3276, taxes_2[1], 0.00001);

      // StTax: 5% of 2.34 = 0.117
      assertEquals(0.117, taxes_2[2], 0.00001);


      // Union Dues: Flat 10
      assertEquals(10.0, taxes_2[3]);
  }
}
