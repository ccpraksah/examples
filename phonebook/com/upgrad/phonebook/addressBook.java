package com.upgrad.phonebook;
import java.util.*;

class Record {    
String name;  
long number;  
}

class addressBook{
	Record[] list;
	int last = -1;
	
	public addressBook() {  
	list=new Record[10]; 
	}

int findBestIndex(String name, int left, int right){	    
	    if(left > right) {
	        return 0;
	    }
	    int mid = -1; 

	    while (left <= right) {
	        mid = (left + right) / 2;
	        if (list[mid].name.compareTo(name) > 0) {
	            right = mid - 1;
	        }
	        else if (list[mid].name.compareTo(name) < 0) {
	            left = mid + 1;
	        }
	        else
	            break;
	    }
	    return (list[mid].name.compareTo(name) > 0) ? mid : mid + 1;	    
}

int findIndex(String name, int start, int end){
	int mid=-1;
    int low = start;
    int high = end;

    while (low <= high) {
        mid = (low + high) / 2;
        if (list[mid].name.compareTo(name) < 0)
            low = mid + 1;
        else if (list[mid].name.compareTo(name) > 0) 
            high = mid - 1;
        else 
            break;
    }
    if(low > high)
        return -1;
    else
        return mid;	
}
	
public void add(String name, long number) {
	Record item = new Record(); 
    item.name = name;  
    item.number = number;
    int a = findBestIndex(name, 0, last);
    for(int i = last;i>=a;i--)
    	list[i+1] = list[i];
    list[a]= item;
    last++;
    System.out.println("Successfully added: " + item.name);
}
public void findByName(String name) {
		int a = findIndex(name, 0, last); 
		if(a==-1)
		System.out.println("No such name exists");
		else
	    System.out.println("Phone number: " + list[a].number);
}

public void delete(String name) {
	int a = findIndex(name, 0, last); 
	if(a==-1)
	System.out.println("No such name exists");
	else
	{
		for(int i = a;i<last;i++)
	    	list[i] = list[i+1];
		list[last] = null;
		last--;
		System.out.println("Successfully deleted: " + name);
	}
}
public void printAddressBook() {
	System.out.println("List of contacts:"); 
	for(int a =0; a<=last; a++)
	    System.out.println("Name: "+list[a].name+", Number: "+list[a].number);  
	}
}