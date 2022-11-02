
public class SavingAccount extends Account implements InterestBearingAccount{
	private final double INTEREST_RATE = 0.03;
	
	public SavingAccount(String firstName, String lastName, String accountNumber, double currentBalance, int statusAccount) {
		super(firstName, lastName, accountNumber, currentBalance, statusAccount);
	}
	/**
	 * Method to add interest to current balance.
	 */
	public void addInterest() {
		this.addBalance(getCurrentBalance()*INTEREST_RATE);
	}
	/**
	 * Method to return an account's type.
	 */
	public String accountType() {
		return "SavingAccount";
	}
}

