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
import java.lang.StringBuilder;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Helper {
    private static List<String> messages = new ArrayList<>();
    //----------------------------------------------------------------------------------------------------------------------------------General Input Validation 
    //-------------------------------------------------------------------------------Checking age 
    public static boolean checkAge(String ageInput) {
        try {
            
            int age = Integer.parseInt(ageInput); // Convert input to integer
            
            if (age >= 1 && age <= 120) {
                return true;
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid age. Please enter an age between 1 and 120.", "Age Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------Validation of age fileds 
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
    //---------------------------------------------------------------------------------only numbers
    public static String extractNumbers(String input) {
        // Use a StringBuilder to store the resulting numbers
            StringBuilder result = new StringBuilder();

            // Flag to check if a period has already been added to avoid multiple decimals
            boolean hasDecimalPoint = false;

            // Iterate through each character in the input string
            for (char ch : input.toCharArray()) {
                if (Character.isDigit(ch)) {
                    // Append digits to the result
                    result.append(ch);
                } else if (ch == '.' && !hasDecimalPoint) {
                    // Append a single decimal point
                    result.append(ch);
                    hasDecimalPoint = true;
                }
            }

            // Return the extracted numbers as a string
            return result.toString();
    }
    
    public static String extractWholePositiveNumbers(String input) {
        // Use a StringBuilder to store the resulting whole positive numbers
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input string
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Append digits to the result
                result.append(ch);
            }
        }

        // Return the extracted whole positive numbers as a string
        return result.toString();
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
                     
                        return false;
                    }
                } else if (checker.equals("%")) {
                    if (value >= 0 && value <= 100) {
                        // Valid percentage input
                        return true;
                    } else {
                        // Show error message for percentage range
                 
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


    //-----------------------------------------------------------------------------------------------------------InterestRateCalculator ----Pedro
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
                   
                    return false;  // Return false to indicate invalid input
                }
            } else {
                       
                return false;  // Return false to indicate invalid input
                
            }
        }
        return false;
    }
    
    //----------------------------------------------------------------------------------------------------------------------------Input Validation for INteresetRate Calculator
    public static boolean interesRateValidationInput(String InitialInvestment, String AnualContribution, String MonthlyContribution, String InterestRate, String InvestmentLenght){
        try{
                boolean isInitialInvestmentValid = InputValidation(InitialInvestment);
                boolean isAnualContributionValid = InputValidation(AnualContribution);
                boolean isMonthlyContributionValid = InputValidation(MonthlyContribution);
                boolean isInterestRateValid = InputValidation(InterestRate);
                boolean isInvestmentLenghtValid = InputValidation(InvestmentLenght);
                boolean isInvestmentLenghtValid2 = isWholeNumber(InvestmentLenght);


                if (!isInitialInvestmentValid) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Initial Investment field!");
                    return false; // Stop if InitialInvestment is invalid
                }

                if (!isAnualContributionValid) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Annual Contribution field!");
                    return false; // Stop if AnualContribution is invalid
                }
                
                if (!isMonthlyContributionValid) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Monthly Contribution field!");
                    return false; // Stop if AnualContribution is invalid
                }
                if (!isInterestRateValid) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Monthly Contribution field!");
                    return false; // Stop if AnualContribution is invalid
                }
                
                if (!isInvestmentLenghtValid2) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Investment Lenght field! It must be a whole number");
                    return false; // Stop if AnualContribution is invalid
                }
                
                if (!isInvestmentLenghtValid) {
                    JOptionPane.showMessageDialog(null, "Invalid number format in the Investment Lenght field! It must be a whole number");
                    return false; // Stop if AnualContribution is invalid
                }
                
                
                
                
                // Both fields are valid
                return true;
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Invalid number format somewhere!.");        
            
            return false;}
    
    
    }
    
        public static boolean interesRateValidationInput2(String II, String AC ){
        try{
            return true;
        }
        catch(Exception e){
            
            return false;}
    
    
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
    
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------MortgagePayoff Calculator PEdro and Azusena 
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
        
        
       //-------------------------------------------------------------------------------------------------------------------------------------MortgagePayoff Byweekly
public static String[] mortgagePayoffByweekly(double currentLoan, int originalTime, int oTimeLeftYears, int oTimeLeftMonths, double interest) {
        DecimalFormat df = new DecimalFormat("#.00");

        // Loan terms and initial setup
        double monthlyInterest = interest / 12 / 100;
        int timeLeft = oTimeLeftYears * 12 + oTimeLeftMonths; // Total remaining months
        int totalMonths = originalTime * 12; // Total original months

        // Calculate original monthly payment
        double monthlyPay = (currentLoan * (monthlyInterest * Math.pow(1 + monthlyInterest, totalMonths))) /
                (Math.pow(1 + monthlyInterest, totalMonths) - 1);

        double totalIntPaid = 0;
        double original = currentLoan;

        // Calculate original total interest and principal
        for (int i = 0; i < totalMonths; i++) {
            double originalInterestPaid = original * monthlyInterest;
            totalIntPaid += originalInterestPaid;
            double principal = monthlyPay - originalInterestPaid;
            original -= principal;
        }

        double beforeInterestPaid = 0;
        // Remaining principal calculation
        double principalLeft = currentLoan;
        int timePaid = totalMonths - timeLeft; // Time already paid
        for (int i = 0; i < timePaid; i++) {
            double interestPaid = principalLeft * monthlyInterest;
            beforeInterestPaid += interestPaid;
            double monthlyPrincipal = monthlyPay - interestPaid;
            principalLeft -= monthlyPrincipal;
        }

        double totalPaymentLeft = monthlyPay * timeLeft;

        // Biweekly calculations
        double remainingPrincipal = principalLeft;
        double biweeklyPayment = monthlyPay / 2;
        int i = 0;
        double biTotalInterest = 0;

        while (remainingPrincipal > 0) {
            if ((i % 6 == 0 || i % 12 == 0) && i != 0) {
                remainingPrincipal -= biweeklyPayment;
            }
            double biInterestPaid = remainingPrincipal * monthlyInterest;
            biTotalInterest += biInterestPaid;
            double biPrincipal = monthlyPay - biInterestPaid;
            remainingPrincipal -= biPrincipal;
            i++;
        }

        // Summaries
        //Original
        String totalPaymentsSummary = df.format(totalIntPaid + currentLoan);//"Total Payments: " + 
        String totalInterestSummary = df.format(totalIntPaid);//"Total Interest Paid: " + 
        String remainingPaymentsSummary = df.format(totalPaymentLeft);//"Remaining Payments: " + 
        String remainingInterestSummary =  df.format(totalIntPaid - beforeInterestPaid);//"Remaining Interest: " +
        String payoffTimeSummary = "Payoff In: " + oTimeLeftYears + " years and " + oTimeLeftMonths + " months";
        String yearsLeft = String.valueOf(oTimeLeftYears);
        String monthsLeft = String.valueOf(oTimeLeftMonths);
        
        //Biweekly

        String totalBiPaymentsSummary =  df.format(biTotalInterest + currentLoan + beforeInterestPaid);
        String totalBiInterestSummary =  df.format(biTotalInterest + beforeInterestPaid);
        String remainingBiPaymentsSummary =  df.format(biTotalInterest + principalLeft);
        String remainingBiInterestSummary = df.format(biTotalInterest);
        String biPayoffTimeSummary = (i / 12) + " years and " + (i % 12) + " months";

        String byweeklyPay = df.format(monthlyPay / 2);

        int payoffIn = (oTimeLeftYears * 12 + oTimeLeftMonths) - (((i / 12) * 12) + (i % 12));
        int payoffYearsEarly = payoffIn / 12;
        int payoffMonthsEarly = payoffIn % 12;
        String timeEarly = payoffYearsEarly + " years and " + payoffMonthsEarly + " months earlier";

        String savingsInInterest = df.format(totalIntPaid - (biTotalInterest + beforeInterestPaid));

        return new String[]{
                String.valueOf(payoffYearsEarly),//0
                String.valueOf(payoffMonthsEarly),//1
                byweeklyPay,//2
                timeEarly,//3
                savingsInInterest,//4
                //orginal
                totalPaymentsSummary, //5
                totalInterestSummary,//6
                remainingPaymentsSummary,//7
                remainingInterestSummary,//8
                payoffTimeSummary,//9
                yearsLeft,//10
                monthsLeft,//11
                
                //custom
                
                totalBiPaymentsSummary, //12
                totalBiInterestSummary,//13
                remainingBiPaymentsSummary,//14
                remainingBiInterestSummary,//15
                biPayoffTimeSummary//16
        };
    }     
    //--------------------------------------------------------------------------------------------------------------------------MortgageCalculatorCustom 
public static String[] mortgagePayoffCustom(double currentLoan, int originalTime, int oTimeLeftYears, int oTimeLeftMonths,
                                                double interest, double perMonth, double perYear, double oneTime) {
        DecimalFormat df = new DecimalFormat("#.00");

        // Loan terms and initial setup
        double monthlyInterest = interest / 12 / 100;
        int timeLeft = oTimeLeftYears * 12 + oTimeLeftMonths; // Total remaining months
        int totalMonths = originalTime * 12; // Total original months

        // Calculate original monthly payment
        double monthlyPay = (currentLoan * (monthlyInterest * Math.pow(1 + monthlyInterest, totalMonths))) /
                (Math.pow(1 + monthlyInterest, totalMonths) - 1);

        double totalIntPaid = 0;
        double original = currentLoan;

        // Calculate original total interest and principal
        for (int i = 0; i < totalMonths; i++) {
            double originalInterestPaid = original * monthlyInterest;
            totalIntPaid += originalInterestPaid;
            double principal = monthlyPay - originalInterestPaid;
            original -= principal;
        }

        double beforeInterestPaid = 0;
        // Remaining principal calculation
        double principalLeft = currentLoan;
        int timePaid = totalMonths - timeLeft; // Time already paid
        for (int i = 0; i < timePaid; i++) {
            double interestPaid = principalLeft * monthlyInterest;
            beforeInterestPaid += interestPaid;
            double monthlyPrincipal = monthlyPay - interestPaid;
            principalLeft -= monthlyPrincipal;
        }

        double totalPaymentLeft = monthlyPay * timeLeft;
        double finalPaymentLeft = totalPaymentLeft;

        // Custom Repayment
        double remainingPrincipal = principalLeft;
        double customTotalInt = 0;
        int months = 0;

        while (remainingPrincipal > 0) {
            if (months % 12 == 0 && months != 0) {
                remainingPrincipal -= perYear;
            }
            double cInterestPaid = remainingPrincipal * monthlyInterest;
            customTotalInt += cInterestPaid;
            double cPrincipal = monthlyPay - cInterestPaid;
            remainingPrincipal -= cPrincipal;
            if (months == 0) {
                remainingPrincipal -= oneTime;
            }
            remainingPrincipal -= perMonth;
            months++;
        }

        // Custom summaries
        String totalPaymentsSummaryCustom = df.format(customTotalInt + currentLoan + beforeInterestPaid);
        String totalInterestSummaryCustom =  df.format(customTotalInt + beforeInterestPaid);
        String remainingPaymentsSummaryCustom = df.format(customTotalInt + principalLeft);
        String remainingInterestSummaryCustom =  df.format(customTotalInt);
        String payoffTimeSummaryCustom =  (months / 12) + " years and " + (months % 12) + " months";

        // Original summaries
        String totalPaymentsSummary = df.format(totalIntPaid + currentLoan);
        String totalInterestSummary =  df.format(totalIntPaid);
        String remainingPaymentsSummary =  df.format(finalPaymentLeft);
        String remainingInterestSummary =  df.format(totalIntPaid - beforeInterestPaid);
        String payoffTimeSummary =  oTimeLeftYears + " years and " + oTimeLeftMonths + " months";

        // Time saved
        int payoffIn = (oTimeLeftYears * 12 + oTimeLeftMonths) - months;
        int payoffYearsEarly = payoffIn / 12;
        int payoffMonthsEarly = payoffIn % 12;
        String timeEarly = payoffYearsEarly + " years and " + payoffMonthsEarly + " months earlier";

        // Savings
        String savingsInInterest = df.format(totalIntPaid - (customTotalInt + beforeInterestPaid));

        // Monthly payment with custom addition
        double monthlyPayment = monthlyPay + perMonth;

        // Return all results as an array of objects
        return new String[]{
            String.valueOf(payoffYearsEarly),
            String.valueOf(payoffMonthsEarly),
            String.valueOf(perMonth),
            String.valueOf(perYear),
            String.valueOf(oneTime),
            String.valueOf(monthlyPayment),
            timeEarly,
            savingsInInterest, 
            totalPaymentsSummaryCustom,
            totalInterestSummaryCustom,
            remainingPaymentsSummaryCustom,
            remainingInterestSummaryCustom,
            payoffTimeSummaryCustom, 
            totalPaymentsSummary,
            totalInterestSummary,
            remainingPaymentsSummary,
            remainingInterestSummary,
            payoffTimeSummary
            
        };
    }
   
        //-----------------------------------------------------------------------------------------------------------------------------------------Retirement Calculator 
    public static double effectiveInterestRateRetirement(double m, double r) {
    r = r / 100;
    return m * (Math.pow((1 + r), (1 / m)) - 1);
    }

    public static double averageReturnInvestment(double incomeNeededAfterRetirement, double m, double returnInvestmentRate, double n) {
        double er = effectiveInterestRateRetirement(m, returnInvestmentRate);
        double incomeAfterRetirementMonthly = incomeNeededAfterRetirement / m;
        double top = (1 - Math.pow(1 + (er / m), -(n * m))) * incomeAfterRetirementMonthly;
        double bottom = er / m;
        return top / bottom;
    }

    public static double yearlyContribution(double result, double n, double r) {
        r = r / 100;
        double top = result * r;
        double bottom = Math.pow(1 + r, n) - 1;
        return top / bottom;
    }

    public static  double[] retirementCalculator(int cAge, int rAge, int lifeExpectancy, double preTaxIncome, double incomeNeededAfterRetirement, double returnInvestmentRate, double currentIncomeSaving) {
        int yearsAfterRetirement = lifeExpectancy - rAge;
        double m = 12;

        double result = averageReturnInvestment(incomeNeededAfterRetirement, m, returnInvestmentRate, yearsAfterRetirement);
        System.out.println("You will need about $" + result + " after " + rAge);

        int yearsOfContribution = rAge - cAge;

        double retirementSavings = currentIncomeSaving * Math.pow(1 + (returnInvestmentRate / 100), yearsOfContribution);

        double yContributions = yearlyContribution(result - retirementSavings, yearsOfContribution, returnInvestmentRate);
        double mContributions = yContributions / 12;
        double proportionContribution = Math.round((yContributions / preTaxIncome) * 10000) / 100.0;

        System.out.println("To save $" + result + " at " + rAge + " you can either save $" + mContributions + " per month or save $" + yContributions + " per year or save " + proportionContribution + "% of your income every year");

        if (retirementSavings < result) {
            System.out.println("Based on your current retirement savings, you will have about $" + retirementSavings + " at age " + rAge + " which is less than what you need for your retirement.");
        } else {
            System.out.println("Based on your current retirement savings, you will have about $" + retirementSavings + " at age " + rAge + " which exceeds what you need for retirement.");
        }
        return new double[]{
            Math.round(result * 100.0) / 100.0,
            Math.round(mContributions * 100.0) / 100.0,
            Math.round(yContributions * 100.0) / 100.0,
            Math.round(proportionContribution * 100.0) / 100.0,
            Math.round(retirementSavings * 100.0) / 100.0, 
        
        };
    }

    public static  double[] fixedRetirementCalculator(int cAge, int rAge, int lifeExpectancy, double preTaxIncome, double incomeNeededAfterRetirement, double currentIncomeSaving) {
        int yearsAfterRetirement = lifeExpectancy - rAge;
        double result = incomeNeededAfterRetirement * yearsAfterRetirement;

        double wYearly = result / yearsAfterRetirement;
        double wMonthly = wYearly / 12;

        double deduction = currentIncomeSaving / (rAge - cAge);

        int yContributions = rAge - cAge;
        double mContribution = yContributions * 12;
        double ySaveToRetirement = (result / yContributions) - deduction;
        double mSaveToRetirement = (result / mContribution) - (deduction / 12);
        double proportionSaveToRetirement = Math.round((ySaveToRetirement / preTaxIncome) * 10000) / 100.0;
        
    

        System.out.println();
        System.out.println("You will need about $" + result + " at age " + rAge + " to retire");
        System.out.println("If you save $" + result + " you can withdraw $" + wMonthly + " per month");

        System.out.println("How can you save $" + result + " at age " + rAge);
        System.out.println("To save $" + result + " at " + rAge + " you can either save $" + mSaveToRetirement + " per month or save $" + ySaveToRetirement + " per year or save " + proportionSaveToRetirement + "% of your income every year");
        
        return new double[]{
            Math.round(result * 100.0) / 100.0,
            Math.round(wMonthly * 100.0) / 100.0,
            Math.round(mSaveToRetirement * 100.0) / 100.0,
            Math.round(ySaveToRetirement * 100.0) / 100.0,
            Math.round(proportionSaveToRetirement * 100.0) / 100.0,     
            };
    }
    
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------------Refinance Calculator Azusena and Pedro
    
    public static double[] originalLoanAmount(double currentLoan, int originalTime, int oTimeLeftYears, int oTimeLeftMonths,
                                              int timeLeft, int timePaid, double interest, int newLoanTime,
                                              double newInterest, double points, double costs, double cashOut) {
        double monthlyInterest = interest / 12 / 100;

        // Calculate monthly payment
        double monthlyPay = (currentLoan * (monthlyInterest * Math.pow(1 + monthlyInterest, originalTime * 12))) /
                            (Math.pow(1 + monthlyInterest, originalTime * 12) - 1);
        double finalMonthly = monthlyPay;

        // Calculate remaining loan details
        int lengthLeft = oTimeLeftYears * 12 + oTimeLeftMonths;
        double totalPaymentLeft = monthlyPay * timeLeft;
        double finalPaymentLeft = totalPaymentLeft;

        double principalLeft = currentLoan;

        // Calculate principal left after payments made
        for (int i = 0; i < timePaid; i++) {
            double interestPaid = principalLeft * monthlyInterest;
            double monthlyPrincipal = monthlyPay - interestPaid;
            principalLeft -= monthlyPrincipal;
        }
        double finalPrincipalLeft = principalLeft;

        double interestLeft = totalPaymentLeft - principalLeft;
        double finalInterestLeft = interestLeft;

        // Calculate new loan details
        double newMonthlyInt = newInterest / 12 / 100;
        int newTimeLeft = 12 * newLoanTime;

        double newMonthlyPay = (principalLeft * (newMonthlyInt * Math.pow(1 + newMonthlyInt, newLoanTime * 12))) /
                               (Math.pow(1 + newMonthlyInt, newLoanTime * 12) - 1);
        double finalNewMonthly = newMonthlyPay;

        double totalNew = newMonthlyPay * newTimeLeft;
        double finalTotalNew = totalNew;

        double newInterestPayment = totalNew - principalLeft;
        double newIntPayment = newInterestPayment;

        // Return results in a double array
        return new double[] {
            finalPrincipalLeft, finalMonthly, finalPaymentLeft, finalInterestLeft,
            principalLeft, finalNewMonthly, finalTotalNew, newIntPayment
        };
    }
    
    
    public static double[] refinanceCalculatorRemaining(
        double original, double monthlyPay, double interestRate, double newLoanTime, 
        double newInterest, double points, double costs, double cashOut) {

        // Convert the annual interest rate to the monthly interest rate
        double monthlyInterest = (interestRate / 100) / 12;
        double remainingLoanAmount = original;

        double totalIntPaid = 0;
        int i = 0;

        // Calculate the number of months remaining using the amortization formula
        while (remainingLoanAmount >= 0) {
            double intPaid = remainingLoanAmount * monthlyInterest;
            totalIntPaid += intPaid;
            double principalLeft = monthlyPay - intPaid;
            remainingLoanAmount -= principalLeft;
            i++;
        }

        int months = i - 1;
        double totalPayments = months * monthlyPay;
        double totalInt = totalPayments - original;

        // New loan info
        double remainingPrincipal = original;
        if (cashOut != 0) {
            remainingPrincipal += cashOut;
        }

        // Monthly interest for the new loan
        double newMonthlyInt = newInterest / 12 / 100;
        double newTimeLeft = newLoanTime * 12;

        // Monthly payment for the new loan
        double newMonthlyPay = remainingPrincipal * (newMonthlyInt * Math.pow(1 + newMonthlyInt, newTimeLeft)) / 
                               (Math.pow(1 + newMonthlyInt, newTimeLeft) - 1);

        // Total payment for the new loan
        double totalNew = newMonthlyPay * newTimeLeft;

        // Calculating interest to be paid on the new loan
        double newPrincipalLeft = remainingPrincipal;
        double newInterestPayment = totalNew - newPrincipalLeft;

        // Points discount and upfront costs
        double discountUsed = (points / 100) * remainingPrincipal;
        double finalCost = costs + discountUsed;

        // Final take-home after costs and points
        double takeHome = -finalCost + cashOut;



        return new double[]{
            original, monthlyPay, months, totalPayments, totalInt, 
            newPrincipalLeft, newMonthlyPay, newTimeLeft, totalNew, 
            newInterestPayment, finalCost, cashOut, takeHome
        };
    }
       
    //----------------------------------------------------------------------------------------------------------------------------------------------Currency Calculator Osvaldo and Pedro
        
    public static Map<String, String[]> currency() { 
          
        Map<String, String[]> currencyDetails = new HashMap<>();

            currencyDetails.put("US Dollar", new String[]{"United States", "$", "dot", "left", "1.0", "1.0"});
            currencyDetails.put("Argentine Peso", new String[]{"Argentina", "$A", "comma", "right"});
            currencyDetails.put("Australian Dollar", new String[]{"Australia", "A$", "dot", "left"});
            currencyDetails.put("Euro", new String[]{"Austria", "€", "comma", "right"});
            currencyDetails.put("Bahraini Dinar", new String[]{"Bahrain", "BD", "dot", "left"});
            currencyDetails.put("Botswana Pula", new String[]{"Botswana", "P", "dot", "left"});
            currencyDetails.put("Brazilian Real", new String[]{"Brazil", "R$", "dot", "left"});
            currencyDetails.put("Bruneian Dollar", new String[]{"Brunei", "B$", "dot", "left"});
            currencyDetails.put("Bulgarian Lev", new String[]{"Bulgaria", "лв", "comma", "right"});
            currencyDetails.put("Canadian Dollar", new String[]{"Canada", "C$", "dot", "left"});
            currencyDetails.put("Chilean Peso", new String[]{"Chile", "$CLP", "comma", "right"});
            currencyDetails.put("Chinese Yuan Renminbi", new String[]{"China", "¥", "dot", "left"});
            currencyDetails.put("Colombian Peso", new String[]{"Colombia", "$COP", "comma", "right"});
            currencyDetails.put("Czech Koruna", new String[]{"Czech Republic", "Kč", "comma", "right"});  
            currencyDetails.put("Danish Krone", new String[]{"Denmark", "kr", "dot", "right"});
            currencyDetails.put("Euro", new String[]{"European Union", "€", "comma", "right"});    
            currencyDetails.put("Euro", new String[]{"Finland", "€", "comma", "right"});
            currencyDetails.put("Euro", new String[]{"France", "€", "comma", "right"});
            currencyDetails.put("Euro", new String[]{"Germany", "€", "comma", "right"});
            currencyDetails.put("Euro", new String[]{"Italy", "€", "comma", "right"});
            currencyDetails.put("Hong Kong Dollar", new String[]{"Hong Kong", "HK$", "comma", "left"});
            currencyDetails.put("Hungarian Forint", new String[]{"Hungary", "Ft", "comma", "right"});
            currencyDetails.put("Icelandic Krona", new String[]{"Iceland", "kr", "dot", "right"});
            currencyDetails.put("Indian Rupee", new String[]{"India", "₹", "comma", "left"});
            currencyDetails.put("Indonesian Rupiah", new String[]{"Indonesia", "Rp", "comma", "left"});
            currencyDetails.put("Iranian Rial", new String[]{"Iran", "﷼", "comma", "right"});
            currencyDetails.put("Israeli Shekel", new String[]{"Israel", "₪", "dot", "left"});
            currencyDetails.put("Japanese Yen", new String[]{"Japan", "¥", "dot", "left"});
            currencyDetails.put("Kazakhstani Tenge", new String[]{"Kazakhstan", "₸", "dot", "left"});
            currencyDetails.put("Kuwaiti Dinar", new String[]{"Kuwait", "د.ك", "dot", "left"});
            currencyDetails.put("Libyan Dinar", new String[]{"Libya", "ل.د", "comma", "left"});
            currencyDetails.put("Malaysian Ringgit", new String[]{"Malaysia", "RM", "dot", "left"});
            currencyDetails.put("Mexican Peso", new String[]{"Mexico", "$MXN", "dot", "right"});
            currencyDetails.put("Mauritian Rupee", new String[]{"Mauritius", "Rs", "comma", "left"});
            currencyDetails.put("Nepalese Rupee", new String[]{"Nepal", "₨", "dot", "left"});
            currencyDetails.put("New Zealand Dollar", new String[]{"New Zealand", "NZ$", "dot", "left"});
            currencyDetails.put("Norwegian Krone", new String[]{"Norway", "kr", "dot", "left"});
            currencyDetails.put("Omani Rial", new String[]{"Oman", "﷼", "dot", "left"});
            currencyDetails.put("Philippine Peso", new String[]{"Philippines", "₱", "dot", "right"});
            currencyDetails.put("Pakistani Rupee", new String[]{"Pakistan", "₨", "comma", "left"});
            currencyDetails.put("Polish Zloty", new String[]{"Poland", "zł", "comma", "right"});
            currencyDetails.put("Qatari Riyal", new String[]{"Qatar", "ر.ق", "dot", "left"});
            currencyDetails.put("Romanian New Leu", new String[]{"Romania", "lei", "comma", "right"});
            currencyDetails.put("Russian Ruble", new String[]{"Russia", "₽", "comma", "left"});
            currencyDetails.put("Saudi Arabian Riyal", new String[]{"Saudi Arabia", "ر.س", "dot", "left"});
            currencyDetails.put("Singapore Dollar", new String[]{"Singapore", "S$", "dot", "left"});
            currencyDetails.put("South African Rand", new String[]{"South Africa", "R", "dot", "left"});
            currencyDetails.put("South Korean Won", new String[]{"South Korea", "₩", "dot", "left"});
            currencyDetails.put("Sri Lankan Rupee", new String[]{"Sri Lanka", "රු", "comma", "right"});
            currencyDetails.put("Swedish Krona", new String[]{"Sweden", "kr", "dot", "left"});
            currencyDetails.put("Swiss Franc", new String[]{"Switzerland", "CHF", "comma", "left"});
            currencyDetails.put("Taiwan New Dollar", new String[]{"Taiwan", "NT$", "dot", "left"});
            currencyDetails.put("Thai Baht", new String[]{"Thailand", "฿", "comma", "right"});
            currencyDetails.put("Trinidadian Dollar", new String[]{"Trinidad and Tobago", "TT$", "dot", "left"});
            currencyDetails.put("Turkish Lira", new String[]{"Turkey", "₺", "comma", "left"});
            currencyDetails.put("Emirati Dirham", new String[]{"United Arab Emirates", "د.إ", "dot", "left"});
            currencyDetails.put("British Pound", new String[]{"United Kingdom", "£", "comma", "left"});
            currencyDetails.put("Venezuelan Bolivar", new String[]{"Venezuela", "Bs.S", "comma", "right"});

         
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable>tbody>tr");
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());

                // Update the dictionary if the currency exists
                if (currencyDetails.containsKey(currency)) {
                    // Get the existing details
                    String[] details = currencyDetails.get(currency);

                    // Create a new array with updated rates
                    String[] updatedDetails = new String[details.length + 2];
                    System.arraycopy(details, 0, updatedDetails, 0, details.length);
                    updatedDetails[details.length] = rate1.toString(); // Convert Double to String
                    updatedDetails[details.length + 1] = rate2.toString(); // Convert Double to String

                    // Put the updated array back into the map
                    currencyDetails.put(currency, updatedDetails);
                }
            }
            return currencyDetails;
        } 
         catch (IOException ex){
                 s= "fail";
         }
            System.out.printf("%s",s);
            return null;
    }
 
   //----------------------------------------------------------------------------------------------------------------ConvertsTheCurency
 
    public static String[] convertingCurrencyFromTo(double amount, String currencyNameFrom, String currencyNameTo) {
        Map<String, String[]> loadingCurrencyDetails = currency();

        double rate2From = 0;
        double rate1To = 0;
        double rateVenezuela = 0;
        String punctuation = "";
        String position = "";
        String symbol = "";
        String originalAmount = "";

        if (loadingCurrencyDetails.containsKey(currencyNameFrom)) {
            String[] values = loadingCurrencyDetails.get(currencyNameFrom);
            rate2From = Double.parseDouble(values[5]);
            rateVenezuela = Double.parseDouble(values[4]);
            String punctuationFrom = values[2];
            String positionFrom = values[3];
            String symbolFrom = values[1];
            String resultStr = String.format("%,.2f", amount);

            
            if ("dot".equals(punctuationFrom)) {
                resultStr = resultStr.replace(".", ",").replace(",", ".");
                String reversed = new StringBuilder(resultStr).reverse().toString();
                reversed = reversed.replaceFirst("\\.", ",");
                resultStr = new StringBuilder(reversed).reverse().toString();
                }

          
            if ("left".equals(positionFrom)) {
                originalAmount = symbolFrom + resultStr;
               
            } 
            if ("right".equals(positionFrom)) {
                originalAmount = resultStr + symbolFrom;
                
            }

        }
        if (loadingCurrencyDetails.containsKey(currencyNameTo)) {
            String[] values = loadingCurrencyDetails.get(currencyNameTo);
            rate1To = Double.parseDouble(values[4]);
            double secondRate = Double.parseDouble(values[5]);
            punctuation = values[2];
            position = values[3];
            symbol = values[1];

        }
                    
        if (currencyNameFrom.equals(currencyNameTo)) {
            return new String[]{originalAmount, originalAmount} ;
        }
        if(currencyNameFrom.equals("Venezuelan Bolivar")){
 
            double result = (amount / rateVenezuela) * rate1To;

            String resultStr = String.format("%,.2f", result);
            if ("dot".equals(punctuation)) {
                resultStr = resultStr.replace(".", ",").replace(",", ".");
                String reversed = new StringBuilder(resultStr).reverse().toString();
                reversed = reversed.replaceFirst("\\.", ",");
                resultStr = new StringBuilder(reversed).reverse().toString();
            }
            if ("left".equals(position)) {
                resultStr = symbol + resultStr;
            } else if ("right".equals(position)) {
                resultStr = resultStr + symbol;
            }
            return new String[]{originalAmount, resultStr};
        }
        else{
            double result = (amount * rate2From) * rate1To;

            String resultStr = String.format("%,.2f", result);
            if ("dot".equals(punctuation)) {
                resultStr = resultStr.replace(".", ",").replace(",", ".");
                String reversed = new StringBuilder(resultStr).reverse().toString();
                reversed = reversed.replaceFirst("\\.", ",");
                resultStr = new StringBuilder(reversed).reverse().toString();
            }
            if ("left".equals(position)) {
                resultStr = symbol + resultStr;
            } else if ("right".equals(position)) {
                resultStr = resultStr + symbol;
            }
            return new String[]{originalAmount, resultStr};
        }
    }
    //------------------------------------------------------------------------------------------LoadALlTheCurrency
     public static String currencyLoader() {
        Map<String, String[]> loadCurrenty = currency();
        StringBuilder fromandToSelection = new StringBuilder();

        // Sort the entries by country name
        List<Map.Entry<String, String[]>> sortedEntries = new ArrayList<>(loadCurrenty.entrySet());
        List<String[]> euroDuplicates = new ArrayList<>();
        euroDuplicates.add(new String[]{"Austria", "€", "comma", "right"});
        euroDuplicates.add(new String[]{"European Union", "€", "comma", "right"});
        euroDuplicates.add(new String[]{"Finland", "€", "comma", "right"});
        euroDuplicates.add(new String[]{"France", "€", "comma", "right"});
        euroDuplicates.add(new String[]{"Germany", "€", "comma", "right"});

        for (String[] euroEntry : euroDuplicates) {
            String countryname = euroEntry[0];
            String symbol = euroEntry[1];
            fromandToSelection.append(countryname).append(":Euro-").append(symbol).append("\n");
        }
        
        sortedEntries.sort(Comparator.comparing(entry -> entry.getValue()[0]));

        // Build the sorted string
        for (Map.Entry<String, String[]> entry : sortedEntries) {
            String countryname = entry.getValue()[0];
            String currencyName = entry.getKey();
            String symbol = entry.getValue()[1];
            fromandToSelection.append(countryname).append(":").append(currencyName).append("-").append(symbol).append("\n");
        }
        


        return fromandToSelection.toString();
    }
    //-------------------------------------------------------------------------PopulatingLabelsCurrencyCalculator
    public static String[] currencySelectedFrom(String currencyNameFrom) {
        Map<String, String[]> loadCurrency = currency();
        String positionFrom = "";
        String symbolFrom = "";

        if (loadCurrency.containsKey(currencyNameFrom)) {
            String[] values = loadCurrency.get(currencyNameFrom);
            positionFrom = values[3];
            symbolFrom = values[1];
        }

        return new String[]{positionFrom, symbolFrom};
        
        
  
    }
    
    //----------------------------------------------------------------------------------------------------Math Calculator Pedro
    
     public static void loadMessages(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                messages.add(line.trim());
            }
        }
    }

    // Perform calculation or generate random responses
    public static String funCalculator(String firstInput, String secondInput, String operator) {
        // Check if inputs contain letters
        if (!isNumeric(firstInput) || !isNumeric(secondInput)) {
            
            return getRandomResponse(); // Return random message or number
        }

        try {
            // Parse inputs as numbers
            double num1 = Double.parseDouble(firstInput);
            double num2 = Double.parseDouble(secondInput);

            // Perform calculation
            double result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num2 != 0 ? num1 / num2 : Double.POSITIVE_INFINITY;
                    break;
                default:
                    return "Invalid operator.";
            }

            // Randomly decide between a message or a result
            if (randomBoolean()) {
                return getRandomMessage();
            } else if (num1 == num2) {
                return "Hooray! Both numbers are the same!";
            } else {
                return "Your result is: " + result+". I got this one right. I am smart.";
            }

        } catch (NumberFormatException e) {
            // If parsing fails (shouldn't happen due to isNumeric check)
            return getRandomResponse();
        }
    }

    // Check if a string is numeric
    private static boolean isNumeric(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

    // Get a random response (message or number)
    private static String getRandomResponse() {
        if (randomBoolean()) {
            // Return a random message
            return getRandomMessage();
        } else {
            // Return a random number
            int randomNumber = ThreadLocalRandom.current().nextInt(1, 101);
            return "Your result is: " + randomNumber + ", maybe!";
        }
    }

    // Generate a random boolean
    private static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    // Get a random message from the loaded list
    private static String getRandomMessage() {
        int index = ThreadLocalRandom.current().nextInt(messages.size());
        return messages.get(index);
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------Jorge
    public static boolean isPositiveNumber(String num){
        try{
            double val = Double.parseDouble(num); // Convert string to a double.
            return val >= 0; // Return true if the value is positive.
        }catch (NumberFormatException e){
            return false; // Return false if the string is not a valid number.
        }
    }
    
    public static boolean isPositiveInteger(String num) {
        try {
            int val = Integer.parseInt(num);
            return val > 0; // Loan term should be strictly positive
        } catch (NumberFormatException e) {
            return false;
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
        private static final int MAX_VALUE = 999_999_999;
        
        public static boolean isValidLoanTerm(String loanTermValue){
            try {
                double loanTerm = Double.parseDouble(loanTermValue.trim()); // Parse as double
                return loanTerm > 0; // Check if it's positive
            } catch (NumberFormatException e) {
                return false; // Return false if not a double
            }
        }
        
        public static double[] calcAutoLoan(String autoPriceStr, String loanTermStr, String interestRateStr,
        String cashIncentivesStr, String downPaymentStr, String tradeInValueStr,
        String amtOwnedTradeInStr, String salesTaxStr, String otherFeesStr){
            
            // Validate loan term as an integer
            if (!isValidLoanTerm(loanTermStr)) {
                System.out.println("Invalid input: Loan term must be a positive number.");
                return new double[]{-1, -1};
            }
            
            StringBuilder msg = new StringBuilder();
            
            // Parse and validate each input
            double autoPrice = parseWithValidation(autoPriceStr, "auto price", msg);
            double loanTerm = parseWithValidationDouble(loanTermStr, "loan term", msg);
            double interestRate = parseWithValidation(interestRateStr, "interest rate", msg);
            double downPayment = parseWithValidation(downPaymentStr, "down payment", msg);
            double tradeInValue = parseWithValidation(tradeInValueStr, "trade-in value", msg);
            double cashIncentives = parseWithValidation(cashIncentivesStr, "cash incentives", msg);
            double amtOwnedTradeIn = parseWithValidation(amtOwnedTradeInStr, "amount owed on trade-in", msg);
            double salesTax = parseWithValidation(salesTaxStr, "sales tax", msg);
            double otherFees = parseWithValidation(otherFeesStr, "other fees", msg);
            
            if(downPayment == autoPrice){
                msg.append("Down payment should not be the same as auto price.");
            }
            
            // If any validation errors, print message and return error code
            if (msg.length() > 0) {
                System.out.println(msg);
                return new double[]{-1, -1};
            }
            
            // Proceed with loan calculation
        return calculateAutoLoan(autoPrice, loanTerm, interestRate, downPayment, tradeInValue, 
            cashIncentives, amtOwnedTradeIn, salesTax, otherFees);
        }
        
        // Calculation method
        private static double[] calculateAutoLoan(double autoPrice, double loanTerm, double interestRate, 
                                              double downPayment, double tradeInValue, 
                                              double cashIncentives, double amtOwnedTradeIn, 
                                              double salesTax, double otherFees){
            double autoLoanPayment = autoPrice - downPayment - tradeInValue + amtOwnedTradeIn - cashIncentives;
            double salesTaxAmount = (autoPrice - tradeInValue) * (salesTax / 100);
            double autoLoanPaymentFees = autoLoanPayment + salesTaxAmount + otherFees;
            double monthlyInterestRate = (interestRate / 100) / 12;
            
            // Monthly payments with and without fees
            double paymentWithoutFees = monthlyInterestRate == 0
                    ? autoLoanPayment / loanTerm
                    : (autoLoanPayment * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
            
            double paymentWithFees = monthlyInterestRate == 0
                ? autoLoanPaymentFees / loanTerm
                : (autoLoanPaymentFees * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
            
            // Round results to two decimal places
            paymentWithoutFees = Math.round(paymentWithoutFees * 100) / 100.0;
            paymentWithFees = Math.round(paymentWithFees * 100) / 100.0;
            
            return new double[]{paymentWithoutFees, paymentWithFees};
        }
        
        // Helper method to parse and validate double values
        // Helper method to parse and validate double values
public static double parseWithValidation(String value, String fieldName, StringBuilder msg) {
    try {
        double parsedValue = Double.parseDouble(value);
        if (parsedValue < 0 || !inRange(parsedValue, MAX_VALUE)) {
            msg.append("Invalid ").append(fieldName).append(". Must be positive and within range.\n");
            return -1;
        }
        return parsedValue;
    } catch (NumberFormatException e) {
        msg.append("Invalid input format for ").append(fieldName).append(".\n");
        return -1;
    }
}

        
        // Helper method for loan term as a positive integer
        private static double parseWithValidationDouble(String value, String fieldName, StringBuilder msg){
            try {
        double parsedValue = Double.parseDouble(value);
            if (parsedValue <= 0 || parsedValue > MAX_VALUE) {
                msg.append("Invalid ").append(fieldName).append(". Must be a positive number within range.\n");
                return -1;
            }
            return parsedValue;
        } catch (NumberFormatException e) {
            msg.append("Invalid input format for ").append(fieldName).append(".\n");
            return -1;
    
        }
        }
//-------------------------------------------------------------------------------------------------------------------------------------------------END OF AUTO LOAN
        
//-------------------------------------------------------------------------------------------------------------------------------------------------Start of House Affordability calc (Jorge)
        // Parse value based on whether it's a percentage or fixed amount
 
    public double parseValue(String option, String value, double housePrice) {  
        // Check for null input
        if (option == null || value == null) return 0.0;

        try {  
            // Trim whitespace
            value = value.trim();

            // Check for empty string
            if (value.isEmpty()) return 0.0;  

            // Handle percentage inputs
            if (option.contains("%")) {  
               // Remove % sign and any whitespace
               String cleanValue = value.replace("%", "").trim();
               
               // Validate percentage is not negative and within reasonable bounds
               double percentage = Double.parseDouble(cleanValue);
               if (percentage < 0 || percentage > 100) {
                   System.err.println("Percentage must be between 0 and 100: " + percentage);
                   return 0.0;
               }
               
               return (percentage / 100.0) * housePrice;  
            } 
            // Handle dollar amount inputs
            else {  
               // Remove $ sign, commas, and any whitespace
               String cleanValue = value.replace("$", "").replace(",", "").trim();
               
               // Validate amount is not negative
               double amount = Double.parseDouble(cleanValue);
               if (amount < 0) {
                   System.err.println("Amount cannot be negative: " + amount);
                   return 0.0;
               }
               
               return amount;  
            }  
        } catch (NumberFormatException e) {  
            // More detailed error logging
            System.err.println("Invalid number format: " + e.getMessage() + 
                                " for value: " + value);
            return 0.0;  
        }  
    }
  
    
    public double[] getDtiRatios(String selectedOption) {  
        // Add more comprehensive input validation
        if (selectedOption == null || selectedOption.trim().isEmpty()) {
            throw new IllegalArgumentException("DTI ratio selection cannot be empty");
        }
        
        return switch (selectedOption.trim()) {
            case "Conventional loan (28/36 rule)" -> new double[]{0.28, 0.36};
            case "FHA loan (31% front-end, 43% back-end)" -> new double[]{0.31, 0.43};
            case "VA loan (41%)" -> new double[]{0.41, 0.41};
            case "10%" -> new double[]{0.10, 0.10};  
            case "15%" -> new double[]{0.15, 0.15};  
            case "20%" -> new double[]{0.20, 0.20};  
            case "25%" -> new double[]{0.25, 0.25};  
            case "30%" -> new double[]{0.30, 0.30};  
            case "35%" -> new double[]{0.35, 0.35};  
            case "40%" -> new double[]{0.40, 0.40};
            case "45%" -> new double[]{0.45,0.45};
            case "50%" -> new double[]{0.50,0.50};
            default -> throw new IllegalArgumentException("Invalid DTI ratio selection: " + selectedOption);  
        };  
    }
  
    
    public double calculateMonthlyMortgage(double principal, double annualRate, int years) {  
        // Validate inputs
        if (principal < 0) {
            throw new IllegalArgumentException("Principal amount cannot be negative");
        }
        if (annualRate < 0 || annualRate > 30) {
            throw new IllegalArgumentException("Interest rate must be between 0% and 30%");
        }
        if (years <= 0 || years > 50) {
            throw new IllegalArgumentException("Loan term must be between 1 and 50 years");
        }
        
        double monthlyRate = annualRate / 1200.0;
        int months = years * 12;
        return principal * monthlyRate * Math.pow(1 + monthlyRate, months)
            / (Math.pow(1 + monthlyRate, months) - 1);  
    }

    
    public String calculateHouseAffordability(  
            double annualIncome, double loanTerm, double interestRate,  
            String hoaOption, String hoaValue,  
            String insuranceOption, String insuranceValue,  
            String propertyTaxOption, String propertyTaxValue,  
            String downPaymentOption, String downPaymentValue,  
            String dtiRule) {  
        
        // Comprehensive input validation
        validateInputs(annualIncome, loanTerm, interestRate, dtiRule);

        double monthlyIncome = annualIncome / 12.0;
        double frontEndRatio = getDtiRatios(dtiRule)[0];
        double maxMonthlyPayment = monthlyIncome * frontEndRatio;  

        // Initial house price estimation  
        double housePrice = annualIncome * 4;  
        double previousHousePrice;  
        int iterations = 0;
        
        do {  
            previousHousePrice = housePrice;  
  
            // Calculate monthly expenses  
            double monthlyPropertyTax = parseValue(propertyTaxOption, propertyTaxValue, housePrice) / 12.0;  
            double monthlyHOA = parseValue(hoaOption, hoaValue, housePrice) / 12.0;  
            double monthlyInsurance = parseValue(insuranceOption, insuranceValue, housePrice) / 12.0;  
            double monthlyExpenses = monthlyPropertyTax + monthlyHOA + monthlyInsurance;  
  
            // Available for P&I  
            double availableForPI = maxMonthlyPayment - monthlyExpenses;  
  
            if (availableForPI <= 0) {  
               return "Your monthly expenses exceed your affordability.";  
            }  
  
            // Calculate down payment  
            double downPayment = calculateDownPayment(downPaymentOption, downPaymentValue, housePrice);  
  
            // Calculate required loan amount  
            double loanAmount = previousHousePrice - downPayment;  
  
            // Calculate monthly P&I for this loan amount  
            double monthlyPI = calculateMonthlyMortgage(loanAmount, interestRate, (int) loanTerm);  
  
            // Adjust house price based on available payment  
            double adjustmentFactor = availableForPI / monthlyPI;  
            housePrice = previousHousePrice * adjustmentFactor;  
  
            iterations++;  
        } while (Math.abs(housePrice - previousHousePrice) > 1.0 && iterations < 50);  
  
        return formatFinalResult(housePrice, downPaymentOption, downPaymentValue, dtiRule);  
    }

    /**
     * Validates critical input parameters
     * 
     */
    private void validateInputs(double annualIncome, double loanTerm, 
                                 double interestRate, String dtiRule) {
        // Validate annual income
        if (annualIncome <= 0) {
            throw new IllegalArgumentException("Annual income must be a positive number.");
        }
        
        // Validate loan term
        if (loanTerm <= 0 || loanTerm > 50) {
            throw new IllegalArgumentException("Loan term must be between 1 and 50 years.");
        }
        
        // Validate interest rate
        if (interestRate <= 0 || interestRate > 20) {
            throw new IllegalArgumentException("Interest rate must be between 0% and 20%.");
        }
        
        // Validate DTI rule
        if (dtiRule == null || dtiRule.trim().isEmpty()) {
            throw new IllegalArgumentException("DTI rule must be selected.");
        }
    }

    /**
     * Calculates down payment based on option and value
     */
    private double calculateDownPayment(String downPaymentOption, 
                                        String downPaymentValue, 
                                        double housePrice) {
        if (downPaymentOption.contains("$")) {
           return Double.parseDouble(downPaymentValue.replace("$", "").trim());
        } else {
           double downPaymentPercent = Double.parseDouble(downPaymentValue.replace("%", "").trim()) / 100.0;
           return housePrice * downPaymentPercent;
        }
    }

    /**
     * Formats the final result with detailed house affordability information
     */
    private String formatFinalResult(double housePrice, 
                                     String downPaymentOption, 
                                     String downPaymentValue, 
                                     String dtiRule) {
        // Use BigDecimal for precise calculations
        BigDecimal housePriceBD = BigDecimal.valueOf(housePrice);
        
        // Calculate down payment
        double downPayment = calculateDownPayment(downPaymentOption, downPaymentValue, housePrice);
        BigDecimal finalDownPaymentBD = BigDecimal.valueOf(downPayment);
        
        // Calculate loan amount
        BigDecimal finalLoanAmountBD = housePriceBD.subtract(finalDownPaymentBD);
        
        // Round the results to the nearest integer
        int finalHousePrice = housePriceBD.setScale(0, RoundingMode.HALF_UP).intValue();
        int finalLoanAmount = finalLoanAmountBD.setScale(0, RoundingMode.HALF_UP).intValue();
        int finalDownPaymentAmount = finalDownPaymentBD.setScale(0, RoundingMode.HALF_UP).intValue();
        
        // Calculate down payment percentage
        double downPaymentPercentage = (downPayment / housePrice) * 100;
        
        // Format result based on DTI rule
        return formatResultString(finalHousePrice, finalLoanAmount, 
                                  finalDownPaymentAmount, downPaymentOption, 
                                  downPaymentPercentage, dtiRule);
    }

    /**
     * Generates the final formatted result string
     */
    private String formatResultString(int finalHousePrice, 
                                      int finalLoanAmount, 
                                      int finalDownPaymentAmount, 
                                      String downPaymentOption, 
                                      double downPaymentPercentage, 
                                      String dtiRule) {
        String baseResult = String.format(
            "You can afford a house up to $%,d according to the %s, " +
            "within which $%,d is the loan and $%,d is the down payment",
            finalHousePrice, 
            dtiRule.equals("Conventional loan (28/36 rule)") ? "28/36 rule" : dtiRule, 
            finalLoanAmount, 
            finalDownPaymentAmount
        );
        
        // Add down payment percentage if applicable
        if (downPaymentOption.contains("$")) {
            return baseResult + String.format(", which is %.1f%% of the house price", downPaymentPercentage);
        }
        
        return baseResult;
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------End of House Affordability calc (Jorge)
}
