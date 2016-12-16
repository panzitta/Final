package rocketBase;

import java.util.ArrayList;



import org.junit.Test;

import rocketDomain.RateDomainModel;

import static org.junit.Assert.*;

import org.junit.Test;



public class Rate_Test {

	
	@Test
	public void interestRate_Test(){
	
	int score=RateDomainModel.getiMinCreditScore();
	ArrayList rates = RateDAL.getAllRates();
	if(score==600){
		assert(((RateDomainModel) rates.get(0)).getdInterestRate()==5);}
		else if(score==650){
			assert(((RateDomainModel) rates.get(1)).getdInterestRate()==4.5);}
			else if(score==700){
				assert(((RateDomainModel) rates.get(2)).getdInterestRate()==4);}
				else if(score==750){
					assert(((RateDomainModel) rates.get(3)).getdInterestRate()==3.75);}
					else {
						assert(((RateDomainModel) rates.get(4)).getdInterestRate()==3.5);}
	
	}
		
	@Test
	public void test() {
		
	ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
	System.out.println ("Rates size: " + rates.size());
	assert(rates.size() > 0);
	
	}

}
