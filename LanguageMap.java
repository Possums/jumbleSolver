import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;



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

	public String getString(String a){
	    Set<String> set = dictionary.computeIfAbsent(a, k -> new HashSet<>());
	    String x = "";

		for (String s : set){
			
			x += s;
			x+= " ";
		}
		
		return x;
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
		alphabetized.toLowerCase();
		return alphabetized;
	}

	public String getLanguage() {
		return myLanguage;
	}

}
