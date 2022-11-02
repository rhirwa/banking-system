
public class CheckingAccount extends Account{
	
	public CheckingAccount(String firstName, String lastName, String accountNumber, double currentBalance, int statusAccount) {
		super(firstName, lastName, accountNumber, currentBalance, statusAccount);
	}
	/**
	 * Method to determine account type.
	 */
	public String accountType() {
		return "CheckingAccount";
	}
}
