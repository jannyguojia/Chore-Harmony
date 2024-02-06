package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CreateAccountPage extends StackPane {
	AccountManagement accountManagement = new AccountManagement();
	Stage stage;

	StackPane rootStackPane = new StackPane();

	// homepage
	BorderPane homePageBorderPane = new BorderPane();
	VBox buttonHomepage = new VBox();
	Button createHousehold = new Button("CREATE A NEW HOUSDHOLD");
	Button existHousehold = new Button("MY HOUSEHOLD HAS AN ACCOUNT");
	Image logoImage = new Image(
			"http://m.qpic.cn/psc?/V50JOf300WYtjc35pq2o0AqNeU05sXJM/ruAMsa53pVQWN7FLK88i5v4vSwIOoAwA4yYQrOH5WtnKPmtsqRwdGjNxMwCBv9mqkwnAYPDuevHL2ZQDnYZsD5dtb0szvyHvPw80BBFGxYo!/b&bo=LAFWAQAAAAABB1o!&rf=viewer_4");
	ImageView logo = new ImageView(logoImage);

	// create account page
	Label titleLabel = new Label("Create a Household");
	GridPane createAccountGridPane = new GridPane();
	Label householdLabel = new Label("Step 1: Name your household.");
	TextField householdNameField = new TextField();
	Label creatorLabel = new Label("Step 2: Register an administrator.");
	TextField nameField = new TextField();
	TextField emailField = new TextField();
	PasswordField passwordField = new PasswordField();
	PasswordField confirmPasswordField = new PasswordField();
	Button registerButton = new Button("Create");

	// response page of registerButton
	StackPane responseStackPane = new StackPane();
	Label outputLabel = new Label("");
	Button ok = new Button("OK");
	Button login = new Button("Log In");

	public CreateAccountPage(Stage stage) {
		this.stage = stage;

		// set homepage(borderPane)
		createAccountGridPane.setVisible(false);
		createAccountGridPane.setDisable(true);
		responseStackPane.setVisible(false);
		responseStackPane.setDisable(true);

		this.buttonHomepage.setSpacing(6);
		BorderPane.setMargin(buttonHomepage, new javafx.geometry.Insets(0, 0, 20, 0));

		this.createHousehold.setPrefSize(400, 35);
		this.createHousehold.setStyle("-fx-font-weight: bold;");
		this.createHousehold.setFont(new Font(15));
		this.createHousehold.getStyleClass().add("button");
		this.createHousehold.setTextFill(Color.web("#ffffff"));

		this.existHousehold.setPrefSize(400, 35);
		this.existHousehold.setStyle("-fx-font-weight: bold;");
		this.existHousehold.setFont(new Font(15));
		this.existHousehold.getStyleClass().add("button");
		this.existHousehold.setTextFill(Color.web("#ffffff"));

		this.buttonHomepage.getChildren().addAll(createHousehold, existHousehold);
		this.homePageBorderPane.setBottom(buttonHomepage);

		this.homePageBorderPane.setCenter(logo);
		this.homePageBorderPane.setStyle("-fx-background-color: #ffffff");

		createHousehold.setOnAction(e -> {
			homePageBorderPane.setVisible(false);
			homePageBorderPane.setDisable(true);
			createAccountGridPane.setVisible(true);
			createAccountGridPane.setDisable(false);
		});

		// set response page (stackPane)
		this.responseStackPane.setMaxWidth(220);
		this.responseStackPane.setMaxHeight(150);
		this.responseStackPane.setStyle("-fx-background-color: lightblue;");
		this.responseStackPane.setMargin(outputLabel, new javafx.geometry.Insets(8, 15, 60, 15));
		this.outputLabel.setWrapText(true);
		this.outputLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
		this.outputLabel.setContentDisplay(ContentDisplay.CENTER);

		this.ok.setPrefSize(40, 25);
		this.ok.setStyle("-fx-font-weight: bold;");
		this.ok.setFont(new Font(12));
		this.ok.getStyleClass().add("button");
		this.ok.setTextFill(Color.web("#ffffff"));
		this.ok.setTranslateX(0);
		this.ok.setTranslateY(30);

		this.login.setPrefSize(60, 25);
		this.login.setStyle("-fx-font-weight: bold;");
		this.login.setFont(new Font(12));
		this.login.getStyleClass().add("button");
		this.login.setTextFill(Color.web("#ffffff"));
		this.login.setTranslateX(0);
		this.login.setTranslateY(30);
		login.setVisible(false);
		login.setDisable(true);

		this.responseStackPane.getChildren().addAll(outputLabel, ok, login);

		// set gridPane
		this.createAccountGridPane.setStyle("-fx-background-color: #FAC8CD");
		this.createAccountGridPane.setPadding(new Insets(35, 30, 20, 30));
		ColumnConstraints col1 = new ColumnConstraints(350);
		this.createAccountGridPane.getColumnConstraints().add(col1);
		this.createAccountGridPane.setVgap(15);
//		this.grid.setHgap(10);
		this.titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.titleLabel.setMaxWidth(400);
		this.titleLabel.setAlignment(Pos.CENTER);
		this.householdLabel.setPrefWidth(350);
//		this.householdLabel.setPrefHeight(30);
		this.householdLabel.setFont(new Font(15));
		this.creatorLabel.setPrefWidth(350);
		this.creatorLabel.setFont(new Font(15));

		this.registerButton.setPrefSize(350, 35);
		this.registerButton.setStyle("-fx-font-weight: bold;");
		this.registerButton.setFont(new Font(20));
		this.registerButton.getStyleClass().add("button");
		this.registerButton.setTextFill(Color.web("#ffffff"));

		this.householdNameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		householdNameField.setPromptText("Household name (maximum 10 characters)");
		householdNameField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 10) {
				householdNameField.setText(oldValue);
			}
		});

		this.nameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		nameField.setPromptText("Your name (maximum 10 characters)");
		nameField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 10) {
				nameField.setText(oldValue);
			}
		});

		this.emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		emailField.setPromptText("Your email (example@example.com)");
		emailField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!Util.isValidEmailFormat(newValue)) {
				emailField.setStyle("-fx-text-box-border: red ; -fx-focus-color: red ;");
			} else {
				emailField.setStyle(""); // Restore default style
			}
		});

		this.passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		passwordField.setPromptText("Set a password");

		this.confirmPasswordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		confirmPasswordField.setPromptText("Confirm the password");

		this.createAccountGridPane.add(titleLabel, 0, 0);
		this.createAccountGridPane.add(householdLabel, 0, 3);
		this.createAccountGridPane.add(householdNameField, 0, 4);
		this.createAccountGridPane.add(creatorLabel, 0, 6);
		this.createAccountGridPane.add(nameField, 0, 7);
		this.createAccountGridPane.add(emailField, 0, 8);
		this.createAccountGridPane.add(passwordField, 0, 9);
		this.createAccountGridPane.add(confirmPasswordField, 0, 10);
		this.createAccountGridPane.add(registerButton, 0, 12);

		this.registerButton.setOnAction(e -> {
			String householdname = householdNameField.getText();
			String name = nameField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();
			String confirmPassword = confirmPasswordField.getText();

			responseStackPane.setVisible(true);
			responseStackPane.setDisable(false);

			String message = Util.createAccountValidateData(householdname, name, email, password, confirmPassword);

			if (message.equals("Create successful!")) {
				setTextFieldUneditable();
				outputLabel.setText(message);
				ok.setVisible(false);
				ok.setDisable(true);
				login.setVisible(true);
				login.setDisable(false);
				accountManagement.createHouseholdAccount(householdname, name, email, confirmPassword);
			} else {
				outputLabel.setText(message);
				setTextFieldUneditable();
			}

		});

		this.existHousehold.setOnAction(e -> {
			openLoginPage();
		});

		ok.setOnAction(e -> {
			responseStackPane.setVisible(false);
			responseStackPane.setDisable(true);
			setTextFieldEditable();
		});

		login.setOnAction(e -> {
			openLoginPage();
		});

		this.getChildren().addAll(homePageBorderPane, createAccountGridPane, responseStackPane);

	}

	private void setTextFieldUneditable() {
		householdNameField.setEditable(false);
		nameField.setEditable(false);
		emailField.setEditable(false);
		passwordField.setEditable(false);
		confirmPasswordField.setEditable(false);
	}

	private void setTextFieldEditable() {
		householdNameField.setEditable(true);
		nameField.setEditable(true);
		emailField.setEditable(true);
		passwordField.setEditable(true);
		confirmPasswordField.setEditable(true);
	}

	private void openLoginPage() {
		stage.setTitle("Login page");
		LoginPage lgoinPage = new LoginPage(stage);

		Scene scene = new Scene(lgoinPage, 400, 700);
		stage.setScene(scene);
		stage.show();
	}
}
