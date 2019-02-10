package goldacbj.finance;

public class ConsumerAccount extends AbstractAccount implements MoneyMarket {
	public final int MAX_WITHDRAW = 750;
	public static final String ACC_TYPE = "ConsumerAccount";
	
	public ConsumerAccount() {
	}
	
	@Override
	public int removeFromBalance(int toRemove) {
		if (toRemove > MAX_WITHDRAW) {
			return super.removeFromBalance(MAX_WITHDRAW);
		}
		return super.removeFromBalance(toRemove);
	}
	
	@Override
	public String getType() {
		return ACC_TYPE;
	}
	
	

}
