package com.coderwurst.tdd;

public class FootballTeam implements Comparable <FootballTeam>{

	private int gamesWon;

	public FootballTeam(int gamesWon) {
		if (gamesWon >= 0 && gamesWon < 38) {
			this.gamesWon = gamesWon;
		} else {
			throw new IllegalArgumentException("Illegal ARGS: " + gamesWon);
		}
	
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	@Override
	public int compareTo(FootballTeam otherTeam) {
		
		return gamesWon - otherTeam.getGamesWon();
	}
	
}
