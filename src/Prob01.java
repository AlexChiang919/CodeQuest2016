import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob01 {

	private static final String PROBLEM = "Prob01";
	private static final String EXT = ".in.txt";

	public static void main(String[] args) {
		Scanner scan;
		try {
			scan = new Scanner(new File(PROBLEM + EXT));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int times = Integer.parseInt(scan.nextLine());
		while (times-- > 0) {
			int size = Integer.parseInt(scan.nextLine());
			int aSize = (size - 1 >= 0) ? size + (size - 1) : size;
			char[][] board = new char[size][aSize];
			for (int i = 0; i < size; i++) {
				board[i] = constructPounds(size).toCharArray();
			}
			printArray(board);
		}
		scan.close();
	}
	
	private static String constructPounds(int pounds) {
		String out = "";
		for (int i = 0; i < pounds; i++) {
			out += "# ";
		}
		return out.trim();
	}
	
	private static void printArray(char[][] array) {
		for (char[] ch : array) {
			for (char c : ch) {
				print(c);
			}
			printLine();
		}
	}

	public static void print(Object... o) {
		for (Object obj : o) {
			System.out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			System.out.println();
			return;
		}
		for (Object obj : o) {
			System.out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		System.out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
