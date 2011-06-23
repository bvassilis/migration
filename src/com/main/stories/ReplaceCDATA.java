package com.main.stories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceCDATA {
	
	
	
	public static void main(String[] args) throws IOException {

		File folder = new File("import-stories");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				
				FileInputStream fstream = new FileInputStream(listOfFiles[i]);
				
				BufferedWriter out = new BufferedWriter(new FileWriter(listOfFiles[i].getAbsoluteFile()+"out.xml"));
				
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					strLine = strLine.replaceAll("\\<\\!\\[\\s*CDATA\\[\\<\\s*div\\>\\<\\s*p\\>", "<div\\>");
					strLine = strLine.replaceAll("\\<\\s*/p\\>\\<\\s*/div\\>\\]\\]\\>", "</div\\>");
//					strLine = strLine.replaceAll("\\<embed.*?\\>", "");
//					strLine = strLine.replaceAll("\\</embed\\>", "");
//					strLine = strLine.replaceAll("\\<EMBED.*?\\>", "");
//					strLine = strLine.replaceAll("\\</EMBED\\>", "");
//					strLine = strLine.replaceAll("img", "img alt=''");
					out.write(strLine);
				}
				// Close the input stream
				in.close();
				out.close();

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}
	
	public static void replace(String folderString) throws IOException {

		File folder = new File(folderString);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				
				FileInputStream fstream = new FileInputStream(listOfFiles[i]);
				
				BufferedWriter out = new BufferedWriter(new FileWriter(listOfFiles[i].getAbsoluteFile()+"out.xml"));
				
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				
				// Read File Line By Line
				while ((strLine = br.readLine()) != null) {
					// Print the content on the console
					strLine = strLine.replaceAll("\\<\\!\\[\\s*CDATA\\[\\<\\s*div\\>\\<\\s*p\\>", "<div\\>");
					strLine = strLine.replaceAll("\\<\\s*/p\\>\\<\\s*/div\\>\\]\\]\\>", "</div\\>");
//					strLine = strLine.replaceAll("\\<embed.*?\\>", "");
//					strLine = strLine.replaceAll("\\</embed\\>", "");
//					strLine = strLine.replaceAll("\\<EMBED.*?\\>", "");
//					strLine = strLine.replaceAll("\\</EMBED\\>", "");
//					strLine = strLine.replaceAll("img", "img alt=''");
					out.write(strLine);
				}
				// Close the input stream
				in.close();
				out.close();

			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}

}
