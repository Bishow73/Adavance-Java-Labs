package Javafx;
import java.io.File;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import java.io.File;

public class Uid extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX UI Example");

        // Create a GridPane to hold all UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Label and TextField
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        // Label and PasswordField
        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();
        gridPane.add(passLabel, 0, 1);
        gridPane.add(passField, 1, 1);

        // Button
        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            String username = nameField.getText();
            String password = passField.getText();
            if (username.equals("admin") && password.equals("admin123")) {
                showAlert("Login Successful", "Welcome, Admin!", AlertType.INFORMATION);
            } else {
                showAlert("Login Failed", "Invalid username or password.", AlertType.ERROR);
            }
        });
        gridPane.add(loginButton, 1, 2);

        // RadioButton
        ToggleGroup userType = new ToggleGroup();
        RadioButton adminRadioButton = new RadioButton("Admin");
        RadioButton userRadioButton = new RadioButton("User");
        adminRadioButton.setToggleGroup(userType);
        userRadioButton.setToggleGroup(userType);
        HBox radioBox = new HBox(10);
        radioBox.getChildren().addAll(adminRadioButton, userRadioButton);
        gridPane.add(new Label("User Type:"), 0, 2);
        gridPane.add(radioBox, 1, 3);

        // CheckBox
        CheckBox rememberCheckBox = new CheckBox("Remember Me");
        gridPane.add(rememberCheckBox, 0, 3);
     // Hyperlink
        Hyperlink hyperlink = new Hyperlink("Visit Bishow Website");
        hyperlink.setOnAction(event -> {
        System.out.println("Opening the website...");
        // You can add code to open a website here
        });
        gridPane.add(hyperlink, 0, 4);
        // Menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openMenuItem = new MenuItem("Open");
        FileChooser fileChooser = new FileChooser();
        openMenuItem.setOnAction(event -> {
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
        });
        fileMenu.getItems().add(openMenuItem);
        menuBar.getMenus().add(fileMenu);
        gridPane.add(menuBar, 0, 5);
        
     // Tooltip
        Tooltip tooltip = new Tooltip("Click me!");
        loginButton.setTooltip(tooltip);

        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}