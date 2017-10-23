package fragments;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerLogin {

    @FXML private TextField username_field = new TextField();
    @FXML private TextField password_field = new TextField();

    @FXML
    private void pressLogin() {
        String login = username_field.getText().toString() ;
        String pass = password_field.getText().toString();
        if (login.length() <= 3 && pass.length() <= 6) {
            throw new IllegalArgumentException("Short password");
        } else {
            if (validation(login, pass)) {
                onConnection();
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        }
    }

    @FXML
    private void pressRegistration() {
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("res/registration.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onConnection() {
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("res/home_page.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validation(String name, String pass) {
        boolean value = false;

        return value;
    }


}
