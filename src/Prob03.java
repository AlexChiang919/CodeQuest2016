import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <b><u>Problem 03</u>:</b> What Triangle Is This?
 * <p>
 * <b>Java Program:</b> Prob03.java<br>
 * <b>Input File:</b> Prob03.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> That sounds easy enough, right? Your job is to write a program that can
 * identify valid triangles. Not only do you need to determine if the three
 * sides can form a triangle – you also have to tell what type it is.
 * 
 * @author Alex Chiang
 *
 */
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
