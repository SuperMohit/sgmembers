package com.sg.members.DTO;

import com.sg.members.entity.Race;

public class MemberDTO {
	
	private int id;
	private String status;
	private int raceId;
	private int weight;
	private int height;
	private boolean is_veg;
	
	public MemberDTO(int id, String status, int raceId, int weight, int height, boolean is_veg) {
		super();
		this.id = id;
		this.status = status;
		this.setRaceId(raceId);
		this.setWeight(weight);
		this.setHeight(height);
		this.is_veg = is_veg;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	public boolean isIs_veg() {
		return is_veg;
	}
	public void setIs_veg(boolean is_veg) {
		this.is_veg = is_veg;
	}


	public int getRaceId() {
		return raceId;
	}


	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

}
