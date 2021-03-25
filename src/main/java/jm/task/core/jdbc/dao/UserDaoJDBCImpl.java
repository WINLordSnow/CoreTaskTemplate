package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection;

    public UserDaoJDBCImpl() {
    }

    public UserDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    public void createUsersTable() {
        final String sqlCreateTable = "CREATE TABLE IF NOT EXISTS USERS" +
                "(" +
                "    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "    name VARCHAR(20)," +
                "    last_name VARCHAR(20)," +
                "    age TINYINT" +
                ");";
        sendQueryOnUpdate(sqlCreateTable);
    }

    public void dropUsersTable() {
        final String sqlCreateTable = "DROP TABLE IF EXISTS USERS;";
        sendQueryOnUpdate(sqlCreateTable);
    }

    public void saveUser(String name, String lastName, byte age) {
        final String sqlInsertUser = String.format("INSERT into USERS (name, last_name, age) values ('%s', '%s', %d)",
                name, lastName, age);
        sendQueryOnUpdate(sqlInsertUser);
    }

    public void removeUserById(long id) {
        final String sqlRemoveUser = String.format("DELETE FROM USERS WHERE id = %d", id);
        sendQueryOnUpdate(sqlRemoveUser);
    }

    public List<User> getAllUsers() {
        final String sqlGetAllUsers = "SELECT * FROM Users";
        List<User> list = new ArrayList<>();
        User user;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAllUsers);
            while (resultSet.next()) {
                user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")
                );
                user.setId(resultSet.getLong("id"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        final String sqlRemoveAllUsers = "DELETE FROM USERS";
        sendQueryOnUpdate(sqlRemoveAllUsers);
    }

    private void sendQueryOnUpdate(String sqlQuery) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
