package rocket.app.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.ss.usermodel.Textbox;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private static MainApp mainApp;

	
	private Textbox txtIncome;
	private Textbox txtExpenses;
	private static Textbox txtCreditScore;
	private Textbox txtHouseCost;
	private static ComboBox cmbTerm;
	private Label Income;
	private Label Expenses;
	private static Label HouseCost;
	private Label CreditScore;
	private Label Term;
	private Label lblMortgagePayment;
	private Button CalcLoanbtn;
	private Label Error;
	private Label pay;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	public static void RocketMainController(double r, int n, double p, double f, boolean t){
		RateBLL.getPayment(r, n, p, f, t);
		 
	}
	
	@FXML
	public static void btnCalculatePayment(ActionEvent event)
	{
		Object message = event;
		RocketMainController(LoanRequest.getdRate(),LoanRequest.getiTerm(),LoanRequest.getdAmount(),0,false);
		
		
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		lq.setdRate(LoanRequest.getdRate());
		lq.setiTerm(LoanRequest.getiTerm());
		lq.setdAmount(LoanRequest.getdAmount());
		lq.setiCreditScore(LoanRequest.getiCreditScore());
		lq.setiDownPayment(LoanRequest.getiDownPayment());

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//CALL NEW FUNCT
		DecimalFormat f = new DecimalFormat("##.00");
		
		String lrequest=(lRequest.toString());
		pay.setText(f.format(lrequest));
		
	}
	
	public  void HandleLoanRequestError(LoanRequest lRequest){
		
	double PITI1 = LoanRequest.getIncome()/12 *.28;
	double PITI2 = LoanRequest.getIncome()/12*.36 - LoanRequest.getExpenses();
	double PITI=0;
	if (PITI1>=PITI2){
		PITI=PITI2;
	}
	else{
		PITI=PITI1;
	}
	if (PITI>LoanRequest.getdPayment()){
		HandleLoanRequestDetails(lRequest);
	}
	else{
		pay.setText("Cannot afford payment.");
	}
	
	}
}
