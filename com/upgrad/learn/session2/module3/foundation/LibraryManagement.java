package com.upgrad.learn.session2.module3.foundation;

import java.util.*;  
class Book {  
int id;  
String name,author;  
int issueDate, returnDate;  
}

class ListOfBooks{
	List<Book> list;
	
	public ListOfBooks() {  
	list=new LinkedList<Book>();  
	}

public void add(int id, String name, String author, int issueDate, int returnDate) {
	Book item = new Book();
	item.id = id;  
    item.name = name;  
    item.author = author;  
    item.issueDate = issueDate;  
    item.returnDate = returnDate;
    list.add(item);
    System.out.println("Successfully added: " + item.id);
}
public void edit(int id, String name, String author, int issueDate, int returnDate) {
	int index = -1;
	for (Book b : list)
		   if (b.id == id) {
			   index = list.lastIndexOf(b);
			   break;
		   }
	if (index==-1)	      
		System.out.println("No such Book ID exists");
	else {
		Book item = new Book();
		item.id = id;  
	    item.name = name;  
	    item.author = author;  
	    item.issueDate = issueDate;  
	    item.returnDate = returnDate;
	    list.remove(index);
	    list.add(index, item);
	    System.out.println("Successfully edited: " + item.id);
	}
}
public void delete(int id) {
	int index = -1;
	for (Book b : list)
		   if (b.id == id) {
			   index = list.lastIndexOf(b);
			   break;
		   }
	if (index==-1)	      
		System.out.println("No such Book ID exists");
	else {
	    list.remove(index);
	    System.out.println("Successfully deleted: " + id);
	}
}
public void printDatabase() {
	System.out.println("List of books:");
	for(Book b:list){  
	    System.out.println("ID: "+b.id+", Name: "+b.name+", Author: "+b.author+", Date of Issue: "+b.issueDate+", Date of Return: "+b.returnDate);  
	    }
}

}  
public class LibraryManagement {  
public static void main(String[] args) {  
	ListOfBooks database = new ListOfBooks();
    database.add(234,"Hamlet","W. Shakespeare",27,29); 
    database.add(35,"Relativity","Albert Einstein",15,30);
    database.add(2,"Data Sciences","Shan B",1,4); 
    database.edit(2,"Data Sciences","Shan B",1,8);
    database.delete(35);
    database.printDatabase();
    database.add(120,"Crooked House","Agatha Christie",15,28);
    database.edit(235,"Hamlet","W. Shakespeare",28,29);
    database.add(121,"The final problem","Arthur Doyle",13,20);
    database.delete(234);
    database.printDatabase();      
}  
}