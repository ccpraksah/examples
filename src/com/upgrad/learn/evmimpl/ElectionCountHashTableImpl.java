package com.upgrad.learn.evmimpl;

import java.util.HashMap;
import java.util.Hashtable;

import com.upgrad.learn.bloomfilter.BloomFilter;
import com.upgrad.learn.bloomfilter.BloomFilterUtil;
import com.upgrad.learn.evm.ElectionCount;

/**
 * This is one of implementation of the ElectionCount using the Hashtable.
 * @author PrakashC
 *
 */
public class ElectionCountHashTableImpl extends ElectionCount {
	private BloomFilterUtil bfUtilObj;
	
	/**
	 * constructor used to get the reference of the Bloomfilter which is being used in the other methods of the class.
	 * @param bfUtilObj
	 */
	public ElectionCountHashTableImpl(BloomFilterUtil bfUtilObj) {
		this.bfUtilObj=bfUtilObj;
	}
	
	/**
	 * which takes the voter_id as the input and outputs the corresponding the canidate_id
	 * We will check the bloomfilter first and check the range between 200000-399999 and 600000-899999
	 * we are also checking the range between 700000-899999 and outputs 0(valid voter not casted vote)
	 * outputs 1(not valid voter)
	 */
	@Override
	public int find(int voter_id) {
		// TODO Auto-generated method stub
		Hashtable<Integer,Integer> hashtableObj = bfUtilObj.getHashtableObj();
		int candidate_id=-1;
		BloomFilter bf = bfUtilObj.getBf();
		boolean isPresent = bf.isPresent(String.valueOf(voter_id));
		boolean isInRange = isInRange(voter_id);
		if(isPresent && isInRange) {
			if(voter_id>=700000 && voter_id<=899999) {
				candidate_id=0;
			}else {
				candidate_id =hashtableObj.get(voter_id);
			}
		}
		return candidate_id;
	}
	
	/**
	 * Takes the candidate_id and outputs the votes count that he got from the valid voters
	 */
	@Override
	public int count(int candidate_id) {
		// TODO Auto-generated method stub
		int candidateVoteCount=0;
		HashMap<Integer,Integer> candidateCountMapObj = bfUtilObj.getCandidateCountMapObj();
		if(candidateCountMapObj.containsKey(candidate_id)) {
			candidateVoteCount = candidateCountMapObj.get(candidate_id);
		}
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
}
