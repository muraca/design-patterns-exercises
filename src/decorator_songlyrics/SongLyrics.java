package decorator_songlyrics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import decorator_songlyrics.model.CleanLyricsDecorator;
import decorator_songlyrics.model.Lyrics;
import decorator_songlyrics.model.PopSongLyrics;
import decorator_songlyrics.model.RapSongLyrics;
import decorator_songlyrics.model.RockSongLyrics;

public class SongLyrics {
	
	private static boolean readSongs(BufferedReader reader) {
		Lyrics l = null;
		System.out.println("Which song lyrics would you like to read?");
		System.out.println("1: Pop song");
		System.out.println("2: Rap song");
		System.out.println("3: Rock song");
		System.out.println("0: exit");
		System.out.print("Insert your choice: ");
		int choice = 0;
		String input = null;
		try {
			input = reader.readLine();
			choice = Integer.parseInt(input);
			
			switch (choice) {
			case 1:
				l = new PopSongLyrics();
				break;
			case 2:
				l = new RapSongLyrics();
				break;
			case 3:
				l = new RockSongLyrics();
				break;
			case 0:
				return false;
			default:
				System.out.println("Invalid! Try again.");
				return true;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e1) {
			System.out.println("Invalid! Try again.");
		}
		System.out.println("Are you over 18 and willing to read explicit content?");
		System.out.print("Insert y for yes: ");
		try {
			input = reader.readLine();
			if (!input.equalsIgnoreCase("y"))
				l = new CleanLyricsDecorator(l);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println("Lyrics: ");
		System.out.println(l.getLyrics());
		System.out.println("");
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome! This is a song lyrics database!");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(readSongs(reader)) {
			continue;
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Bye!");
	}
}
