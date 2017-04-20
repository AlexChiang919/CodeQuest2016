import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * <b><u>Problem 17</b>:</u> Honeycomb
 * <p>
 * <b>Java Program:</b> Prob17.java<br>
 * <b>Input File:</b> Prob17.in.txt<br>
 * <b>Status</b>: IN PROGRESS
 * <p>
 * <b>Description:</b> In this problem, you are a honey bee. You are currently
 * located at the top of the honeycomb triangle. You are supposed to leave soon
 * to go gather pollen, but you left your pollen brush in the bottom right
 * corner of the triangle. And you just remembered that your pollen bag is in
 * the bottom left corner! You need to collect your things, and you need to do
 * it quickly so you don’t get left behind. Since the door to the bee hive is
 * just above the top of the honeycomb, you need to find the fastest route to go
 * from the top of the honeycomb to the bottom right, then to the bottom left,
 * and back to the top again.
 * 
 * @author Alex Chiang
 *
 */
public class Prob17 {

	private static final String PROBLEM = "Prob17";
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
			int times = Integer.parseInt(scan.nextLine());
			int[][] honeycomb = new int[times][];
			for (int i = 0; i < times; i++) {
				String[] split = scan.nextLine().split("\\,");
				honeycomb[i] = new int[split.length];
				for (int j = 0; j < honeycomb[i].length; j++) {
					honeycomb[i][j] = Integer.parseInt(split[j]);
				}
			}
			// printLine(Arrays.deepToString(honeycomb));
			int[][] distance = bofus(honeycomb, 0, 0);
			int[][] distance1 = bofus(honeycomb, honeycomb.length - 1, 0);
			int[][] distance2 = bofus(honeycomb, honeycomb.length - 1, honeycomb[honeycomb.length - 1].length - 1);
			printLine(distance[honeycomb.length - 1][0]
					+ distance1[honeycomb.length - 1][honeycomb[honeycomb.length - 1].length - 1] + distance2[0][0]);
		}
		scan.close();
	}

	private static int[][] d = { { -1, -1, 0, 0, 1, 1 }, { -1, 0, -1, 1, 0, 1 } };

	public static int[][] bofus(int[][] honeycomb, int sr, int sc) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] distance = new int[honeycomb.length][];
		for (int i = 0; i < honeycomb.length; i++) {
			distance[i] = new int[honeycomb[i].length];
			Arrays.fill(distance[i], 1000000);
		}
		q.add(sr);
		q.add(sc);
		distance[sr][sc] = 0;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int i = 0; i < 6; i++) {
				int rr = r + d[0][i];
				int cc = c + d[1][i];
				if (!inBounds(honeycomb, rr, cc))
					continue;
				if (distance[r][c] + honeycomb[rr][cc] < distance[rr][cc]) {
					distance[rr][cc] = distance[r][c] + honeycomb[rr][cc];
					q.add(rr);
					q.add(cc);
				}
			}
		}
		printLine(Arrays.deepToString(honeycomb));
		printLine(Arrays.deepToString(distance));
		return distance;
	}

	public static boolean inBounds(int[][] array, int r, int c) {
		return (r > 0 && r < array.length) && (c > 0 && c < array[r].length);
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
