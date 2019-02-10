package problem;

import solution.ILineParser;

public class AmazonParser implements ILineParser {

	@Override
	public String parse(String line) {
		StringBuilder builder = new StringBuilder();
		String[] strings = line.split(",");
		line.length();
		
		builder.append(strings[0].trim().replace(" ttl ", " : ")+ "\n");
		builder.append(strings[1].trim().replace(" ttl ", " : ") );
		return builder.toString();
	}
	
	public int[][] rotated(int[][] matrix, int flag) {
		int rotate[][] = new int[matrix.length][matrix[0].length];
		int rotater[][] = new int[1][0];
		rotater[0][0] = 1;
	}

}
