package service;

import model.Account;

import java.util.List;

/**
 * Интерфейс представляющий методы для сервиса.
 * @autor Сергей Зверев
 * @version 1.1
 */

public interface AccountService {
    Account findById(int id);
    List<Account> findAll();
}
