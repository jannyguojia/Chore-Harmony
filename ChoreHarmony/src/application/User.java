package application;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	private String name;
	private String email;
	private String password;
	private ArrayList<Chore> choreList = new ArrayList<Chore>();
	private Boolean isCreator;

	public User(String name, String email, String password, boolean isCreator) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.isCreator = isCreator;
	}

	// add a chore to this user
	public void addChore(Chore chore) {
		System.out.println("test1");
		choreList.add(chore);
	}

	public Boolean getIsCreator() {
		return isCreator;
	}

	public void setIsCreator(Boolean isCreator) {
		this.isCreator = isCreator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Chore> getChoreList() {
		return choreList;
	}

	public void setChoreList(ArrayList<Chore> choreList) {
		this.choreList = choreList;
	}

}
