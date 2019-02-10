package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataStandardizer {
	private static HashMap<String, ILineParser> parsers = new HashMap<>();
	private String companyName;
	private String data;
	
	public String publicField1;
	public String publicField2;
	protected String protectedField1;
	protected String protectedField2;
	private GoogleParser parserTest1;
	private List<MicrosoftParser> parsertestList1;
	
	public DataStandardizer() {
		this.companyName = "";
		this.data = "";
	}
	
	/**
	 * Parses the data file to the standard format: 
	 * <compnay Name>
	 * field : data 
	 * 
	 * @param path to the file to parse 
	 * @return
	 */
	public String parse(String path) {
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), charset)) {
			// First line represents the name of a company
			this.companyName = reader.readLine();

			// The rest is the data
			StringBuffer buffer = new StringBuffer();
			String line = null;
			ILineParser parser = parsers.get(this.companyName);
			if (parser == null) {
				System.err.println("DataStandarizer does not support this company format yet");
				return (this.data = "");
			} else {
				while ((line = reader.readLine()) != null) {
					buffer.append(parser.parse(line));
					buffer.append("\n");
				}
			}

			// Done unifying the data
			this.data = buffer.toString();
			return this.data;
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			return (this.data = "");
		}
	}
	
	/**
	 * Adds a new ILineParser type to the support library 
	 * 
	 * @param companyName - name that will be at the top of each file
	 * @param parser - line parsing algorithm 
	 */
	public static void addParser(String companyName, ILineParser parser) {
		parsers.put(companyName, parser);
	}
	
	public String getCompany() {
		return this.companyName;
	}
	
	public String getData() {
		return this.data;
	}
	
	private void privateTestMethod1() {
		String test1 = "Hello";
		String test2 = "hi";
		int test3 = 1;
		boolean test4 = true;
		List<String> test5 = new ArrayList<>();
		Thread test6 = new Thread();
	}
	
	private void privateTestMethod2() {
		// do nothing
	}
	
	protected void protectedTestMethod() {
		// do nothing
	}
	
	protected void protectedTestMethod2() {
		// do nothing
	}
	
}
