package problem;

import solution.ILineParser;

public class GrouponParser implements ILineParser {

	@Override
	public String parse(String line) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ' ') {
				if(line.charAt(i+1) != ' ') {
					builder.append(" : ");
				}
			}else {
				builder.append(line.charAt(i));
			}
		}
		return builder.toString();
	
	}

}
