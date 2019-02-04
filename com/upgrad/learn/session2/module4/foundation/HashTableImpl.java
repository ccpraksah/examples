package com.upgrad.learn.session2.module4.foundation;

import java.util.*;

public class HashTableImpl {
	
	static Map<Credentials, AccountInfo> bankHash = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long counter = 10000000;//account number
		while(true) {
			counter++;
// 			System.out.println("Enter 1 for signIn and 2 for signUp");
			int signFlag = sc.nextInt();

			if(signFlag == 1) {
				signIn();
			}
			else if(signFlag == 2) {
				signUp(counter);
			}
			else {
//				System.out.println("Wrong input. Terminating the program.");
				break;
			}
		}
	}

	private static void signUp(long count) {
		// TODO Auto-generated method stub
		
		Credentials userUp = getVerifiedUser("signUp");
		if(userUp == null) {
			return;
		}
		
		if(bankHash.containsKey(userUp)) {
			return;
		}
		AccountInfo account = new AccountInfo();
		fillAccountDetails(account, count);
		bankHash.put(userUp, account);
	}

	
	private static void fillAccountDetails(AccountInfo account, long accNumber) {
		// TODO Auto-generated method stub
//		System.out.println("Enter the following account details: ");
//		System.out.println("Enter your name: ");
		account.setName(sc.next());
		//adding this line because scanner class will skip the first line after using nextLine() method.
		//refer this link https://stackoverflow.com/questions/7877529/java-string-scanner-input-does-not-wait-for-info-moves-directly-to-next-stateme
		sc.nextLine();
		
		
//		System.out.println("Enter the intial deposit amount: ");
		account.setBalance(sc.nextLong());
		sc.nextLine();
		account.setAccNum(sc.nextLong());
	}

	
	private static void signIn() {
		// TODO Auto-generated method stub
		Credentials user = getVerifiedUser("signIn");
		if(user == null) {
			return;
		}
		if(bankHash.containsKey(user)) {
//			System.out.println("Retrieving account details");
			AccountInfo acc = bankHash.get(user);
			System.out.println(acc.getAccNum());
		}
		else {
			System.out.println("-1");
		}
		
//		System.out.println("\n\n");
	}

	
	
	
	private static Credentials getVerifiedUser(String x) {
		// TODO Auto-generated method stub
//		System.out.println("Enter the following details to " + x + ": ");
//		System.out.println("username: ");
		String usrName = sc.next();
//		System.out.println("password: ");
		String pwd = sc.next();
//		System.out.println("mobile: ");
		long phone = Long.parseLong(sc.next());
		int length = (int) (Math.log10(phone) + 1);
		Credentials usr = new Credentials();
		usr.setMobile(phone);
		usr.setPassword(pwd);
		usr.setUsername(usrName);
		
		return usr;
	}

}


class Credentials {
	String username;
	String password;
	long mobile;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long phone) {
		this.mobile = phone;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	
	@Override
	public int hashCode() {
		final int prime = 31;
		long result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + mobile;
		return Long.hashCode(result);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Credentials other = (Credentials) obj;
		if(username == null) {
			if(other.username != null) {
				return false;
			}
		}
		else if(! username.equals(other.username)) {
			return false;
		}
		if(password == null) {
			if(other.password != null) {
				return false;
			}
		}
		else if(! password.equals(other.password)) {
			return false;
		}
		
		if(mobile != other.mobile) {
			return false;
		}
		
		return true;
	}
	
	
	
}


class AccountInfo {
	String name;
	long accNum, balance; 
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	

}

