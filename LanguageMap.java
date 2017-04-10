import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class LanguageMap {

	String myLanguage;
	File dictionaryFile;
	// this needs a Map that maps keys ex:  "aehr" to the 
	// Set of String { "hare", "hear", "rhea"} that have those chars
	private HashMap<String, Set<String>> dictionary;

	public LanguageMap(String lang, Scanner wordSource) {
		this.myLanguage=lang;
		// more...
	}
	
	public void scan(){
		dictionaryFile = new File("src/language_files/English.txt");
		dictionary = new HashMap<String, Set<String>>();
		
		try {

			Scanner sc = new Scanner(dictionaryFile);

			while (sc.hasNextLine()) {
				String i = sc.nextLine();
				System.out.println(i);
				String type = alphabetize(i);
				if (dictionary.get(type) == null){
					Set<String> set = new HashSet<>();
					set.add(i);
					dictionary.put(type, set);
				} else {
					dictionary.get(type).add(i);	
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File could not be found");
		}
	}

	public String alphabetize(String a){
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String alphabetized = new String(chars);
		return alphabetized;
	}

	public String getLanguage() {
		return myLanguage;
	}

}
