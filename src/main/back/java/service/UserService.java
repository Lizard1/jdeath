package service;

import model.User;

import java.util.List;

/**
 * Интерфейс представляющий методы для сервиса.
 * @autor Сергей Зверев
 * @version 1.1
 */

public interface UserService {
    User findById(int id);
    List<User> findAll();
}
