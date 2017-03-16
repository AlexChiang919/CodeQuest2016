import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob07 {

	private static final String PROBLEM = "Prob07";
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
			int lines = Integer.parseInt(scan.nextLine());
			char[][] array = new char[lines][];
			for (int i = 0; i < lines; i++) {
				array[i] = scan.nextLine().toCharArray();
			}
			String[] split = scan.nextLine().split("\\,");
			final int sr = Integer.parseInt(split[0]);
			final int sc = Integer.parseInt(split[1]);
			int liness = Integer.parseInt(scan.nextLine());
			char[][] hidden = new char[liness][];
			for (int i = 0; i < liness; i++) {
				hidden[i] = scan.nextLine().toCharArray();
			}
			String message = "";
			for (int r = 0; r < hidden.length; r++) {
				for (int c = 0; c < hidden[r].length; c++) {
					if (hidden[r][c] == 'O') {
						message += array[sr + r][sc + c];
					}
				}
			}
			printLine(message);
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
