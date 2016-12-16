package exceptions;

import java.util.ArrayList;

import rocketBase.RateDAL;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {
		Object RateDomainModel;
		
	public RateException(int score){	
		super();
	}
	
	public Object getRateException(){
		return RateDomainModel;
		
	}


	
}
