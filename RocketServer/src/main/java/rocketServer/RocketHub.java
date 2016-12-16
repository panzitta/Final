package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketBase.RateDAL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) throws RateException {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			int score = rocketDomain.RateDomainModel.getiMinCreditScore();
			if (RateBLL.getRate(score)==new RateException(score)){
				System.out.println("RateException");
				
			}
			else{
				double r=(double) RateBLL.getRate(score);
				double n=lq.getiTerm();
				double p=lq.getdAmount();
				double f =lq.getdAmount() ;
				double pay=RateBLL.getPayment(r, n, p, f, false);
				lq.setdPayment(pay);
				sendToAll(lq);
			
			}
		}
	}
}
