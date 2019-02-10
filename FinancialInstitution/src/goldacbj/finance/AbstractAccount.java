package goldacbj.finance;

public abstract class AbstractAccount implements Account {
	private FinancailCustomer owner;
	private int balance;

	public AbstractAccount() {
		this.owner = null;
		this.balance = 0;
	}

	@Override
	public boolean setOwner(FinancailCustomer c) {
		if (this.owner != null) 
			return false;
		this.owner = c;
		return true;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public void addToBalance(int toAdd) {
		this.balance += toAdd;
		
	}

	@Override
	public int removeFromBalance(int toRemove) {
		if (toRemove > this.balance) {
			int temp = this.balance;
			this.balance = 0;
			return temp;
		}
		this.balance -= toRemove;
		return toRemove;
	}
	
	

}
