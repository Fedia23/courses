package JDBS;

import users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static Connection connection = null;
    private static PreparedStatement preparedStatment = null;
    private static ResultSet resultSet = null;

    private final String ADD_USER = "insert into users(id, date, name, userName, password, country, phone, email) values(?,?,?,?,?,?,?,?)";
    private final String GET_LIST = "SELECT * FROM users";

    public void addUser(User user) {
        try {
            int count = user.getId();
            user.setId(count++);
            connection = JDBCPostgreSQLExampl.onConnectJDBS();
            preparedStatment = connection.prepareStatement(ADD_USER);

            preparedStatment.setInt(1, user.getId());
            preparedStatment.setInt(2, user.getDate());
            preparedStatment.setString(3, user.getName());
            preparedStatment.setString(4, user.getUserName());
            preparedStatment.setString(5, user.getPassword());
            preparedStatment.setString(6, user.getCountry());
            preparedStatment.setString(7, user.getPhone());
            preparedStatment.setString(8, user.getEmail());

            preparedStatment.executeUpdate();
            System.out.println("Good");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> listUser = new ArrayList<>();

        try {
            connection = JDBCPostgreSQLExampl.onConnectJDBS();
            preparedStatment = connection.prepareStatement(GET_LIST);
            resultSet = preparedStatment.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setDate(resultSet.getInt("date"));
                user.setName(resultSet.getString("name"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setCountry(resultSet.getString("country"));
                user.setPhone(resultSet.getString("phone"));
                user.setEmail(resultSet.getString("email"));

                listUser.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listUser;
    }

}
