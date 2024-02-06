package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * The LoginPage class represents a graphical user interface for logging into a user account.
 * It extends StackPane to organize UI elements. This class provides input fields for entering
 * user information such as household name, email, and password. Users can also click a "Log In"
 * button to attempt login and see potential error messages in the case of failed login attempts.
 *
 * @author Richard
 * @version 1.0
 */
public class LoginPage extends StackPane {
	Stage stage;
	String email;
	String householdName;
	AccountManagement accountManagement = new AccountManagement();

	StackPane loginLayout = new StackPane();
	GridPane loginGrid = new GridPane();

	Label heading = new Label("Login to Your Account");
	TextField householdNameField = new TextField();
	TextField emailField = new TextField();
	PasswordField passwordField = new PasswordField();
	Button loginButton = new Button("Log In");

	// error page of login
	StackPane errorPane = new StackPane();
	Label errorLabel = new Label("");
	Button ok = new Button("OK");

	public LoginPage(Stage stage) {
		this.stage = stage;
		this.errorPane.getChildren().addAll(errorLabel, ok);
		this.getChildren().addAll(loginGrid, errorPane);
		errorPane.setVisible(false);
		errorPane.setDisable(true);

		this.setStyle("-fx-background-color: #FAC8CD");

		this.loginGrid.setPadding(new Insets(35, 30, 20, 30));
		ColumnConstraints col1 = new ColumnConstraints(350);
		this.loginGrid.getColumnConstraints().add(col1);
		this.loginGrid.setVgap(15);

//		this.heading.getStyleClass().add("heading");
		this.heading.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		this.heading.setMaxWidth(400);
		this.heading.setAlignment(Pos.CENTER);

		this.loginButton.setPrefSize(350, 35);
		this.loginButton.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.loginButton.setFont(new Font(15));
//		this.loginButton.getStyleClass().add("button");
//		this.loginButton.setTextFill(Color.web("#ffffff"));

		this.householdNameField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		householdNameField.setPromptText("Household name");

		this.emailField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		emailField.setPromptText("Your email");

		this.passwordField.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");
		passwordField.setPromptText("Your password");

		this.loginGrid.add(heading, 0, 0);
		this.loginGrid.add(householdNameField, 0, 3);
		this.loginGrid.add(emailField, 0, 4);
		this.loginGrid.add(passwordField, 0, 5);
		this.loginGrid.add(loginButton, 0, 7);

		// set error page (stackPane)
		this.errorPane.setMaxWidth(220);
		this.errorPane.setMaxHeight(150);
		this.errorPane.setStyle("-fx-background-color: lightblue;");
		this.errorPane.setMargin(errorLabel, new javafx.geometry.Insets(8, 15, 60, 15));
		this.errorLabel.setWrapText(true);
		this.errorLabel.setStyle("-fx-font-size: 15px; -fx-font-weight: bold;");
		this.errorLabel.setContentDisplay(ContentDisplay.CENTER);

		this.ok.setPrefSize(40, 25);
		this.ok.setStyle("-fx-font-weight: bold;-fx-text-fill: #ffffff; -fx-background-color: #6E51E4;");
		this.ok.setFont(new Font(15));
		this.ok.setTranslateX(0);
		this.ok.setTranslateY(30);

		/**
		 * This method sets an event handler for the login button. When the login button is clicked, it
		 * retrieves the user-entered household name, email, and password from the input fields. It then
		 * performs validation of the entered data using the Util.loginValidateData method and checks
		 * if the user exists in the system using the AccountManagement class.
		 *
		 * If the entered data is valid and the user exists, it opens the "AddAChorePage."
		 * If the login attempt fails, it displays an error message and clears the input fields.
		 *
		 * @param e The ActionEvent representing the button click event.
		 */
		this.loginButton.setOnAction(e -> {
			householdName = householdNameField.getText();
			email = emailField.getText();
			String password = passwordField.getText();
			// Database db = Database.getInstance();

			String errorMessage = Util.loginValidateData(householdName, email, password);

			if (errorMessage.equals("") && accountManagement.userExist(householdName, email, password)) {
				openAddAChorePage();
			} else {
				errorPane.setVisible(true);
				errorPane.setDisable(false);
				errorLabel.setText("Login failed! Please check the household name, your email and password!");
				householdNameField.clear();
				emailField.clear();
				passwordField.clear();
				emailField.setPromptText("Your email");
				passwordField.setPromptText("Your password");
				householdNameField.setPromptText("Household name");
			}
		});

		/**
		 * This method sets an event handler for the "OK" button associated with the error message pane.
		 * When the "OK" button is clicked, it hides the error pane and disables it, effectively
		 * dismissing the error message displayed to the user.
		 *
		 * @param e The ActionEvent representing the button click event.
		 */
		ok.setOnAction(e -> {
			errorPane.setVisible(false);
			errorPane.setDisable(true);
		});
	}



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
	private void openAddAChorePage() {
		stage.setTitle("Add A Chore");
		AddAChorePage AddAChorePage = new AddAChorePage(stage, householdName, email);

		Scene scene = new Scene(AddAChorePage, 400, 700);
		stage.setScene(scene);
		stage.show();
	}


}
