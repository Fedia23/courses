package fragments;

import JDBS.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import users.User;

import java.util.List;
import java.util.regex.Pattern;

public class ControllerRegistration {

    private UserDAO userDAO = new UserDAO();
    private User user = new User();
    private List<User> allUsersList;

    public ControllerRegistration() {
    }

    @FXML
    private TextField name, user_name, date, password, repeat_password, country, phone, email;

    @FXML
    private Label passLabel, emailLabel, userNameLabel;

    @FXML
    private Button btn_regestration;

    @FXML
    private void initialize(){
        btn_regestration.setDisable(true);
    }

    @FXML
    private void pressRegestration() {
        UserDAO userDAO = new UserDAO();

        if (phone.getText().toString().length() < 1) {
            user.setPhone("1");
        }
        user.setPhone(phone.getText().toString());

        userDAO.addUser(user);
    }
  /*
  pattern
  */
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})");

    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");

    private static final Pattern NAME_PATTERN = Pattern.compile("[A-Za-z0_]+");

    private static final Pattern USER_NAME_PATTERN = Pattern.compile("[A-Za-z0_9]+");

    private static final Pattern COUNTRY_PATTERN = Pattern.compile("[A-Za-z0_]+");

    /*
    is valid field
    * */
    private boolean isNameValid(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    private boolean isUserNameValid(String userName) {
        return USER_NAME_PATTERN.matcher(userName).matches();
    }

    private boolean isPasswordValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    private boolean isEmailValid(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    private boolean isCountryValid(String country) { return COUNTRY_PATTERN.matcher(country).matches(); }

    private boolean isDateValid(String date) { try { Integer.parseInt(date); return true; } catch (NumberFormatException e) { return false; } }

    private boolean isPhoneValid(String number) { return number.length() > 0; }

    @FXML
    private void nameTF() {
        if (isNameValid(name.getText().toString())) {
            name.setBlendMode(BlendMode.MULTIPLY);
            name.setStyle("-fx-fill: black");
            user.setName(name.getText().toString());
        } else {
            name.setBlendMode(BlendMode.GREEN);
            name.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void userNameTF() {
        userNameLabel.setText("");
        if (isUserNameValid(user_name.getText().toString())) {
            if (dublicateUserName(user_name.getText().toString())) {
                user_name.setBlendMode(BlendMode.GREEN);
                user_name.setStyle("-fx-fill: red");
            } else {
                user_name.setBlendMode(BlendMode.MULTIPLY);
                user_name.setStyle("-fx-fill: black");
                user.setUserName(user_name.getText().toString());
            }
        } else {
            user_name.setBlendMode(BlendMode.GREEN);
            user_name.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void passwordTF() {
        if (isPasswordValid(password.getText().toString())) {
            password.setBlendMode(BlendMode.MULTIPLY);
            password.setStyle("-fx-fill: black");
        } else {
            password.setBlendMode(BlendMode.GREEN);
            password.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void repPasswordTF() {
        passLabel.isVisible();
        if (password.getText().toString().equals(repeat_password.getText().toString())) {
                password.setBlendMode(BlendMode.MULTIPLY);
                password.setStyle("-fx-fill: black");

                repeat_password.setBlendMode(BlendMode.MULTIPLY);
                repeat_password.setStyle("-fx-fill: black");

            if (password.getText().length() > 5) {
                    passLabel.setText("passwords match");
                    passLabel.setStyle("-fx-background-color: white");
                    user.setPassword(password.getText().toString());
            } else {
                    passLabel.setText("");
                    password.setBlendMode(BlendMode.GREEN);
                    password.setStyle("-fx-fill: red");
                    repeat_password.setBlendMode(BlendMode.GREEN);
                    repeat_password.setStyle("-fx-fill: red");
            }
        } else {
            password.setBlendMode(BlendMode.GREEN);
            password.setStyle("-fx-fill: red");

            repeat_password.setBlendMode(BlendMode.GREEN);
            repeat_password.setStyle("-fx-fill: red");
            passLabel.setStyle("-fx-background-color: red");
            passLabel.setText("You entered two different passwords. Please try again.");
        }
    }

    @FXML
    private void emailTF() {
        emailLabel.setText("");
        if (isEmailValid(email.getText().toString())) {
                if (dublicateEmail(email.getText().toString())) {
                    email.setBlendMode(BlendMode.GREEN);
                    email.setStyle("-fx-fill: red");
                } else {
                    email.setBlendMode(BlendMode.MULTIPLY);
                    email.setStyle("-fx-fill: black");
                    user.setEmail(email.getText().toString());
                }

        } else {
            email.setBlendMode(BlendMode.GREEN);
            email.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void dateTF() {
        if(isDateValid(date.getText().toString())) {
            date.setBlendMode(BlendMode.MULTIPLY);
            date.setStyle("-fx-fill: black");
            user.setDate(Integer.parseInt(date.getText().toString()));
        } else {
            date.setBlendMode(BlendMode.GREEN);
            date.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void countryTF() {
        if (isCountryValid(country.getText().toString())) {
            country.setBlendMode(BlendMode.MULTIPLY);
            country.setStyle("-fx-fill: black");
            user.setCountry(country.getText().toString());
            if (       user.getName()     == null
                    && user.getUserName() == null
                    && user.getPassword() == null
                    && user.getEmail()    == null) {
            } else {
                btn_regestration.setDisable(false);
            }
        } else {
            country.setBlendMode(BlendMode.GREEN);
            country.setStyle("-fx-fill: red");
        }
    }

    @FXML
    private void phoneTF() {
        if(isPhoneValid(phone.getText().toString())) {
            phone.setBlendMode(BlendMode.MULTIPLY);
            phone.setStyle("-fx-fill: black");
            user.setPhone(phone.getText().toString());
        } else {
            date.setBlendMode(BlendMode.GREEN);
            date.setStyle("-fx-fill: red");
        }
    }

    private boolean dublicateEmail(String email) {
        allUsersList = userDAO.getAll();
        boolean value = false;

        if (allUsersList.size() > 0) {
            for (User cn : allUsersList) {
                if (email.equals(cn.getEmail())) {
                    value = true;
                    emailLabel.setText("Such email already in use");
                } else {
                    value = false;
                }
            }
        } else {
            value = false;
        }
        return value;
    }

    private boolean dublicateUserName(String userName) {
        allUsersList = userDAO.getAll();
        boolean value = false;

        if (allUsersList.size() > 0) {
            for (User cn : allUsersList) {
                if (userName.equals(cn.getUserName())) {
                    value = true;
                    userNameLabel.setText("Such user name already in use");
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
