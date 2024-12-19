/**
 * 
 */
package fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sonam
 *
 */
public class FileProgram {

	/**
	 * @param args
	 * @return
	 */
	//Function to write the file for both string as well as number list
	public static void filewrite(File f, List<?> list) {
		try {
		FileWriter myWriter = new FileWriter(f);
		for(int i=0;i<list.size();i++)
		myWriter.write("  "+list.get(i)+"  ");
		myWriter.close();//File Closing
		System.out.println("Successfully wrote to the file "+f.getName() );
		}catch (IOException e) {
			System.out.println("An error occurred while writing the file.");
			e.printStackTrace();
		}

	}
	//Function for reading and writing files.
	public static void readWritefile(FileReader readFile,FileWriter writeFile) {
		
		try(BufferedReader bufferedReader = new BufferedReader(readFile)) {
			BufferedWriter bufferedWriter = new BufferedWriter(writeFile);
		    String line = bufferedReader.readLine();
		    int i=0;
		    while(line != null) {
		    	if(line.length() > 0) {  //checking for empty line (problem 3)
		    	i=i+1;//adding numbers to line
		        System.out.println(i+" "+line);
		        bufferedWriter.write(i+" "+line+System.lineSeparator());//writing to the file
		    	}
		        line = bufferedReader.readLine();
		    }
		    bufferedReader.close();
		    bufferedWriter.close();
		} catch (FileNotFoundException e) {
		    // Exception handling
		} catch (IOException e) {
		    // Exception handling
		}
	}
	
	
	//File Creation Function to create various files in given problem.
	public static File fileCreation(File fileName) {
		try {
			if (fileName.createNewFile()) {
				System.out.println("File created: " + fileName.getName());
				return fileName;
			} else {
				System.out.println("File already exists.");
			}
		}catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return fileName;
	}
	

	public static void main(String[] args) {
		//creating 2 list as per the problem 1
		List<String> foodList = Arrays.asList("Cake", "Bread", "Apple", "Banana","Mango");
		List<Integer> numberList = Arrays.asList(1,2,3,4,5,6);
		try {
			//Calling for Problem1
			filewrite(fileCreation(new File("MyFavFood.txt")),foodList);
			filewrite(fileCreation(new File("MyNumberFile.txt")),numberList);
			
			File inputFile = fileCreation(new File("Animal.txt"));
			File outputFile = fileCreation(new File("AnimalsWithLines.txt"));
			//Calling for Problem1 and 2
			readWritefile(new FileReader(inputFile),new FileWriter(outputFile));
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
