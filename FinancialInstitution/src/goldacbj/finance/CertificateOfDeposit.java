package goldacbj.finance;

public class CertificateOfDeposit extends AbstractAccount {
	public static final String ACC_TYPE = "CD";

	public CertificateOfDeposit() {
	}

	@Override
	public String getType() {
		return ACC_TYPE;
	}

}
