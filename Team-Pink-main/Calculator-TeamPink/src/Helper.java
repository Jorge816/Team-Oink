/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 154jo
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Helper {
    //----------------------------------------------------------------------------------------------------------------------------------General 
    //-------------------------------Checking age 
    public static void checkAge(String ageInput) {
        try {
            
            int age = Integer.parseInt(ageInput); // Convert input to integer
            
            if (age >= 1 && age <= 120) {
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter an age between 1 and 120.", "Age Validation Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Validation of age fileds 
      public static boolean validateAges(String currentAgeInput, String retirementAgeInput) {
        try {
            int currentAge = Integer.parseInt(currentAgeInput);       // Convert current age to integer
            int retirementAge = Integer.parseInt(retirementAgeInput); // Convert retirement age to integer

            if (currentAge <= retirementAge) {
                return true; // Valid if current age is less than or equal to retirement age
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Invalid input: Current age cannot be greater than retirement age.", 
                    "Age Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Invalid input. Please enter valid numbers for both ages.", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------InterestRateCalculator ----Pedro
    //-----------// isWHoleNumber
    public static boolean isWholeNumber(String input) {
    // Check if the input is null or empty
        if (input == null || input.isEmpty()) {
            
            return false;
            
        }

        // Check if the input contains only digits (for whole numbers) and an optional minus sign for negative numbers
        if (input.matches("\\d+")) { // "-?" allows an optional negative sign, "\\d+" ensures only digits
            return true;
        }
        
        JOptionPane.showMessageDialog(null, "Enter a whole number.");
        return false; // If input contains anything other than digits, return false
    }
    
    //------------------------------------------------------------------------------------------------------------------------- // Validate the stripped input -Pedro
    public static boolean InputValidation(String input) {
    
        if (!input.isEmpty()) {
            if (input.isEmpty()) {
               return false;
            }
            // Check if the input contains only digits (this allows decimals as well)
            if (input.matches("[0-9.]+")) {
                try {
                    // Parse the input to a number and check if it's a positive number
                    double value = Double.parseDouble(input);

                    if (value < 0) {
                        // If the number is negative, display an error message
                        JOptionPane.showMessageDialog(null, "Negative numbers are not allowed.");
                        return false;  // Return false to indicate invalid input
                    }         
                    // If all checks pass, return true
                    return true;  // Return true to indicate valid input        
                } catch (NumberFormatException e) {
                    // Handle case where input isn't a valid double (e.g., multiple dots)
                    JOptionPane.showMessageDialog(null, "Invalid number format.");
                    return false;  // Return false to indicate invalid input
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number format.");         
                return false;  // Return false to indicate invalid input
                
            }
        }
        return false;
    }
    
    //handling selection periond------
    public static int selectionPeriod(String input) {
      // Initialize n value
      int nValue = 1;  // Default value for Annually

      // Determine the value of n based on the selected option
      switch (input) {
          case "Annually":
              nValue = 1;
              break;
          case "Semiannually":
              nValue = 2;
              break;
          case "Quarterly":
              nValue = 4;
              break;
          case "Monthly":
              nValue = 12;
              break;
          case "Semimonthly":
              nValue = 24;
              break;
          case "Biweekly":
              nValue = 26;
              break;
          case "Weekly":
              nValue = 52;
              break;
          case "Daily":
              nValue = 365;
              break;
          case "Continuously":
              nValue = -1;  // Use a special value to represent continuous compounding
              break;
          default:
              nValue = 1;  // Default value (Annually)
        }

        return nValue;
    }
    //Formula ------------------------------------------------------------------------------------------Pedro
       // Function to calculate the effective interest rate
    public static double effectiveInterestRate(double r, int n) {
        return Math.pow(1 + r / n, n) - 1;
    }

    // Function to calculate the nominal interest rate from the effective rate
    public static double nominalInterestRate(double ER, int a) {
        return a * (Math.pow(1 + ER, 1.0 / a) - 1);
    }
    //----------------------------------------------------------------------------------------------------------------------------------BeginningCompountInterestRate - Pedro
    

    // Function to calculate future value with nominal interest rate and contributions
    public static double interestRateBegining(double PI, double Ca, double Cm, double r, int a, int n, double t) {
        double FV = 0;

        // Step 1: Calculate effective interest rate
        double ER = effectiveInterestRate(r, n);

        // Step 2: Calculate nominal interest rate
        double NR = nominalInterestRate(ER, a);

        // Step 3: Calculate future value using the nominal interest rate (NR) with annual contributions
        FV += Ca * ((Math.pow(1 + NR / a, a * t) - 1) / (NR / a)) * (1 + NR / a);

        // Recalculate NR for monthly contributions
        NR = nominalInterestRate(ER, 12);  // a = 12 for monthly
        int m = 12;
        FV += Cm * ((Math.pow(1 + NR / m, m * t) - 1) / (NR / m)) * (1 + NR / m);

        // Add the primary investment compounded annually
        FV += PI * Math.pow(1 + r / n, n * t);

        return FV;
    }
    
        // Step 3: Function to calculate the future value using nominal interest rate and contributions
    public static double interestrateEND(double PI, double Ca, double Cm, double r, int a, int n, double t) {
        double FV = 0;

        // Step 1: Calculate effective interest rate
        double ER = effectiveInterestRate(r, n);

        // Step 2: Calculate nominal interest rate
        double NR = nominalInterestRate(ER, a);

        // Step 3: Calculate future value using the nominal interest rate (NR) with annual contributions
        FV += Ca * ((Math.pow(1 + NR / a, a * t) - 1) / (NR / a));

        // Recalculate NR for monthly contributions
        NR = nominalInterestRate(ER, 12);  // a = 12 for monthly
        int m = 12;
        FV += Cm * ((Math.pow(1 + NR / m, m * t) - 1) / (NR / m));

        // Add the primary investment compounded annually
        FV += PI * Math.pow(1 + r / n, n * t);

        return FV;
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------formula for continuous Interest RateCalculator - Pedro 
        // Function to calculate future value for end contributions
    public static double future_valueEnd(double PI, double Ca, double Cm, double r, double t) {
        // Continuous compounding for primary investment
        double continuousP = PI * Math.exp(r * t);

        // Future value for annual contributions at the end
        double endFVAnnual = 0;
        for (int i = 1; i < t; i++) {
            double endInterest = (endFVAnnual + Ca) * Math.exp(r);
            endFVAnnual = endInterest;
        }
        System.out.println("End (annual): " + (endFVAnnual + Ca));

        // Future value for monthly contributions at the end
        double endFVMonthly = 0;
        for (int i = 1; i < t * 12; i++) {
            double endInterest = (endFVMonthly + Cm) * Math.exp(r / 12);
            endFVMonthly = endInterest;
        }
        System.out.println("End (monthly): " + (endFVMonthly + Cm));

        return (continuousP) + (endFVAnnual + Ca) + (endFVMonthly + Cm);
    }

    // Function to calculate future value for beginning contributions
    public static double future_valueBeginning(double PI, double Ca, double Cm, double r, double t) {
        // Continuous compounding for primary investment
        double continuousP = PI * Math.exp(r * t);

        // Future value for annual contributions at the beginning
        double beginningFVAnnual = 0;
        for (int i = 1; i <= t; i++) {
            double annualInterest = (beginningFVAnnual + Ca) * Math.exp(r);
            beginningFVAnnual = annualInterest;
        }
        System.out.println("Beginning (annual): " + beginningFVAnnual);

        // Future value for monthly contributions at the beginning
        double beginningFVMonthly = 0;
        for (int i = 1; i <= t * 12; i++) {
            double monthlyInterest = (beginningFVMonthly + Cm) * Math.exp(r / 12);
            beginningFVMonthly = monthlyInterest;
        }
        System.out.println("Beginning (monthly): " + beginningFVMonthly);

        return (continuousP) + beginningFVAnnual + beginningFVMonthly;
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------Extra Calculation for Interest Rate Calculator 
    public static double[] interestRateCalculatorExtraCalculations(double FV_year, double PI, double Ca, double Cm, double t) {
        // Calculate total principal
        double totalPrinciple = PI + (Ca * t) + (Cm * 12 * t);
        
        // Calculate total contributions
        double totalContributions = totalPrinciple - PI;
        
        // Calculate total interest
        double totalInterest = FV_year - totalPrinciple;

        // Return values in an array, rounded to two decimal places
        return new double[] {
            Math.round(totalPrinciple * 100.0) / 100.0,    // Total Principal
            Math.round(totalContributions * 100.0) / 100.0, // Total Contributions
            Math.round(totalInterest * 100.0) / 100.0,       // Total Interest
            Math.round(FV_year * 100.0) / 100.0       // Total Interest
        };
    }

    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------Roth IRA Calculator - Pedro
    
    //-------------------------------------------------No
        public static double calculate_MaximizeContributionNo(double PI, double Ca, double r, int n) {
            
            
            // Calculate FVcurrentBalance
            double FVcurrentBalance = PI * Math.pow((1 + r), n);
            System.out.println("NO- current: " + FVcurrentBalance);

            // Calculate FVanualcontribution
            double FVanualcontribution = Ca * (Math.pow((1 + r), n) - 1) / r;
            System.out.println("NO annual: " + FVanualcontribution);

            // Calculate total future value
            double futureValue = FVanualcontribution + FVcurrentBalance;
            System.out.println("Total future value: " + futureValue);
            return futureValue;
    }
        //------------------------------------------Yes
        public static double calculate_MaximizeContributionYes(double PI, double Ca, double r, int C_age, int R_age) {
        double balance = 0;

        if (R_age <= 50 || (C_age >= 50 && R_age >= 50)) {
            int Under50 = R_age - C_age;
            balance += Ca * (Math.pow(1 + r, Under50) - 1) / r;
            balance += PI * Math.pow(1 + r, Under50);
        } else {
            int Under50 = 50 - C_age;
            balance += Ca * (Math.pow(1 + r, Under50) - 1) / r;
            balance += PI * Math.pow(1 + r, Under50);

            int Over50 = R_age - 50;
            for (int i = 0; i < Over50; i++) {
                double RothIraunder50 = balance * r;
                balance += RothIraunder50 + 8000;
            }
        }

        System.out.println("Balance: " + balance);

        return balance;
    }
        //----------------------------------------------------------------------------------------------------------------------------Extra Calculation for RothIRAYEs
        public static double[] extraCalculationsRothIRACalculatorYES(double PI, double Ca, int C_age, int R_age, double result) {
        double balance = 0;
        double totalInterest = 0;

        if (R_age <= 50 || (C_age >= 50 && R_age >= 50)) {
            // Case where age at retirement is 50 or younger, or both current and retirement age are above 50
            int Under50 = R_age - C_age;
            balance = PI + (Ca * Under50);
            totalInterest = (result - balance) + Ca;
        } else {
            // Case where retirement age is over 50
            int Under50 = 50 - C_age;
            int Over50 = R_age - 50;
            balance = PI + (Ca * Under50);
            Ca = 8000; // Update annual contribution for over 50
            balance += Ca * Over50;
            totalInterest = (result - balance)+Ca;
        }

        // Return balance and total interest as an array
        return new double[] {
            Math.round(balance * 100.0) / 100.0,       // Rounded balance
            Math.round(totalInterest * 100.0) / 100.0  // Rounded total interest
        };
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------Rent Calculator - Pedro
        
               // Function to calculate affordable rent based on income
    public static long[] calculateAffordableRent(double income, double debt, String option) {
        double acceptableAggressive = 0;
        double safeAcceptable = 0;
        double affordableRent;

        if (option.equals("monthly") && debt == 0) {
            affordableRent = ((income * 12 * 30) / 1000) - debt;
            if (affordableRent > 0) {
                acceptableAggressive = affordableRent;
                safeAcceptable = (affordableRent * (7.0 / 9.0));
            } else {
                return null;
            }

        } else if (option.equals("monthly") && debt > 0) {
            affordableRent = ((income * 12 * 30) / 1000);
            if (affordableRent-debt > 0) {
                acceptableAggressive = affordableRent - debt;
                safeAcceptable = (affordableRent * (7.0 / 9.0)) - debt;
            }else{return null;}

        } else if (option.equals("year") && debt == 0) {
            affordableRent = ((income * 30) / 1000) - debt;
            if (affordableRent -debt> 0) {
                acceptableAggressive = affordableRent;
                safeAcceptable = (affordableRent * (7.0 / 9.0));
            } else {
                return null;
            }

        } else {
            affordableRent = ((income * 30) / 1000);
            if (affordableRent -debt> 0) {
                acceptableAggressive = affordableRent - debt;
                safeAcceptable = (affordableRent * (7.0 / 9.0)) - debt;
            } else {
                return null;
            }
        }

       return new long[]{Math.round(acceptableAggressive), Math.round(safeAcceptable)};
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------DownPayment Calculator - Pedro 
    
    
        // Function: No Closing Costs Included, Down Payment Percentage
    public static double[] downpaymentNOClosingCostandPercent(double UpC, double DP, double rate, double loanTerm, double includeClosingCosts) {
        double r = (rate / 100) / 12;  // Monthly interest rate
        double n = loanTerm * 12;      // Total number of payments (months)
        double top = Math.pow(1 + r, n) - 1;
        double bottom = r * Math.pow(1 + r, n);
        double k = top / bottom;

        double Sp = 100 / (DP + includeClosingCosts);  // Loan to value ratio
        double homePrice = UpC * Sp;                   // Home price based on upfront cash and percentage
        double subtractingFromLoan = UpC - UpC * (includeClosingCosts / 100) * Sp;  // Subtracting closing costs
        double loanAmount = homePrice - subtractingFromLoan;   // Final loan amount
        double monthlyPayment = loanAmount / k;                // Monthly mortgage payment
        
        homePrice = Math.round(homePrice);
        loanAmount = Math.round(loanAmount);
        monthlyPayment = Math.round(monthlyPayment);

        return new double[]{homePrice, loanAmount, monthlyPayment};
    }

    // Function: Yes Closing Costs Included, Down Payment in Money
    public static double[] downpaymentYesClosingCostandMoney(double UpC, double DP, double rate, double loanTerm, double includeClosingCosts) {
        double r = (rate / 100) / 12;  // Monthly interest rate
        double n = loanTerm * 12;      // Total number of payments (months)
        double top = Math.pow(1 + r, n) - 1;
        double bottom = r * Math.pow(1 + r, n);
        double k = top / bottom;

        double Sp = 100 / DP;          // Loan to value ratio
        UpC = UpC - includeClosingCosts;  // Subtracting closing costs from upfront cash
        double homePrice = UpC * Sp;      // Home price after closing costs
        double loanAmount = homePrice - UpC;  // Final loan amount
        double monthlyPayment = loanAmount / k;  // Monthly mortgage payment
        homePrice = Math.round(homePrice);
        loanAmount = Math.round(loanAmount);
        monthlyPayment = Math.round(monthlyPayment);

        return new double[]{homePrice, loanAmount, monthlyPayment};
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------Percentage Validation Pedro
public static boolean validateInput(double input, double hp, String checker) {
        try {
            double value = input;

            if (checker.equals("$")) {
                if (value < hp) {
                    // Valid dollar input
                    return true;
                } else {
                    // Show error message for dollar amount
                    JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price ($" + hp + ")", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else if (checker.equals("%")) {
                if (value >= 0 && value <= 100) {
                    // Valid percentage input
                    return true;
                } else {
                    // Show error message for percentage range
                    JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 100", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else {
                // Show error message for invalid checker
                JOptionPane.showMessageDialog(null, "Error: Checker must be either '$' or '%'", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            // Show error message for invalid number format
            JOptionPane.showMessageDialog(null, "Error: Invalid number format", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------Mortgage Calculator Pedro
    
    public static double[] mortgageCalculator(double hp, double dp, int loanTerm, double rate, int startDate, double pt, double hI, double hf, double oc) {
        double r = (rate / 100) / 12;          // Monthly interest rate
        double n = loanTerm * 12;              // Total number of payments (months)
        double loanAmount = hp - dp;           // Loan principal after downpayment
        
        // Monthly mortgage payment calculation
        double top = Math.pow(1 + r, n) - 1;
        double bottom = r * Math.pow(1 + r, n);
        double monthlyPayment = loanAmount * (r / (1 - 1 / Math.pow(1 + r, n)));
        
        // Monthly additional costs
        double monthlyPropertyTaxes = pt / 12;
        double monthlyHomeInsurance = hI / 12;
        double monthlyHOAFee = hf / 12;
        double monthlyOtherCost = oc / 12;
        
        // Total out-of-pocket monthly cost
        double totalMonthlyOutOfPocket = monthlyPayment + monthlyPropertyTaxes + monthlyHomeInsurance + monthlyHOAFee + monthlyOtherCost;
        
        // Total payments and interest
        double totalMortgagePayments = monthlyPayment * n;
        double totalInterest = totalMortgagePayments - loanAmount;
        
        // Mortgage payoff date
        int payoffDate = startDate + loanTerm;
        
        return new double[] {
            Math.round(loanAmount * 100.0) / 100.0,
            Math.round(monthlyPayment * 100.0) / 100.0,
            Math.round(monthlyPropertyTaxes * 100.0) / 100.0,
            Math.round(monthlyHomeInsurance * 100.0) / 100.0,
            Math.round(monthlyHOAFee * 100.0) / 100.0,
            Math.round(monthlyOtherCost * 100.0) / 100.0,
            Math.round(totalMortgagePayments * 100.0) / 100.0,
            Math.round(totalInterest * 100.0) / 100.0,
            payoffDate,
            Math.round(totalMonthlyOutOfPocket * 100.0) / 100.0
                
        };
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------MortgagePayoff Calculator 
        public static double[] mortgagePayoffCalculator(double ola, int olt, double r, int rt, int m) {
        // Convert annual interest rate from percentage to decimal
        r = r / 100;

        // Calculate remaining months
        int p = (olt * 12) - ((rt * 12) + m);

        // Remaining balance calculation
        double top = ola * (Math.pow(1 + (r / 12), olt * 12) - Math.pow(1 + (r / 12), p));
        double bottom = Math.pow(1 + (r / 12), olt * 12) - 1;
        double b = top / bottom;

        // Monthly payment calculation
        double pat = b * ((r / 12) * Math.pow(1 + (r / 12), (rt * 12) + m)) / (Math.pow(1 + (r / 12), (rt * 12) + m) - 1);

        // Savings calculation
        double savings = (pat * ((12 * rt) + m)) - b;

        // Original payoff schedule
        double rpmt = pat * ((12 * rt) + m); // Remaining balance
        double tp = (ola * ((r / 12) * Math.pow(1 + (r / 12), olt * 12)) / (Math.pow(1 + (r / 12), olt * 12) - 1)) * 12 * olt; // Total payment
        double totalInterest = tp - ola;

        // If payoff altogether
        double totalPayment = tp - savings;
        double payoffTotalInterest = totalInterest - savings;

        // Return values in an array, rounded to two decimal places
        return new double[] {
            Math.round(totalPayment * 100.0) / 100.0,          // Total Payment if Payoff Together
            Math.round(payoffTotalInterest * 100.0) / 100.0,   // Total Interest if Payoff Together
            Math.round(pat * 100.0) / 100.0,                   // Monthly Payment
            Math.round(tp * 100.0) / 100.0,                    // Total Payment on Original Schedule
            Math.round(totalInterest * 100.0) / 100.0,         // Total Interest on Original Schedule
            Math.round(rpmt * 100.0) / 100.0,                  // Remaining Balance
            Math.round(savings * 100.0) / 100.0,               // Remaining Interest Savings
            Math.round(b * 100.0) / 100.0                      // Remaining Balance to Pay Off Loan
        };
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------Jorge
    public static boolean isPositiveNumber(String num){
        try{
            double val = Double.parseDouble(num); // Convert string to a double.
            return val > 0; // Return true if the value is positive.
        }catch (NumberFormatException e){
            return false; // Return false if the string is not a valid number.
        }
    }
    
    public static boolean inRange(double num, double max){
        return num <= max; // Returns true if the number is within the specified range.
    }

    public static boolean isEmptyInput(String input){
        return input == null || input.trim().isEmpty();
    }

    public static double calcMonthlyPayment(String loanAmountStr, String annualInterestRateStr, String yearsStr) {
        if(isEmptyInput(loanAmountStr) || isEmptyInput(annualInterestRateStr) || isEmptyInput(yearsStr)){
            System.out.println("Input cannot be empty.");
            return -1;
        }
        
        double loanAmount;
        double annualInterestRate;
        int years;
        
        try{
            loanAmount = Double.parseDouble(loanAmountStr);
            annualInterestRate = Double.parseDouble(annualInterestRateStr);
            years = Integer.parseInt(yearsStr);
        }catch (NumberFormatException e){
            System.out.println("Invalid input format.");
            return -1;
        }
        
        String msg = ""; // Message to accumulate any input validation errors.
        
        if (years <= 0) {
            msg += "Input must be positive. Years must be greater than 0. \n";
        }
        
        if(annualInterestRate <= 0){
            msg += "Input must be positive. Annual interest rate must be greater than 0. \n";
        }
        
        if(loanAmount <= 0){
            msg += "Input must be positive. Loan Amount must be greater than 0. \n";
        }
        
        // Validate input: Ensure the loan amount does not exceed the maximum allowable value.
        double maxValue = 999999999; // Maximum allowed value for loan amount and interest rate.
        if(!inRange(loanAmount, maxValue)){
            msg += "Input too large: Loan amount exceeds limit.";
        }
        
        // Validate input: Ensure the interest rate does not exceed the maximum allowable value.
        if(!inRange(annualInterestRate, maxValue)){
            msg += "Input too large: Interest rate exceeds limit.";
        }
        
        if(!inRange(years, maxValue)){
            msg += "Input too large: Years exceeds limit.";
        }
        
        // If there are any validation errors, print the message and return -1 to indicate failure.
        if(!msg.isEmpty()){
            System.out.println(msg);
            return -1;
        }
            
            // Call the computeMonthlyPayment function
            return computeMonthlyPayment(loanAmount, annualInterestRate, years);
        }
        
        public static double computeMonthlyPayment(double loanAmount, double annualInterestRate, int years){
            double monthlyInterestRate = annualInterestRate / 1200; // Calculate monthly interest rate from annual interest rate.
            int numMonths = years * 12; // Calculate total number of months for the loan term.
            
            // Calculate the monthly payment using the loan payment formula.
        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numMonths)); 
        
        return monthlyPayment; // Returns the calculated monthly payment
        }
        
        
        //-----------------------------AUTO-LOAN-CALCULATOR--------------------------------------------------------------------------
        public static double[] calcAutoLoan(
        String autoPriceStr,
        String loanTermStr,
        String interestRateStr,
        String cashIncentivesStr,
        String downPaymentStr,
        String tradeInValueStr,
        String amtOwnedTradeInStr,
        String salesTaxStr,
        String otherFeesStr){
            
         String msg = "";
            
            if (isEmptyInput(autoPriceStr) || isEmptyInput(loanTermStr) || isEmptyInput(interestRateStr) ||
       isEmptyInput(cashIncentivesStr) || isEmptyInput(downPaymentStr) || isEmptyInput(tradeInValueStr) || 
       isEmptyInput(amtOwnedTradeInStr) || isEmptyInput(salesTaxStr) || isEmptyInput(otherFeesStr)){
                System.out.println("Input cannot be empty.");
                msg += "All input fields are required. \n";
            }
            
            double autoPrice, downPayment, tradeInValue, cashIncentives, amtOwnedTradeIn, interestRate, salesTax, otherFees;
            int  loanTerm;
            double maxValue = 999999999;
            
            // Attempt to parse the input strings into numeric values
            try{
                autoPrice = Double.parseDouble(autoPriceStr);
                downPayment = Double.parseDouble(downPaymentStr);
                tradeInValue = Double.parseDouble(tradeInValueStr);
                salesTax = Double.parseDouble(salesTaxStr);
                otherFees = Double.parseDouble(otherFeesStr);
                cashIncentives = Double.parseDouble(cashIncentivesStr);
                amtOwnedTradeIn = Double.parseDouble(amtOwnedTradeInStr);
                interestRate = Double.parseDouble(interestRateStr);
                loanTerm = Integer.parseInt(loanTermStr);
            }catch (NumberFormatException e){
                msg += "Invalid input format. Please enter numeric values. \n";
                // Return an error if input cannot be parsed into a number
                System.out.println("Invalid input format.");
                return new double []{-1,-1};
            }
            
            // Attempt to parse the input strings into numeric values and check for non-zero/non-negative where necessary.
    try {
        autoPrice = Double.parseDouble(autoPriceStr);
        if (autoPrice <= 0) {
            msg += "Auto price must be greater than 0.\n";
        }
        
        loanTerm = Integer.parseInt(loanTermStr);
        if (loanTerm <= 0) {
            msg += "Loan term must be greater than 0.\n";
        }

        interestRate = Double.parseDouble(interestRateStr);
        if (interestRate < 0) {
            msg += "Interest rate cannot be negative.\n";
        }

        downPayment = Double.parseDouble(downPaymentStr);
        if (downPayment < 0) {
            msg += "Down payment cannot be negative.\n";
        }

        tradeInValue = Double.parseDouble(tradeInValueStr);
        if (tradeInValue < 0) {
            msg += "Trade-in value cannot be negative.\n";
        }

        cashIncentives = Double.parseDouble(cashIncentivesStr);
        if (cashIncentives < 0) {
            msg += "Cash incentives cannot be negative.\n";
        }

        amtOwnedTradeIn = Double.parseDouble(amtOwnedTradeInStr);
        if (amtOwnedTradeIn < 0) {
            msg += "Amount owed on trade-in cannot be negative.\n";
        }

        salesTax = Double.parseDouble(salesTaxStr);
        if (salesTax < 0) {
            msg += "Sales tax cannot be negative.\n";
        }

        otherFees = Double.parseDouble(otherFeesStr);
        if (otherFees < 0) {
            msg += "Other fees cannot be negative.\n";
        }
        
        // Validate range limits
        if (!inRange(autoPrice, maxValue)) {
            msg += "Auto price exceeds the allowed maximum limit.\n";
        }
        if (!inRange(interestRate, maxValue)) {
            msg += "Interest rate exceeds the allowed maximum limit.\n";
        }
        if (!inRange(loanTerm, maxValue)) {
            msg += "Loan term exceeds the allowed maximum limit.\n";
        }

    } catch (NumberFormatException e) {
        // Return an error if input cannot be parsed into a number
        System.out.println("Invalid input format.");
        return new double[] {-1, -1};
    }
            
            
            if (autoPrice <= 0) {
                msg += "Auto price must be greater than 0.\n";
            }
            if (loanTerm <= 0) {
                msg += "Loan term must be greater than 0.\n";
            }
            if (interestRate <= 0) {
                msg += "Interest rate must be greater than 0.\n";
            }
            
            // Validate range limits
            if (!inRange(autoPrice, maxValue)) {
                msg += "Auto price exceeds the allowed maximum limit.\n";
            }
            if (!inRange(interestRate, maxValue)) {
                msg += "Interest rate exceeds the allowed maximum limit.\n";
            }
            if (!inRange(loanTerm, maxValue)) {
                msg += "Loan term exceeds the allowed maximum limit.\n";
            }
            
            // If there are validation errors, return [-1, -1]
            if(!msg.isEmpty()){
                System.out.println(msg);
                return new double[]{-1,-1};
            }
          
            // Proceed with calculation if input is valid
            double autoLoanPayment = autoPrice - downPayment - tradeInValue + amtOwnedTradeIn - cashIncentives;
            double salesTaxAmount = (autoPrice - tradeInValue) * (salesTax / 100);
            double autoLoanPaymentFees = autoLoanPayment + salesTaxAmount + otherFees;
            double monthlyInterestRate = (interestRate / 100) / 12;
           
            // Declare variables to store the monthly payments
            double paymentWithoutFees;
            double paymentWithFees;
           
            // Calculate the monthly payment without fees
            if (monthlyInterestRate == 0) {
                // If the interest rate is 0, the loan is divided evenly over the loan term
                paymentWithoutFees = autoLoanPayment / loanTerm;
            } else {
                // Standard loan formula: P * r / (1 - (1 + r)^-n)
                paymentWithoutFees = (autoLoanPayment * monthlyInterestRate) /
                                     (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
            }
           
            // Calculate the monthly payment with fees included
            if (monthlyInterestRate == 0) {
                // Same logic for 0 interest rate
                paymentWithFees = autoLoanPaymentFees / loanTerm;
            } else {
                // Same formula but with the loan amount that includes fees
                paymentWithFees = (autoLoanPaymentFees * monthlyInterestRate) /
                                  (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
            }
           
            // Round the results to two decimal places for better readability
            paymentWithFees = Math.round(paymentWithFees * 100) / 100.0;
            paymentWithoutFees = Math.round(paymentWithoutFees * 100) / 100.0;
            
            // Return both the payments (without fees and with fees) in an array
            return new double[]{paymentWithoutFees, paymentWithFees};
        }
}
