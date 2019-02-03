package com.upgrad.phonebook;
import java.io.*;
import java.util.*;

public class Source {  
public static void main(String[] args) throws IOException {  
	addressBook myContacts = new addressBook();
	Scanner br = new Scanner(System.in);		
		System.out.println("Choose one of the following options:");
		System.out.println("1. Add a contact");
		System.out.println("2. Delete a contact");
		System.out.println("3. Find a contact");
		System.out.println("4. Print existing contacts");
		System.out.println("0. Exit the phonebook");
		int n = br.nextInt();
		while(n!=0) {
		switch(n) {
		case 1: {
			System.out.println("Enter the name and number space separated");
			String[] strNums;
			Scanner sc = new Scanner(System.in);
			strNums = sc.nextLine().split("\\s");
			myContacts.add(strNums[0], Long.parseLong(strNums[1]));
			break;
		}
		case 2: {
			System.out.println("Enter the name to delete");
			Scanner sc = new Scanner(System.in);
			myContacts.delete(sc.nextLine());
			break;
		}
		case 3: {
			System.out.println("Enter the name to find");
			Scanner sc = new Scanner(System.in);
			myContacts.findByName(sc.nextLine());
			break;
		}
		case 4: {
			myContacts.printAddressBook();
			break;
		}
		default: {
			System.out.println("Wrong option");
			break;
		}
		}
		n=br.nextInt();
		}
		if(n==0) {
			System.out.println("Phonebook application terminated");
			
		}
		br.close();
		
	}
}  

