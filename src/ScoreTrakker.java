import java.awt.Desktop;  
import java.io.*;
import java.util.ArrayList; 

/**
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * 
 */
public class ScoreTrakker {
	private ArrayList<Student> students;
	public ScoreTrakker() {

	}
	public void loadDataFile(String fileName)
	{
		File file = new File(fileName);

	}
	public void printInOrder()
	{
		for(Student student: students)
	}
	public void processFiles()
	{
		printInOrder();
		printInOrder();
	}
	public static void main(String[] args) {
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
	}

}
