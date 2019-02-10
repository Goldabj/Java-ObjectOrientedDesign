package goldacbj.finance;

public interface FinancailCustomer {
	public boolean addNewAccount(Account a);
	public boolean removeAccount(Account a);
	public int getId();
	public String getName();
}
