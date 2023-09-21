import java.util.ArrayList;
import java.util.Collections;
import java.io.File; 
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
		try {
		      File file = new File(fileName);
		      Scanner reader = new Scanner(file);
		      while (reader.hasNextLine()) {
		        String name = reader.nextLine();
		        int score = reader.nextInt();
		        reader.nextLine();
		    	students.add(new Student(name,score));
		      }
		      reader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void printInOrder()
	{
		Collections.sort(students);
		for(Student student: students)
		{
			System.out.println(student);
		}
	}
	public void processFiles()
	{
		loadDataFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) {
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
	}

}
