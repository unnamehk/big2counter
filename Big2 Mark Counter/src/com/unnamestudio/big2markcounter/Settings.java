package com.unnamestudio.big2markcounter;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;

import com.unnamestudio.framework.FileIO;

public class Settings {
	public final static String file = ".Big2MarkCounter";
	public static int lang = 1; //language option: 1 = zh; 2 = en; 3 = cn
	
	public static int character_spade = 1;
	public static int character_heart = 1;
	public static int character_club = 1;
	public static int character_diamond = 1;
	
	public static int round = 1;
	
	public static int spade_balance = 0;
	public static int spade_be_fired = 0;
	public static int spade_wins = 0;
	public static int heart_balance = 0;
	public static int heart_be_fired = 0;
	public static int heart_wins = 0;
	public static int club_balance = 0;
	public static int club_be_fired = 0;
	public static int club_wins = 0;
	public static int diamond_balance = 0;
	public static int diamond_be_fired = 0;
	public static int diamond_wins = 0;
	
	public static void load(FileIO files) { 
		BufferedReader in = null; 
		try {
			in = new BufferedReader(new InputStreamReader( files.readFile(file)));
			lang = Integer.parseInt(in.readLine());
			character_spade = Integer.parseInt(in.readLine());
			character_heart = Integer.parseInt(in.readLine());
			character_club = Integer.parseInt(in.readLine());
			character_diamond = Integer.parseInt(in.readLine());
			round = Integer.parseInt(in.readLine());
			spade_balance = Integer.parseInt(in.readLine());
			spade_be_fired = Integer.parseInt(in.readLine());
			spade_wins = Integer.parseInt(in.readLine());
			heart_balance = Integer.parseInt(in.readLine());
			heart_be_fired = Integer.parseInt(in.readLine());
			heart_wins = Integer.parseInt(in.readLine());
			club_balance = Integer.parseInt(in.readLine());
			club_be_fired = Integer.parseInt(in.readLine());
			club_wins = Integer.parseInt(in.readLine());
			diamond_balance = Integer.parseInt(in.readLine());
			diamond_be_fired = Integer.parseInt(in.readLine());
			diamond_wins = Integer.parseInt(in.readLine());
			
		} catch (IOException e) {
			// :( It's ok we have defaults
		} catch (NumberFormatException e) { 
			// :/ It's ok, defaults save our day
		} finally { 
			try {
				if (in != null) in.close();
			} catch (IOException e) { 
			}
		}
	}
	
	public static void save(FileIO files) { 
		BufferedWriter out = null; 
		try {
			out = new BufferedWriter(new OutputStreamWriter( files.writeFile(file)));
			out.write(Integer.toString(lang));
			out.write("\n");
			out.write(Integer.toString(character_spade));
			out.write("\n");
			out.write(Integer.toString(character_heart));
			out.write("\n");
			out.write(Integer.toString(character_club));
			out.write("\n");
			out.write(Integer.toString(character_diamond));
			out.write("\n");
			out.write(Integer.toString(round));
			out.write("\n");
			out.write(Integer.toString(spade_balance));
			out.write("\n");
			out.write(Integer.toString(spade_be_fired));
			out.write("\n");
			out.write(Integer.toString(spade_wins));
			out.write("\n");
			out.write(Integer.toString(heart_balance));
			out.write("\n");
			out.write(Integer.toString(heart_be_fired));
			out.write("\n");
			out.write(Integer.toString(heart_wins));
			out.write("\n");
			out.write(Integer.toString(club_balance));
			out.write("\n");
			out.write(Integer.toString(club_be_fired));
			out.write("\n");
			out.write(Integer.toString(club_wins));
			out.write("\n");
			out.write(Integer.toString(diamond_balance));
			out.write("\n");
			out.write(Integer.toString(diamond_be_fired));
			out.write("\n");
			out.write(Integer.toString(diamond_wins));
			out.write("\n");
			
		}catch (IOException e) {
		}finally {
			try { 
				if (out != null)
					out.close(); 
				} catch (IOException e) {
				}
		}
	}
}
