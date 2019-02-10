package problem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem.api.Team;

public class UniversalTests {
	@Test
	public void test() {
		Team t = UniversalObjectFactory.create(Team.class);
	//	System.out.println(t.getName());
	//	System.out.println(t.getLosses());
	//	System.out.println(t.getWins());
		System.out.println(t.getDefensiveStartingLineup());
		System.out.println(t.getOffensiveStartingLineup());
		System.out.println(t.getSpecialTeamsStartingLineup());
		
		t.setName("Colts");
		System.out.println(t.getName());
		
		t.incrementLosses();
		System.out.println(String.valueOf(t.getLosses()));
		
		
	}

}
