package problem.client;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import problem.lib.LinearTransformer;

public class App {
	public static void main(String[] args) throws Exception {
		
		// Test does this throw an error
		List<String> daList = null;
		for(String s : daList) {
			// never does nothin
		}
		// ArrayList<String> vect = new ArrayList<String>();
		//Vector<String> vect = new Vector<String>();
		ArrayList<String> arr = new ArrayList<>();
		Vector vect = new ArrayListToVectorAdapter(arr);
		for(int i = 1; i <= 3; ++i) {
			vect.add("Tick Tick " + i);
		}
		
		Enumeration<String> etion = vect.elements();
		LinearTransformer<String> lT = new LinearTransformer<String>(etion);
		lT.transform(System.out);
	}
}
