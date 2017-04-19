import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Prob06 {

	private static final String PROBLEM = "Prob06";
	private static final String EXT = ".in.txt";

	public static void main(String[] args) {
		Scanner scan;
		try {
			scan = new Scanner(new File(PROBLEM + EXT));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int sets = Integer.parseInt(scan.nextLine());
		while (sets-- > 0) {
			String school = scan.nextLine();
			int students = Integer.parseInt(scan.nextLine());
			HashMap<String, Double> gpa = new HashMap<String, Double>();
			HashMap<String, Integer> hours = new HashMap<String, Integer>();
			while (students-- > 0) {
				String[] split = scan.nextLine().split("[\\:\\,]");
				String student = split[0];
				double sum = 0.0;
				int hour = 0;
				for (int i = 1; i < split.length; i++) {
					char[] ch = split[i].toCharArray();
					int g = 0;
					switch(ch[0]) {
					case 'A': g = 4;break;
					case 'B': g = 3; break;
					case 'C': g = 2; break;
					case 'D': g = 1; break;
					}
					sum += g * Integer.parseInt("" + ch[1]);
					hour += Integer.parseInt("" + ch[1]);
				}
				gpa.put(student, sum / hour);
				hours.put(student, hour);
			}
			String stu = "";
			double avg = 0.0;
			for (String s : gpa.keySet()) {
				if (gpa.get(s) > avg) {
					stu = s;
					avg = gpa.get(s);
				} else if (gpa.get(s) == avg) {
					int hO = hours.get(stu);
					int hN = hours.get(s);
					if (hN > hO) {
						stu = s;
					}
				}
			}
			printLine(school + " = " + stu);
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
