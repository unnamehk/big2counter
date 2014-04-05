package com.unnamestudio.big2markcounter;

import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter;

import com.unnamestudio.framework.FileIO;

public class Settings {
	public final static String file = ".Big2MarkCounter";
	public static int lang = 1; //1 = zh; 2 = en; 3 = cn
	public static void load(FileIO files) { 
		BufferedReader in = null; 
		try {
			in = new BufferedReader(new InputStreamReader( files.readFile(file)));
			lang = Integer.parseInt(in.readLine());
			
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
