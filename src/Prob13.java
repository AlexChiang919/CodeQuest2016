import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <b><u>Problem 13</b>:</u> Communtative Combo!
 * <p>
 * <b>Java Program:</b> Prob13.java<br>
 * <b>Input File:</b> Prob13.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> Just do it.
 * 
 * @author Alex Chiang
 *
 */
public class Prob13 {

	private static final String PROBLEM = "Prob13";
	private static final String EXT = ".in.txt";

	private static int target;
	private static int[] digits;
	private static boolean[] used;
	private static ArrayList<String> combos = new ArrayList<String>();
	
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
			combos = new ArrayList<String>();
			int target = Integer.parseInt(scan.nextLine().substring(9));
			String[] split = scan.nextLine().split("\\,");
			int[] digits = new int[split.length];
			for (int i = 0; i < digits.length; i++)
				digits[i] = Integer.parseInt(split[i]);
			Prob13.target = target;
			Prob13.digits = digits;
			used = new boolean[split.length];
			Arrays.fill(used, false);
			Arrays.sort(digits);
			findSums(0, "");
		}
		scan.close();
	}
	
	public static void findSums(int currentSum, String currentString) {
		if (currentSum == target) {
			if (!combos.contains(currentString)) {
				combos.add(currentString);
				printLine(currentString);
			}
			return;
		} else {
			for (int i = 0; i < digits.length; i++) {
				if (!used[i]) {
					if (currentSum + digits[i] <= target) {
						used[i] = true;
						String newString = currentString;
						if (newString.length() > 0)
							newString += "+";
						newString += digits[i];
						findSums(currentSum + digits[i], newString);
						used[i] = false;
					} else {
						i = digits.length;
					}
				}
			}
		}
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
