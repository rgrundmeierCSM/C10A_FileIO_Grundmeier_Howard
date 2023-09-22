import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public void loadDataFile(String fileName) throws FileNotFoundException
	{
		FileReader reader = new FileReader(fileName);
		Scanner in  = new Scanner(reader);
		students = new ArrayList<Student>();

		//While there are more lines to read
		while(in.hasNextLine()) {
			int tempInt = 0;
			//read the first two values and store them as a  string
			String tempString = in.next();
			tempString = tempString + " " + in.next();
			//read in the integer value and create a Student object
			String tempString2 = in.next();
			// Error handling to check that the score is formatted as an integer. 
			try {
				tempInt = Integer.parseInt(tempString2);
				students.add(new Student(tempString, tempInt));
			}

			catch (NumberFormatException e){
				System.out.println("Incorrect format for " + tempString + " not a valid score: " + tempString2);
				System.out.println("");
			}
		}
		in.close();
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
	public void processFiles() throws FileNotFoundException	{
		for (int i = 0; i < 3; i++) {
			loadDataFile(files[i]);
			printInOrder();
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
	}	
}

