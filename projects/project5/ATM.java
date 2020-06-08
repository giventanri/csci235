/**
 * ATM.java
 * 
 * Class to represent an ATM
 *
 * @author Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Project 5
 * Date 20200408
 */

public class ATM {

    // Instance variables
    /**
     * The number of USD 5 bills available in this ATM.
     */
    private int cashUSD005;

    /**
     * The number of USD 20 bills available in this ATM.
     */
    private int cashUSD020;

    
    // Constructors
    /**
     * Default constructor for initializing a ATM's instance variables.
     * The ATM will have USD 0 cash available. 
     */
    public ATM() {
        this.cashUSD005 = 0;
	this.cashUSD020 = 0;
    }

    /**
     * Constructor for initializing a ATM's instance variables.
     * The ATM will hold a USD amount as indicated by the parameters.
     * @param fives The number of USD 5 bills initially available in this ATM.
     * @param twenties The number of USD 20 bills initially available in this ATM.
     */
    public ATM(int fives, int twenties) {
        this.cashUSD005 = fives;
	this.cashUSD020 = twenties;
    }


    // toString()   
    /**
     * toString() to display the available USD bills and USD amount in this ATM.
     * @return The available USD bills and USD amount in this ATM
     */
    public String toString() {
	return "\n" + 
	    ">> ATM now has" + "\n>>\t" +
	    this.cashUSD020 + " twenty dollar bill(s) and " +
	    this.cashUSD005 + " five dollar bill(s): $" +
	    billsToUSD(cashUSD005, cashUSD020) + "\n";
    }

    
    // withdraw() and its helper methods 
    /**
     * Withdraw sufficient USD bills as indicated by the amount.
     * @param amount The USD amount to be withdrawn
     * @return withdrawn The USD amount successfully withdrawn
     * PRECONDITION: The amount is a positive integer and a multiple of 5. 
     * POSTCONDITION: The bills in this ATM are decremented accordingly to match
     *                the amount of transaction
     */  
    public int withdraw(int amount) {
	int transactionAmount = amount;
	transactionAmount = withdrawTwenties(transactionAmount);
	transactionAmount = withdrawFives(transactionAmount);
	int withdrawn = amount - transactionAmount;
	return withdrawn;
    }

    /**
     * Withdraw sufficient USD 20 bills as indicated the amount.
     * @param amount The USD amount to withdraw
     * @return change The remaining USD amount to be withdrawn using smaller bills
     * PRECONDITION: amount is a positive integer.
     * POSTCONDITION: cashUSD020 of this ATM is decremented by 
     *                the number of bills necessary for the transaction. 
     */
    private int withdrawTwenties(int amount) {
	int twentiesWithdrawn = amount / 20;

	if (this.cashUSD020 < twentiesWithdrawn) {
	    twentiesWithdrawn = this.cashUSD020;
	}
	    
	this.cashUSD020 -= twentiesWithdrawn;
	
	int change = amount - billsToUSD(0, twentiesWithdrawn);
	return change;
    }

    /**
     * Withdraw sufficient USD 5 bills as indicated the amount.
     * @param amount The USD amount to withdraw
     * @return change The remaining USD amount to be withdrawn using smaller bills
     * PRECONDITION: amount is a positive integer.
     * POSTCONDITION: cashUSD005 of this ATM is decremented by 
     *                the number of bills necessary for the transaction. 
     */
    private int withdrawFives(int amount) {
	int fivesWithdrawn = amount / 5;

	if (this.cashUSD005 < fivesWithdrawn) {
	    fivesWithdrawn = this.cashUSD005;
	}
	this.cashUSD005 -= fivesWithdrawn;
	
	int change = amount - billsToUSD(fivesWithdrawn, 0);
	return change;
    }


    // addTwenties()
    /**
     * Add sufficient USD 20 bills as indicated the amount.
     * @param twentiesAdded The number of USD 20 bills to be added
     * PRECONDITION: twentiesAdded is a positive integer
     * POSTCONDITION: cashUSD020 of this ATM is incremented by
     *.               twentiesAdded. 
     */
    public void addTwenties(int twentiesAdded) {
	this.cashUSD020 += twentiesAdded;
    }

    // addFives()
    /**
     * Add sufficient USD 5 bills as indicated the amount.
     * @param fivesAdded The number of USD 5 bills to be added
     * PRECONDITION: fivesAdded is a positive integer
     * POSTCONDITION: cashUSD005 of this ATM is incremented by
     *.               fivesAdded. 
     */
    public void addFives(int fivesAdded) {
	this.cashUSD005 += fivesAdded;
    }

    //Other helper methods
    /**
     * Convert amount of bills to USD.
     * @param fives The number of USD 5 bills
     * @param twenties The number of USD 20 bills
     * @return amountUSD The total USD value of the inputted bills
     * PRECONDITION: No negative number of bills.
     */
    public static int billsToUSD(int fives, int twenties) {
	int fivesToUSD = fives * 5;
	int twentiesToUSD = twenties * 20;
	int amountUSD = fivesToUSD + twentiesToUSD;
	return amountUSD;
    }

    /**
     * Return the available USD in this ATM 
     * @return funds The available USD in this ATM
     */
    public int getAmount() {
	int funds = billsToUSD(this.cashUSD005, this.cashUSD020);
	return funds;
    }
    
    /** Return the number of USD 5 bills in this ATM 
     * @return bills The number of USD 5 bills in this ATM
     */
    public int getFives() {
	int bills = this.cashUSD005;
	return bills;
    }

    /** Return the number of USD 20 bills in this ATM 
     * @return bills The number of USD 20 bills in this ATM
     */
    public int getTwenties() {
	int bills = this.cashUSD020;
	return bills;
    }
}
