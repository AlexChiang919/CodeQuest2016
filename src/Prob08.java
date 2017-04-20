import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <b><u>Problem 08</b>:</u> Muddled Music
 * <p>
 * <b>Java Program:</b> Prob08.java<br>
 * <b>Input File:</b> Prob08.in.txt<br>
 * <b>Status</b>: FINISHED
 * <p>
 * <b>Description:</b> Your task is to write a program that will read in a list
 * of song – artist pairs and organize them.
 * 
 * @author Alex Chiang
 *
 */
public class Prob08 {

	private static final String PROBLEM = "Prob08";
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
			int s = Integer.parseInt(scan.nextLine());
			List<Song> songs = new ArrayList<Song>();
			while (s-- > 0) {
				String[] split = scan.nextLine().split(" \\- ");
				songs.add(new Song(split[1], split[0]));
			}
			Collections.sort(songs);
			for (int a = 0; a < songs.size(); a++)
				printLine(songs.get(a));
		}
		scan.close();
	}

	public static class Song implements Comparable<Song> {
		private String artist;
		private String name;

		public Song(String artist, String name) {
			this.artist = artist;
			this.name = name;
		}

		public String getArtist() {
			return artist;
		}

		public String getName() {
			return name;
		}

		@Override
		public int compareTo(Song s) {
			String oa = artist.startsWith("The ") ? artist.substring(4) : artist;
			String na = s.artist.startsWith("The ") ? s.artist.substring(4) : s.artist;
			int ca = oa.toUpperCase().compareTo(na.toUpperCase());
			if (ca != 0)
				return ca;
			return name.toUpperCase().compareTo(s.name.toUpperCase());
		}

		@Override
		public String toString() {
			return name + " - " + artist;
		}
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
