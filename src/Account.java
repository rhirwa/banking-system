
public abstract class Account{
	private String firstName;
	private String lastName;
	private String accountNumber;
	private double currentBalance;
	private int statusAccount;
	
	public Account(String firstName, String lastName, String accountNumber, double currentBalance, int statusAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.statusAccount = statusAccount;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance() {
		
	}
	/**
	 * Method to add new amount to current balance.
	 * @param amount
	 */
	public void addBalance(double amount) {
		this.currentBalance += amount;
	}
	/**
	 * Method to subtract subtracted amount from current balance.
	 * @param amount
	 */
	public void subtractBalance(double amount) {
		this.currentBalance -= amount;
	}

	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", accountNumber=" + accountNumber
				+ ", currentBalance=" + currentBalance + ", statusAccount=" + statusAccount + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getStatusAccount() {
		String status = "Open";
		if(statusAccount == 0) {
			status = "Closed";
		}
		return status;
	}
	public abstract String accountType();
	
}
