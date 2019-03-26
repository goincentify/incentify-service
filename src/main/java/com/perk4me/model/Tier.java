package com.perk4me.model;

public class Tier {
	int rank;
	int totalDaysGoal;
	int onTimePercentageGoal;
	String value;

	// used for accessors
	public Tier() {
	}

	public Tier(int rank, int totalDaysGoal, int onTimePercentageGoal) {
		this.rank = rank;
		this.totalDaysGoal = totalDaysGoal;
		this.onTimePercentageGoal = onTimePercentageGoal;
	}

	public Tier(int rank, int totalDaysGoal, int onTimePercentageGoal, String value) {
		this.rank = rank;
		this.totalDaysGoal = totalDaysGoal;
		this.onTimePercentageGoal = onTimePercentageGoal;
		this.value = value;
	}

	public Tier getTier(User user) {
		return new Tier(2, 180, 90, "Silver");
	}

	public String getValue() {
		return this.value;
	}
}