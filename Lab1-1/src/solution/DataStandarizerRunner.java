package solution;

import problem.AmazonParser;

public class DataStandarizerRunner {

	public static void main(String[] args) {
		DataStandardizerGUI gui = new DataStandardizerGUI();
		DataStandardizer.addParser("amazon", new AmazonParser());
		gui.execute();
	}

}
