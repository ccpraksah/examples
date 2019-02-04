package com.upgrad.learn.session1.module4.foundation;

import java.util.*;

class Record1 {    
String name;  
long number; 
int ID;
}

class AddressBook1{
	Record1[] list;
	
	public AddressBook1() {  
	list=new Record1[900]; 
	}
	
public void add(String name, long number, int ID) {
	Record1 item = new Record1(); 
    item.name = name;  
    item.number = number;
    item.ID = ID;
    list[ID-100]= item;
    System.out.println("Successfully added: " + item.name);
}
public void findByID(int ID) {
	if(list[ID-100]==null)
		System.out.println("No such ID exists");
	else
	    System.out.println("Name: " + list[ID-100].name+" Number: " + list[ID-100].number);
}

public void delete(int ID) {
	if(list[ID-100]==null)
		System.out.println("No such ID exists");
	else
	{
		System.out.println("Successfully deleted: " + list[ID-100].name);
		list[ID-100]=null;
	}
}
public void printAddressBook() {
	System.out.println("List of contacts:"); 
	for(Record1 r:list) {
		if(r!=null)
		System.out.println("Name: "+r.name+" ID: "+r.ID+" Number: "+r.number);
	}	      
}

}  
public class AddressBookMain {  
public static void main(String[] args) {  
	AddressBook1 myContacts = new AddressBook1();
    myContacts.add("John", 9876123450l, 101);
    myContacts.add("Mellisa", 8360789114l, 560);
    myContacts.add("Daman",9494149900l, 444);
    myContacts.findByID(999);
    myContacts.printAddressBook();
    myContacts.delete(101);
    myContacts.add("Gregory",7289880988l, 980);
    myContacts.printAddressBook();
    myContacts.findByID(560);
    myContacts.add("Mary",7205678901l, 670);
    myContacts.delete(101);
    myContacts.findByID(670);
    myContacts.printAddressBook();      
}  
}