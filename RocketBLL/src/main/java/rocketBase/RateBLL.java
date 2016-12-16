package rocketBase;

import java.util.ArrayList;

import java.util.List;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static Object getRate(int score) throws RateException
	{
	
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		if(score==600){
			return(((RateDomainModel) rates.get(0)).getdInterestRate());}
			else if(score==650){
				return(((RateDomainModel) rates.get(1)).getdInterestRate());}
				else if(score==700){
					return(((RateDomainModel) rates.get(2)).getdInterestRate());}
					else if(score==750){
						return(((RateDomainModel) rates.get(3)).getdInterestRate());}
						else if (score==800) {
							return(((RateDomainModel) rates.get(4)).getdInterestRate());}
						else{
							return new RateException(score);}
	}
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n/12, p/12, f, t);
	}
}
