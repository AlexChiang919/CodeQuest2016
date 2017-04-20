import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * <b><u>Problem 05</b>:</u> Mobile Miser
 * <p>
 * <b>Java Program:</b> Prob05.java<br>
 * <b>Input File:</b> Prob05.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> Your program will read a file with various bill amounts
 * from fine dining restaurants and calculate the gratuity as a percentage of
 * the bill. As is customary in U.S. restaurants, gratuity typically ranges from
 * 15%-20% of the bill, so your program needs to calculate the gratuities at the
 * 15%, 18% and 20% levels (rounding to the nearest cent using the CodeQuest
 * rounding guidelines found in Appendix A) and display this in the output. You
 * will get no points for claiming bad service and leaving a 0% tip on the bill!
 * 
 * @author Alex Chiang
 *
 */
public class Prob05 {

	private static final String PROBLEM = "Prob05";
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
			double bill = Double.parseDouble(scan.nextLine().substring(1));
			BigDecimal total = BigDecimal.valueOf(bill);
			BigDecimal fift = total.multiply(BigDecimal.valueOf(0.15d));
			BigDecimal eigh = total.multiply(BigDecimal.valueOf(0.18d));
			BigDecimal twen = total.multiply(BigDecimal.valueOf(0.20d));
			printLine("Total of the bill: $" + total);
			printLine("15% = $" + String.format("%.2f", fift));
			printLine("18% = $" + String.format("%.2f", eigh));
			printLine("20% = $" + String.format("%.2f", twen));
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
