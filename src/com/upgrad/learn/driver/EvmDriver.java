package com.upgrad.learn.driver;

import java.util.Scanner;

import com.upgrad.learn.bloomfilter.BloomFilter;
import com.upgrad.learn.bloomfilter.BloomFilterUtil;
import com.upgrad.learn.evm.ElectionCount;
import com.upgrad.learn.evmimpl.EvmUtil;
import com.upgrad.learn.factory.EvmFactory;

/**
 * This is the Starting point for the Evm Project.
 * Displays the following using 2 implementations(Direct Addressing & Hashtable)
 * 1. outputs candidate_id corresponding to the voter_id
 * 2. outputs the count of votes, a candidate got.
 * @author PrakashC
 */
public class EvmDriver {
	/**
	 * main(starting point of Evm Project)
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvmUtil.print(EvmUtil.TITLE);
		int voterOrCandidateId;
		int candidate_id1,candidate_id2;
		int candidateVoterCount1,candidateVoterCount2;
		Scanner scannerObj=null;
		//ElectionCount elctionCountObj=null;
    	try {
    		scannerObj = new Scanner(System.in);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//this object to initalize the variables required for bloom filter
    	BloomFilterUtil bfUtilObj = new BloomFilterUtil();
    	//loads the bloomfilter
    	BloomFilter bf =bfUtilObj.processBloomFilter();
    	//process the voteridCandidateId file
    	bfUtilObj.processVoterCandidateFile(bf);
    	
    	int findOrCount = scannerObj.nextInt();
    	/*
    	 * if findOrCount =1 it will call the find methods of DirectAddressing and Hashtable
    	 *    findOrCount =2 it will call the count methods of DirectAddressing and Hashtable
    	 */
    	if(findOrCount==1) {
    		ElectionCount electionCountObj =EvmFactory.buildImplementaionType(1,bfUtilObj);
    		EvmUtil.print(EvmUtil.VALID_VOTER_LABEL);
        	voterOrCandidateId= scannerObj.nextInt();
        	candidate_id1=electionCountObj.find(voterOrCandidateId);
        	electionCountObj = EvmFactory.buildImplementaionType(2,bfUtilObj);
        	candidate_id2=electionCountObj.find(voterOrCandidateId);
        	
        	/*
        	 * if candidateids are coming as 0, means voter  id is valid, but not casted the vote eg: above 799999 which are not
        	 * present in the 2nd file but values are there in 1st file(valid voterids)
        	 * if voter_id is not in range it will print invalid voter id
        	*/
        	if(candidate_id1==0 && candidate_id2==0) {
        		EvmUtil.print(EvmUtil.VOTE_NOT_CASTE);
        	}else if(candidate_id1==-1 && candidate_id2==-1) {
        		EvmUtil.print(EvmUtil.INVALID_VOTER);
        	}else {
        		EvmUtil.print(EvmUtil.VALID_VOTER_DIRECT_ADDRESS+candidate_id1);
        		EvmUtil.print(EvmUtil.VALID_VOTER_HASH_TABLE+candidate_id2);
        	}
        }else if(findOrCount==2){
    		ElectionCount electionCountObj =EvmFactory.buildImplementaionType(1,bfUtilObj);
    		EvmUtil.print(EvmUtil.VALID_CANDIDATE_LABEL);
        	voterOrCandidateId= scannerObj.nextInt();
        	candidateVoterCount1=electionCountObj.count(voterOrCandidateId);
        	electionCountObj = EvmFactory.buildImplementaionType(2,bfUtilObj);
        	candidateVoterCount2=electionCountObj.count(voterOrCandidateId);
        	
        	/*
        	 * It will checks the candidate id if its not valid it will print invalid
        	 * If its valid it will print the count of votes casted aganist candidate id
        	 */
        	if(candidateVoterCount1==0 && candidateVoterCount2==0) {
        		EvmUtil.print(EvmUtil.INVALID_CANDIDATE);
        	}else {
        		EvmUtil.print(EvmUtil.CANDIDATE_VOTE_COUNT_DIRECT_ADDRESS+candidateVoterCount1);
        		EvmUtil.print(EvmUtil.CANDIDATE_VOTE_COUNT_HASH_TABLE+candidateVoterCount2);
        	}
        }else {
        	/*
        	 * If user enters other invalid program will quit
        	 * valid input is 1(find) or 2(count)
        	 */
        	
        	EvmUtil.print(EvmUtil.INVLID_INPUT_FOR_OPERATION);
        	System.exit(0);
        }
    	EvmUtil.print(EvmUtil.FALSE_POSITIVE+BloomFilterUtil.falsePositive);
    }

}
