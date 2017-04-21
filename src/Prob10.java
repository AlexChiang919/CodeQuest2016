import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 10</b>:</u> GCAS
 * <p>
 * <b>Java Program:</b> Prob10.java<br>
 * <b>Input File:</b> Prob10.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> Just do it.
 * 
 * @author Alex Chiang
 *
 */
public class Prob10 {

	private static final String PROBLEM = "Prob10";
	private static final String EXT = ".in.txt";

	public static void main(String[] args) {
		Scanner scan;
		try {
			scan = new Scanner(new File(PROBLEM + EXT));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int sets = Integer.parseInt(scan.nextLine());
		while (sets-- > 0) {
			int times = Integer.parseInt(scan.nextLine());
			int[] altitudes = new int[times];
			int[] elevations = new int[times + 1];
			for (int i = 0; i < times; i++) {
				String[] split = scan.nextLine().split("\\,");
				altitudes[i] = Integer.parseInt(split[0]);
				elevations[i + 1] = Integer.parseInt(split[1]);
			}
			for (int i = 0; i < times; i++) {
				printLine(evaluate(altitudes, elevations, i));
			}
		}
		scan.close();
	}
	
	public static String evaluate(int[] altitudes, int[] elevations, int i) {
		if (i == 0) {
			if (altitudes[i] <= elevations[i + 1])
				return "PULL UP!";
			else if (altitudes[i] - 500 <= elevations[i])
				return "Low Altitude!";
			else
				return "ok";
		} else {
			int delta = altitudes[i] - altitudes[i - 1];
			if (altitudes[i] + delta <= elevations[i + 1])
				return "PULL UP!";
			else if (altitudes[i] - 500 <= elevations[i])
				return "Low Altitude!";
			else
				return "ok";
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
