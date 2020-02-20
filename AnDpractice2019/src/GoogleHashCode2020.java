import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GoogleHashCode2020 {

	public static void main(String[] args) throws FileNotFoundException {
		File inputA = new File("InputA.txt");
		File inputB = new File("InputB.txt");
		File inputC = new File("InputC.txt");
		File inputD = new File("InputD.txt");
		File inputE = new File("InputE.txt");
		PrintStream out = new PrintStream("outputA.txt");
		readSolve(new Scanner (inputA), out);
		out = new PrintStream("outputB.txt");
		readSolve(new Scanner (inputB), out);
		out = new PrintStream("outputC.txt");
		readSolve(new Scanner (inputC), out);
		out = new PrintStream("outputD.txt");
		readSolve(new Scanner (inputD), out);
		out = new PrintStream("outputE.txt");
		readSolve(new Scanner (inputE), out);

	}
	public static void readSolve(Scanner scan, PrintStream out) {	
		
		int B = scan.nextInt();
		int L = scan.nextInt();	
		int D = scan.nextInt();
		ArrayList<Library> adj = new ArrayList<Library>();
		//L libraries
		for(int i = 0; i<L;i++) {
			int n = scan.nextInt(); // number of books in library i
			int t = scan.nextInt(); // number of days to signup library i
			int m = scan.nextInt(); // number of books which can be shipped from i
			Library lib = new Library(n,t,m);
			//read in the ID's of the books
			for(int j = 0; j<n;j++) {
				int id = scan.nextInt();
			}
		}
	}
	
	public static void solve(int B,int L,int D) {
		
	}
	
	static class Library{
		int n;
		int t;
		int m;
		ArrayList<Books> books;
		public Library(int n,int t,int m) {
			this.n = n;
			this.t = t;
			this.m = m;
			books = new ArrayList<Books>();
		}
	}
	
	public class Books{
		int value;
		int id;
		
		public Books(int val, int id) {
			this.value = val;
			this.id = id;
		}
	}
}
