package problem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import edu.rosehulman.csse374.editor.TextEditor;

// 
// 		 2. Go to the input_output folder and review in.txt and out.txt to see what the editor does.
//		 3. There are two more files in input_output: encryptedin.txt and encryptedout.txt. Your
//			job is to use the SubstibutioCipher object to do the following:
//
//			a. Develop a custom Inputstream that decorates another InputStream and can read the encrypted 
//				text from the decorated InputStream while decrypting it character-by-character.
//			b. Develop a custom Outputstream that decorates another OutputStream and can write plain text 
//				while encrypting it character-by-character.
//			c. Decorate the FileInputStream object below with the custom Inputstream developed in a.
//			d. Decorate the FileOutputStream object below with the custom OutputStream developed in b.
//
// By doing all of these, you are in fact adding a new feature to the TextEditor framework without
// changing a single line of its code. If you see the dependencies section in build.gradle, you will find that 
// we are in fact getting the TextEditor jar as a library and using it in this class. 
// Ohhh the beauty of OO decoration! Decorators do make things beautiful, don't they?
public class TextEditorApp {
	public static void main(String[] args) throws Exception {
		// 
		InputStream in = new FileInputStream("./input_output/encryptedin.txt");
		OutputStream out = new FileOutputStream("./input_output/encryptedout.txt");
		
		SubstitutionCipher chiper = new SubstitutionCipher();
		
		DecryptionInputStream inCrypt = new DecryptionInputStream(in, chiper);
		EncryptionOutputStream outCrypt = new EncryptionOutputStream(out, chiper);
		
				
		TextEditor editor = new TextEditor(inCrypt, outCrypt);
		editor.execute();
		
	}	
	
	
	
}
