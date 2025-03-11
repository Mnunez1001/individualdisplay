package edu.guilford;

import java.io.File;

//import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

// IndividualPane is a container for the UI elements
// GridPane is a layout manayer that uses a grid (rows and columns) to arrange its children
public class IndividualPane extends GridPane {
    // 1: Declare the TextField.
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField emailField;
    private Button submitButton;
    private Label formattedNameLabel;
    // add labels for the fields
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label emailLabel;
    private Label avatarLabel;
    private TextField avatarField;
    private ImageView avatarView;

    // constructor
    public IndividualPane() {
        // 2:instantiate the fields
        firstNameField = new TextField();
        lastNameField = new TextField();
        emailField = new TextField();
        submitButton = new Button("Submit");
        formattedNameLabel = new Label();

        // instantiating the labels
        firstNameLabel = new Label("First Name");
        lastNameLabel = new Label("Last Name");
        emailLabel = new Label("Email");
        avatarLabel = new Label("Avatar file name");
        avatarField = new TextField();
        avatarView = new ImageView();
        // 2a. Decorate the fields
        firstNameLabel.setFont(Font.font("Times New Roman", 20));
        lastNameLabel.setFont(Font.font("Times New Roman", 20));
        emailLabel.setFont(Font.font("Times New Roman", 20));

        // 2a. decorate the avatar stuff
        avatarLabel.setFont(Font.font("Times New Roman", 20));
        avatarField.setFont(Font.font("Times New Roman", 20));

        // 2a. Decorate the interactive elements
        firstNameField.setFont(Font.font("Times New Roman", 20));
        lastNameField.setFont(Font.font("Times New Roman", 20));
        emailField.setFont(Font.font("Times New Roman", 20));

        // 3: add the fields to the gridpane, which requires a row, column, and column
        // span
        // 3a. Add the labels to the gridpane
        this.add(firstNameLabel, 0, 0);
        this.add(lastNameLabel, 0, 1);
        this.add(emailLabel, 0, 2);
        this.add(avatarLabel, 0, 3);
        this.add(firstNameField, 1, 0);
        this.add(lastNameField, 1, 1);
        this.add(emailField, 1, 2);
        this.add(avatarField, 1, 3);
        this.add(submitButton, 2, 0, 2, 1);
        this.add(formattedNameLabel, 2, 1, 2, 1);

        // 4-5 set the event handler for the button
        submitButton.setOnAction(e -> {
            // everything between the {} is essentially the event handler
            // e is the event object
            System.out.println("the Button event is " + e);
            // get the text from the fields
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();

            // create an individual object
            Individual individual = new Individual(firstName, lastName, email, null);
            // set the text of the label to the formatted name
            formattedNameLabel.setText(individual.toString());

            // set the image avater
            String avatarFileName = avatarField.getText();
            File avatarFile = new File(this.getClass().getResource(avatarFileName).getFile());
            avatarView.setImage(new Image(avatarFile.toURI().toString()));
            avatarView.setFitWidth(150);
            avatarView.setFitHeight(150);
            //avatarView.setPreserveRatio(true);
            this.add(avatarView, 0, 4, 3, 1);
        });

        // 5: set the event handler for the button
        // :: is the method reference operator: tell setOnAction to call the handle
        // method

        // submitButton.setOnAction(this::handle);

    }

    // create the event handler
    // this is the event handler for the button
    // public void handle(ActionEvent e) {
    // // get the text from the fields
    // String firstName = firstNameField.getText();
    // String lastName = lastNameField.getText();
    // String email = emailField.getText();

    // // create an individual object
    // Individual individual = new Individual(firstName, lastName, email, null);
    // // set the text of the label to the formatted name
    // formattedNameLabel.setText(individual.toString());
    // }
}
