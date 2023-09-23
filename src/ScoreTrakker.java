import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * 
 */
public class ScoreTrakker {

	private ArrayList<Student> students;
	private String [] files = {"scores.txt", "badscore.txt", "nofile.txt"};

	public ScoreTrakker() {
		students = new ArrayList<Student>();

	}
	/**
	 * 
	 * @param fileName
	 * @throws FileNotFoundException, error to be handled by processFiles()
	 */
	public void loadDataFile(String fileName)
	{
		FileReader reader;
		try {
			reader = new FileReader(fileName);
			Scanner in  = new Scanner(reader);
			//While there are more lines to read
			while(in.hasNextLine()) {
				//Reads the first number in as a string
				String Name = in.nextLine();
				System.out.println(Name);
				String scoreString = in.nextLine();
				int score = Integer.parseInt(scoreString);
				students.add(new Student(Name, score));
			}
			in.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sorts the items in the ArrayList and then prints them out with appropriate labels. 
	 */
	public void printInOrder()
	{
		//Put the Students in the correct order
		Collections.sort(students);
		//Print out the header statement
		System.out.println("Student Score List");
		//Iterate through the ArrayList and print out the objects
		for(Student student: students)	{
			System.out.println(student);
		}
		//Add a blank line after the list
		System.out.println("");
	}
	
	/**
	 * Loads and prints the information from the array of file names. 
	 * @throws FileNotFoundException - this will go away, exception handling will be added 
	 * to this function as a part of the requirement. 
	 */
	public void processFiles() {
		for (int i = 0; i < 3; i++) {
			loadDataFile(files[i]);
			printInOrder();
		}
	}
	
	public static void main(String[] args) {
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
	}	
}

