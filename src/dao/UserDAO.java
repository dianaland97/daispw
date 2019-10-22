package dao;

import entity.RegisteredUser;
import entity.User;

import java.sql.*;

public class UserDAO {
    public User verifyUser (String nickname, String password) {

        try {
            PreparedStatement preparedStatement = DBhelper.getDBInstance().getConnection().prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //Connection connection = DBhelper.getDBInstance().getConnection();
            //PreparedStatement preparedStatement = null;
            //preparedStatement = connection.prepareStatement(Query.checkForUsername, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) //rs empty
                return null;
            else {
                resultSet.first();
                String name = resultSet.getString("nickname");
                String pass = resultSet.getString("password");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                if (role.equals("landlord") && nickname.equals(name) && pass.equals(password)) {
                    User user = new RegisteredUser(name, pass, email, role, null);
                    return user;
                } else return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
