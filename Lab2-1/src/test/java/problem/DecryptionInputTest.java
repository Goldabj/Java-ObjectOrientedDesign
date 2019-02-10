package problem;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DecryptionInputTest {
	private SubstitutionCipher chiper;
	private InputStream in;
	private DecryptionInputStream cryptStream;
	private byte[] testString;


	@Before
	public void setUp() throws Exception {
		chiper = new SubstitutionCipher();
		testString = "testing this".getBytes();
		byte[] input = new byte[testString.length];
		for(int i = 0; i < testString.length; i++) {
			input[i] = (byte) chiper.encrypt((char) testString[i]);
		}
		in = new ByteArrayInputStream(input);
		cryptStream = new DecryptionInputStream(in, chiper);
		
	}
	
	@Test
	public void test() throws IOException {
		int character;
		int i = 0;
		while((character = cryptStream.read()) != -1) {
			assertEquals(testString[i], (byte) character);
			i++;
		}
	}

}
