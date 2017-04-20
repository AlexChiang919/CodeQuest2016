import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * <b><u>Problem 13</b>:</u> Communtative Combo!
 * <p>
 * <b>Java Program:</b> Prob13.java<br>
 * <b>Input File:</b> Prob13.in.txt<br>
 * <b>Status</b>: IN PROGRESS
 * <p>
 * <b>Description:</b> Just do it.
 * 
 * @author Alex Chiang
 *
 */
public class Prob13 {

	private static final String PROBLEM = "Prob13";
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
			int target = Integer.parseInt(scan.nextLine().substring(9));
			String[] split = scan.nextLine().split("\\,");
			int[] digits = new int[split.length];
			for (int i = 0; i < digits.length; i++)
				digits[i] = Integer.parseInt(split[i]);
			TreeSet<String> combos = new TreeSet<String>();
			List<Integer> current = new ArrayList<Integer>();
			for (int i = 0; i < digits.length; i++) {
				while (sum(current) != target) {
					if (sum(current) > target) {
						current.remove(current.size() - 1);
					}
				}
			}
		}
		scan.close();
	}
	
	public static int sum(List<Integer> numbers) {
		int sum = 0;
		for (int i : numbers)
			sum += i;
		return sum;
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
