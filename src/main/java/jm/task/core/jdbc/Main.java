package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {
//        new UserDaoJDBCImpl().createUsersTable();
//        new UserDaoJDBCImpl().saveUser("Marina", "Marushchak", (byte) 34);
//        new UserDaoJDBCImpl().saveUser("Yakov", "Marushchak", (byte) 29);
//        new UserDaoJDBCImpl().saveUser("Arina", "Marushchak", (byte) 4);
//        new UserDaoJDBCImpl().saveUser("Alex", "Marushchak", (byte) 6);
        System.out.println(new UserDaoJDBCImpl().getAllUsers());
//        new UserDaoJDBCImpl().removeUserById(5L);
//        new UserDaoJDBCImpl().dropUsersTable();
//        new UserDaoJDBCImpl().cleanUsersTable();
    }
}
