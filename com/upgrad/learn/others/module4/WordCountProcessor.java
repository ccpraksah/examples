package com.upgrad.learn.others.module4;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class WordCountProcessor implements Callable<Boolean> {

	private String filePath;

	WordCountProcessor(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public Boolean call() {
		try {
			BufferedReader br = readFile();
			String currentLine = null;
			while((currentLine = br.readLine()) != null) {
				String[] words = currentLine.split(" "); //Identity the words by delimiter space
				for(String word : words) {
					WordCountMapper mapper = WordCountMapperFactory.getMapperFor(word);
					mapper.read(word);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private  BufferedReader readFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

}
