//
//AnagramMain contains a main program that prompts a user for phrase and find anagrams
//It constructs an Anagram object to do the actual
//search for anagrams that match the user's phrases.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AnagramMain {

	public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		// open the dictionary file
		Scanner input = new Scanner(new File("D:\\Javaprojects\\AnagramSolver-master\\dict1.txt"));

		// read dictionary into an ArrayList
		List<String> dictionary = new ArrayList<String>();
		while (input.hasNextLine()) {
			dictionary.add(input.nextLine());
		}

		// solve anagrams
		List<String> dictionary2 = Collections.unmodifiableList(dictionary);
		Anagram solver = new Anagram(dictionary2);
		String phrase;
		Set<String> anagramSolution=null;
		do {
			
			System.out.println();
			System.out.print("phrase to scramble");
			phrase = console.nextLine();
			if (phrase.length() != 0) {
				int max = 0;
				anagramSolution=solver.print(phrase, max);
				solver.printOut(anagramSolution);
				anagramSolution.clear();
			}
		} while (phrase.length() > 0);
		
		input.close();

	}
}
