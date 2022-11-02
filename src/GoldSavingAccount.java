
public class GoldSavingAccount extends SavingAccount{
	private final double INTEREST_RATE = 0.06;
	
	public GoldSavingAccount(String firstName, String lastName, String accountNumber, double currentBalance, int statusAccount) {
		super(firstName, lastName, accountNumber, currentBalance, statusAccount);
	}
	/**
	 * Method to add interest to current balance.
	 */
	public void addInterest() {
		this.addBalance(getCurrentBalance()*INTEREST_RATE);
	}
	/**
	 * Method to return account's type.
	 */
	public String accountType() {
		return "GoldSavingAccount";
	}
}
