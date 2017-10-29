package fragments;

import JDBS.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.User;

import java.io.IOException;
import java.util.List;

public class ControllerLogin {

    @FXML private TextField username_field = new TextField();
    @FXML private TextField password_field = new TextField();
    private List<User> userList;
    private UserDAO userDAO = new UserDAO();
    private Stage primaryStage;


    private Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void pressLogin() {
        if (validation(username_field.getText().toString(), password_field.getText().toString())) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
                Scene scene = new Scene(root);
                Stage primaryStage = getPrimaryStage();
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("FFFF");
        }
    }

    @FXML
    private void pressRegistration() {
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/registration.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = getPrimaryStage();
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onConnection() {

    }

    private boolean validation(String name, String pass) {
        boolean value = false;
        userList = userDAO.getAll();

            if (userList.size() > 0) {
            for (User cn : userList) {
                    if (name.equals(cn.getUserName())) {
                        value = true;
                    } else {
                        value = false;
                    }
                }
            } else {
                value = false;
            }

        return value;
    }


}
