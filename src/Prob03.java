import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Prob03 {

	private static final String PROBLEM = "Prob03";
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
			String[] split = scan.nextLine().split("\\, ");
			long[] sides = parseSides(split);
			Arrays.sort(sides);
			if (sides[0] + sides[1] <= sides[2]) {
				printLine("Not a Triangle");
				continue;
			}
			if (sides[0] == sides[1] && sides[1] == sides[2])
				printLine("Equilateral");
			else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2])
				printLine("Isosceles");
			else
				printLine("Scalene");
		}
		scan.close();
	}
	
	private static long[] parseSides(String[] split) {
		long[] array = new long[split.length];
		for (int i = 0; i < split.length; i++) {
			array[i] = Long.parseLong(split[i]);
		}
		return array;
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
