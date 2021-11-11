import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WordRecommender {
	private Dictionary dic;

	public WordRecommender(String dictionaryFile) throws IOException {
		// TODO: change this!
		this.dic = new Dictionary();
		this.dic = this.reader(dictionaryFile);
	}

	public Dictionary reader(String file) throws IOException {
		try {
			FileInputStream fin = new FileInputStream(file);
			Scanner scnr = new Scanner(fin);
			System.out.println(Util.DICTIONARY_SUCCESS_NOTIFICATION);
			while (scnr.hasNext()) {
				this.dic.add(scnr.next());
			}
			scnr.close();
		} catch (FileNotFoundException e) {
			System.out.println(Util.FILE_OPENING_ERROR);
			System.out.println(Util.DICTIONARY_PROMPT);
			Scanner scnr = new Scanner(System.in);
			String newFile = scnr.nextLine();
			this.reader(newFile);
		}
		return this.dic;
	}

	public double commonPercentage(String word1, String word2) {
		HashSet<Character> word1Set = new HashSet<Character>();
		HashSet<Character> word2Set = new HashSet<Character>();
		int common = 0;
		int total = 0;
		for (int i = 0; i < word1.length(); i++) {
			word1Set.add(word1.charAt(i));
		}
		for (int i = 0; i < word2.length(); i++) {
			word2Set.add(word2.charAt(i));
		}
		for (char c : word1Set) {
			if (word2Set.contains(c)) {
				common += 1;
			}
		}
		total = word1Set.size() + word2Set.size() - common;
		return common / (total * 1.0);
	}

	public double getSimilarity(String word1, String word2) {
		// TODO: change this!
		return 0.0;
	}

	public boolean isExist(String word) {
		return dic.contains(word);
	}

	public ArrayList<String> getWordSuggestions(String word, int tolerance, double commonPercent, int topN) {
		// TODO: change this!
		return null;
	}

}