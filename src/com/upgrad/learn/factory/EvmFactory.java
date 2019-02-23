package com.upgrad.learn.factory;

import com.upgrad.learn.bloomfilter.BloomFilterUtil;
import com.upgrad.learn.evm.ElectionCount;
import com.upgrad.learn.evmimpl.ElectionCountDirectAddressingImpl;
import com.upgrad.learn.evmimpl.ElectionCountHashTableImpl;

/**
 * Factory design pattern class.
 * @author PrakashC
 *
 */
public class EvmFactory {
	private static ElectionCount electionCountObj;
	
	/**
	 * this method takes the input based on that it will create the instance of the child class
	 * @param type
	 * @param bfUtilObj
	 * @return
	 */
	public static ElectionCount buildImplementaionType(int type,BloomFilterUtil bfUtilObj) {
		if(type==1) {
			electionCountObj = new ElectionCountDirectAddressingImpl(bfUtilObj);
		}else if(type==2) {
			electionCountObj = new ElectionCountHashTableImpl(bfUtilObj);
		}
		return electionCountObj;
	}
}
