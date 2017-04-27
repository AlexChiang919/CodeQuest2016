import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Template Class</u></b>
 * <p>
 * <b>Description:</b> This is a template class for coding all problems.
 * 
 * @author Alex Chiang
 *
 */
public class Prob16 {

	private static final String PROBLEM = "Prob16";
	private static final String EXT = ".in.txt";

	public static void main(String[] args) {
		Scanner scan;
		try {
			scan = new Scanner(new File(PROBLEM + EXT));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.nextLine());
		while (T-- > 0) {
			
		}
		scan.close();
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
