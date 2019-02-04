package com.upgrad.learn.session1.module2.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class absdetail1{
	public String father = null;
	public abstract void setFather(String father);
	public abstract String getFather();
}

interface year1{
    public int getYear(int std);
}

class Student2 extends absdetail1{
	private String name = null;
	private int ANo;
	private int STD;

	public Student2(String name, int ANo, int STD) {
		this.name = name;
		this.ANo = ANo;
		this.STD = STD;
	}
	
	@Override
	public void setFather(String father) {
		this.father = father;
	}
	public String getFather() {
		return father;
	}
	public String getName() {
		return name;
	}

	public int getANo() {
		return ANo;
	}

	public int getSTD() {
		return STD;
	}
	public void quality(int ANo){
		if (ANo>= 10) {
			System.out.println("New student");
			return;
		} else {
			System.out.println("Old student");
			return;
		}
	}
}

class Report2 extends Student2 implements year{
	private int ptage;
	private String pass = null;
	public Report2(String name, int ANo, int STD, int ptage, String pass) {
		super(name, ANo, STD);
		this.ptage = ptage;
		this.pass = pass;
	}
	public int getptage() {
		return ptage;
	}
	public String getpass() {
		return pass;
	}
	@Override
    public int getYear(int std) {
		return (12-std);   
    }
	public void quality(int ANo, int average){
		if (this.getANo() == ANo)
		{
			if (ptage>= average) {
				System.out.println("Above average student");
				return;
			} else {
				System.out.println("Below average student");
				return;
			}
		}
	}
}

class Bus2 extends Student2 {
	private int route;
	private String BG = null;
	public Bus2(String name, int ANo, int STD, int route, String BG) {
		super(name, ANo, STD);
		this.BG = BG;
		this.route = route;
	}
	public String getBG() {
		return BG;
	}
	public int getroute() {
		return route;
	}
	@Override
	public void quality(int ANo){
		if (this.getANo() == ANo)
		{
			if (route>= 20) {
				System.out.println("Out of city student");
				return;
			} else {
				System.out.println("In-city student");
				return;
			}
		}
	}
}

public class PolyMorph {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strNums1, strNums2;
    	strNums1 = br.readLine().split("\\s");
    	strNums2 = br.readLine().split("\\s");
    	Report2 r1 = new Report2(strNums1[0], Integer.parseInt(strNums1[1]), Integer.parseInt(strNums1[2]), Integer.parseInt(strNums1[3]),strNums1[4]);
    	Report2 r2 = new Report2(strNums2[0], Integer.parseInt(strNums2[1]), Integer.parseInt(strNums2[2]), Integer.parseInt(strNums2[3]),strNums2[4]);
    	Bus2 b1 = new Bus2(strNums1[0], Integer.parseInt(strNums1[1]), Integer.parseInt(strNums1[2]), Integer.parseInt(strNums1[5]),strNums1[6]);
    	Bus2 b2 = new Bus2(strNums2[0], Integer.parseInt(strNums2[1]), Integer.parseInt(strNums2[2]), Integer.parseInt(strNums2[5]),strNums2[6]);
    	r1.setFather(strNums1[7]);
    	r2.setFather(strNums2[7]);
    	b1.setFather(strNums1[7]);
    	b2.setFather(strNums2[7]);
    	int n = Integer.parseInt(br.readLine());
    	if(n==r1.getANo()) {
    		System.out.println(r1.getName() +" "+ r1.getptage() + " "+b1.getroute()+ " "+b1.getFather());
    		System.out.println("You will graduate in " + r1.getYear(r1.getSTD())+ " years");
    		r1.quality(r1.getANo());
    		r1.quality(r1.getANo(),55);
    		b1.quality(r1.getANo());
    	}
    	else if(n==r2.getANo()){
    		System.out.println(r2.getName() +" "+ r2.getptage() + " "+b2.getroute()+ " "+b2.getFather());
    		System.out.println("You will graduate in " + r2.getYear(r2.getSTD())+ " years");
    		r2.quality(r2.getANo());
    		r2.quality(r2.getANo(),55);
    		b2.quality(r2.getANo());
    	}	
    	else
    		System.out.println("No entry found");
    }
}