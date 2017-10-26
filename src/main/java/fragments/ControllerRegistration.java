package fragments;

import JDBS.UserDAO;
import javafx.fxml.FXML;
import users.User;

import java.awt.*;

public class ControllerRegistration {

    @FXML
    private TextField name, date, userName, password, country, phone, email;

    @FXML
    private void pressRegestration() {
        UserDAO userDAO = new UserDAO();

        name = new TextField();
        date = new TextField();
        userName = new TextField();
        password = new TextField();
        country = new TextField();
        phone = new TextField();
        email = new TextField();

        User user = new User();
        user.setName(name.getText().toString());
//        int age = Integer.parseInt(date.getText().toString()) ;
        user.setDate(23);
        user.setUserName(userName.getText().toString());
        user.setPassword(password.getText().toString());
        user.setCountry(country.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setEmail(email.getText().toString());

        userDAO.addUser(user);
    }



}
