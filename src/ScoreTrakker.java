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
	public ScoreTrakker() {
		students = new ArrayList<Student>();
	}
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
	public void printInOrder()
	{
		System.out.print("hello");
		Collections.sort(students);
		for(Student student: students)
		{
			System.out.println(student);
		}
	}
	public void processFiles()
	{
		this.loadDataFile("scores.txt");
		this.printInOrder();
	}
	public static void main(String[] args) throws FileNotFoundException{
		ScoreTrakker s = new ScoreTrakker();
		s.loadDataFile("scores.txt");
		//s.printInOrder();

	}	
	
}

