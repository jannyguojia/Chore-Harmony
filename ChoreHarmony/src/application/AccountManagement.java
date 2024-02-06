package application;

import java.util.ArrayList;

/**
 * This private method is responsible for opening the "Add A Chore" page in the application.
 * It sets the title of the current stage to "Add A Chore" and creates an instance of the
 * AddAChorePage, passing the stage, household name, and email as parameters.
 * It then creates a Scene for the AddAChorePage and sets it as the active scene for the stage,
 * finally showing the updated stage.
 *
 * @see AddAChorePage
 * @param stage The Stage where the "Add A Chore" page will be displayed.
 * @param householdName The household name of the user.
 * @param email The email address of the user.
 */
public class AccountManagement {
	private Database database;

	public AccountManagement() {
		this.database = Database.getInstance();
	}

	// create household account and add it into households arrayList
	public void createHouseholdAccount(String householdName, String creatorName, String email, String password) {
		Household household = new Household(householdName);

		User creator = new User(creatorName, email, password, true);
		household.addUser(creator);
		database.addHousehold(household);
		database.saveData();
	}

	// login
	public boolean userExist(String householdName, String email, String password) {
		boolean exist = false;
		for (Household household : database.getHouseholds()) {
			if (household.getName().equals(householdName)) {
				for (User teamMember : getCurrentHousehold(householdName).getUsers()) {
					if (teamMember.getEmail().equalsIgnoreCase(email)
							&& teamMember.getPassword().equalsIgnoreCase(password)) {
						exist = true;
						break;
					}
				}
			}
		}
		if (exist) {
			return true;
		} else {
			return false;// email or password is wrong or email does not exist
		}
	}

	// Choose a chore for a team member
	public void selectedChore(String householdName, String email, String ChoreName, String frequency, String startTime,
			boolean teamTask) {
		Chore chore = new Chore(ChoreName, frequency, startTime, teamTask);
		System.out.println(chore.toString());
		for (User teamMember : getCurrentHousehold(householdName).getUsers()) {
			if (teamMember.getEmail().equalsIgnoreCase(email)) {
				teamMember.addChore(chore); // add this chore into the chore list of this user
				chore.addTeamMember(teamMember); // add this user into the team member list of this chore
				getCurrentHousehold(householdName).addChore(chore);// add this chore into chores list of this household
				break;
			}
		}
		database.saveData();
	}

	// get current household
	public Household getCurrentHousehold(String householdName) {
		for (Household household : database.getHouseholds()) {
			if (household.getName().equalsIgnoreCase(householdName)) {
				return household;
			}
		}
		return null;
	}

	// get chore list of the specific user
	public ArrayList<Chore> getChoreListOfAUser(String householdName, String email) {
		for (User teamMember : getCurrentHousehold(householdName).getUsers()) {
			if (teamMember.getEmail().equalsIgnoreCase(email)) {
				return teamMember.getChoreList();
			}
		}
		return null;
	}

}
