package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
		public static void main(String[] args) {
			String location = "";
			String file = "";

		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		
		File directory = new File("src");
		File[] files = directory.listFiles();
		for(int i = 0; i<files.length; i++) {
			File[] moreFiles = files[i].listFiles();
			for(int j = 0; j<moreFiles.length; j++) {
				if(moreFiles[j].getName().contains(".txt")) {
					try {
						FileWriter fw = new FileWriter(moreFiles[j].getAbsolutePath(), true);
						fw.write("\n Copyright © 2019 Joe Mother");
							
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
}
