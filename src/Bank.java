import java.util.List;

public class Bank {
	private String bankName;
	private String manager;
	private List<Account> accounts;
	
	public Bank(String bankName, String manager, List<Account> accounts) {
		this.bankName = bankName;
		this.manager = manager;
		this.accounts = accounts;
	}
	public String getBankName() {
		return bankName;
	}
	public String getManager() {
		return manager;
	}
	/**
	 * Method to calculate total assets in bank
	 * @return
	 */
	public double totalAssets() {
		double total = 0.0;
		for( Account a: accounts) {
			if(a.getStatusAccount().equals("Open")) {
				total += a.getCurrentBalance();
			}
		}
		return total;
	} 
	/**
	 * Method to add an new bank account in accounts list.
	 * @param a
	 */
	public void addAccount(Account a) {
		accounts.add(a);
	}
	/**
	 * Method to print a report of accounts list with bank total assets before and after interest is added. 
	 * @return
	 */
	public String printReport() {
		StringBuilder report = new StringBuilder();
		report = report.append(String.format("%s %s", " BK BANK\n","Manager: John Doe"+ "\n----------------------\n"));
		report.append("Account Holder     Account Number     Current Balance     	Status             Account Type\n");
		for (Account a: accounts) {
			report = report.append(String.format("%s %-17s %-20s %,.2f %15s %30s", a.getFirstName(),a.getLastName(), a.getAccountNumber(), a.getCurrentBalance(), a.getStatusAccount(), a.accountType())+"\n");
		}
		report = report.append(String.format("Total Assets: %,.2f", totalAssets())+"\n\nAdding interest...\n----------------------\n");
		report.append("Account Holder     Account Number     Current Balance     	Status              Account Type\n");
		for (Account a: accounts) {
			if(a.getStatusAccount().equals("Open")) {
				if(a.accountType().equals("SavingAccount")) {
				((SavingAccount)a).addInterest();
				} else if(a.accountType().equals("GoldSavingAccount")){
				((GoldSavingAccount)a).addInterest();
				} else if(a.accountType().equals("PlatinumSavingAccount")){
				((PlatinumSavingAccount)a).addInterest();
				}
			}
			report = report.append(String.format("%s %-20s %-20s %,.2f %15s %30s", a.getLastName(), a.getFirstName(), a.getAccountNumber(), a.getCurrentBalance(), a.getStatusAccount(), a.accountType())+"\n");
		}
		report = report.append(String.format("Total Assets: %,.2f", totalAssets())+"\n");
		return report.toString();
	}
}
