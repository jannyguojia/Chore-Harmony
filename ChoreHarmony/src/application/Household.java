package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Household implements Serializable {

	private String name;
	private ArrayList<Chore> chores = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();

	public Household(String name) {
		super();
		this.name = name;
	}

	// add a chore to this household
	public void addChore(Chore chore) {
		chores.add(chore);
	}

	// add a team member to this household
	public void addUser(User user) {
		users.add(user);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Chore> getChores() {
		return chores;
	}

	public void setChores(ArrayList<Chore> chores) {
		this.chores = chores;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

}
