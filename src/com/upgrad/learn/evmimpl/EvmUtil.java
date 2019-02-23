package com.upgrad.learn.evmimpl;

/**
 * Its having the constants and utilities used in the EVM project.
 * @author PrakashC
 *
 */
public class EvmUtil {
	public static final String TITLE="-----Election Count Program-----\n\t"+" 1)Find  2)Count\nChoose your option among 1) or 2)";
	public static final String FALSE_POSITIVE="\n\tThe False Positve Count = ";
	public static final String VALID_VOTER_LABEL="\n\tEnter Valid Voter Id";
	public static final String INVALID_VOTER="\n\tInvalid Voter";
	public static final String VOTE_NOT_CASTE="\n\tVoter Not casted the vote";
	public static final String VALID_VOTER_DIRECT_ADDRESS="\n\tVoter casted for the candidate(Direct Addressing) = ";
	public static final String VALID_VOTER_HASH_TABLE="\n\tVoter casted for the candidate(Hash Table) = ";
	public static final String VALID_CANDIDATE_LABEL="\n\tEnter Valid Candidate Id";
	public static final String CANDIDATE_VOTE_COUNT_DIRECT_ADDRESS="\n\tCount of the votes (Direct Addressing) = ";
	public static final String CANDIDATE_VOTE_COUNT_HASH_TABLE="\n\tCount of the votes (HashTable) = ";
	public static final String INVALID_CANDIDATE="\n\tInvalid Candidate";
	public static final String INVLID_INPUT_FOR_OPERATION="\nRun the program again and choose the correct option";
	
	
	/**
	 * Takes the str as the input which are defined as constants above and will be printed in the console 
	 * This method is used across the Evm Project. If you have any constants define as above constants variables
	 * and try to use print method to display to the the user.
	 * @param str
	 */
	public static void print(String str) {
		System.out.println(str); 
	}
}
