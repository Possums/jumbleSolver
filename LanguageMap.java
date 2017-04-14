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
	ArrayList<String> permutationOne;
	ArrayList<String> permutationTwo;
	ArrayList<String> list;


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


	public String multiString(String a){
		//		Set<String> set = dictionary.computeIfAbsent(a,  k-> new HashSet<>());
		//		String x = "";
		//		
		//		for (String s : set){
		//			x+=s;
		//			x+=" ";
		//			
		//		}
		//		
		//		return  x;
		String result = "";
		list = new ArrayList<String>();
		permuteList("", a);


		for (int z =0; z<list.size(); z++){
			for (int i=1; i<a.length(); i++){
				a = list.get(z);
				String x = a.substring(0, i);
				String y = a.substring(i);
				//System.out.println(x + " " + y);


				String one = alphabetize(x.toLowerCase());
				String two = alphabetize(y.toLowerCase());
				//System.out.println("iterate");
				if (dictionary.get(one) != null && dictionary.get(two) != null){
					//System.out.println("exists");
					result += stringFromSet(dictionary.get(one)) + "|" + stringFromSet(dictionary.get(two)) + "  ";
				}
			}
		}
		//JOptionPane.showMessageDialog(null, "iterate string");





		return result;
	}

	public String stringFromSet(Set<String> set){

		String x = "";

		for (String s : set){
			x += s;
			x += " ";
		}

		return x;
	}

	public void permuteList(String prefix, String str){
		int n = str.length();
		if (n == 0) list.add(prefix);
		else {
			for (int i=0; i<n; i++){
				permuteList(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
			}
		}
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
