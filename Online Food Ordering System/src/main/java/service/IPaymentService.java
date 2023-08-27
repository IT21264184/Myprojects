package service;

public interface IPaymentService {
	
	public void addPayment(String type, String cardNo, String ccv, String exp_date, String name);
	
	public String checkCardNo(long cardNo);
	
	public String checkCvv(int cvv);
	
	public String encrypt(String data);
	
	public String decrypt(String data);
}
