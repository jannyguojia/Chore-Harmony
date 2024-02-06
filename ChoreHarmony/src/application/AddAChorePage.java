package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AddAChorePage extends StackPane {
	Stage stage;
	String email;
	String householdName;

	AccountManagement accountManagement = new AccountManagement();

	StackPane rootStackPane = new StackPane();
	BorderPane addChoreBorderPane = new BorderPane();
	GridPane addChore = new GridPane();

	ObservableList<String> choreOptions = FXCollections.observableArrayList("Mow lawn", "Wash dishes", "Feed cats",
			"Laundry");
	final ComboBox choreBox = new ComboBox(choreOptions);

	ObservableList<String> frequencyOptions = FXCollections.observableArrayList("Daily", "Weekly", "Monthly",
			"Quarterly", "Yearly");
	final ComboBox frequencyBox = new ComboBox(frequencyOptions);

	ObservableList<String> timeOptions = FXCollections.observableArrayList("06:00", "06:30", "07:00", "07:30", "08:00");
	final ComboBox timeBox = new ComboBox(timeOptions);

	CheckBox isTeamTaskCheckBox = new CheckBox("Yes");
	CheckBox notTeamTaskCheckBox = new CheckBox("No");
	HBox checkBox = new HBox(isTeamTaskCheckBox, notTeamTaskCheckBox);

	ObservableList<String> TeamMemberOptions = FXCollections.observableArrayList("Sophie", "Jia", "Richard", "Jay",
			"Emma");
	final ComboBox teamBox = new ComboBox(TeamMemberOptions);

	Label heading = new Label("Choose A Chore");
	Label chooseChoreHint = new Label("Chores: ");
	Label frequencyHint = new Label("Frequency: ");
	Label timingHint = new Label("Start time: ");
	Label taskTypeHint = new Label("Team work:");
	Label teamHint = new Label("Team members: ");

	Button addButton = new Button("Add");

	// response page of addChoreButton
	StackPane responseStackPane = new StackPane();
	Label outputLabel = new Label("");
	Button ok = new Button("OK");

	public AddAChorePage(Stage stage, String householdName, String email) {
		this.stage = stage;
		this.householdName = householdName;
		this.email = email;

		teamHint.setDisable(true);
		teamBox.setDisable(true);

		responseStackPane.setVisible(false);
		responseStackPane.setDisable(true);

		this.setStyle("-fx-background-color: #FAC8CD");

		this.heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.heading.setMaxWidth(400);
		this.heading.setAlignment(Pos.CENTER);
		BorderPane.setMargin(heading, new javafx.geometry.Insets(40, 0, 0, 0));
		addChoreBorderPane.setTop(heading);

		this.addChore.setPadding(new Insets(15, 50, 20, 50));
		this.addChore.setVgap(20);
		this.addChore.setHgap(25);

		this.chooseChoreHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.frequencyHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.timingHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.taskTypeHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.teamHint.setStyle("-fx-font-weight: bold;-fx-font-size: 15px");
		this.choreBox.setPrefWidth(155);
		this.frequencyBox.setPrefWidth(155);
		this.timeBox.setPrefWidth(155);
		this.checkBox.setSpacing(35);
		this.teamBox.setPrefWidth(155);

		this.addChore.add(chooseChoreHint, 0, 3);
		this.addChore.add(choreBox, 1, 3);
		this.addChore.add(frequencyHint, 0, 4);
		this.addChore.add(frequencyBox, 1, 4);
		this.addChore.add(timingHint, 0, 5);
		this.addChore.add(timeBox, 1, 5);
		this.addChore.add(taskTypeHint, 0, 6);
		this.addChore.add(checkBox, 1, 6);
		this.addChore.add(teamHint, 0, 7);
		this.addChore.add(teamBox, 1, 7);

		addChoreBorderPane.setCenter(addChore);

		this.addButton.setPrefSize(300, 35);
		this.addButton.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.addButton.setFont(new Font(15));
		BorderPane.setMargin(addButton, new javafx.geometry.Insets(0, 0, 310, 50));
		addChoreBorderPane.setBottom(addButton);

		// set response page (stackPane)
		this.responseStackPane.setMaxWidth(220);
		this.responseStackPane.setMaxHeight(150);
		this.responseStackPane.setStyle("-fx-background-color: lightblue;");
		this.responseStackPane.setMargin(outputLabel, new javafx.geometry.Insets(8, 15, 60, 15));
		this.outputLabel.setWrapText(true);
		this.outputLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
		this.outputLabel.setContentDisplay(ContentDisplay.CENTER);

		this.ok.setPrefSize(40, 25);
		this.ok.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.ok.setFont(new Font(15));
		this.ok.setTranslateX(0);
		this.ok.setTranslateY(30);

		this.responseStackPane.getChildren().addAll(outputLabel, ok);

		isTeamTaskCheckBox.setOnAction(event -> {
			if (isTeamTaskCheckBox.isSelected()) {
				teamHint.setDisable(false);
				teamBox.setDisable(false);
				notTeamTaskCheckBox.setSelected(false);
			} else {
				teamHint.setDisable(true);
				teamBox.setDisable(true);
			}
		});

		notTeamTaskCheckBox.setOnAction(event -> {
			if (notTeamTaskCheckBox.isSelected()) {
				teamHint.setDisable(true);
				teamBox.setDisable(true);
				isTeamTaskCheckBox.setSelected(false);
			}
		});

		this.addButton.setOnAction(e -> {
			String choreName = (String) choreBox.getValue();
			String frequency = (String) frequencyBox.getValue();
			String startTime = (String) timeBox.getValue();
			String teamMember = (String) teamBox.getValue();
			boolean isTeamTask = isTeamTaskCheckBox.isSelected();
			boolean notTeamTask = notTeamTaskCheckBox.isSelected();
			boolean teamTask = false;
			if (isTeamTask) {
				teamTask = true;
			}

			String errorMessage = Util.addAChoreValidateData(choreName, frequency, startTime, isTeamTask, notTeamTask,
					teamMember);

			if (errorMessage.equals("Please select all items!")) {
				// System.out.println("Please select all items.");
				outputLabel.setText("Please select all items!");
				responseStackPane.setVisible(true);
				responseStackPane.setDisable(false);

			} else if (errorMessage.equals("")) {
				accountManagement.selectedChore(householdName, email, choreName, frequency, startTime, teamTask);
				openShowChoreListPage();
			}
		});

		ok.setOnAction(e -> {
			responseStackPane.setVisible(false);
			responseStackPane.setDisable(true);

		});

		this.getChildren().addAll(addChoreBorderPane, responseStackPane);
	}

	private void openShowChoreListPage() {
		stage.setTitle("Chore List");
		ShowChoreListPage choreListPage = new ShowChoreListPage(stage, householdName, email);
		Scene scene = new Scene(choreListPage, 400, 700);
		stage.setScene(scene);
		stage.show();
	}
}
