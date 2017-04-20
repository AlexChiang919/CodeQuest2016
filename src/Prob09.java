import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <b><u>Problem 09</b>:</u> Navigating the World
 * <p>
 * <b>Java Program:</b> Prob09.java<br>
 * <b>Input File:</b> Prob09.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> Your company is working on a new mobile app, you have
 * been asked to write the code that will convert a file containing a list of
 * zoom levels and associated GPS coordinates into URLs to download the
 * corresponding map tile from OpenStreetMap.
 * 
 * @author Alex Chiang
 *
 */
public class Prob09 {

	private static final String PROBLEM = "Prob09";
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
			String[] split = scan.nextLine().split(" ");
			int zoom = Integer.parseInt(split[0]);
			double lat = Double.parseDouble(split[1]);
			double lon = Double.parseDouble(split[2]);
			printLine(String.format("http://tile.openstreetmap.org/%d/%d/%d.png", zoom, x(zoom, lon), y(zoom, lat)));
		}
		scan.close();
	}

	public static int x(int zoom, double longitude) {
		return (int) ((longitude + 180) / 360 * Math.pow(2, zoom));
	}

	public static int y(int zoom, double latitude) {
		return (int) ((1
				- ((Math.log(Math.tan(latitude * (Math.PI / 180)) + (1 / Math.cos(latitude * (Math.PI / 180)))))
						/ Math.PI))
				* Math.pow(2, zoom - 1));
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
