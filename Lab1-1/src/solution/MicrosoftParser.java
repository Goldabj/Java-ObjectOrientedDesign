package solution;

public class MicrosoftParser implements ILineParser {

	@Override
	public String parse(String line) {
		StringBuilder builder = new StringBuilder();
		String[] fields = line.split(",");
		builder.append(fields[0].trim());
		builder.append(" : ");
		builder.append(fields[1].trim());
		return builder.toString();
	}

}
