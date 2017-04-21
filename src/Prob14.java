import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 14</b>:</u> Turkey
 * <p>
 * <b>Java Program:</b> Prob14.java<br>
 * <b>Input File:</b> Prob14.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> This problem isn't about Thanksgiving, itís about
 * bowling! If youíve ever gone bowling, then you know that the scoring can be
 * complicated. Thatís why we want you to write a program to do it.
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
			String[] split = scan.nextLine().split("\\,");
			int[] score = new int[10];
			for (int a = 0; a < split.length - 1; a++) {
				for (int b = 0; b < split[a].length(); b++) {
					char c = split[a].charAt(b);
					if (c != '-' && c != 'X' && c != '/')
						score[a] += Integer.parseInt("" + c);
					else if (c == '/' || c == 'X') {
						if (c == '/') {
							int before = (split[a].charAt(b - 1) == '-') ? 0 : Integer.parseInt("" + split[a].charAt(b - 1));
							score[a] += 10 - before;
						} else
							score[a] += 10;
						char cc = split[a + 1].charAt(0);
						if (cc == 'X')
							score[a] += 10;
						else if (cc != '-')
							score[a] += Integer.parseInt("" + cc);
						if (c == 'X') {
							int before = 0;
							if (split[a + 1].length() == 1) {
								cc = split[a + 2].charAt(0);
							} else {
								cc = split[a + 1].charAt(1);
								if (split[a + 1].charAt(0) != '-' && split[a + 1].charAt(0) != 'X')
									before = Integer.parseInt("" + split[a + 1].charAt(0));
							}
							if (cc == 'X')
								score[a] += 10;
							else if (cc == '/')
								score[a] += 10 - before;
							else if (cc != '-')
								score[a] += Integer.parseInt("" + cc);
						}
					}
				}
			}
			for (int b = 0; b < split[9].length(); b++) {
				char c = split[9].charAt(b);
				if (c != '-' && c != 'X' && c != '/')
					score[9] += Integer.parseInt("" + c);
				else if (c == '/') {
					int before = (split[9].charAt(b - 1) == '-') ? 0 : Integer.parseInt("" + split[9].charAt(b - 1));
					score[9] += 10 - before;
				} else if (c == 'X')
					score[9] += 10;
			}
			printLine(sum(score));
		}
		scan.close();
	}
	
	public static int sum(int[] score) {
		int sum = 0;
		for (int i : score)
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