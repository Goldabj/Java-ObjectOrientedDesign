package problem.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayListToVectorTest {
	Vector<Integer> vect;

	@Before
	public void setUp() throws Exception {
		ArrayList<Integer> arr = new ArrayList<>();
		this.vect = new ArrayListToVectorAdapter(arr);
	}


	@Test
	public void test() {
		for(int i = 0; i < 6; i++) {
			this.vect.add(i);
		}
		Enumeration<Integer> enumer = this.vect.elements();
		for(int i = 0; i < 6; i++) {
			assertEquals(Integer.valueOf(i), enumer.nextElement());
		}
		
		assertFalse(enumer.hasMoreElements());
	}

}
