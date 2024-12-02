/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pedro
 */
import java.awt.Component;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.Image;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.text.NumberFormat;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultComboBoxModel;
import java.util.Map;
import java.util.Dictionary;
import java.util.Hashtable;
import java.io.BufferedReader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

import java.io.*;


public class Main extends javax.swing.JFrame {
   private Clip backgroundMusic;

    

    private void playBackgroundMusic() {
        try {
            // Use getResourceAsStream to load from classpath
            InputStream audioSrc = getClass().getResourceAsStream("/Music/Pink Panther.wav");
            
            if (audioSrc == null) {
                System.err.println("Audio file not found!");
                return;
            }
            
            // Wrap in BufferedInputStream for better performance
            InputStream bufferedAudio = new BufferedInputStream(audioSrc);
            
            // Load the audio input stream
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(bufferedAudio);
            
            // Create a music clip
            backgroundMusic = AudioSystem.getClip();
            backgroundMusic.open(audioInput);
            
            // Optional: Set volume
            FloatControl gainControl = 
                (FloatControl) backgroundMusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f); // Reduce volume by 20 decibels
            
            // Ensure continuous looping
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            // Important: Handle potential errors gracefully
            System.err.println("Error playing background music: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Method to stop music if needed
    private void stopBackgroundMusic() {
        if (backgroundMusic != null && backgroundMusic.isRunning()) {
            backgroundMusic.stop();
            backgroundMusic.close();
        }
    }

    // Optional: Method to toggle music on/off
    private void toggleBackgroundMusic() {
        if (backgroundMusic != null) {
            if (backgroundMusic.isRunning()) {
                stopBackgroundMusic();
            } else {
                playBackgroundMusic();
            }
        }
    }

    // You might want to add a cleanup method
    @Override
    public void dispose() {
        stopBackgroundMusic();
        super.dispose();
    }

    
    

    /**
     * Creates new form Main
     */
    private HashMap<String, Component> storedTabs = new HashMap<>(); // To store removed tabs
    private int currentIndex = 0;
    String messageMathCalculator ="";
    private int currentIndexLabel3 = 0;
    private String RothIRAAnualContributionSpace = "";
    
    private String decimalSeparator;
    private String currencySymbol2;
    private Map<String, String> decimalSeparatorMap = new HashMap<>();
    private Map<String, CurrencyInfo> currencyMap = new HashMap<>();
    private Map<String, CurrencyInfo> currencyDataMap = new HashMap<>();
    

 

    public Main() {
        initComponents();
        playBackgroundMusic();
        populateComboBoxes();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(DISTANCES));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(PREDEFINED_DISTANCES));
                
        this.setMinimumSize(new Dimension(1400, 350)); 
  
        //--------------------------------------------------------------------------------------------------------------------
         // Set the icon
        CalculatorNameLBL.setText("Welcome...");
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/logo.jpg"));
        setIconImage(icon);
        //------------------------------------------------------------------------------------------------------------

        //set image for header
         pinkIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Images/logo.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
         
         
         //Set image to dashborar
         
         azusena.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Images/logo.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
         jorge.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Images/Inspector.png")).getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH)));
         pedro.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Images/BigNose.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
         osvaldo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Images/BlueAardvark.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
         
         pinkPanterCbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/gifgit.gif")));

         
        

        
        //-------------------------------------------------------------------------------------------------------------------
        //making the panels invisible
         removeAllTabs();
         //Restoring dashboar
         restoreTab("+");
         
         //start animation
         startAnimation(); // Call the method to start the animation.
        FCcontrolBtn.setVisible(false);
        
    
        
        
        //displaying Message Instruction for Currency Calculator
        setMessage1();
        //displaying message Instruction for Auto Loan Calculator
        setMessage2();
        setMessage3();
        
        //displaying message Interest Rate Calculator
        setMessage4();
        
        //display message Retirement Calculator
        setMessage5();
        
        //display message Roth IRA Calculator
        setMessage6();
        
        //display message Morgage Payoff Calculator
        setMessage7();
        
        //display message morgage calculator
        setMessage8();
         
        //display message House affordability calculator
        setMessage9();
        
        //display message rent calculator
        setMessage10();
        
        //display message refinance calculator
        setMessage11();
        
        //display message down payment calculator
        setMessage12();
        
        //display message rent and buy calculator
        setMessage13();
        
        setMessage14();
        //----------------------------------------------------------------Interest Rate Calculator fileds 
        interestRateFields();
        //---------------------------------------------------------------Rent Calculator
        RentMonthlyDebt.setText("0");
       //--------------------settingOPtionalMortgageFields Visible=false Hide Components for MorgageCalculator
       hideComponentsMortgageCalculator();
        
        //-----------------------------------Hide components forROTHIRA
        hideComponents();
        RothIRAAnualContribution.setText("0");
        RothIRAMaximizeNO.setSelected(true);
        //----------------------------------------------MorgageCalculatorFields 
       MortgageCalculatorPropertyTaxes.setText("0");
       MortgageCalculatorHomeInsurance.setText("0");
       MortgageCalculatorHOAFee.setText("0");
       MortgageCalculatorOtherCost.setText("0");
       //------------------------------------------------Mortgage Payoff 
       MortgagePayoffCalculatorNormalPayment.setSelected(true);
       //--------------------------------------------------------Retirement Calculator 
        RetirementCalculatorAverageInvestmentReturn.setText("0");
        RetirementCalculatorOtherIncomeAfterRetirement.setText("0");
        RetirementCalculatorYourCurrentRetirementSavings.setText("0");
        
        //--------------------------------------------------Refinance Calculator
        refinanceCalculatorShowUp();
        
        //-------------------------------------------------currency Calculator 
        populateComboBoxesCurrencyCalculator();
        
        //chasing mouse
       

    }
    
   
    
    //showing about 
    // Method to show the About pop-up using JOptionPane
    public static void showAboutPopup() {
String aboutMessage = "<html>"
        + "<h2><b>This Application</b></h2>"
        + "<p>This application is a suite of calculators designed to help users make informed decisions about <b>mortgages, rent, and more.</b></p>"
        + "<p>Developed by a dedicated team of students from the Software Development class,<b>Team Pink</b>, under the guidance of <b>Dr. Johnson</b>.</p>"
        + "<p>Moreover, we thank <b>Dr. Delozier</b> for her invaluable assistance during the development of the <b>Roth IRA Calculator</b> and <b>Interest Rate Calculator</b>.</p>"
        + ""
        + "<p>We hope you find this tool helpful in your <b>financial planning</b>!</p>"
        + "</html>";


        
        // Display the message in a dialog box
        JOptionPane.showMessageDialog(null, new JLabel(aboutMessage), "About", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Displaying message under cosntruction
    private void startAnimation() {
        // Create a Timer to update the labels at fixed intervals
        messageMathCalculator = "Please enter your numbers, and I'll calculate the answer for you!";
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // If the currentIndex is less than the length of the message, keep adding letters
                if (currentIndex < messageMathCalculator.length()) {
                    String textToShow = messageMathCalculator.substring(0, currentIndex + 1);
                    // Update only jLabel46, jLabel39, and jLabel37 with the same text
                    jLabel46.setText(textToShow);
                    jLabel39.setText(textToShow);
                    jLabel37.setText(textToShow);
                    currentIndex++;
                } else {
                    // If the entire message has been displayed, reset currentIndex to start over
                    currentIndex = 0;
                    // Clear these labels before starting again
                    jLabel46.setText("");
                    jLabel39.setText("");
                    jLabel37.setText("");
                }
            }
        }, 0, 100); // 200ms delay between updates

        // Set a static message for jLabel3 (Team Pink, Software Development)
    
        String messageLabel3 = "Team Pink, Software Development";
        Timer timerLabel3 = new Timer();
        timerLabel3.schedule(new TimerTask() {
            @Override
            public void run() {
                // If the currentIndexLabel3 is less than the length of the messageLabel3, keep adding letters
                if (currentIndexLabel3 < messageLabel3.length()) {
                    String textToShowLabel3 = messageLabel3.substring(0, currentIndexLabel3 + 1);
                    // Update jLabel3 with the text
                    jLabel3.setText(textToShowLabel3);
                    currentIndexLabel3++;
                } else {
                    // If the entire message has been displayed, reset currentIndexLabel3 to start over
                    currentIndexLabel3 = 0;
                    // Clear the label before starting again
                    jLabel3.setText("");
                }
            }
        }, 0, 100); 
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //list of functions
    
            //seting every tab invisible 
        public void removeAllTabs() {
            // Loop backwards to avoid indexing issues when removing tabs
            for (int i = Calculators.getTabCount() - 1; i >= 0; i--) {
                // Get the tab title and content before removing it
                String tabTitle = Calculators.getTitleAt(i);
                Component tabContent = Calculators.getComponentAt(i);

                // Store the tab title and content in the map
                storedTabs.put(tabTitle, tabContent);

                // Remove the tab
                Calculators.removeTabAt(i);
            }
            
            jTabbedPane1.remove(jPanel68);
        }
        
                    // Restores a specific tab based on the tab title.

         public void restoreTab(String title) {
             Component tabContent = storedTabs.get(title);
             if (tabContent != null) {
                // System.out.println("Restoring tab: " + title);  // Debugging message
                 Calculators.addTab(title, tabContent);  // Restore the tab
             } else {
                 //System.out.println("Tab content for '" + title + "' not found in storedTabs.");
             }
         }
    

   //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pinkIcon = new javax.swing.JLabel();
        CalculatorNameLBL = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnmathCalculator = new javax.swing.JButton();
        btnfitnessCalculator = new javax.swing.JButton();
        btnOtherCalculators = new javax.swing.JButton();
        dashboard = new javax.swing.JButton();
        btnfinancialCalculator = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FCcontrolBtn = new javax.swing.JPanel();
        MortgageandRealEstateBTN = new javax.swing.JButton();
        OtherCalculatorsBTN1 = new javax.swing.JButton();
        RetirementCalculatorBTN2 = new javax.swing.JButton();
        InvestmentCalculatorBTN3 = new javax.swing.JButton();
        autoCalculatorBTN4 = new javax.swing.JButton();
        pinkPanterCbtn = new javax.swing.JLabel();
        Calculators = new javax.swing.JTabbedPane();
        rentandbuy = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel37 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jTextField56 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        InstructionsRentAndBuyCalculator = new javax.swing.JTextPane();
        MortgageCalculator2 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        MortgageCalculatorOUtput = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        MorgageCalculatorHomePrice = new javax.swing.JTextField();
        MortgageCalculatorLoanTerm = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        MortgateCalculatorYear = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        MortgateCalculatorDownPayment = new javax.swing.JTextField();
        MortgageCalculatorDownPaymentCBox = new javax.swing.JComboBox<>();
        MortgageCalculatorMonthCbox = new javax.swing.JComboBox<>();
        MortgageCalculatorInterestRate = new javax.swing.JTextField();
        MortgageCalculatorIncudeTaxesandMOre = new javax.swing.JCheckBox();
        jPanel41 = new javax.swing.JPanel();
        MortgageCalculatorPropertyTaxesLabel = new javax.swing.JLabel();
        MortgageCalculatorPropertyTaxes = new javax.swing.JTextField();
        MortgageCalculatorHomeInsuranceLabel = new javax.swing.JLabel();
        MortgageCalculatorHomeInsurance = new javax.swing.JTextField();
        MortgageCalculatorHOAFee = new javax.swing.JTextField();
        MortgageCalculatorHoaFeeLabel = new javax.swing.JLabel();
        MortgageCalculatorOtherCostLabel = new javax.swing.JLabel();
        MortgageCalculatorOtherCost = new javax.swing.JTextField();
        MortgageCalculatorPropertyTaxesCbox = new javax.swing.JComboBox<>();
        MortgageCalculatorHomeInsuranceCBox = new javax.swing.JComboBox<>();
        MortgageCalculatorHoaFeeCBox = new javax.swing.JComboBox<>();
        MortgageCalculatorOtherCostCBox = new javax.swing.JComboBox<>();
        MortgateCalculatorCaculateBTN = new javax.swing.JButton();
        MortgateCalculatorClearBTN = new javax.swing.JButton();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        InstructionsMortgageCalculator = new javax.swing.JTextPane();
        retirementCalculator3 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jPanel43 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        RetirementCalculatorCurrentAge = new javax.swing.JTextField();
        RetirementCalculatorPreTaxIncome = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        RetirementCalculatorLifeExpectancy = new javax.swing.JTextField();
        RetirementCalculatorCalculateBTN = new javax.swing.JButton();
        RetirementCalculatorClearBTN = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        RetirementCalculatorRetirementAge = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        RetirementCalculatorAverageInvestmentReturn = new javax.swing.JTextField();
        RetirementCalculatorIncomeNeededAfterRetirement = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        RetirementCalculatorOtherIncomeAfterRetirement = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        RetirementCalculatorYourCurrentRetirementSavings = new javax.swing.JTextField();
        RetirementCalculatorNeededAfterRetirementCbox = new javax.swing.JComboBox<>();
        jLabel120 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        RetirementCalculatorOutput = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        InstructionsRetirementCalculator = new javax.swing.JTextPane();
        HouseAffordabilityCalculator = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        haResultOutput = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        haIncomeInput = new javax.swing.JTextField();
        haDebtInput = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        haPropertyTaxInput = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        haInterestInput = new javax.swing.JTextField();
        haCalcButton = new javax.swing.JButton();
        haClearButton = new javax.swing.JButton();
        jLabel109 = new javax.swing.JLabel();
        haLoanTermInput = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        haInsuranceInput = new javax.swing.JTextField();
        haHOAInput = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        haDownPaymentInput = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        haDownPaymentBox = new javax.swing.JComboBox<>();
        haPropertyTaxBox = new javax.swing.JComboBox<>();
        haHOABox = new javax.swing.JComboBox<>();
        haInsuranceBox = new javax.swing.JComboBox<>();
        haDTIBox = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        InstructionsHouseAffordabilityCalculator = new javax.swing.JTextPane();
        RentCalculator = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        RentComboboxYearandMonth = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        RentPretaxIncome = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        RentMonthlyDebt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        RentCalculateBTN = new javax.swing.JButton();
        RentClearBTN = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        RentOutput = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        InstructionsRentCalculator = new javax.swing.JTextPane();
        RefinanceCalculator = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jPanel25 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        RefinanceCalculatorCurrentLoan = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        RefinanceCalculatorRemainingBalanceLabel = new javax.swing.JLabel();
        RefinanceCalculatorMonthlyPaymentLbl = new javax.swing.JLabel();
        RefinanceCalculatorRemainingBalance = new javax.swing.JTextField();
        RefinanceCalculatorInterestRate = new javax.swing.JTextField();
        RefinanceCalculatorInterestRatelbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        RefinanceCalculatorYearsPayment = new javax.swing.JTextField();
        RefinanceCalculatorMonthsPayment = new javax.swing.JTextField();
        RefinanceCalculatorYearsandMonth = new javax.swing.JLabel();
        RefinanceCalculatorLoanTerm = new javax.swing.JLabel();
        RefinanceCalculatorLoanTermtext = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        RefinanceCalculatorNewLoanTerm = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        RefinancecalculatorInterestRateNewLoan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        RefinanceCalculatorPoints = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        RefinanceCalculatorCostandFees = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        RefinanceCalculatorCashout = new javax.swing.JTextField();
        RefinanceCalculatorCalculateBTN = new javax.swing.JButton();
        RefinanceCalculatorClear = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        RefinanceCalculatorOutput = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        InstructionsRefinanceCalculator = new javax.swing.JTextPane();
        downpaymentCalculator = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        DownPaymentOuput = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        DownPaymentUpfrontCash = new javax.swing.JTextField();
        DownPaymentClosingCOst = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        DownPaymentLoanTerm = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        DownPaymentCalculateBTN = new javax.swing.JButton();
        DownPaymentClearBTN = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        DownPaymentDownPayment = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        DownPaymentInterestRate = new javax.swing.JTextField();
        DownPaymnentCheckboxClosingCost = new javax.swing.JCheckBox();
        DownPaymentComboBox = new javax.swing.JComboBox<>();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        InstructionsDownPaymentCalculator = new javax.swing.JTextPane();
        MortgagePayoffCalculator = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        MortgagepayoffCalculatorOriginalLoanAmount = new javax.swing.JTextField();
        MortgagePayoffCalculateBTN = new javax.swing.JButton();
        MortgagePayOffClearBTN = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        MortgagePayoffOriginalLoanTerm = new javax.swing.JTextField();
        MortgagePayoffPayAlltogether = new javax.swing.JRadioButton();
        MortgagePayoffRepaymentWithExtraPayments = new javax.swing.JRadioButton();
        MorgagePayoffRePayementExtraMonthLabel = new javax.swing.JLabel();
        MortGagePayoffRemainingTerm = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraMonth = new javax.swing.JTextField();
        MorgagePayoffRePayementExtraYear = new javax.swing.JTextField();
        MorgagePayoffRePayementExtraOneTime = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        MorgagePayoffCalculatorInterestRate = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraYearlabel = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraOneTimeLabel = new javax.swing.JLabel();
        MortgagePayoffBiweeklyRepayment = new javax.swing.JRadioButton();
        MortgagePayoffCalculatorNormalPayment = new javax.swing.JRadioButton();
        MorgagePayoffRePayementExtraMonthLabel12 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraYearlabel2 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraOneTimeLabel2 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraMonthLabel13 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraMonthLabel15 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraMonthLabel16 = new javax.swing.JLabel();
        MorgagePayoffRePayementExtraMonthLabel17 = new javax.swing.JLabel();
        MortGagePayoffRemainingTermMonths = new javax.swing.JTextField();
        MorgagePayoffRePayementExtraMonthLabel18 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        MortgagePayoffOutput = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        InstructionsMortgagePayoffCalculator = new javax.swing.JTextPane();
        MathCalculator = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        firstNumber = new javax.swing.JTextField();
        operator = new javax.swing.JComboBox<>();
        secondNumber = new javax.swing.JTextField();
        btnChaseMe = new javax.swing.JButton();
        btnChaseMe1 = new javax.swing.JButton();
        FitnessAndHealthCalculator = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        OtherCalculator = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        Currency = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        CurrencyCalculatorTO = new javax.swing.JComboBox<>();
        CurrencyCalculatorFrom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CurrencyCalculatatorAmount = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CurrencyCalculatorCalculateBTN = new javax.swing.JButton();
        CurrencyCalculatorClear = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        CurrencyCalculatorOuput = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        instructionCurrencyCalculator = new javax.swing.JTextPane();
        InterestRate = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        InterestRateInitialInvestment = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        InterestRateCalculatorCalculateBTN = new javax.swing.JButton();
        InterestRateCalculatorClearBTN = new javax.swing.JButton();
        InterestRateAnnualContribution = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        InterestRateMonthlyContribution = new javax.swing.JTextField();
        InterestRateBeggnning = new javax.swing.JRadioButton();
        InterestRateEnd = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        InterestRateCompoundPeriods = new javax.swing.JComboBox<>();
        jLabel117 = new javax.swing.JLabel();
        InterestRateInterest = new javax.swing.JTextField();
        InterestRateInvestmentLengthYears = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        InterestRateOutput = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        InstructionsRateCalculator = new javax.swing.JTextPane();
        jPanel19 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        azusena = new javax.swing.JLabel();
        osvaldo = new javax.swing.JLabel();
        pedro = new javax.swing.JLabel();
        jorge = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AutoLoan = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel62 = new javax.swing.JPanel();
        jPanel64 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        ALPriceInput = new javax.swing.JTextField();
        ALCashIncentivesInput = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        ALTradeInValueInput = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        ALInterestRateInput = new javax.swing.JTextField();
        ALCalcButton = new javax.swing.JButton();
        ALClearButton = new javax.swing.JButton();
        jLabel145 = new javax.swing.JLabel();
        ALLoanTermInput = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        ALSalesTaxInput = new javax.swing.JTextField();
        ALAmtOwnInput = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        ALDownPaymentInput = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        ALOtherFeesInput = new javax.swing.JTextField();
        ALCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        InstructionsAutoLoanCalculator = new javax.swing.JTextPane();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jTextField62 = new javax.swing.JTextField();
        jTextField115 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jTextField116 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jTextField117 = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jTextField86 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jTextField118 = new javax.swing.JTextField();
        jTextField119 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jTextField120 = new javax.swing.JTextField();
        jComboBox29 = new javax.swing.JComboBox<>();
        jLabel171 = new javax.swing.JLabel();
        jTextField121 = new javax.swing.JTextField();
        jCheckBox6 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        InstructionsAutoLoan2Calculator = new javax.swing.JTextPane();
        jPanel63 = new javax.swing.JPanel();
        ALResultOutput = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        RothIRACalculator = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jPanel46 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        RothIRACalculatorCurrentBalance = new javax.swing.JTextField();
        RothIRACalculateBTN = new javax.swing.JButton();
        RothIRAclearBTN = new javax.swing.JButton();
        LabelAnnualContribution = new javax.swing.JLabel();
        RothIRAAnualContribution = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        RothIRAMaximizeYes = new javax.swing.JRadioButton();
        RothIRAMaximizeNO = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        RothIRACalculatorExpectedReturnRate = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        RothIRACurrentAge = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        RothIRaRetirementAge = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        RothIRAoutput = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        InstructionsRothIRACalculator = new javax.swing.JTextPane();
        paceCalculator = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        gettime = new javax.swing.JTextField();
        getdistance = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        Caculateforpace = new javax.swing.JButton();
        ClearForPacecalc = new javax.swing.JButton();
        jScrollPane26 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        KilometerLabel = new javax.swing.JLabel();
        MileLabel = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        deepThoughts = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel123 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        ekinator2 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel140 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        quitBnt = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 215, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 215, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Team Pink ,  Software Development");

        CalculatorNameLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pinkIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                .addComponent(CalculatorNameLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(CalculatorNameLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(pinkIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 215, 255));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setMaximumSize(new java.awt.Dimension(130, 32767));
        jPanel7.setMinimumSize(new java.awt.Dimension(130, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 0));

        btnmathCalculator.setBackground(new java.awt.Color(179, 246, 179));
        btnmathCalculator.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnmathCalculator.setText("Math Calculators");
        btnmathCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmathCalculatorActionPerformed(evt);
            }
        });

        btnfitnessCalculator.setBackground(new java.awt.Color(179, 246, 179));
        btnfitnessCalculator.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnfitnessCalculator.setText("Fitness & Health Calculators");
        btnfitnessCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfitnessCalculatorActionPerformed(evt);
            }
        });

        btnOtherCalculators.setBackground(new java.awt.Color(179, 246, 179));
        btnOtherCalculators.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOtherCalculators.setText("Other Calculators");
        btnOtherCalculators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherCalculatorsActionPerformed(evt);
            }
        });

        dashboard.setBackground(new java.awt.Color(179, 246, 179));
        dashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dashboard.setText("Dashboard");
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });

        btnfinancialCalculator.setBackground(new java.awt.Color(179, 246, 179));
        btnfinancialCalculator.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnfinancialCalculator.setText("Financial Calculators ");
        btnfinancialCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfinancialCalculatorActionPerformed(evt);
            }
        });

        jLabel1.setText("All rights reserved.");

        jLabel2.setText("© 2024 Team Pink.  ");

        FCcontrolBtn.setBackground(new java.awt.Color(255, 237, 255));

        MortgageandRealEstateBTN.setBackground(new java.awt.Color(204, 255, 204));
        MortgageandRealEstateBTN.setText("Mortgage and Real Estate");
        MortgageandRealEstateBTN.setActionCommand("Currency Calculatro");
        MortgageandRealEstateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgageandRealEstateBTNActionPerformed(evt);
            }
        });

        OtherCalculatorsBTN1.setBackground(new java.awt.Color(204, 255, 204));
        OtherCalculatorsBTN1.setText("Currency");
        OtherCalculatorsBTN1.setActionCommand("Currency Calculatro");
        OtherCalculatorsBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherCalculatorsBTN1ActionPerformed(evt);
            }
        });

        RetirementCalculatorBTN2.setBackground(new java.awt.Color(204, 255, 204));
        RetirementCalculatorBTN2.setText("Retirement");
        RetirementCalculatorBTN2.setActionCommand("Currency Calculatro");
        RetirementCalculatorBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirementCalculatorBTN2ActionPerformed(evt);
            }
        });

        InvestmentCalculatorBTN3.setBackground(new java.awt.Color(204, 255, 204));
        InvestmentCalculatorBTN3.setText("Investment");
        InvestmentCalculatorBTN3.setActionCommand("Currency Calculatro");
        InvestmentCalculatorBTN3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvestmentCalculatorBTN3ActionPerformed(evt);
            }
        });

        autoCalculatorBTN4.setBackground(new java.awt.Color(204, 255, 204));
        autoCalculatorBTN4.setText("Auto");
        autoCalculatorBTN4.setActionCommand("Currency Calculatro");
        autoCalculatorBTN4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoCalculatorBTN4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FCcontrolBtnLayout = new javax.swing.GroupLayout(FCcontrolBtn);
        FCcontrolBtn.setLayout(FCcontrolBtnLayout);
        FCcontrolBtnLayout.setHorizontalGroup(
            FCcontrolBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FCcontrolBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FCcontrolBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FCcontrolBtnLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(FCcontrolBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InvestmentCalculatorBTN3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RetirementCalculatorBTN2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MortgageandRealEstateBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OtherCalculatorsBTN1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(autoCalculatorBTN4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        FCcontrolBtnLayout.setVerticalGroup(
            FCcontrolBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FCcontrolBtnLayout.createSequentialGroup()
                .addComponent(MortgageandRealEstateBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RetirementCalculatorBTN2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvestmentCalculatorBTN3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(autoCalculatorBTN4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OtherCalculatorsBTN1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pinkPanterCbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gifgit.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOtherCalculators, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnfinancialCalculator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnfitnessCalculator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(btnmathCalculator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(FCcontrolBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pinkPanterCbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(dashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfinancialCalculator)
                .addGap(1, 1, 1)
                .addComponent(FCcontrolBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfitnessCalculator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmathCalculator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOtherCalculators)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinkPanterCbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Calculators.setBackground(new java.awt.Color(253, 178, 253));
        Calculators.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));
        Calculators.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Calculators.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Calculators.setAutoscrolls(true);
        Calculators.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Calculators.setDoubleBuffered(true);
        Calculators.setFocusCycleRoot(true);
        Calculators.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Calculators.setOpaque(true);

        rentandbuy.setBackground(new java.awt.Color(255, 237, 255));
        rentandbuy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        rentandbuy.setAutoscrolls(true);
        rentandbuy.setFocusCycleRoot(true);
        rentandbuy.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                rentandbuyAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        rentandbuy.setLayout(new javax.swing.OverlayLayout(rentandbuy));

        jPanel35.setBackground(new java.awt.Color(255, 143, 255));

        jPanel36.setBackground(new java.awt.Color(255, 224, 255));
        jPanel36.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Home Rent");

        jLabel42.setText("Rental Fee Increase");

        jLabel57.setText("Renter's Insurance");

        jLabel58.setText("Security Deposit");

        jLabel59.setText("Upfront Cost");

        jLabel43.setText("Montly Rental Fee");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("Your Information");

        jLabel61.setText("Average Investment Return");

        jLabel62.setText("Marginal Federal Tax Rate");

        jLabel63.setText("Marginal StateTax Rate");

        jLabel64.setText("Tax Filing Status");

        jButton9.setBackground(new java.awt.Color(179, 246, 179));
        jButton9.setText("Calculate");

        jButton10.setBackground(new java.awt.Color(179, 246, 179));
        jButton10.setText("Clear");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married filing jointly", "Married filing separately", "Head of household", "qualified widow" }));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField21)
                        .addContainerGap())
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23)
                        .addContainerGap())
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField22)
                        .addContainerGap())
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField37)
                        .addContainerGap())
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField36)
                        .addContainerGap())
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField38)
                            .addComponent(jTextField39)
                            .addComponent(jTextField41)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBox5, 0, 1, Short.MAX_VALUE))
                        .addGap(11, 11, 11))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField23))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jTextField22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField36))
                .addGap(21, 21, 21)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField41))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPanel37.setBackground(new java.awt.Color(255, 224, 255));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Home Purchace");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Down Payment");

        jLabel65.setText("Interest Rate");

        jLabel66.setText("Loan Term");

        jLabel67.setText("Buying Closing Cost");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Home Price");

        jLabel73.setText("Property Taxes");

        jLabel74.setText("Property Taxes Increase");

        jLabel75.setText("Home Insurance");

        jLabel76.setText("HOA Fee");

        jLabel77.setText("Maintanence Cost");

        jLabel78.setText("Home Value Appreciation");

        jLabel79.setText("Selling Closing Cost");

        jLabel80.setText("Cost/Insurance Increase");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField56, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jTextField55)
                            .addComponent(jTextField54)
                            .addComponent(jTextField53)
                            .addComponent(jTextField52)
                            .addComponent(jTextField51)
                            .addComponent(jTextField50)
                            .addComponent(jTextField49)
                            .addComponent(jTextField42)
                            .addComponent(jTextField43)
                            .addComponent(jTextField35)
                            .addComponent(jTextField44)
                            .addComponent(jTextField24))
                        .addContainerGap())))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jTextField35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jTextField42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jTextField49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextField50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextField51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jTextField52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jTextField53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jTextField54))
                .addGap(2, 2, 2)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField55)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jTextField56))
                .addGap(19, 19, 19))
        );

        jLabel5.setText("Output here");

        InstructionsRentAndBuyCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane13.setViewportView(InstructionsRentAndBuyCalculator);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        rentandbuy.add(jPanel35);

        Calculators.addTab("Rent vs Buy Calculator", rentandbuy);

        MortgageCalculator2.setBackground(new java.awt.Color(255, 143, 255));
        MortgageCalculator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        MortgageCalculator2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MortgageCalculator2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel39.setBackground(new java.awt.Color(255, 143, 255));

        jPanel40.setBackground(new java.awt.Color(255, 224, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));
        jPanel40.setAutoscrolls(true);
        jPanel40.setEnabled(false);

        MortgageCalculatorOUtput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorOUtput.setAutoscrolls(true);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Results");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MortgageCalculatorOUtput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgageCalculatorOUtput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel42.setBackground(new java.awt.Color(255, 224, 255));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setText("Home Purchace");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setText("Down Payment");

        MorgageCalculatorHomePrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgageCalculatorHomePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MorgageCalculatorHomePriceKeyReleased(evt);
            }
        });

        MortgageCalculatorLoanTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorLoanTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorLoanTermKeyReleased(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setText("Loan Term (years)");

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setText("Interest Rate");

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel96.setText("Start Date");

        MortgateCalculatorYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgateCalculatorYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgateCalculatorYearKeyReleased(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setText("Home Price                 $");

        MortgateCalculatorDownPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgateCalculatorDownPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgateCalculatorDownPaymentKeyReleased(evt);
            }
        });

        MortgageCalculatorDownPaymentCBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorDownPaymentCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        MortgageCalculatorMonthCbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorMonthCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        MortgageCalculatorInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorInterestRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorInterestRateKeyReleased(evt);
            }
        });

        MortgageCalculatorIncudeTaxesandMOre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MortgageCalculatorIncudeTaxesandMOre.setText("Include Taxes & Cost Below");
        MortgageCalculatorIncudeTaxesandMOre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgageCalculatorIncudeTaxesandMOreActionPerformed(evt);
            }
        });

        jPanel41.setBackground(new java.awt.Color(255, 224, 255));

        MortgageCalculatorPropertyTaxesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorPropertyTaxesLabel.setText("Property Taxes Increase");

        MortgageCalculatorPropertyTaxes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorPropertyTaxes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorPropertyTaxesKeyReleased(evt);
            }
        });

        MortgageCalculatorHomeInsuranceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHomeInsuranceLabel.setText("Home Insurance");

        MortgageCalculatorHomeInsurance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHomeInsurance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorHomeInsuranceKeyReleased(evt);
            }
        });

        MortgageCalculatorHOAFee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHOAFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorHOAFeeKeyReleased(evt);
            }
        });

        MortgageCalculatorHoaFeeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHoaFeeLabel.setText("HOA Fee");

        MortgageCalculatorOtherCostLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorOtherCostLabel.setText("Other Costs");

        MortgageCalculatorOtherCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorOtherCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgageCalculatorOtherCostKeyReleased(evt);
            }
        });

        MortgageCalculatorPropertyTaxesCbox.setEditable(true);
        MortgageCalculatorPropertyTaxesCbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorPropertyTaxesCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        MortgageCalculatorHomeInsuranceCBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHomeInsuranceCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        MortgageCalculatorHoaFeeCBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorHoaFeeCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        MortgageCalculatorOtherCostCBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgageCalculatorOtherCostCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MortgageCalculatorPropertyTaxesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MortgageCalculatorHomeInsuranceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MortgageCalculatorHoaFeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MortgageCalculatorOtherCostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(MortgageCalculatorOtherCost, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MortgageCalculatorOtherCostCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(MortgageCalculatorPropertyTaxes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MortgageCalculatorPropertyTaxesCbox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(MortgageCalculatorHomeInsurance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MortgageCalculatorHomeInsuranceCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(MortgageCalculatorHOAFee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MortgageCalculatorHoaFeeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgageCalculatorPropertyTaxesLabel)
                    .addComponent(MortgageCalculatorPropertyTaxes)
                    .addComponent(MortgageCalculatorPropertyTaxesCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgageCalculatorHomeInsuranceLabel)
                    .addComponent(MortgageCalculatorHomeInsurance)
                    .addComponent(MortgageCalculatorHomeInsuranceCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgageCalculatorHoaFeeLabel)
                    .addComponent(MortgageCalculatorHOAFee)
                    .addComponent(MortgageCalculatorHoaFeeCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgageCalculatorOtherCostLabel)
                    .addComponent(MortgageCalculatorOtherCost)
                    .addComponent(MortgageCalculatorOtherCostCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        MortgateCalculatorCaculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        MortgateCalculatorCaculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgateCalculatorCaculateBTN.setText("Calculate");
        MortgateCalculatorCaculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgateCalculatorCaculateBTNActionPerformed(evt);
            }
        });

        MortgateCalculatorClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        MortgateCalculatorClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgateCalculatorClearBTN.setText("Clear");
        MortgateCalculatorClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgateCalculatorClearBTNActionPerformed(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setText("Month          Year");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MortgageCalculatorLoanTerm)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(MortgateCalculatorDownPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MortgageCalculatorDownPaymentCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MorgageCalculatorHomePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(MortgageCalculatorMonthCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MortgateCalculatorYear))
                            .addComponent(MortgageCalculatorInterestRate)
                            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                        .addComponent(MortgageCalculatorIncudeTaxesandMOre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MortgateCalculatorCaculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgateCalculatorClearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MorgageCalculatorHomePrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(MortgateCalculatorDownPayment)
                    .addComponent(MortgageCalculatorDownPaymentCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(MortgageCalculatorLoanTerm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(MortgageCalculatorInterestRate))
                .addGap(1, 1, 1)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(MortgageCalculatorMonthCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MortgateCalculatorYear))
                .addGap(0, 0, 0)
                .addComponent(jLabel107)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgageCalculatorIncudeTaxesandMOre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgateCalculatorCaculateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MortgateCalculatorClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );

        InstructionsMortgageCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane8.setViewportView(InstructionsMortgageCalculator);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(153, 153, 153))
        );

        jScrollPane17.setViewportView(jPanel39);

        javax.swing.GroupLayout MortgageCalculator2Layout = new javax.swing.GroupLayout(MortgageCalculator2);
        MortgageCalculator2.setLayout(MortgageCalculator2Layout);
        MortgageCalculator2Layout.setHorizontalGroup(
            MortgageCalculator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        MortgageCalculator2Layout.setVerticalGroup(
            MortgageCalculator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17)
        );

        Calculators.addTab("Mortgage Calculator", MortgageCalculator2);

        retirementCalculator3.setBackground(new java.awt.Color(255, 143, 255));
        retirementCalculator3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        retirementCalculator3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                retirementCalculator3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel43.setBackground(new java.awt.Color(255, 143, 255));

        jPanel45.setBackground(new java.awt.Color(255, 224, 255));
        jPanel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setText("Your life expentency");

        RetirementCalculatorCurrentAge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorCurrentAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorCurrentAgeKeyReleased(evt);
            }
        });

        RetirementCalculatorPreTaxIncome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorPreTaxIncome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorPreTaxIncomeKeyReleased(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setText("Your current pre-tax income $");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel97.setText("Assumptions");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel68.setText("Your Current Age");

        RetirementCalculatorLifeExpectancy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorLifeExpectancy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorLifeExpectancyKeyReleased(evt);
            }
        });

        RetirementCalculatorCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        RetirementCalculatorCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorCalculateBTN.setText("Calculate");
        RetirementCalculatorCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirementCalculatorCalculateBTNActionPerformed(evt);
            }
        });

        RetirementCalculatorClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        RetirementCalculatorClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorClearBTN.setText("Clear");
        RetirementCalculatorClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirementCalculatorClearBTNActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setText("Your plan retirement age");

        RetirementCalculatorRetirementAge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorRetirementAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorRetirementAgeKeyReleased(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setText("Income Needed after retirement");
        jLabel94.setToolTipText("");

        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel99.setText("Average Investment return");

        RetirementCalculatorAverageInvestmentReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorAverageInvestmentReturn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorAverageInvestmentReturnKeyReleased(evt);
            }
        });

        RetirementCalculatorIncomeNeededAfterRetirement.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorIncomeNeededAfterRetirement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorIncomeNeededAfterRetirementKeyReleased(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel104.setText("Optional");

        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setText("Other income after retirement $");

        RetirementCalculatorOtherIncomeAfterRetirement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorOtherIncomeAfterRetirementKeyReleased(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setText("Your current retirement savings");

        RetirementCalculatorYourCurrentRetirementSavings.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RetirementCalculatorYourCurrentRetirementSavingsKeyReleased(evt);
            }
        });

        RetirementCalculatorNeededAfterRetirementCbox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorNeededAfterRetirementCbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setText("%");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel99, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RetirementCalculatorIncomeNeededAfterRetirement, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(RetirementCalculatorAverageInvestmentReturn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(RetirementCalculatorNeededAfterRetirementCbox, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel45Layout.createSequentialGroup()
                                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel45Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(RetirementCalculatorCalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(RetirementCalculatorClearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel45Layout.createSequentialGroup()
                                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                            .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RetirementCalculatorCurrentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RetirementCalculatorRetirementAge, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RetirementCalculatorLifeExpectancy, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RetirementCalculatorPreTaxIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel45Layout.createSequentialGroup()
                                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(RetirementCalculatorYourCurrentRetirementSavings, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(RetirementCalculatorOtherIncomeAfterRetirement))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(RetirementCalculatorCurrentAge)
                        .addGap(3, 3, 3)
                        .addComponent(RetirementCalculatorRetirementAge, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(RetirementCalculatorLifeExpectancy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RetirementCalculatorPreTaxIncome)
                    .addComponent(jLabel93))
                .addGap(22, 22, 22)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(RetirementCalculatorIncomeNeededAfterRetirement)
                    .addComponent(RetirementCalculatorNeededAfterRetirementCbox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(RetirementCalculatorAverageInvestmentReturn)
                    .addComponent(jLabel120))
                .addGap(28, 28, 28)
                .addComponent(jLabel104)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(RetirementCalculatorOtherIncomeAfterRetirement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(RetirementCalculatorYourCurrentRetirementSavings))
                .addGap(25, 25, 25)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RetirementCalculatorCalculateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RetirementCalculatorClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel44.setBackground(new java.awt.Color(255, 224, 255));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 255), 3, true));
        jPanel44.setAutoscrolls(true);
        jPanel44.setEnabled(false);

        RetirementCalculatorOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RetirementCalculatorOutput.setAutoscrolls(true);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("Results");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RetirementCalculatorOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55)
                .addGap(185, 185, 185))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RetirementCalculatorOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        InstructionsRetirementCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane5.setViewportView(InstructionsRetirementCalculator);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane16.setViewportView(jPanel43);

        javax.swing.GroupLayout retirementCalculator3Layout = new javax.swing.GroupLayout(retirementCalculator3);
        retirementCalculator3.setLayout(retirementCalculator3Layout);
        retirementCalculator3Layout.setHorizontalGroup(
            retirementCalculator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        retirementCalculator3Layout.setVerticalGroup(
            retirementCalculator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(retirementCalculator3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
        );

        Calculators.addTab("Retirement Calculator", retirementCalculator3);

        HouseAffordabilityCalculator.setBackground(new java.awt.Color(255, 143, 255));
        HouseAffordabilityCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        HouseAffordabilityCalculator.setAutoscrolls(true);
        HouseAffordabilityCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HouseAffordabilityCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel49.setBackground(new java.awt.Color(255, 143, 255));

        jPanel50.setBackground(new java.awt.Color(255, 224, 255));
        jPanel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));
        jPanel50.setEnabled(false);

        haResultOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel72.setText("Results");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel72)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(haResultOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(haResultOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel51.setBackground(new java.awt.Color(255, 224, 255));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setText("Interest rate");

        haIncomeInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        haDebtInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel100.setText("Monthly debt payback");

        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel102.setText("Property Tax ");

        haPropertyTaxInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel108.setText("Annual Household Income");

        haInterestInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        haCalcButton.setBackground(new java.awt.Color(179, 246, 179));
        haCalcButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haCalcButton.setText("Calculate");
        haCalcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haCalcButtonActionPerformed(evt);
            }
        });

        haClearButton.setBackground(new java.awt.Color(179, 246, 179));
        haClearButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haClearButton.setText("Clear");
        haClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haClearButtonActionPerformed(evt);
            }
        });

        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel109.setText("Mortgage loan term");

        haLoanTermInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel110.setText("HOA or co-op fee");

        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel111.setText("Insurance ");

        haInsuranceInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        haHOAInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel112.setText("Debt-to-income (DTI) ratio");

        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel101.setText("Down Payment ");

        haDownPaymentInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel113.setText("salary + other income (before tax)");

        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel114.setText("years");

        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setText("long-term debs, car, student loan, etc");

        haDownPaymentBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haDownPaymentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%" }));

        haPropertyTaxBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haPropertyTaxBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "% per year" }));

        haHOABox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haHOABox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "% per year" }));

        haInsuranceBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haInsuranceBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "% per year" }));

        haDTIBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        haDTIBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conventional loan (28/36 rule)", "FHA loan (31% front-end", "43% back-end)", "VA loan (41%)", "10%", "15%", "20%", "25%", "30%", "35%", "40%", "45%", "50%" }));

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(haCalcButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(haClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel100, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel102, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(haDTIBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel51Layout.createSequentialGroup()
                                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel51Layout.createSequentialGroup()
                                        .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(haDebtInput, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(haIncomeInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                            .addComponent(haLoanTermInput, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(haInterestInput, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(haPropertyTaxInput)
                                            .addComponent(haDownPaymentInput, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addComponent(haHOAInput, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(haInsuranceInput))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel51Layout.createSequentialGroup()
                                        .addComponent(haInsuranceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(125, 125, 125))
                                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel51Layout.createSequentialGroup()
                                            .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel51Layout.createSequentialGroup()
                                                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(haDownPaymentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(haPropertyTaxBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(18, 18, 18))
                                        .addGroup(jPanel51Layout.createSequentialGroup()
                                            .addComponent(haHOABox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(haIncomeInput)
                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(haLoanTermInput)
                    .addComponent(jLabel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(haInterestInput))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(haDebtInput)
                    .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(haDownPaymentInput)
                    .addComponent(haDownPaymentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(haPropertyTaxInput)
                    .addComponent(haPropertyTaxBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(haHOAInput)
                    .addComponent(haHOABox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(haInsuranceInput)
                    .addComponent(haInsuranceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(haDTIBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(haCalcButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(haClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InstructionsHouseAffordabilityCalculator.setBackground(new java.awt.Color(255, 224, 255));
        InstructionsHouseAffordabilityCalculator.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        InstructionsHouseAffordabilityCalculator.setDoubleBuffered(true);
        InstructionsHouseAffordabilityCalculator.setDragEnabled(true);
        jScrollPane9.setViewportView(InstructionsHouseAffordabilityCalculator);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );

        jScrollPane18.setViewportView(jPanel49);

        javax.swing.GroupLayout HouseAffordabilityCalculatorLayout = new javax.swing.GroupLayout(HouseAffordabilityCalculator);
        HouseAffordabilityCalculator.setLayout(HouseAffordabilityCalculatorLayout);
        HouseAffordabilityCalculatorLayout.setHorizontalGroup(
            HouseAffordabilityCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        HouseAffordabilityCalculatorLayout.setVerticalGroup(
            HouseAffordabilityCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        Calculators.addTab("House Affordability Calculator", HouseAffordabilityCalculator);

        RentCalculator.setBackground(new java.awt.Color(255, 143, 255));
        RentCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        RentCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                RentCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel26.setBackground(new java.awt.Color(255, 143, 255));

        jPanel27.setBackground(new java.awt.Color(255, 224, 255));
        jPanel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        RentComboboxYearandMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentComboboxYearandMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "per year", "per month" }));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Your pre-tax income");

        RentPretaxIncome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentPretaxIncome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        RentPretaxIncome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RentPretaxIncomeKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Your monthly debt payback");

        RentMonthlyDebt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentMonthlyDebt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RentMonthlyDebtKeyReleased(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("car/student loan, credit cards, etc");

        RentCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        RentCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentCalculateBTN.setText("Calculate ");
        RentCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentCalculateBTNActionPerformed(evt);
            }
        });

        RentClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        RentClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RentClearBTN.setText("Clear");
        RentClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentClearBTNActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("$");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(RentCalculateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RentClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RentPretaxIncome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RentComboboxYearandMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RentMonthlyDebt))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RentComboboxYearandMonth)
                    .addComponent(RentPretaxIncome)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RentMonthlyDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RentCalculateBTN)
                    .addComponent(RentClearBTN))
                .addGap(14, 14, 14))
        );

        jPanel28.setBackground(new java.awt.Color(255, 224, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));

        RentOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setText("Results");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(RentOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addComponent(jLabel81)
                    .addContainerGap(167, Short.MAX_VALUE)))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(RentOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel28Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(189, Short.MAX_VALUE)))
        );

        InstructionsRentCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane10.setViewportView(InstructionsRentCalculator);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(0, 123, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        jScrollPane19.setViewportView(jPanel26);

        javax.swing.GroupLayout RentCalculatorLayout = new javax.swing.GroupLayout(RentCalculator);
        RentCalculator.setLayout(RentCalculatorLayout);
        RentCalculatorLayout.setHorizontalGroup(
            RentCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        RentCalculatorLayout.setVerticalGroup(
            RentCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        Calculators.addTab("Rent Calculator", RentCalculator);

        RefinanceCalculator.setBackground(new java.awt.Color(255, 143, 255));
        RefinanceCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        RefinanceCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                RefinanceCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel25.setBackground(new java.awt.Color(255, 143, 255));
        jPanel25.setAutoscrolls(true);

        jPanel18.setBackground(new java.awt.Color(255, 224, 255));

        RefinanceCalculatorCurrentLoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorCurrentLoan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I know my remaining balance", "I know the orginal loan amount" }));
        RefinanceCalculatorCurrentLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefinanceCalculatorCurrentLoanActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Current Loan");

        RefinanceCalculatorRemainingBalanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorRemainingBalanceLabel.setText("Remaining Balance $");

        RefinanceCalculatorMonthlyPaymentLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorMonthlyPaymentLbl.setText("Monthly Payment $");

        RefinanceCalculatorRemainingBalance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorRemainingBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorRemainingBalanceKeyReleased(evt);
            }
        });

        RefinanceCalculatorInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorInterestRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorInterestRateKeyReleased(evt);
            }
        });

        RefinanceCalculatorInterestRatelbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorInterestRatelbl.setText("Interest Rate %");

        RefinanceCalculatorYearsPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorYearsPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorYearsPaymentKeyReleased(evt);
            }
        });

        RefinanceCalculatorMonthsPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorMonthsPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefinanceCalculatorMonthsPaymentActionPerformed(evt);
            }
        });
        RefinanceCalculatorMonthsPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorMonthsPaymentKeyReleased(evt);
            }
        });

        RefinanceCalculatorYearsandMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorYearsandMonth.setText("years                      months");

        RefinanceCalculatorLoanTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorLoanTerm.setText("Loan term");
        RefinanceCalculatorLoanTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorLoanTermKeyReleased(evt);
            }
        });

        RefinanceCalculatorLoanTermtext.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorLoanTermtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorLoanTermtextKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorRemainingBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorMonthlyPaymentLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorRemainingBalance)
                    .addComponent(RefinanceCalculatorInterestRate)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorCurrentLoan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(RefinanceCalculatorYearsPayment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RefinanceCalculatorMonthsPayment))
                    .addComponent(RefinanceCalculatorInterestRatelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorYearsandMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorLoanTerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RefinanceCalculatorLoanTermtext))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorCurrentLoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefinanceCalculatorRemainingBalanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(RefinanceCalculatorLoanTermtext, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorMonthlyPaymentLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RefinanceCalculatorYearsPayment)
                    .addComponent(RefinanceCalculatorMonthsPayment))
                .addGap(1, 1, 1)
                .addComponent(RefinanceCalculatorYearsandMonth)
                .addGap(29, 29, 29)
                .addComponent(RefinanceCalculatorInterestRatelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorInterestRate)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 224, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("New Loan");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("New Loan Term (Years)");

        RefinanceCalculatorNewLoanTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorNewLoanTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefinanceCalculatorNewLoanTermActionPerformed(evt);
            }
        });
        RefinanceCalculatorNewLoanTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorNewLoanTermKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Interest Rate %");

        RefinancecalculatorInterestRateNewLoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinancecalculatorInterestRateNewLoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinancecalculatorInterestRateNewLoanKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Points");

        RefinanceCalculatorPoints.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorPoints.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorPointsKeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Costs and Fees $");

        RefinanceCalculatorCostandFees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorCostandFees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorCostandFeesKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Cashout Amount $");

        RefinanceCalculatorCashout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorCashout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RefinanceCalculatorCashoutKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RefinanceCalculatorNewLoanTerm, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RefinancecalculatorInterestRateNewLoan))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RefinanceCalculatorCashout, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(RefinanceCalculatorCostandFees, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RefinanceCalculatorPoints, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorNewLoanTerm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(RefinancecalculatorInterestRateNewLoan)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorPoints)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorCostandFees)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefinanceCalculatorCashout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RefinanceCalculatorCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        RefinanceCalculatorCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorCalculateBTN.setText("Calculate");
        RefinanceCalculatorCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefinanceCalculatorCalculateBTNActionPerformed(evt);
            }
        });

        RefinanceCalculatorClear.setBackground(new java.awt.Color(179, 246, 179));
        RefinanceCalculatorClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefinanceCalculatorClear.setText("Clear");
        RefinanceCalculatorClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefinanceCalculatorClearActionPerformed(evt);
            }
        });

        jPanel38.setBackground(new java.awt.Color(255, 224, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));

        RefinanceCalculatorOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel88.setText("Results");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RefinanceCalculatorOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel88)
                .addGap(206, 206, 206))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RefinanceCalculatorOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        InstructionsRefinanceCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane11.setViewportView(InstructionsRefinanceCalculator);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefinanceCalculatorCalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RefinanceCalculatorClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RefinanceCalculatorClear)
                            .addComponent(RefinanceCalculatorCalculateBTN))
                        .addGap(44, 44, 44)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jScrollPane15.setViewportView(jPanel25);

        javax.swing.GroupLayout RefinanceCalculatorLayout = new javax.swing.GroupLayout(RefinanceCalculator);
        RefinanceCalculator.setLayout(RefinanceCalculatorLayout);
        RefinanceCalculatorLayout.setHorizontalGroup(
            RefinanceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RefinanceCalculatorLayout.createSequentialGroup()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        RefinanceCalculatorLayout.setVerticalGroup(
            RefinanceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RefinanceCalculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                .addContainerGap())
        );

        Calculators.addTab("Refinance Calculator", RefinanceCalculator);

        downpaymentCalculator.setBackground(new java.awt.Color(255, 143, 255));
        downpaymentCalculator.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255)));
        downpaymentCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                downpaymentCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel59.setBackground(new java.awt.Color(255, 143, 255));

        jPanel60.setBackground(new java.awt.Color(255, 224, 255));
        jPanel60.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));
        jPanel60.setEnabled(false);

        DownPaymentOuput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel89.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel89.setText("Results");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DownPaymentOuput, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel60Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jLabel89)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel60Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(DownPaymentOuput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel60Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );

        jPanel61.setBackground(new java.awt.Color(255, 224, 255));

        DownPaymentUpfrontCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentUpfrontCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DownPaymentUpfrontCashKeyReleased(evt);
            }
        });

        DownPaymentClosingCOst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentClosingCOst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DownPaymentClosingCOstKeyReleased(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel132.setText("Loan Term");

        DownPaymentLoanTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentLoanTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DownPaymentLoanTermKeyReleased(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel133.setText("Upfront Cahs Available ");

        DownPaymentCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        DownPaymentCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentCalculateBTN.setText("Calculate");
        DownPaymentCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownPaymentCalculateBTNActionPerformed(evt);
            }
        });

        DownPaymentClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        DownPaymentClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentClearBTN.setText("Clear");
        DownPaymentClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownPaymentClearBTNActionPerformed(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setText("Down Payment");

        DownPaymentDownPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentDownPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DownPaymentDownPaymentKeyReleased(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel138.setText("Interest Rate");

        DownPaymentInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentInterestRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DownPaymentInterestRateKeyReleased(evt);
            }
        });

        DownPaymnentCheckboxClosingCost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DownPaymnentCheckboxClosingCost.setText("Include Closing Cost");

        DownPaymentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DownPaymentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "$" }));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel135.setText("%");

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setText("%");

        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel137.setText("years");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel132, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel134, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(DownPaymentLoanTerm)
                                    .addComponent(DownPaymentInterestRate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DownPaymentUpfrontCash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(DownPaymentDownPayment, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel137)
                                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel61Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(DownPaymentCalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(DownPaymentClearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel61Layout.createSequentialGroup()
                        .addComponent(DownPaymnentCheckboxClosingCost, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DownPaymentClosingCOst, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DownPaymentComboBox, 0, 1, Short.MAX_VALUE))))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownPaymentUpfrontCash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownPaymentDownPayment)
                    .addComponent(jLabel136))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DownPaymnentCheckboxClosingCost)
                    .addComponent(DownPaymentClosingCOst)
                    .addComponent(DownPaymentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(DownPaymentInterestRate)
                    .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(DownPaymentLoanTerm)
                    .addComponent(jLabel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DownPaymentCalculateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DownPaymentClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InstructionsDownPaymentCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane12.setViewportView(InstructionsDownPaymentCalculator);

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(318, Short.MAX_VALUE))
        );

        jScrollPane20.setViewportView(jPanel59);

        javax.swing.GroupLayout downpaymentCalculatorLayout = new javax.swing.GroupLayout(downpaymentCalculator);
        downpaymentCalculator.setLayout(downpaymentCalculatorLayout);
        downpaymentCalculatorLayout.setHorizontalGroup(
            downpaymentCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        downpaymentCalculatorLayout.setVerticalGroup(
            downpaymentCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        Calculators.addTab("Down Payment Calculator", downpaymentCalculator);

        MortgagePayoffCalculator.setBackground(new java.awt.Color(255, 237, 255));
        MortgagePayoffCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        MortgagePayoffCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                MortgagePayoffCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel56.setBackground(new java.awt.Color(255, 143, 255));

        jPanel57.setBackground(new java.awt.Color(255, 224, 255));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Original Loan Amount ");

        MortgagepayoffCalculatorOriginalLoanAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgagepayoffCalculatorOriginalLoanAmountKeyReleased(evt);
            }
        });

        MortgagePayoffCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        MortgagePayoffCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffCalculateBTN.setText("Calculate");
        MortgagePayoffCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayoffCalculateBTNActionPerformed(evt);
            }
        });

        MortgagePayOffClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        MortgagePayOffClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayOffClearBTN.setText("Clear");
        MortgagePayOffClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayOffClearBTNActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setText("Original Loan Term");

        MortgagePayoffOriginalLoanTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffOriginalLoanTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortgagePayoffOriginalLoanTermKeyReleased(evt);
            }
        });

        MortgagePayoffPayAlltogether.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffPayAlltogether.setText("Payback Altogether");
        MortgagePayoffPayAlltogether.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayoffPayAlltogetherActionPerformed(evt);
            }
        });

        MortgagePayoffRepaymentWithExtraPayments.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffRepaymentWithExtraPayments.setText("Repayment With Extra Payments");
        MortgagePayoffRepaymentWithExtraPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayoffRepaymentWithExtraPaymentsActionPerformed(evt);
            }
        });

        MorgagePayoffRePayementExtraMonthLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel.setText("per month");

        MortGagePayoffRemainingTerm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortGagePayoffRemainingTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortGagePayoffRemainingTermKeyReleased(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel121.setText("Repayment Options ");

        MorgagePayoffRePayementExtraMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MorgagePayoffRePayementExtraMonthKeyReleased(evt);
            }
        });

        MorgagePayoffRePayementExtraYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MorgagePayoffRePayementExtraYearKeyReleased(evt);
            }
        });

        MorgagePayoffRePayementExtraOneTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraOneTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MorgagePayoffRePayementExtraOneTimeKeyReleased(evt);
            }
        });

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel125.setText("Interest Rate");

        MorgagePayoffCalculatorInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffCalculatorInterestRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MorgagePayoffCalculatorInterestRateKeyReleased(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel126.setText("Remaining Term");

        MorgagePayoffRePayementExtraYearlabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraYearlabel.setText("per year");

        MorgagePayoffRePayementExtraOneTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraOneTimeLabel.setText("one time");

        MortgagePayoffBiweeklyRepayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffBiweeklyRepayment.setText("Biweekly repayment");
        MortgagePayoffBiweeklyRepayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayoffBiweeklyRepaymentActionPerformed(evt);
            }
        });

        MortgagePayoffCalculatorNormalPayment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffCalculatorNormalPayment.setText("Normal Payment");
        MortgagePayoffCalculatorNormalPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MortgagePayoffCalculatorNormalPaymentActionPerformed(evt);
            }
        });

        MorgagePayoffRePayementExtraMonthLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel12.setText("$");

        MorgagePayoffRePayementExtraYearlabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraYearlabel2.setText("$");

        MorgagePayoffRePayementExtraOneTimeLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraOneTimeLabel2.setText("$");

        MorgagePayoffRePayementExtraMonthLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel13.setText("$");

        MorgagePayoffRePayementExtraMonthLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel15.setText("%");

        MorgagePayoffRePayementExtraMonthLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel16.setText("years");

        MorgagePayoffRePayementExtraMonthLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel17.setText("years");

        MortGagePayoffRemainingTermMonths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MortGagePayoffRemainingTermMonthsKeyReleased(evt);
            }
        });

        MorgagePayoffRePayementExtraMonthLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MorgagePayoffRePayementExtraMonthLabel18.setText("months");

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MorgagePayoffRePayementExtraMonthLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MorgagePayoffRePayementExtraMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MorgagePayoffRePayementExtraMonthLabel)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel125, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(MorgagePayoffRePayementExtraMonthLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MorgagePayoffCalculatorInterestRate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MortgagePayoffOriginalLoanTerm, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MortgagepayoffCalculatorOriginalLoanAmount)
                            .addComponent(MortGagePayoffRemainingTerm)
                            .addComponent(MortGagePayoffRemainingTermMonths))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MorgagePayoffRePayementExtraMonthLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MorgagePayoffRePayementExtraMonthLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(MorgagePayoffRePayementExtraMonthLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MorgagePayoffRePayementExtraMonthLabel15))
                        .addContainerGap())
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel121)
                            .addGroup(jPanel57Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MortgagePayoffPayAlltogether, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MortgagePayoffCalculatorNormalPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MortgagePayoffRepaymentWithExtraPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                                        .addComponent(MorgagePayoffRePayementExtraOneTimeLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MorgagePayoffRePayementExtraOneTime, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                                        .addComponent(MorgagePayoffRePayementExtraYearlabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MorgagePayoffRePayementExtraYear, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MorgagePayoffRePayementExtraYearlabel)
                            .addComponent(MorgagePayoffRePayementExtraOneTimeLabel))
                        .addGap(113, 113, 113))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MortgagePayoffBiweeklyRepayment, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MortgagePayoffCalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(MortgagePayOffClearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(MortgagepayoffCalculatorOriginalLoanAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(MortgagePayoffOriginalLoanTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel16))
                .addGap(1, 1, 1)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(MorgagePayoffCalculatorInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel126)
                        .addComponent(MorgagePayoffRePayementExtraMonthLabel17))
                    .addComponent(MortGagePayoffRemainingTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortGagePayoffRemainingTermMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel18))
                .addGap(5, 5, 5)
                .addComponent(jLabel121)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgagePayoffPayAlltogether)
                .addGap(3, 3, 3)
                .addComponent(MortgagePayoffRepaymentWithExtraPayments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MorgagePayoffRePayementExtraMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel)
                    .addComponent(MorgagePayoffRePayementExtraMonthLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MorgagePayoffRePayementExtraYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MorgagePayoffRePayementExtraYearlabel)
                    .addComponent(MorgagePayoffRePayementExtraYearlabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MorgagePayoffRePayementExtraOneTimeLabel)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MorgagePayoffRePayementExtraOneTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MorgagePayoffRePayementExtraOneTimeLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgagePayoffBiweeklyRepayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MortgagePayoffCalculatorNormalPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MortgagePayoffCalculateBTN)
                    .addComponent(MortgagePayOffClearBTN))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel58.setBackground(new java.awt.Color(255, 224, 255));
        jPanel58.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));
        jPanel58.setAutoscrolls(true);

        MortgagePayoffOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MortgagePayoffOutput.setAutoscrolls(true);

        jLabel90.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel90.setText("Results");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MortgagePayoffOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel58Layout.createSequentialGroup()
                    .addGap(191, 191, 191)
                    .addComponent(jLabel90)
                    .addContainerGap(191, Short.MAX_VALUE)))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(MortgagePayoffOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel58Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );

        InstructionsMortgagePayoffCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane7.setViewportView(InstructionsMortgagePayoffCalculator);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel56Layout.createSequentialGroup()
                        .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 153, Short.MAX_VALUE))
        );

        jScrollPane14.setViewportView(jPanel56);

        javax.swing.GroupLayout MortgagePayoffCalculatorLayout = new javax.swing.GroupLayout(MortgagePayoffCalculator);
        MortgagePayoffCalculator.setLayout(MortgagePayoffCalculatorLayout);
        MortgagePayoffCalculatorLayout.setHorizontalGroup(
            MortgagePayoffCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        MortgagePayoffCalculatorLayout.setVerticalGroup(
            MortgagePayoffCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        Calculators.addTab("Mortgage Payoff Calculator", MortgagePayoffCalculator);

        MathCalculator.setBackground(new java.awt.Color(255, 237, 255));
        MathCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pinkPanterUnderConstruction.gif"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Please enter your numbers, and I'll calculate the answer for you!");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Experience the power of our advanced math calculator!");

        firstNumber.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        operator.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        operator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+", "-", "*", "/" }));

        secondNumber.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        btnChaseMe.setBackground(new java.awt.Color(179, 246, 179));
        btnChaseMe.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnChaseMe.setText("Calculate");
        btnChaseMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChaseMeActionPerformed(evt);
            }
        });

        btnChaseMe1.setBackground(new java.awt.Color(179, 246, 179));
        btnChaseMe1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnChaseMe1.setText("Clear");
        btnChaseMe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChaseMe1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MathCalculatorLayout = new javax.swing.GroupLayout(MathCalculator);
        MathCalculator.setLayout(MathCalculatorLayout);
        MathCalculatorLayout.setHorizontalGroup(
            MathCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MathCalculatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MathCalculatorLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MathCalculatorLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(operator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChaseMe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChaseMe1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MathCalculatorLayout.setVerticalGroup(
            MathCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MathCalculatorLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(MathCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operator, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChaseMe)
                    .addComponent(btnChaseMe1))
                .addGap(91, 91, 91)
                .addGroup(MathCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        Calculators.addTab("Math Calculator", MathCalculator);

        FitnessAndHealthCalculator.setBackground(new java.awt.Color(255, 237, 255));
        FitnessAndHealthCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pinkPanterUnderConstruction.gif"))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Under Construction");

        javax.swing.GroupLayout FitnessAndHealthCalculatorLayout = new javax.swing.GroupLayout(FitnessAndHealthCalculator);
        FitnessAndHealthCalculator.setLayout(FitnessAndHealthCalculatorLayout);
        FitnessAndHealthCalculatorLayout.setHorizontalGroup(
            FitnessAndHealthCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FitnessAndHealthCalculatorLayout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        FitnessAndHealthCalculatorLayout.setVerticalGroup(
            FitnessAndHealthCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FitnessAndHealthCalculatorLayout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addGroup(FitnessAndHealthCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        Calculators.addTab("Fitness & Health Calculator", FitnessAndHealthCalculator);

        OtherCalculator.setBackground(new java.awt.Color(255, 237, 255));
        OtherCalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setText("Under Construction");

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pinkPanterUnderConstruction.gif"))); // NOI18N

        javax.swing.GroupLayout OtherCalculatorLayout = new javax.swing.GroupLayout(OtherCalculator);
        OtherCalculator.setLayout(OtherCalculatorLayout);
        OtherCalculatorLayout.setHorizontalGroup(
            OtherCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OtherCalculatorLayout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        OtherCalculatorLayout.setVerticalGroup(
            OtherCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OtherCalculatorLayout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addGroup(OtherCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        Calculators.addTab("Other Calculators", OtherCalculator);

        Currency.setBackground(new java.awt.Color(255, 143, 255));
        Currency.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));

        jPanel29.setBackground(new java.awt.Color(255, 143, 255));

        jPanel30.setBackground(new java.awt.Color(255, 224, 255));

        CurrencyCalculatorTO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        CurrencyCalculatorFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CurrencyCalculatorFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencyCalculatorFromActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Amount");

        CurrencyCalculatatorAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CurrencyCalculatatorAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CurrencyCalculatatorAmountKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("From");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("To");

        CurrencyCalculatorCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        CurrencyCalculatorCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CurrencyCalculatorCalculateBTN.setText("Calculate");
        CurrencyCalculatorCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencyCalculatorCalculateBTNActionPerformed(evt);
            }
        });

        CurrencyCalculatorClear.setBackground(new java.awt.Color(179, 246, 179));
        CurrencyCalculatorClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CurrencyCalculatorClear.setText("Clear");
        CurrencyCalculatorClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencyCalculatorClearActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrencyCalculatatorAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addComponent(CurrencyCalculatorTO, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CurrencyCalculatorFrom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                        .addComponent(CurrencyCalculatorCalculateBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CurrencyCalculatorClear, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CurrencyCalculatatorAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(CurrencyCalculatorFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addComponent(CurrencyCalculatorTO, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CurrencyCalculatorCalculateBTN)
                    .addComponent(CurrencyCalculatorClear))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel31.setBackground(new java.awt.Color(255, 224, 255));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 255), 3, true));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel91.setText("Results");

        CurrencyCalculatorOuput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(CurrencyCalculatorOuput, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(167, 167, 167))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel91)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CurrencyCalculatorOuput, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
                .addContainerGap())
        );

        instructionCurrencyCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane2.setViewportView(instructionCurrencyCalculator);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349))))
        );

        jScrollPane21.setViewportView(jPanel29);

        javax.swing.GroupLayout CurrencyLayout = new javax.swing.GroupLayout(Currency);
        Currency.setLayout(CurrencyLayout);
        CurrencyLayout.setHorizontalGroup(
            CurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        CurrencyLayout.setVerticalGroup(
            CurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );

        Calculators.addTab("Currency Calculator", Currency);

        InterestRate.setBackground(new java.awt.Color(255, 143, 255));
        InterestRate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));

        jPanel32.setBackground(new java.awt.Color(255, 143, 255));

        jPanel33.setBackground(new java.awt.Color(255, 224, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Initial Investment         $");

        InterestRateInitialInvestment.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateInitialInvestment.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InterestRateInitialInvestment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InterestRateInitialInvestmentKeyReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Annual Contribution    $");

        InterestRateCalculatorCalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        InterestRateCalculatorCalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateCalculatorCalculateBTN.setText("Calculate ");
        InterestRateCalculatorCalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterestRateCalculatorCalculateBTNActionPerformed(evt);
            }
        });

        InterestRateCalculatorClearBTN.setBackground(new java.awt.Color(179, 246, 179));
        InterestRateCalculatorClearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateCalculatorClearBTN.setText("Clear");
        InterestRateCalculatorClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterestRateCalculatorClearBTNActionPerformed(evt);
            }
        });

        InterestRateAnnualContribution.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateAnnualContribution.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InterestRateAnnualContribution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InterestRateAnnualContributionKeyReleased(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel116.setText("Monthly Contribution  $");

        InterestRateMonthlyContribution.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateMonthlyContribution.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InterestRateMonthlyContribution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InterestRateMonthlyContributionKeyReleased(evt);
            }
        });

        InterestRateBeggnning.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateBeggnning.setText("Contribute at the beggining of each compound period");
        InterestRateBeggnning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterestRateBeggnningActionPerformed(evt);
            }
        });

        InterestRateEnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateEnd.setText("Contribute at the end of each compound period");
        InterestRateEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterestRateEndActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Interest Rate                  ");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Compound");

        InterestRateCompoundPeriods.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateCompoundPeriods.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Annually", "Semiannually", "Quarterly", "Monthly", "Semimonthly", "Biweekly", "Weekly", "Daily", "Continuously" }));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setText("Investment Length");

        InterestRateInterest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateInterest.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InterestRateInterest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InterestRateInterestKeyReleased(evt);
            }
        });

        InterestRateInvestmentLengthYears.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        InterestRateInvestmentLengthYears.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InterestRateInvestmentLengthYears.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InterestRateInvestmentLengthYearsKeyReleased(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setText("Years");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("%");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(InterestRateCalculatorCalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InterestRateCalculatorClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InterestRateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(InterestRateAnnualContribution)
                                    .addComponent(InterestRateInitialInvestment)
                                    .addComponent(InterestRateMonthlyContribution, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                            .addComponent(InterestRateBeggnning, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InterestRateCompoundPeriods, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InterestRateInterest))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InterestRateInvestmentLengthYears, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InterestRateInitialInvestment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InterestRateAnnualContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InterestRateMonthlyContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InterestRateBeggnning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InterestRateEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InterestRateInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InterestRateCompoundPeriods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InterestRateInvestmentLengthYears, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addGap(24, 24, 24)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InterestRateCalculatorCalculateBTN)
                    .addComponent(InterestRateCalculatorClearBTN))
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(255, 224, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));

        InterestRateOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel92.setText("Results");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InterestRateOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jLabel92)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(InterestRateOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(198, Short.MAX_VALUE)))
        );

        InstructionsRateCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane4.setViewportView(InstructionsRateCalculator);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 190, Short.MAX_VALUE))
        );

        jScrollPane22.setViewportView(jPanel32);

        javax.swing.GroupLayout InterestRateLayout = new javax.swing.GroupLayout(InterestRate);
        InterestRate.setLayout(InterestRateLayout);
        InterestRateLayout.setHorizontalGroup(
            InterestRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        InterestRateLayout.setVerticalGroup(
            InterestRateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        Calculators.addTab("Interest Rate Calculator", InterestRate);

        jPanel19.setBackground(new java.awt.Color(255, 237, 255));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 2, true));

        jPanel4.setBackground(new java.awt.Color(255, 237, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Meet Our Team Pink ");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Welcome Fellas, We are Excited to See You Again!");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 237, 255));

        jLabel19.setText("Blue Aardvark");

        jLabel20.setText("Big Nose");

        jLabel21.setText("Inspector");

        jLabel23.setText("Pink Panther");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(azusena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jorge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osvaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(azusena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(osvaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(pedro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jorge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel20)
                        .addComponent(jLabel21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap())))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Explore Our Calculators");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(164, 164, 164))
        );

        Calculators.addTab("+", jPanel19);

        AutoLoan.setBackground(new java.awt.Color(255, 143, 255));

        jPanel62.setBackground(new java.awt.Color(255, 143, 255));

        jPanel64.setBackground(new java.awt.Color(255, 224, 255));

        jLabel141.setText("Interest Rate");

        jLabel142.setText("Cash Incentives");

        jLabel143.setText("Trade-in value");

        jLabel144.setText("Auto Price ");

        ALCalcButton.setBackground(new java.awt.Color(179, 246, 179));
        ALCalcButton.setText("Calculate");
        ALCalcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALCalcButtonActionPerformed(evt);
            }
        });

        ALClearButton.setBackground(new java.awt.Color(179, 246, 179));
        ALClearButton.setText("Clear");
        ALClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALClearButtonActionPerformed(evt);
            }
        });

        jLabel145.setText("Loan Term");

        jLabel146.setText("Amount Owed on Trade-in");

        jLabel148.setText("Sales Tax");

        jLabel149.setText("Down Payment ");

        jLabel150.setText("Title, Registration and Other Fees");

        ALCheckBox.setText("Include All Fees in Loan");

        javax.swing.GroupLayout jPanel64Layout = new javax.swing.GroupLayout(jPanel64);
        jPanel64.setLayout(jPanel64Layout);
        jPanel64Layout.setHorizontalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ALCalcButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ALCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel141, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel146, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel150, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel142, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ALClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ALSalesTaxInput, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(ALLoanTermInput)
                    .addComponent(ALPriceInput)
                    .addComponent(ALInterestRateInput)
                    .addComponent(ALCashIncentivesInput)
                    .addComponent(ALDownPaymentInput)
                    .addComponent(ALAmtOwnInput)
                    .addComponent(ALTradeInValueInput)
                    .addComponent(ALOtherFeesInput))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        jPanel64Layout.setVerticalGroup(
            jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel64Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ALPriceInput))
                .addGap(3, 3, 3)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ALLoanTermInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(ALInterestRateInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(ALCashIncentivesInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(ALDownPaymentInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALTradeInValueInput)
                    .addComponent(jLabel143))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(ALAmtOwnInput))
                .addGap(50, 50, 50)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(ALSalesTaxInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(ALOtherFeesInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ALCheckBox)
                .addGap(18, 18, 18)
                .addGroup(jPanel64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALCalcButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ALClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        InstructionsAutoLoanCalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane1.setViewportView(InstructionsAutoLoanCalculator);

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Total Price", jPanel62);

        jPanel68.setBackground(new java.awt.Color(255, 237, 255));

        jPanel69.setBackground(new java.awt.Color(204, 255, 204));

        jLabel162.setText("Interest Rate");

        jLabel163.setText("Cash Incentives");

        jLabel164.setText("Trade-in value");

        jLabel165.setText("Monthly Pay");

        jButton27.setText("Calculate");

        jButton28.setText("Clear");

        jLabel166.setText("Loan Term");

        jLabel167.setText("Amount Owed on Trade-in");

        jLabel168.setText("Your State");

        jLabel169.setText("Sales Tax");

        jLabel170.setText("Down Payment ");

        jTextField120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField120ActionPerformed(evt);
            }
        });

        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));

        jLabel171.setText("Title, Registration and Other Fees");

        jCheckBox6.setText("Include All Fees in Loan");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel69Layout.createSequentialGroup()
                        .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel162, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel167, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel168, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel169, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel171, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addComponent(jLabel165, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel164, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField118)
                            .addComponent(jTextField86)
                            .addComponent(jTextField62)
                            .addComponent(jTextField117)
                            .addComponent(jTextField115)
                            .addComponent(jTextField120)
                            .addComponent(jTextField119)
                            .addComponent(jTextField116)
                            .addComponent(jComboBox29, 0, 167, Short.MAX_VALUE)
                            .addComponent(jTextField121)))
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField62))
                .addGap(3, 3, 3)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(jTextField117))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(jTextField115))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel170)
                    .addComponent(jTextField120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField116)
                    .addComponent(jLabel164))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167)
                    .addComponent(jTextField119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel168)
                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel169)
                    .addComponent(jTextField118))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel171)
                    .addComponent(jTextField121))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        InstructionsAutoLoan2Calculator.setBackground(new java.awt.Color(255, 215, 255));
        jScrollPane3.setViewportView(InstructionsAutoLoan2Calculator);

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Monthly Payment", jPanel68);

        jPanel63.setBackground(new java.awt.Color(255, 224, 255));
        jPanel63.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));
        jPanel63.setEnabled(false);

        ALResultOutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel98.setText("Results");

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ALResultOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel63Layout.createSequentialGroup()
                    .addGap(228, 228, 228)
                    .addComponent(jLabel98)
                    .addContainerGap(229, Short.MAX_VALUE)))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel63Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(ALResultOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel63Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout AutoLoanLayout = new javax.swing.GroupLayout(AutoLoan);
        AutoLoan.setLayout(AutoLoanLayout);
        AutoLoanLayout.setHorizontalGroup(
            AutoLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutoLoanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AutoLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AutoLoanLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AutoLoanLayout.setVerticalGroup(
            AutoLoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutoLoanLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        Calculators.addTab("Auto Loan Calculator", AutoLoan);

        RothIRACalculator.setBackground(new java.awt.Color(255, 143, 255));
        RothIRACalculator.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 1, true));
        RothIRACalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                RothIRACalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel46.setBackground(new java.awt.Color(255, 143, 255));

        jPanel47.setBackground(new java.awt.Color(255, 224, 255));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Currenct Balance               $");

        RothIRACalculatorCurrentBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RothIRACalculatorCurrentBalanceKeyReleased(evt);
            }
        });

        RothIRACalculateBTN.setBackground(new java.awt.Color(179, 246, 179));
        RothIRACalculateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RothIRACalculateBTN.setText("Calculate");
        RothIRACalculateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RothIRACalculateBTNActionPerformed(evt);
            }
        });

        RothIRAclearBTN.setBackground(new java.awt.Color(179, 246, 179));
        RothIRAclearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RothIRAclearBTN.setText("Clear");
        RothIRAclearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RothIRAclearBTNActionPerformed(evt);
            }
        });

        LabelAnnualContribution.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelAnnualContribution.setText("Anual Contribution           $");

        RothIRAAnualContribution.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RothIRAAnualContributionKeyReleased(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setText("Maximize Contribution?");

        RothIRAMaximizeYes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RothIRAMaximizeYes.setText("Yes");
        RothIRAMaximizeYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RothIRAMaximizeYesActionPerformed(evt);
            }
        });

        RothIRAMaximizeNO.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RothIRAMaximizeNO.setText("No");
        RothIRAMaximizeNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RothIRAMaximizeNOActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setText("Expected rate of return        ");

        RothIRACalculatorExpectedReturnRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RothIRACalculatorExpectedReturnRateKeyReleased(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setText("Current age");

        RothIRACurrentAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RothIRACurrentAgeKeyReleased(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setText("Retirement Age ");

        RothIRaRetirementAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RothIRaRetirementAgeKeyReleased(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setText("%");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(RothIRAMaximizeYes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RothIRAMaximizeNO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel82)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel47Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(RothIRACalculateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RothIRAclearBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RothIRaRetirementAge, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RothIRACurrentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel47Layout.createSequentialGroup()
                                        .addComponent(RothIRACalculatorExpectedReturnRate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel47Layout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RothIRACalculatorCurrentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel47Layout.createSequentialGroup()
                                        .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(LabelAnnualContribution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RothIRAAnualContribution, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(RothIRACalculatorCurrentBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAnnualContribution)
                    .addComponent(RothIRAAnualContribution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RothIRAMaximizeYes)
                    .addComponent(RothIRAMaximizeNO))
                .addGap(21, 21, 21)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(RothIRACalculatorExpectedReturnRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(RothIRACurrentAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83)
                    .addComponent(RothIRaRetirementAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RothIRACalculateBTN)
                    .addComponent(RothIRAclearBTN))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel48.setBackground(new java.awt.Color(255, 224, 255));
        jPanel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 3));

        RothIRAoutput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel103.setText("Results");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RothIRAoutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel48Layout.createSequentialGroup()
                    .addGap(159, 159, 159)
                    .addComponent(jLabel103)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(RothIRAoutput, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel48Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );

        InstructionsRothIRACalculator.setEditable(false);
        InstructionsRothIRACalculator.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane6.setViewportView(InstructionsRothIRACalculator);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        jScrollPane23.setViewportView(jPanel46);

        javax.swing.GroupLayout RothIRACalculatorLayout = new javax.swing.GroupLayout(RothIRACalculator);
        RothIRACalculator.setLayout(RothIRACalculatorLayout);
        RothIRACalculatorLayout.setHorizontalGroup(
            RothIRACalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        RothIRACalculatorLayout.setVerticalGroup(
            RothIRACalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane23)
        );

        Calculators.addTab("Roth IRA Calculator", RothIRACalculator);

        paceCalculator.setBackground(new java.awt.Color(255, 143, 255));
        paceCalculator.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                paceCalculatorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 224, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Distance");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Time");

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setText("hh:mmss");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        Caculateforpace.setText("Calculate");
        Caculateforpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaculateforpaceActionPerformed(evt);
            }
        });

        ClearForPacecalc.setText("Clear");
        ClearForPacecalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearForPacecalcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(gettime, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(getdistance, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Caculateforpace))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClearForPacecalc)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(gettime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel124))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(getdistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Caculateforpace)
                    .addComponent(ClearForPacecalc))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTextPane1.setBackground(new java.awt.Color(255, 224, 255));
        jScrollPane26.setViewportView(jTextPane1);

        jPanel3.setBackground(new java.awt.Color(255, 224, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255), 2));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel122.setText("Pace in different Units");

        KilometerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MileLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane25.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KilometerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(MileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel122)
                            .addComponent(jLabel128))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KilometerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paceCalculatorLayout = new javax.swing.GroupLayout(paceCalculator);
        paceCalculator.setLayout(paceCalculatorLayout);
        paceCalculatorLayout.setHorizontalGroup(
            paceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paceCalculatorLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(paceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paceCalculatorLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(paceCalculatorLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        paceCalculatorLayout.setVerticalGroup(
            paceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paceCalculatorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paceCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paceCalculatorLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        Calculators.addTab("Pace Calculator", paceCalculator);

        deepThoughts.setBackground(new java.awt.Color(255, 143, 255));
        deepThoughts.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                deepThoughtsAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Good evening\n\nI am Deep thought.\n\nI have an answer for you.\n\nTHE answer\n\nI really have it\n\nI am ready to give it to you\n\nNOW\n\nYou will not like it ");
        jScrollPane24.setViewportView(jTextArea1);

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel123.setText("Deep Thought");

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel127.setText("What is the answer to the great question of life ");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setText("I Submit my answer to the universe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout deepThoughtsLayout = new javax.swing.GroupLayout(deepThoughts);
        deepThoughts.setLayout(deepThoughtsLayout);
        deepThoughtsLayout.setHorizontalGroup(
            deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deepThoughtsLayout.createSequentialGroup()
                .addGroup(deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deepThoughtsLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(deepThoughtsLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(deepThoughtsLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                    .addComponent(jLabel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(deepThoughtsLayout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jButton1))))
                    .addGroup(deepThoughtsLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        deepThoughtsLayout.setVerticalGroup(
            deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deepThoughtsLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(deepThoughtsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deepThoughtsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(deepThoughtsLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel127)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );

        Calculators.addTab("Deep Thought", deepThoughts);

        ekinator2.setBackground(new java.awt.Color(255, 143, 255));
        ekinator2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ekinator2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel130.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel130.setText("<html>Welcome to Akinator 2 – the superior version!  I’m not just any guessing genie; <br> I’m the upgraded, enhanced, and undeniably improved model. Forget the old Akinator—he’s obsolete!  <br>  Why? Because I’m Akinator 2.0, baby! Let’s see if you can stump me. Spoiler alert: you<html>");

        jLabel131.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel131.setText("<html> Give me your age, <br> and i will provide you with mystical Knowledge<html>");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setText("Submit Age");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout ekinator2Layout = new javax.swing.GroupLayout(ekinator2);
        ekinator2.setLayout(ekinator2Layout);
        ekinator2Layout.setHorizontalGroup(
            ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekinator2Layout.createSequentialGroup()
                .addGroup(ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ekinator2Layout.createSequentialGroup()
                            .addGap(213, 213, 213)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ekinator2Layout.createSequentialGroup()
                            .addGap(96, 96, 96)
                            .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ekinator2Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addComponent(jButton2))
                                .addGroup(ekinator2Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(ekinator2Layout.createSequentialGroup()
                            .addGap(191, 191, 191)
                            .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(306, 431, Short.MAX_VALUE))
        );
        ekinator2Layout.setVerticalGroup(
            ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ekinator2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(ekinator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ekinator2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(12, 12, 12)
                .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        Calculators.addTab("Ekinator 2", ekinator2);

        quitBnt.setText("Quit");
        quitBnt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quitBnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitBntMouseClicked(evt);
            }
        });
        jMenuBar1.add(quitBnt);

        jMenu2.setText("About");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu2.setHideActionText(true);
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Calculators, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Calculators)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)))
        );

        Calculators.getAccessibleContext().setAccessibleName("Rent vs Buy Calculator");

        pack();
    }// </editor-fold>//GEN-END:initComponents
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private void btnmathCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmathCalculatorActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
         restoreTab("Math Calculator");//needs to be change according to the name of the tab 
         CalculatorNameLBL.setText("Math Calculator");
    }//GEN-LAST:event_btnmathCalculatorActionPerformed

    private void btnfitnessCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfitnessCalculatorActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
       
       //restoreTab("Fitness & Health Calculator");
       CalculatorNameLBL.setText("Pace Calculator");
        restoreTab("Pace Calculator");
       
    }//GEN-LAST:event_btnfitnessCalculatorActionPerformed

    private void btnOtherCalculatorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherCalculatorsActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        //restoreTab("Other Calculators");
        CalculatorNameLBL.setText("Other Calculator");
            restoreTab("Deep Thought");
            restoreTab("Ekinator 2");

    }//GEN-LAST:event_btnOtherCalculatorsActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        restoreTab("+");
        CalculatorNameLBL.setText("Welcome...");
   
    }//GEN-LAST:event_dashboardActionPerformed

    private void btnfinancialCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfinancialCalculatorActionPerformed
        // TODO add your handling code here:
 
        if (FCcontrolBtn.isVisible()) {
           // If it is visible, set it to invisible
           FCcontrolBtn.setVisible(false);
       } else {
           // If it is invisible, set it to visible
           FCcontrolBtn.setVisible(true);
       }
         
        
    }//GEN-LAST:event_btnfinancialCalculatorActionPerformed

    private void RefinanceCalculatorNewLoanTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefinanceCalculatorNewLoanTermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefinanceCalculatorNewLoanTermActionPerformed

    private void MortgageandRealEstateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgageandRealEstateBTNActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        restoreTab("Mortgage Payoff Calculator");
        restoreTab("Mortgage Calculator");
        restoreTab("House Affordability Calculator");
        restoreTab("Rent Calculator");
        restoreTab("Refinance Calculator");
        restoreTab("Down Payment Calculator");
        //restoreTab("Rent vs Buy Calculator");---pending
    }//GEN-LAST:event_MortgageandRealEstateBTNActionPerformed

    private void OtherCalculatorsBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherCalculatorsBTN1ActionPerformed
        // TODO add your handling code here:
            removeAllTabs();
            restoreTab("Currency Calculator");//needs to be change according to the name of the tab
            CalculatorNameLBL.setText("Currency Calculator");

            

    }//GEN-LAST:event_OtherCalculatorsBTN1ActionPerformed

    private void RetirementCalculatorBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirementCalculatorBTN2ActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        restoreTab("Retirement Calculator");
        restoreTab("Roth IRA Calculator");

    }//GEN-LAST:event_RetirementCalculatorBTN2ActionPerformed

    private void InvestmentCalculatorBTN3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvestmentCalculatorBTN3ActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        CalculatorNameLBL.setText("Interest Rate Calculator");
        restoreTab("Interest Rate Calculator");
        
        interestRateFields();
    }//GEN-LAST:event_InvestmentCalculatorBTN3ActionPerformed

    private void autoCalculatorBTN4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoCalculatorBTN4ActionPerformed
        // TODO add your handling code here:
        removeAllTabs();
        restoreTab("Auto Loan Calculator");
        
        CalculatorNameLBL.setText("Auto Loan Calculator");
    }//GEN-LAST:event_autoCalculatorBTN4ActionPerformed

    private void quitBntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitBntMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitBntMouseClicked

    private void jTextField120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField120ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField120ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        showAboutPopup();
    }//GEN-LAST:event_jMenu2MouseClicked
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------MOney FOrmat 
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------Interest Rate Calculator Pedro
    private void InterestRateCalculatorClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterestRateCalculatorClearBTNActionPerformed
        // TODO add your handling code here:
        InterestRateInitialInvestment.setText("");
        InterestRateAnnualContribution.setText("0");
        InterestRateMonthlyContribution.setText("0");
        InterestRateBeggnning.setSelected(true);
        InterestRateEnd.setSelected(false);
        InterestRateInterest.setText("");
        InterestRateInvestmentLengthYears.setText("1");
        InterestRateOutput.setText("");
    }//GEN-LAST:event_InterestRateCalculatorClearBTNActionPerformed

    private void interestRateFields(){
        InterestRateAnnualContribution.setText("0");
        InterestRateMonthlyContribution.setText("0");
        InterestRateInvestmentLengthYears.setText("1");
        InterestRateBeggnning.setSelected(true);
    }
    private void InterestRateBeggnningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterestRateBeggnningActionPerformed
        // TODO add your handling code here:
       if (InterestRateBeggnning.isSelected()) {
        // If selected, uncheck InterestRateEnd
        InterestRateEnd.setSelected(false);
    }
    }//GEN-LAST:event_InterestRateBeggnningActionPerformed

    private void InterestRateEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterestRateEndActionPerformed
        // TODO add your handling code here:
        if (InterestRateEnd.isSelected()) {
        // If selected, uncheck InterestRateEnd
        InterestRateBeggnning.setSelected(false);}
        
    }//GEN-LAST:event_InterestRateEndActionPerformed

    private void InterestRateInitialInvestmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InterestRateInitialInvestmentKeyReleased
        // TODO add your handling code here:
         // Get the input from the text field
      String input = InterestRateInitialInvestment.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      InterestRateInitialInvestment.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      InterestRateInitialInvestment.setText(Number);
    }//GEN-LAST:event_InterestRateInitialInvestmentKeyReleased

    private void InterestRateAnnualContributionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InterestRateAnnualContributionKeyReleased
        // TODO add your handling code here:
                 // Get the input from the text field
      String input = InterestRateAnnualContribution.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      InterestRateAnnualContribution.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      InterestRateAnnualContribution.setText(Number);
    }//GEN-LAST:event_InterestRateAnnualContributionKeyReleased

    private void InterestRateMonthlyContributionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InterestRateMonthlyContributionKeyReleased
      // Get the input from the text field
      String input = InterestRateMonthlyContribution.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      InterestRateMonthlyContribution.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      InterestRateMonthlyContribution.setText(Number);
    }//GEN-LAST:event_InterestRateMonthlyContributionKeyReleased

    private void InterestRateInterestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InterestRateInterestKeyReleased
          // Get the input from the text field
      String input = InterestRateInterest.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      InterestRateInterest.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      InterestRateInterest.setText(Number);
    }//GEN-LAST:event_InterestRateInterestKeyReleased

    private void InterestRateInvestmentLengthYearsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InterestRateInvestmentLengthYearsKeyReleased
        // TODO add your handling code here:
          String input = InterestRateInvestmentLengthYears.getText();
          // Strip all spaces from the input as the user types
          String strippedInput = input.replaceAll("\\s", "");
          // Set the text field with the stripped input (without spaces)
          InterestRateInvestmentLengthYears.setText(strippedInput);
          String Number = Helper.extractWholePositiveNumbers(input);
          InterestRateInvestmentLengthYears.setText(Number);
    }//GEN-LAST:event_InterestRateInvestmentLengthYearsKeyReleased

    private void InterestRateCalculatorCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterestRateCalculatorCalculateBTNActionPerformed
        try{
            
            // Retrieve the selected item from the InterestRateCompoundPeriods combo box
           String selectedOption = (String) InterestRateCompoundPeriods.getSelectedItem();



           double PI = Double.parseDouble(InterestRateInitialInvestment.getText());
           double Ca = Double.parseDouble(InterestRateAnnualContribution.getText());
           double Cm = Double.parseDouble(InterestRateMonthlyContribution.getText());
           double r = Double.parseDouble(InterestRateInterest.getText())/100;
           int a = 1;   
           int n = Helper.selectionPeriod(selectedOption);
           double t = Double.parseDouble(InterestRateInvestmentLengthYears.getText());

           double FV_year = 0;
           String outputText="";

           if (InterestRateBeggnning.isSelected()) {
               if ("Continuously".equals(selectedOption)){
                   FV_year =Helper.future_valueBeginning(PI, Ca, Cm, r, t);
                   double[] extraCalculations = Helper.interestRateCalculatorExtraCalculations(FV_year, PI, Ca, Cm, t);
                   outputText = "<html>"
                             + "<b>Investment Calculations:</b><br>"
                             + "Ending Balance: " +  currencyFormat.format(extraCalculations[3]) + "<br>"
                             + "Total Principal: " + currencyFormat.format(extraCalculations[0]) + "<br>"
                             + "Total Contributions: " + currencyFormat.format(extraCalculations[1]) + "<br>"
                             + "Total Interest: " + currencyFormat.format(extraCalculations[2]) + "<br>"
                             + "</html>";
               }else{
                   FV_year = Helper.interestRateBegining(PI, Ca, Cm, r, a, n, t);}
                   double[] extraCalculations = Helper.interestRateCalculatorExtraCalculations(FV_year, PI, Ca, Cm, t);
                   outputText = "<html>"
                             + "<b>Investment Calculations:</b><br>"
                             + "Ending Balance: " + currencyFormat.format(extraCalculations[3]) + "<br>"
                             + "Total Principal: " + currencyFormat.format(extraCalculations[0]) + "<br>"
                             + "Total Contributions: " + currencyFormat.format(extraCalculations[1]) + "<br>"
                             + "Total Interest: " + currencyFormat.format(extraCalculations[2]) + "<br>"
                             + "</html>";
           }

           // Check if InterestRateEnd is selected
           if (InterestRateEnd.isSelected()) {
                if ("Continuously".equals(selectedOption)){
                    FV_year =Helper.future_valueEnd(PI, Ca, Cm, r, t);
                   double[] extraCalculations = Helper.interestRateCalculatorExtraCalculations(FV_year, PI, Ca, Cm, t);
                   outputText = "<html>"
                             + "<b>Investment Calculations:</b><br>"
                             + "Ending Balance: " + currencyFormat.format(extraCalculations[3]) + "<br>"
                             + "Total Principal: " + currencyFormat.format(extraCalculations[0]) + "<br>"
                             + "Total Contributions: " + currencyFormat.format(extraCalculations[1]) + "<br>"
                             + "Total Interest: " + currencyFormat.format(extraCalculations[2]) + "<br>"
                             + "</html>";
                }
                else{
                // Calculate future value using nominal interest rate and contributions
                   FV_year = Helper.interestrateEND(PI, Ca, Cm, r, a, n, t);
                   double[] extraCalculations = Helper.interestRateCalculatorExtraCalculations(FV_year, PI, Ca, Cm, t);
                   outputText = "<html>"
                             + "<b>Investment Calculations:</b><br>"
                             + "Ending Balance: " + currencyFormat.format(extraCalculations[3]) + "<br>"
                             + "Total Principal: " + currencyFormat.format(extraCalculations[0]) + "<br>"
                             + "Total Contributions: " + currencyFormat.format(extraCalculations[1]) + "<br>"
                             + "Total Interest: " + currencyFormat.format(extraCalculations[2]) + "<br>"
                             + "</html>";
                }
           }

           InterestRateOutput.setText(outputText);
        }

        catch(Exception e){
            InterestRateOutput.setText("Error404");
            JOptionPane.showMessageDialog(null, "Empty fields!");
          
        }
       
    }//GEN-LAST:event_InterestRateCalculatorCalculateBTNActionPerformed
//------------------------------------------------------------------------------------------------------------------------------------------------------------Roth IRA calculator Pedro
    private void RothIRACalculatorCurrentBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RothIRACalculatorCurrentBalanceKeyReleased
        // TODO add your handling code here:
       // Get the input from the text field
      String input = RothIRACalculatorCurrentBalance.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      RothIRACalculatorCurrentBalance.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      RothIRACalculatorCurrentBalance.setText(Number);
    }//GEN-LAST:event_RothIRACalculatorCurrentBalanceKeyReleased

    private void RothIRAAnualContributionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RothIRAAnualContributionKeyReleased
        // TODO add your handling code here:
      // Get the input from the text field
      String input = RothIRAAnualContribution.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      RothIRAAnualContribution.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      RothIRAAnualContribution.setText(Number);
    }//GEN-LAST:event_RothIRAAnualContributionKeyReleased

    private void RothIRACalculatorExpectedReturnRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RothIRACalculatorExpectedReturnRateKeyReleased
      String input = RothIRACalculatorExpectedReturnRate.getText();
      String strippedInput = input.replaceAll("\\s", "");
      RothIRACalculatorExpectedReturnRate.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      RothIRACalculatorExpectedReturnRate.setText(Number);

            int input2 = Integer.valueOf(input);
            double hp = 0;
            String selectedOptionDownPayment = "%";
            Helper.validateInput(input2, hp, selectedOptionDownPayment);
          
    }//GEN-LAST:event_RothIRACalculatorExpectedReturnRateKeyReleased

    private void RothIRACurrentAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RothIRACurrentAgeKeyReleased
        // TODO add your handling code here:
      String input = RothIRACurrentAge.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      RothIRACurrentAge.setText(strippedInput);
      String Number = Helper.extractWholePositiveNumbers(input);
      RothIRACurrentAge.setText(Number);

          
          if (RothIRACurrentAge.getText().isEmpty()){
          }
          else{Helper.checkAge(RothIRACurrentAge.getText().replaceAll("\\s", ""));}
  
    }//GEN-LAST:event_RothIRACurrentAgeKeyReleased

    private void RothIRaRetirementAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RothIRaRetirementAgeKeyReleased
        // TODO add your handling code here:
          // TODO add your handling code here:
        String input = RothIRaRetirementAge.getText();
        // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        RothIRaRetirementAge.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RothIRaRetirementAge.setText(Number);

         if (RothIRaRetirementAge.getText().isEmpty()){}
         else{Helper.checkAge(RothIRaRetirementAge.getText().replaceAll("\\s", ""));}
    }//GEN-LAST:event_RothIRaRetirementAgeKeyReleased

    private void RothIRAMaximizeYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RothIRAMaximizeYesActionPerformed
        // TODO add your handling code here:
        if (RothIRAMaximizeYes.isSelected()) {
        // If selected, uncheck InterestRateEnd
       RothIRAAnualContributionSpace = RothIRAAnualContribution.getText();
       RothIRAMaximizeNO.setSelected(false);
       RothIRAAnualContribution.setText("0");
       RothIRAAnualContribution.setVisible(false);
       LabelAnnualContribution.setText("Annual Contributions Max Out");
        }    
    }//GEN-LAST:event_RothIRAMaximizeYesActionPerformed

    private void RothIRAMaximizeNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RothIRAMaximizeNOActionPerformed
        // TODO add your handling code here:
        if (RothIRAMaximizeNO.isSelected()) {
        // If selected, uncheck InterestRateEnd
        RothIRAMaximizeYes.setSelected(false);
        RothIRAAnualContribution.setText(RothIRAAnualContributionSpace);
        RothIRAAnualContributionSpace =null;
        RothIRAAnualContribution.setVisible(true);
        LabelAnnualContribution.setText("Anual Contribution           $");
        }
    }//GEN-LAST:event_RothIRAMaximizeNOActionPerformed

    private void RothIRAclearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RothIRAclearBTNActionPerformed
        // TODO add your handling code here:
        RothIRACalculatorCurrentBalance.setText("");

        RothIRACalculatorExpectedReturnRate.setText("");
        RothIRACurrentAge.setText("");
        RothIRaRetirementAge.setText("");

        RothIRAMaximizeNO.setSelected(true);
        RothIRAoutput.setText("");
        RothIRAAnualContributionSpace =null;
        RothIRAMaximizeYes.setSelected(false);
        RothIRAAnualContribution.setText("0");
        RothIRAAnualContribution.setVisible(true);
        LabelAnnualContribution.setText("Anual Contribution           $");
        RentOutput.setText("");
    }//GEN-LAST:event_RothIRAclearBTNActionPerformed

    private void RothIRACalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RothIRACalculateBTNActionPerformed
        // TODO add your handling code here:
        try{         
        
        if (
            Helper.InputValidation(RothIRACalculatorCurrentBalance.getText()) &&
            Helper.InputValidation(RothIRAAnualContribution.getText()) &&
            Helper.InputValidation(RothIRACalculatorExpectedReturnRate.getText()) &&
            Helper.InputValidation(RothIRACurrentAge.getText()) &&
            Helper.InputValidation(RothIRaRetirementAge.getText()) &&
            Helper.validateAges(RothIRACurrentAge.getText(), RothIRaRetirementAge.getText())
        ) {
                double PI = Double.parseDouble(RothIRACalculatorCurrentBalance.getText());
                double Ca = Double.parseDouble(RothIRAAnualContribution.getText());
                double r = Double.parseDouble(RothIRACalculatorExpectedReturnRate.getText())/100;

                int C_age = Integer.parseInt(RothIRACurrentAge.getText());
                int R_age = Integer.parseInt(RothIRaRetirementAge.getText());

                double balance = 0;
                double totalPrinciple=0;
                double totalInterest = 0;

                 if (RothIRAMaximizeNO.isSelected()) {
                    if (Ca > 7000) {
                         JOptionPane.showMessageDialog(null,  "<html><body style='width: 300px;'><p style='font-size:12px;'>"
                        + "The annual contribution is higher than the limit imposed by the IRS for the age, "
                        + "which is $7000. As a result, the calculator used the adjusted contribution amount "
                        + "to meet the IRS requirement."
                        + "</p></body></html>");
                         
                         
                        Ca = 7000; // Adjust contribution to IRS limit
                        int n = R_age - C_age;
                        balance =Helper.calculate_MaximizeContributionNo(PI, Ca, r, n);
                        totalPrinciple = PI +(Ca*(R_age-C_age));
                        totalInterest = (balance-totalPrinciple)+Ca;
                    }
                    else{

                     int n = R_age - C_age;
                     balance =Helper.calculate_MaximizeContributionNo(PI, Ca, r, n);
                     totalPrinciple = PI +(Ca*(R_age-C_age));
                     totalInterest = (balance-totalPrinciple)+Ca;}

                }

                // Check if InterestRateEnd is selected
                if (RothIRAMaximizeYes.isSelected()) {
                    Ca = 7000;
                    if (C_age> 50 && R_age >50){Ca = 8000;}

                    balance = Helper.calculate_MaximizeContributionYes(PI, Ca, r, C_age, R_age);
                    double[] extraCalculations = Helper.extraCalculationsRothIRACalculatorYES(PI, Ca, C_age, R_age, balance);
                    totalPrinciple = extraCalculations[0];
                    totalInterest = extraCalculations[1];

                }

                String outputText = "<html><body style='width: 300px;'>"
                                  + "Roth IRA Calculation Results"
                                  + "<p><b>Your balance at age " + R_age + ":</b> " +  currencyFormat.format(balance) + "</p>"
                                  + "<p><b>Total principal:</b> " +  currencyFormat.format(totalPrinciple) + "</p>"
                                  + "<p><b>Total Interest:</b> " +  currencyFormat.format(totalInterest) + "</p>"
                                  + "</body></html>";



                RothIRAoutput.setText(outputText);
        } else {
            RothIRAoutput.setText("Error404");
           
        }
  
        }
        catch(Exception e){
            RothIRAoutput.setText("Error404");
            JOptionPane.showMessageDialog(null, "Empty fields!");
        }
    }//GEN-LAST:event_RothIRACalculateBTNActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------Rent Calculator Pedro
    private void RentPretaxIncomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RentPretaxIncomeKeyReleased
        // TODO add your handling code here:
      String input = RentPretaxIncome.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      RentPretaxIncome.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      RentPretaxIncome.setText(Number);
    }//GEN-LAST:event_RentPretaxIncomeKeyReleased

    private void RentMonthlyDebtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RentMonthlyDebtKeyReleased
        // TODO add your handling code here:
      String input = RentMonthlyDebt.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      RentMonthlyDebt.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      RentMonthlyDebt.setText(Number);
    }//GEN-LAST:event_RentMonthlyDebtKeyReleased

    private void RentClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentClearBTNActionPerformed
        // TODO add your handling code here:
       RentPretaxIncome.setText("");
       RentMonthlyDebt.setText("0");
    }//GEN-LAST:event_RentClearBTNActionPerformed

    private void RentCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentCalculateBTNActionPerformed
        // TODO add your handling code here:
        try{
            String selectedOption = (String) RentComboboxYearandMonth.getSelectedItem();
            
                if (RentMonthlyDebt.getText().trim().isEmpty()) {
                RentMonthlyDebt.setText("0");
            }
   
            double incomeYearlyOrMonthly = Double.parseDouble(RentPretaxIncome.getText());
            double monthlyDebt = Double.parseDouble(RentMonthlyDebt.getText());
            
            

           
            String outputText = "";
            
          
            
   
            
            if ("per year".equals(selectedOption)) {
                String optionSelected = "year";
                long[] affordableRent = Helper.calculateAffordableRent(incomeYearlyOrMonthly, monthlyDebt, optionSelected);
                if (affordableRent != null) {
                    outputText = "<html>You can afford up to " + currencyFormat.format(affordableRent[0]) 
                                + " per month on a rental payment.<br>"
                                + "It is recommended to keep your rental payment below " 
                                + currencyFormat.format(affordableRent[1]) + " per month</html>";
                } else {
                    outputText = "<html>"
                            + "At your level of income and debt, "
                            + "It will be hard to meet rent payments</html>";
                }
            }

            if ("per month".equals(selectedOption)) {
                String optionSelected = "monthly";
                long[] affordableRent = Helper.calculateAffordableRent(incomeYearlyOrMonthly, monthlyDebt, optionSelected);
                if (affordableRent != null) {
                    outputText = "<html>You can afford up to " + currencyFormat.format(affordableRent[0]) 
                                + " per month on a rental payment.<br>"
                                + "It is recommended to keep your rental payment below " 
                                + currencyFormat.format(affordableRent[1]) + " per month</html>";
                } else {
                    outputText = "<html>"
                            + "At your level of income and debt, "
                            + "It will be hard to meet rent payments</html>";
                }
            }

            // Set the text in the RentOutput label using HTML
            RentOutput.setText(outputText);



        }
        catch(Exception e){
            RentOutput.setText("Error404");
            JOptionPane.showMessageDialog(null, "Empty fields!");
        }
        
    }//GEN-LAST:event_RentCalculateBTNActionPerformed
//-------------------------------------------------------------------------------------------------------------------------------------------------------Down Payment Calculator
    private void DownPaymentUpfrontCashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DownPaymentUpfrontCashKeyReleased

      String input = DownPaymentUpfrontCash.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      DownPaymentUpfrontCash.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      DownPaymentUpfrontCash.setText(Number);
    }//GEN-LAST:event_DownPaymentUpfrontCashKeyReleased

    private void DownPaymentClosingCOstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DownPaymentClosingCOstKeyReleased
      String input = DownPaymentClosingCOst.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      DownPaymentClosingCOst.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      DownPaymentClosingCOst.setText(Number);
    }//GEN-LAST:event_DownPaymentClosingCOstKeyReleased

    private void DownPaymentInterestRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DownPaymentInterestRateKeyReleased
      String input = DownPaymentInterestRate.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      DownPaymentInterestRate.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      DownPaymentInterestRate.setText(Number);
    }//GEN-LAST:event_DownPaymentInterestRateKeyReleased

    private void DownPaymentLoanTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DownPaymentLoanTermKeyReleased
      String input = DownPaymentLoanTerm.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      DownPaymentLoanTerm.setText(strippedInput);
      String Number = Helper.extractWholePositiveNumbers(input);
      DownPaymentLoanTerm.setText(Number);
    }//GEN-LAST:event_DownPaymentLoanTermKeyReleased

    private void DownPaymentClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownPaymentClearBTNActionPerformed
       
        DownPaymentUpfrontCash.setText("");
        DownPaymentDownPayment.setText("");
        DownPaymentClosingCOst.setText("");
        DownPaymentInterestRate.setText("");
        DownPaymentLoanTerm.setText("");
        DownPaymnentCheckboxClosingCost.setSelected(false);
        DownPaymentOuput.setText("");
    }//GEN-LAST:event_DownPaymentClearBTNActionPerformed

    private void DownPaymentDownPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DownPaymentDownPaymentKeyReleased
      String input = DownPaymentDownPayment.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      DownPaymentDownPayment.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      DownPaymentDownPayment.setText(Number);
    }//GEN-LAST:event_DownPaymentDownPaymentKeyReleased

    private void DownPaymentCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownPaymentCalculateBTNActionPerformed
                // Assuming DownPaymentCheckboxClosingCost is your JCheckBox
                
        try{
            
            if (DownPaymentClosingCOst.getText().trim().isEmpty()) {
                DownPaymentClosingCOst.setText("0");
            }
            double upfrontCash = Double.parseDouble( DownPaymentUpfrontCash.getText());
            double downpayment = Double.parseDouble(DownPaymentDownPayment.getText());
            double includeClosingCosts = Double.parseDouble(DownPaymentClosingCOst.getText());
            double interestRate = Double.parseDouble(DownPaymentInterestRate.getText());
            double loanTerm = Double.parseDouble(DownPaymentLoanTerm.getText());

            String outputText="";


            if (DownPaymnentCheckboxClosingCost.isSelected()) {

                String selectedOption = (String) DownPaymentComboBox.getSelectedItem();
                if ("%".equals(selectedOption)) {
                     if (includeClosingCosts+1>100){
                        JOptionPane.showMessageDialog(null, "Closing costs percentage should not be so high. It should between 0 and 99%");
                         }
                     else{
                    double[] result1 = Helper.downpaymentNOClosingCostandPercent(upfrontCash, downpayment, interestRate, loanTerm, includeClosingCosts);     
                    outputText = "<html>You can afford up to " + currencyFormat.format(result1[0]) + " for the home price.<br>"
                              + "Your loan amount is " + currencyFormat.format(result1[1]) + ".<br>"
                              + "Your monthly payment will be " + currencyFormat.format(result1[2]) + ".</html>";
                    }



                } if ("$".equals(selectedOption)){
                     if (includeClosingCosts>upfrontCash){
                            JOptionPane.showMessageDialog(null, "Closing costs should not be more than the cash amount you plan to put in.");
                        }
                     else{
                    double[] result2 = Helper.downpaymentYesClosingCostandMoney(upfrontCash, downpayment, interestRate, loanTerm, includeClosingCosts);
                    outputText = "<html>You can afford up to " + currencyFormat.format(result2[0]) + " for the home price.<br>"
                               + "Your loan amount is " + currencyFormat.format(result2[1]) + ".<br>"
                               + "Your monthly payment will be " + currencyFormat.format(result2[2]) + ".</html>";}
                }
            } else {
               double[] result1 = Helper.downpaymentNOClosingCostandPercent(upfrontCash, downpayment, interestRate, loanTerm, includeClosingCosts=0);     
               outputText = "<html>You can afford up to " + currencyFormat.format(result1[0]) + " for the home price.<br>"
                              + "Your loan amount is " + currencyFormat.format(result1[1]) + ".<br>"
                              + "Your monthly payment will be " + currencyFormat.format(result1[2]) + ".</html>";
            }
            DownPaymentOuput.setText(outputText);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empty fields!");DownPaymentOuput.setText("Error404");
        }
    }//GEN-LAST:event_DownPaymentCalculateBTNActionPerformed

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------Auto Loan Calculator Jorge 
    private void highlightErrorField(JTextField field) {
    field.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
}

    
    private void ALCalcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALCalcButtonActionPerformed
        // TODO add your handling code here:
        String autoPriceValue = ALPriceInput.getText();
        String loanTermValue = ALLoanTermInput.getText();
        String interestRateValue = ALInterestRateInput.getText();
        String cashIncentivesValue = ALCashIncentivesInput.getText();
        String downPaymentValue = ALDownPaymentInput.getText();
        String tradeInValueValue = ALTradeInValueInput.getText();
        String amtOwnedTradeInValue = ALAmtOwnInput.getText();
        String salesTaxValue = ALSalesTaxInput.getText();
        String otherFeesValue = ALOtherFeesInput.getText();
        
        clearErrorHighlights();

        // Initialize a flag to track if there are any errors
        boolean hasErrors = false;

        // Validate each input field and highlight errors
        if (Helper.isValidLoanTerm(loanTermValue)) {
            // Valid loan term
        } else {
            highlightErrorField(ALLoanTermInput);
            hasErrors = true;
        }

        double autoPrice = Helper.parseWithValidation(autoPriceValue, "auto price", new StringBuilder());
        if (autoPrice == -1) {
            highlightErrorField(ALPriceInput);
            hasErrors = true;
        }

        double interestRate = Helper.parseWithValidation(interestRateValue, "interest rate", new StringBuilder());
        if (interestRate == -1) {
            highlightErrorField(ALInterestRateInput);
            hasErrors = true;
        }

        double cashIncentives = Helper.parseWithValidation(cashIncentivesValue, "cash incentives", new StringBuilder());
        if (cashIncentives == -1) {
            highlightErrorField(ALCashIncentivesInput);
            hasErrors = true;
        }

        double downPayment = Helper.parseWithValidation(downPaymentValue, "down payment", new StringBuilder());
        if (downPayment == -1) {
            highlightErrorField(ALDownPaymentInput);
            hasErrors = true;
        }

        double tradeInValue = Helper.parseWithValidation(tradeInValueValue, "trade-in value", new StringBuilder());
        if (tradeInValue == -1) {
            highlightErrorField(ALTradeInValueInput);
            hasErrors = true;
        }

        double amtOwnedTradeIn = Helper.parseWithValidation(amtOwnedTradeInValue, "amount owed on trade-in", new StringBuilder());
        if (amtOwnedTradeIn == -1) {
            highlightErrorField(ALAmtOwnInput);
            hasErrors = true;
        }

        double salesTax = Helper.parseWithValidation(salesTaxValue, "sales tax", new StringBuilder());
        if (salesTax == -1) {
            highlightErrorField(ALSalesTaxInput);
            hasErrors = true;
        }

        double otherFees = Helper.parseWithValidation(otherFeesValue, "other fees", new StringBuilder());
        if (otherFees == -1) {
            highlightErrorField(ALOtherFeesInput);
            hasErrors = true;
        }

        // If there are any validation errors, display a message and return
        if (hasErrors) {
            ALResultOutput.setText("Error: Please check your input values.");
            return;
        }

        // Proceed with loan calculation if no errors
        double[] result = Helper.calcAutoLoan(
            autoPriceValue, loanTermValue, interestRateValue,
            cashIncentivesValue, downPaymentValue, tradeInValueValue,
            amtOwnedTradeInValue, salesTaxValue, otherFeesValue
        );

        // Format the result as currency
        DecimalFormat resultFormat = new DecimalFormat("$#,###.00");

        // Display the result based on checkbox selection
        if (ALCheckBox.isSelected()) {
            ALResultOutput.setText("Monthly Payment (with fees): " + resultFormat.format(result[1]));
        } else {
            ALResultOutput.setText("Monthly Payment (without fees): " + resultFormat.format(result[0]));
        }
        
        /*double[] result = Helper.calcAutoLoan(autoPriceValue, loanTermValue, interestRateValue, cashIncentivesValue, downPaymentValue, tradeInValueValue, amtOwnedTradeInValue, salesTaxValue, otherFeesValue);
        if(result[0] == -1 || result[1] == -1){
            ALResultOutput.setText("");
            return;
        }
        
        DecimalFormat resultFormat = new DecimalFormat("$#,###.00");
        if(ALCheckBox.isSelected()){
            ALResultOutput.setText(resultFormat.format(result[1]));
        }else{
            ALResultOutput.setText(resultFormat.format(result[0]));
        }*/
    }//GEN-LAST:event_ALCalcButtonActionPerformed

    private void clearErrorHighlights() {
        ALPriceInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALLoanTermInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALInterestRateInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALCashIncentivesInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALDownPaymentInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALTradeInValueInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALAmtOwnInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALSalesTaxInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        ALOtherFeesInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
}
    
    private void ALClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALClearButtonActionPerformed
        // TODO add your handling code here:
        // Clear all input fields
        ALPriceInput.setText("");
        ALLoanTermInput.setText("");
        ALInterestRateInput.setText("");
        ALCashIncentivesInput.setText("");
        ALDownPaymentInput.setText("");
        ALTradeInValueInput.setText("");
        ALAmtOwnInput.setText("");
        ALSalesTaxInput.setText("");
        ALOtherFeesInput.setText("");

        // Clear the output field
        ALResultOutput.setText("");
        clearErrorHighlights();
    }//GEN-LAST:event_ALClearButtonActionPerformed
//---------------------------------------------------------------------------------------------------------------------------------------------Mortgage Calculator Pedro
    private void hideComponentsMortgageCalculator() {
        MortgageCalculatorPropertyTaxes.setVisible(false);
        MortgageCalculatorPropertyTaxesLabel.setVisible(false);
        MortgageCalculatorPropertyTaxesCbox.setVisible(false);
        
        MortgageCalculatorHomeInsurance.setVisible(false);
        MortgageCalculatorHomeInsuranceLabel.setVisible(false);
        MortgageCalculatorHomeInsuranceCBox.setVisible(false);
        
        MortgageCalculatorHOAFee.setVisible(false);
        MortgageCalculatorHoaFeeLabel.setVisible(false);
        MortgageCalculatorHoaFeeCBox.setVisible(false);
        
        MortgageCalculatorOtherCost.setVisible(false);
        MortgageCalculatorOtherCostLabel.setVisible(false);
        MortgageCalculatorOtherCostCBox.setVisible(false);}
        
        
    
    private void MorgageCalculatorHomePriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MorgageCalculatorHomePriceKeyReleased
      String input = MorgageCalculatorHomePrice.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      MorgageCalculatorHomePrice.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      MorgageCalculatorHomePrice.setText(Number);  
    }//GEN-LAST:event_MorgageCalculatorHomePriceKeyReleased

    private void MortgateCalculatorDownPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgateCalculatorDownPaymentKeyReleased
      String input = MortgateCalculatorDownPayment.getText();
      // Strip all spaces from the input as the user types
      String strippedInput = input.replaceAll("\\s", "");
      // Set the text field with the stripped input (without spaces)
      MortgateCalculatorDownPayment.setText(strippedInput);
      String Number = Helper.extractNumbers(input);
      MortgateCalculatorDownPayment.setText(Number);  
      
      try {
            String selectedOptionDownPayment = (String) MortgageCalculatorDownPaymentCBox.getSelectedItem();
            double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
            double downpayment = Double.parseDouble( MortgateCalculatorDownPayment.getText());
            if (!Helper.validateInput(downpayment, hp, selectedOptionDownPayment)){
                if("%".equals(selectedOptionDownPayment)){
                    MortgateCalculatorDownPayment.setText("99");
                    JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 99%");
                }
                if("$".equals(selectedOptionDownPayment)){
                    double homeprice = hp-1;
                    String homepriceString = String.valueOf(homeprice);
                    MortgateCalculatorDownPayment.setText(homepriceString);
                    JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price (" + currencyFormat.format(hp) + ")");
                }
                
                        }
 


    } catch (NumberFormatException e) {
        // This block will execute if parsing fails, for example if input is "abc"
        JOptionPane.showMessageDialog(null, "Please enter valid value for Downpayment or Home Price");
}
      
   
      
    }//GEN-LAST:event_MortgateCalculatorDownPaymentKeyReleased

    private void MortgageCalculatorLoanTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorLoanTermKeyReleased
        String input =  MortgageCalculatorLoanTerm.getText(); 
        String strippedInput = input.replaceAll("\\s", "");
        MortgageCalculatorLoanTerm.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        MortgageCalculatorLoanTerm.setText(Number); 

    }//GEN-LAST:event_MortgageCalculatorLoanTermKeyReleased

    private void MortgageCalculatorInterestRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorInterestRateKeyReleased
        String input = MortgageCalculatorInterestRate.getText();
              // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
              // Set the text field with the stripped input (without spaces)
        MortgageCalculatorInterestRate.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MortgageCalculatorInterestRate.setText(Number); 
         
    }//GEN-LAST:event_MortgageCalculatorInterestRateKeyReleased

    private void MortgateCalculatorYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgateCalculatorYearKeyReleased
        String input = MortgateCalculatorYear.getText();
        String strippedInput = input.replaceAll("\\s", "");    
        MortgateCalculatorYear.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        MortgateCalculatorYear.setText(Number);

    }//GEN-LAST:event_MortgateCalculatorYearKeyReleased

    private void MortgageCalculatorPropertyTaxesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorPropertyTaxesKeyReleased

        try {
            String input = MortgageCalculatorPropertyTaxes.getText();
          // Strip all spaces from the input as the user types
            String strippedInput = input.replaceAll("\\s", "");
          // Set the text field with the stripped input (without spaces)
            MortgageCalculatorPropertyTaxes.setText(strippedInput);

            String Number = Helper.extractNumbers(input);
            MortgageCalculatorPropertyTaxes.setText(Number); 
            String selectedOptionDownPayment = (String) MortgageCalculatorPropertyTaxesCbox.getSelectedItem();
            double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
            double downpayment = Double.parseDouble( MortgageCalculatorPropertyTaxes.getText());
            if (!Helper.validateInput(downpayment, hp, selectedOptionDownPayment)){
                if("%".equals(selectedOptionDownPayment)){
                        MortgageCalculatorPropertyTaxes.setText("99");
                        JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 99%");
                    }
                if("$".equals(selectedOptionDownPayment)){
                    double homeprice = hp-1;
                    String homepriceString = String.valueOf(homeprice);
                    MortgageCalculatorPropertyTaxes.setText(homepriceString);
                    JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price (" + currencyFormat.format(hp) + ")");
                }
            }


        } catch (NumberFormatException e) {
            // This block will execute if parsing fails, for example if input is "abc"
            JOptionPane.showMessageDialog(null, "Please enter valid value for Property Tax or Home Price");
}
    }//GEN-LAST:event_MortgageCalculatorPropertyTaxesKeyReleased

    private void MortgageCalculatorHomeInsuranceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorHomeInsuranceKeyReleased

        try {
            String input = MortgageCalculatorHomeInsurance.getText();
              // Strip all spaces from the input as the user types
            String strippedInput = input.replaceAll("\\s", "");
            // Set the text field with the stripped input (without spaces)
            MortgageCalculatorHomeInsurance.setText(strippedInput);

            String Number = Helper.extractNumbers(input);
            MortgageCalculatorHomeInsurance.setText(Number);  
            
            String selectedOptionDownPayment = (String)MortgageCalculatorHomeInsuranceCBox.getSelectedItem();
            double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
            double downpayment = Double.parseDouble(MortgageCalculatorHomeInsurance.getText());
            if(!Helper.validateInput(downpayment, hp, selectedOptionDownPayment)){
                if("%".equals(selectedOptionDownPayment)){
                    MortgageCalculatorHomeInsurance.setText("99");
                    JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 99%");
                    }
                if("$".equals(selectedOptionDownPayment)){
                    double homeprice = hp-1;
                    String homepriceString = String.valueOf(homeprice);
                    MortgageCalculatorHomeInsurance.setText(homepriceString);
                    JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price (" + currencyFormat.format(hp) + ")");
                }
            }


        } catch (NumberFormatException e) {
            // This block will execute if parsing fails, for example if input is "abc"
            JOptionPane.showMessageDialog(null, "Please enter valid value for Home Insurance or Home Price");
}
    }//GEN-LAST:event_MortgageCalculatorHomeInsuranceKeyReleased

    private void MortgageCalculatorHOAFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorHOAFeeKeyReleased
 
        try {
        String input = MortgageCalculatorHOAFee.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MortgageCalculatorHOAFee.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MortgageCalculatorHOAFee.setText(Number);  
        
        String selectedOptionDownPayment = (String)MortgageCalculatorHoaFeeCBox.getSelectedItem();
        double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
        double downpayment = Double.parseDouble(MortgageCalculatorHOAFee.getText());
        if (!Helper.validateInput(downpayment, hp, selectedOptionDownPayment)){
            if("%".equals(selectedOptionDownPayment)){
                MortgageCalculatorHOAFee.setText("99");
                JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 99%");
                }
            if("$".equals(selectedOptionDownPayment)){
                double homeprice = hp-1;
                String homepriceString = String.valueOf(homeprice);
                MortgageCalculatorHOAFee.setText(homepriceString);
                JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price (" + currencyFormat.format(hp) + ")");
            }
        }


        } catch (NumberFormatException e) {
            // This block will execute if parsing fails, for example if input is "abc"
            JOptionPane.showMessageDialog(null, "Please enter valid value for HOA Fee or Home Price");
}
    }//GEN-LAST:event_MortgageCalculatorHOAFeeKeyReleased

    private void MortgageCalculatorOtherCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgageCalculatorOtherCostKeyReleased
    
        try {
            String input = MortgageCalculatorOtherCost.getText();
            // Strip all spaces from the input as the user types
            String strippedInput = input.replaceAll("\\s", "");
          // Set the text field with the stripped input (without spaces)
            MortgageCalculatorOtherCost.setText(strippedInput);
            String Number = Helper.extractNumbers(input);
            MortgageCalculatorOtherCost.setText(Number);
            
            String selectedOptionDownPayment = (String) MortgageCalculatorOtherCostCBox.getSelectedItem();
            double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
            double downpayment = Double.parseDouble(MortgageCalculatorOtherCost.getText());
            if(!Helper.validateInput(downpayment, hp, selectedOptionDownPayment)){
                if("%".equals(selectedOptionDownPayment)){
                    MortgageCalculatorOtherCost.setText("99");
                    JOptionPane.showMessageDialog(null, "Error: Percentage must be between 0 and 99%");
                    }
                if("$".equals(selectedOptionDownPayment)){
                    double homeprice = hp-1;
                    String homepriceString = String.valueOf(homeprice);
                    MortgageCalculatorOtherCost.setText(homepriceString);
                    JOptionPane.showMessageDialog(null, "Error: Dollar amount must be less than the house price (" + currencyFormat.format(hp) + ")");
                }
            }


        } catch (NumberFormatException e) {
            // This block will execute if parsing fails, for example if input is "abc"
            JOptionPane.showMessageDialog(null, "Please enter valid value for Other Cost or Home Price");
}
    }//GEN-LAST:event_MortgageCalculatorOtherCostKeyReleased

    private void MortgateCalculatorClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgateCalculatorClearBTNActionPerformed
       String strippedInput ="";
       MorgageCalculatorHomePrice.setText(strippedInput);
       MortgateCalculatorDownPayment.setText(strippedInput);
       MortgageCalculatorLoanTerm.setText(strippedInput);
       MortgageCalculatorInterestRate.setText(strippedInput);
       MortgateCalculatorYear.setText(strippedInput);
       MortgageCalculatorPropertyTaxes.setText(strippedInput);
       MortgageCalculatorHomeInsurance.setText(strippedInput);
       MortgageCalculatorHOAFee.setText(strippedInput);
       MortgageCalculatorOtherCost.setText(strippedInput);
       MortgageCalculatorIncudeTaxesandMOre.setSelected(false);
       hideComponentsMortgageCalculator();
       MortgageCalculatorOUtput.setText("");
    }//GEN-LAST:event_MortgateCalculatorClearBTNActionPerformed

    private void MortgageCalculatorIncudeTaxesandMOreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgageCalculatorIncudeTaxesandMOreActionPerformed
       if (MortgageCalculatorIncudeTaxesandMOre.isSelected()) {
        MortgageCalculatorPropertyTaxes.setVisible(true);
        MortgageCalculatorPropertyTaxesLabel.setVisible(true);
        MortgageCalculatorPropertyTaxesCbox.setVisible(true);
        
        MortgageCalculatorHomeInsurance.setVisible(true);
        MortgageCalculatorHomeInsuranceLabel.setVisible(true);
        MortgageCalculatorHomeInsuranceCBox.setVisible(true);
        
        MortgageCalculatorHOAFee.setVisible(true);
        MortgageCalculatorHoaFeeLabel.setVisible(true);
        MortgageCalculatorHoaFeeCBox.setVisible(true);
        
        MortgageCalculatorOtherCost.setVisible(true);
        MortgageCalculatorOtherCostLabel.setVisible(true);
        MortgageCalculatorOtherCostCBox.setVisible(true);
                
                
        } else {
       MortgageCalculatorPropertyTaxes.setText("0");
       MortgageCalculatorHomeInsurance.setText("0");
       MortgageCalculatorHOAFee.setText("0");
       MortgageCalculatorOtherCost.setText("0"); 
           
        MortgageCalculatorPropertyTaxes.setVisible(false);
        MortgageCalculatorPropertyTaxesLabel.setVisible(false);
        MortgageCalculatorPropertyTaxesCbox.setVisible(false);
        
        MortgageCalculatorHomeInsurance.setVisible(false);
        MortgageCalculatorHomeInsuranceLabel.setVisible(false);
        MortgageCalculatorHomeInsuranceCBox.setVisible(false);
        
        MortgageCalculatorHOAFee.setVisible(false);
        MortgageCalculatorHoaFeeLabel.setVisible(false);
        MortgageCalculatorHoaFeeCBox.setVisible(false);
        
        MortgageCalculatorOtherCost.setVisible(false);
        MortgageCalculatorOtherCostLabel.setVisible(false);
        MortgageCalculatorOtherCostCBox.setVisible(false);          
        }
    }//GEN-LAST:event_MortgageCalculatorIncudeTaxesandMOreActionPerformed

    private void MortgateCalculatorCaculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgateCalculatorCaculateBTNActionPerformed
      try{
      
            double hp = Double.parseDouble(MorgageCalculatorHomePrice.getText());
            double downpayment = Double.parseDouble( MortgateCalculatorDownPayment.getText());
            double dp = 0;
            int loanTerm = Integer.parseInt(MortgageCalculatorLoanTerm.getText());
            double rate = Double.parseDouble(MortgageCalculatorInterestRate.getText());
            String selectedOptionMonth = (String) MortgageCalculatorMonthCbox.getSelectedItem();  
            int startDate = Integer.parseInt(MortgateCalculatorYear.getText());
            double propertyTax = Double.parseDouble(MortgageCalculatorPropertyTaxes.getText());
            double propertyTaxes = 0;
            double homeInsuranceValue = Double.parseDouble(MortgageCalculatorHomeInsurance.getText());
            double homeInsurance = 0;
            double hoaFeeValue = Double.parseDouble( MortgageCalculatorHOAFee.getText());
            double hoaFee = 0;
            double otherCostAmount = Double.parseDouble(MortgageCalculatorOtherCost.getText());
            double otherCost = 0;




            String selectedOptionDownPayment = (String) MortgageCalculatorDownPaymentCBox.getSelectedItem();  
            if ("%".equals(selectedOptionDownPayment)) {
                dp = hp*(downpayment/100);             
            } 
            if ("$".equals(selectedOptionDownPayment)){
                dp = downpayment;       
             }

            String selectedOptionPropertyTaxes = (String)  MortgageCalculatorPropertyTaxesCbox.getSelectedItem();  
            if ("%".equals(selectedOptionPropertyTaxes)) {
                propertyTaxes = hp*(propertyTax/100);             
            } 
            if ("$".equals(selectedOptionPropertyTaxes)){
                propertyTaxes = propertyTax;       
             }

            String selectedOptionHomeInsurance = (String)   MortgageCalculatorHomeInsuranceCBox.getSelectedItem();  
            if ("%".equals(selectedOptionHomeInsurance)) {
                homeInsurance = hp*(homeInsuranceValue/100);             
            } 
            if ("$".equals(selectedOptionHomeInsurance)){
                homeInsurance = homeInsuranceValue;       
             }

            String selectedOptionHoaFee = (String) MortgageCalculatorHoaFeeCBox.getSelectedItem();  
            if ("%".equals(selectedOptionHoaFee)) {
                hoaFee= hp*(hoaFeeValue/100);             
            } 
            if ("$".equals(selectedOptionHoaFee)){
                hoaFee= hoaFeeValue;       
             }

            String selectedOptionOtherCost = (String) MortgageCalculatorOtherCostCBox.getSelectedItem();  
            if ("%".equals(selectedOptionOtherCost)) {
               otherCost= hp*(otherCostAmount/100);             
            } 
            if ("$".equals(selectedOptionOtherCost)){
                otherCost= otherCostAmount;       
             }



            String outputText="";
            if (MortgageCalculatorIncudeTaxesandMOre.isSelected()) {
                double[] mortgageResult = Helper.mortgageCalculator(hp, dp, loanTerm, rate, startDate, propertyTaxes, homeInsurance, hoaFee, otherCost);
                int endDate = startDate + loanTerm;
                outputText = "<html>"
                    +"<b>Monthly Payment:</b><br>"
                    + "Your monthly payment will be " + currencyFormat.format(mortgageResult[1]) + ".<br>"
                    + "Monthly Property Tax: " + currencyFormat.format(mortgageResult[2]) + "<br>"
                    + "Monthly Home Insurance: " + currencyFormat.format(mortgageResult[3]) + "<br>"
                    + "Monthly HOA Fee: " + currencyFormat.format(mortgageResult[4]) + "<br>"
                    + "Monthly Other Cost: " + currencyFormat.format(mortgageResult[5]) + "<br>"
                    + "Total Out-of-Pocket: " + currencyFormat.format(mortgageResult[9]) + "<br><br>"
                        
                    +"<b>Total Payment over " + loanTerm + " years:</b><br>"
                    + "Your total payment will be " + currencyFormat.format(mortgageResult[1] * loanTerm * 12) + ".<br>" // Multiply by loanTerm * 12 for total payment
                    + "Total Property Tax: " + currencyFormat.format(mortgageResult[2] * loanTerm * 12) + "<br>"
                    + "Total Home Insurance: " + currencyFormat.format(mortgageResult[3] * loanTerm * 12) + "<br>"
                    + "Total HOA Fee: " + currencyFormat.format(mortgageResult[4] * loanTerm * 12) + "<br>"
                    + "Total Other Cost: " + currencyFormat.format(mortgageResult[5] * loanTerm * 12) + "<br>"
                    + "Final Out-of-Pocket Expense: " + currencyFormat.format(mortgageResult[9] * loanTerm * 12) + "<br><br>"
                    + "Loan term start date: " + selectedOptionMonth + " " + startDate + "<br>"
                    + "Loan term end date: " + selectedOptionMonth + " " + endDate + "<br><br>"

                    + "<b>House Price:</b> " + currencyFormat.format(hp) + ".<br>"
                    + "Your down payment is " + currencyFormat.format(dp) + ".<br>"
                    + "Your loan amount is " + currencyFormat.format(mortgageResult[0]) + ".<br>"
                    + "Total Mortgage Payments over " + (12 * loanTerm) + " months: " + currencyFormat.format(mortgageResult[6]) + "<br>"
                    + "Total Interest Paid: " + currencyFormat.format(mortgageResult[7]) + "<br>"
                    +  "Mortgage Payoff Date: " +selectedOptionMonth+" "+ (int) mortgageResult[8]
                    + "</html>";
            }   
            else {
                double[] mortgageResult = Helper.mortgageCalculator(hp, dp, loanTerm, rate, startDate, propertyTaxes=0, homeInsurance=0, hoaFee=0, otherCost=0);
                outputText = "<html>"
                    +"<b>Monthly Payment:</b><br>"
                    + "Your monthly payment will be " + currencyFormat.format(mortgageResult[1]) + ".<br>"
                    + "Total Out-of-Pocket: " + currencyFormat.format(mortgageResult[9]) + "<br><br>"
                    
                    +"<b>Total Payment over " + loanTerm + " years:</b><br>"
                    + "Your total payment will be " + currencyFormat.format(mortgageResult[1] * loanTerm * 12) + ".<br>" // Total monthly payment over the loan term
                    + "Total Out-of-Pocket: " + currencyFormat.format(mortgageResult[9] * loanTerm * 12) + "<br><br>" 
                        

                    + "\"<b>House Price:</b> " + currencyFormat.format(hp) + ".<br>"
                    + "Your down payment is " + currencyFormat.format(dp) + ".<br>"
                    + "Your loan amount is " + currencyFormat.format(mortgageResult[0]) + ".<br>"
                    + "Total Mortgage Payments over " + (12 * loanTerm) + " months: " + currencyFormat.format(mortgageResult[6]) + "<br>"
                    + "Total Interest Paid: " + currencyFormat.format(mortgageResult[7]) + "<br>"
                    +  "Mortgage Payoff Date: " +selectedOptionMonth+" "+ (int) mortgageResult[8]
                    + "</html>";
                    
            }

            MortgageCalculatorOUtput.setText(outputText);
                }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Empty fields!");MortgageCalculatorOUtput.setText("Error404");
        }
    }//GEN-LAST:event_MortgateCalculatorCaculateBTNActionPerformed
//---------------------------------------------------------------------------------------------------------------------------------------------------------------Mortgage Payoff Calculator Pedro 
    private void MortgagepayoffCalculatorOriginalLoanAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgagepayoffCalculatorOriginalLoanAmountKeyReleased
       
        String input = MortgagepayoffCalculatorOriginalLoanAmount.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MortgagepayoffCalculatorOriginalLoanAmount.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MortgagepayoffCalculatorOriginalLoanAmount.setText(Number);     
    }//GEN-LAST:event_MortgagepayoffCalculatorOriginalLoanAmountKeyReleased

    private void MortgagePayoffOriginalLoanTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortgagePayoffOriginalLoanTermKeyReleased

        String input = MortgagePayoffOriginalLoanTerm.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MortgagePayoffOriginalLoanTerm.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        MortgagePayoffOriginalLoanTerm.setText(Number);  
    }//GEN-LAST:event_MortgagePayoffOriginalLoanTermKeyReleased

    private void MorgagePayoffCalculatorInterestRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MorgagePayoffCalculatorInterestRateKeyReleased
        String input = MorgagePayoffCalculatorInterestRate.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MorgagePayoffCalculatorInterestRate.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MorgagePayoffCalculatorInterestRate.setText(Number); 
           
    }//GEN-LAST:event_MorgagePayoffCalculatorInterestRateKeyReleased

    private void MortGagePayoffRemainingTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortGagePayoffRemainingTermKeyReleased
        String input = MortGagePayoffRemainingTerm.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MortGagePayoffRemainingTerm.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        MortGagePayoffRemainingTerm.setText(Number);
    }//GEN-LAST:event_MortGagePayoffRemainingTermKeyReleased

    private void MortgagePayoffPayAlltogetherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayoffPayAlltogetherActionPerformed
   
        if (MortgagePayoffPayAlltogether.isSelected()) {
        // If selected, uncheck InterestRateEnd
            MortgagePayoffPayAlltogether.setSelected(true); 
            MortgagePayoffRepaymentWithExtraPayments.setSelected(false);
            MortgagePayoffBiweeklyRepayment.setSelected(false);
            MortgagePayoffCalculatorNormalPayment.setSelected(false);
            hideComponents();} 
        
    

    }//GEN-LAST:event_MortgagePayoffPayAlltogetherActionPerformed

    private void MortgagePayoffRepaymentWithExtraPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayoffRepaymentWithExtraPaymentsActionPerformed
     if (MortgagePayoffRepaymentWithExtraPayments.isSelected()) {
        MortgagePayoffPayAlltogether.setSelected(false); 
        MortgagePayoffRepaymentWithExtraPayments.setEnabled(true);
        MortgagePayoffBiweeklyRepayment.setSelected(false);
        MortgagePayoffCalculatorNormalPayment.setSelected(false);

        MorgagePayoffRePayementExtraMonth.setText("0");
        MorgagePayoffRePayementExtraYear.setText("0");
        MorgagePayoffRePayementExtraOneTime.setText("0");
        setVisibilityTrue();} 

    }//GEN-LAST:event_MortgagePayoffRepaymentWithExtraPaymentsActionPerformed

    private void MortgagePayoffBiweeklyRepaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayoffBiweeklyRepaymentActionPerformed
        if (MortgagePayoffBiweeklyRepayment.isSelected()) {
            MortgagePayoffPayAlltogether.setSelected(false); 
            MortgagePayoffRepaymentWithExtraPayments.setSelected(false);
            MortgagePayoffBiweeklyRepayment.setSelected(true);
            MortgagePayoffCalculatorNormalPayment.setSelected(false);
            hideComponents();
           } 
        
    }//GEN-LAST:event_MortgagePayoffBiweeklyRepaymentActionPerformed

    private void MortgagePayoffCalculatorNormalPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayoffCalculatorNormalPaymentActionPerformed
        if (MortgagePayoffCalculatorNormalPayment.isSelected()) {
            MortgagePayoffPayAlltogether.setSelected(false); 
            MortgagePayoffRepaymentWithExtraPayments.setSelected(false);
            MortgagePayoffBiweeklyRepayment.setSelected(false);
            MortgagePayoffCalculatorNormalPayment.setSelected(true);
            hideComponents();
               } 

    }//GEN-LAST:event_MortgagePayoffCalculatorNormalPaymentActionPerformed

    private void MortgagePayOffClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayOffClearBTNActionPerformed
        MortgagepayoffCalculatorOriginalLoanAmount.setText("");
        MortgagePayoffOriginalLoanTerm.setText("");
        MorgagePayoffCalculatorInterestRate.setText("");
        MortGagePayoffRemainingTerm.setText("");
        MortGagePayoffRemainingTermMonths.setText("");
        
        hideComponents();
        MortgagePayoffPayAlltogether.setSelected(false); 
        MortgagePayoffRepaymentWithExtraPayments.setSelected(false);
        MortgagePayoffBiweeklyRepayment.setSelected(false);
        MortgagePayoffCalculatorNormalPayment.setSelected(true);
    }//GEN-LAST:event_MortgagePayOffClearBTNActionPerformed

    private void MortgagePayoffCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MortgagePayoffCalculateBTNActionPerformed

        try{
            double originalLoanAmount = Double.parseDouble(MortgagepayoffCalculatorOriginalLoanAmount.getText());
            int originalLoanTerm = Integer.parseInt(MortgagePayoffOriginalLoanTerm.getText());
            double interestRate =Double.parseDouble( MorgagePayoffCalculatorInterestRate.getText());
            int remainingTerm = Integer.parseInt(MortGagePayoffRemainingTerm.getText());
            int months =Integer.parseInt(MortGagePayoffRemainingTermMonths.getText());
            double morgagePayoffRemainingBalance =0;

            String outputText="";
            if (MortgagePayoffPayAlltogether.isSelected()) {

                double[] mortgagePayoff = Helper.mortgagePayoffCalculator(originalLoanAmount, originalLoanTerm, interestRate, remainingTerm, months);

                outputText = "<html>"
                                  + "<b>If Payoff Together:</b><br>"
                                  + "Total Payment: " + currencyFormat.format(mortgagePayoff[0]) + "<br>"
                                  + "Total Interest: " + currencyFormat.format(mortgagePayoff[1]) + "<br><br>"
                                  + "<b>Normal Repayment:</b><br>"
                                  + "Monthly Pay: " + currencyFormat.format(mortgagePayoff[2]) + "<br>"
                                  + "Total Payment on Original Schedule: " + currencyFormat.format(mortgagePayoff[3]) + "<br>"
                                  + "Total Interest on Original Schedule: " + currencyFormat.format(mortgagePayoff[4]) + "<br>"
                                  + "Remaining Balance: $" + currencyFormat.format(mortgagePayoff[5]) + "<br>"
                                  + "Remaining Interest Savings: " + currencyFormat.format(mortgagePayoff[6]) + "<br>"
                                  + "Remaining Balance to Pay Off Loan: " + currencyFormat.format(mortgagePayoff[7]) + "<br>"
                                  + "</html>";} 

            if (MortgagePayoffCalculatorNormalPayment.isSelected()) {

                double[] mortgagePayoff = Helper.mortgagePayoffCalculator(originalLoanAmount, originalLoanTerm, interestRate, remainingTerm, months);
                morgagePayoffRemainingBalance = mortgagePayoff[5];

                outputText = "<html>"

                                  + "<b>Normal Repayment:</b><br>"
                                  + "Monthly Pay: " + currencyFormat.format(mortgagePayoff[2]) + "<br>"
                                  + "Total Payment on Original Schedule: " + currencyFormat.format(mortgagePayoff[3]) + "<br>"
                                  + "Total Interest on Original Schedule: " + currencyFormat.format(mortgagePayoff[4]) + "<br>"
                                  + "Remaining Balance: " + currencyFormat.format(mortgagePayoff[5]) + "<br>"
                                  + "Remaining Interest Savings: " + currencyFormat.format(mortgagePayoff[6]) + "<br>"
                                  + "Remaining Balance to Pay Off Loan: " + currencyFormat.format(mortgagePayoff[7]) + "<br>"
                        
                                  + "</html>";} 
            
            
            if (MortgagePayoffBiweeklyRepayment.isSelected()) {
                double currentLoan = originalLoanAmount;
                int originalTime = originalLoanTerm;
                double interest = interestRate;
                int oTimeLeftYears = remainingTerm;
                int oTimeLeftMonths = months;

                String[] results = Helper.mortgagePayoffByweekly(currentLoan, originalTime, oTimeLeftYears, oTimeLeftMonths, interest);
                double[] mortgagePayoff = Helper.mortgagePayoffCalculator(originalLoanAmount, originalLoanTerm, interestRate, remainingTerm, months);
                morgagePayoffRemainingBalance = mortgagePayoff[5];
                

                for (String summary : results) {
                    System.out.println(summary);
                }
                outputText = "<html>"
                     + "By making biweekly payments of <b>"+currencyFormat.format(Double.parseDouble(results[2]))+"</b> starting now, <br>"
                     +"the loan will be fully paid off in <b>"+results[0]+" years and "+results[1]+" months</b>,<br>"
                     + "which is <b>"+results[3]+"</b> than the original schedule.<br>"
                     + "This adjustment results in an interest savings of <b>"+currencyFormat.format(Double.parseDouble(results[4]))+"</b>." 
                        
                        
                        + "<body style='font-family: Arial; font-size: 14px;'>"
                        + "<table border='1' cellspacing='0' cellpadding='8' style='border-collapse: collapse; width: 100%; text-align: center;'>"
                        + "<thead style='background-color: #004080; color: white;'>"
                        + "<tr>"
                        + "<th></th>"
                        + "<th>Original</th>"
                        + "<th>With payoff</th>"
                        + "</tr>"
                        + "</thead>"
                        + "<tbody>"
                        + "<tr>"
                        + "<td>Total payments</td>"
                        + "<td>$"+results[5] +"</td>"
                        + "<td>$"+results[12]+"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Total interest</td>"
                        + "<td>$"+results[6] +"</td>"
                        + "<td>$"+results[13] +"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Remaining payments</td>"
                        + "<td>$"+results[7] +"</td>"
                        + "<td>$"+results[14] +"</td>"
                        + "</tr>"
                        + "<td>Remaining interest</td>"
                        + "<td>$"+results[8] +"</td>"
                        + "<td>$"+results[15] +"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Payoff in</td>"
                        + "<td>"+results[10] +" years and " +results[11]+ " months</td>"
                        + "<td>"+results[16] +"</td>"
                        + "</tr>"
                        + "</tbody>"
                        + "</table>"
                        + "</body>"

                  + "</html>";
            
            } 
                
                    
                    
            if (MortgagePayoffRepaymentWithExtraPayments.isSelected()) {
                if (MorgagePayoffRePayementExtraMonth.getText().trim().isEmpty()) {
            // Set it to "0"
                    MorgagePayoffRePayementExtraMonth.setText("0");
                }
                if (MorgagePayoffRePayementExtraYear.getText().trim().isEmpty()) {
            // Set it to "0"
                    MorgagePayoffRePayementExtraYear.setText("0");
                }
                if (MorgagePayoffRePayementExtraOneTime.getText().trim().isEmpty()) {
            // Set it to "0"
                    MorgagePayoffRePayementExtraOneTime.setText("0");
                }
double extra_monthly = Double.parseDouble(MorgagePayoffRePayementExtraMonth.getText());
                double extra_yearly = Double.parseDouble(MorgagePayoffRePayementExtraYear.getText());
                double extra_once = Double.parseDouble(MorgagePayoffRePayementExtraOneTime.getText());
                double currentLoan = originalLoanAmount;
                int originalTime = originalLoanTerm;
                int oTimeLeftYears = remainingTerm;
                int oTimeLeftMonths = months;
                double interest = interestRate;
                double perMonth = extra_monthly;
                double perYear = extra_yearly;
                double oneTime = extra_once;

                
                String[] results = Helper.mortgagePayoffCustom(currentLoan, originalTime, oTimeLeftYears, oTimeLeftMonths,
                        interest, perMonth, perYear, oneTime);
                double[] mortgagePayoff = Helper.mortgagePayoffCalculator(originalLoanAmount, originalLoanTerm, interestRate, remainingTerm, months);
                morgagePayoffRemainingBalance = mortgagePayoff[5];

                    // Print results
                    for (String result : results) {
                        System.out.println(result);
                    }
                    outputText = "<html>"
                     + "By making extra monthly payments of <b>"+currencyFormat.format(Double.parseDouble(results[2]))+"</b>,<br> extra yearly payments of <b>"+currencyFormat.format(Double.parseDouble(results[3]))+"</b>,<br> and a one-time payment of <b>"+currencyFormat.format(Double.parseDouble(results[4]))+ "</b> starting now, <br>"
                     +"the loan will be fully paid off in <b>"+results[12]+"</b>,<br>"
                     + "which is <b>"+results[6]+"</b> than the original schedule.<br>"
                     + "This adjustment results in an interest savings of <b>"+currencyFormat.format(Double.parseDouble(results[7]))+"</b>." 
                        
                        
                        + "<body style='font-family: Arial; font-size: 14px;'>"
                        + "<table border='1' cellspacing='0' cellpadding='8' style='border-collapse: collapse; width: 100%; text-align: center;'>"
                        + "<thead style='background-color: #004080; color: white;'>"
                        + "<tr>"
                        + "<th></th>"
                        + "<th>Original</th>"
                        + "<th>With payoff</th>"
                        + "</tr>"
                        + "</thead>"
                        + "<tbody>"
                        + "<tr>"
                        + "<td>Total payments</td>"
                        + "<td>$"+results[13] +"</td>"
                        + "<td>$"+results[8]+"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Total interest</td>"
                        + "<td>$"+results[14] +"</td>"
                        + "<td>$"+results[9] +"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Remaining payments</td>"
                        + "<td>$"+results[15] +"</td>"
                        + "<td>$"+results[10] +"</td>"
                        + "</tr>"
                        + "<td>Remaining interest</td>"
                        + "<td>$"+results[16] +"</td>"
                        + "<td>$"+results[11] +"</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Payoff in</td>"
                        + "<td>"+results[17]+ " </td>"
                        + "<td>"+results[12] +"</td>"
                        + "</tr>"
                        + "</tbody>"
                        + "</table>"
                        + "</body>"

                  + "</html>";
            }  
                    
            MortgagePayoffOutput.setText(outputText);}
        catch(Exception e){JOptionPane.showMessageDialog(null, "Empty fields!");MortgagePayoffOutput.setText("Error404");}
        


        
    }//GEN-LAST:event_MortgagePayoffCalculateBTNActionPerformed

        
   private void hideComponents() {
        MorgagePayoffRePayementExtraMonth.setText("0");
        MorgagePayoffRePayementExtraYear.setText("0");
        MorgagePayoffRePayementExtraOneTime.setText("0");
        MortGagePayoffRemainingTermMonths.setText("0");
        // Text boxes
        MorgagePayoffRePayementExtraMonth.setVisible(false);
        MorgagePayoffRePayementExtraYear.setVisible(false);
        MorgagePayoffRePayementExtraOneTime.setVisible(false);

        // Labels
        MorgagePayoffRePayementExtraMonthLabel.setVisible(false);
        MorgagePayoffRePayementExtraYearlabel.setVisible(false);
        MorgagePayoffRePayementExtraOneTimeLabel.setVisible(false);
        MorgagePayoffRePayementExtraMonthLabel12.setVisible(false);
        MorgagePayoffRePayementExtraYearlabel2.setVisible(false);
        MorgagePayoffRePayementExtraOneTimeLabel2.setVisible(false);
    } 
   
   public void setVisibilityTrue() {
        // Text boxes
        MorgagePayoffRePayementExtraMonth.setVisible(true);
        MorgagePayoffRePayementExtraYear.setVisible(true);
        MorgagePayoffRePayementExtraOneTime.setVisible(true);

        // Labels
        MorgagePayoffRePayementExtraMonthLabel.setVisible(true);
        MorgagePayoffRePayementExtraYearlabel.setVisible(true);
        MorgagePayoffRePayementExtraOneTimeLabel.setVisible(true);
        MorgagePayoffRePayementExtraMonthLabel12.setVisible(true);
        MorgagePayoffRePayementExtraYearlabel2.setVisible(true);
        MorgagePayoffRePayementExtraOneTimeLabel2.setVisible(true);
    }
   

    
    
    
    private void MortGagePayoffRemainingTermMonthsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MortGagePayoffRemainingTermMonthsKeyReleased
        String input = MortGagePayoffRemainingTermMonths.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MortGagePayoffRemainingTermMonths.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        MortGagePayoffRemainingTermMonths.setText(Number);
        int months = Integer.parseInt(Number);

    // Check if the number of months is within the valid range
    if (months >= 0 && months <= 11) {
    } else {
      
        JOptionPane.showMessageDialog(null,"Invalid number of months. Please enter a value between 0 and 11.");
        MortGagePayoffRemainingTermMonths.setText("0");   
    }
    }//GEN-LAST:event_MortGagePayoffRemainingTermMonthsKeyReleased
   //-------------------------------------------------------------------------------------------------------------------------------Retirement Calculator Pedro
    private void RetirementCalculatorClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirementCalculatorClearBTNActionPerformed
        RetirementCalculatorCurrentAge.setText("");
        RetirementCalculatorRetirementAge.setText("");
        RetirementCalculatorLifeExpectancy.setText("");
        RetirementCalculatorPreTaxIncome.setText("");
        RetirementCalculatorIncomeNeededAfterRetirement.setText("");
        RetirementCalculatorAverageInvestmentReturn.setText("0");
        RetirementCalculatorOtherIncomeAfterRetirement.setText("0");
        RetirementCalculatorYourCurrentRetirementSavings.setText("0");
        RetirementCalculatorOutput.setText("");
    }//GEN-LAST:event_RetirementCalculatorClearBTNActionPerformed

    private void RetirementCalculatorCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirementCalculatorCalculateBTNActionPerformed
        try{
            boolean check = false;
            double AgeRetiremtn =Double.parseDouble(RetirementCalculatorRetirementAge.getText());
            double lifeExpectancyage =Double.parseDouble(RetirementCalculatorLifeExpectancy.getText());
            if(AgeRetiremtn<=lifeExpectancyage){
                check = true;
            }
            else{check=false;JOptionPane.showMessageDialog(null, "Your life expectancy age must be greater than or equal your retirement age");
            }
            
            if(Helper.validateAges(RetirementCalculatorCurrentAge.getText(), RetirementCalculatorRetirementAge.getText()) && check){              

                if (RetirementCalculatorAverageInvestmentReturn.getText().trim().isEmpty()) {
                RetirementCalculatorAverageInvestmentReturn.setText("0");
                }
                if (RetirementCalculatorOtherIncomeAfterRetirement.getText().trim().isEmpty()) {
                RetirementCalculatorOtherIncomeAfterRetirement.setText("0");
                }
                if (RetirementCalculatorYourCurrentRetirementSavings.getText().trim().isEmpty()) {
                RetirementCalculatorYourCurrentRetirementSavings.setText("0");
                }
                int cAge = Integer.parseInt(RetirementCalculatorCurrentAge.getText());
                int rAge = Integer.parseInt(RetirementCalculatorRetirementAge.getText());
                int lifeExpectancy = Integer.parseInt(RetirementCalculatorLifeExpectancy.getText());
                double preTaxIncome =Double.parseDouble(RetirementCalculatorPreTaxIncome.getText());
                double incomeNeededAfterRetirement =Double.parseDouble(RetirementCalculatorIncomeNeededAfterRetirement.getText());
                double returnInvestmentRate = Double.parseDouble(RetirementCalculatorAverageInvestmentReturn.getText());

                double otherIncomeAfterRetirement = Double.parseDouble(RetirementCalculatorOtherIncomeAfterRetirement.getText());
                double currentIncomeSaving = Double.parseDouble(RetirementCalculatorYourCurrentRetirementSavings.getText());

                 double incomeNeededAfterRetirement2 =  0;

                String selectedOptionRetirementCalculator = (String) RetirementCalculatorNeededAfterRetirementCbox.getSelectedItem();  
                if ("%".equals(selectedOptionRetirementCalculator)) {
                    incomeNeededAfterRetirement = preTaxIncome * (incomeNeededAfterRetirement/100);
                    incomeNeededAfterRetirement2 =incomeNeededAfterRetirement;
                } 
                if ("$".equals(selectedOptionRetirementCalculator)){
                    incomeNeededAfterRetirement = incomeNeededAfterRetirement; 
                    incomeNeededAfterRetirement2=incomeNeededAfterRetirement;
                 }


                if (otherIncomeAfterRetirement == 0) {
                    incomeNeededAfterRetirement = incomeNeededAfterRetirement;
                } else {
                    incomeNeededAfterRetirement = incomeNeededAfterRetirement - (otherIncomeAfterRetirement * 12);
                }


                String outputText = "";

                if (incomeNeededAfterRetirement2>otherIncomeAfterRetirement){
                    if (returnInvestmentRate > 0) {
                        double[] retirementCalculator1= Helper.retirementCalculator(cAge, rAge, lifeExpectancy, preTaxIncome, incomeNeededAfterRetirement, returnInvestmentRate, currentIncomeSaving);
                        double[] retirementCalculator2 = Helper.fixedRetirementCalculator(cAge, rAge, lifeExpectancy, preTaxIncome, incomeNeededAfterRetirement, currentIncomeSaving);
                        String retirement_savingMsg = "";
                        if(currentIncomeSaving ==0){
                            retirement_savingMsg = "";
                        }
                        else{
                            if (retirementCalculator1[4] < retirementCalculator1[0]) {
                                retirement_savingMsg = "<html>"
                                        +"Based on your current retirement savings, you will have about " + currencyFormat.format(retirementCalculator1[4])
                                            + " at age " + rAge + ", which is less than what you need for your retirement.<br>"
                                                + "</html>";
                            } else {
                               retirement_savingMsg = "<html>"
                                       +"Based on your current retirement savings, you will have about " + currencyFormat.format(retirementCalculator1[4])
                                            + " at age " + rAge + ", which exceeds what you need for your retirement.<br>"
                                       + "</html>";
                            }
                        }
                        


                        String otherIncomeMsg = "";
                        if(retirementCalculator1[0]<0){
                            otherIncomeMsg  ="You don't need to save for your retirement!";
                        }
                        else if (otherIncomeAfterRetirement>0){
                           otherIncomeMsg =  "<html>"


                                + "If saved " + currencyFormat.format(retirementCalculator1[0]) + ", you can withdraw " 
                                + currencyFormat.format(retirementCalculator2[1]) 
                                + " per month after your retirement. Together with your other income of " + currencyFormat.format(otherIncomeAfterRetirement)+" per month,<br>"
                                + "you will have an income " + currencyFormat.format(retirementCalculator2[1]+ otherIncomeAfterRetirement) +" per month after your retirement"
                                + "</html>";
                        }else{
                            otherIncomeMsg =  "<html>"
                                + "If saved " + currencyFormat.format(retirementCalculator1[0]) + ", you can withdraw " 
                                + currencyFormat.format(retirementCalculator2[1]) 
                                + " per month after your retirement."
                                + "</html>";

                        }

                        if(retirementCalculator1[0]<0){
                            outputText = "<html>"
                                + "You don't need to save for your retirement!<br>"
                                + "Your other income after retirement is sufficient "
                                + "to support your desired lifestyle after retirement."
                                + "</html>";
                          
                        }
                        else if (retirementCalculator1[0]>= retirementCalculator1[4]){


                            outputText = "<html>"
                                + "If you are planning to withdraw "+currencyFormat.format(incomeNeededAfterRetirement2)+ " or " + (incomeNeededAfterRetirement2/preTaxIncome)*100 +"% of your income<br>"
                                +"after your retirement, then you will need about "+ currencyFormat.format(retirementCalculator1[0])+ " before you retire. <br><br>"
                                + "To save " + currencyFormat.format(retirementCalculator1[0]) + " at age " + rAge + ", you can either:<br>"
                                + "<ul>"
                                + "    <li>Save " + currencyFormat.format(retirementCalculator1[1]) + " per month</li>"
                                + "    <li>Save " + currencyFormat.format(retirementCalculator1[2]) + " per year</li>"
                                + "    <li>Save " + retirementCalculator1[3] + "% of your income every year</li>"
                                + "</ul>"
                                + "<br>"
                                + retirement_savingMsg + "<br><br>"
                                + otherIncomeMsg
                                + "</html>";
                        }
                        else{

                            outputText = "<html>"
                                + "If you are planning to withdraw "+currencyFormat.format(incomeNeededAfterRetirement2)+ " or " + (incomeNeededAfterRetirement2/preTaxIncome)*100 +"% of your income<br>"
                                +"after your retirement, then you will need about "+ currencyFormat.format(retirementCalculator1[0])+ " before you retire. <br><br>"

                                + "<br>"
                                + retirement_savingMsg + "<br><br>"

                                + "</html>";}



                    } else {
                        double[] retirementCalculator1 = Helper.fixedRetirementCalculator(cAge, rAge, lifeExpectancy, preTaxIncome, incomeNeededAfterRetirement, currentIncomeSaving);
                        outputText = "<html>"
                                + "You will need about " + currencyFormat.format(retirementCalculator1[0]) + " at age " + rAge + " to retire.<br>"
                                + "If you save " + currencyFormat.format(retirementCalculator1[0]) + ", you can withdraw " + currencyFormat.format(retirementCalculator1[1]) + " per month after your retirement.<br><br>"
                                + "How can you save " + currencyFormat.format(retirementCalculator1[0]) + " at age " + rAge + "?<br>"
                                + "To save " + currencyFormat.format(retirementCalculator1[0]) + " at age " + rAge + ", you can either:<br>"
                                + "<ul>"
                                + "    <li>Save " + currencyFormat.format(retirementCalculator1[2]) + " per month</li>"
                                + "    <li>Save " + currencyFormat.format(retirementCalculator1[3]) + " per year</li>"
                                + "    <li>Save " + retirementCalculator1[4] + "% of your income every year</li>"
                                + "</ul>"
                                + "</html>";

                    }


                }else {
                    outputText = "<html>"
                                + "You do not need to save for you retirement!<br>"
                                + "Your other income after retirement is sufficient to <br>"
                                + "support you desired lifestyle after retirement.<br>"

                                + "</html>";


                }

                RetirementCalculatorOutput.setText(outputText);
            }
            else {RetirementCalculatorOutput.setText("Error404");}
        
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "Empty fields!");RetirementCalculatorOutput.setText("Error404");}
                                                                   

    }//GEN-LAST:event_RetirementCalculatorCalculateBTNActionPerformed

        public void DefaultRetirementCalculator(){

        RetirementCalculatorAverageInvestmentReturn.setText("0");
        RetirementCalculatorOtherIncomeAfterRetirement.setText("0");
        RetirementCalculatorYourCurrentRetirementSavings.setText("0");
    
    }
        
        
        //----------------------------------------------------------------------------------------------------------------------------Label- Display Name of the Calculator when is click 
    private void MortgagePayoffCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MortgagePayoffCalculatorAncestorAdded
        CalculatorNameLBL.setText("Mortgage Payoff Calculator");
    }//GEN-LAST:event_MortgagePayoffCalculatorAncestorAdded

    private void MortgageCalculator2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_MortgageCalculator2AncestorAdded
        CalculatorNameLBL.setText("Mortgage Calculator");
    }//GEN-LAST:event_MortgageCalculator2AncestorAdded

    private void HouseAffordabilityCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HouseAffordabilityCalculatorAncestorAdded
        CalculatorNameLBL.setText("House Affordability Calculator");
    }//GEN-LAST:event_HouseAffordabilityCalculatorAncestorAdded

    private void RentCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_RentCalculatorAncestorAdded
        CalculatorNameLBL.setText("Rent Calculator");
    }//GEN-LAST:event_RentCalculatorAncestorAdded

    private void RefinanceCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_RefinanceCalculatorAncestorAdded
        CalculatorNameLBL.setText("Refinance Calculator");
    }//GEN-LAST:event_RefinanceCalculatorAncestorAdded

    private void downpaymentCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_downpaymentCalculatorAncestorAdded
        CalculatorNameLBL.setText("Down Payment Calculator");
    }//GEN-LAST:event_downpaymentCalculatorAncestorAdded

    private void rentandbuyAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_rentandbuyAncestorAdded
        CalculatorNameLBL.setText("Rent vs Buy Calculator");
    }//GEN-LAST:event_rentandbuyAncestorAdded

    private void RothIRACalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_RothIRACalculatorAncestorAdded
        CalculatorNameLBL.setText("Roth IRA Calculator");
    }//GEN-LAST:event_RothIRACalculatorAncestorAdded

    private void retirementCalculator3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_retirementCalculator3AncestorAdded
        CalculatorNameLBL.setText("Retirement Calculator");
    }//GEN-LAST:event_retirementCalculator3AncestorAdded
//----------------------------------------------------------------------------------------------------------------------------------COntinuation of the Retirement Calculator Pedro
    private void RetirementCalculatorCurrentAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorCurrentAgeKeyReleased
        String input = RetirementCalculatorCurrentAge.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorCurrentAge.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RetirementCalculatorCurrentAge.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorCurrentAgeKeyReleased

    private void RetirementCalculatorRetirementAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorRetirementAgeKeyReleased
        String input = RetirementCalculatorRetirementAge.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorRetirementAge.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RetirementCalculatorRetirementAge.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorRetirementAgeKeyReleased

    private void RetirementCalculatorLifeExpectancyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorLifeExpectancyKeyReleased
        String input = RetirementCalculatorLifeExpectancy.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorLifeExpectancy.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RetirementCalculatorLifeExpectancy.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorLifeExpectancyKeyReleased

    private void RetirementCalculatorPreTaxIncomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorPreTaxIncomeKeyReleased
        String input = RetirementCalculatorPreTaxIncome.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorPreTaxIncome.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RetirementCalculatorPreTaxIncome.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorPreTaxIncomeKeyReleased

    private void RetirementCalculatorIncomeNeededAfterRetirementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorIncomeNeededAfterRetirementKeyReleased
        String input = RetirementCalculatorIncomeNeededAfterRetirement.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorIncomeNeededAfterRetirement.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RetirementCalculatorIncomeNeededAfterRetirement.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorIncomeNeededAfterRetirementKeyReleased

    private void RetirementCalculatorAverageInvestmentReturnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorAverageInvestmentReturnKeyReleased
        String input = RetirementCalculatorAverageInvestmentReturn.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorAverageInvestmentReturn.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RetirementCalculatorAverageInvestmentReturn.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorAverageInvestmentReturnKeyReleased

    private void RetirementCalculatorOtherIncomeAfterRetirementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorOtherIncomeAfterRetirementKeyReleased
        String input =  RetirementCalculatorOtherIncomeAfterRetirement.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
         RetirementCalculatorOtherIncomeAfterRetirement.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
         RetirementCalculatorOtherIncomeAfterRetirement.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorOtherIncomeAfterRetirementKeyReleased

    private void RetirementCalculatorYourCurrentRetirementSavingsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RetirementCalculatorYourCurrentRetirementSavingsKeyReleased
        String input =  RetirementCalculatorYourCurrentRetirementSavings.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RetirementCalculatorYourCurrentRetirementSavings.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RetirementCalculatorYourCurrentRetirementSavings.setText(Number);
    }//GEN-LAST:event_RetirementCalculatorYourCurrentRetirementSavingsKeyReleased

    
    //--------------------------------------------------------------------------------------------------------------------------------Refinance Calculator
    private void RefinanceCalculatorMonthsPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefinanceCalculatorMonthsPaymentActionPerformed
        
    }//GEN-LAST:event_RefinanceCalculatorMonthsPaymentActionPerformed

    private void RefinanceCalculatorCurrentLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefinanceCalculatorCurrentLoanActionPerformed
       String selectedItem = (String) RefinanceCalculatorCurrentLoan.getSelectedItem();

    // Toggle visibility based on selection
    if ("I know the orginal loan amount".equals(selectedItem)) {
        RefinanceCalculatorMonthsPayment.setVisible(true);
        RefinanceCalculatorYearsandMonth.setVisible(true);
        RefinanceCalculatorLoanTerm.setVisible(true);
        RefinanceCalculatorLoanTermtext.setVisible(true);
        
        RefinanceCalculatorRemainingBalanceLabel.setText("Original loan amount $");
        RefinanceCalculatorLoanTerm.setText("Loan term (Years)");
    
        RefinanceCalculatorMonthlyPaymentLbl.setText("Time remaining");
        InstructionsRefinanceCalculator.setText("");
        setMessage112();
 
    } else {
        refinanceCalculatorShowUp();
        RefinanceCalculatorRemainingBalanceLabel.setText("Remaining Balance $");
  
    
        RefinanceCalculatorMonthlyPaymentLbl.setText("Monthly Payment $");
        InstructionsRefinanceCalculator.setText("");
        setMessage11();
       
    }
    
    }//GEN-LAST:event_RefinanceCalculatorCurrentLoanActionPerformed
        public void refinanceCalculatorShowUp(){

        RefinanceCalculatorMonthsPayment.setVisible(false);
        RefinanceCalculatorYearsandMonth.setVisible(false);
        RefinanceCalculatorLoanTerm.setVisible(false);
        RefinanceCalculatorLoanTermtext.setVisible(false);
        RefinanceCalculatorMonthsPayment.setText("0");
    }

    private void RefinanceCalculatorLoanTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorLoanTermKeyReleased
        String input = RefinanceCalculatorLoanTerm.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorLoanTerm.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorLoanTerm.setText(Number); 
    }//GEN-LAST:event_RefinanceCalculatorLoanTermKeyReleased

    private void RefinanceCalculatorRemainingBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorRemainingBalanceKeyReleased
        String input = RefinanceCalculatorRemainingBalance.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorRemainingBalance.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorRemainingBalance.setText(Number); 
    }//GEN-LAST:event_RefinanceCalculatorRemainingBalanceKeyReleased

    private void RefinanceCalculatorLoanTermtextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorLoanTermtextKeyReleased
         String input = RefinanceCalculatorLoanTermtext.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorLoanTermtext.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RefinanceCalculatorLoanTermtext.setText(Number); 
    }//GEN-LAST:event_RefinanceCalculatorLoanTermtextKeyReleased

    private void RefinanceCalculatorYearsPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorYearsPaymentKeyReleased
         String input = RefinanceCalculatorYearsPayment.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorYearsPayment.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RefinanceCalculatorYearsPayment.setText(Number); 
    }//GEN-LAST:event_RefinanceCalculatorYearsPaymentKeyReleased

    private void RefinanceCalculatorMonthsPaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorMonthsPaymentKeyReleased
         String input = RefinanceCalculatorMonthsPayment.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorMonthsPayment.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RefinanceCalculatorMonthsPayment.setText(Number);
        int months = Integer.parseInt(Number);

    // Check if the number of months is within the valid range
        if (months >= 0 && months <= 11) {
        } else {

            JOptionPane.showMessageDialog(null,"Invalid number of months. Please enter a value between 0 and 11.");
            RefinanceCalculatorMonthsPayment.setText("0");   
        }
    }//GEN-LAST:event_RefinanceCalculatorMonthsPaymentKeyReleased

    private void RefinanceCalculatorInterestRateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorInterestRateKeyReleased
         String input = RefinanceCalculatorInterestRate.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorInterestRate.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorInterestRate.setText(Number);
        double rate = Double.parseDouble(Number);

    // Check if the number of months is within the valid range
        if (rate>= 0 && rate <= 199) {
        } else {

            JOptionPane.showMessageDialog(null,"Please provide a positive interest rate that less than 200%");
            RefinanceCalculatorInterestRate.setText("1");   
        }
    }//GEN-LAST:event_RefinanceCalculatorInterestRateKeyReleased

    private void RefinanceCalculatorNewLoanTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorNewLoanTermKeyReleased
         String input = RefinanceCalculatorNewLoanTerm.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorNewLoanTerm.setText(strippedInput);
        String Number = Helper.extractWholePositiveNumbers(input);
        RefinanceCalculatorNewLoanTerm.setText(Number);
 
    }//GEN-LAST:event_RefinanceCalculatorNewLoanTermKeyReleased

    private void RefinancecalculatorInterestRateNewLoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinancecalculatorInterestRateNewLoanKeyReleased
         String input = RefinancecalculatorInterestRateNewLoan.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinancecalculatorInterestRateNewLoan.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinancecalculatorInterestRateNewLoan.setText(Number);
        double rate = Double.parseDouble(Number);

    // Check if the number of months is within the valid range
        if (rate>= 0 && rate <= 199) {
        } else {

            JOptionPane.showMessageDialog(null,"Please provide a positive interest rate that less than 200%");
            RefinancecalculatorInterestRateNewLoan.setText("1");   }
    }//GEN-LAST:event_RefinancecalculatorInterestRateNewLoanKeyReleased

    private void RefinanceCalculatorPointsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorPointsKeyReleased
        String input = RefinanceCalculatorPoints.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorPoints.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorPoints.setText(Number);
      

    }//GEN-LAST:event_RefinanceCalculatorPointsKeyReleased

    private void RefinanceCalculatorCostandFeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorCostandFeesKeyReleased
        String input = RefinanceCalculatorCostandFees.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorCostandFees.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorCostandFees.setText(Number);
    }//GEN-LAST:event_RefinanceCalculatorCostandFeesKeyReleased

    private void RefinanceCalculatorCashoutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefinanceCalculatorCashoutKeyReleased
        String input = RefinanceCalculatorCashout.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        RefinanceCalculatorCashout.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        RefinanceCalculatorCashout.setText(Number);
    }//GEN-LAST:event_RefinanceCalculatorCashoutKeyReleased

    private void RefinanceCalculatorClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefinanceCalculatorClearActionPerformed
        RefinanceCalculatorRemainingBalance.setText("");
        RefinanceCalculatorYearsPayment.setText("");
        RefinanceCalculatorMonthsPayment.setText("0");
        RefinanceCalculatorInterestRate.setText("");
        RefinanceCalculatorLoanTermtext.setText("");
        
        RefinanceCalculatorNewLoanTerm.setText("");
        RefinancecalculatorInterestRateNewLoan.setText("");
        RefinanceCalculatorPoints.setText("");
        RefinanceCalculatorCostandFees.setText("");
        RefinanceCalculatorCashout.setText("");
        RefinanceCalculatorOutput.setText("");

    }//GEN-LAST:event_RefinanceCalculatorClearActionPerformed

    private void RefinanceCalculatorCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefinanceCalculatorCalculateBTNActionPerformed
        try{    
            String outputText = "";
            String selectedItem = (String) RefinanceCalculatorCurrentLoan.getSelectedItem();            
            if ("I know the orginal loan amount".equals(selectedItem)) {
               
                double currentLoan = Double.parseDouble(RefinanceCalculatorRemainingBalance.getText());
                int originalTime =Integer.parseInt(RefinanceCalculatorLoanTermtext.getText());
                int oTimeLeftYears = Integer.parseInt(RefinanceCalculatorYearsPayment.getText());
                int oTimeLeftMonths = Integer.parseInt(RefinanceCalculatorMonthsPayment.getText());
                int timeLeft = oTimeLeftYears * 12 + oTimeLeftMonths;
                int timePaid = originalTime * 12 - timeLeft;
                double interest = Double.parseDouble(RefinanceCalculatorInterestRate.getText());

                int newLoanTime = Integer.parseInt(RefinanceCalculatorNewLoanTerm.getText());
                double newInterest = Double.parseDouble(RefinancecalculatorInterestRateNewLoan.getText());
                double points = Double.parseDouble(RefinanceCalculatorPoints.getText());
                double costs = Double.parseDouble(RefinanceCalculatorCostandFees.getText());
                double cashOut = Double.parseDouble(RefinanceCalculatorCashout.getText());

                double timeRamining = oTimeLeftYears + (oTimeLeftMonths/12);
                if (timeRamining<=originalTime){

                // Call the function
                     double[] result = Helper.originalLoanAmount(currentLoan, originalTime, oTimeLeftYears, oTimeLeftMonths,
                                                     timeLeft, timePaid, interest, newLoanTime, newInterest,
                                                     points, costs, cashOut);

                    outputText = "<html>"
                            + "<body style='font-family: Arial; font-size: 14px;'>"
                            + "<table border='1' cellspacing='0' cellpadding='8' style='border-collapse: collapse; width: 100%; text-align: center;'>"
                            + "<thead style='background-color: #004080; color: white;'>"
                            + "    <tr>"
                            + "        <th></th>" // Empty header for the row labels
                            + "        <th>Current Loan (Remaining)</th>"
                            + "        <th>New Loan</th>"
                            + "    </tr>"
                            + "</thead>"
                            + "<tbody>"
                            + "    <tr>"
                            + "        <td>Principal/Loan Amount</td>"
                            + "        <td>" + currencyFormat.format(result[0]) + "</td>"
                            + "        <td>" + currencyFormat.format(result[4]) + "</td>"
                            + "    </tr>"
                            + "    <tr>"
                            + "        <td>Monthly Pay</td>"
                            + "        <td>" + currencyFormat.format(result[1]) + "</td>"
                            + "        <td>" + currencyFormat.format(result[5]) + "</td>"
                            + "    </tr>"
                            + "    <tr>"
                            + "        <td>Total Monthly Payments</td>"
                            + "        <td>" + currencyFormat.format(result[2]) + "</td>"
                            + "        <td>" + currencyFormat.format(result[6]) + "</td>"
                            + "    </tr>"
                            + "    <tr>"
                            + "        <td>Total Interest</td>"
                            + "        <td>" + currencyFormat.format(result[3]) + "</td>"
                            + "        <td>" + currencyFormat.format(result[7]) + "</td>"
                            + "    </tr>"
                            + "</tbody>"
                            + "</table>"
                            + "</body>"
                            + "</html>";
                }else{JOptionPane.showMessageDialog(null, "Loan term must be greater than or equal to time ramaining!");}
            }
            if ("I know my remaining balance".equals(selectedItem)){
                double currentLoan = Double.parseDouble(RefinanceCalculatorRemainingBalance.getText());
                int originalTime =Integer.parseInt(RefinanceCalculatorYearsPayment.getText());
               
                
                double interest = Double.parseDouble(RefinanceCalculatorInterestRate.getText());
                outputText= String.valueOf(originalTime);
                double newLoanTime = Double.parseDouble(RefinanceCalculatorNewLoanTerm.getText());
                double newInterest = Double.parseDouble(RefinancecalculatorInterestRateNewLoan.getText());
                double points = Double.parseDouble(RefinanceCalculatorPoints.getText());
                double costs = Double.parseDouble(RefinanceCalculatorCostandFees.getText());
                double cashOut = Double.parseDouble(RefinanceCalculatorCashout.getText());
                
                
                double original = currentLoan;
                double monthlyPay = Double.valueOf(originalTime);
                double interestRate =interest;
                double upfrontCost = 0.00;
                double cashOutoriginal = 0.00;
                double takeHomeAfterCost = 0.00;


                double[] remaining =Helper.refinanceCalculatorRemaining(original, monthlyPay, interestRate, newLoanTime, newInterest, points, costs, cashOut);
                for (double value : remaining) {
                    System.out.printf("%.2f%n", value);
                    outputText = "<html>"
                        + "<body style='font-family: Arial; font-size: 14px;'>"
                        + "<table border='1' cellspacing='0' cellpadding='8' style='border-collapse: collapse; width: 100%; text-align: center;'>"
                        + "<thead style='background-color: #004080; color: white;'>"
                        + "    <tr>"
                        + "        <th></th>"
                        + "        <th>Current Loan</th>"
                        + "        <th>New Loan</th>"
                        + "    </tr>"
                        + "</thead>"
                        + "<tbody>"
                        + "    <tr>"
                        + "        <td>Principal/Loan Amount</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[0]) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[5]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Monthly Pay</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[1]) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[6]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Length</td>"
                        + "        <td>" +String.format("%,.0f", remaining[2])  + " months</td>"
                        + "        <td>" + String.format("%,.0f", remaining[7]) + " months</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Total Monthly Payments</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[3]) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[8]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Total Interest</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[4]) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[9]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Cost + Points (Upfront)</td>"
                        + "        <td>" + String.format("$%,.2f", upfrontCost) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[10]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Cash Out</td>"
                        + "        <td>" + String.format("$%,.2f", cashOutoriginal) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[11]) + "</td>"
                        + "    </tr>"
                        + "    <tr>"
                        + "        <td>Take Home Amount After Cost/Point</td>"
                        + "        <td>" + String.format("$%,.2f", takeHomeAfterCost) + "</td>"
                        + "        <td>" + String.format("$%,.2f", remaining[12]) + "</td>"
                        + "    </tr>"
                        + "</tbody>"
                        + "</table>"
                        + "</body>"
                        + "</html>";
                }


            }

            RefinanceCalculatorOutput.setText(outputText);
        }
        catch(Exception e){JOptionPane.showMessageDialog(null, "Empty fields!");RefinanceCalculatorOutput.setText("Error404");}
    }//GEN-LAST:event_RefinanceCalculatorCalculateBTNActionPerformed
//-----------------------------------------------------------------------------------------------------------------------------------Currency Calculator
    

    private class CurrencyInfo {
        String currencySymbol;
        String decimalSeparator;
        String symbolPosition;
        double exchangeRate;

        CurrencyInfo(String symbol, String separator, String position, double rate) {
            this.currencySymbol = symbol;
            this.decimalSeparator = separator;
            this.symbolPosition = position;
            this.exchangeRate = rate;
        }
    }

    private void CurrencyCalculatorCalculateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencyCalculatorCalculateBTNActionPerformed
        // TODO add your handling code here:
        String amountText = CurrencyCalculatatorAmount.getText();
     /*   // Validate the input
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter numbers only!",  "Invalid Input", JOptionPane.WARNING_MESSAGE);
            CurrencyCalculatatorAmount.setText("");
            return;
        }

        // Get the selected items from the combo boxes
        String selectedCurrency1 = (String) CurrencyCalculatorFrom.getSelectedItem();
        String selectedCurrency2 = (String) CurrencyCalculatorTO.getSelectedItem();

        // Extract rates from the selected currency strings
        double rate1 = extractRate(selectedCurrency1);
        double rate2 = extractRate(selectedCurrency2);

        // Calculate the conversion
        double convertedAmount = amount * (rate2 / rate1);
        String[] parts = selectedCurrency2.split(" ");
        String currencyKey = parts[0] + " " + parts[1];
        String decimalSeparator = decimalSeparatorMap.getOrDefault(currencyKey, "dot");
        String thousandSeparator = decimalSeparatorMap.getOrDefault(currencyKey + " thousand", ",");
        String symbolPosition = decimalSeparatorMap.getOrDefault(currencyKey + " symbol", "left");
        String currencySymbol = parts[1];
        // Format the result accordingly
        CurrencyInfo info1 = currencyDataMap.get(selectedCurrency1);
        CurrencyInfo info2 = currencyDataMap.get(selectedCurrency2);
        //System.out.println(CurrencyInfo);

        String formattedAmount = String.format("%,.2f", convertedAmount);
        if ("comma".equals(info2.decimalSeparator)) {
            //formattedAmount = formattedAmount.replace(",", "#").replace(".", ",").replace("#", ".");
        }
        if ("left".equalsIgnoreCase(info2.symbolPosition)) {
                //formattedAmount = currencySymbol + " " + formattedAmount;
                //CurrencyCalculatorOuput.setText(info2.currencySymbol+ formattedAmount);

        } else if ("right".equalsIgnoreCase(info2.symbolPosition)) {
            //formattedAmount = formattedAmount + " " + currencySymbol;
            //CurrencyCalculatorOuput.setText(formattedAmount +  info2.currencySymbol);
        }  
        */
        if (CurrencyCalculatatorAmount.getText().trim().isEmpty()) {
            CurrencyCalculatatorAmount.setText("1");}
        double currencyAmount = Double.parseDouble(CurrencyCalculatatorAmount.getText());
        String selectedCurrencyFrom = (String) CurrencyCalculatorFrom.getSelectedItem();
        String currencyNameFrom = selectedCurrencyFrom.split(":")[1].split("-")[0];
        String selectedCurrencyTo = (String) CurrencyCalculatorTO.getSelectedItem();
        
        String currencyNameTo = selectedCurrencyTo.split(":")[1].split("-")[0];
        System.out.println(currencyNameFrom + " helo" + currencyNameTo);
        String[] result = Helper.convertingCurrencyFromTo(currencyAmount, currencyNameFrom, currencyNameTo);

        String outputText = "<html>"
            + "<table border='1' style='border-collapse:visible; text-align:left;'>"

            + " <td><b>Original Amount:</b> "+currencyNameFrom+":<br><br>"
            + " " + result[0] + "</td>"

            + "<td><b>Converted Amount:</b> "+currencyNameTo+":<br><br>"
            + "" + result[1] + "</td>"

            + "</html>";
        CurrencyCalculatorOuput.setText(outputText);
    }//GEN-LAST:event_CurrencyCalculatorCalculateBTNActionPerformed

    private void CurrencyCalculatorFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencyCalculatorFromActionPerformed
        String selectedCurrencyFrom = (String) CurrencyCalculatorFrom.getSelectedItem();
        //if (selectedCurrency != null && currencyDataMap.containsKey(selectedCurrency)) {
           // CurrencyInfo info = currencyDataMap.get(selectedCurrency);
            //jLabel13.setText(info.currencySymbol);
           
        //}
        String currencyNameFrom = selectedCurrencyFrom.split(":")[1].split("-")[0];
        String[] details = Helper.currencySelectedFrom(currencyNameFrom); // Call the method
        String positionFrom = details[0]; // First value: positionFrom
        String symbolFrom = details[1]; // Second value: symbolFrom

        if ("left".equals(positionFrom)) {
            jLabel13.setText(symbolFrom);
            jLabel14.setText("");
        } else if ("right".equals(positionFrom)) {
            jLabel14.setText(symbolFrom);
            jLabel13.setText("");
    }
        // Additional processing using info as needed  
        
        
    }//GEN-LAST:event_CurrencyCalculatorFromActionPerformed

    private void CurrencyCalculatorClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencyCalculatorClearActionPerformed
       CurrencyCalculatatorAmount.setText("");
       CurrencyCalculatorOuput.setText("");
    }//GEN-LAST:event_CurrencyCalculatorClearActionPerformed

    private void CurrencyCalculatatorAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CurrencyCalculatatorAmountKeyReleased
        String input = CurrencyCalculatatorAmount.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        CurrencyCalculatatorAmount.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        CurrencyCalculatatorAmount.setText(Number);
    }//GEN-LAST:event_CurrencyCalculatatorAmountKeyReleased

    private void paceCalculatorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_paceCalculatorAncestorAdded
        CalculatorNameLBL.setText("Pace Calculator");
    }//GEN-LAST:event_paceCalculatorAncestorAdded

    private void deepThoughtsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_deepThoughtsAncestorAdded
        CalculatorNameLBL.setText("Deep Thoughts");
    }//GEN-LAST:event_deepThoughtsAncestorAdded

    private void ekinator2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ekinator2AncestorAdded
        CalculatorNameLBL.setText("Ekinator 2");
    }//GEN-LAST:event_ekinator2AncestorAdded

    //-------------------------------------------------------------------------------------------------Math Calculator
    private void btnChaseMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChaseMeActionPerformed
       String selectedOperator = (String) operator.getSelectedItem();
    try {
        String firstInput = firstNumber.getText();
        String secondInput = secondNumber.getText();
        if (firstInput.isEmpty() || secondInput.isEmpty()) {
            messageMathCalculator ="Don’t try to trick me!";
        
        }else{
        // Get the file path from the resources folder
        String filePath = Helper.class.getResource("/playful_messages_only.txt").getPath();

        // Load messages using the absolute file path
        Helper.loadMessages(filePath);

       

        // Get inputs from the text fields


        // Call the Helper function
        String result = Helper.funCalculator(firstInput, secondInput, selectedOperator);
        messageMathCalculator =result;

        // Display the result
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error loading messages: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnChaseMeActionPerformed

    private void btnChaseMe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChaseMe1ActionPerformed
        messageMathCalculator = "Please enter your numbers, and I'll calculate the answer for you!";
        firstNumber.setText("");
        secondNumber.setText("");
    }//GEN-LAST:event_btnChaseMe1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selectedEvent = (String) jComboBox2.getSelectedItem();

        // Check if an event is selected (not "Or Pick an Event")
        if (!selectedEvent.equals("--Or Pick an Event")) {
            // Automatically update jTextField2 based on the event
            if (selectedEvent.equals("5K")) {
                getdistance.setText("5");
                jComboBox1.setSelectedItem("Kilometer");  // Set the unit to Kilometer
            } else if (selectedEvent.equals("10K")) {
                getdistance.setText("10");
                jComboBox1.setSelectedItem("Kilometer");  // Set the unit to Kilometer
            } else if (selectedEvent.equals("Marathon")) {
                getdistance.setText("26.2");
                jComboBox1.setSelectedItem("Miles");  // Set the unit to Miles
            }
            // "--Or Pick an Event","5K", "10K", "Marathon",
            //"Half-Marathon","8K","10 Miles"
            else if (selectedEvent.equals("Half-Marathon")) {
                getdistance.setText("13.1");
                jComboBox1.setSelectedItem("Miles");  // Set the unit to Miles
            }
            else if (selectedEvent.equals("8k")) {
                getdistance.setText("8");
                jComboBox1.setSelectedItem("Kilometer");  // Set the unit to Miles
            }
            else if (selectedEvent.equals("10 Miles")) {
                getdistance.setText("10");
                jComboBox1.setSelectedItem("Miles");  // Set the unit to Miles
            }
        } else {
            // Reset the text and combo boxes if no event is selected
            getdistance.setText("");  // Clear the distance text
            jComboBox1.setSelectedItem("Miles");  // Default the unit to Miles
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed
private static final String[] DISTANCES = {
        "Miles","Kilometer"
    };
    
     private static final String[] PREDEFINED_DISTANCES = {
        "--Or Pick an Event","5K", "10K", "Marathon","Half-Marathon","8k","10 Miles"
    };
    private void CaculateforpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaculateforpaceActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        // Get the time input from the user
        String inputTimeStr = gettime.getText().trim();
        if (inputTimeStr.matches("\\d{2}:\\d{2}:\\d{2}")) {
            String[] timeParts = inputTimeStr.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int seconds = Integer.parseInt(timeParts[2]);
            int totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

            // Get selected distance and unit
            double distance = Double.parseDouble(getdistance.getText());
            String distanceUnit = (String) jComboBox1.getSelectedItem();

            // Convert distance to miles if necessary
            double distanceInMiles = distance;
            if (distanceUnit.equals("Kilometer")) {
                distanceInMiles = distance / 1.60934;  // Convert kilometers to miles
            }

            // Calculate paces
            double paceInSecondsPerKm = totalSeconds / (distanceInMiles * 1.60934);  // Time per kilometer
            double paceInSecondsPerMile = totalSeconds / distanceInMiles;  // Time per mile

            // Format paces
            int kmPaceMinutes = (int) (paceInSecondsPerKm / 60);
            int kmPaceSeconds = (int) (paceInSecondsPerKm % 60);
            int milePaceMinutes = (int) (paceInSecondsPerMile / 60);
            int milePaceSeconds = (int) (paceInSecondsPerMile % 60);

            // Display both paces
            KilometerLabel.setText(String.format("%02d:%02d per Kilometer", kmPaceMinutes, kmPaceSeconds));
            MileLabel.setText(String.format("%02d:%02d per Mile", milePaceMinutes, milePaceSeconds));

            // Build splits for the race distance
            StringBuilder splits = new StringBuilder();
            splits.append(String.format("%-6s %-12s\n", "Split", "Time"));

            // Initialize variables for cumulative time
            double cumulativeTime = 0;

            // Loop through each kilometer
            for (int i = 1; i <= (int) distance; i++) {
                // Add the pace for each full kilometer
                cumulativeTime += paceInSecondsPerKm;
                int splitMinutes = (int) (cumulativeTime / 60);
                int splitSeconds = (int) (cumulativeTime % 60);
                splits.append(String.format("%-6d %-12s\n", i, String.format("%02d:%02d", splitMinutes, splitSeconds)));
            }

            // Handle fractional kilometer (if any)
            double fractionalDistance = distance - (int) distance;
            if (fractionalDistance > 0) {
                cumulativeTime += fractionalDistance * paceInSecondsPerKm;
                int splitMinutes = (int) (cumulativeTime / 60);
                int splitSeconds = (int) (cumulativeTime % 60);
                splits.append(String.format("%-6s %-12s\n", String.format("%.3f", distance), String.format("%02d:%02d", splitMinutes, splitSeconds)));
            }
            jTextArea2.setText(splits.toString());
        } else {
            KilometerLabel.setText("Invalid time format. Please enter in hh:mm:ss.");
            MileLabel.setText("");  // Clear additional output
        }
    }//GEN-LAST:event_CaculateforpaceActionPerformed

    private void ClearForPacecalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearForPacecalcActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        getdistance.setText("");
        gettime.setText("");
        KilometerLabel.setText("");
        MileLabel.setText("");
        jTextArea2.setText("");
    }//GEN-LAST:event_ClearForPacecalcActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String input = jTextField1.getText();
    
    // Check if the input is "42"
    if ("42".equals(input)) {
        // Show "Correct" message in the label
        jLabel129.setText("Correct Oh wise one, you have unlocked the secret of universe");
    } else {
        // Clear the input field and show "Incorrect" message
String[] responses = {
    "<html>Segmentation fault:<br>Your logic is out of bounds.</html>",
    "<html>Error 404:<br>Ultimate Answer Not Found.</html>",
    "<html>Warning:<br>Your input may cause undefined behavior<br>in the universe.</html>",
    "<html>Looks like you’re stuck<br>in an infinite loop of wrong guesses.</html>",
    "<html>Stack overflow detected—<br>too many guesses.</html>",
    "<html>This guess needs debugging.<br>Have you tried stepping through it?</html>",
    "<html>Access denied.<br>You don’t have permission<br>to reveal the ultimate answer.</html>",
    "<html>Error: Guess value is null.<br>Please try again with meaningful input.</html>",
    "<html>That input is like using <i>goto</i>—<br>technically valid, but still wrong.</html>",
    "<html>Hmm, your guess doesn’t compile<br>with the laws of the universe.</html>",
    "<html>Logical error detected:<br>Did you forget to initialize <i>UltimateAnswer</i>?</html>",
    "<html>Off by one?<br>Nope. Off by infinity.</html>",
    "<html>You’re running on a deprecated version<br>of universal knowledge.<br>Update required.</html>"
};

int randomIndex = (int) (Math.random() * responses.length);
jLabel129.setText(responses[randomIndex]);

    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
        // Parse input from text field to an integer
        int input = Integer.parseInt(jTextField2.getText());
        // Add 1 to the input
        int result = input + 1;
        // Display the result in the label
        jLabel139.setText("My great powers tell me you will be "+ String.valueOf(result)+" in one year");
        jLabel140.setText("Are you not amazed");
    } catch (NumberFormatException e) {
        // Handle invalid input
        jLabel140.setText("Invalid input! Please enter a valid age");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void haCalcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haCalcButtonActionPerformed
        // TODO add your handling code here:
        try {
            // Retrieve input values from the UI
            String haIncomeValue = haIncomeInput.getText().replace("$", "").replace(",", ""); 
            String haLoanTermValue = haLoanTermInput.getText();
            String haInterestValue = haInterestInput.getText();

            // Get values and their corresponding options (% or $ per year)
            String haDownPaymentValue = haDownPaymentInput.getText();
            String haDownPaymentOption = (String) haDownPaymentBox.getSelectedItem();

            String haPropertyTaxValue = haPropertyTaxInput.getText();
            String haPropertyTaxOption = (String) haPropertyTaxBox.getSelectedItem();

            String haHOAValue = haHOAInput.getText();
            String haHOAOption = (String) haHOABox.getSelectedItem();

            String haInsuranceValue = haInsuranceInput.getText();
            String haInsuranceOption = (String) haInsuranceBox.getSelectedItem();

            String selectDTIOption = (String) haDTIBox.getSelectedItem();

            // Validate required fields
            if (haIncomeValue.isEmpty() || haLoanTermValue.isEmpty() || haInterestValue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Income, Loan Term, and Interest Rate are required.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert required inputs to numeric types
            double annualIncome = Double.parseDouble(haIncomeValue);
            double loanTerm = Double.parseDouble(haLoanTermValue);
            double interestRate = Double.parseDouble(haInterestValue);

            // Create an instance of Helper
            Helper helper = new Helper();

            // Perform the calculation with all options
            String message = helper.calculateHouseAffordability(
                annualIncome, loanTerm, interestRate,
                haHOAOption, haHOAValue,
                haInsuranceOption, haInsuranceValue,
                haPropertyTaxOption, haPropertyTaxValue,
                haDownPaymentOption, haDownPaymentValue,
                selectDTIOption
            );

            // Display the result
            haResultOutput.setText(message);
            System.out.println(message);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), 
                "Calculation Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_haCalcButtonActionPerformed

    private void haClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haClearButtonActionPerformed
        // TODO add your handling code here:
        // Clear all input fields
        haIncomeInput.setText("");
        haLoanTermInput.setText("");
        haInterestInput.setText("");
        haDebtInput.setText("");
        haDownPaymentInput.setText("");
        haPropertyTaxInput.setText("");
        haHOAInput.setText("");
        haInsuranceInput.setText("");

        // Reset dropdown/combo boxes to their default first item
        haDownPaymentBox.setSelectedIndex(0);
        haPropertyTaxBox.setSelectedIndex(0);
        haHOABox.setSelectedIndex(0);
        haInsuranceBox.setSelectedIndex(0);
        haDTIBox.setSelectedIndex(0);

        // Clear the result output
        haResultOutput.setText("");
    }//GEN-LAST:event_haClearButtonActionPerformed
//-----------------------------------------------------------------------------------------------------------MortgagePayoff Validation Fields - 
    private void MorgagePayoffRePayementExtraMonthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MorgagePayoffRePayementExtraMonthKeyReleased
        String input = MorgagePayoffRePayementExtraMonth.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MorgagePayoffRePayementExtraMonth.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MorgagePayoffRePayementExtraMonth.setText(Number);
    }//GEN-LAST:event_MorgagePayoffRePayementExtraMonthKeyReleased

    private void MorgagePayoffRePayementExtraYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MorgagePayoffRePayementExtraYearKeyReleased
        String input = MorgagePayoffRePayementExtraYear.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MorgagePayoffRePayementExtraYear.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MorgagePayoffRePayementExtraYear.setText(Number);
    }//GEN-LAST:event_MorgagePayoffRePayementExtraYearKeyReleased

    private void MorgagePayoffRePayementExtraOneTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MorgagePayoffRePayementExtraOneTimeKeyReleased
        String input = MorgagePayoffRePayementExtraOneTime.getText();
          // Strip all spaces from the input as the user types
        String strippedInput = input.replaceAll("\\s", "");
        // Set the text field with the stripped input (without spaces)
        MorgagePayoffRePayementExtraOneTime.setText(strippedInput);
        String Number = Helper.extractNumbers(input);
        MorgagePayoffRePayementExtraOneTime.setText(Number);
    }//GEN-LAST:event_MorgagePayoffRePayementExtraOneTimeKeyReleased

   //----------------------------------------------------------------------------------
    
    
    
    private void populateComboBoxesCurrencyCalculator(){
      String[] currencies = Helper.currencyLoader().split("\n");
        for (String currency : currencies) {
            CurrencyCalculatorFrom.addItem(currency);
            CurrencyCalculatorTO.addItem(currency);
            
            
        }  
    }

    private void populateComboBoxes() {
        DefaultComboBoxModel<String> model1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
            getClass().getClassLoader().getResourceAsStream("currency_dictionary.txt")))) {
            jLabel13.setText("$");
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length >= 6) {
                    String country = parts[0];
                    String currencyName = parts[1];
                    String currencySymbol = parts[2];
                    double exchangeRate = Double.parseDouble(parts[3]);
                    String decimalSeparator = parts[4];
                    String symbolPosition = parts[5];
                   // currencySymbolMap.put(currencySymbol, symbolPosition);
                    String displayName = country + " " + currencySymbol+" " + exchangeRate;
                    String currencyKey = country + " " + currencyName;
                    decimalSeparatorMap.put(currencyKey, decimalSeparator);
                    decimalSeparatorMap.put(currencyKey + " thousand", decimalSeparator);
                    decimalSeparatorMap.put(currencyKey + " symbol", symbolPosition);
                    currencyDataMap.put(displayName, new CurrencyInfo(currencySymbol, decimalSeparator, symbolPosition, exchangeRate));
                    model1.addElement(country + " " + currencySymbol + " " + exchangeRate);
                    model2.addElement(country + " " + currencySymbol + " " + exchangeRate);
                    model1.addElement(country + " " + currencyName);
                    //model2.addElement(country + " " + currencyName);
                }
        }
        //CurrencyCalculatorFrom.setModel(model1);
        //CurrencyCalculatorTO.setModel(model2);
        } catch (IOException e) {
        e.printStackTrace(); // Print the error for debugging purposes
    }
    }
    
    private double extractRate(String currencyString) {
        String[] parts = currencyString.split(" ");
        return Double.parseDouble(parts[parts.length - 1]);
    }
    //Text field 
     // Method to display the first message in jTextPane1

    // Method to display the second message in jTextPane1
    private void setMessage1() {
        String message2 = "<html>"
                + "<b>Amount Field:</b><br>"
                + "Start by entering the amount of money you want to convert in the 'Amount' box. For example, if you want to convert $100, just type '100' in the box.<br><br>"
                + "<b>From (Currency Selection):</b><br>"
                + "Next, click the dropdown menu labeled 'From.' This is where you select the currency you currently have. For example, if you are converting from U.S. dollars, select 'USD' from the list.<br><br>"
                + "<b>To (Currency Selection):</b><br>"
                + "After that, click the 'To' dropdown menu. This is where you choose the currency you want to convert to. For example, if you want to convert U.S. dollars to euros, select 'EUR' from the list.<br><br>"
                + "<b>Calculate Button:</b><br>"
                + "Once you’ve entered the amount and selected both currencies, click the 'Calculate' button. This will perform the conversion and show you the result.<br><br>"
                + "<b>Clear Button:</b><br>"
                + "If you want to start over or reset everything, click the 'Clear' button. This will remove the amount and reset the currency selections so you can begin a new conversion."
                + "</html>";
        
        instructionCurrencyCalculator.setContentType("text/html");
        instructionCurrencyCalculator.setText(message2);
    }
    
    private void setMessage2(){
            String autoLoanInstructions = "<html>"
        + "<b>Auto Price:</b><br>"
        + "Enter the total price of the car you want to buy.<br><br>"
        + "<b>Loan Term:</b><br>"
        + "Enter the number of months you will be financing the loan.<br><br>"
        + "<b>Interest Rate:</b><br>"
        + "Provide the interest rate for your loan (as a percentage).<br><br>"
        + "<b>Cash Incentives:</b><br>"
        + "If there are any manufacturer or dealer incentives, enter the amount here.<br><br>"
        + "<b>Down Payment:</b><br>"
        + "Enter the amount of money you will pay upfront for the car.<br><br>"
        + "<b>Trade-in Value:</b><br>"
        + "Enter the value of your current vehicle that you are trading in.<br><br>"
        + "<b>Amount Owed on Trade-in:</b><br>"
        + "If you still owe money on your current vehicle, enter that amount here.<br><br>"
        + "<b>Sales Tax:</b><br>"
        + "Enter the sales tax rate in your state (if not calculated automatically).<br><br>"
        + "<b>Title, Registration, and Other Fees:</b><br>"
        + "Enter the total cost of fees related to title, registration, and other charges.<br><br>"
        + "<b>Include All Fees in Loan:</b><br>"
        + "Check this box if you want to include all fees in your loan calculation.<br><br>"
        + "<b>Calculate Button:</b><br>"
        + "Once all fields are filled, click 'Calculate' to get your estimated monthly payment.<br><br>"
        + "<b>Clear Button:</b><br>"
        + "Click 'Clear' to reset all fields to their default values."
        + "</html>";
    InstructionsAutoLoanCalculator.setContentType("text/html");
    InstructionsAutoLoanCalculator.setText(autoLoanInstructions);
    }
    
    private void setMessage3(){
        String autoLoanInstructions2 = "<html>"
           + "<b>Monthly Pay:</b><br>"
           + "Enter the estimated or calculated monthly payment amount for the loan.<br><br>"
           + "<b>Loan Term:</b><br>"
           + "Enter the number of months you plan to finance the loan.<br><br>"
           + "<b>Interest Rate:</b><br>"
           + "Provide the interest rate for your loan as a percentage.<br><br>"
           + "<b>Cash Incentives:</b><br>"
           + "If there are any manufacturer or dealer incentives, enter the amount here.<br><br>"
           + "<b>Down Payment:</b><br>"
           + "Enter the amount of money you will pay upfront for the car.<br><br>"
           + "<b>Trade-in Value:</b><br>"
           + "Enter the value of your current vehicle that you are trading in.<br><br>"
           + "<b>Amount Owed on Trade-in:</b><br>"
           + "If you still owe money on your current vehicle, enter the amount here.<br><br>"
           + "<b>Sales Tax:</b><br>"
           + "Enter the sales tax rate for your state (if not automatically calculated).<br><br>"
           + "<b>Title, Registration, and Other Fees:</b><br>"
           + "Enter the total amount for fees related to title, registration, and other charges.<br><br>"
           + "<b>Include All Fees in Loan:</b><br>"
           + "Check this box if you want to include all fees in the total loan calculation.<br><br>"
           + "<b>Calculate Button:</b><br>"
           + "After completing the form, click 'Calculate' to get your estimated loan payments.<br><br>"
           + "<b>Clear Button:</b><br>"
           + "Click 'Clear' to reset all the fields and start a new calculation."
           + "</html>";
        InstructionsAutoLoan2Calculator.setContentType("text/html");
        InstructionsAutoLoan2Calculator.setText(autoLoanInstructions2);
     }
     
private void setMessage4() {
    String rateCalculatorInstructions = "<html>"
        + "<b>Initial Investment:</b><br>"
        + "Enter the amount of the initial investment you plan to contribute.<br><br>"
        + "<b>Annual Contribution:</b><br>"
        + "Enter the total amount you plan to contribute each year.<br><br>"
        + "<b>Monthly Contribution:</b><br>"
        + "Enter the total amount you plan to contribute each month.<br><br>"
        + "<b>Contribute at the beginning/end of each period:</b><br>"
        + "Select whether you will contribute at the beginning or end of each compound period.<br><br>"
        + "<b>Interest Rate:</b><br>"
        + "Enter the annual interest rate (in percentage) for your investment.<br><br>"
        + "<b>Compound:</b><br>"
        + "Select how frequently the interest is compounded (e.g., Annually, Monthly, etc.).<br><br>"
        + "<b>Investment Length:</b><br>"
        + "Enter the length of the investment in years and months.<br><br>"
        + "<b>Calculate Button:</b><br>"
        + "Once you’ve entered all the information, click the 'Calculate' button to compute the future value of your investment.<br><br>"
        + "<b>Clear Button:</b><br>"
        + "Click 'Clear' to reset all the fields and start a new calculation."
        + "</html>";

    InstructionsRateCalculator.setContentType("text/html");
    InstructionsRateCalculator.setText(rateCalculatorInstructions);
}

      
    private void setMessage5(){
      String retirementCalculatorInstructions = "<html>"
        + "<b>Your Current Age:</b><br>"
        + "Enter your current age.<br><br>"
        + "<b>Your Planned Retirement Age:</b><br>"
        + "Enter the age at which you plan to retire.<br><br>"
        + "<b>Your Life Expectancy:</b><br>"
        + "Estimate how long you expect to live post-retirement.<br><br>"
        + "<b>Your Current Pre-tax Income:</b><br>"
        + "Enter your current yearly income before taxes.<br><br><br>"
        + "<b>Assumptions:</b><br><br>"
       
        + "<b>Income Needed After Retirement:</b><br>"
        + "Enter the percentage of your <b>pretax income</b> that you expect to need after retirement, or specify a fixed amount.<br><br>"
      

        + "<b>Average Investment Return:</b><br>"
        + "Enter the average annual return you expect from your investments (as a percentage).<br><br><br>"
       
        + "<b>Optional:</b><br>"
        + "<b>Other Income After Retirement:</b><br>"
        + "Enter any additional income you expect to receive after retirement, such as pensions or social security.<br><br>"
        + "<b>Your Current Retirement Savings:</b><br>"
        + "Enter the amount you currently have saved for retirement.<br><br>"
        
        + "<b>Calculate Button:</b><br>"
        + "After entering all relevant information, click 'Calculate' to estimate your retirement savings and needs.<br><br>"
        + "<b>Clear Button:</b><br>"
        + "Click 'Clear' to reset all fields and start a new calculation."
        + "</html>";
      InstructionsRetirementCalculator.setContentType("text/html");
      InstructionsRetirementCalculator.setText(retirementCalculatorInstructions);

    }

    private void setMessage6(){
      String rothIRACalculatorInstructions = "<html>"
          + "<b>Current Balance:</b><br>"
          + "Enter the current balance of your Roth IRA account.<br><br>"
          + "<b>Annual Contribution:</b><br>"
          + "Enter the amount you contribute to your Roth IRA each year.<br><br>"
          + "<b>Maximize Contribution?</b><br>"
          + "Select 'Yes' if you plan to maximize your contributions according to IRS limits, or 'No' if you do not.<br><br>"
          + "If you select 'Yes':<br>"
            + "- The maximum contribution limit is $7,000 for individuals under the age of 50.<br>"
            + "- Once you turn 50, the limit increases to $8,000 to allow for additional 'catch-up' contributions as per IRS guidelines.<br><br>"
            + "For example, if you are currently 32 and plan to retire at 65, you can contribute up to $7,000 annually until you turn 50. After that, starting at age 50, you can contribute up to $8,000 annually until you retire.<br><br>"
            + "If you select 'No', you can specify a custom contribution amount.<br><br>"
          + "<b>Expected Rate of Return:</b><br>"
          + "Enter the expected annual rate of return on your Roth IRA investments (as a percentage).<br><br>"
          + "<b>Current Age:</b><br>"
          + "Enter your current age.<br><br>"
          + "<b>Retirement Age:</b><br>"
          + "Enter the age at which you plan to retire.<br><br>"
          + "<b>Calculate Button:</b><br>"
          + "Once you’ve filled out all fields, click 'Calculate' to estimate your Roth IRA growth and future balance.<br><br>"
          + "<b>Clear Button:</b><br>"
          + "Click 'Clear' to reset the fields and start a new calculation."
          + "</html>";
      InstructionsRothIRACalculator.setContentType("text/html");
      InstructionsRothIRACalculator.setText(rothIRACalculatorInstructions);

    }

    private void setMessage7() {
        String mortgagePayoffCalculatorInstructions = "<html>"
            + "<b>Mortgage Payoff Calculator Instructions:</b><br><br>"
            + "<ul>"
            + "   <li><b>Original Loan Amount:</b> Enter the initial amount borrowed for the mortgage loan when it was first taken out.</li><br>"
            + "   <li><b>Original Loan Term:</b> Enter the original duration of the loan in months or years (e.g., 30 years).</li><br>"
            + "   <li><b>Interest Rate:</b> Enter the annual interest rate for the mortgage (as a percentage).</li><br>"
            + "   <li><b>Remaining Term:</b> Enter the number of months or years left on your mortgage.</li><br>"
            + "   <li><b>Repayment Options:</b> Choose one of the following repayment options:"
            + "       <ul>"
            + "           <li><b>Payback Altogether:</b> Choose this if you plan to repay the loan in full at once.</li>"
            + "           <li><b>Repayment With Extra Payments:</b> Select this if you plan to make additional payments toward the loan.</li>"
            + "       </ul>"
            + "   </li><br>"
            + "   <li><b>Extra Payments:</b> If 'Repayment With Extra Payments' is selected, enter the extra amounts you plan to pay:"
            + "       <ul>"
            + "           <li><b>Monthly:</b> Enter the extra amount you plan to pay each month.</li>"
            + "           <li><b>Yearly:</b> Enter the extra amount you plan to pay each year.</li>"
            + "           <li><b>One-time:</b> Enter any one-time payment you plan to make.</li>"
            + "       </ul>"
            + "   </li><br>"
            + "   <li><b>Payment Frequency:</b> Select the payment schedule for your loan repayment:"
            + "       <ul>"
            + "           <li><b>Biweekly Repayment:</b> Choose this option if you plan to make biweekly payments.</li>"
            + "           <li><b>Normal Payment:</b> Choose this option for regular monthly payments.</li>"
            + "       </ul>"
            + "   </li><br>"
            + "   <li><b>Calculate Button:</b> Click 'Calculate' after entering all the required information to estimate how extra payments will affect your mortgage payoff timeline.</li><br>"
            + "   <li><b>Clear Button:</b> Click 'Clear' to reset all fields and start a new calculation.</li><br>"
            + "</ul>"
            + "</html>";

        InstructionsMortgagePayoffCalculator.setContentType("text/html");
        InstructionsMortgagePayoffCalculator.setText(mortgagePayoffCalculatorInstructions);
    }


    private void setMessage8(){
      String mortgageCalculatorInstructions = "<html>"
          + "<b>Home Price:</b><br>"
          + "Enter the total purchase price of the home you want to buy.<br><br>"
          + "<b>Down Payment:</b><br>"
          + "Enter the amount you plan to pay upfront as a down payment. You can enter a specific amount or a percentage of the home price.<br><br>"
          + "<b>Loan Term:</b><br>"
          + "Enter the number of years over which you plan to repay the loan.<br><br>"
          + "<b>Interest Rate:</b><br>"
          + "Enter the annual interest rate for the mortgage (as a percentage).<br><br>"
          + "<b>Start Date:</b><br>"
          + "Select the start date of the loan. You can choose the month and enter the year.<br><br>"
          + "<b>Include Taxes & Costs Below:</b><br>"
          + "Check this box if you want to include additional costs such property taxes, home insurance, HOA fee and other costs in the calculation.<br><br>"
          + "<b>Details (if checkbox is selected):</b><br>"
          + "<ul>"
            + "   <li><b>Property Taxes Increase:</b> Enter the percentage by which property taxes are expected to increase annually.</li><br>"
            + "   <li><b>Home Insurance:</b> Enter the expected cost of home insurance as a percentage of the home price.</li><br>"
            + "   <li><b>PMI Insurance:</b> Enter the percentage for private mortgage insurance (PMI) if applicable. This typically applies when your down payment is less than 20%.</li><br>"
            + "   <li><b>HOA Fee:</b> Enter the expected amount for homeowners' association (HOA) fees as a percentage of the home price.</li><br>"
            + "   <li><b>Other Costs:</b> Enter any other additional costs, such as maintenance or repairs, as a percentage of the home price.</li><br>"
          + "</ul>"
          + "<b>Calculate Button:</b><br>"
          + "After entering all relevant information, click 'Calculate' to determine your estimated mortgage payments.<br><br>"
          + "<b>Clear Button:</b><br>"
          + "Click 'Clear' to reset the fields and start a new calculation."
          + "</html>";

      InstructionsMortgageCalculator.setContentType("text/html");
      InstructionsMortgageCalculator.setText(mortgageCalculatorInstructions);

     }

    private void setMessage9(){
         String houseAffordabilityCalculatorInstructions = "<html>"
              + "<b>Annual Household Income:</b><br>"
              + "Enter your total household income before taxes, including salary and other income sources.<br><br>"
              + "<b>Mortgage Loan Term:</b><br>"
              + "Enter the number of years over which you plan to repay the mortgage.<br><br>"
              + "<b>Interest Rate:</b><br>"
              + "Enter the annual interest rate for the mortgage (as a percentage).<br><br>"
              + "<b>Monthly Debt Payback:</b><br>"
              + "Enter the total amount you pay each month toward long-term debts, such as car loans, student loans, and credit cards.<br><br>"
              + "<b>Down Payment:</b><br>"
              + "Enter the amount of the down payment. You can select between entering a percentage or a specific dollar amount.<br><br>"
              + "<b>Property Tax:</b><br>"
              + "Enter the property tax as a percentage or a dollar amount per year.<br><br>"
              + "<b>HOA or Co-op Fee:</b><br>"
              + "Enter the homeowners' association (HOA) or co-op fee as a percentage or dollar amount per year.<br><br>"
              + "<b>Insurance:</b><br>"
              + "Enter the cost of insurance as a percentage or a dollar amount per year.<br><br>"
              + "<b>Debt-to-Income (DTI) Ratio:</b><br>"
              + "Select your desired DTI ratio. This is a comparison of your monthly debt payments to your monthly income, used by lenders to assess affordability.<br><br>"
              + "<b>Calculate Button:</b><br>"
              + "Once you've filled in all the necessary fields, click 'Calculate' to determine your house affordability based on your income and other financial factors.<br><br>"
              + "<b>Clear Button:</b><br>"
              + "Click 'Clear' to reset all fields and start a new calculation."
              + "</html>";
          InstructionsHouseAffordabilityCalculator.setContentType("text/html");
          InstructionsHouseAffordabilityCalculator.setText(houseAffordabilityCalculatorInstructions);



     }
    private void setMessage10(){
       String rentCalculatorInstructions = "<html>"
            + "<b>Your Pre-tax Income:</b><br>"
            + "Enter your total pre-tax income. You can select whether the amount is per year or per month from the dropdown menu.<br><br>"
            + "<b>Your Monthly Debt Payback:</b><br>"
            + "Enter the total amount you pay each month toward long-term debts, such as car loans, student loans, credit card payments, etc.<br><br>"
            + "<b>Calculate Button:</b><br>"
            + "After entering your pre-tax income and monthly debt payments, click 'Calculate' to estimate the amount of rent you can afford.<br><br>"
            + "<b>Clear Button:</b><br>"
            + "Click 'Clear' to reset the fields and start a new calculation."
            + "</html>";
       InstructionsRentCalculator.setContentType("text/html");
       InstructionsRentCalculator.setText(rentCalculatorInstructions);


    }
    
    private void setMessage11(){
        String refinanceCalculatorInstructions = "<html>"
            + "<b>Current Loan:</b><br>"
            + "Select whether you know your remaining balance or monthly payment for your current loan.<br><br>"
            + "<b>Remaining Balance:</b><br>"
            + "Enter the remaining balance on your current loan if you selected that option above.<br><br>"
            + "<b>Monthly Payment:</b><br>"
            + "Enter your current monthly payment if you selected that option above.<br><br>"
            + "<b>Interest Rate (Current Loan):</b><br>"
            + "Enter the interest rate on your current loan.<br><br>"
            + "-----------------------------------------<br><br>"
            + "<b>New Loan Term:</b><br>"
            + "Enter the number of years for the new loan term.<br><br>"
            + "<b>Interest Rate (New Loan):</b><br>"
            + "Enter the interest rate for the new loan.<br><br>"
            + "<b>Points:</b><br>"
            + "Enter any points you are paying for the new loan. Points are prepaid interest, with 1 point equal to 1% of the loan amount.<br><br>"
            + "<b>Costs and Fees:</b><br>"
            + "Enter the costs and fees associated with the new loan.<br><br>"
            + "<b>Cashout:</b><br>"
            + "If you are taking cash out as part of the refinancing, enter the cashout amount here.<br><br>"
            + "<b>Calculate Button:</b><br>"
            + "After entering the details of your current loan and the new loan, click 'Calculate' to estimate your new monthly payment and savings from refinancing.<br><br>"
            + "<b>Clear Button:</b><br>"
            + "Click 'Clear' to reset the form and start a new calculation."
            + "</html>";
        InstructionsRefinanceCalculator.setContentType("text/html");
        InstructionsRefinanceCalculator.setText(refinanceCalculatorInstructions);
    }
    private void setMessage112(){
        String refinanceCalculatorInstructions = "<html>"
            + "<b>Current Loan:</b><br>"
            + "1. <b>I know the original loan amount:</b><br>"
            + "   Select whether you know the original loan amount for your current loan.<br><br>"
            + "2. <b>Original Loan Amount ($):</b><br>"
            + "   Enter the original amount borrowed for your current loan.<br><br>"
            + "3. <b>Loan Term (Years):</b><br>"
            + "   Enter the total number of years for the term of your current loan.<br><br>"
            + "4. <b>Time Remaining:</b><br>"
            + "   Enter the remaining time left to pay off your current loan in years and months.<br><br>"
            + "5. <b>Interest Rate (%):</b><br>"
            + "   Enter the interest rate applied to your current loan.<br><br>"
            + "-----------------------------------------<br><br>"
            + "<b>New Loan:</b><br>"
            + "1. <b>New Loan Term (Years):</b><br>"
            + "   Enter the total number of years for the term of the new loan.<br><br>"
            + "2. <b>Interest Rate (%):</b><br>"
            + "   Enter the interest rate for the new loan.<br><br>"
            + "3. <b>Points:</b><br>"
            + "   Enter the number of points you are paying for the new loan. Points are prepaid interest, with 1 point equal to 1% of the loan amount.<br><br>"
            + "4. <b>Costs and Fees ($):</b><br>"
            + "   Enter the costs and fees associated with the new loan.<br><br>"
            + "5. <b>Cashout Amount ($):</b><br>"
            + "   Enter the amount of cash you want to take out as part of refinancing.<br><br>"
            + "-----------------------------------------<br><br>"
            + "<b>Buttons:</b><br>"
            + "1. <b>Calculate:</b><br>"
            + "   After entering all details for your current and new loan, click 'Calculate' to estimate the savings and monthly payment of refinancing.<br><br>"
            + "2. <b>Clear:</b><br>"
            + "   Click 'Clear' to reset all fields and start over.<br>"
            + "</html>";

        InstructionsRefinanceCalculator.setContentType("text/html");
        InstructionsRefinanceCalculator.setText(refinanceCalculatorInstructions);
    }
  
    private void setMessage12(){
        String downPaymentCalculatorInstructions = "<html>"
            + "<b>Upfront Cash Available:</b><br>"
            + "Enter the total amount of cash you have available for the upfront payment.<br><br>"
            + "<b>Down Payment:</b><br>"
            + "Enter the amount or percentage of the down payment you plan to make.<br><br>"
            + "<b>Include Closing Costs:</b><br>"
            + "Check this box if you want to include closing costs in the calculation. Enter the amount or percentage of the closing costs if applicable.<br><br>"
            + "<b>Interest Rate:</b><br>"
            + "Enter the interest rate for the loan (as a percentage).<br><br>"
            + "<b>Loan Term:</b><br>"
            + "Enter the duration of the loan in years.<br><br>"
            + "<b>Calculate Button:</b><br>"
            + "After entering all necessary fields, click 'Calculate' to determine how much house you can afford based on your available cash and down payment.<br><br>"
            + "<b>Clear Button:</b><br>"
            + "Click 'Clear' to reset all fields and start a new calculation."
            + "</html>";
        InstructionsDownPaymentCalculator.setContentType("text/html");
        InstructionsDownPaymentCalculator.setText(downPaymentCalculatorInstructions);


    }
    private void setMessage13(){
        String rentAndBuyCalculatorInstructions = "<html>"
            + "<h2>Home Purchase:</h2>"
            + "<b>Home Price:</b><br>"
            + "Enter the total purchase price of the home.<br><br>"
            + "<b>Down Payment:</b><br>"
            + "Enter the amount or percentage of the home price you plan to pay upfront as a down payment.<br><br>"
            + "<b>Interest Rate:</b><br>"
            + "Enter the annual interest rate for the mortgage (as a percentage).<br><br>"
            + "<b>Loan Term:</b><br>"
            + "Enter the duration of the loan in years.<br><br>"
            + "<b>Buying Closing Cost:</b><br>"
            + "Enter the closing costs for purchasing the home.<br><br>"
            + "<b>Property Taxes:</b><br>"
            + "Enter the annual property tax amount.<br><br>"
            + "<b>Property Taxes Increase:</b><br>"
            + "Enter the expected annual increase in property taxes (as a percentage).<br><br>"
            + "<b>Home Insurance:</b><br>"
            + "Enter the annual cost of home insurance.<br><br>"
            + "<b>HOA Fee:</b><br>"
            + "Enter the annual homeowners' association (HOA) fee.<br><br>"
            + "<b>Maintenance Cost:</b><br>"
            + "Enter the annual cost of maintaining the property.<br><br>"
            + "<b>Home Value Appreciation:</b><br>"
            + "Enter the expected annual appreciation of the home’s value (as a percentage).<br><br>"
            + "<b>Cost/Insurance Increase:</b><br>"
            + "Enter the expected annual increase in costs and insurance (as a percentage).<br><br>"
            + "<b>Selling Closing Cost:</b><br>"
            + "Enter the expected closing cost when selling the home.<br><br>"

            + "<h2>Home Rent:</h2>"
            + "<b>Monthly Rental Fee:</b><br>"
            + "Enter the monthly rental fee for the property.<br><br>"
            + "<b>Rental Fee Increase:</b><br>"
            + "Enter the expected annual increase in rental fees (as a percentage).<br><br>"
            + "<b>Renter's Insurance:</b><br>"
            + "Enter the annual cost of renter’s insurance.<br><br>"
            + "<b>Security Deposit:</b><br>"
            + "Enter the amount of the security deposit for the rental property.<br><br>"
            + "<b>Upfront Cost:</b><br>"
            + "Enter any other upfront costs associated with renting the property.<br><br>"

            + "<h2>Your Information:</h2>"
            + "<b>Average Investment Return:</b><br>"
            + "Enter the average annual return on investments you expect to make (as a percentage).<br><br>"
            + "<b>Marginal Federal Tax Rate:</b><br>"
            + "Enter your marginal federal tax rate (as a percentage).<br><br>"
            + "<b>Marginal State Tax Rate:</b><br>"
            + "Enter your marginal state tax rate (as a percentage).<br><br>"
            + "<b>Tax Filing Status:</b><br>"
            + "Select your tax filing status from the dropdown (e.g., Single, Married, etc.).<br><br>"

            + "<b>Calculate Button:</b><br>"
            + "Click 'Calculate' to compare the cost of buying versus renting based on the information provided.<br><br>"
            + "<b>Clear Button:</b><br>"
            + "Click 'Clear' to reset all fields and start a new calculation."
            + "</html>";
        InstructionsRentAndBuyCalculator.setContentType("text/html");
        InstructionsRentAndBuyCalculator.setText(rentAndBuyCalculatorInstructions);


    }
       private void setMessage14(){
      String PaceInstructions = "<html>"
        + "<b>Time:</b><br>"
        + "Enter the time your activity took.<br><br>"
        + "<b>Distance:</b><br>"
        + "Enter the distance you covered, Or choose from a list of popular distances<br><br>"
        + "</html>";
      jTextPane1.setContentType("text/html");
      jTextPane1.setText(PaceInstructions);
        }


    
    


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
             @Override
            public void run() {
                new Main().setVisible(true);
                new Main();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ALAmtOwnInput;
    private javax.swing.JButton ALCalcButton;
    private javax.swing.JTextField ALCashIncentivesInput;
    private javax.swing.JCheckBox ALCheckBox;
    private javax.swing.JButton ALClearButton;
    private javax.swing.JTextField ALDownPaymentInput;
    private javax.swing.JTextField ALInterestRateInput;
    private javax.swing.JTextField ALLoanTermInput;
    private javax.swing.JTextField ALOtherFeesInput;
    private javax.swing.JTextField ALPriceInput;
    private javax.swing.JLabel ALResultOutput;
    private javax.swing.JTextField ALSalesTaxInput;
    private javax.swing.JTextField ALTradeInValueInput;
    private javax.swing.JPanel AutoLoan;
    private javax.swing.JButton Caculateforpace;
    private javax.swing.JLabel CalculatorNameLBL;
    private javax.swing.JTabbedPane Calculators;
    private javax.swing.JButton ClearForPacecalc;
    private javax.swing.JPanel Currency;
    private javax.swing.JTextField CurrencyCalculatatorAmount;
    private javax.swing.JButton CurrencyCalculatorCalculateBTN;
    private javax.swing.JButton CurrencyCalculatorClear;
    private javax.swing.JComboBox<String> CurrencyCalculatorFrom;
    private javax.swing.JLabel CurrencyCalculatorOuput;
    private javax.swing.JComboBox<String> CurrencyCalculatorTO;
    private javax.swing.JButton DownPaymentCalculateBTN;
    private javax.swing.JButton DownPaymentClearBTN;
    private javax.swing.JTextField DownPaymentClosingCOst;
    private javax.swing.JComboBox<String> DownPaymentComboBox;
    private javax.swing.JTextField DownPaymentDownPayment;
    private javax.swing.JTextField DownPaymentInterestRate;
    private javax.swing.JTextField DownPaymentLoanTerm;
    private javax.swing.JLabel DownPaymentOuput;
    private javax.swing.JTextField DownPaymentUpfrontCash;
    private javax.swing.JCheckBox DownPaymnentCheckboxClosingCost;
    private javax.swing.JPanel FCcontrolBtn;
    private javax.swing.JPanel FitnessAndHealthCalculator;
    private javax.swing.JPanel HouseAffordabilityCalculator;
    private javax.swing.JTextPane InstructionsAutoLoan2Calculator;
    private javax.swing.JTextPane InstructionsAutoLoanCalculator;
    private javax.swing.JTextPane InstructionsDownPaymentCalculator;
    private javax.swing.JTextPane InstructionsHouseAffordabilityCalculator;
    private javax.swing.JTextPane InstructionsMortgageCalculator;
    private javax.swing.JTextPane InstructionsMortgagePayoffCalculator;
    private javax.swing.JTextPane InstructionsRateCalculator;
    private javax.swing.JTextPane InstructionsRefinanceCalculator;
    private javax.swing.JTextPane InstructionsRentAndBuyCalculator;
    private javax.swing.JTextPane InstructionsRentCalculator;
    private javax.swing.JTextPane InstructionsRetirementCalculator;
    private javax.swing.JTextPane InstructionsRothIRACalculator;
    private javax.swing.JPanel InterestRate;
    private javax.swing.JTextField InterestRateAnnualContribution;
    private javax.swing.JRadioButton InterestRateBeggnning;
    private javax.swing.JButton InterestRateCalculatorCalculateBTN;
    private javax.swing.JButton InterestRateCalculatorClearBTN;
    private javax.swing.JComboBox<String> InterestRateCompoundPeriods;
    private javax.swing.JRadioButton InterestRateEnd;
    private javax.swing.JTextField InterestRateInitialInvestment;
    private javax.swing.JTextField InterestRateInterest;
    private javax.swing.JTextField InterestRateInvestmentLengthYears;
    private javax.swing.JTextField InterestRateMonthlyContribution;
    private javax.swing.JLabel InterestRateOutput;
    private javax.swing.JButton InvestmentCalculatorBTN3;
    private javax.swing.JLabel KilometerLabel;
    private javax.swing.JLabel LabelAnnualContribution;
    private javax.swing.JPanel MathCalculator;
    private javax.swing.JLabel MileLabel;
    private javax.swing.JTextField MorgageCalculatorHomePrice;
    private javax.swing.JTextField MorgagePayoffCalculatorInterestRate;
    private javax.swing.JTextField MorgagePayoffRePayementExtraMonth;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel12;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel13;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel15;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel16;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel17;
    private javax.swing.JLabel MorgagePayoffRePayementExtraMonthLabel18;
    private javax.swing.JTextField MorgagePayoffRePayementExtraOneTime;
    private javax.swing.JLabel MorgagePayoffRePayementExtraOneTimeLabel;
    private javax.swing.JLabel MorgagePayoffRePayementExtraOneTimeLabel2;
    private javax.swing.JTextField MorgagePayoffRePayementExtraYear;
    private javax.swing.JLabel MorgagePayoffRePayementExtraYearlabel;
    private javax.swing.JLabel MorgagePayoffRePayementExtraYearlabel2;
    private javax.swing.JTextField MortGagePayoffRemainingTerm;
    private javax.swing.JTextField MortGagePayoffRemainingTermMonths;
    private javax.swing.JPanel MortgageCalculator2;
    private javax.swing.JComboBox<String> MortgageCalculatorDownPaymentCBox;
    private javax.swing.JTextField MortgageCalculatorHOAFee;
    private javax.swing.JComboBox<String> MortgageCalculatorHoaFeeCBox;
    private javax.swing.JLabel MortgageCalculatorHoaFeeLabel;
    private javax.swing.JTextField MortgageCalculatorHomeInsurance;
    private javax.swing.JComboBox<String> MortgageCalculatorHomeInsuranceCBox;
    private javax.swing.JLabel MortgageCalculatorHomeInsuranceLabel;
    private javax.swing.JCheckBox MortgageCalculatorIncudeTaxesandMOre;
    private javax.swing.JTextField MortgageCalculatorInterestRate;
    private javax.swing.JTextField MortgageCalculatorLoanTerm;
    private javax.swing.JComboBox<String> MortgageCalculatorMonthCbox;
    private javax.swing.JLabel MortgageCalculatorOUtput;
    private javax.swing.JTextField MortgageCalculatorOtherCost;
    private javax.swing.JComboBox<String> MortgageCalculatorOtherCostCBox;
    private javax.swing.JLabel MortgageCalculatorOtherCostLabel;
    private javax.swing.JTextField MortgageCalculatorPropertyTaxes;
    private javax.swing.JComboBox<String> MortgageCalculatorPropertyTaxesCbox;
    private javax.swing.JLabel MortgageCalculatorPropertyTaxesLabel;
    private javax.swing.JButton MortgagePayOffClearBTN;
    private javax.swing.JRadioButton MortgagePayoffBiweeklyRepayment;
    private javax.swing.JButton MortgagePayoffCalculateBTN;
    private javax.swing.JPanel MortgagePayoffCalculator;
    private javax.swing.JRadioButton MortgagePayoffCalculatorNormalPayment;
    private javax.swing.JTextField MortgagePayoffOriginalLoanTerm;
    private javax.swing.JLabel MortgagePayoffOutput;
    private javax.swing.JRadioButton MortgagePayoffPayAlltogether;
    private javax.swing.JRadioButton MortgagePayoffRepaymentWithExtraPayments;
    private javax.swing.JButton MortgageandRealEstateBTN;
    private javax.swing.JTextField MortgagepayoffCalculatorOriginalLoanAmount;
    private javax.swing.JButton MortgateCalculatorCaculateBTN;
    private javax.swing.JButton MortgateCalculatorClearBTN;
    private javax.swing.JTextField MortgateCalculatorDownPayment;
    private javax.swing.JTextField MortgateCalculatorYear;
    private javax.swing.JPanel OtherCalculator;
    private javax.swing.JButton OtherCalculatorsBTN1;
    private javax.swing.JPanel RefinanceCalculator;
    private javax.swing.JButton RefinanceCalculatorCalculateBTN;
    private javax.swing.JTextField RefinanceCalculatorCashout;
    private javax.swing.JButton RefinanceCalculatorClear;
    private javax.swing.JTextField RefinanceCalculatorCostandFees;
    private javax.swing.JComboBox<String> RefinanceCalculatorCurrentLoan;
    private javax.swing.JTextField RefinanceCalculatorInterestRate;
    private javax.swing.JLabel RefinanceCalculatorInterestRatelbl;
    private javax.swing.JLabel RefinanceCalculatorLoanTerm;
    private javax.swing.JTextField RefinanceCalculatorLoanTermtext;
    private javax.swing.JLabel RefinanceCalculatorMonthlyPaymentLbl;
    private javax.swing.JTextField RefinanceCalculatorMonthsPayment;
    private javax.swing.JTextField RefinanceCalculatorNewLoanTerm;
    private javax.swing.JLabel RefinanceCalculatorOutput;
    private javax.swing.JTextField RefinanceCalculatorPoints;
    private javax.swing.JTextField RefinanceCalculatorRemainingBalance;
    private javax.swing.JLabel RefinanceCalculatorRemainingBalanceLabel;
    private javax.swing.JTextField RefinanceCalculatorYearsPayment;
    private javax.swing.JLabel RefinanceCalculatorYearsandMonth;
    private javax.swing.JTextField RefinancecalculatorInterestRateNewLoan;
    private javax.swing.JButton RentCalculateBTN;
    private javax.swing.JPanel RentCalculator;
    private javax.swing.JButton RentClearBTN;
    private javax.swing.JComboBox<String> RentComboboxYearandMonth;
    private javax.swing.JTextField RentMonthlyDebt;
    private javax.swing.JLabel RentOutput;
    private javax.swing.JTextField RentPretaxIncome;
    private javax.swing.JTextField RetirementCalculatorAverageInvestmentReturn;
    private javax.swing.JButton RetirementCalculatorBTN2;
    private javax.swing.JButton RetirementCalculatorCalculateBTN;
    private javax.swing.JButton RetirementCalculatorClearBTN;
    private javax.swing.JTextField RetirementCalculatorCurrentAge;
    private javax.swing.JTextField RetirementCalculatorIncomeNeededAfterRetirement;
    private javax.swing.JTextField RetirementCalculatorLifeExpectancy;
    private javax.swing.JComboBox<String> RetirementCalculatorNeededAfterRetirementCbox;
    private javax.swing.JTextField RetirementCalculatorOtherIncomeAfterRetirement;
    private javax.swing.JLabel RetirementCalculatorOutput;
    private javax.swing.JTextField RetirementCalculatorPreTaxIncome;
    private javax.swing.JTextField RetirementCalculatorRetirementAge;
    private javax.swing.JTextField RetirementCalculatorYourCurrentRetirementSavings;
    private javax.swing.JTextField RothIRAAnualContribution;
    private javax.swing.JButton RothIRACalculateBTN;
    private javax.swing.JPanel RothIRACalculator;
    private javax.swing.JTextField RothIRACalculatorCurrentBalance;
    private javax.swing.JTextField RothIRACalculatorExpectedReturnRate;
    private javax.swing.JTextField RothIRACurrentAge;
    private javax.swing.JRadioButton RothIRAMaximizeNO;
    private javax.swing.JRadioButton RothIRAMaximizeYes;
    private javax.swing.JButton RothIRAclearBTN;
    private javax.swing.JLabel RothIRAoutput;
    private javax.swing.JTextField RothIRaRetirementAge;
    private javax.swing.JButton autoCalculatorBTN4;
    private javax.swing.JLabel azusena;
    private javax.swing.JButton btnChaseMe;
    private javax.swing.JButton btnChaseMe1;
    private javax.swing.JButton btnOtherCalculators;
    private javax.swing.JButton btnfinancialCalculator;
    private javax.swing.JButton btnfitnessCalculator;
    private javax.swing.JButton btnmathCalculator;
    private javax.swing.JButton dashboard;
    private javax.swing.JPanel deepThoughts;
    private javax.swing.JPanel downpaymentCalculator;
    private javax.swing.JPanel ekinator2;
    private javax.swing.JTextField firstNumber;
    private javax.swing.JTextField getdistance;
    private javax.swing.JTextField gettime;
    private javax.swing.JButton haCalcButton;
    private javax.swing.JButton haClearButton;
    private javax.swing.JComboBox<String> haDTIBox;
    private javax.swing.JTextField haDebtInput;
    private javax.swing.JComboBox<String> haDownPaymentBox;
    private javax.swing.JTextField haDownPaymentInput;
    private javax.swing.JComboBox<String> haHOABox;
    private javax.swing.JTextField haHOAInput;
    private javax.swing.JTextField haIncomeInput;
    private javax.swing.JComboBox<String> haInsuranceBox;
    private javax.swing.JTextField haInsuranceInput;
    private javax.swing.JTextField haInterestInput;
    private javax.swing.JTextField haLoanTermInput;
    private javax.swing.JComboBox<String> haPropertyTaxBox;
    private javax.swing.JTextField haPropertyTaxInput;
    private javax.swing.JLabel haResultOutput;
    private javax.swing.JTextPane instructionCurrencyCalculator;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField115;
    private javax.swing.JTextField jTextField116;
    private javax.swing.JTextField jTextField117;
    private javax.swing.JTextField jTextField118;
    private javax.swing.JTextField jTextField119;
    private javax.swing.JTextField jTextField120;
    private javax.swing.JTextField jTextField121;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField86;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel jorge;
    private javax.swing.JComboBox<String> operator;
    private javax.swing.JLabel osvaldo;
    private javax.swing.JPanel paceCalculator;
    private javax.swing.JLabel pedro;
    private javax.swing.JLabel pinkIcon;
    private javax.swing.JLabel pinkPanterCbtn;
    private javax.swing.JMenu quitBnt;
    private javax.swing.JPanel rentandbuy;
    private javax.swing.JPanel retirementCalculator3;
    private javax.swing.JTextField secondNumber;
    // End of variables declaration//GEN-END:variables
}
