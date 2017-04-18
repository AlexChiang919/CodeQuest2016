import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prob12 {

	private static final String PROBLEM = "Prob12";
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
		int[] p3 = {1, 0, 1, 1};
		while (times-- > 0) {
			int[] data = toData(scan.nextLine().toCharArray());
			int index = index(data);
			while (!(index > data.length - 5 || index == -1)) {
				for (int i = index; i < index + 4; i++) {
					data[i] = xor(data[i], p3[i - index]);
				}
				index = index(data);
			}
			printLine((corrupt(data) ? "corrupt" : "ok"));
		}
		scan.close();
	}
	
	public static int[] toData(char[] line) {
		int[] data = new int[line.length];
		for (int i = 0; i < data.length; i++) {
			if (line[i] == '1')
				data[i] = 1;
			else if (line[i] == '0')
				data[i] = 0;
		}
		return data;
	}
	
	public static int index(int[] data) {
		for (int i = 0; i < data.length; i++)
			if (data[i] == 1)
				return i;
		return -1;
	}
	
	public static boolean corrupt(int[] data) {
		for (int i = 0; i < data.length; i++)
			if (data[i] == 1)
				return true;
		return false;
	}
	
	public static int xor(int a, int b) {
		return (a != b) ? 1 : 0;
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
