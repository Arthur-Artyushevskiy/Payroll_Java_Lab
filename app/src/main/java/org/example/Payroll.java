package org.example;
import java.util.Scanner;


public class Payroll {
    private double life_insurance_plan_cost;

    void runProgram(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Payroll Program!");

        System.out.print("How many hours did you work this week? ");
        double hours_worked = scan.nextDouble();

        scan = new Scanner(System.in);
        System.out.print("How many children do you have? ");
        double children_num = scan.nextDouble();

        // prevents this variable to become negative
        if(children_num < 0){
            children_num = 0;
            System.out.println("Your number of children is set to 0!");
        }


        scan = new Scanner(System.in);
        System.out.print("What is your pay rate? ");
        double pay_rate = scan.nextDouble();

        // forces the user to choose the life insurance plan
        choose_life_insurance_plan(children_num);

        double gross_income = Math.round(calculate_gross_income(hours_worked, pay_rate) * 100)/100.0;
        double insurance_cost = calculate_insurance_cost(children_num);
        double[] gov_taxes = calculate_gov_tax(gross_income);



        System.out.println("Payroll Stub: \n\n");
        System.out.println("Hours:   " + hours_worked + "\n");
        System.out.println("Rate:    " + pay_rate + " $/hr" + "\n");
        System.out.println("Gross:   $" + gross_income + "\n\n");

        gross_income = gross_income - insurance_cost -life_insurance_plan_cost;
        for (double govTax : gov_taxes) gross_income -= govTax;

        System.out.println("SocSec:  $" + Math.round(gov_taxes[0] * 100)/100.0 + "\n");
        System.out.println("FedTax:  $" + Math.round(gov_taxes[1] * 100)/100.0 + "\n");
        System.out.println("StTax:   $" + Math.round(gov_taxes[2] * 100)/100.0 + "\n");


        if(gross_income<0){
            gross_income += gov_taxes[3] + insurance_cost + life_insurance_plan_cost;
            System.out.println("Net:     $" + Math.round(gross_income * 100)/100.0 + "\n");
            System.out.println("The employee still owes:");
            System.out.println("Union:   $" + Math.round(gov_taxes[3]) + "\n");
            System.out.println("Ins:     $" + insurance_cost + "\n");
            System.out.println("LifeIns: $" + life_insurance_plan_cost + "\n");
        }
        else{
            System.out.println("Union:   $" + Math.round(gov_taxes[3]) + "\n");
            System.out.println("Ins:     $" + insurance_cost + "\n");
            System.out.println("LifeIns: $" + life_insurance_plan_cost + "\n");
            System.out.println("Net:     $" + Math.round(gross_income * 100)/100.0 + "\n");
        }

        System.out.println("Thank you for using the Payroll Program!");
    }

    double calculate_gross_income(double hours, double pay_rate){
        if(hours <= 40) return hours * pay_rate;
        else {
            double extra_hours = hours - 40;
            return extra_hours * pay_rate * 1.5 + (hours - extra_hours) * pay_rate;
        }
    }

    double calculate_insurance_cost(double children_num){
        if(children_num >= 3) return 35.00;
        return 15.00;
    }

    double[] calculate_gov_tax(double income){
       var taxes = new double[4];
       double soc_security = income * 0.06;
       taxes[0] = soc_security;
       double federal_tax = income * 0.14;
       taxes[1] = federal_tax;
       double state_tax = income * 0.05;
       taxes[2] = state_tax;
       taxes[3] = 10.00; // Local Union dues
        return taxes;
    }

    void choose_life_insurance_plan(double children_num){
        var scanner = new Scanner(System.in);
        System.out.println("Which life insurance plan do you want to select?");
        System.out.println(" (1) no plan \n (2) single plan \n (3) married plan \n (4) married with children plan \n\n");
        System.out.print("Choose your option: ");
        String str_option = scanner.nextLine();

        // prevents the user from choosing a wrong option
        while(!(str_option.equals("1") || str_option.equals("2") || str_option.equals("3") || str_option.equals("4"))){
            System.out.println("Sorry! You need choose one of the plans.");
            System.out.println("Which life insurance plan do you want to select?");
            System.out.println(" (1) no plan \n (2) single plan \n (3) married plan \n (4) married with children plan \n\n");
            System.out.print("Choose your option: ");
            str_option = scanner.nextLine();
        }

        // precents the user from choosing a children plan if the user has no children
        while(str_option.equals("4") && children_num < 1){
            System.out.println("Sorry! You need at least one child to select that plan.");
            System.out.println("Which life insurance plan do you want to select?");
            System.out.println(" (1) no plan \n (2) single plan \n (3) married plan \n (4) married with children plan \n\n");
            System.out.print("Choose your option: ");
            str_option = scanner.nextLine();
        }

        int option = Integer.parseInt(str_option);
        switch (option){
            case 1:
                System.out.println("You chose a no plan option, no deduction from your paycheck");
                break;
            case 2:
                System.out.println("You chose a single plan option, $5 deduction from your paycheck");
                life_insurance_plan_cost = 5.00;
                break;
            case 3:
                System.out.println("You chose a married plan option, $10 deduction from your paycheck");
                life_insurance_plan_cost = 10.00;
                break;
            case 4:
                System.out.println("You chose a married with children plan option, $15 deduction from your paycheck");
                life_insurance_plan_cost = 15.00;
                break;
        }
    }
}
