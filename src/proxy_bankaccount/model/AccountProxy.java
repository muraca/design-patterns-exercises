package proxy_bankaccount.model;

public class AccountProxy {
	
	private class RealAccount {
		
		Person owner;
		private float balance;
		
		RealAccount(Person p) {
			this.owner = p;
			this.balance = 0;
		}
		
		void addToBalance(float f) {
			balance += f;
		}
		
		void removeFromBalance(float f) {
			balance -= f;
		}

		public float getBalance() {
			return balance;
		}
	}
	
	private RealAccount account;
	
	public AccountProxy(Person p) {
		account = new RealAccount(p);
	}
	
	public void deposit(Person p, float amount) {
		account.addToBalance(amount);
	}
	
	public boolean withdraw(Person p, float amount) {
		if((p == account.owner && p.isAdult()) ^ account.owner.isChildOf(p)) {
			if(amount <= account.getBalance()) {
				account.removeFromBalance(amount);
				return true;
			}
		}
		return false;
		
	}
}
