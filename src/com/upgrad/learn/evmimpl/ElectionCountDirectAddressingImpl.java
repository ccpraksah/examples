package com.upgrad.learn.evmimpl;

import java.util.HashMap;
import java.util.Map;

import com.upgrad.learn.bloomfilter.BloomFilter;
import com.upgrad.learn.bloomfilter.BloomFilterUtil;
import com.upgrad.learn.evm.ElectionCount;

/**
 * Class is being used by factory method pattern
 * @author PrakashC
 *
 */
public class ElectionCountDirectAddressingImpl extends ElectionCount {
	
	private BloomFilterUtil bfUtilObj;
	
	/**
	 * constructor used to get the reference of the Bloomfilter which is being used in the other methods of the class.
	 * @param bfUtilObj
	 */
	public ElectionCountDirectAddressingImpl(BloomFilterUtil bfUtilObj){
		this.bfUtilObj= bfUtilObj;
	}
	
	/**
	 * which takes the voter_id as the input and outputs the corresponding the canidate_id
	 * We will check the bloomfilter first and check the range between 200000-399999 and 600000-899999
	 * 
	 */
	@Override
	public int find(int voter_id) {
		// TODO Auto-generated method stub
		int candidate_id=-1;
		BloomFilter bf = bfUtilObj.getBf();
		boolean isPresent = bf.isPresent(String.valueOf(voter_id));
		boolean isInRange = isInRange(voter_id);
		if(isPresent && isInRange) {
			candidate_id =getCandidateId(voter_id);
		}
		return candidate_id;
	}
	
	/**
	 * Takes the voter_id and outputs the votes count that he got from the valid voters
	 */
	@Override
	public int count(int candidate_id) {
		// TODO Auto-generated method stub
		int candidateVoteCount=0;
		HashMap<Integer,Integer> candidateCountMapObj = bfUtilObj.getCandidateCountMapObj();
		if(candidateCountMapObj.containsKey(candidate_id)) {
			candidateVoteCount = candidateCountMapObj.get(candidate_id);
		}
		for (Map.Entry<Integer,Integer> entry : candidateCountMapObj.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());
		return candidateVoteCount;
	}
	
	/**
	 * checks the range and returns true if range is in between 200000-399999 and 600000-899999
	 * @param voter_id
	 * @return
	 */
	private boolean isInRange(int voter_id) {
		boolean isInRange=false;
		if(voter_id>=200000 && voter_id<=399999) {
			isInRange =true;
		}else if(voter_id>=600000 && voter_id<=899999) {
			isInRange=true;
		}
		return isInRange;
	}
	
	/**
	 * gets the candidate id from the direct address array and returns the candiate_id
	 * Logic is as follows.
	 * We know data set is from 200000-399999 and 600000-899999. So total size is 500000
	 * We are taking the array which will normally starts from 0. 
	 * So we are deducting value 200000 for the voter_ids ranging from 200000-399999
	 * and we are deducting value 400000 for the voter_ids ranging from 600000-899999
	 * 
	 * @param voter_id
	 * @return
	 */
	private int getCandidateId(int voter_id) {
		int candidate_id =0;
		int [] directAddressAry = bfUtilObj.getDirectAdressAry();
		if(voter_id>=200000 && voter_id<=399999) {
			candidate_id=directAddressAry[voter_id-200000];
		}else if(voter_id>=600000 && voter_id<=899999) {
			candidate_id=directAddressAry[voter_id-400000];;
		}
		return candidate_id;
	}

}
