import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 14</b>:</u> Turkey
 * <p>
 * <b>Java Program:</b> Prob14.java<br>
 * <b>Input File:</b> Prob14.in.txt<br>
 * <b>Status</b>: IN PROGRESS
 * <p>
 * <b>Description:</b> This problem isn’t about Thanksgiving, it’s about
 * bowling! If you’ve ever gone bowling, then you know that the scoring can be
 * complicated. That’s why we want you to write a program to do it.
 * 
 * @author Alex Chiang
 *
 */
public class Prob14 {

	private static final String PROBLEM = "Prob14";
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
			String nextLine = scan.nextLine();
			if (nextLine.equals("X,X,X,X,X,X,X,X,X,XXX")) {
				printLine(300);
				continue;
			}
			String[] split = scan.nextLine().split("\\,");

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
