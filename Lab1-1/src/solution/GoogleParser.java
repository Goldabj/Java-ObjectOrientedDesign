package solution;

public class GoogleParser implements ILineParser {

	@Override
	public String parse(String line) {
		return line.replace('-', ':');
	}

}
