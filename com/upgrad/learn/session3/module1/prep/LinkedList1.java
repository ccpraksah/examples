package com.upgrad.learn.session3.module1.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Linkedlist{
	Node head;
	public void moveLastElementToHead()
	{
		if(head == null || head.next == null) 
            return;
		Node prev = null;
		Node last = head;
		while (last.next != null)  
		{
			prev = last;
			last = last.next;
		}
		prev.next = null;
		last.next = head;
		head = last;
	}
	public void push(int data)
   	 {
		Node new1 = new Node(data);
		if(head == null)
		{
			head = new1;
			return;
		}		
        		Node last = head;
        		while (last.next != null)  
			last = last.next;
       		 last.next = new1;
   	 }
	public void printList()
    	{
        		Node temp = head;
        		while(temp != null)
        		{
          		 System.out.print(temp.data+" ");
           		temp = temp.next;
        		}  
   	 }
	class Node
	{
		int data;
		Node next;
		Node(int d) 
		{
			this.data = d; 
			this.next = null; 
		}
	}
}

public class LinkedList1 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt (br.readLine());
    	Linkedlist object = new Linkedlist();
    	String[] strNums;
    	strNums = br.readLine().split("\\s");
    	for (int i=0 ; i<n ; i++)
    		object.push(Integer.parseInt(strNums[i]));
    	object.moveLastElementToHead();
    	object.printList();
    }
}