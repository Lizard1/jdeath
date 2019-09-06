package service.impl;

import repository.RepositoryConnector;
import model.User;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс-сервис отвечающий за работу с БД, относительно класса User.
 * @autor Сергей Зверев
 * @version 1.1
 */

public class UserImpl implements UserService {
    private RepositoryConnector connector;
    private String query;

    /**Метод для нахождения пользователя по его ID.*/
    @Override
    public User findById(int id) {
        connector = new RepositoryConnector();
        query = "SELECT * FROM user WHERE userid =" + id;
        User user = new User();

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt((1)));
                user.setName(resultSet.getString((2)));
                user.setSurname(resultSet.getString((3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }

        return user;
    }
    /**Метод для нахождения всех пользователей в БД.*/
    @Override
    public List<User> findAll() {
        RepositoryConnector connector = new RepositoryConnector();
        String query = "SELECT * FROM user";
        List<User> users = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt((1)));
                user.setName(resultSet.getString((2)));
                user.setSurname(resultSet.getString((3)));
                users.add(user);
            }
        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
