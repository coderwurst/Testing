package com.coderwurst.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

	private static final int ANY_NUMBER = 33;
	private static final int THREE_GAMES_WON = 3;

	public Object [] numberOfGamesWon() {
		return new Object [] {
				new Object [] {0},
				new Object [] {1},
				new Object [] {2}
		};
	}
	
	public Object [] invalidParams() {
		return new Object [] {
				new Object [] {-1},
				new Object [] {1011},
				new Object [] {-10}
		};
	}
	
	@Test
	@Parameters(method = "numberOfGamesWon")
	public void testContructor(int numberOfGames) {
		
		FootballTeam team = new FootballTeam(numberOfGames);
		assertEquals("team should have won "+ numberOfGames + " games and " 
		+ team.getGamesWon() + " has been returned", numberOfGames, team.getGamesWon());
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	@Parameters(method = "invalidParams")
	public void testInvalidParams(int numberOfGames) {
		
		FootballTeam team = new FootballTeam(numberOfGames);
		
	}
	
	@Test
	public void testFootballTeamIsComparable() {
	
		FootballTeam team = new FootballTeam(ANY_NUMBER);
		
		assertTrue("team is not an instance of comparable", team instanceof Comparable);
		
	}
	
	@Test
	public void testTeamWithMoreWinsShouldBeGreater() {
	
		FootballTeam winners = new FootballTeam(22);
		FootballTeam losers = new FootballTeam(12);

		assertTrue("team with less wins is above team with more wins", winners.compareTo(losers) > 0);
		
	}
	
	@Test
	public void testTeamWithLessWinsShouldBeLesser() {
		
		FootballTeam losers = new FootballTeam(2);
		FootballTeam winners = new FootballTeam(22);
		
		assertTrue("team with less wins is below team with more wins", losers.compareTo(winners) < 0);	
	}
	
	@Test
	public void testTeamsWithSameWinsAreEqual() {
		
		FootballTeam losers = new FootballTeam(2);
		FootballTeam winners = new FootballTeam(2);
		
		assertTrue("team with less wins is below team with more wins", losers.compareTo(winners) == 0);
	}
		
}
