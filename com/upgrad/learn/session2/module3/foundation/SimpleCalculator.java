package com.upgrad.learn.session2.module3.foundation;

class Item{
	public int number1;
	public int number2;
	public int result;
	public char operation;
}

class Stack {
   private int maxSize;
   private Item[] stackArray;
   private int top;
 
   public Stack(int s) {
      maxSize = s;
      stackArray = new Item[maxSize];
      top = -1;
   }
   public void push(Item j) {
      stackArray[++top] = j;
   }
   public void displayOperationTop5() {
	   for (int i=top, j=0;i>=0 && j<5;i--, j++)
	   {
		   System.out.println(stackArray[i].number1 + " "+ stackArray[i].operation+" "+ stackArray[i].number2+" = "+ stackArray[i].result);
	   }
   }
   public int peek() {
	   return stackArray[top].result;
   }
   public void add(int number1, int number2) {
	   int result = number1 + number2;
	   System.out.println("Result: "+ result);
	   Item additem = new Item();
	   additem.number1 = number1;
	   additem.number2 = number2;
	   additem.operation = '+';
	   additem.result = result;
	   push(additem);
   }
   public void subtract(int number1, int number2) {
	   int result = number1 - number2;
	   System.out.println("Result: "+ result);
	   Item subitem = new Item();
	   subitem.number1 = number1;
	   subitem.number2 = number2;
	   subitem.operation = '-';
	   subitem.result = result;
	   push(subitem);
   }
   public void multiply(int number1, int number2) {
	   int result = number1 * number2;
	   System.out.println("Result: "+ result);
	   Item mulitem = new Item();
	   mulitem.number1 = number1;
	   mulitem.number2 = number2;
	   mulitem.operation = '*';
	   mulitem.result = result;
	   push(mulitem);
   }
   public void divide(int number1, int number2) {
	   int result = number1 / number2;
	   System.out.println("Result: "+ result);
	   Item divitem = new Item();
	   divitem.number1 = number1;
	   divitem.number2 = number2;
	   divitem.operation = '/';
	   divitem.result = result;
	   push(divitem);
   }
}

public class SimpleCalculator{
	public static void main(String[] args) {
	      Stack newStack = new Stack(10); 
	      newStack.add(2,3);
	      newStack.multiply(8,9);
	      newStack.displayOperationTop5();
	      newStack.divide(6,3);
	      newStack.subtract(45,44);
	      newStack.add(18,0);
	      newStack.multiply(6,newStack.peek());
	      newStack.displayOperationTop5();
	      newStack.divide(2,3);
	      newStack.subtract(3,newStack.peek());
	   }
}