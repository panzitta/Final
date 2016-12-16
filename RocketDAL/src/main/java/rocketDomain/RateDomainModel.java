package rocketDomain;

public class RateDomainModel {

	private int iRateID;
	private static int iMinCreditScore;
	private static double dInterestRate;
	
	public RateDomainModel()
	{
		
	}

	public int getiRateID() {
		return iRateID;
	}

	public void setiRateID(int iRateID) {
		this.iRateID = iRateID;
	}

	public static int getiMinCreditScore() {
		return iMinCreditScore;
	}

	public void setiMinCreditScore(int iMinCreditScore) {
		this.iMinCreditScore = iMinCreditScore;
	}

	public static double getdInterestRate() {
		return dInterestRate;
	}

	public void setdInterestRate(double dInterestRate) {
		this.dInterestRate = dInterestRate;
	}
	
	
}
