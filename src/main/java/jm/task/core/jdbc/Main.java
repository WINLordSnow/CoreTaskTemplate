package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
        new UserDaoHibernateImpl().saveUser("Yakov",  "Marushchak", (byte) 34);
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.dropUsersTable();

        //userService.createUsersTable();
//        new UserDaoHibernateImpl().saveUser("Yakov",  "Marushchak", (byte) 34);
//        new UserDaoHibernateImpl().dropUsersTable();
////        new UserDaoJDBCImpl().dropUsersTable();
////        new UserDaoHibernateImpl().saveUser("Yakov",  "Marushchak", (byte) 34);
////        new UserDaoHibernateImpl().removeUserById(5);
////        System.out.println(new UserDaoHibernateImpl().getAllUsers());
////       // new UserDaoHibernateImpl().cleanUsersTable();
////        System.out.println(new UserDaoHibernateImpl().getAllUsers());
//
//        Util.getSessionFactory().close();

//        userService.saveUser("Yakov",  "Marushchak", (byte) 34);
//        userService.saveUser("Ivan",   "Petrov",     (byte) 21);
//        userService.saveUser("Marina", "Marushchak", (byte) 29);
//        userService.saveUser("Gleb",   "Ivanov",     (byte) 50);
//        System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
