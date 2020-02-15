import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class HashcodePractice2020 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
		PrintStream out = new PrintStream("output.txt");
		readSolve(scan,out);

	}
	
	public static void readSolve(Scanner in,PrintStream out) {
		
	}

}
