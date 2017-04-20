import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <b><u>Problem 04</u>:</b> Anagram Checker
 * <p>
 * <b>Java Program:</b> Prob04.java<br>
 * <b>Input File:</b> Prob04.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> You have been hired by Anagrammy to create an anagram
 * checker program that they can use to determine whether words submitted by
 * their users are anagrams or not for the purposes of determining a monthly
 * contest winner. Anagrammy only wants to check word anagrams in their anagram
 * checker and not deal with phrases for their first release. Anagrammy needs
 * your help in order to officially release their web site.
 * 
 * @author Alex Chiang
 *
 */
public class Prob04 {

	private static final String PROBLEM = "Prob04";
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
			String original = scan.nextLine();
			String[] split = original.split("\\|");
			if (split[0].equals(split[1])) {
				printLine(original + " = NOT AN ANAGRAM");
				continue;
			}
			char[] cA = split[0].toCharArray();
			char[] cB = split[1].toCharArray();
			Arrays.sort(cA);
			Arrays.sort(cB);
			printLine(original + " = " + (equals(cA, cB) ? "ANAGRAM" : "NOT AN ANAGRAM"));
		}
		scan.close();
	}

	private static boolean equals(char[] a, char[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
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
