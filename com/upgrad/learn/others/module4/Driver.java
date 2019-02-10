package com.upgrad.learn.others.module4;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {

	public static List<String> INPUT_FILE_PATHS = Arrays.asList(new String[] {
			"C:/Users/PrakashC/eclipse-workspace/BitsActuals/src/data/randomtext_1.txt",
			"C:/Users/PrakashC/eclipse-workspace/BitsActuals/src/data/ramdomtext_2.txt"});
	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(INPUT_FILE_PATHS.size());
		List<Future<Boolean>> statuses = new ArrayList<Future<Boolean>>();
		
		//For each file a new processor is spawned and words are read from each file in parallel
		for(String filePath : INPUT_FILE_PATHS) {
			WordCountProcessor processor = new WordCountProcessor(filePath);
			Future<Boolean> future = executor.submit(processor);
			statuses.add(future);
		}
		
		for(Future<Boolean> future : statuses) {
			try {
                //print the return value of Future, Future.get() waits for task to get completed
				System.out.println(future + " completed with status " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
		}
		
		List<WordCountMapper> wordCountMappers = WordCountMapperFactory.getAllWordCountMappers();
		Map<String, Long> aggregatedWordCount = WordCountReducer.getAggregatedWordCount(wordCountMappers);
		printWordFrequency(aggregatedWordCount);
		
		//shut down the executor service now
        executor.shutdown();
	}
	
	public static void printWordFrequency(Map<String, Long> wordCount) {
		for (Map.Entry<String, Long> entry : wordCount.entrySet())
		{
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
