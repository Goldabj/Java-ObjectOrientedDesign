package goldacbj.finance;

public class CommercailAccount extends AbstractAccount implements MoneyMarket {
	public static final String ACC_TYPE = "CommercailAccount";

	public CommercailAccount() {
	}
	
	@Override 
	public String getType() {
		return ACC_TYPE;
	}

}
