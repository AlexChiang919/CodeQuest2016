import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 11</b>:</u> Encryption
 * <p>
 * <b>Java Program:</b> Prob11.java<br>
 * <b>Input File:</b> Prob11.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> You have been hired to encrypt and decrypt messages
 * according to the cipher key (the mapping for the alphabet into the new
 * encoding). You must be able to both encrypt and decrypt messages, where
 * encrypt means to map from the standard English alphabet to the cipher key and
 * decrypt means to map from the cipher key to the standard English alphabet.
 * You must also be adaptable to being given a different cipher key each time.
 * 
 * @author Alex Chiang
 *
 */
public class Prob11 {

	private static final String PROBLEM = "Prob11";
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
			String action = scan.nextLine();
			String map = scan.nextLine();
			int lines = Integer.parseInt(scan.nextLine());
			while (lines-- > 0) {
				String line = scan.nextLine();
				String out = "";
				if (action.equals("ENCRYPT")) {
					for (int i = 0; i < line.length(); i++) {
						char c = line.charAt(i);
						if (c == ' ')
							out += ' ';
						else if (Character.isUpperCase(c))
							out += Character.toUpperCase(map.charAt((int) (Character.toUpperCase(c) - 'A')));
						else if (Character.isLowerCase(c))
							out += Character.toLowerCase(map.charAt((int) (Character.toUpperCase(c) - 'A')));
					}
				} else if (action.equals("DECRYPT")) {
					for (int i = 0; i < line.length(); i++) {
						char c = line.charAt(i);
						if (c == ' ')
							out += ' ';
						else if (Character.isUpperCase(c))
							out += Character.toUpperCase((char) ('A' + map.indexOf(Character.toLowerCase(c))));
						else if (Character.isLowerCase(c))
							out += Character.toLowerCase((char) ('A' + map.indexOf(Character.toLowerCase(c))));
					}
				}
				printLine(out);
			}
			printLine();
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
