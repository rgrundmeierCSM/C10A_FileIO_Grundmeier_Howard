import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.IOException;
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
	public void loadDataFile(String fileName)
	{
		FileReader reader;
		try {
			reader = new FileReader(fileName);
			Scanner in  = new Scanner(reader);
			//While there are more lines to read
			while(in.hasNextLine()) {
				//read the first two values and store them as a  string
				String tempString = in.next();
				tempString = tempString + " " + in.next();
				//read in the integer value and create a Student object
				int tempInt = in.nextInt();
				students.add(new Student(tempString, tempInt));
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

