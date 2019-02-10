package problem;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
	
public class DecryptionInputStream extends FilterInputStream {
	InputStream input; 
	IDecryption chiper;
	
	protected DecryptionInputStream(InputStream in, IDecryption decrypt) {
		super(in);
		input = in;
		chiper = decrypt;
	}
	
	@Override
	public int read() throws IOException {
		int bite = in.read();
		if(bite == -1) {
			return -1;
		}
		char letter = chiper.decrypt((char) bite);
		return letter;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int bites = in.read(b, off, len);
		for (int i = 0; i < bites; i++) {
			b[i] = (byte) chiper.decrypt((char) b[i]);
		}
		return bites;
	}
	
	


}
