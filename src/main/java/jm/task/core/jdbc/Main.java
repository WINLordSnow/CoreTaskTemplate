package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Yakov",  "Marushchak", (byte) 34);
        userService.saveUser("Ivan",   "Petrov",     (byte) 21);
        userService.saveUser("Marina", "Marushchak", (byte) 29);
        userService.saveUser("Gleb",   "Ivanov",     (byte) 50);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
