package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;


public class Login {
    boolean userExists;
    @FXML
    TextField usernameText, passwordText;
    @FXML
    RadioButton radioButton;

    public void login(ActionEvent event) {
        try {
            // set the boolean value of userExists corresponding to the entered values
            userExists = UserData.isFound(usernameText, passwordText, radioButton);

            // radio button for roles
            RadioButton Role = (RadioButton) radioButton.getToggleGroup().getSelectedToggle();

            // Authenticate Instructor
            if (userExists && Objects.equals(Role.getText(), "Instructor")) {
                alertBox.display("Alert", "Login Successful! Welcome Instructor!");
                Instructor instructor = new Instructor();
                instructor.Instructor(event);
            }
            // Authenticate Student
            else if (userExists && Objects.equals(Role.getText(), "Student")) {
                alertBox.display("Alert", "Login Successful! Welcome Student!");
                student student = new student();
                student.Student(event);
            }
            // Authentication Failed
            else alertBox.display("Alert", "Login Failed due to wrong credentials provided.");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}