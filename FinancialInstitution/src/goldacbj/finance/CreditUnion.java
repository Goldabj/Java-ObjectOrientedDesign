package goldacbj.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditUnion implements FinancialInstitution {
	private List<Account> accounts;
	private String name;
	private Map<String,	Class<? extends Account>> accountTypes;
 

	public CreditUnion(String name) {
		this.name = name;
		this.accounts = new ArrayList<>();
		this.accountTypes = new HashMap<>();
		addSupportedAccounts();
	}
	
	private void addSupportedAccounts() {
		this.accountTypes.put(ConsumerAccount.ACC_TYPE, ConsumerAccount.class);
		this.accountTypes.put(CommercailAccount.ACC_TYPE, CommercailAccount.class);
		this.accountTypes.put(CertificateOfDeposit.ACC_TYPE, CertificateOfDeposit.class);
	}

	@Override
	public boolean addNewAccount(FinancailCustomer c, String type) {
		Class<? extends Account> accType = this.accountTypes.get(type);
		if (accType == null) {
			return false;
		}
		Account acc = null;
		try {
			acc = accType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}
		if (acc != null) {
			acc.setOwner(c);
		}
		return true;
		

	}

	@Override
	public boolean removeAccount(Account a) {
		return this.accounts.remove(a);
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean processTransaction(Transaction t) {
	 
		return false;
	}
	
	

}
