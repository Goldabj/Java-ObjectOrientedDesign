package problem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EncryptionOutputTest {
	private SubstitutionCipher chiper;
	private OutputStream out;
	private EncryptionOutputStream cryptStream;
	private byte[] testString;

	@Before
	public void setUp() throws Exception {
		chiper = new SubstitutionCipher();
		testString = "testing this".getBytes();
		out = new ByteArrayOutputStream();
		cryptStream = new EncryptionOutputStream(out, chiper);
	}
	
	@Test
	public void test() throws IOException {
		char[] input = new char[testString.length];
		for(int i = 0; i < testString.length; i++) {
			input[i] = chiper.encrypt((char) testString[i]);
		}
		int i = 0;
		for(i =0; i < testString.length; i++) {
			cryptStream.write(testString[i]);
		}
		StringBuilder builder = new StringBuilder();
		for(i = 0; i < input.length; i++) {
			builder.append(Character.valueOf(input[i]));
		}
		
		assertEquals(builder.toString(), out.toString());
	
	}

}
