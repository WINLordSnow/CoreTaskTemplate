package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        final String sqlCreateTable = "CREATE TABLE IF NOT EXISTS USERS" +
                "(" +
                "    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "    name VARCHAR(20)," +
                "    last_name VARCHAR(20)," +
                "    age TINYINT" +
                ");";
        try (Connection connection = new Util().getMyConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCreateTable);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        final String sqlCreateTable = "DROP TABLE IF EXISTS USERS;";
        try (Connection connection = new Util().getMyConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCreateTable);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String sqlInsertUser = String.format("INSERT into USERS (name, last_name, age) values ('%s', '%s', %d)",
                name, lastName, age);
        try (Connection connection = new Util().getMyConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlInsertUser);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        final String sqlRemoveUser = String.format("DELETE FROM USERS WHERE id = %d", id);
        try (Connection connection = new Util().getMyConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlRemoveUser);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        final String sqlGetAllUsers = String.format("SELECT * FROM Users");
        List<User> list = new ArrayList<>();
        User user;
        try (Connection connection = new Util().getMyConnection()) {
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        final String sqlRemoveAllUsers = String.format("DELETE FROM USERS");
        try (Connection connection = new Util().getMyConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlRemoveAllUsers);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
