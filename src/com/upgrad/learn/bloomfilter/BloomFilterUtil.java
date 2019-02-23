package com.upgrad.learn.bloomfilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * This class is used process the 2 input files and load the direct addressing array, hashtable and hashmap which is used 
 * to store the count of votes casted aganist for each candidate id.
 * @author PrakashC
 *
 */
public class BloomFilterUtil {
	
	public static int falsePositive=0;
	int counter;
	int noOfHashFunctions;
	private int candidateCounter =0;
	private int [] directAdressAry = new int[500000];
	BloomFilter bf;
	BufferedReader br;
	private Hashtable<Integer,Integer> hashtableObj = new Hashtable<Integer,Integer>();
	private HashMap<Integer,Integer> candidateCountMapObj = new HashMap<Integer,Integer>();
	
	/**
	 * Constructor used to initialize the variables which are being used in bloom filter
	 */
	public BloomFilterUtil() {
		this.counter =5792530;
		this.noOfHashFunctions=7;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream is =cl.getResourceAsStream("validVotersList.txt");
		this.br = new BufferedReader(new InputStreamReader(is));
	}
	
	/**
	 * Used to instantiate the BloomFilter with the variables assigned in constructor
	 * calls the method of adding an element in the bloomfilter.
	 * @return
	 */
	public BloomFilter processBloomFilter() {
		String str=null;
		int i=0;
		bf =new BloomFilter(this.counter,this.noOfHashFunctions);
		try {
			while((str=this.br.readLine())!=null) {
				bf.addElement(str);
				i++;
			}
		}catch(IOException e) {
			
		}
		return bf;
	}
	
	/**
	 * Used to process the voterIdCandidate file and parse each line send the 
	 * voter_id and candiate_id to the add function.
	 * @param bf
	 */
	public void processVoterCandidateFile(BloomFilter bf) {
		int voterId;
		int candidateId;
		String str =null;
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream is =cl.getResourceAsStream("votersCandList.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			while((str=br.readLine())!=null) {
				String[] split = str.split(" ");
				if(split.length==2) {
					voterId = Integer.parseInt(split[0]);
		            candidateId = Integer.parseInt(split[1]);
		            add(voterId,candidateId);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * checks the voter_id in bloom filter if present it will check the range.
	 * if the voter_id is in range it will add to bloomfilter, hashtable and hashmap(which is used for count methods)
	 * @param voter_id
	 * @param candidate_id
	 */
	public void add(int voter_id, int candidate_id) {
		boolean isPresent =bf.isPresent(Integer.toString(voter_id));
		if(isPresent && (voter_id>399999 && voter_id<600000)) {
			falsePositive++;
		}else {
			if(voter_id>=200000 && voter_id<=399999) {
				hashtableObj.put(voter_id, candidate_id);
				this.directAdressAry[voter_id-200000]=candidate_id;
				if(candidateCountMapObj.containsKey(candidate_id)) {
					candidateCounter = candidateCountMapObj.get(candidate_id);
					candidateCounter=candidateCounter+1;
					candidateCountMapObj.put(candidate_id,candidateCounter);
				}else {
					candidateCountMapObj.put(candidate_id,1);
				}
			}else if(voter_id>=600000 && voter_id<=899999) {
				hashtableObj.put(voter_id, candidate_id);
				this.directAdressAry[voter_id-400000]=candidate_id;
				if(candidateCountMapObj.containsKey(candidate_id)) {
					candidateCounter = candidateCountMapObj.get(candidate_id);
					candidateCounter=candidateCounter+1;
					candidateCountMapObj.put(candidate_id,candidateCounter);
				}else {
					candidateCountMapObj.put(candidate_id,1);
				}
			}
		}	
	}
	/**
	 * getter method for BloomFilter reference
	 * @return
	 */
	public BloomFilter getBf() {
		return bf;
	}
	
	/**
	 * getter method for direct address arrary reference
	 * @return
	 */
	public int[] getDirectAdressAry() {
		return directAdressAry;
	}
	
	/**
	 * getter method for hashtable reference
	 * @return
	 */
	public Hashtable<Integer, Integer> getHashtableObj() {
		return hashtableObj;
	}
	
	/**
	 * getter method for candidateMap reference
	 * @return
	 */
	public HashMap<Integer, Integer> getCandidateCountMapObj() {
		return candidateCountMapObj;
	}
	
	/**
	 * getter method for bufferedreader reference
	 * @return
	 */
	public BufferedReader getBr() {
		return this.br;
	}
	
}
