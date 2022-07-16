package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileEncryptor {
	int moveRight;
	String stringToEncrypt;

	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public void encriptingClass(String stringToEncrypt, int moveRight) {
		this.moveRight = moveRight;
		if(moveRight>28){
			moveRight = moveRight-28;
		}

		if (moveRight != 0) {
			try {
				FileReader fr = new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt");
				int c = fr.read();
				while (c != -1) {
					System.out.print((char) c);
					c = fr.read();
				}
				fr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
