package rocketBase;

import static org.junit.Assert.*;


import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {
	
	@Test
	public void RocketBLL_rate_Test() throws RateException{
	int score=RateDomainModel.getiMinCreditScore();
	if(score==600){
		assert((double)RateBLL.getRate(600)==5);}
		else if(score==650){
			assert((double)RateBLL.getRate(650)==4.5);}
			else if(score==700){
				assert((double)RateBLL.getRate(700)==4);}
				else if(score==750){
					assert((double)RateBLL.getRate(750)==3.75);}
					else {
						assert((double)RateBLL.getRate(800)==3.5);}
	}
	
	
	
	@Test (expected=RateException.class)
	public void Exception_Test() throws RateException{
		RateBLL.getRate(0);
	}
	
	@Test
	public void Payment_Test(){
		
		assert(Math.round(RateBLL.getPayment(.04, 360, 300000, 0, false))==-1432.25);
	}
	
	
	
	@Test
	public void test() {
		assert(1==1);
	}

}
