import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankDriver {
	/**
	 * Method to parse data into one list.
	 * @return
	 */
	public static List<Account> parseDataFile(){
		List<Account> result = new ArrayList<>();
		File f = new File("data/Account.csv");
		try(Scanner s = new Scanner(f)){
			s.nextLine().trim();
			while(s.hasNext()) {
				Account e = null;
				String line = s.nextLine();
				String tokens[] = line.split(",");
				if (tokens.length  == 1) {
					continue;
				}
				else {
				String fullName = tokens[0];
				String firstName = fullName.split(" ")[0];
				String lastName = fullName.split(" ")[1];
				String accountNumber = tokens[1];
				double currentBalance = Double.parseDouble(tokens[3]);
				int statusAccount = Integer.parseInt(tokens[4]);
				if(tokens[2].equals("C")) {
					e = new CheckingAccount(firstName, lastName, accountNumber, currentBalance, statusAccount);
				}
				else if(tokens[2].equals("S")){
					e = new SavingAccount(firstName, lastName, accountNumber, currentBalance, statusAccount);
				}
				else if(tokens[2].equals("G")) {
					e = new GoldSavingAccount(firstName, lastName, accountNumber, currentBalance, statusAccount);
				}
				else {
					e = new PlatinumSavingAccount(firstName, lastName, accountNumber, currentBalance, statusAccount);
				}
				result.add(e);
			}
			}
			s.close();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		};
		return result;
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank("BK BANK", "John Doe", parseDataFile());
		System.out.println(bank.printReport());
	}

}
