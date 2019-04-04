package com.javadbproject.jdbc;

public class Station {
	private int id;
	private String stationName;
	private String division;
	private int murderAssault;
	private int dangerousNegligance;
	private int kidnapping;
	private int robExtortHijack;
	private int burglary;
	private int theft;
	private int fraud;
	private int drugs;
	private int weapons;
	private int damageProperty;
	private int publicOrder;
	private int orgCrime;
	
	public Station(String division) {
		this.division = division;
	}
	//smaller constructor to test
	public Station(String stationName, String division, int murderAssault) {
		this.stationName = stationName;
		this.division = division;
		this.murderAssault = murderAssault;
	}

	//complete
	public Station(int id, String stationName, String division, int murderAssault, int dangerousNegligance,
			int kidnapping, int robExtortHijack, int burglary, int theft, int fraud, int drugs, int weapons,
			int damageProperty, int publicOrder, int orgCrime) {
		this.id = id;
		this.stationName = stationName;
		this.division = division;
		this.murderAssault = murderAssault;
		this.dangerousNegligance = dangerousNegligance;
		this.kidnapping = kidnapping;
		this.robExtortHijack = robExtortHijack;
		this.burglary = burglary;
		this.theft = theft;
		this.fraud = fraud;
		this.drugs = drugs;
		this.weapons = weapons;
		this.damageProperty = damageProperty;
		this.publicOrder = publicOrder;
		this.orgCrime = orgCrime;
	}

	public int getId() {
		return id;
	}

	public String getStationName() {
		return stationName;
	}

	public String getDivision() {
		return division;
	}

	public int getMurderAssault() {
		return murderAssault;
	}

	public int getDangerousNegligance() {
		return dangerousNegligance;
	}

	public int getKidnapping() {
		return kidnapping;
	}

	public int getRobExtortHijack() {
		return robExtortHijack;
	}

	public int getBurglary() {
		return burglary;
	}

	public int getTheft() {
		return theft;
	}

	public int getFraud() {
		return fraud;
	}

	public int getDrugs() {
		return drugs;
	}

	public int getWeapons() {
		return weapons;
	}

	public int getDamageProperty() {
		return damageProperty;
	}

	public int getPublicOrder() {
		return publicOrder;
	}

	public int getOrgCrime() {
		return orgCrime;
	}

	//smaller toString to test
	@Override
	public String toString() {
		return "Station [stationName=" + stationName + ", division=" + division + ", murderAssault=" + murderAssault
				+ "]";
	}

	
	
}
