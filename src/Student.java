/**
 * @author Clark Howard
 * @author Ryan Grumdmeier
 * 
 * 
 */
public class Student implements Comparable<Student> {
	
	
	private String name;
	private int score;
	/**
	 * 
	 * @param name name of the Student
	 * @param score Student's corresponding score
	 */
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	/**
	 * @param o the student object we can compare to 
	 * 
	 */
	public int compareTo(Student o) {
		if (o.score == this.score)
			return 0;
		else if (o.score > this.score)
			return -1;
		else 
			return 1;
		
	}
	
	public String toString() {
		String temp = name + " " + score;
		return temp;
	}
	
	

}
