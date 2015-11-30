package com.sg.members.entity;

public enum Race {

	Asian(0), Indian(1), African_Americans(2), Asian_Americans(3), European(4), British(5), Jewish(6), Latino(
			7), Native_American(8), Arabic(9);

	private int raceId;

	Race(int raceId) {
		this.setRaceId(raceId);

	}

	public int getRaceId() {
		return raceId;
	}

	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}

}
