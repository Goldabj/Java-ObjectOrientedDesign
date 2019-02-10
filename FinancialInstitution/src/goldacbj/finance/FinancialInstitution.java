package goldacbj.finance;

public interface FinancialInstitution {	
	
	/**
	 * This adds a new account to the financial Institution 
	 * for the given customer. 
	 * 
	 * @param a
	 */
	public boolean addNewAccount(FinancailCustomer c, String type);
	
	/**
	 * remove the account from the accounts this financail Instution manages
	 * 
	 * @param a
	 * 			- the Account to remove
	 * @return
	 * 		- True if the account was sucessfully remove
	 */
	public boolean removeAccount(Account a);
	
	/**
	 * returns the name of the Financial Instution 
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Processes the transaction if it is a valid transaction
	 * 
	 * @param t
	 * 			- Transaction to process
	 * @return
	 * 		- true if the transaction was sucessfully processes
	 */
	public boolean processTransaction(Transaction t);
	

	
}
