package com.upgrad.learn.bloomfilter;

import java.util.BitSet;

/**
 * BloomFilter class which is used to load bitset array and find and add methods
 * @author PrakashC
 *
 */
public class BloomFilter {
	int hash1,hash2,hash3;
	int collisionCount =0;
	int size;
	int noOfHashFunctions;
	BitSet bs;
	HashFunction hf;
	
	/**
	 * Constructor which is used to initialize the bitset array and hashfunction variables
	 * @param bitSetSize
	 * @param noOfHashFunctions
	 */
	public BloomFilter(int bitSetSize, int noOfHashFunctions) {
		bs = new BitSet(bitSetSize);
		bs.clear();
		hf = new HashFunction();
		this.size = bs.size();
		this.noOfHashFunctions=noOfHashFunctions;
	}
	/**
	 * check the data in the bit array for the data. It checks wether the bits are assigned for the data or not
	 * @param data
	 * @return
	 */
	public boolean isPresent(String data) {
		hash1 = hf.genHash1(data);
		hash2 = hf.genHash2(data);
		hash3 = hf.genHash3(data);
		for(int i=1;i<this.noOfHashFunctions;i++) {
			if(bs.get(Math.abs((this.hash1+i*this.hash2+i*i+this.hash3)%this.size))){
				continue;
			}else {
				return false;
			}
		} 
		return true;
	}
	/**
	 * adds the data to the bit set array. It will set the bits corresponding to the data in the bit set array.
	 * @param data
	 */
	public void addElement(String data) {
		if(isPresent(data)) {
			collisionCount++;
		}
		hash1 = hf.genHash1(data);
		hash2 = hf.genHash2(data);
		hash3 = hf.genHash3(data);
		for(int i=1;i<=this.noOfHashFunctions;i++) {
			bs.set(Math.abs((this.hash1+i*this.hash2+i*i+this.hash3)%this.size));
		}
	}
}
