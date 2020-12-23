package proxy_bankaccount;
import proxy_bankaccount.model.*;

public class BankAccount {
	public static void main(String[] args) {
		Person johnny = new Person("Johnny", 14);
		
		AccountProxy johnnyAccount = new AccountProxy(johnny);
		johnnyAccount.deposit(johnny, 200);
		
		System.out.print("Johnny tries to withdraw: ");
		if(johnnyAccount.withdraw(johnny, 15))
			System.out.println("he did it!");
		else
			System.out.println("he can't!");
		
		Person sarah = new Person("Sarah", 40);
		
		System.out.print("Sarah tries to withdraw: ");
		if(johnnyAccount.withdraw(sarah, 15))
			System.out.println("she did it!");
		else
			System.out.println("she can't!");
		
		
		johnny.addParent(sarah);
		
		System.out.print("Sarah tries to withdraw: ");
		if(johnnyAccount.withdraw(sarah, 15))
			System.out.println("she did it!");
		else
			System.out.println("she can't!");
		
	}
}
