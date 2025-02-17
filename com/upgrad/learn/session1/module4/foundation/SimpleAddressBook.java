package com.upgrad.learn.session1.module4.foundation;

import java.util.*;

class Record {    
String name;  
long number; 
}

class AddressBook{
	List<Record> list;

	public AddressBook() {  
		list=new LinkedList<Record>(); 
	}
	
public void add(String name, long number) {
	Record item = new Record(); 
    item.name = name;  
    item.number = number;
    list.add(item);
    System.out.println("Successfully added: " + item.name);
}
public void findByNumber(long number) {	
	int index = -1;
	for (Record b : list)
		   if (b.number == number) {
			   index = list.lastIndexOf(b);
			   break;
		   }
	if (index==-1)	      
		System.out.println("No such Number exists");
	else {
		Record item = list.get(index);
		System.out.println("Name: " + item.name);
	}	    
}

public void delete(long number) {
	int index = -1;
	for (Record b : list)
		   if (b.number == number) {
			   index = list.lastIndexOf(b);
			   break;
		   }
	if (index==-1)	      
		System.out.println("No such Number exists");
	else {
		list.remove(index);
		System.out.println("Successfully deleted: " + number);
	}
}
public void printAddressBook() {
	System.out.println("List of contacts:"); 
	for(Record r:list)
		System.out.println("Name: "+r.name+" Number: "+r.number);	      
}
}  
public class SimpleAddressBook {  
public static void main(String[] args) {  
	AddressBook myContacts = new AddressBook();
    myContacts.add("John", 9876123450l);
    myContacts.add("Mellisa", 8360789114l);
    myContacts.add("Daman",9494149900l);
    myContacts.findByNumber(9998760333l);
    myContacts.printAddressBook();
    myContacts.delete(9876123450l);
    myContacts.add("Gregory",7289880988l);
    myContacts.printAddressBook();
    myContacts.findByNumber(8360789114l);
    myContacts.add("Mary",7205678901l);
    myContacts.delete(9876123450l);
    myContacts.findByNumber(7205678901l);
    myContacts.printAddressBook();      
}  
}