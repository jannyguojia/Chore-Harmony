package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Chore implements Serializable {

	private String name;
	private String frequency;
	private String startTime;
	private boolean teamTask;
	private ArrayList<User> teamMemberList = new ArrayList<User>();

	public Chore(String name, String frequency, String startTime, boolean teamTask) {
		super();
		this.name = name;
		this.frequency = frequency;
		this.startTime = startTime;
		this.teamTask = teamTask;
	}

//	@Override
//	public String toString() {
//		return "name: " + name + "   frequency:" + frequency + "  startTime:" + startTime + "  teamTask:" + teamTask;
//	}

	// add team member to this chore
	public void addTeamMember(User teamMember) {
		teamMemberList.add(teamMember);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public boolean isTeamTask() {
		return teamTask;
	}

	public void setTeamTask(boolean teamTask) {
		this.teamTask = teamTask;
	}

	public ArrayList<User> getTeamMemberList() {
		return teamMemberList;
	}

	public void setTeamMemberList(ArrayList<User> teamMemberList) {
		this.teamMemberList = teamMemberList;
	}

}
