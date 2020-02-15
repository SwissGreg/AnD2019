import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class HashcodePractice2020 {

	public static void main(String[] args) throws FileNotFoundException {
		File fileA = new File("inputA.txt");
		File fileB = new File("inputB.txt");
		File fileC = new File("inputC.txt");
		File fileD = new File("inputD.txt");
		File fileE = new File("inputE.txt");
		Scanner scan = new Scanner(fileA);
		PrintStream out = new PrintStream("outputA.txt");
		readSolve(scan,out);
		scan = new Scanner(fileB);
		out = new PrintStream("outputB.txt");
		readSolve(scan,out);
		scan = new Scanner(fileC);
		out = new PrintStream("outputC.txt");
		readSolve(scan,out);
		scan = new Scanner(fileD);
		out = new PrintStream("outputD.txt");
		readSolve(scan,out);
		scan = new Scanner(fileE);
		out = new PrintStream("outputE.txt");
		readSolve(scan,out);

	}
	
	public static void readSolve(Scanner in,PrintStream out) {
		int N = in.nextInt();
		int K = in.nextInt();
		int[] slices = new int[N];
		for(int i = 0; i< N;i++) {
			slices[i] = in.nextInt();
		}
		
		out.println(solve(N,K,slices));
	}
	public static int[] solve(int N,int K,int[] slices) {
		//TODO:
		return null;
	}
}
