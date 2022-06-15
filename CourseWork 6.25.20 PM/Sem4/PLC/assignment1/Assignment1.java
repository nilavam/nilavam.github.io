import java.util.Random;

public class Assignment1 {
	
	/************************* *************************/
	
	/**
	 * @description Main method.
	 */
	public static void main(String[] args) {
		
		// Data
		String[] names1 = {"Aragog", "Bane", "Crookshanks", "Dobby", "Errol", "Fluffy", "Grawp"};
		int[] ages1 = {55, 700, 4, 25, 7, 3, 15};
		String[] genders1 = {"male", "male", "female", "male", "female", "female", "male"};
		String[] programs1 = {"MSc", "PhD", "BSc", "BSc", "PhD", "MSc", "BSc"};
		String[] advisors1 = {"Dumbledore", "Voldemort"};
		
		String[] names2 = {"Hedwig", "Kreacher", "Magorian", "Norbert", "Pigwidgeon", "Trevor"};
		int[] ages2 = {5, 28, 640, 2, 2, 4};
		String[] genders2 = {"male", "male", "female", "male", "female", "male"};
		String[] programs2 = {"BSc", "MSc", "MSc", "BSc", "BSc", "MSc"};
		int minCgpa = 6;

		// Initialise (P)RNG
		Random rng = new Random();

		// Array 1 creation
		Student[] students = new Student[7];
		int advisorIndex = 0;
		for(int i=0;i<7;++i) {
			int currCgpa = rng.nextInt(11);
			int currBacklogs = rng.nextInt(25);
			if(programs1[i].equals("BSc")) {
				students[i] = new BScStudent(names1[i], ages1[i], genders1[i], programs1[i], currCgpa, currBacklogs);
			} else if(programs1[i].equals("MSc")) {
				students[i] = new MScStudent(names1[i], ages1[i], genders1[i], programs1[i], currCgpa, currBacklogs);
			} else { //PhD student
				students[i] = new PhDStudent(names1[i], ages1[i], genders1[i], programs1[i], advisors1[advisorIndex++]);
			}
		}
		
		// Array 2 creation
		CourseStudent[] courseStudents = new CourseStudent[6];
		for(int i=0;i<6;++i) {
			int currCgpa = rng.nextInt(11);
			int currBacklogs = rng.nextInt(25);
			if(programs2[i].equals("BSc")) {
				courseStudents[i] = new BScStudent(names2[i], ages2[i], genders2[i], programs2[i], currCgpa, currBacklogs);
			} else { //MSc student
				courseStudents[i] = new MScStudent(names2[i], ages2[i], genders2[i], programs2[i], currCgpa, currBacklogs);
			}
		}
		
		System.out.println("Male students living three in a room");
		StudentUtils.maleThreePerRoom(students);
		/* The above call should print a list of names of all
		  male students who have two room mates */
		
		System.out.println("Students with cgpa at least " + minCgpa);
		StudentUtils.cgpaAtLeast(courseStudents, minCgpa);
		/* The above call should print a list of names and
		   their programs all students with cgpa at least
		   minCgpa */
	}
}
