import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

	public SpellChecker() {
		// TODO: You can modify the body of this constructor,
		// or you can leave it blank. You must keep the signature, however.
	}

	public static void start() throws IOException {
		// TODO: You can modify the body of this method,
		// or you can leave it blank. You must keep the signature, however.

		Scanner scnr1 = new Scanner(System.in);
		System.out.println(Util.DICTIONARY_PROMPT);
		String dictionaryFile = scnr1.nextLine();
		WordRecommender wr = new WordRecommender(dictionaryFile);
		System.out.println(Util.FILENAME_PROMPT);
		String userFile = scnr1.nextLine();
		ArrayList<String> words = new ArrayList<String>();
		words = readFile(userFile);
	}

	public static ArrayList<String> readFile(String userFile) {
		ArrayList<String> words = new ArrayList<String>();
		try {
			FileInputStream fin = new FileInputStream(userFile);
			Scanner scnr = new Scanner(fin);
			System.out.println(Util.DICTIONARY_SUCCESS_NOTIFICATION);
			while (scnr.hasNext()) {
				String word = scnr.next();
				if (!word.equals("\n")) {
					words.add(word);
				}
			}
			scnr.close();
		} catch (FileNotFoundException e) {
			System.out.println(Util.FILE_OPENING_ERROR);
			System.out.println(Util.DICTIONARY_PROMPT);
			Scanner scnr = new Scanner(System.in);
			String newFile = scnr.nextLine();
			readFile(newFile);
		}
		return words;
	}

	// You can of course write other methods as well.
}