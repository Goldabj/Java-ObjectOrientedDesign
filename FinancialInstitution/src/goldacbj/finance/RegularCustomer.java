package goldacbj.finance;

import java.util.ArrayList;
import java.util.List;

public class RegularCustomer implements FinancailCustomer {
	private List<Account> accounts;
	private String name;
	private final int ID;

	public RegularCustomer(String name, int id) {
		this.accounts = new ArrayList<>();
		this.name = name;
		this.ID = id;
	}

	@Override
	public boolean addNewAccount(Account a) {
		return this.accounts.add(a);
		
	}

	@Override
	public boolean removeAccount(Account a) {
		return this.accounts.remove(a);
	}

	@Override
	public int getId() {
		return this.ID;
	}

	@Override
	public String getName() {
		return this.name;
	}
	

}
