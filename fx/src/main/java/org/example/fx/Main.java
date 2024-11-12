package org.example.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private ComboBox<String> courseComboBox;
    private ListView<String> courseListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Information");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Name
        Label nameLabel = new Label("Full Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        // Address
        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 1);
        TextField addressInput = new TextField();
        GridPane.setConstraints(addressInput, 1, 1);

        // City
        Label cityLabel = new Label("City:");
        GridPane.setConstraints(cityLabel, 0, 2);
        TextField cityInput = new TextField();
        GridPane.setConstraints(cityInput, 1, 2);

        // Province
        Label provinceLabel = new Label("Province:");
        GridPane.setConstraints(provinceLabel, 0, 3);
        TextField provinceInput = new TextField();
        GridPane.setConstraints(provinceInput, 1, 3);

        // Postal Code
        Label postalCodeLabel = new Label("Postal Code:");
        GridPane.setConstraints(postalCodeLabel, 0, 4);
        TextField postalCodeInput = new TextField();
        GridPane.setConstraints(postalCodeInput, 1, 4);

        // Phone Number
        Label phoneLabel = new Label("Phone Number:");
        GridPane.setConstraints(phoneLabel, 0, 5);
        TextField phoneInput = new TextField();
        GridPane.setConstraints(phoneInput, 1, 5);

        // Email
        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 6);
        TextField emailInput = new TextField();
        GridPane.setConstraints(emailInput, 1, 6);

        // Major
        Label majorLabel = new Label("Major:");
        GridPane.setConstraints(majorLabel, 0, 7);
        ToggleGroup majorGroup = new ToggleGroup();
        RadioButton csRadio = new RadioButton("Computer Science");
        csRadio.setToggleGroup(majorGroup);
        RadioButton businessRadio = new RadioButton("Business");
        businessRadio.setToggleGroup(majorGroup);
        HBox majorBox = new HBox(10, csRadio, businessRadio);
        GridPane.setConstraints(majorBox, 1, 7);

        // Course Selection
        Label courseLabel = new Label("Select Course:");
        GridPane.setConstraints(courseLabel, 0, 8);
        courseComboBox = new ComboBox<>();
        GridPane.setConstraints(courseComboBox, 1, 8);

        // Course List
        Label courseListLabel = new Label("Selected Courses:");
        GridPane.setConstraints(courseListLabel, 0, 9);
        courseListView = new ListView<>();
        GridPane.setConstraints(courseListView, 1, 9);

        // Additional Info
        Label infoLabel = new Label("Additional Information:");
        GridPane.setConstraints(infoLabel, 0, 10);
        CheckBox studentCouncilBox = new CheckBox("Student Council");
        CheckBox volunteerBox = new CheckBox("Volunteer Work");
        VBox infoBox = new VBox(10, studentCouncilBox, volunteerBox);
        GridPane.setConstraints(infoBox, 1, 10);

        // Display Area
        TextArea displayArea = new TextArea();
        displayArea.setPrefHeight(200);
        displayArea.setEditable(false);
        GridPane.setConstraints(displayArea, 0, 11, 2, 1);

        // Display Button
        Button displayButton = new Button("Display");
        GridPane.setConstraints(displayButton, 1, 12);
        displayButton.setOnAction(e -> {
            StringBuilder info = new StringBuilder();
            info.append("Full Name: ").append(nameInput.getText()).append("\n");
            info.append("Address: ").append(addressInput.getText()).append("\n");
            info.append("City: ").append(cityInput.getText()).append("\n");
            info.append("Province: ").append(provinceInput.getText()).append("\n");
            info.append("Postal Code: ").append(postalCodeInput.getText()).append("\n");
            info.append("Phone Number: ").append(phoneInput.getText()).append("\n");
            info.append("Email: ").append(emailInput.getText()).append("\n");
            info.append("Major: ").append(((RadioButton) majorGroup.getSelectedToggle()).getText()).append("\n");
            info.append("Courses: ").append(courseListView.getItems()).append("\n");
            info.append("Additional Info: ");
            if (studentCouncilBox.isSelected()) info.append("Student Council ");
            if (volunteerBox.isSelected()) info.append("Volunteer Work");
            displayArea.setText(info.toString());
        });

        // Populate course list based on major
        csRadio.setOnAction(e -> {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Java", "Python", "Data Structures");
        });

        businessRadio.setOnAction(e -> {
            courseComboBox.getItems().clear();
            courseComboBox.getItems().addAll("Business Management", "Accounting", "Marketing");
        });

        // Add selected course to list
        courseComboBox.setOnAction(e -> {
            String selectedCourse = courseComboBox.getSelectionModel().getSelectedItem();
            if (!courseListView.getItems().contains(selectedCourse)) {
                courseListView.getItems().add(selectedCourse);
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, addressLabel, addressInput, cityLabel, cityInput, provinceLabel, provinceInput, postalCodeLabel, postalCodeInput, phoneLabel, phoneInput, emailLabel, emailInput, majorLabel, majorBox, courseLabel, courseComboBox, courseListLabel, courseListView, infoLabel, infoBox, displayArea, displayButton);

        Scene scene = new Scene(grid, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

