package rocketData;

import java.io.Serializable;

public class LoanRequest implements Serializable {

	private static int iTerm;
	private static double dRate;
	private static double dAmount;
	private static int iCreditScore;
	private static int iDownPayment;
	private static double dPayment;
	private static double Income;
	private static double Expenses;
	
	public LoanRequest() {
		super();
		
	}
	public static int getiTerm() {
		return iTerm;
	}
	public void setiTerm(int iTerm) {
		this.iTerm = iTerm;
	}
	public static double getdRate() {
		return dRate;
	}
	public void setdRate(double dRate) {
		this.dRate = dRate;
	}
	public static double getdAmount() {
		return dAmount;
	}
	public void setdAmount(double dAmount) {
		this.dAmount = dAmount;
	}
	public static int getiCreditScore() {
		return iCreditScore;
	}
	public void setiCreditScore(int iCreditScore) {
		this.iCreditScore = iCreditScore;
	}
	public static int getiDownPayment() {
		return iDownPayment;
	}
	public void setiDownPayment(int iDownPayment) {
		this.iDownPayment = iDownPayment;
	}
	public static double getdPayment() {
		return dPayment;
	}
	public void setdPayment(double dPayment) {
		this.dPayment = dPayment;
	}
	
	public static double getIncome(){
		return Income;
	}
	public void setIncome(double Income){
		this.Income=Income;
	}
	public static double getExpenses(){
		return Expenses;
	}
	public void setExpenses(double Expenses){
		this.Expenses=Expenses;
	}
	
}
