package com.upgrad.learn.evm;

/**
 * abstract class used for the factory method implementation
 * @author PrakashC
 *
 */
public abstract class ElectionCount {
	
	/**
	 * this abstract method is implemented in the child classes
	 * @param voter_id
	 * @return the candidate_id
	 */
	public abstract int find(int voter_id);
	
	/**
	 * this abstract method is implemented in the child classes
	 * @param candidate_id
	 * @return the no of votes casted by candidate_id
	 */
	public abstract int count(int candidate_id);
}
