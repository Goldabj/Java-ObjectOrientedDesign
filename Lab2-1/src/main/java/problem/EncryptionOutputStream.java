package problem;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EncryptionOutputStream extends FilterOutputStream {
	OutputStream output; 
	IEncryption chiper;
	
	protected EncryptionOutputStream(OutputStream out, IEncryption encrypt) {
		super(out);
		output = out;
		chiper = encrypt;
	}
	
	@Override
	public void write(int toWrite) throws IOException {
		int crypt = chiper.encrypt((char) toWrite);
		out.write(crypt);
	}

}
