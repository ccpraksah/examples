package upgrad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class RunApp {
	static BufferedReader br = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List of weak passwords
		String fileLocation1 = "/home/buddharajupurandhar/eclipse-workspace/BloomFilterApp/data/alleged-gmail-passwords.txt";
		try {
			br = new BufferedReader(new FileReader(fileLocation1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int counter = 3500000; // to use 2/3 to build bloom filter and use 1/3 to test the bloom filter.
		int initial_counter = counter;
		int numFalsePos = 0;
		String l = null;
		BloomFilter bf = new BloomFilter(167000000, 20);
		try {
			while((l = br.readLine()) != null) {
				if(counter > initial_counter/3) {
					bf.add(l);
				}
				else {
					if(bf.isPresent(l)) {
						numFalsePos++;
					}
				}
				counter--;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("total number of collisions while building a bloom filter are " + bf.collisionCount);
		System.out.println("Total number of false positives are " + numFalsePos);
	}

}
