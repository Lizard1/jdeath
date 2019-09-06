package service.impl;

import repository.RepositoryConnector;
import model.Account;
import service.AccountService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс-сервис отвечающий за работу с БД, относительно класса Account.
 * @autor Сергей Зверев
 * @version 1.1
 */

public class AccountImpl implements AccountService {
    private RepositoryConnector connector;
    private String query;

    /** Метод для нахождения аккаунта по его ID.*/
    @Override
    public Account findById(int id) {
        Account account = new Account();
        connector = new RepositoryConnector();
        query = "SELECT * FROM account WHERE userid =" + id;

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                account.setAccountNumber(resultSet.getInt(2));
                account.setUserId(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return account;
    }

    /**Метод для нахождения всех аккаунтов в БД.*/
    @Override
    public List<Account> findAll() {
        connector = new RepositoryConnector();
        query = "SELECT * FROM account";
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();
                account.setUserId(resultSet.getInt(1));
                account.setAccountNumber(resultSet.getInt(2));
                account.setUserId(resultSet.getInt(3));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return accounts;
    }
}
