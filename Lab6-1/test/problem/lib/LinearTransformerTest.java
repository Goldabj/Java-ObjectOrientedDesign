package problem.lib;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinearTransformerTest {
	LinearTransformer<String> transformer;
	String expected;
	int size;
	
	@Before
	public void setUp() throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Transformation in progress ...\n");

		size = 5;
		Vector<String> vect = new Vector<String>();
		for(int i = 1; i <= size; ++i) {
			String elem = "Tick Tick " + i; 
			vect.add(elem);
			buffer.append(i + " : " + elem + "\n");
		}
		
		buffer.append("Transformation complete!\n");
		expected = buffer.toString().trim();

		Enumeration<String> etion = vect.elements();
		transformer = new LinearTransformer<String>(etion);
	}

	@After
	public void tearDown() throws Exception {
		transformer = null;
	}

	@Test
	public final void testTransform() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		transformer.transform(out);		
		
		String actual = out.toString().trim();
		assertEquals(expected, actual);
	}
}
