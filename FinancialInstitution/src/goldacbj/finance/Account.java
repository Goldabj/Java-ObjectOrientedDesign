package goldacbj.finance;

public interface Account {
	/**
	 * Sets the owner to the account. If there is already
	 * an owner of the account then this function will return false
	 * 
	 * @param c
	 * @return
	 * 			
	 */
	public boolean setOwner(FinancailCustomer c);
	public int getBalance();
	public void addToBalance(int toAdd);
	
	/**
	 * remove the amount from the account. This will not remove any more 
	 * than the account has
	 * 
	 * @param
	 * @return 
	 * 		- The amount that was actually removed
	 */
	public int removeFromBalance(int toRemove);
	
	/**
	 * returns a string representing the type of account
	 * 
	 * @return
	 */
	public String getType();
}
