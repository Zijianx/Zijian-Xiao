import java.util.HashSet;

public class Dictionary {
	private HashSet<String> dictionary;

	public Dictionary() {
		this.dictionary = new HashSet();
	}

	public void add(String word) {
		this.dictionary.add(word);
	}

	public boolean contains(String word) {
		return this.dictionary.contains(word);
	}
}
