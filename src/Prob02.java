import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 02</u>:</b>  Change for the World
 * <p>
 * <b>Java Program:</b> Prob02.java<br>
 * <b>Input File:</b> Prob02.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * In order to strike the right balance of quirky and practical, you need to be
 * able to pay for things using the fewest number of coins possible – and your
 * program will help you do just that.
 * 
 * @author Alex Chiang
 *
 */
public class Prob02 {

	private static final String PROBLEM = "Prob02";
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
			final double c = Double.parseDouble(scan.nextLine().substring(1));
			double change = c;
			int q = 0;
			int d = 0;
			int n = 0;
			int p = 0;
			while (change > 0.0) {
				if (change >= 0.25) {
					q += change / 0.25;
					change %= 0.25;
				} else if (change >= 0.1) {
					d += change / 0.1;
					change %= 0.1;
				} else if (change >= 0.05) {
					n += change / 0.05;
					change %= 0.05;
				} else {
					p += change / 0.01;
					change = 0;
				}
			}
			printLine("$" + String.format("%.2f", c));
			printLine("Quarters=" + q);
			printLine("Dimes=" + d);
			printLine("Nickelbacks=" + n);
			printLine("Pennies=" + p);
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
