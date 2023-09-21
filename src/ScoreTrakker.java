import java.awt.Desktop;  
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; 

/**
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * 
 */
public class ScoreTrakker {
	private ArrayList<Student> students;
	public ScoreTrakker() {
		students = new ArrayList<Student>();
		

	}
	public void loadDataFile(String fileName) throws FileNotFoundException
	{
		FileReader reader = new FileReader(fileName);
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

	}
	public void printInOrder()
	{
		for(Student student: students) {
		}
		}
	
	public void processFiles()
	{
		printInOrder();
		printInOrder();
	}
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker s = new ScoreTrakker();
		s.loadDataFile("scores.txt");
		System.out.println(s.students.get(1));
		
		
	}	
	
}

