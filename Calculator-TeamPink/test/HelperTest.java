/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

/**
 *
 * @author 154jo
 */
public class HelperTest {
    
    public HelperTest() {
    }

    /**
     * Test of isPositiveNumber method, of class Helper.
     */
    @Test
    public void testIsPositiveNumber() {
        System.out.println("isPositiveNumber - empty string");
        String num = "";
        boolean expResult = false;
        boolean result = Helper.isPositiveNumber(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testIsPositiveNumberValid() {
        System.out.println("isPositiveNumber - valid positive number");
        String num = "10";
        boolean expResult = true;
        boolean result = Helper.isPositiveNumber(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsPositiveNumberZero() {
        System.out.println("isPositiveNumber - zero");
        String num = "0";
        boolean expResult = true;
        boolean result = Helper.isPositiveNumber(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsPositiveNumberNegative() {
        System.out.println("isPositiveNumber - negative number");
        String num = "-5";
        boolean expResult = false;
        boolean result = Helper.isPositiveNumber(num);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsPositiveNumberNonNumeric() {
        System.out.println("isPositiveNumber - non-numeric string");
        String num = "abc";
        boolean expResult = false;
        boolean result = Helper.isPositiveNumber(num);
        assertEquals(expResult, result);
    }

    /**
     * Test of inRange method, of class Helper.
     */
    @Test
    public void testInRangeWithinLimit() {
        System.out.println("inRange - number within range");
        double num = 500.0;
        double max = 1000.0;
        boolean expResult = true;
        boolean result = Helper.inRange(num, max);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testInRangeEqualToMax() {
        System.out.println("inRange - number equal to max");
        double num = 999999999.0;
        double max = 999999999.0;
        boolean expResult = true;
        boolean result = Helper.inRange(num, max);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInRangeExceedsMax() {
        System.out.println("inRange - number exceeds max");
        double num = 1000000000.0;
        double max = 999999999.0;
        boolean expResult = false;
        boolean result = Helper.inRange(num, max);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcMonthlyPayment method, of class Helper.
     */
    @Test
    public void testCalcMonthlyPaymentAllZero() {
        System.out.println("calcMonthlyPayment - all inputs zero");
        String loanAmount = "0.0";
        String annualInterestRate = "0.0";
        String years = "0";
        double expResult = -1;  // Expected -1 due to input validation failure
        double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
        assertEquals(expResult, result, 0.1);
    }
    
    @Test
    public void testCalcMonthlyPaymentNegativeValues() {
        System.out.println("calcMonthlyPayment - negative values");
        String loanAmount = "-5000.0";
        String annualInterestRate = "-2.5";
        String years = "-10";
        double expResult = -1;  // Expected -1 due to input validation failure
        double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
        assertEquals(expResult, result, 0.1);
    }
    
    @Test
    public void testCalcMonthlyPaymentValid() {
        System.out.println("calcMonthlyPayment - valid inputs");
        String loanAmount = "10000.0";
        String annualInterestRate = "5.0";
        String years = "2";
        double expResult = 438.71;
        double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
        assertEquals(expResult, result, 0.1);
    }

@Test
public void testCalcMonthlyPaymentWithEmptyInputs(){
    System.out.println("calcMonthlyPayment - Empty Inputs");
    String loanAmountStr = "";
    String annualInterestRateStr = "";
    String yearsStr = "";
    
    double expResult = -1;
    double result = Helper.calcMonthlyPayment(loanAmountStr, annualInterestRateStr, yearsStr);
    assertEquals(expResult, result, 0.1);
}

@Test
public void testCalcMonthlyPaymentYearsExceedsMax() {
    System.out.println("calcMonthlyPayment - years exceeds max value");
    String loanAmount = "10000.0";
    String annualInterestRate = "5.0";
    String years = "1000000000";  // Years exceeding max value
    double expResult = -1;  // Expected -1 due to input validation failure
    double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
    assertEquals(expResult, result, 0.1);
}

@Test
public void testCalcMonthlyPaymentLoanAmountExceedsMax() {
    System.out.println("calcMonthlyPayment - loan amount exceeds max value");
    String loanAmount = "1000000000";  // Loan amount exceeding max value
    String annualInterestRate = "5.0";
    String years = "5";
    double expResult = -1;  // Expected -1 due to input validation failure
    double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
    assertEquals(expResult, result, 0.1);
}

@Test
public void testCalcMonthlyPaymentInterestRateExceedsMax() {
    System.out.println("calcMonthlyPayment - interest rate exceeds max value");
    String loanAmount = "10000.0";
    String annualInterestRate = "1000000000";  // Interest rate exceeding max value
    String years = "5";
    double expResult = -1;  // Expected -1 due to input validation failure
    double result = Helper.calcMonthlyPayment(loanAmount, annualInterestRate, years);
    assertEquals(expResult, result, 0.1);
}


    /**-----------------------------------------------------------------------------------------------------------------Pedro
     * Test of checkAge method, of class Helper.//-------------------------------Checking age 
     */
    @Test
    public void testCheckAge() {
        System.out.println("checkAge");
        String ageInput = "2";
        Helper.checkAge(ageInput);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

     //---------------------------------------------------------------checking if current age is less than retirement age 
    @Test
    public void testValidateAges() {
        System.out.println("validateAges");
        String currentAgeInput = "35";
        String retirementAgeInput = "65";
        boolean expResult = true;
        boolean result = Helper.validateAges(currentAgeInput, retirementAgeInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        @Test//----------------------------------------------invalid 
    public void testValidateAges2() {
        System.out.println("validateAges");
        String currentAgeInput = "65";
        String retirementAgeInput = "35";
        boolean expResult = false;
        boolean result = Helper.validateAges(currentAgeInput, retirementAgeInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**-----------------------------------------------------------------------------------Checking whole number 
     * Test of isWholeNumber method, of class Helper.
     */
    
    @Test
    public void testIsWholeNumber() {
        System.out.println("isWholeNumber");
        String input = "35";
        boolean expResult = true;
        boolean result = Helper.isWholeNumber(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
       
    @Test//-----------------------------------------------------------invalid
    public void testIsWholeNumber2() {
        System.out.println("isWholeNumber");
        String input = "35.5";
        boolean expResult = false;
        boolean result = Helper.isWholeNumber(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**-------------------------------------------------------------------------------------------------Check input if is number- if is a string false
     * Test of InputValidation method, of class Helper.
     */
     @Test
    public void testInputValidation() {
        System.out.println("InputValidation");
        String input = "7.7";
        boolean expResult = true;
        boolean result = Helper.InputValidation(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //--------------------------------------------------------------invalid
     @Test
    public void testInputValidation2() {
        System.out.println("InputValidation");
        String input = "a";
        boolean expResult = false;
        boolean result = Helper.InputValidation(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testInputValidation3() {
        System.out.println("InputValidation");
        String input = "-3";
        boolean expResult = false;
        boolean result = Helper.InputValidation(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**----------------------------------------------------------------------------------------compounded n 
     * Test of selectionPeriod method, of class Helper.
     */
    @Test
    public void testSelectionPeriod() {
        System.out.println("selectionPeriod");
        String input = "Semiannually";
        int expResult = 2;
        int result = Helper.selectionPeriod(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//-------------------------------------------------------------------------------------------------------------------------------InterestCalculator 
    /**------------------------------------------------------------------------------------effectiveInterest Rate 
     * Test of effectiveInterestRate method, of class Helper.
     */
    @Test
    public void testEffectiveInterestRate() {
        System.out.println("effectiveInterestRate");
        double r = 0.06;
        int n = 2;
        double expResult = .060899999999999954;
        double result = Helper.effectiveInterestRate(r, n);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**-------------------------------------------------------------------------------------------------------------------------------Nominal InterestRate
     * Test of nominalInterestRate method, of class Helper.
     */
    @Test
    public void testNominalInterestRate() {
        System.out.println("nominalInterestRate");
        double ER = 0.0609;
        int a = 1;
        double expResult =0.060899999999999954;
        double result = Helper.nominalInterestRate(ER, a);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of interestRateBegining method, of class Helper.
     */
    @Test
    public void testInterestRateBegining() {
        System.out.println("interestRateBegining");
        double PI = 400;
        double Ca = 10;
        double Cm = 1;
        double r = 0.06;
        int a = 1;
        int n = 2;
        double t = 5;
        double expResult = 667.4600689936799;
        double result = Helper.interestRateBegining(PI, Ca, Cm, r, a, n, t);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of interestrateEND method, of class Helper.
     */
    @Test
    public void testInterestrateEND() {
        System.out.println("interestrateEND");
        double PI = 400;
        double Ca = 10;
        double Cm = 1.0;
        double r = 0.06;
        int a = 1;
        int n = 2;
        double t = 6;
        double expResult = 726.4262923894754;
        double result = Helper.interestrateEND(PI, Ca, Cm, r, a, n, t);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of future_valueEnd method, of class Helper.
     */
    @Test
    public void testFuture_valueEnd() {
        System.out.println("future_valueEnd");
        double PI = 400;
        double Ca = 10;
        double Cm = 1.0;
        double r = 0.06;
        double t = 6;
        double expResult = 729.8577517742107;
        double result = Helper.future_valueEnd(PI, Ca, Cm, r, t);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of future_valueBeginning method, of class Helper.
     */
    @Test
    public void testFuture_valueBeginning() {
        System.out.println("future_valueBeginning");
        double PI = 400;
        double Ca = 10.0;
        double Cm = 1.0;
        double r = 0.06;
        double t = 6;
        double expResult = 734.6243753343743;
        double result = Helper.future_valueBeginning(PI, Ca, Cm, r, t);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of interestRateCalculatorExtraCalculations method, of class Helper.
     */
    @Test
    public void testInterestRateCalculatorExtraCalculations() {
        System.out.println("interestRateCalculatorExtraCalculations");
        double FV_year = 3000.0;
        double PI = 100.0;
        double Ca = 100.0;
        double Cm = 10.0;
        double t = 8.0;
        double[] expResult = {1860.0, 1760.0, 1140.0, 3000.0};
        double[] result = Helper.interestRateCalculatorExtraCalculations(FV_year, PI, Ca, Cm, t);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**------------------------------------------------------------------------------------------ROth IRA
     * Test of calculate_MaximizeContributionNo method, of class Helper.
     */
    @Test
    public void testCalculate_MaximizeContributionNo() {
        System.out.println("calculate_MaximizeContributionNo");
        double PI = 50;
        double Ca = 20.0;
        double r = 0.06;
        int n = 10;
        double expResult =353.1582836747609;
        double result = Helper.calculate_MaximizeContributionNo(PI, Ca, r, n);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculate_MaximizeContributionYes method, of class Helper.
     */
    @Test
    public void testCalculate_MaximizeContributionYes() {
        System.out.println("calculate_MaximizeContributionYes");
        double PI = 50.0;
        double Ca = 7000.0;
        double r = 0.06;
        int C_age = 25;
        int R_age = 35;
        double expResult = 92355.10698149352;
        double result = Helper.calculate_MaximizeContributionYes(PI, Ca, r, C_age, R_age);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of extraCalculationsRothIRACalculatorYES method, of class Helper.
     */
    @Test
    public void testExtraCalculationsRothIRACalculatorYES() {
        System.out.println("extraCalculationsRothIRACalculatorYES");
        double PI = 3455;
        double Ca = 10.0;
        int C_age = 5;
        int R_age = 15;
        double result_2 = 0.0;
        double[] expResult = {3555.0,-3545.0};
        double[] result = Helper.extraCalculationsRothIRACalculatorYES(PI, Ca, C_age, R_age, result_2);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculateAffordableRent method, of class Helper.
     */
    @Test
    public void testCalculateAffordableRent() {
        System.out.println("calculateAffordableRent");
        double income = 000.0;
        double debt = 0.0;
        String option = "";
        long[] expResult = null;
        long[] result = Helper.calculateAffordableRent(income, debt, option);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of downpaymentNOClosingCostandPercent method, of class Helper.
     */
    @Test
    public void testDownpaymentNOClosingCostandPercent() {
        System.out.println("downpaymentNOClosingCostandPercent");
        double UpC = 7000.0;
        double DP = 600.0;
        double rate = 6.0;
        double loanTerm = 25.0;
        double includeClosingCosts = 90.0;
        double[] expResult = {1014.0,-5072.0,-33.0};
        double[] result = Helper.downpaymentNOClosingCostandPercent(UpC, DP, rate, loanTerm, includeClosingCosts);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of downpaymentYesClosingCostandMoney method, of class Helper.
     */
    @Test
    public void testDownpaymentYesClosingCostandMoney() {
        System.out.println("downpaymentYesClosingCostandMoney");
        double UpC = 22220.0;
        double DP = 20.0;
        double rate = 2.0;
        double loanTerm = 20.0;
        double includeClosingCosts = 0.0;
        double[] expResult = {111100.0,88880,450};
        double[] result = Helper.downpaymentYesClosingCostandMoney(UpC, DP, rate, loanTerm, includeClosingCosts);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of validateInput method, of class Helper.
     */
    @Test
    public void testValidateInput() {
        System.out.println("validateInput");
        double input = 0.0;
        double hp = 0.0;
        String checker = "";
        boolean expResult = false;
        boolean result = Helper.validateInput(input, hp, checker);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mortgageCalculator method, of class Helper.
     */
    @Test
    public void testMortgageCalculator() {
        System.out.println("mortgageCalculator");
        double hp = 566.0;
        double dp = 79.0;
        int loanTerm = 6;
        double rate = 8.0;
        int startDate = 2024;
        double pt = 0.0;
        double hI = 0.0;
        double hf = 0.0;
        double oc = 0.0;
        double[] expResult = {487.0, 8.54, 0.0, 0.0, 0.0, 0.0, 614.79, 127.79, 2030, 8.54};
        double[] result = Helper.mortgageCalculator(hp, dp, loanTerm, rate, startDate, pt, hI, hf, oc);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mortgagePayoffCalculator method, of class Helper.
     */
    @Test
    public void testMortgagePayoffCalculator() {
        System.out.println("mortgagePayoffCalculator");
        double ola = 4000;
        int olt = 50;
        double r = 155;
        int rt =6;
        int m = 0;
        double[] expResult = {276799.36,272799.36,516.67,310000.0,306000.0,37200.0,33200.64,3999.36};
        double[] result = Helper.mortgagePayoffCalculator(ola, olt, r, rt, m);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of effectiveInterestRateRetirement method, of class Helper.
     */
    @Test
    public void testEffectiveInterestRateRetirement() {
        System.out.println("effectiveInterestRateRetirement");
        double m =12.0;
        double r = 6.0;
        double expResult = 0.05841060678411658;
        double result = Helper.effectiveInterestRateRetirement(m, r);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of averageReturnInvestment method, of class Helper.
     */
    @Test
    public void testAverageReturnInvestment() {
        System.out.println("averageReturnInvestment");
        double incomeNeededAfterRetirement = 2800;
        double m = 3;
        double returnInvestmentRate = 6.0;
        double n = 78.0;
        double expResult = 47082.51075733197;
        double result = Helper.averageReturnInvestment(incomeNeededAfterRetirement, m, returnInvestmentRate, n);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of yearlyContribution method, of class Helper.
     */
    @Test
    public void testYearlyContribution() {
        System.out.println("yearlyContribution");
        double result_2 = 30000;
        double n = 8.0;
        double r =6.0;
        double expResult = 3031.078279443869;
        double result = Helper.yearlyContribution(result_2, n, r);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }//

    /**
     * Test of retirementCalculator method, of class Helper.
     */
    @Test
    public void testRetirementCalculator() {
        System.out.println("retirementCalculator");
        int cAge =12;
        int rAge =40;
        int lifeExpectancy = 68;
        double preTaxIncome = 70000.0;
        double incomeNeededAfterRetirement = 8000.0;
        double returnInvestmentRate = 6.0;
        double currentIncomeSaving = 10.0;
        double[] expResult = {110167.64,133.91,1606.88,2.3,51.12};
        double[] result = Helper.retirementCalculator(cAge, rAge, lifeExpectancy, preTaxIncome, incomeNeededAfterRetirement, returnInvestmentRate, currentIncomeSaving);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fixedRetirementCalculator method, of class Helper.
     */
    @Test
    public void testFixedRetirementCalculator() {
        System.out.println("fixedRetirementCalculator");
        int cAge = 12;
        int rAge = 40;
        int lifeExpectancy = 68;
        double preTaxIncome = 70000.0;
        double incomeNeededAfterRetirement =1000.0;
        double currentIncomeSaving = 0.0;
        double[] expResult = {28000.0,83.33,83.33,1000.0,1.43};
        double[] result = Helper.fixedRetirementCalculator(cAge, rAge, lifeExpectancy, preTaxIncome, incomeNeededAfterRetirement, currentIncomeSaving);
        assertArrayEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isPositiveInteger method, of class Helper.
     */
    @Test
    public void testIsPositiveInteger() {
        System.out.println("isPositiveInteger");
        String num = "";
        boolean expResult = false;
        boolean result = Helper.isPositiveInteger(num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inRange method, of class Helper.
     */
    @Test
    public void testInRange() {
        System.out.println("inRange");
        double num = 0.0;
        double max = 0.0;
        boolean expResult = true;
        boolean result = Helper.inRange(num, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmptyInput method, of class Helper.
     */
    @Test
    public void testIsEmptyInput() {
        System.out.println("isEmptyInput");
        String input = "";
        boolean expResult = true;
        boolean result = Helper.isEmptyInput(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calcMonthlyPayment method, of class Helper.
     */
    @Test
    public void testCalcMonthlyPayment() {
        System.out.println("calcMonthlyPayment");
        String loanAmountStr = "";
        String annualInterestRateStr = "";
        String yearsStr = "";
        double expResult = -1.0;
        double result = Helper.calcMonthlyPayment(loanAmountStr, annualInterestRateStr, yearsStr);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of computeMonthlyPayment method, of class Helper.
     */
    @Test
    public void testComputeMonthlyPayment() {
        System.out.println("computeMonthlyPayment");
        double loanAmount = 1200.0;
        double annualInterestRate = 6.0;
        int years =8;
        double expResult = 15.76971625216731;
        double result = Helper.computeMonthlyPayment(loanAmount, annualInterestRate, years);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



}
